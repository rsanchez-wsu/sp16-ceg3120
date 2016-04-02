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
		PreparedStatement pstmt = null;
		String val = null;
		int numVal = 0;
		int choice = 0;
		int order = 1;
		int orderChoice = 0;
		int editChoice = 0;
		int colType = 0;
		String colName = null;
		try {
			createTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		createWindow();

		do {
			System.out.println("\nWelcome to the database \nTo view contents enter 1 \n"
					+ "To insert a new item enter 2 \nTo delete an item from "
					+ "the table enter 3 \nTo edit an item in the table enter 4 "
					+ "\nTo create a new table enter 5 \nTo edit a table enter 6 "
					+ "\nTo sort table enter 7 \nTo search table by ID enter 8"
					+ "\nTo search table by first name enter 9 "
					+ "\nTo search table by last name enter 10 \nTo exit enter 11");

			Scanner keyboard = new Scanner(System.in);

			try {
				choice = keyboard.nextInt();
			} catch (InputMismatchException exception) {
				System.out.println("Invalid Input");
			}

			switch (choice) {
			case 1:
				printTable(orderChoice, order);
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
				printTable(orderChoice, order);
				break;
			case 3:
				System.out.println("Enter ID number to delete");
				id = keyboard.next();
				deleteItem(id);
				System.out.println("Deletion Successful");
				printTable(orderChoice, order);
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
				printTable(orderChoice, order);
				break;
			case 5:
				System.out.println("Enter the number of columns for the table: ");
				val = keyboard.next();
				numVal = Integer.parseInt(val);
				addTable(numVal);
				System.out.println("Table created successfully");
				break;
			case 6:
				System.out.println("Enter '1' to edit a column name, or enter '2' to add a "
						+ "Column to a table?: ");
				try {
					editChoice = keyboard.nextInt();
				} catch (InputMismatchException exception) {
					System.out.println("Invalid Input");
				}
				if (editChoice == 1) {
					System.out.println("Enter the name of the table you wish to edit: ");
					val = keyboard.next();
					System.out.println("Enter the old name of the Column");
					firstName = keyboard.next();
					System.out.println("Enter new name of the Column");
					lastName = keyboard.next();
					editColumnName(val, firstName, lastName);
					System.out.println("Table edited successfully");
					printTable(orderChoice, order);
				} else if (editChoice == 2) {
					System.out.println("Enter the name of the table you wish to edit: ");
					val = keyboard.next();
					System.out.println("Enter the name of the new Column");
					colName = keyboard.next();
					System.out.println("Select the data type for the column. For an integer, "
							+ "enter 1; for a string, enter 2; for a boolean, enter 3: ");
					try {
						colType = keyboard.nextInt();
					} catch (InputMismatchException exception) {
						System.out.println("Invalid Input");
					}
					addColumn(val, colName, colType);
					System.out.println("Column added successfully");
					printTable(orderChoice, order);
				} else {
					System.out.println("Please enter a valid choice. ");	
				}

				break;	
			case 7:
				System.out.println("To order by ID enter 1 \nTo order by first name enter 2"
						+ "\nTo order by last name enter 3");
				try {
					orderChoice = keyboard.nextInt();
				} catch (InputMismatchException exception) {
					System.out.println("Invalid Input");
				}
				System.out.println("For descending order enter 1 \nFor ascending order enter 2");
				try {
					order = keyboard.nextInt();
				} catch (InputMismatchException exception) {
					System.out.println("Invalid Input");
				}
				System.out.println("Table sorted successfully");
				printTable(orderChoice, order);
				break;
			case 8:
				System.out.println("Enter ID number to search");
				id = keyboard.next();
				idNum = Integer.parseInt(id);
				pstmt = createIdSearch(idNum);
				searchTable(pstmt);
				break;
			case 9:
				System.out.println("Enter first name to search");
				firstName = keyboard.next();
				pstmt = createFirstNameSearch(firstName);
				searchTable(pstmt);
				break;
			case 10:
				System.out.println("Enter last name to search");
				lastName = keyboard.next();
				pstmt = createLastNameSearch(lastName);
				searchTable(pstmt);
				break;
			case 11:
				run = 0;
				System.exit(0);
				keyboard.close();
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
			stmt.close();
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
			pstmt.close();
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
		try {
			pstmt = conn.prepareStatement("INSERT INTO Test values (?,?,?)");
			pstmt.setString(1, lastName);
			pstmt.setString(2, firstName);
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
	 * This method edits allows a user to rename a column in a table in the database.
	 * @param tableName
	 * 			This is the name of the table in which the column desired to be 
	 * 					edited is located
	 * @param oldColumn
	 * 			This is the name of the column before the edit
	 * @param newColumn
	 * 			This is the desired name of the column after the edit
	 * 
	 * 
	 */
	private static void editColumnName(String tableName, String oldColumn, String newColumn) {
		Connection conn = establishConn();
		PreparedStatement pstmt = null;
		try {			
			pstmt = conn.prepareStatement("ALTER TABLE table_name = ? CHANGE COLUMN old_name= ? "
					+ "TO new_name = ?;");
			pstmt.setString(1, tableName);
			pstmt.setString(2, oldColumn);
			pstmt.setString(3, newColumn);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

	/**
	 * This method edits allows a user to add a column in a table in the database.
	 * @param tableName
	 * 			This is the name of the table in which the column desired to be 
	 * 					edited is located
	 *  @param newName
	 * 			This is the desired name of the column that is being created
	 * @param columnType
	 * 			This is an integer that matches up with a choice to decide what type of 
	 * 					data will be contained in the column: 1 for int, 2 for string, 3 for boolean
	 */	
	private static void addColumn(String tableName, String newName, int columnType) {
		Connection conn = establishConn();
		PreparedStatement pstmt = null;
		try {
			String colType = "";
			pstmt = conn.prepareStatement("ALTER TABLE table_name = ? ADD name= ? "
					+ "value = ?;");
			pstmt.setString(1, tableName);
			pstmt.setString(2, newName);
			if (columnType == 1) {
				colType = "INT(10)";
				pstmt.setString(1, colType);	
			} else if (columnType == 2) {
				colType = "VARCHAR(100)";
				pstmt.setString(2, colType);	
			} else {
				colType = "BOOL DEFAULT '0'";
				pstmt.setString(3, colType);
			}
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}

	}

	/**
	 * This method allows a user to search the database.
	 * @param pstmt - prepared statement used to search database
	 */
	private static void searchTable(PreparedStatement pstmt) {
		try {
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

	/**
	 * Creates PreparedStatement for a table search of the specified ID.
	 * @param id - ID number to search
	 * @return sql query
	 */
	private static PreparedStatement createIdSearch(int id) {
		Connection conn = establishConn();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM Test WHERE ID = ?");
			pstmt.setInt(1, id);
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
		return pstmt;
	}

	/**
	 * Creates PreparedStatement for a table search of the specified first name.
	 * @param fname first name to search
	 * @return sql query
	 */
	private static PreparedStatement createFirstNameSearch(String fname) {
		Connection conn = establishConn();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM Test WHERE FNAME = ?");
			pstmt.setString(1, fname);
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
		return pstmt;
	}

	/**
	 * Creates PreparedStatement for a table search of the specified last name.
	 * @param lname last name to search
	 * @return sql query
	 */
	private static PreparedStatement createLastNameSearch(String lname) {
		Connection conn = establishConn();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM Test WHERE LNAME = ?");
			pstmt.setString(1, lname);
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
		return pstmt;
	}


	/**
	 * This method creates a new table in the database.
	 */
	private static void addTable(int items) {
		Connection conn = establishConn();
		PreparedStatement pstmt = null;

		try {
			
			String sql = "CREATE TABLE REGISTRATION "
					+ "(id INTEGER not NULL,  PRIMARY KEY ( id ))";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt.close();

			System.out.println("Created table in given database...");
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

	/**
	 * This method prints the current contents of the table and sorts 
	 * based on id number, first name, or last name, in ascending or 
	 * descending order.
	 * 
	 * @param orderChoice
	 *            The column to sort the table by
	 * @param order
	 * 			  The type of order to sort the table by: ascending or descending 
	 */
	private static void printTable(int orderChoice, int order) {
		Connection conn = establishConn();
		PreparedStatement pstmt = null;
		String sql = null;
		sql = "SELECT * FROM Test ";

		try {
			switch (orderChoice) {
			case 1:
				if (order == 1) {
					sql = sql + "ORDER BY ID DESC";
				} else {
					sql = sql + "ORDER BY ID ASC";
				}

				break;
			case 2:
				if (order == 1) {
					sql = sql + "ORDER BY FNAME DESC";
				} else {
					sql = sql + "ORDER BY FNAME ASC";
				}
				break;
			case 3:
				if (order == 1) {
					sql = sql + "ORDER BY LNAME DESC";
				} else {
					sql = sql + "ORDER BY LNAME ASC";
				}
				break;
			default:
				break;
			}
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
