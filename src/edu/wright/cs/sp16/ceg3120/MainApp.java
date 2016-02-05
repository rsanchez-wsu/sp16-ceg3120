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

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	static String DB_URL;
	
	
	static void connectionWinSetup(){
		connectionWindow = new JFrame("Connection Interface");
		JLabel userLabel = new JLabel("User Name: ");
		JTextField userTextField = new JTextField();
		JLabel passLabel = new JLabel("Password: ");
		JTextField passTextField = new JTextField();
		
		connectionWindow.setLayout(new GridLayout(3,2));
		connectionWindow.getContentPane().add(userLabel);
		connectionWindow.getContentPane().add(userTextField);
		connectionWindow.getContentPane().add(passLabel);
		connectionWindow.getContentPane().add(passTextField);
		//frame.getContentPane().add(userLabel);
		//frame.getContentPane().add(userLabel);
		
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
		
		connectionWindow.setSize(300, 300);
		connectionWindow.setLocationRelativeTo(null);
		connectionWindow.setVisible(true);
		
	}
	/**
	 * The main method that displays the main application window.
	 * 
	 * @param args The command-line arguments
	 */
	
	public static void main(String[] args) {
	
		//connectionWinSetup();
		
 	   // JDBC driver name and database URL
		   JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";  
		   DB_URL = "jdbc:derby:testdb";

		   //  Database credentials
		    String USER = "";
		    String PASS = "";
		   
		   Connection conn = null;
		   Statement stmt = null;
		   try{
			   //STEP 2: Register JDBC driver
		      Class.forName(JDBC_DRIVER).newInstance();

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * FROM TEAM6";
		      ResultSet rs = stmt.executeQuery(sql);

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         //int id  = rs.getInt("id");
		         //int age = rs.getInt("age");
		         //String first = rs.getString("first");
		         //String last = rs.getString("last");

		         //Display values
		         System.out.print("ID: " + rs.getInt("memid"));
		         System.out.print(", First: " + rs.getString("lastname"));
		         System.out.println(", Last: " + rs.getString("firstname"));
		      }
		      //STEP 6: Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		
	}
}
