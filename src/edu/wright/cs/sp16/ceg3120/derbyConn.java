package edu.wright.cs.sp16.ceg3120;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class derbyConn {

	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static Statement stmt = null;

	public static void main(String[] args) {
		String fName = null;
		String lName = null;
		String input = null;
		String id = null;
		int idNum = 0;
		int choice = 0;
		
		
		Scanner keyboard = new Scanner( System.in );
		establishConn();
		System.out.println("Welcome to the database: To view contents enter 1, To enter new data enter 2");
		input = keyboard.next();
		choice = Integer.parseInt(input);
		switch(choice) {
		case 1: printTable();
			break;
		case 2: System.out.println("Enter last name");
				fName = keyboard.next();
				System.out.println("Enter first name");
				lName = keyboard.next();
				System.out.println("Enter ID");
				id = keyboard.next();
				idNum = Integer.parseInt(id);
				insertItem(fName, lName, idNum);
				System.out.println("Insertion Successful");
				printTable();
				break;
		}
		 
		

		

	}

	private static void establishConn() {
		try {

			// database connection url. Creates a database called derbyDB in the
			// sp16-ceg3120 directory with
			// user set to team 4 and password set to test.
			String dbURL = "jdbc:derby:sp16-ceg3120/derbyDb;create=true";

			// database connection
			conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
				System.out.println("Connection to derbyDb successful");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private static void insertItem(String lName, String fName, int idNum) {
		try {

			pstmt = conn.prepareStatement("INSERT INTO Test values (?,?,?)");
			pstmt.setString(1, lName);
			pstmt.setString(2, fName);
			pstmt.setInt(3, idNum);
			pstmt.executeUpdate();
			pstmt.close();
	
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

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
				String lName = entries.getString(1);
				String fName = entries.getString(2);
				System.out.println(lName + "\t\t" + fName + "\t\t"+ idNum + "\t\t");
			}
			entries.close();
			stmt.close();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}
	
}
