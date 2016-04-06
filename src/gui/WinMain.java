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

package gui;

import testconnection.DbConnection;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

/**
 * 
 * @author carl.heritage
 * 	   This class handles creation of the main window gui for the program as well as creation of 
 *     tabs for new, successful connections. Also alerts user if a connection fails on a valid 
 *     connection
 *
 */
public class WinMain extends JFrame {
	//components to main window
	private static final long serialVersionUID = 1L;
	private JTabbedPane connectionTabs;
	private NewConnectionTab connWin;
	private JMenuBar menuBar;
	
	/**Constructor for the SQLizard main window.
	 * 
	 */
	public WinMain() {
		super("SQLizard");//new jframe with given title
		connectionTabs = new JTabbedPane();
		newConnWindow();
		add(connectionTabs);
		buildMenuBar();
		
		//current size settings for main window
		pack();
		setSize(750, 500);
		setVisible(true);
	}
	
	/**
	 * Constructs the menubar and menuitem functionality.
	 */
	private void buildMenuBar() {
		menuBar = new JMenuBar();
		//initializing new menu items
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu winMenu = new JMenu("Window");
		JMenu helpMenu = new JMenu("Help");
		//adding items to menu bar
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(winMenu);
		menuBar.add(helpMenu);
		setJMenuBar(menuBar);
	}
	
	/**Instantiates the create Connection Window.
	 * 
	 */
	public void newConnWindow() {
		connWin = new NewConnectionTab(this);
		connectionTabs.addTab("New Connection", connWin);
	}
	
	/**Notification method to call from Create Connection
	 * Window when the results of the DB connection are found.
	 * 
	 */
	public void notifyConnResult() {
		try {
			//if the new connection is made successfully and commands can be sent and results 

			if (connWin.getDbConnection().isConnected()) {
				addConnection(connWin.getDbConnection());
			} else {
				System.out.println("Connection Failed");	
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		connWin.reset();//removes and reselts to standard values for all fields in the window tab
		
	}
	
	/**
	 * Add a working connection as a tab to the window.
	 * @param newConnection The connection to base the new tab on.
	 */
	public void addConnection(DbConnection newConnection) {
		//only if the connection is a success
		connectionTabs.addTab(newConnection.getDbName(), new ConnectionPanel(newConnection));
	}
}
