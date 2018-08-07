
package com.huoli.checkin.framework.mvc;

import javax.sql.DataSource;

/**
 * 数据源工厂
 * 
 * @author liaohao
 * @since 1.6
 *
 */
public interface DataSourceFactory {
	
	DataSource getDataSource();

}
