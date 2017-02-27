package com.huoli.checkin.auto.code;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.jsoup.helper.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huoli.utils.DateTimeUtil;

/**
 * 数据库自动转换JAVA类 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月27日<br>
 */
public class DB2JavaConvertor {
    private static Logger logger = LoggerFactory.getLogger(DB2JavaConvertor.class);
    private Connection connection;
    //数据库中的表名
    //oracle: FLY_BOARD_CARD airport_inter_info 
    //mysql: checkin_condition2 AIRLINE_WEB_LOGIN
    //特别注意:由于getColumns大小写敏感，所以一定要写数据库实际的表名称
    private final static String tableName = "AIRLINES_NORMAL";
    // mysql oracle
    private final static String sqlType = "oracle";
    //数据库的列名称
    private List<String> columnNameList;
    //列名类型数组  
    private List<String> typeNameList;
    //备注说明数组  
    private List<String> commentList;
    //用户去重的列map
    private Map<String, String> duplicateColumnMap = new ConcurrentHashMap<String, String>();
    private static boolean isContainDateField = false;

    public DB2JavaConvertor() {
        connection = JDBCConnectionUtil.getConnection(sqlType);
        initTableColumnMetaData(tableName);
    }

    private void initColumnMetaDataCollection(int rowSize) {
        columnNameList = new ArrayList<String>(rowSize);
        typeNameList = new ArrayList<String>(rowSize);
        commentList = new ArrayList<String>(rowSize);
    }

    /**
     * 初始化列表元数据
     *
     */
    private void initTableColumnMetaData(String tableName) {
        try {
            //获取数据库的元数据 
            DatabaseMetaData metaData = connection.getMetaData();
            //特别注意:由于getColumns大小写敏感，所以一定要写数据库实际的表名称
            ResultSet rs = metaData.getColumns(null, "%", tableName, "%");
            initColumnMetaDataCollection(rs.getRow());
            while (rs.next()) {
                String columnName = rs.getString("COLUMN_NAME"); //视图名
                if (duplicateColumnMap.get(columnName) != null) {
                    continue;
                }
                String typeName = rs.getString("TYPE_NAME"); //视图类型
                String remarks = rs.getString("REMARKS"); //视图备注
                columnNameList.add(columnName.toLowerCase());
                typeNameList.add(getFieldType(typeName));
                commentList.add(remarks);
                duplicateColumnMap.put(columnName, typeName);
            }
        } catch (SQLException e) {
            logger.error("初始化表列表元数据异常", e);
        }
    }

    /*
     * mysql的字段类型转化为java的类型*/
    private String getFieldType(String sqlType) {
        if (sqlType.equalsIgnoreCase("bit")) {
            return "boolean";
        } else if (sqlType.equalsIgnoreCase("tinyint") || sqlType.equalsIgnoreCase("smallint") || sqlType.equalsIgnoreCase("integer") || sqlType.equalsIgnoreCase("int")
                   || sqlType.equalsIgnoreCase("int unsigned")) {
            return "Integer";
        } else if (sqlType.equalsIgnoreCase("bigint")) {
            return "Long";
        } else if (sqlType.equalsIgnoreCase("float")) {
            return "Float";
        } else if (sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric") || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")
                   || sqlType.equalsIgnoreCase("smallmoney")) {
            return "Double";
        } else if (sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char") || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
                   || sqlType.equalsIgnoreCase("text")) {
            return "String";
        } else if (sqlType.equalsIgnoreCase("varchar2")) {
            return "String";
        } else if (sqlType.equalsIgnoreCase("datetime") || sqlType.equalsIgnoreCase("date") || sqlType.equalsIgnoreCase("TIMESTAMP")) {
            isContainDateField = true;
            return "Date";
        }
        return "String";
    }

    /*
     * mysql的字段类型转化为java的类型*/
    private String getMethodType(String fieldType) {
        String rsGetMethod = "";
        if ("Integer".equalsIgnoreCase(fieldType)) {
            rsGetMethod = "Int";
        }
        if ("Long".equalsIgnoreCase(fieldType)) {
            rsGetMethod = "Long";
        }
        if ("String".equalsIgnoreCase(fieldType)) {
            rsGetMethod = "String";
        }
        if ("Date".equalsIgnoreCase(fieldType)) {
            rsGetMethod = "Timestamp";
        }
        if ("Double".equalsIgnoreCase(fieldType)) {
            rsGetMethod = "Double";
        }
        return rsGetMethod;
    }

    /*获取整个类的字符串并且输出为java文件
     * */
    public StringBuilder generateJavaObject() {
        //输出的类字符串
        StringBuilder entityBuilder = new StringBuilder("");
        //校验
        if (columnNameList.size() == 0 || typeNameList.size() == 0) {
            return null;
        }
        entityBuilder.append(this.getClass().getPackage() + ";\r\n\r\n");
        if (isContainDateField) {
            entityBuilder.append("import java.util.Date;\r\n\r\n");
        }
        entityBuilder.append("import org.apache.commons.lang3.builder.ToStringBuilder;\n");
        entityBuilder.append("import org.apache.commons.lang3.builder.ToStringStyle;\n");
        //填充Java文件头部注释
        fillJavaHeadComment(entityBuilder);
        //拼接
        String className = tableName.toLowerCase().substring(0, 1).toUpperCase() + tableName.toLowerCase().substring(1);
        className = getClassOrFieldName(className, 0);
        entityBuilder.append("public class " + className + " {\r\n");
        //拼接属性
        for (int index = 0; index < columnNameList.size(); index++) {
            String fieldComment = getFieldComment(commentList.get(index));
            // 如果数据库注释不为NULL，则添加字段注释
            if (StringUtils.isNotBlank(fieldComment)) {
                entityBuilder.append(getFieldComment(commentList.get(index)));
            }
            entityBuilder.append(getAttrbuteString(getClassOrFieldName(columnNameList.get(index), 1), typeNameList.get(index)));
        }
        entityBuilder.append("\r\n");
        //拼接get，Set方法       
        for (int index = 0; index < columnNameList.size(); index++) {
            entityBuilder.append(getGetMethodString(getClassOrFieldName(columnNameList.get(index), 1), typeNameList.get(index)));
            entityBuilder.append(getSetMethodString(getClassOrFieldName(columnNameList.get(index), 1), typeNameList.get(index)));
        }
        entityBuilder.append("\n");
        entityBuilder.append("    @Override\n");
        entityBuilder.append("    public String toString() {\n");
        entityBuilder.append("          return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);\n");
        entityBuilder.append("    }\n");
        entityBuilder.append("}\r\n");
        //输出到文件中
        String packageName = DB2JavaConvertor.class.getPackage().getName().replace(".", "\\");
        String s2 = "src" + File.separator + "main" + File.separator + "java" + File.separator + packageName;
        String absolutePath = System.getProperty("user.dir") + File.separator + s2;
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            FileUtils.writeStringToFile(new File(absolutePath + File.separator + className + ".java"), entityBuilder.toString(), "utf-8");
        } catch (IOException e) {
            logger.error("EXCEPTION", e);
        }
        return entityBuilder;
    }

    /*获取整个类的字符串并且输出为java文件
     * */
    public StringBuilder generateDao() {
        //输出的类字符串
        StringBuilder daoBuilder = new StringBuilder("");
        //校验
        if (columnNameList.size() == 0 || typeNameList.size() == 0) {
            return null;
        }
        daoBuilder.append(this.getClass().getPackage() + ";\r\n\r\n");
        daoBuilder.append("import java.sql.ResultSet;\n");
        daoBuilder.append("import java.sql.SQLException;\n");
        daoBuilder.append("import org.springframework.jdbc.core.RowMapper;\n");
        daoBuilder.append("import org.springframework.jdbc.core.support.JdbcDaoSupport;\n");
        //填充Java文件头部注释
        fillJavaHeadComment(daoBuilder);
        //拼接
        String lowerTable = tableName.toLowerCase();
        String className = lowerTable.substring(0, 1).toUpperCase() + lowerTable.substring(1);
        className = getClassOrFieldName(className, 0);
        String instanceName = className.substring(0, 1).toLowerCase() + className.substring(1);
        daoBuilder.append("public class ").append(className).append("Dao extends JdbcDaoSupport {\n");
        daoBuilder.append("\t/**行映射器*/\n");
        daoBuilder.append("\tprivate RowMapper <").append(className).append("> rowMapper = new RowMapper<").append(className).append(">() {\n");
        daoBuilder.append("\t\tpublic ").append(className).append(" mapRow(ResultSet rs, int rowNum) throws SQLException {\n");
        daoBuilder.append("            ").append(className).append(" ").append(instanceName).append(" = new ").append(className).append("();\r\n");
        //拼接属性
        for (int index = 0; index < columnNameList.size(); index++) {
            String columnName = columnNameList.get(index);
            String methodType = getMethodType(typeNameList.get(index));
            daoBuilder.append("            ").append(instanceName).append(".set").append(getClassOrFieldName(columnName, 0)).append("(rs.get").append(methodType).append("(\"")
                .append(columnName).append("\"));\r\n");
        }
        daoBuilder.append("\t\t\treturn ").append(instanceName).append(";\n");
        daoBuilder.append("\t\t}\n\t};\n}");
        //输出到文件中
        String packageName = DB2JavaConvertor.class.getPackage().getName().replace(".", "\\");
        String s2 = "src" + File.separator + "main" + File.separator + "java" + File.separator + packageName;
        String absolutePath = System.getProperty("user.dir") + File.separator + s2;
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            FileUtils.writeStringToFile(new File(absolutePath + File.separator + className + "Dao.java"), daoBuilder.toString(), "utf-8");
        } catch (IOException e) {
            logger.error("EXCEPTION", e);
        }
        return daoBuilder;
    }

    /**
     * 填充java文件头部注释信息
     *
     * @param builder
     */
    private void fillJavaHeadComment(StringBuilder builder) {
        builder.append("/**\n");
        builder.append(" * <br>\n");
        builder.append(" * 版权: Copyright (c) 2011-2017<br>\n");
        builder.append(" * 公司: 北京活力天汇<br>\n");
        builder.append(" * \n");
        builder.append(" * @author: 廖浩<br>\n");
        builder.append(" * @date: " + DateTimeUtil.format(DateTimeUtil.now(), "yyyy年MM月dd日") + "<br>\n");
        builder.append(" * generated by DB2JavaConvertor<br>\n");
        builder.append(" */\n");
    }

    private String getFieldComment(String comment) {
        if (StringUtil.isBlank(comment)) {
            return null;
        }
        comment = comment.replace("\n", "");
        return String.format("    /* %s */\n", comment);
    }

    /*
     * 获取字段字符串*/
    private String getAttrbuteString(String name, String type) {
        if (!check(name, type)) {
            System.out.println("类中有属性或者类型为空");
            return null;
        }
        return String.format("    private %s %s;\n", type, name);
    }

    /*
     * 校验name和type是否合法*/
    private boolean check(String name, String type) {
        if (StringUtils.isBlank(name) || StringUtils.isBlank(type)) {
            return false;
        }
        return true;
    }

    /*
     * 获取get方法字符串*/
    private String getGetMethodString(String fieldName, String fieldType) {
        if (!check(fieldName, fieldType)) {
            System.out.println("类中有属性或者类型为空");
            return null;
        }
        String getMethodName = "get" + getCamelName(fieldName);
        String getMethodString = String.format("    public %s %s(){\n        return this.%s;\n    }\n\r", fieldType, getMethodName, fieldName);
        return getMethodString;
    }

    /**
     * 将名称首字符大写
     *
     * @param name
     * @return
     */
    private String getCamelName(String name) {
        name = name.trim();
        if (name.length() > 1) {
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
        } else {
            name = name.toUpperCase();
        }
        return name;
    }

    /*
     * 获取字段的get方法字符串*/
    private Object getSetMethodString(String name, String type) {
        if (!check(name, type)) {
            System.out.println("类中有属性或者类型为空");
            return null;
        }
        String setMethodName = "set" + getCamelName(name);
        String setMethodString = String.format("    public void %s(%s %s){\n", setMethodName, type, name);
        setMethodString += String.format("        this.%s = %s;\n    }\n\r", name, name);
        return new StringBuffer(setMethodString);
    }

    /**
     * 按照驼峰命名法获取类名或者字段名称
     *
     * @param name 类名或者字段名
     * @param type(0:类名 1:字段)
     * @return
     */
    private static String getClassOrFieldName(String name, int type) {
        StringBuilder buffer = new StringBuilder("");
        for (int index = 0; index < name.length(); index++) {
            String charStr = name.substring(index, index + 1);
            if (index == 0 && type == 0) {
                charStr = charStr.toUpperCase();
            }
            if ("_".equals(charStr)) {
                charStr = name.substring((++index), index + 1).toUpperCase();
            }
            buffer.append(charStr);
        }
        return buffer.toString();
    }

    public static void main(String[] args) throws IOException {
        DB2JavaConvertor bean = new DB2JavaConvertor();
        System.err.println(bean.generateJavaObject());
        System.err.println(bean.generateDao());
    }

}
