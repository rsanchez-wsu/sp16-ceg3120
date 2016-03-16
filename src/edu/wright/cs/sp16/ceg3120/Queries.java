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

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

/**
 * This is the GUI for the recent queries.
 * @author Megan
 *
 */
public class Queries {
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Queries window = new Queries();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frame = new JFrame();
		frame.setBounds(100, 100, 684, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnQuery = new JTextPane();
		txtpnQuery.setText("Query 1 \nQuery 2 \nQuery 3 \nQuery 4 \nQuery 5 \nQuery 6 \nQuery 7 "
				+ "\nQuery 8 \nQuery 9 \nQuery 10 \nQuery 11 \nQuery 12 \nQuery 13 \nQuery 14"
				+ " \nQuery 15 \nQuery 16 \nQuery 17 \nQuery 18 \nQuery 19 \nQuery 20");
		txtpnQuery.setBounds(23, 24, 376, 381);
		frame.getContentPane().add(txtpnQuery);
	}
}
