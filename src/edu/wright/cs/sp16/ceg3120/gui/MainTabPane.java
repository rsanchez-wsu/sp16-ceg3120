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

package edu.wright.cs.sp16.ceg3120.gui;

import edu.wright.cs.sp16.ceg3120.gui.other.TabNames;
import edu.wright.cs.sp16.ceg3120.gui.tabs.ConnectionTab;
import edu.wright.cs.sp16.ceg3120.gui.tabs.NewConnectionTab;
import edu.wright.cs.sp16.ceg3120.gui.tabs.StartPageTab;


import javax.swing.JTabbedPane;

/**
 * Controls the tabs that encompass most of the application.
 * 
 * @author codybutz
 *
 */
public class MainTabPane extends JTabbedPane {
	
	private static final long serialVersionUID = 1147338263638840061L;


	/**
	 * Creates the MainTabPane and starts up a "Start Page" tab.
	 */
	public MainTabPane() {
		super();
		
		addStartPageTab();
		addConnectionTab();
		addNewConnectionTab();
	}

	/**
	 * TODO: Add "New Connection" Tab.
	 */
	public void addNewConnectionTab() {

		NewConnectionTab connectionTab = new NewConnectionTab();

		// TODO: add icon, add better tooltip
		addTab(TabNames.NewConnection.toString(), null, connectionTab, "Make a connection here!!");
	}
	
	/**
	 * TODO: Creates a new connection tab and adds it to the tab pane.
	 */
	public void addConnectionTab() {
		ConnectionTab connectionTab = new ConnectionTab();

		// TODO: add icon, add better tooltip
		addTab(TabNames.Connection.toString(), null, connectionTab, "Make a connection here!!");
	}
	
	/**
	 * TODO: Add "Help" Tab.
	 */
	public void addHelpTab() {
		
	}
	
	/**
	 * Creates a start page tab and adds it to the tab pane.
	 */
	public void addStartPageTab() {
		StartPageTab startPageTab = new StartPageTab(this);

		// TODO: add icon, add better tooltip
		addTab(TabNames.Start.toString(), null, startPageTab, null);
	}
}
