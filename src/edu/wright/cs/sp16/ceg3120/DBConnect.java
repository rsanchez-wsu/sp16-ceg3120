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

//Import necessary connection libraries
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	public static void main(String[] args) {
		// Create needed variables
		String dbAddress = "";
		String dbUsername = "";
		String dbPassword = "";
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		// Prompt user for input
		try {
			System.out.println("Welcome to the database connector!");
			System.out.print("Please enter the address of the database you wish to connect to: ");
			dbAddress = input.readLine();
			System.out.print("\nPlease enter the username you wish to use: ");
			dbUsername = input.readLine();
			System.out.print("\nPlease enter the password for your username: ");
			dbPassword = input.readLine();
			// Test output to make sure variables are correct
			// System.out.println(db_address + db_username + db_password);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Create new connection instance
		// This code was found on the Developer MySQL site

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		try {
			Connection conn = null;
			conn = DriverManager
					.getConnection("jdbc:mysql:" + dbAddress + "user=" + dbUsername + "&password=" + dbPassword);
			
			System.out.println("If you see this you connected!");
			
			System.out.print(conn.getSchema());
			
		} catch (SQLException SQLex) {
			System.out.println("If you see this, you failed to connect!");
			System.out.println(SQLex.getMessage());
		}

	}
}
