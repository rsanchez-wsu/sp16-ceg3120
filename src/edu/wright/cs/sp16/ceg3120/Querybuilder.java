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

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;


/**
 * 
 * @author Kenton Dover.
 *
 */
public class Querybuilder {

	private static DatabaseConnector connector;

	private static JPanel panel = new JPanel();
	private static JEditorPane input = new JEditorPane();
	private static JButton run = new JButton("Run");
	private static JButton clear = new JButton("Clear");
	private static JTable output = new JTable();
	private static JFrame frame = new JFrame("Query Builder");

	private static ActionListener actionHandler = new ActionHandler();

	/**
	 * create the query builder window.
	 */
	public static void createQueryBuilder() {

		panel.setLayout(new BorderLayout(5,10));
		panel.add(input, BorderLayout.NORTH);
		panel.add(run, BorderLayout.WEST);
		panel.add(clear, BorderLayout.EAST);
		panel.add(output, BorderLayout.SOUTH);

		input.setPreferredSize(new Dimension(500, 200));
		run.setPreferredSize(new Dimension(100, 100));
		clear.setPreferredSize(new Dimension(100, 100));
		output.setPreferredSize(new Dimension(500, 200));

		run.addActionListener(actionHandler);

		frame.add(panel);

		frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	/**
	 * Query builder constructor, accepts an open database connection. Will
	 * allow the user to construct SQL queries in the GUI.
	 * 
	 * @param connector
	 *            Open database connector that is already established.
	 */
	public Querybuilder(DatabaseConnector connector) {
		setConnector(connector);
		createQueryBuilder();
	}

	/**
	 * Function which returns the open database connection.
	 * 
	 * @return the open database connection.
	 */
	public static DatabaseConnector getConnector() {
		return Querybuilder.connector;
	}

	/**
	 * Sets the internal connection variable which must be an open and
	 * configured database connection.
	 * 
	 * @param connector
	 *            Must be an open and connected connection object.
	 */
	public static void setConnector(DatabaseConnector connector) {
		Querybuilder.connector = connector;
	}

	/**
	 * Handles the actions.
	 */
	private static class ActionHandler implements ActionListener {
		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent ae) {
			String in = input.getText();
			String[][] out = new String[0][0];
			try {
				out =  Querybuilder.getConnector().executeQuery(in);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Object[] names = {"test"};
			output = new JTable(out, names);
			panel.add(output, BorderLayout.SOUTH);
			frame.repaint();
			for (int i = 0; i < out.length; i++) {
				for (int j = 0; j < out[0].length; j++) {
					System.out.print(out[i][j]);
					System.out.print(",");
				}
				System.out.println("");
			}
		}
	}
}
