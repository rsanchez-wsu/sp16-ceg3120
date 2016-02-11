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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//import com.sun.corba.se.pept.transport.Connection;

/**
 * The application's main class.
 */
public class MainApp {
	static JFrame connectionWindow;
	static String JDBC_DRIVER;
	static String DB_URL_BASE = "jdbc:derby:";
	static String DB_URL;

	/**
	 * Sets up connection and connects to database.
	 * 
	 */
	static void connectTodb() {
		// JDBC driver name and database URL
		JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
<<<<<<< HEAD
		//DB_URL_BASE = "jdbc:derby:";//JBDC compliant DBMS: derby, mySQL, 
		//  Database credentials
		//String user = "";
		//String password = "";
		//Connection conn = null;
		//Statement stmt = null;
		try ( Connection conn = DriverManager.getConnection(DB_URL);
				Statement stmt = conn.createStatement(); ) {
			//STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER).newInstance();

			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			//conn = DriverManager.getConnection(DB_URL);

//			//STEP 4: Execute a query
//			System.out.println("Creating statement...");
//			//stmt = conn.createStatement();
//			String sql;
//			sql = "SELECT * FROM TEAM6";
//			ResultSet rs = stmt.executeQuery(sql);
//
//			//STEP 5: Extract data from result set
//			int colCount = rs.getMetaData().getColumnCount();
//			while (rs.next()) {
//				String rowContent = new String("");
//				for (int i = 1; i <= colCount; i++) {
//					rowContent = rowContent + " : " + rs.getString(i);
//				}
//				System.out.println(rowContent);
//			}
//			//STEP 6: Clean-up environment
//			rs.close();
			//stmt.close();
			//conn.close();
		} catch (SQLException se) {
			//Handle errors for JDBC
			se.printStackTrace(); 
		} catch (Exception e) {
			//Handle errors for Class.forName
			e.printStackTrace();
		} 
//		finally {
//			//finally block used to close resources
//			try {
//				if (stmt != null) {
//					stmt.close();
//				}
//			} catch (SQLException se2) {
//				System.out.println("Nothing we can do");
//			} // nothing we can do
//			try {
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException se) {
//				se.printStackTrace();
//			} //end finally try
//		} //end try
		System.out.println("Goodbye!");
=======
		// DB_URL_BASE = "jdbc:derby:";//jdbc compliant DBMS: derby, mysql,


		// Database credentials
		// String user = "";
		// String pass = "";


		try (Connection conn = DriverManager.getConnection(DB_URL); 
				Statement stmt = conn.createStatement()) {
			try {
				// STEP 2: Register JDBC driver
				Class.forName(JDBC_DRIVER).newInstance();

				// STEP 3: Open a connection
				System.out.println("Connecting to database...");

				// STEP 4: Execute a query
				System.out.println("Creating statement...");
				String sql;
				sql = "SELECT * FROM TEAM6";
				ResultSet rs = stmt.executeQuery(sql);

				// STEP 5: Extract data from result set
				int colCount = rs.getMetaData().getColumnCount();
				while (rs.next()) {
					String rowContent = new String("");
					for (int i = 1; i <= colCount; i++) {
						rowContent = rowContent + " : " + rs.getString(i);
					}
					System.out.println(rowContent);
				}

				// STEP 6: Clean-up environment
				rs.close();
				stmt.close();
				conn.close();

			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			} finally {
				// finally block used to close resources
				// try{
				// if(stmt!=null)
				// stmt.close();
				// }catch(SQLException se2){
				// }// nothing we can do
				// try{
				// if(conn!=null)
				// conn.close();
				// }catch(SQLException se){
				// se.printStackTrace();
				// }//end finally try
			} // end try
			System.out.println("Goodbye!");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

>>>>>>> 159df2a9b01e6ba8bafeee48f56b6bca581c738c
	}

	/**
	 * Initiates the GUI for defining DB connection.
	 */
	static void connectionWinSetup() {
		connectionWindow = new JFrame("Connection Interface");

		final JLabel dburlLabel = new JLabel("Database URL: ");
		final JTextField dburlTextField = new JTextField();
		final JLabel userLabel = new JLabel("User Name: ");
		final JTextField userTextField = new JTextField();
		final JLabel passLabel = new JLabel("Password: ");
		final JTextField passTextField = new JTextField();
		final JButton submitConnButton = new JButton("Submit");

		submitConnButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				DB_URL = DB_URL_BASE + dburlTextField.getText();
				connectTodb();
			}
		});
		
		connectionWindow.setLayout(new GridLayout(4,2));
		connectionWindow.getContentPane().add(dburlLabel);
		connectionWindow.getContentPane().add(dburlTextField);
		connectionWindow.getContentPane().add(userLabel);
		connectionWindow.getContentPane().add(userTextField);
		connectionWindow.getContentPane().add(passLabel);
		connectionWindow.getContentPane().add(passTextField);
		connectionWindow.getContentPane().add(submitConnButton);
		// frame.getContentPane().add(userLabel);
		// frame.getContentPane().add(userLabel);

		connectionWindow.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent we) {
				int close = JOptionPane.showConfirmDialog(connectionWindow, 
						"Exit the application?", 
						"Exit",
						JOptionPane.YES_NO_OPTION);

				if (close == JOptionPane.YES_OPTION) {

					connectionWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} else {
					connectionWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});

		// connectionWindow.setSize(300, 300);
		connectionWindow.pack();
		connectionWindow.setLocationRelativeTo(null);
		connectionWindow.setVisible(true);

	}

	/**
	 * The main method that displays the main application window.
	 * 
	 * @param args
	 *            The command-line arguments
	 */

	public static void main(String[] args) {

		connectionWinSetup();

	}
}
