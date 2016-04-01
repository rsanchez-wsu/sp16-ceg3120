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


import edu.wright.cs.sp16.ceg3120.sql.DatabaseConnector;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 * This will be a tab for the query builder under the connection tab.
 * @author Bonnie
 *
 */
public class QueryBuilderTab extends JPanel {

	private static final long serialVersionUID = 1L;
	private GridBagLayout layout;
	private transient ActionListener actionHandler = new ActionHandler();
	private JEditorPane input;
	private JTable output;
	private DatabaseConnector connector;
	private DefaultTableModel result = null;

	/**
	 * Default constructor for the Query Builder tab.
	 */
	public QueryBuilderTab(DatabaseConnector connector) {
		super(new GridBagLayout());
		setConnector(connector);
		initComponents();
	}
	
	/**
	 * initialize components.
	 */
	private void initComponents() {

		layout = new GridBagLayout();
		this.setLayout(layout);
		GridBagConstraints subConstraints = new GridBagConstraints();
		subConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		input = new JEditorPane();
		subConstraints.fill = GridBagConstraints.HORIZONTAL;
		subConstraints.ipady = 300;
		subConstraints.ipadx = 100;
		subConstraints.gridx = 0;
		subConstraints.gridy = 0;
		add(input, subConstraints);
		JButton run = new JButton("Run");
		subConstraints.ipady = 0;
		subConstraints.ipadx = 0;
		run.addActionListener(actionHandler);
		subConstraints.fill = GridBagConstraints.HORIZONTAL;
		subConstraints.gridx = 0;
		subConstraints.gridy = 1;
		add(run, subConstraints);
//		final JButton clear = new JButton("Clear");
//		subConstraints.fill = GridBagConstraints.HORIZONTAL;
//		subConstraints.gridx = 1;
//		subConstraints.gridy = 1;
//		add(clear, subConstraints);
		output = new JTable(result);
		subConstraints.fill = GridBagConstraints.HORIZONTAL;
		subConstraints.ipady = 300;
		subConstraints.ipadx = 100;
		subConstraints.gridx = 0;
		subConstraints.gridy = 3;
		add(output, subConstraints);
	}

	/**
	 * gets the database connector.
	 * @return the database connector
     */
	public DatabaseConnector getConnector() {
		return connector;
	}

	/**
	 * this updates sets the database connector.
	 * @param connector
	 * 				this is a database connector
     */
	public void setConnector(DatabaseConnector connector) {
		this.connector = connector;
	}

	/**
	 * This is the action for the run button.
	 */
	class ActionHandler implements ActionListener {
		/**
		 * This is the action performed when the run button is pressed.
		 * @param ae this is the exception
         */
		public void actionPerformed(ActionEvent ae) {
			String in = input.getText();
			System.out.println(in);
			//This needs to be updated to include all cases.
			if (in.contains("INSERT")) {
				try {
					getConnector().updateQuery(in);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				try {
					result = getConnector().executeQuery(in);
					// result.fireTableDataChanged();
					output.setModel(result);
					output.repaint();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Implements a default WriteObject to avoid critical warning messages.
	 */
	private void writeObject(ObjectOutputStream stream)
			throws IOException {
		stream.defaultWriteObject();
	}

	/**
	 * Implements a default ReadObject to avoid critical warning messages.
	 */
	private void readObject(ObjectInputStream stream)
			throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
	}
}
