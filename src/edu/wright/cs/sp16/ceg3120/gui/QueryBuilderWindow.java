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

package edu.wright.cs.sp16.ceg3120.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 * This is the GUI for the Query Builder.
 * It will have a basic input and output screen and run button for now.
 * @author Bonnie
 *
 */
public class QueryBuilderWindow {

	/**
	 * default constructor to build the query builder window.
	 */
	public QueryBuilderWindow() {
	}
	/**
	 * create the query builder window.
	 */
	public static void createQueryBuilder() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(5,10));
		JButton run = new JButton("Run");
		JEditorPane input = new JEditorPane();
		JTable output = new JTable();
		
		panel.add(input, BorderLayout.NORTH);
		panel.add(run, BorderLayout.WEST);
		panel.add(output, BorderLayout.SOUTH);
		
		JFrame frame = new JFrame("Query Builder");
		frame.add(panel);
		
		frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
			
	}
	
	public static void main(String[] args){
		createQueryBuilder();
	}
}
