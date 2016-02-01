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
import java.util.Scanner;

/**
 * @author rhys DbConnect is a class to run basic connection to mysql test
 *         database.
 */

public class DbConnect {

	/**
	 * main method contains the code to connect to the test database.
	 * 
	 * 
	 * @param args
	 *            default arguments
	 * @throws SQLException  Checkstyle satisfaction
	 */
	public static void main(String[] args) throws SQLException {
		Scanner input = new Scanner(System.in, "UTF-8");
		System.out.println("Welcome to the database connector!");
		System.out.print("Please enter the address of the database you wish to connect to: ");
		final String dbAddress = input.nextLine();
		System.out.print("\nPlease enter the username you wish to use: ");
		String dbUsername = input.nextLine();
		System.out.print("\nPlease enter the password for your username: ");
		String dbPassword = input.nextLine();
		System.out.print("\nPlease enter the database name: ");
		String dbName = input.nextLine();
		// Test output to make sure variables are correct
		// System.out.println(db_address + db_username + db_password);

		com.mysql.jdbc.jdbc2.optional.MysqlDataSource dataSource = 
				new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
		dataSource.setUser(dbUsername);
		dataSource.setPassword(dbPassword);
		dataSource.setServerName(dbAddress);
		dataSource.setDatabaseName(dbName);
		Connection conn = dataSource.getConnection();
		java.sql.Statement stmt = conn.createStatement();
		try {

			ResultSet rs = stmt.executeQuery("SELECT * FROM inventory");

			System.out.println("If you see this you connected!");

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
		
	}
}
