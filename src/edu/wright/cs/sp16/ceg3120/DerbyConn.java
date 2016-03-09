/*
 * Copyright(C) 2016
 */

package edu.wright.cs.sp16.ceg3120;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * This class connects to a database and manipulates it.
 * 
 * @author Team4
 *
 */
public class DerbyConn {
	private static ResultSet rs = null;

	/**
	 * The main method.
	 * 
	 * @param args
	 *            Arguments.
	 */
	public static void main(String[] args) {
		String firstName = null;
		String lastName = null;
		int run = 1;
		String id = null;
		int idNum = 0;

		String val = null;
		int numVal = 0;
		int choice = 0;
		try {
			createTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		createWindow();

		do {
			System.out
					.println("\nWelcome to the database \nTo view contents enter 1 \n"
							+ "To insert a new item enter 2 \nTo delete an item from "
							+ "the table enter 3 \nTo edit an item from the table enter 4 "
							+ "\nTo create a table enter 5 \nTo exit enter 6");
			Scanner keyboard = new Scanner(System.in);

			try {
				choice = keyboard.nextInt();
			} catch (InputMismatchException exception) {
				System.out.println("Invalid Input");
			}

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
				System.out.println("Deletion Successful");
				printTable();
				break;
			case 4:
				System.out.println("Enter ID number to edit");
				id = keyboard.next();
				idNum = Integer.parseInt(id);
				System.out.println("Enter new first name");
				firstName = keyboard.next();
				System.out.println("Enter new last name");
				lastName = keyboard.next();
				editItem(firstName, lastName, idNum);
				System.out.println("Edit Successful");
				printTable();
				break;
			case 5:
				System.out
						.println("Enter the number of columns for the table: ");
				val = keyboard.next();
				numVal = Integer.parseInt(val);
				addTable(numVal);
				break;
			case 6:
				run = 0;
				System.exit(0);
				break;
			default:
				break;
			}
		} while (run != 0);

	}

	/**
	 * This method creates the application window.
	 * 
	 */
	private static void createWindow() {
		JFrame frame = new JFrame("Team 4 Database");

		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});

		JButton displayTable = new JButton("Display Table");
		displayTable.setSize(40, 60);
		displayTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				displayTable();
			}
		});
		JPanel panel = new JPanel(new GridLayout(2, 2));
		panel.add(displayTable);
		frame.getContentPane().add(panel);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}

	/**
	 * This method creates the Test table used in the program if it does not
	 * exist.
	 * 
	 * @throws SQLException
	 *             Sql exception
	 */
	private static void createTable() throws SQLException {
		Connection conn = establishConn();
		Statement stmt = null;
		// attempts to create table
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("CREATE TABLE Test" + "(LNAME VARCHAR(25),"
					+ "FNAME VARCHAR(25)," + "ID INTEGER)");
		} catch (SQLException e) {
			// checks for specific error code for table already existing
			if (!e.getSQLState().equals("X0Y32")) {
				throw e;
			}
		}
	}

	/**
	 * This method puts data from the database into a JTable.
	 * 
	 * 
	 */
	private static void displayTable() {
		Connection conn = establishConn();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("select * from Test");
			rs = pstmt.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Table is created from the table model created in
		// buildTableModel()
		JTable table = null;
		try {
			table = new JTable(buildTableModel(rs));
		} catch (SQLException e) {

			e.printStackTrace();
		}

		JOptionPane.showMessageDialog(null, new JScrollPane(table));
	}

	/**
	 * This method builds the JTable from the result set of the derby table.
	 * 
	 * @param rs
	 *            The result set of the derby table
	 * @return Returns a table model for the table to be displayed
	 * @throws SQLException
	 *             Throws exception
	 */
	public static DefaultTableModel buildTableModel(ResultSet rs)
			throws SQLException {

		ResultSetMetaData metaData = rs.getMetaData();

		// Gets column names from database table
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}

		// Gets the data from the database table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}

		// returns a table model to format the table
		return new DefaultTableModel(data, columnNames);

	}

	/**
	 * This method establishes a connection with the database.
	 */
	private static Connection establishConn() {
		Connection conn = null;
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
		return conn;
	}

	/**
	 * This method inserts an item given by the user into the table.
	 * 
	 * @param lastName
	 *            The last name of the individual added to the database.
	 * @param firstName
	 *            The first name of the individual added to the database.
	 * @param idNum
	 *            The id number of the individual added to the database.
	 */
	private static void insertItem(String firstName, String lastName, int idNum) {
		Connection conn = establishConn();
		PreparedStatement pstmt = null;
		PreparedStatement checkId = null;
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

	/**
	 * This method deletes an item from the database based on id number.
	 * 
	 * @param idNum
	 *            The id number of the individual being deleted from the
	 *            database.
	 */
	private static void deleteItem(String idNum) {
		Connection conn = establishConn();
		PreparedStatement pstmt = null;
		try {

			pstmt = conn.prepareStatement("DELETE FROM Test WHERE ID = ?");
			pstmt.setString(1, idNum);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}
	
	/**
	 * This method edits an item from the database based on id number.
	 * 
	 * @param idNum
	 *            The id number of the individual being edited from the
	 *            database.
	 */
	private static void editItem(String firstName, String lastName, int idNum) {
		Connection conn = establishConn();
		PreparedStatement pstmt = null;
		try {

			pstmt = conn.prepareStatement("UPDATE Test SET FNAME = ?, LNAME = ? WHERE ID = ?");
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setInt(3, idNum);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

	/**
	 * This method creates a new table in the database.
	 */
	private static void addTable(int items) {
		Connection conn = establishConn();
		PreparedStatement pstmt = null;

		try {
			Scanner orbital = new Scanner(System.in);
			String[] tableInfo = new String[items * 2];
			int location = 0;
			for (int i = 0; i < items; i++) {
				String colName;
				System.out
						.println("If value "
								+ i++
								+ "is a string enter 1, "
								+ "if it is a number enter 2, if it is a boolean enter 3: ");
				int choice = orbital.nextInt();

				switch (choice) {
				case 1:
					tableInfo[location] = "VARCHAR(255), ";
					location++;
					System.out.println("Enter in the name of the category: ");
					colName = orbital.next();
					tableInfo[location] = colName;
					location++;

					break;
				case 2:
					tableInfo[location] = "INTEGER, ";
					location++;
					System.out.println("Enter in the name of the category: ");
					colName = orbital.next();
					tableInfo[location] = colName;
					location++;

					break;
				case 3:
					tableInfo[location] = "BOOLEAN, ";
					location++;
					System.out.println("Enter in the name of the category: ");
					colName = orbital.next();
					tableInfo[location] = colName;
					location++;
					break;
				default:
					break;
				}

			}
			String sql = "CREATE TABLE REGISTRATION "
					+ "(id INTEGER not NULL, ";
			for (int j = 0; j < location; j = j + 2) {
				sql = sql + tableInfo[j + 1] + " " + tableInfo[j];
			}
			sql = sql + " PRIMARY KEY ( id ))";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();

			System.out.println("Created table in given database...");
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

	/**
	 * This method prints the current contents of the table.
	 */
	private static void printTable() {
		Connection conn = establishConn();
		PreparedStatement pstmt = null;
		String sql = null;
		sql = "SELECT * FROM Test";

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet entries = pstmt.executeQuery();
			ResultSetMetaData meta = entries.getMetaData();
			int numberCols = meta.getColumnCount();
			System.out.println("");
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
			pstmt.close();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

}
