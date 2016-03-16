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

import edu.wright.cs.sp16.ceg3120.gui.tabs.QueryBuilderTab;

import java.awt.Component;

import javax.swing.JTabbedPane;

/**
 * Connection Tab.
 * @author Bonnie
 */
public class ConnectionTabPane extends JTabbedPane{

	private static final long serialVersionUID = 8991726988535798603L;

	/**
	 * Initializes Components.
	 */
	public ConnectionTabPane() {
		super();
		initComponents();

	}
	/**
	 * Initialize components.
	 */
	public void initComponents() {
		addQueryBuilderTab();
	}
	
	/**
	 * Initialize query builder tab.
	 */
	public void addQueryBuilderTab() {
		Component queryBuilderTab = new QueryBuilderTab();
		
		addTab("Query Builder", null, queryBuilderTab, null);
	}
}
