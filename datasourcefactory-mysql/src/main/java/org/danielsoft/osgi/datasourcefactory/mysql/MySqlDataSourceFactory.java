package org.danielsoft.osgi.datasourcefactory.mysql;

import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import javax.sql.XADataSource;

import org.osgi.service.jdbc.DataSourceFactory;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MySqlDataSourceFactory implements DataSourceFactory {

	public DataSource createDataSource(Properties props) throws SQLException {
		MysqlDataSource ds = new MysqlDataSource();
		ds.setURL(props.getProperty(DataSourceFactory.JDBC_URL));
		ds.setUser(props.getProperty(DataSourceFactory.JDBC_USER));
		ds.setPassword(props.getProperty(DataSourceFactory.JDBC_PASSWORD));
		return ds;
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
