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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

// import com.puppycrawl.tools.checkstyle.api.Configurable;

/**
 * @author rhys DbConnect is a class to run basic connection to mysql test
 *         database.
 */

public class DbConnect {
	
	private JPanel successPanel = new JPanel();

	private String dbAddress;
	private String dbUsername;
	private String dbPassword;
	private String dbName;
	private com.mysql.jdbc.jdbc2.optional.MysqlDataSource dataSource =
			new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
	
	/**
	 * DbConnect is just a place holder constructor.
	 */
	public DbConnect() {
		
	}
	
	/**
	 * DbConnect is the default constructor that the DbConnect class has.
	 * after this is done call the configure method to set up the db
	 * connection.
	 * @param dbAddress database address
	 * @param dbUsername database username
	 * @param dbPassword database password
	 * @param dbName database name
	 */
	public DbConnect(String dbAddress, String dbUsername, String dbPassword, String dbName) {
		setDbAddress(dbAddress);
		setDbUsername(dbUsername);
		setDbPassword(dbPassword);
		setDbName(dbName);
	}
	
	/**
	 * sets up the database connection.
	 * @throws SQLException when sql conncetion cant be made 
	 */
	public void configure() throws SQLException {
		dataSource.setUser(getDbUsername());
		dataSource.setPassword(getDbPassword());
		dataSource.setServerName(getDbAddress());
		dataSource.setDatabaseName(getDbName());
		Connection conn = dataSource.getConnection();
		try {
			java.sql.Statement stmt = conn.createStatement();
			try {

				ResultSet rs = stmt.executeQuery("SELECT * FROM inventory");
			
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnsNumber = rsmd.getColumnCount();
				while (rs.next()) {
					for (int i = 1; i <= columnsNumber; i++) {
						if (i > 1) {
							System.out.print(",  ");
							String columnValue = rs.getString(i);
							System.out.print(columnValue + " " + rsmd.getColumnName(i));
						}
					}
					System.out.println("");
				}
				JOptionPane.showMessageDialog(successPanel, "Connection successful");
			
				rs.close();
				stmt.close();
				conn.close();

			} catch (SQLException SqlEx) {
				stmt.close();
				conn.close();
				System.out.println("If you see this, you failed to connect!");
				System.out.println(SqlEx.getMessage());
				
			} finally {
				stmt.close();
				conn.close();
			}
			stmt.close();
			conn.close();

		} finally {
			conn.close();
		}
	}
	
	/**
	 * returns dbadrress.
	 * @return string
	 */
	public String getDbAddress() {
		return dbAddress;
	}

	/**
	 * sets dbaddress.
	 * @param dbAddress database address
	 */
	public void setDbAddress(String dbAddress) {
		this.dbAddress = dbAddress;
	}
	
	/**
	 * returns dbusername.
	 * @return string
	 */
	public String getDbUsername() {
		return dbUsername;
	}

	/**
	 * sets dbusername.
	 * @param dbUsername database username
	 */
	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	/**
	 * returns dbpassword.
	 * @return string
	 */
	public String getDbPassword() {
		return dbPassword;
	}

	/**
	 * sets dbpassword.
	 * @param dbPassword database password
	 */
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	/**
	 * returns dbname.
	 * @return string
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * sets dbname.
	 * @param dbName database name
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	
//	/**
//	 * main method contains the code to connect to the test database.
//	 * 
//	 * 
//	 * @param args
//	 *            default arguments
//	 * @throws SQLException
//	 *             Checkstyle satisfaction
//	 */
//	public static void main(String[] args) throws SQLException {
//		Scanner input = new Scanner(System.in, "UTF-8");
//		System.out.println("Welcome to the database connector!");
//		System.out.print("Please enter the address of the database you wish to connect to: ");
//		final String dbAddress = input.nextLine();
//		System.out.print("\nPlease enter the username you wish to use: ");
//		String dbUsername = input.nextLine();
//		System.out.print("\nPlease enter the password for your username: ");
//		String dbPassword = input.nextLine();
//		System.out.print("\nPlease enter the database name: ");
//		String dbName = input.nextLine();
//		// Test output to make sure variables are correct
//		// System.out.println(db_address + db_username + db_password);
//
//		com.mysql.jdbc.jdbc2.optional.MysqlDataSource dataSource =
//				new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
//		dataSource.setUser(dbUsername);
//		dataSource.setPassword(dbPassword);
//		dataSource.setServerName(dbAddress);
//		dataSource.setDatabaseName(dbName);
//		Connection conn = dataSource.getConnection();
//		try {
//			java.sql.Statement stmt = conn.createStatement();
//			try {
//
//				ResultSet rs = stmt.executeQuery("SELECT * FROM inventory");
//
//				System.out.println("If you see this you connected!");
//
//				ResultSetMetaData rsmd = rs.getMetaData();
//				int columnsNumber = rsmd.getColumnCount();
//				while (rs.next()) {
//					for (int i = 1; i <= columnsNumber; i++) {
//						if (i > 1) {
//							System.out.print(",  ");
//							String columnValue = rs.getString(i);
//							System.out.print(columnValue + " " + rsmd.getColumnName(i));
//						}
//					}
//					System.out.println("");
//				}
//
//				rs.close();
//				stmt.close();
//				conn.close();
//
//			} catch (SQLException SqlEx) {
//				stmt.close();
//				conn.close();
//				System.out.println("If you see this, you failed to connect!");
//				System.out.println(SqlEx.getMessage());
//
//			} finally {
//				stmt.close();
//				conn.close();
//			}
//			stmt.close();
//			conn.close();
//
//		} finally {
//			conn.close();
//		}
//
//	}
}

