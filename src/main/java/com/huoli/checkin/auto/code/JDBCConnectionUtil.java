package com.huoli.checkin.auto.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JDBC连接工具类<br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月21日<br>
 */
public class JDBCConnectionUtil {
    private static Logger logger = LoggerFactory.getLogger(JDBCConnectionUtil.class);

    /**
     * 获取自定义的数据库连接
     *
     * @param driver
     * @param url
     * @param username
     * @param password
     * @return
     */
    public static Connection getCustomizedConnection(String driver, String url, String username, String password) {
        Connection conn = null;
        try {
            // 不需要加载Driver. Servlet 2.4规范开始容器会自动载入
            Class.forName(driver);
            Properties properties = new Properties();
            properties.put("user", username);
            properties.put("password", password);
            // !!! Oracle 如果想要获取元数据 REMARKS 信息,需要加此参数
            properties.put("remarksReporting", "true");
            // !!! MySQL 标志位, 获取TABLE元数据 REMARKS 信息
            properties.put("useInformationSchema", "true");
            conn = DriverManager.getConnection(url, properties);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取数据库链接异常", e);
        }
        return conn;
    }

    public static Connection getConnection(String type) {
        if (StringUtils.equals("oracle", type)) {
            return getDefaultOracleJdbcConnection();
        }
        return getDefaultMysqlJdbcConnection();
    }

    public static Connection getDefaultMysqlJdbcConnection() {
        return getCustomizedConnection("com.mysql.jdbc.Driver", "jdbc:mysql://101.200.123.157:3306/booking?useUnicode=true&characterEncoding=UTF-8", "checkin", "querycek0602");
    }

    public static Connection getDefaultOracleJdbcConnection() {
        return getCustomizedConnection("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@101.200.123.157:1521:ora9i", "et", "et001");
    }
    
    public static Connection getProductOracleJdbcConnection() {
        return getCustomizedConnection("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@120.133.0.161:1521:ora9i", "flightdyn", "flight0515 ");
    }

}
