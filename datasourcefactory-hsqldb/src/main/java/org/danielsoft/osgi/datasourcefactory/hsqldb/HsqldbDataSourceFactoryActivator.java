package org.danielsoft.osgi.datasourcefactory.hsqldb;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.jdbc.DataSourceFactory;

public class HsqldbDataSourceFactoryActivator implements BundleActivator {

	public static final String JDBC_DRIVER_CLASS = "org.hsqldb.jdbc.JDBCDriver";
	public static final String JDBC_DRIVER_VERSION = "2.2.8";
	public static final String JDBC_DRIVER_NAME = "org.hsqldb.jdbc.JDBCDriver";

	public void start(BundleContext bundleContext) throws Exception {
		Hashtable<String, String> props = new Hashtable<String, String>();
		HsqldbDataSourceFactory factory = new HsqldbDataSourceFactory();

		props.put(DataSourceFactory.OSGI_JDBC_DRIVER_CLASS, JDBC_DRIVER_CLASS);
		props.put(DataSourceFactory.OSGI_JDBC_DRIVER_VERSION, JDBC_DRIVER_VERSION);
		props.put(DataSourceFactory.OSGI_JDBC_DRIVER_NAME, JDBC_DRIVER_NAME);

		bundleContext.registerService(DataSourceFactory.class.getName(), factory, props);
	}
	
	public void stop(BundleContext bundleContext) throws Exception {
		
	};
}
