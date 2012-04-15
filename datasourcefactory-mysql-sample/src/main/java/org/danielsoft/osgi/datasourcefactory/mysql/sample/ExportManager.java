package org.danielsoft.osgi.datasourcefactory.mysql.sample;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class ExportManager {

	private DataSource dataSource;

	public ExportManager(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void exportTableDataToCsv(String table, PrintStream out) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(String
					.format("SELECT * FROM %s", table));
			int columnCount = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					out.print(rs.getString(i));
					if (i < columnCount) {
						out.print(", ");
					}
				}
				out.println();
			}
		} catch (SQLException e) {
			throw new RuntimeException(String.format(
					"Error while exporting data from table %s", table), e);
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// IGNORE
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// IGNORE
				}
			}
		}

	}

}
