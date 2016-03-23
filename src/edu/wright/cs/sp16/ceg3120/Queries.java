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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;




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
	public Queries(JButton btnCancel) {
		
		initialize(btnCancel);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JButton btnCancel) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{28, 139, 125, 89, 0, 0};
		gridBagLayout.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblRecentQueries = new JLabel("Recent Queries");
		lblRecentQueries.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRecentQueries.setBounds(59, 42, 160, 35);
		GridBagConstraints gbc_lblRecentQueries = new GridBagConstraints();
		gbc_lblRecentQueries.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblRecentQueries.insets = new Insets(0, 0, 5, 5);
		gbc_lblRecentQueries.gridx = 1;
		gbc_lblRecentQueries.gridy = 0;
		add(lblRecentQueries, gbc_lblRecentQueries);
		JComboBox<String> recentQueryBox = new JComboBox<String>();
		//TODO create something that adds the recent queries to the recentQueryBox
		recentQueryBox.addItem(null);
		recentQueryBox.setBounds(59, 89, 152, 30);
		GridBagConstraints gbc_recentQueryBox = new GridBagConstraints();
		gbc_recentQueryBox.anchor = GridBagConstraints.WEST;
		gbc_recentQueryBox.insets = new Insets(0, 0, 5, 5);
		gbc_recentQueryBox.gridx = 1;
		gbc_recentQueryBox.gridy = 4;
		add(recentQueryBox, gbc_recentQueryBox);
		
		JButton btnRunSelectedQuery = new JButton("Run selected query");
		btnRunSelectedQuery.setBounds(59, 360, 152, 23);
		GridBagConstraints gbc_btnRunSelectedQuery = new GridBagConstraints();
		gbc_btnRunSelectedQuery.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnRunSelectedQuery.insets = new Insets(0, 0, 5, 5);
		gbc_btnRunSelectedQuery.gridx = 2;
		gbc_btnRunSelectedQuery.gridy = 4;
		add(btnRunSelectedQuery, gbc_btnRunSelectedQuery);
		
		JButton btnNewButton = btnCancel;
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 8;
		add(btnNewButton, gbc_btnNewButton);
		
	}
}
