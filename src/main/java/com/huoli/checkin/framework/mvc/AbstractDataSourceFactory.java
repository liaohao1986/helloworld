/**
 * 
 */
package com.huoli.checkin.framework.mvc;

import javax.sql.DataSource;

/**
 * @author liaohao
 *
 */
public abstract class AbstractDataSourceFactory<T extends DataSource> implements DataSourceFactory {

    protected final String driver   = "";
    protected final String url      = "";
    protected final String username = "";
    protected final String password = "";

    /*
     * (non-Javadoc)
     * 
     * @see com.huoli.checkin.framework.mvc.DataSourceFactory#getDataSource()
     */
    @Override
    public T getDataSource() {
        T ds = createDataSource();
        setDriver(ds, driver);
        setUrl(ds, url);
        setUsername(ds, username);
        setPassword(ds, password);
        setAdvancedConfig(ds);
        return ds;
    }

    public abstract T createDataSource();

    public abstract void setDriver(T ds, String driver);

    public abstract void setUrl(T ds, String url);

    public abstract void setUsername(T ds, String username);

    public abstract void setPassword(T ds, String password);

    public abstract void setAdvancedConfig(T ds);
}
