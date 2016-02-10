/*
 * Copyright(C) 2016
 */

package edu.wright.cs.sp16.ceg3120;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * This class connects to a database and manipulates it.
 * 
 * @author Team4
 *
 */
public class DerbyConn {

	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static Statement stmt = null;

	/**
	 * The main method.
	 * 
	 * @param args Arguments.
	 */
	public static void main(String[] args) {
		String firstName = null;
		String lastName = null;
		String input = null;
		String id = null;
		int idNum = 0;

		Scanner keyboard = new Scanner(System.in);
		establishConn();
		System.out
				.println("Welcome to the database: To view contents enter 1, "
						+ "To enter new data enter 2, To delete an item from "
						+ "the table enter 3");
		input = keyboard.next();
		int choice = Integer.parseInt(input);
		switch (choice) {
		case 1:
			printTable();
			break;
		case 2:
			System.out.println("Enter first name");
			firstName = keyboard.next();
			System.out.println("Enter last name");
			lastName = keyboard.next();
			System.out.println("Enter ID");
			id = keyboard.next();
			idNum = Integer.parseInt(id);
			insertItem(firstName, lastName, idNum);
			System.out.println("Insertion Successful");
			printTable();
			break;
		case 3:
			System.out.println("Enter ID number to delete");
			id = keyboard.next();
			deleteItem(id);
			printTable();
			break;
		default:
			break;
		}

	}

	/**This method establishes a connection with the database.
     */
	private static void establishConn() {
		try {

			// database connection url. Creates a database called derbyDB in the
			// sp16-ceg3120 directory
			String dbUrl = "jdbc:derby:sp16-ceg3120/derbyDb;create=true";

			// database connection
			conn = DriverManager.getConnection(dbUrl);
			if (conn != null) {
				System.out.println("Connection to derbyDb successful");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/**This method inserts an item given by the user into the table.
	 * 
	 * @param lastName The last name of the individual added to the database.
	 * @param firstName The first name of the individual added to the database.
	 * @param idNum The id number of the individual added to the database.
	 */
	private static void insertItem(String lastName, String firstName, int idNum) {
		try {

			pstmt = conn.prepareStatement("INSERT INTO Test values (?,?,?)");
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setInt(3, idNum);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

	/** This method deletes an item from the database from the database based
	 *  on id number.
	 * @param idNum The id number of the individual being deleted from the database.
	 */
	private static void deleteItem(String idNum) {
		try {

			pstmt = conn.prepareStatement("DELETE FROM Test WHERE ID = ?");
			pstmt.setString(1, idNum);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

	/** This method prints the current contents of the table.
	 */
	private static void printTable() {
		try {
			stmt = conn.createStatement();
			ResultSet entries = stmt.executeQuery("select * from Test");
			ResultSetMetaData meta = entries.getMetaData();
			int numberCols = meta.getColumnCount();
			for (int i = 1; i <= numberCols; i++) {

				System.out.print(meta.getColumnLabel(i) + "\t\t");
			}

			System.out
					.println("\n-------------------------------------------------");

			while (entries.next()) {
				int idNum = entries.getInt(3);
				String lastName = entries.getString(2);
				String firstName = entries.getString(1);
				System.out.println(firstName + "\t\t" + lastName + "\t\t"
						+ idNum + "\t\t");
			}
			entries.close();
			stmt.close();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

}
