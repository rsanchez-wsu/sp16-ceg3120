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

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

//import javax.swing.JTabbedPane;

/**Learn and Discover tab, providing resources for helpful info lookup.
 * 
 * @author Blizzri
 */
public class LearnAndDiscoverTab {

	/**Initialize the Learn and Discover tab.
	 * 
	 * @author Blizzri
	 */
	public LearnAndDiscoverTab() {
		super();
		
		initComponents();
	}
	
	/**Create the Learn and Discover tab.
	 * 
	 * @author Blizzri
	 */
	private void initComponents() {
		//JTabbedPane pane = new JTabbedPane();
		
		//URL information for tool tips
		final String sqlUrl = "http://www.w3schools.com/sql/";
		final String driverInfoUrl = "";
		final String jenkinsUrl = "https://jenkins-ci.org/";
		final String derbyUrl = "https://db.apache.org/derby/";
		final String githubUrl = "https://github.com/rsanchez-wsu/sp16-ceg3120";
		
		JFrame frame = new JFrame("Links");
		
		final JButton sqlButton = new JButton();
		final JButton driverButton = new JButton();
		final JButton jenkinsButton = new JButton();
		final JButton derbyButton = new JButton();
		final JButton gitButton = new JButton();
		
		Container container = frame.getContentPane();
		container.setLayout(new GridBagLayout());
		
		sqlButton.setText("SQL help/reference: ");
		sqlButton.setOpaque(false);
		sqlButton.setBackground(Color.WHITE);
		sqlButton.setToolTipText(sqlUrl);
		//sqlButton.addActionListener(new OpenUrlAction());
		container.add(sqlButton);
		
		driverButton.setText("Driver information: ");
		driverButton.setOpaque(false);
		driverButton.setBackground(Color.WHITE);
		driverButton.setToolTipText(driverInfoUrl);
		//driverButton.addActionListener(new OpenUrlAction());
		container.add(driverButton);
		
		jenkinsButton.setText("Jenkins: ");
		jenkinsButton.setOpaque(false);
		jenkinsButton.setBackground(Color.WHITE);
		jenkinsButton.setToolTipText(jenkinsUrl);
		//jenkinsButton.addActionListener(new OpenUrlAction());
		container.add(jenkinsButton);
		
		derbyButton.setText("Derby: ");
		derbyButton.setOpaque(false);
		derbyButton.setBackground(Color.WHITE);
		derbyButton.setToolTipText(derbyUrl);
		//derbyButton.addActionListener(new OpenUrlAction());
		container.add(derbyButton);
		
		gitButton.setText("Github: ");
		gitButton.setOpaque(false);
		gitButton.setBackground(Color.WHITE);
		gitButton.setToolTipText(githubUrl);
		//driverButton.addActionListener(new OpenUrlAction());
		container.add(gitButton);
				
		//TODO: add links to preferences page as well as help within app
		
	}
}