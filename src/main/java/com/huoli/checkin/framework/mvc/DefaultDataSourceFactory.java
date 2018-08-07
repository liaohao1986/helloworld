//package com.huoli.checkin.framework.mvc;
//
//import org.apache.commons.dbcp.BasicDataSource;
//
///**
// * 描述: 默认的数据源工厂类<br>
// * 版权：Copyright (c) 2011-2017<br>
// * 公司：北京活力天汇<br>
// * 版本：1.0<br>
// * 作者：廖浩<br>
// * 创建日期：2017年8月26日<br>
// */
//public class DefaultDataSourceFactory extends AbstractDataSourceFactory<BasicDataSource> {
//
//    @Override
//    public BasicDataSource createDataSource() {
//        return new BasicDataSource();
//    }
//
//    @Override
//    public void setDriver(BasicDataSource ds, String driver) {
//        ds.setDriverClassName(driver);
//    }
//
//    @Override
//    public void setUrl(BasicDataSource ds, String url) {
//        ds.setUrl(url);
//    }
//
//    @Override
//    public void setUsername(BasicDataSource ds, String username) {
//        ds.setUsername(username);
//    }
//
//    @Override
//    public void setPassword(BasicDataSource ds, String password) {
//        ds.setPassword(password);
//    }
//
//    @Override
//    public void setAdvancedConfig(BasicDataSource ds) {
//        // 解决 java.sql.SQLException: Already closed. 的问题（连接池会自动关闭长时间没有使用的连接）
//        ds.setValidationQuery("select 1 from dual");
//    }
//
//}
