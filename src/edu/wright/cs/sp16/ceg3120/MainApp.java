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
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.UIManager;
import java.awt.*;
import java.awt.event.*;

//import com.sun.corba.se.pept.transport.Connection;

/**
 * The application's main class.
 */
public class MainApp extends JPanel
{
	//coding for Tabs
	public MainApp() {
		super(new GridLayout(1, 1));
        
        JPanel p = new JPanel(new GridLayout()); //PREFERRED!
        //p.setLayout(new GridLayout(p, GridLayout.AXIS));
        
        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("images/middle.gif");
        
        JComponent panel1 = makeTextPanel("Panel #1");
        tabbedPane.addTab("Production Database (Derby)", icon, panel1,
                "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        JComponent panel2 = makeTextPanel(
                "Panel #2 (has a preferred size of 410 x 50).");
        panel2.setPreferredSize(new Dimension(410, 50));
        tabbedPane.addTab("Other Connection", icon, panel2,
                "Does nothing at all");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        //Add the tabbed pane to this panel.
        add(tabbedPane);
        
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
    
	protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
	/** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = MainApp.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    //End of coding for Tabs
   
    
    
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
	static void connectTodb() throws SQLException 
	{
		// JDBC driver name and database URL
		JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
		try 
		( Connection conn = DriverManager.getConnection(DB_URL);
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
	
	/**
	 * THIS create And Show GUI.
	 */
	static void mainWinSetup() { //createAndShowGUI(Create and set up the window)
		JFrame mainWindow = new JFrame("SQLizard");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem open = new JMenuItem("New Connection");
		//Add content to the window.
		mainWindow.add(new MainApp(), BorderLayout.CENTER);
		//Display the window.
		mainWindow.pack();
		mainWindow.setVisible(true);
		/**
		 * THIS DOES PANEL STUFF.
		 */
		// JMenuBar greenMenuBar = new JMenuBar();
        //greenMenuBar.setOpaque(true);
        //greenMenuBar.setBackground(new Color(154, 165, 127));
        //greenMenuBar.setPreferredSize(new Dimension(200, 20));

        ////Create a yellow label to put in the content pane.
        //JLabel yellowLabel = new JLabel();
        //yellowLabel.setOpaque(true);
        //yellowLabel.setBackground(new Color(248, 213, 131));
        //yellowLabel.setPreferredSize(new Dimension(200, 180));
		
        ////Set the menu bar and add the label to the content pane.
        //mainWindow.setJMenuBar(greenMenuBar);
        //mainWindow.getContentPane().add(yellowLabel, BorderLayout.CENTER);
        
      ////Display the window.
        //mainWindow.pack();
        //mainWindow.setVisible(true);
		
		
		
		open.addActionListener(new ActionListener(){

		
			@Override
			public void actionPerformed(ActionEvent e){
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
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				mainWinSetup();
			}
		});
		

	}
}

