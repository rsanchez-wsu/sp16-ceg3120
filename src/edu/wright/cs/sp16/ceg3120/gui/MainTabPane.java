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
import edu.wright.cs.sp16.ceg3120.gui.tabs.LearnAndDiscoverTab;
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
	private boolean isLearnDiscoverOpen;

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
	 * Check if Learn and Discover tab is already created.
	 * 
	 * @author Alex
	 */
	public boolean checkLearnDiscoverStatus() {
		return isLearnDiscoverOpen;
	}
	
	/**
	 * LearnDiscover tab state setter.
	 * 
	 */
	public void setLearnDiscStatus(boolean status) {
		isLearnDiscoverOpen = status;
	}
	

	/**
	 * Initialize learn and discover tab.
	 * 
	 * @author Alex, Kirill Kultinov
	 */
	public void addLearnAndDiscoverTab() {
		LearnAndDiscoverTab learnDiscoverTab = new LearnAndDiscoverTab();
		learnDiscoverTab.setOpaque(false);
		isLearnDiscoverOpen = true;
		this.addTab("Learn and Discover", learnDiscoverTab);
		setTabComponentAt(this.indexOfComponent(learnDiscoverTab),
				learnDiscoverTab.setTitleDesign(this, learnDiscoverTab, "Learn and Discover"));
		this.setSelectedIndex(this.indexOfComponent(learnDiscoverTab));
	}

	/**
	 * TODO: Add "New Connection" Tab.
	 */
	public void addNewConnectionTab() {

		newConnectionTab = new NewConnectionTab();

		// TODO: add icon, add better tool tip
		addTab(TabNames.NewConnection.toString(), null, newConnectionTab);
	}

	/**
	 * TODO: Creates a new connection tab and adds it to the tab pane.
	 */
	public void addConnectionTab() {
		connectionTab = new ConnectionTab();

		// TODO: add icon, add better tool tip
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

		// TODO: add icon, add better tool tip
		addTab(TabNames.Start.toString(), null, startPageTab, null);
	}

	// properties
	private NewConnectionTab newConnectionTab;

	private ConnectionTab connectionTab;

	// property getters

	/**
	 * "New connection" property getter.
	 * 
	 * @return "New connection" tab.
	 */
	public NewConnectionTab getNewConnectionTab() {
		return newConnectionTab;
	}

	/**
	 * "Connection" tab property setter.
	 * 
	 * @return "Connection" tab.
	 */
	public ConnectionTab getConnectionTab() {
		return connectionTab;
	}

	// property setters

	/**
	 * "New connection tab" property setter.
	 * 
	 * @param nct
	 *            what you want to replace the "New connection tab" with.
	 */
	public void setNewConnectionTab(NewConnectionTab nct) {
		newConnectionTab = nct;
	}

	/**
	 * "Connection Tab" property setter.
	 * 
	 * @param ct
	 *            what you want to replace the "Connection Tab" with.
	 */
	public void setConnectionTab(ConnectionTab ct) {
		connectionTab = ct;
	}
	


}
