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

package testconnection;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author AlisonGuyton.
 *
 */
public class DbConnection {
	private Connection conn = null;
	private String url;
	private String dbType = "";
	private String connString = "";
	//private String username = "";
	//private String password = "";
	private boolean isConnected;

	/**
	 * Default constructor for a DBconnection.
	 */
	public DbConnection() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		//path may vary per user because it is an Embedded Driver
		url = "jdbc:derby:/Users/AlisonGuyton/.ivy2/cache/org.apache.derby/derby/jars/newDB;"
				+ "create=true";

		System.out.println("Created SQL Connect");
	}
	
	/**
	 * Constructor for a Database connection.
	 * @param url The url location of the DB
	 * @param dbType The DB type eg. derby
	 * @param user The username
	 * @param pass The password for the user
	 */
	public DbConnection(String url, String dbType, String user, String pass) {
		//TODO: Create connection with passed arguments
		this.url = url;
		this.dbType = dbType;
		//this.username = user;
		//this.password = pass;
		connString = "jdbc:" + this.dbType + ":" + this.url;

		createConnection();
	}

	/**
	 * CreateConnection creates a connection.
	 */
	public void createConnection() {
		try {
			conn = DriverManager.getConnection(connString);
			isConnected = true;
			System.out.println("Successfully Connected");
		} catch (SQLException e) {
			isConnected = false;
			System.out.println(e.toString() + "\nexception thrown");
		}
	}

	/**
	 * closeConnection closes the established connection to a derby database.
	 */
	public void closeConnection() {
		try {
			this.conn.close();	
			System.out.println("Connection successfully closed");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	/**
	 * returns the name of the connected database.
	 * @return The name of the DB
	 */
	public String getDbName() {
		String fileName;
		try {
			fileName = new File(url).getName();
		} catch (Exception exc) {
			fileName = "";
		}
		return fileName;
	}
	
	/**
	 * Returns the connection status.
	 * @return isConnected The status of the connection
	 */
	public boolean isConnected() {
		return isConnected;
	}
	
	/**
	 * Returns the Connection.
	 * @return the Connection
	 */
	public Connection getConnection() {
		return conn;
	}
}
