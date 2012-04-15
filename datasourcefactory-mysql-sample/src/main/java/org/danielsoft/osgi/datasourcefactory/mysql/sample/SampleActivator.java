package org.danielsoft.osgi.datasourcefactory.mysql.sample;

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
		properties.put(DataSourceFactory.JDBC_URL, "jdbc:mysql://localhost:3306/mysql");
		properties.put(DataSourceFactory.JDBC_USER, "root");
		properties.put(DataSourceFactory.JDBC_PASSWORD, "");

		DataSource dataSource = dsFactory.createDataSource(properties);

		ExportManager exportManager = new ExportManager(dataSource);
		exportManager.exportTableDataToCsv("help_category", System.out);

	}

	public void stop(BundleContext context) throws Exception {
		// DO NOTHING
	}

	private String getMysqlDataSourceFactoryFilter() {
		return "(" + DataSourceFactory.OSGI_JDBC_DRIVER_CLASS
				+ "=com.mysql.jdbc.Driver)";
	}

	private DataSourceFactory getMysqlDataSourceFactory() throws Exception {
		ServiceReference[] serviceReferences = bundleContext
				.getServiceReferences(DataSourceFactory.class.getName(),
						getMysqlDataSourceFactoryFilter());
		return serviceReferences != null ? (DataSourceFactory) bundleContext
				.getService(serviceReferences[0]) : null;
	}
}
