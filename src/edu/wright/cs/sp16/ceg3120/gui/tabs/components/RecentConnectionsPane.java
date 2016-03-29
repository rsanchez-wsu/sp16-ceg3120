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

package edu.wright.cs.sp16.ceg3120.gui.tabs.components;

import edu.wright.cs.sp16.ceg3120.gui.MainTabPane;
import edu.wright.cs.sp16.ceg3120.util.XmlUtil;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * "Recent Connections" pane on start page. This pane will be used to hold all
 * recent connections for the user TODO: -Create links for recent the users
 * recent connections -Need to pull actual recent connections from user, and
 * connect them to link
 * 
 * @author Sam
 *
 */
public class RecentConnectionsPane extends JPanel {

	private static final long serialVersionUID = -3169614508873955055L;

	/**
	 * Default constructor. Initialize "Recent Connections" panel. Note: if you
	 * need a reference of another GUI class then you need to add a new
	 * constructor and add it as an argument
	 */
	public RecentConnectionsPane() {
		super(new GridBagLayout());

		initComponents();
	}

	/**
	 * Initialize "Recent Connections" panel with reference to MainTabPane.java
	 * 
	 * @param mainTabPane
	 *            the reference to the MainGui's tabbed pane.
	 */
	public RecentConnectionsPane(MainTabPane mainTabPane) {
		super(new GridBagLayout());

		// set mainTab property to main tab pane reference
		mainTab = mainTabPane;

		initComponents();
	}

	/**
	 * Initialize this panes components. Components: "Learn and Discover" button
	 * "Tip of the Day" label "Tip of the day" text
	 */
	public void initComponents() {
		setBorder(BorderFactory.createLineBorder(Color.gray, 1));

		recentConn = new JLabel("<html><h2>Recent Connections</h2></html>");

		// set size and positioning of components
		GridBagConstraints subConstraints = new GridBagConstraints();
		subConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		subConstraints.gridx = 0;
		subConstraints.gridy = 0;
		subConstraints.weightx = 0.5;
		subConstraints.weighty = 0.5;
		subConstraints.insets = new Insets(0, 10, 0, 0);

		add(recentConn, subConstraints);

		ButtonHandler recentConnClickEvent = new ButtonHandler();
		
		// get alias's
		aliass = XmlUtil.populateAlias();
		
		// initialize recent connection links
		recentConnLinks = new JButton[aliass.length];

		// initialize dummy values for recent connection links
		for (int i = 0; i < aliass.length; i++) {
			recentConnLinks[i] = new JButton();
			recentConnLinks[i].setText("<HTML><U>Recent connection " + i + "</U></HTML>");
			recentConnLinks[i].setBorderPainted(false);
			recentConnLinks[i].setOpaque(false);
			recentConnLinks[i].setBackground(Color.white);
			recentConnLinks[i].addActionListener(recentConnClickEvent);

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

	/**
	 * Button handler class, this class holds our "onclick" events.
	 * 
	 * @author Sam
	 */
	class ButtonHandler implements ActionListener {
		/**
		 * The button handler code that makes the handler "do stuff".
		 */
		public void actionPerformed(ActionEvent event) {
			/*
			 * currently this causes the "Connection" tab to be opened as it is
			 * the second tab in MainTabPane 3/19/2016.
			 */
			mainTab.setSelectedIndex(1);
		}
	}

	/* properties */

	MainTabPane mainTab;

	/**
	 * "Recent connections" label.
	 */
	JLabel recentConn;

	/**
	 * "Recent connection x" link array.
	 */
	JButton[] recentConnLinks;

	/**
	 * List of alias's
	 */
	String[] aliass;
	
	/**
	 * Get "Recent connections" label.
	 */
	public JLabel getRecentConnLabel() {
		return recentConn;
	}
	
	/**
	 * Set "Recent connections" label.
	 * 
	 * @param label
	 *            JLabel to replace "Recent Connections" label.
	 */
	public void setRecentConnLabel(JLabel label) {
		recentConn = label;
	}
}
