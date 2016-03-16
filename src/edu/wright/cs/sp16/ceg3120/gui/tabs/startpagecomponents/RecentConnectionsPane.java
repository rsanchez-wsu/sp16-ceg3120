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
import java.awt.Insets;

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
		setBorder(BorderFactory.createLineBorder(Color.black, 5));
		
		recentConn = new JLabel("Recent Connections");
		recentConn.setFont(new Font("TimesRoman", Font.BOLD, 24));
		
		// set size and positioning of components
		GridBagConstraints subConstraints = new GridBagConstraints();
		subConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		subConstraints.gridx = 0;
		subConstraints.gridy = 0;
		subConstraints.weightx = 0.5;
		subConstraints.weighty = 0.5;
		subConstraints.insets = new Insets(0, 10, 0, 0);
		
		add(recentConn, subConstraints);
		
		recentConnLinks = new JLabel[10];
		
		// initialize dummy values for recent connection links
		for (int i = 0; i < recentConnLinks.length; i++) {
			recentConnLinks[i] = new JLabel("Recent connection " + i);
			
			subConstraints = new GridBagConstraints();
			subConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
			subConstraints.gridx = 0;
			subConstraints.gridy = i + 1;
			subConstraints.weightx = 0.5;
			subConstraints.weighty = 0.1;
			subConstraints.insets = new Insets(0, 10, 0, 0);

			add(recentConnLinks[i], subConstraints);
		}
	}

	/* properties */
	
	/**
	 * "Recent connections" label.
	 */
	JLabel recentConn;
	
	/**
	 * "Recent connection x" link array.
	 */
	JLabel[] recentConnLinks;
	
	/* property access */
	
	/**
	 * Get the recent connection links.
	 * 
	 * @return JLabel[] recentConnLinks: array of links to be displayed on the start page.
	 */
	public JLabel[] getRecentConnLinks() {
		return recentConnLinks;
	}
	
	/**
	 * Set the new recent connection links.
	 * 
	 * @param newLinks what you want to replace the recent connection links with.
	 */
	public void setRecentConnLinks(JLabel[] newLinks) {
		recentConnLinks = newLinks;
	}
	
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
