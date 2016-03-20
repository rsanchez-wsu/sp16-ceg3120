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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SearchHistory {

	private JFrame frame;
	private JTable table;
	private JLabel lblUser;
	private JTextField textField;
	private JLabel lblLast;
	private JComboBox comboBox;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchHistory window = new SearchHistory();
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
	public SearchHistory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();		
		frame.setBounds(100, 100, 630, 456);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(121, 142, 293, 37);
		frame.getContentPane().add(table);
		
		JLabel lblSearchHistory = new JLabel("  Search history :  ");
		lblSearchHistory.setBounds(10, 157, 112, 22);
		frame.getContentPane().add(lblSearchHistory);
		
		lblUser = new JLabel(" User: ");
		lblUser.setBounds(21, 48, 51, 28);
		frame.getContentPane().add(lblUser);
		
		textField = new JTextField();
		textField.setBounds(121, 43, 308, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblLast = new JLabel("Last :");
		lblLast.setBounds(20, 88, 51, 37);
		frame.getContentPane().add(lblLast);
		
		comboBox = new JComboBox();
		comboBox.setBounds(121, 95, 91, 22);
		frame.getContentPane().add(comboBox);
		
		//Search history has a JTable box to facilitate import of a result
		//in a 2D table.
		lblNewLabel = new JLabel(" Search History ");
		lblNewLabel.setBounds(232, 11, 103, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(131, 307, 89, 23);
		frame.getContentPane().add(btnClear);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(269, 307, 89, 23);
		frame.getContentPane().add(btnEnter);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(382, 307, 89, 23);
		frame.getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				System.exit(0);
				}
			});
	}
}
