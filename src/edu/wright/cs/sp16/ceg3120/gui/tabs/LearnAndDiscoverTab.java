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

import java.awt.*;

import javax.swing.*;

import edu.wright.cs.sp16.ceg3120.OpenUrlAction;


//import javax.swing.JTabbedPane;

/**Learn and Discover tab, providing resources for helpful info lookup.
 * 
 * @author Blizzri, sam
 */
public class LearnAndDiscoverTab extends JPanel {

	/**
	 * idk what this is honestly
	 */
	private static final long serialVersionUID = -6246927473993559297L;

	/**Initialize the Learn and Discover tab.
	 * 
	 * @author Blizzri
	 */
	public LearnAndDiscoverTab() {
		super(new GridLayout(3, 3));

		initComponents();
	}
	
	/**Create the Learn and Discover tab.
	 * 
	 * @author Blizzri
	 */
	private void initComponents() {
		//JTabbedPane pane = new JTabbedPane();

		//URL information for tool tips
		String sqlUrl = "http://www.w3schools.com/sql/";
		String driverInfoUrl = "";
		String jenkinsUrl = "https://jenkins-ci.org/";
		String derbyUrl = "https://db.apache.org/derby/";
		String githubUrl = "https://github.com/rsanchez-wsu/sp16-ceg3120";

		JFrame frame = new JFrame("Links");

		JButton gitButton = createTabButton("Git", githubUrl);
		JButton sqlButton = createTabButton("Sql", sqlUrl);
		JButton driverButton = createTabButton("Driver", driverInfoUrl);
		JButton derbyButton = createTabButton("Derby", derbyUrl);
		JButton jenkinsButton = createTabButton("Jenkins", jenkinsUrl);

		add(gitButton);
		add(sqlButton);
		add(driverButton);
		add(derbyButton);
		add(jenkinsButton);

		//TODO: add links to preferences page as well as help within app
	}

	JButton createTabButton(String text, String url){
		JButton b = new JButton();

		b.setText(text);
		b.setOpaque(false);
		b.setBackground(Color.WHITE);
		b.setToolTipText(url);
		b.setPreferredSize(new Dimension(40,40));
		b.setMaximumSize(new Dimension(40,40));

		return b;
	}
}