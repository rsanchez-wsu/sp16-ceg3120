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

package edu.wright.cs.sp16.ceg3120;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;




/**
 * This is the GUI for the recent queries.
 * @author Megan
 *
 */
public class Queries extends JPanel {

	private static final long serialVersionUID = 1L;


	/**
	 * Create the application.
	 */
	public Queries() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JComboBox<String> recentQueryBox = new JComboBox<String>();
		//TODO create something that adds the recent queries to the recentQueryBox
		recentQueryBox.addItem(null);
		recentQueryBox.setBounds(59, 89, 152, 30);
		add(recentQueryBox);
		
		JLabel lblRecentQueries = new JLabel("Recent Queries");
		lblRecentQueries.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRecentQueries.setBounds(59, 42, 160, 35);
		add(lblRecentQueries);
		
		JButton btnRunSelectedQuery = new JButton("Run selected query");
		btnRunSelectedQuery.setBounds(59, 360, 152, 23);
		add(btnRunSelectedQuery);
		
	}
}
