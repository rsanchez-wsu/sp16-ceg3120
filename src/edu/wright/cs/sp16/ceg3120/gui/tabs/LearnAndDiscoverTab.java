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

import javax.swing.JButton;
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
		super();
		
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
		
		//initialization of buttons, url links, add to page
		String githubUrl = "https://github.com/rsanchez-wsu/sp16-ceg3120";		
		JButton gitButton = createTabButton("Git", githubUrl);

		add(gitButton);
		
		//add(new JSeparator(SwingConstants.HORIZONTAL));
		String sqlUrl = "http://www.w3schools.com/sql/";
		JButton sqlButton = createTabButton("Sql", sqlUrl);

		add(sqlButton);
		
		String driverInfoUrl = "http://www.google.com";
		JButton driverButton = createTabButton("Driver", driverInfoUrl);
		add(driverButton);
		
		String derbyUrl = "https://db.apache.org/derby/";
		JButton derbyButton = createTabButton("Derby", derbyUrl);
		add(derbyButton);
		
		String jenkinsUrl = "https://jenkins-ci.org/";
		JButton jenkinsButton = createTabButton("Jenkins", jenkinsUrl);
		add(jenkinsButton);
		
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