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

import edu.wright.cs.sp16.ceg3120.gui.tabs.startpagecomponents.RecentConnectionsPane;
import edu.wright.cs.sp16.ceg3120.gui.tabs.startpagecomponents.TipOfTheDayPane;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

/**
 * A Start Page Tab that contains items such as:
 * - Recent Connections
 * - Tip of the Day
 * - etc.
 * 
 * @author codybutz, alyssa, sam
 *
 */
public class StartPageTab extends JPanel {

	private static final long serialVersionUID = 8991726988535798603L;
	
	/**
	 * Initializes Start Page Tab, pulls recent connections, adds components to GUI.
	 * TODO: Pull recent connections, initialize components.
	 */
	public StartPageTab() {
		super(new GridBagLayout());

		
		setSize(960, 600);
		initComponents();
	}
	
	/**Initialize components in the start tab pane.
	 * @author Sam
	 */
	public void initComponents() {
		//TODO: have recentConnConstraints, and tipOfTheDayConstraints be separate classes
		//Initialize components
		
		// specify constraints for "Recent Connections" pane
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;

		//add "Recent Connections" pane with constraints
		JPanel recentConnsPane = new RecentConnectionsPane();
		add(recentConnsPane, constraints);
		
		// specify constraints for "Tip of the day" pane
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 0.5;
		constraints.weighty = 1.0;

		//add "Tip of the day" pane with constraints
		JPanel tipOfTheDayPane = new TipOfTheDayPane();
		add(tipOfTheDayPane, constraints);
	}

}
