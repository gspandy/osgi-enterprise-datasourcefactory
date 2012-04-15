package org.danielsoft.osgi.datasourcefactory.hsqldb;

import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import javax.sql.XADataSource;

import org.hsqldb.jdbc.JDBCDataSource;
import org.osgi.service.jdbc.DataSourceFactory;

public class HsqldbDataSourceFactory implements DataSourceFactory {

	public DataSource createDataSource(Properties props) throws SQLException {
		JDBCDataSource dataSource = new JDBCDataSource();
		dataSource.setUrl(props.getProperty(DataSourceFactory.JDBC_URL));
		dataSource.setUser(props.getProperty(DataSourceFactory.JDBC_USER));
		dataSource.setPassword(props.getProperty(DataSourceFactory.JDBC_PASSWORD));
		return dataSource;
	}

	public ConnectionPoolDataSource createConnectionPoolDataSource(
			Properties props) throws SQLException {
		throw new IllegalStateException("Not implemented yet");
	}

	public XADataSource createXADataSource(Properties props)
			throws SQLException {
		throw new IllegalStateException("Not implemented yet");
	}

	public Driver createDriver(Properties props) throws SQLException {
		throw new IllegalStateException("Not implemented yet");
	}

}
