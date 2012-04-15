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
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setURL(props.getProperty(DataSourceFactory.JDBC_URL));
		dataSource.setUser(props.getProperty(DataSourceFactory.JDBC_USER));
		dataSource.setPassword(props.getProperty(DataSourceFactory.JDBC_PASSWORD));
		return dataSource;
	}

	public ConnectionPoolDataSource createConnectionPoolDataSource(
			Properties props) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public XADataSource createXADataSource(Properties props)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Driver createDriver(Properties props) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
