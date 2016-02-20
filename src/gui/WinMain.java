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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

/**
 * 
 * @author carl.heritage
 *
 */
public class WinMain extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTabbedPane connectionTabs;
	private CreateConnWindow connWin;
	private JMenuBar menuBar;
	
	/**Constructor for the SQLizard main window.
	 * 
	 */
	public WinMain() {
		super("SQLizard");
		connectionTabs = new JTabbedPane();
//		JPanel testPanel = new JPanel();
//		testPanel.setVisible(true);
//		connectionTabs.add("hello", testPanel);
		add(connectionTabs);
		buildMenuBar();
		
		pack();
		setSize(500, 500);
		setVisible(true);
	}
	
	/**
	 * Constructs the menubar and menuitem functionality.
	 */
	private void buildMenuBar() {
		menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem open = new JMenuItem("New Connection");
		open.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent event) {
				newConnWindow();
			}

		});
		JMenu connMenu = new JMenu("Connections");
		connMenu.add(open);
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(fileMenu);
		menuBar.add(connMenu);
		menuBar.add(helpMenu);
		setJMenuBar(menuBar);
	}
	
	/**Instantiates the create Connection Window.
	 * 
	 */
	public void newConnWindow() {
		connWin = new CreateConnWindow(this);		
	}
	
	/**Notification method to call from Create Connection
	 * Window when the results of the DB connection are found.
	 * 
	 */
	public void notifyConnResult() {
		try {
			if (connWin.getDbConnection().getConnection().isValid(10)) {
				addConnection(connWin.getDbConnection());
			} else {
				System.out.println("Connection Failed");	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connWin.reset();
	}
	
	/**
	 * Add a working connection as a tab to the window.
	 * @param newConnection The connection to base the new tab on.
	 */
	public void addConnection(DbConnection newConnection) {
		connectionTabs.addTab(newConnection.getDbName(), new ConnectionPanel(newConnection));
	}
}
