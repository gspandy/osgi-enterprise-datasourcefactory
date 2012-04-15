package org.danielsoft.osgi.datasourcefactory.mysql;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.jdbc.DataSourceFactory;

public class MySqlDataSourceFactoryActivator implements BundleActivator {

	public static final String JDBC_DRIVER_CLASS = "com.mysql.jdbc.Driver";
	public static final String JDBC_DRIVER_VERSION = "5.1.19";
	public static final String JDBC_DRIVER_NAME = "com.mysql.jdbc.Driver";

	public void start(BundleContext bundleContext) throws Exception {
		Hashtable<String, String> props = new Hashtable<String, String>();
		MySqlDataSourceFactory factory = new MySqlDataSourceFactory();

		props.put(DataSourceFactory.OSGI_JDBC_DRIVER_CLASS, JDBC_DRIVER_CLASS);
		props.put(DataSourceFactory.OSGI_JDBC_DRIVER_VERSION, JDBC_DRIVER_VERSION);
		props.put(DataSourceFactory.OSGI_JDBC_DRIVER_NAME, JDBC_DRIVER_NAME);

		bundleContext.registerService(DataSourceFactory.class.getName(), factory, props);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		// DO NOTHING HERE
	}

}
