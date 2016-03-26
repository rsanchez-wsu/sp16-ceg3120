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


import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTable;






/**
 * This will be a tab for the query builder under the connection tab.
 * @author Bonnie
 *
 */
public class QueryBuilderTab extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor for the Query Builder tab.
	 */
	public QueryBuilderTab() {
		super(new GridBagLayout());
		initComponents();
	}
	
	/**
	 * initialize components.
	 */
	private void initComponents() {



		JEditorPane input = new JEditorPane();
		add(input);

		JButton run = new JButton("Run");
		add(run);

		JButton clear = new JButton("Clear");
		add(clear);

		JTable output = new JTable();
		add(output);

		input.setPreferredSize(new Dimension(500, 200));
		run.setPreferredSize(new Dimension(100, 100));
		clear.setPreferredSize(new Dimension(100, 100));
		output.setPreferredSize(new Dimension(500, 200));

	}
	
}
