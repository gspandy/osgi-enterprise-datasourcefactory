This project provides modularized distributions of JDBC drivers suitable for running in OSGi.
It exports a DataSourceFactory as an OSGi Service so that client applications of the JDBC driver
can import and access the features of the driver without having to package the driver as part of the application.