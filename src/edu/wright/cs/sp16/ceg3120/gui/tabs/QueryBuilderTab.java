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

import java.awt.Component;

import javax.swing.JEditorPane;

import javax.swing.JScrollPane;

/**
 * This will be a tab for the query builder under the connection tab.
 * @author Bonnie
 *
 */
public class QueryBuilderTab extends Component{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor for the Query Builder tab.
	 */
	public QueryBuilderTab() {
		super();
		initComponents();
	}
	/**
	 * initialize components.
	 */
	private void initComponents() {
		JEditorPane editorPane = new JEditorPane();
		
		editorPane.setVisible(true);
		editorPane.setSize(500, 500);
		
		JScrollPane scrollPane = new JScrollPane(editorPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);		
	}
	
}
