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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;


/**
 * This will create a derby database to connect to within the application.
 * 
 * @author Bonnie
 *
 */
public class DerbyConnect  {

	private String dbName;
	private String dbUrl = "jdbc:derby://localhost:1527/testDB;create=true;"
			+ "user=admin;password=";
	private Connection conn = null;

	/**
	 * Default constructor.
	 */
	public DerbyConnect() {

	}

	/**
	 * this constructor is used to set the database address, username, password
	 * and the database name.
	 * @param dbName
	 *            - sets the database name.
	 */
	public DerbyConnect(String dbName) {
		setDbName(dbName);
	}

	/**
	 * This will create the connection for the derby database.
	 */
	public void configure() throws SQLException {
		// Still working on creating the connection.
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			conn = DriverManager.getConnection(dbUrl);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Sets the database name for the derby db.
	 * 
	 * @param dbName
	 *            - name of the database.
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	/**
	 * returns the database name used for the derby connection.
	 * 
	 * @return - returns a string of database name.
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * the method is to run derby commands in derby drivers and return the results of any command
	 * 
	 * @return String variable containing the results of the query executed.
	 * @throws Exception
	 *  */
	public DefaultTableModel executeQuery(String query) throws Exception {
		DefaultTableModel dtm = new DefaultTableModel();	
		Statement stmt = conn.createStatement();
		try {
			ResultSet rs = stmt.executeQuery(query); 
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			String[] col = new String[cols];
			for (int i = 0; i < cols; i++) {
				col[i] = rsmd.getColumnName(i + 1);
				dtm.addColumn(col[i]);
			}

			Object[] row = new Object[cols];
			while (rs.next()) {
				for (int jr = 0; jr < cols; jr++) {
					row[jr] = rs.getString(jr + 1);
				}
				dtm.addRow(row);
			}
			return dtm;
			
		} catch (SQLException e) {
			stmt.close();
			System.out.println(e.getMessage());

		} finally {
			stmt.close();
		}
		return dtm;
	}

}
