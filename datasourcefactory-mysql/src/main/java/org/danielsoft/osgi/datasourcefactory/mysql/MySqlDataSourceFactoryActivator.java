package org.danielsoft.osgi.datasourcefactory.mysql;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.jdbc.DataSourceFactory;

public class MySqlDataSourceFactoryActivator implements BundleActivator {

	public void start(BundleContext context) throws Exception {
		Hashtable<String, String> props = new Hashtable<String, String>();
		MySqlDataSourceFactory factory = new MySqlDataSourceFactory();
		
		props.put(DataSourceFactory.OSGI_JDBC_DRIVER_CLASS, "com.mysql.jdbc.Driver");
		props.put(DataSourceFactory.OSGI_JDBC_DRIVER_VERSION, "5.1.19"); // sync with mysql/connectorj version?
		props.put(DataSourceFactory.OSGI_JDBC_DRIVER_NAME, "com.mysql.jdbc.Driver");
        context.registerService(DataSourceFactory.class.getName(), factory, props);
	}
	
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
