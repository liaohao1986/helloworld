package com.huoli.checkin.framework.mvc;

import java.beans.PropertyVetoException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 描述: 默认的数据源工厂类<br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年8月26日<br>
 */
public class C3P0DataSourceFactory extends AbstractDataSourceFactory<ComboPooledDataSource> {

    @Override
    public ComboPooledDataSource createDataSource() {
        return new ComboPooledDataSource();
    }

    @Override
    public void setDriver(ComboPooledDataSource ds, String driver) {
        try {
            ds.setDriverClass(driver);
        } catch (PropertyVetoException e) {
        }
    }

    @Override
    public void setUrl(ComboPooledDataSource ds, String url) {
        ds.setJdbcUrl(url);
    }

    @Override
    public void setUsername(ComboPooledDataSource ds, String username) {
        ds.setUser(username);
    }

    @Override
    public void setPassword(ComboPooledDataSource ds, String password) {
        ds.setPassword(password);
    }

    @Override
    public void setAdvancedConfig(ComboPooledDataSource ds) {
        throw new UnsupportedOperationException();
    }

}
