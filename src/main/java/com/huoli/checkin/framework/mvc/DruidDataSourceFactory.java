package com.huoli.checkin.framework.mvc;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 描述: 默认的数据源工厂类<br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年8月26日<br>
 */
public class DruidDataSourceFactory extends AbstractDataSourceFactory<DruidDataSource> {

    @Override
    public DruidDataSource createDataSource() {
        return new DruidDataSource();
    }

    @Override
    public void setDriver(DruidDataSource ds, String driver) {
        ds.setDriverClassName(driver);
    }

    @Override
    public void setUrl(DruidDataSource ds, String url) {
        ds.setUrl(url);
    }

    @Override
    public void setUsername(DruidDataSource ds, String username) {
        ds.setUsername(username);
    }

    @Override
    public void setPassword(DruidDataSource ds, String password) {
        ds.setPassword(password);
    }

    @Override
    public void setAdvancedConfig(DruidDataSource ds) {
        // 解决 java.sql.SQLException: Already closed. 的问题（连接池会自动关闭长时间没有使用的连接）
        ds.setValidationQuery("select 1 from dual");
    }

}
