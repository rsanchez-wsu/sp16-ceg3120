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

/**
 * This will create a derby database to connect to within the application.
 * 
 * @author Bonnie 
 *
 */
public class DerbyConnect {
	
	private String dbAddress;
	private String dbUsername;
	private String dbPassword;
	private String dbName;
//	private String dbUrl = "jdbc:derby://localhost:1527/testDB;create=true;"
//			+ "user=bonnie;password=bonnie";
//	private Connection conn;
	
	/**
	 * Default constructor.
	 */
	public DerbyConnect(){
		
	}
	
	/**
	 * this constructor is used to set the database address, username,
	 * password and the database name. 
	 * @param dbAddress - sets the database address.
	 * @param dbUsername - sets the username used.
	 * @param dbPassword - sets the password for the username for the db.
	 * @param dbName - sets the database name.
	 */
	public DerbyConnect(String dbAddress, String dbUsername, 
						String dbPassword, String dbName) {
		setDbAddress(dbAddress);
		setDbUsername(dbUsername);
		setDbPassword(dbPassword);
		setDbName(dbName);
	}
	
	/**
	 * This will create the connection for the derby database.
	 */
//	public void createConnection() {
//		//Still working on creating the connection.
//		try {
//			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
//			conn = DriverManager.getConnection(dbUrl);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	/**
	 * Sets the database address name.
	 * @param dbAddress - address name of DB.
	 */
	public void setDbAddress(String dbAddress) { 
		this.dbAddress = dbAddress;
	}
	
	/**
	 * Sets the database username.
	 * @param dbUsername - username for the derby db.
	 */
	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}
	
	/**
	 * Sets the password for the derby database.
	 * @param dbPassword - password for the derby db.
	 */
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	
	/**
	 * Sets the database name for the derby db.
	 * @param dbName - name of the database.
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	
	/**
	 * returns the address name for the derby db.
	 * @return - return a string of address.
	 */
	public String getDbAddress() {
		return dbAddress;
	}
	
	/**
	 * returns the username for the derby db.
	 * @return - will return a string of username.
	 */
	public String getDbUsername() {
		return dbUsername;
	}
	
	/**
	 * returns the password for the derby db.
	 * @return - will return a string of password.
	 */
	public String getDbPassword() {
		return dbPassword;
	}
	
	/**
	 * returns the database name used for the derby connection.
	 * @return - returns a string of database name.
	 */
	public String getDbName() {
		return dbName;
	}
	
}
