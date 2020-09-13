/**
 * 
 */
package com.sca.common.logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnection;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.logging.log4j.core.appender.db.jdbc.ConnectionSource;

/**
 * 
 * @author subhash
 *
 */
public class LoggerConnectionSource implements ConnectionSource {

	private DataSource dataSource;

	/**
	 * 
	 * @param url
	 * @param userName
	 * @param password
	 * @param validationQuery
	 */
	public LoggerConnectionSource(String url, String userName, String password, String validationQuery) {
		Properties properties = new Properties();
		properties.setProperty("user", userName);
		properties.setProperty("password", password);

		GenericObjectPool<PoolableConnection> pool = new GenericObjectPool<>();
		DriverManagerConnectionFactory cf = new DriverManagerConnectionFactory(url, properties);
		new PoolableConnectionFactory(cf, pool, null, validationQuery, 3, false, false,
				Connection.TRANSACTION_READ_COMMITTED);
		this.dataSource = new PoolingDataSource(pool);
	}

	/**
	 * 
	 */
	@Override
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	/**
	 * 
	 */
	@Override
	public State getState() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	@Override
	public boolean isStarted() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 
	 */
	@Override
	public boolean isStopped() {
		// TODO Auto-generated method stub
		return false;
	}

}
