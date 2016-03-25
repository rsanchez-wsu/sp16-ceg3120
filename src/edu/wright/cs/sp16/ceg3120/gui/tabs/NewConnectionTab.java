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

package edu.wright.cs.sp16.ceg3120.gui.tabs;

import edu.wright.cs.sp16.ceg3120.gui.tabs.components.NewConnectionDetailsPane;

import javax.swing.JPanel;

/**
 * The tab that contains all the components for creating a new connection.
 * 
 * @author cody
 *
 */
public class NewConnectionTab extends JPanel {

	private static final long serialVersionUID = -2518312376192094011L;

	/**
	 * Default constructor, initializes components.
	 */
	public NewConnectionTab() {
		super();

		initComponents();
	}

	/**
	 * TODO: create all components for this window and initialize them here.
	 */
	private void initComponents() {

		NewConnectionDetailsPane pane = new NewConnectionDetailsPane();

		add(pane);
	}
}
