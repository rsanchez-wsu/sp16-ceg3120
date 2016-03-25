/*
 * Copyright (C) 2016
 * 
 * 
 * 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package edu.wright.cs.sp16.ceg3120.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author Rhys
 * 
 *         MySqlConnect is a class to run basic connection to MySQL test
 *         database. This class is capable of receiving a database address, user
 *         name, password, and database name of a MySQL server. Currently, it
 *         will iterate over the designated database and return its table
 *         values.
 */

public class MySqlConnect extends DatabaseConnector {

	private String dbAddress;
	private String dbUsername;
	private String dbPassword;
	private String dbName;
	private com.mysql.jdbc.jdbc2.optional.MysqlDataSource dataSource = 
			new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();

	/**
	 * MySqlConnect is just a place holder constructor.
	 */
	public MySqlConnect() {

	}

	/**
	 * MySqlConnect is the default constructor that the MySqlConnect class has.
	 * After this is done, call the configure method to set up the database
	 * connection.
	 * 
	 * 
	 * @param dbAddress
	 *            database address without port (uses default MySQL port = 3306)
	 *            Capitalization does not matter, IP address or domain names are
	 *            accepted.
	 * @param dbUsername
	 *            Database user name: not case sensitive, needs to be created in
	 *            the database before use here.
	 * @param dbPassword
	 *            Database password: is case sensitive, will be verified against
	 *            the database.
	 * @param dbName
	 *            Database name: Not case sensitive, will not connect if the
	 *            database name does not exist.
	 * 
	 */
	public MySqlConnect(String dbAddress, String dbUsername, String dbPassword, String dbName) {
		setDbAddress(dbAddress);
		setDbUsername(dbUsername);
		setDbPassword(dbPassword);
		setDbName(dbName);
	}

	/**
	 * This constructor sets up the database connection.
	 * 
	 * @throws SQLException
	 *             when a SQL connection can't be made.
	 */
	public void configure() throws SQLException {
		dataSource.setUser(getDbUsername());
		dataSource.setPassword(getDbPassword());
		dataSource.setServerName(getDbAddress());
		dataSource.setDatabaseName(getDbName());
	}

	/**
	 * This function accepts a String variable that is a SQL query, executes the
	 * query, iterates through the resulting data, and concatenates a string of
	 * the results from the query. It should be noted that FindBugs flagged this
	 * approach as unsafe and required a Suppression on the warning. We want to
	 * be able to execute arbitrary code, so there is no need to protect against
	 * SQL injection.
	 * 
	 * @return String variable containing the results of the query executed.
	 * @throws SQLException
	 *             when there is an issue connection to the database.
	 */
	@edu.umd.cs.findbugs.annotations.SuppressFBWarnings(value = 
			"SQL_NONCONSTANT_STRING_PASSED_TO_EXECUTE", justification = 
			"We specifically want to allow the user to execute arbitrary SQL")
	public String[][] executeQuery(String stringQuery) throws SQLException {
		//JTable t1 = new JTable();
		String[][] resultTable = null;  // create the array to return
		// try to create the connection and resultset
		try (Connection conn = dataSource.getConnection();
				Statement inputStatement = conn.createStatement();
				ResultSet rs = inputStatement.executeQuery(stringQuery);) {
			// ResultSetMetaData does not implement AutoClosable() so it
			// cannot be handled by try-with-resources.
			ResultSetMetaData rsmd = null;
			// Get the information required to make th array
			rsmd = rs.getMetaData();
			// this part of code gets how many rows there are
			rs.last(); // moves the resultset cursor to the last row
			int numRows = rs.getRow(); //sets the number of rows to the last row
			rs.beforeFirst(); // moves the cursor to the beginning
			//initialize the array with the [rows][columns]
			resultTable = new String[numRows][rsmd.getColumnCount()];
			// Iterate through all data returned and put it into a string array
			// test to see if it does not get ot of index with i < numRows
			// and that there is more data to grab with rs.next()
			// first for loop is for rows
			for (int i = 0; i < numRows && rs.next(); i++) {
				// second for loop columns
				for (int j = 0; j < rsmd.getColumnCount(); j++) {
					// the resultset data starts at index of 1 so that's why there
					// is an offset to get the string.
					resultTable[i][j] = rs.getString(j + 1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// return resultTable the 2d array
		return resultTable;
	}

	
	/**
	 * This method returns a populated JTable element that is filled with data
	 * from a SQL Query.
	 * 
	 * @param query
	 *            String Format of the table to convert.
	 * 
	 * @return Populated JTAble element from the SQL query.
	 */
	@edu.umd.cs.findbugs.annotations.SuppressFBWarnings(value = 
			"SQL_NONCONSTANT_STRING_PASSED_TO_EXECUTE", justification = 
			"We specifically want to allow the user to execute arbitrary SQL")
	public JTable getTable(String query) {
		JTable tableOne = new JTable();
		DefaultTableModel dtm = new DefaultTableModel();
		try (Connection conn = dataSource.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);) {
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			String[] col = new String[cols];
			for (int i = 0; i < cols; i++) {
				col[i] = rsmd.getColumnName(i + 1);
				dtm.addColumn(col[i]);
			}

			Object[] row = new Object[cols];
			while (rs.next()) {
				for (int i = 0; i < cols; i++) {
					row[i] = rs.getString(i + 1);
				}
				dtm.addRow(row);
			}
			tableOne.setModel(dtm);
			return tableOne;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tableOne;
	}

	/**
	 * Constructor returns the database address as data type String. Null if no
	 * address entered already.
	 * 
	 * @return string
	 */
	public String getDbAddress() {
		return dbAddress;
	}

	/**
	 * Constructor receives a string that is an address of a MySQL database
	 * without the port. Default port of 3306 is used in the underlying code.
	 * 
	 * @param dbAddress
	 *            database address
	 */
	public void setDbAddress(String dbAddress) {
		this.dbAddress = dbAddress;
	}

	/**
	 * Constructor returns the set user name for the database as type String.
	 * Null if no user name entered already.
	 * 
	 * @return string
	 */
	public String getDbUsername() {
		return dbUsername;
	}

	/**
	 * Constructor sets the user name for the database. Receives a String value,
	 * is not case sensitive.
	 * 
	 * @param dbUsername
	 *            database username
	 */
	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	/**
	 * Constructor returns the set password as a String. If there is no password
	 * set, the constructor returns NULL.
	 * 
	 * @return string
	 */
	public String getDbPassword() {
		return dbPassword;
	}

	/**
	 * Sets the database password as a String value. It is case sensitive, and
	 * is verified against the database.
	 * 
	 * @param dbPassword
	 *            database password
	 */
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	/**
	 * Constructor returns a database name, if there is no name set it returns
	 * NULL.
	 * 
	 * @return string
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * Constructor sets the database name. Receives a String variable and is not
	 * case sensitive.
	 * 
	 * @param dbName
	 *            database name
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
}
