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

import edu.wright.cs.sp16.ceg3120.gui.listeners.OpenUrlAction;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**Learn and Discover tab, providing resources for helpful info lookup.
 * 
 * @author Alex, sam
 */
public class LearnAndDiscoverTab extends JPanel {

	private static final long serialVersionUID = -6246927473993559297L;
	private GridBagLayout layout;
	private GridBagConstraints gbc = new GridBagConstraints();
	
	/**Initialize the Learn and Discover tab.
	 * 
	 * @author Alex
	 */
	public LearnAndDiscoverTab() {
		super(new GridBagLayout());
		initComponents();
	}
	
	/**Create the Learn and Discover tab.
	 * 
	 * @author Alex
	 */
	private void initComponents() {
		
		layout = new GridBagLayout();
		this.setLayout(layout);
		gbc.fill = GridBagConstraints.VERTICAL;
		
		// set size and positioning of components
		GridBagConstraints subConstraints = new GridBagConstraints();
		subConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		subConstraints.gridx = 0;
		subConstraints.gridy = 0;
		subConstraints.weightx = 0.5;
		subConstraints.weighty = 0.5;
		subConstraints.insets = new Insets(0, 10, 0, 0);
		JLabel titleLabel = new JLabel("<html><h2>Learn and Discover</h2></html>");
		add(titleLabel, subConstraints);
		
		//initialization of buttons, url links, add to page
		String githubUrl = "https://github.com/rsanchez-wsu/sp16-ceg3120";		
		JButton gitButton = createTabButton("Git", githubUrl);
		gitButton.setBorderPainted(false);
		gitButton.setOpaque(false);
		gitButton.setBackground(Color.white);
		subConstraints.gridx = 0;
		subConstraints.gridy = 1;
		add(gitButton, subConstraints);
		
		//add(new JSeparator(SwingConstants.HORIZONTAL));
		String sqlUrl = "http://www.w3schools.com/sql/";
		JButton sqlButton = createTabButton("Sql", sqlUrl);
		sqlButton.setBorderPainted(false);
		sqlButton.setOpaque(false);
		sqlButton.setBackground(Color.white);
		subConstraints.gridx = 0;
		subConstraints.gridy = 2;
		add(sqlButton, subConstraints);
		
		String driverInfoUrl = "http://www.google.com";
		JButton driverButton = createTabButton("Driver", driverInfoUrl);
		driverButton.setBorderPainted(false);
		driverButton.setOpaque(false);
		driverButton.setBackground(Color.white);
		subConstraints.gridx = 0;
		subConstraints.gridy = 3;
		add(driverButton, subConstraints);
		
		String derbyUrl = "https://db.apache.org/derby/";
		JButton derbyButton = createTabButton("Derby", derbyUrl);
		derbyButton.setBorderPainted(false);
		derbyButton.setOpaque(false);
		derbyButton.setBackground(Color.white);
		subConstraints.gridx = 0;
		subConstraints.gridy = 4;
		add(derbyButton, subConstraints);
		
		String jenkinsUrl = "https://jenkins-ci.org/";
		JButton jenkinsButton = createTabButton("Jenkins", jenkinsUrl);
		jenkinsButton.setBorderPainted(false);
		jenkinsButton.setOpaque(false);
		jenkinsButton.setBackground(Color.white);
		subConstraints.gridx = 0;
		subConstraints.gridy = 5;
		add(jenkinsButton, subConstraints);
		
		//TODO: add links to preferences page as well as help within app
	}
	
	/**Dynamically create buttons for URL links.
	 * @author Alex
	 */
	JButton createTabButton(String text, String url) {
		JButton button = new JButton();

		button.setText(text);
		button.setOpaque(false);
		button.setBackground(Color.WHITE);
		button.setToolTipText(url);
		button.addActionListener(new OpenUrlAction());
		return button;
	}
}