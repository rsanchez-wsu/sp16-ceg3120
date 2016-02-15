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

package edu.wright.cs.sp16.ceg3120;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.Statement;

/**
 * This will create a derby database to connect to within the application.
 * 
 * @author Bonnie
 *
 */
public class DerbyConnect {

	private String dbName;
	private String dbUrl = "jdbc:derby://localhost:1527/testDB;create=true;"
			+ "user=admin;password=";
	private Connection conn = null;
//	private Statement stmt = null;

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
	public void createConnection() {
		// Still working on creating the connection.
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			conn = DriverManager.getConnection(dbUrl);
//			stmt.close();
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

}
