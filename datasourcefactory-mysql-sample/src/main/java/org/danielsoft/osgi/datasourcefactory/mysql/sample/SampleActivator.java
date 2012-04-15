package org.danielsoft.osgi.datasourcefactory.mysql.sample;

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.jdbc.DataSourceFactory;

public class SampleActivator implements BundleActivator {

	public void start(BundleContext bundleContext) throws Exception {
		String filter = String.format("(%s=%s)",
				DataSourceFactory.OSGI_JDBC_DRIVER_CLASS,
				"com.mysql.jdbc.Driver");
		ServiceReference[] serviceReferences = bundleContext.getServiceReferences(DataSourceFactory.class.getName(),
				filter);
		if (serviceReferences != null) {
			DataSourceFactory dsFactory = (DataSourceFactory) bundleContext.getService(serviceReferences[0]);
			System.out.println("dsFactory: " + dsFactory);
			
			Properties properties = new Properties();
			properties.put(DataSourceFactory.JDBC_URL, "jdbc:mysql://localhost:3306/mysql");
			properties.put(DataSourceFactory.JDBC_USER, "root");
			properties.put(DataSourceFactory.JDBC_PASSWORD, "");
			
			DataSource dataSource = dsFactory.createDataSource(properties);
			System.out.println("datasource: " + dataSource);
			
			Connection connection = dataSource.getConnection();
			System.out.println("connection = " + connection);
		}
	}

	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}
}
