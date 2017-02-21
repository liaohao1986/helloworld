package com.huoli.checkin.auto.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.codec.binary.StringUtils;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月21日<br>
 */
public class JdbcConnectionUtil {

    public static Connection getConnection(String driver, String url, String username, String password) {
        Connection conn = null;
        try {
            // 不需要加载Driver. Servlet 2.4规范开始容器会自动载入
            Class.forName(driver);
            Properties info = new Properties();
            //
            info.put("user", username);
            info.put("password", password);
            // !!! Oracle 如果想要获取元数据 REMARKS 信息,需要加此参数
            info.put("remarksReporting", "true");
            // !!! MySQL 标志位, 获取TABLE元数据 REMARKS 信息
            info.put("useInformationSchema", "true");
            // 不知道SQLServer需不需要设置...
            //
            conn = DriverManager.getConnection(url, info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection getConnection(String type) {
        if (StringUtils.equals("oracle", type)) {
            return getOracleJdbcConnection();
        }
        return getMysqlJdbcConnection();
    }

    public static Connection getMysqlJdbcConnection() {
        try {//驱动注册
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://202.103.25.41:3306/checkin?useUnicode=true&characterEncoding=UTF-8", "root", "zencat");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Connection getOracleJdbcConnection() {
        try {//驱动注册
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //            Properties 
            Properties props = new Properties();
            props.put("user", "et");
            props.put("password", "et001");
            // !!! Oracle 如果想要获取元数据 REMARKS 信息,需要加此参数
            props.put("remarksReporting", "true");
            // !!! MySQL 标志位, 获取TABLE元数据 REMARKS 信息
            props.put("useInformationSchema", "true");
            // 不知道SQLServer需不需要设置...
            return DriverManager.getConnection("jdbc:oracle:thin:@202.103.25.41:1521:ora9i", props);
            //            return DriverManager.getConnection("jdbc:oracle:thin:@202.103.25.41:1521:ora9i", "et", "et001");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
