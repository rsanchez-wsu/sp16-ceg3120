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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
	static final String USER = "username";
	static final String PASS = "password";
	
	/**
	 * Sets up connection and connects to database.
	 * 
	 */
	static void connectTodb() throws SQLException {
		// JDBC driver name and database URL
		JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
		try ( Connection conn = DriverManager.getConnection(DB_URL);
				Statement stmt = conn.createStatement()) {
			// Register JDBC driver
			Class.forName(DB_URL_BASE).newInstance();

			// Open a connection
			System.out.println("Connecting to database...");

		} catch (SQLException se) {
			//Handle errors for JDBC
			se.printStackTrace(); 
		} catch (Exception e) {
			//Handle errors for Class.forName
			e.printStackTrace();
		} 

		System.out.println("Goodbye!");

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
				) {
			try {
				// Register JDBC driver
				Class.forName(JDBC_DRIVER).newInstance();

				// Open a connection
				System.out.println("Connecting to database...");
			//	conn = DriverManager.getConnection(DB_URL,USER,PASS);

			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			} 
				
			System.out.println("Goodbye!");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


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
				try {
					connectTodb();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		
		// connectionWindow.setSize(300, 300);
		connectionWindow.pack();
		connectionWindow.setLocationRelativeTo(null);
		connectionWindow.setVisible(true);

	}
	
	/*
	 * 
	 */
	static void mainWinSetup() {
		JFrame mainWindow = new JFrame("SQLizard");
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem open = new JMenuItem("New Connection");
		open.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				connectionWinSetup();
			}
			
		});
		fileMenu.add(open);
		JMenu connMenu = new JMenu("Connections");
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(fileMenu);
		menuBar.add(connMenu);
		menuBar.add(helpMenu);
		mainWindow.setJMenuBar(menuBar);
		
		mainWindow.setSize(500,500);
		mainWindow.setVisible(true);
		mainWindow.addWindowListener(new WindowAdapter() {

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
	}

	/**
	 * The main method that displays the main application window.
	 * 
	 * @param args
	 *            The command-line arguments
	 */

	public static void main(String[] args) {

		mainWinSetup();

	}
}
