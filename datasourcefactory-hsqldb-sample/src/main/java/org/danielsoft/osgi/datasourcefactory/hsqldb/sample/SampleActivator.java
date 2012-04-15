package org.danielsoft.osgi.datasourcefactory.hsqldb.sample;

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.jdbc.DataSourceFactory;

public class SampleActivator implements BundleActivator {


		private BundleContext bundleContext;

		public void start(BundleContext bundleContext) throws Exception {
			this.bundleContext = bundleContext;

			DataSourceFactory dsFactory = getMysqlDataSourceFactory();

			Properties properties = new Properties();
			properties.put(DataSourceFactory.JDBC_URL, "jdbc:hsqldb:mem:mydatabase");
			properties.put(DataSourceFactory.JDBC_USER, "SA");
			properties.put(DataSourceFactory.JDBC_PASSWORD, "");

			DataSource dataSource = dsFactory.createDataSource(properties);
			
			Connection connection = dataSource.getConnection();
			System.out.println("connection: " + connection);
		}

		public void stop(BundleContext context) throws Exception {
			// DO NOTHING
		}

		private String getMysqlDataSourceFactoryFilter() {
			return "(" + DataSourceFactory.OSGI_JDBC_DRIVER_CLASS
					+ "=org.hsqldb.jdbc.JDBCDriver)";
		}

		private DataSourceFactory getMysqlDataSourceFactory() throws Exception {
			ServiceReference[] serviceReferences = bundleContext
					.getServiceReferences(DataSourceFactory.class.getName(),
							getMysqlDataSourceFactoryFilter());
			return serviceReferences != null ? (DataSourceFactory) bundleContext
					.getService(serviceReferences[0]) : null;
		}
	}

