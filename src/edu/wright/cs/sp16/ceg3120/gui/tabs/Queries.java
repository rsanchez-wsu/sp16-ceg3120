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

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblRecentQueries = new JLabel("Recent Queries");
		lblRecentQueries.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRecentQueries.setBounds(59, 42, 160, 35);
		GridBagConstraints gbcLblRecentQueries = new GridBagConstraints();
		gbcLblRecentQueries.anchor = GridBagConstraints.NORTHWEST;
		gbcLblRecentQueries.insets = new Insets(0, 0, 5, 5);
		gbcLblRecentQueries.gridx = 1;
		gbcLblRecentQueries.gridy = 0;
		add(lblRecentQueries, gbcLblRecentQueries);
		JComboBox<String> recentQueryBox = new JComboBox<String>();
		recentQueryBox.setToolTipText("");
		//TODO create something that adds the recent queries to the recentQueryBox
		recentQueryBox.addItem("Sample Item: Query 1");
		recentQueryBox.addItem("Sample Item: Query 2");
		recentQueryBox.setBounds(59, 89, 152, 30);
		GridBagConstraints gbcRecentQueryBox = new GridBagConstraints();
		gbcRecentQueryBox.anchor = GridBagConstraints.WEST;
		gbcRecentQueryBox.insets = new Insets(0, 0, 5, 5);
		gbcRecentQueryBox.gridx = 1;
		gbcRecentQueryBox.gridy = 3;
		add(recentQueryBox, gbcRecentQueryBox);
		
		
		GridBagConstraints gbcBtnNewButton = new GridBagConstraints();
		gbcBtnNewButton.insets = new Insets(0, 0, 0, 5);
		gbcBtnNewButton.anchor = GridBagConstraints.NORTHWEST;
		gbcBtnNewButton.gridx = 3;
		gbcBtnNewButton.gridy = 8;
		JButton btnNewButton = btnCancel;
		add(btnNewButton, gbcBtnNewButton);
		
		JButton btnRunSelectedQuery = new JButton("Run selected query");
		btnRunSelectedQuery.setBounds(59, 360, 152, 23);
		GridBagConstraints gbcBtnRunSelectedQuery = new GridBagConstraints();
		gbcBtnRunSelectedQuery.anchor = GridBagConstraints.NORTHWEST;
		gbcBtnRunSelectedQuery.insets = new Insets(0, 0, 5, 5);
		gbcBtnRunSelectedQuery.gridx = 2;
		gbcBtnRunSelectedQuery.gridy = 3;
		add(btnRunSelectedQuery, gbcBtnRunSelectedQuery);
		
	}
}
