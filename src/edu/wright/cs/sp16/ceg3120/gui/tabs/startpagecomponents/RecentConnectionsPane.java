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

package edu.wright.cs.sp16.ceg3120.gui.tabs.startpagecomponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * "Recent Connections" pane on start page.
 * This pane will be used to hold all recent 
 * connections for the user
 * TODO: 
 * -Create links for recent the users recent connections
 * -Need to pull actual recent connections from user, and
 *  connect them to link
 * 
 * @author Sam
 *
 */
public class RecentConnectionsPane extends JPanel {

	private static final long serialVersionUID = -3169614508873955055L;
	
	/**
	 * Initialize "Recent Connections" panel.
	 */
	public RecentConnectionsPane() {
		super(new GridBagLayout());
		
		initComponents();
	}
	
	/**
	 * Initialize this panes components.
	 * Components:
	 * "Learn and Discover" button
	 * "Tip of the Day" label
	 * "Tip of the day" text
	 */
	public void initComponents() {
		// setting border and background color for debug
		setBackground(Color.getHSBColor(187, 82, 74));
		setBorder(BorderFactory.createLineBorder(Color.black, 5));

		recentConn = new JLabel("Recent Connections");
		recentConn.setFont(new Font("TimesRoman", Font.BOLD, 24));
		recentConn.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
		
		// set size and positioning of components
		GridBagConstraints subConstraints = new GridBagConstraints();
		subConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		subConstraints.gridx = 0;
		subConstraints.gridy = 0;
		subConstraints.weightx = 0.5;
		subConstraints.weighty = 0.5;
		
		add(recentConn, subConstraints);
	}

	/* properties */
	
	/**
	 * "Recent connections" label.
	 */
	JLabel recentConn;
	
	/* property access */
	
	/**
	 * Get "Recent connections" label.
	 */
	public JLabel getRecentConnLabel() {
		return recentConn;
	}
	
	/**
	 * Set "Recent connections" label.
	 * 
	 * @param label JLabel to replace "Recent Connections" label.
	 */
	public void setRecentConnLabel(JLabel label) {
		recentConn = label;
	}
}
