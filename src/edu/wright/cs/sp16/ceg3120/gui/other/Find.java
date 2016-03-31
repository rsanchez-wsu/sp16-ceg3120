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

package edu.wright.cs.sp16.ceg3120.gui.other;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This is a Find window implementation.
 * 
 * @author Devesh Patel
 */
public class Find extends JDialog {

	private static final long serialVersionUID = 6520964837879556371L;
	private JPanel mainPanel = new JPanel();
	private JLabel lblFind = new JLabel("Find: ");
	private static JFrame frame = null;
	private static JTextField textField = new JTextField(10);
	private static JTextArea text = new JTextArea(10, 10);
	private static boolean caseSensi;
	private static JCheckBox checkBox = new JCheckBox("Match case");
	private static JButton findButton = new JButton("Find");
	private static JButton closeButton = new JButton("Close");
	private JPanel tempTextPanel = new JPanel();
	String str = "This is a temporary JTextArea. \nThis doesn't work completely.";

	static int initial;
	static int index;

	/**
	 * Constructor for Find.
	 */
	public Find() {
		super(frame, "Find");

		setLayout(new BorderLayout());

		mainPanel.add(lblFind);
		mainPanel.add(textField);
		mainPanel.add(checkBox);
		getContentPane().add(mainPanel, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));
		buttonPanel.add(findButton);
		buttonPanel.add(closeButton);

		// close button listener
		closeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
			}
		});

		getContentPane().add(buttonPanel, BorderLayout.CENTER);

		createFakeText();
		getContentPane().add(tempTextPanel, BorderLayout.SOUTH);

		buttonListener();

		setSize(400, 150);
	} // end Find constructor

	/**
	 * Just a temp text panel and position.
	 */
	private void createFakeText() {
		tempTextPanel.setLayout(new GridLayout(1, 1));
		text.setLineWrap(true);
		text.setText(str);
		tempTextPanel.add(text);
	}

	/**
	 * Find algorithm.
	 */
	private static void find() {

		try {
			String string = textField.getText();

			if (string != null) {
				String search = text.getText();

				boolean endSearch = false;

				while (!endSearch) {
					if (caseSensi) {
						index = search.indexOf(string, initial);
					} else {
						index = search.toLowerCase(Locale.US)
								.indexOf(string.toLowerCase(Locale.US), initial);
					}

					if (index != -1) {
						endSearch = true;
						text.select(index, index + string.length());
						initial = text.getCaretPosition();
					} else {
						endSearch = true;
						JOptionPane.showMessageDialog(null, "\"" + string + "\"" + " not found ");
					}
				}
			}
		} catch (Exception e) {
			System.out.println("No textfield found.");
			e.printStackTrace();
		}
	} // end find algorithm

	/**
	 * All button listener.
	 */
	private static void buttonListener() {

		// find button listener
		findButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				find();

			}
		});

		// check box listener
		checkBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				if (checkBox.isSelected()) {
					caseSensi = true;
				} else {
					caseSensi = false;
				}
			}
		});
	} // end buttonListener
} // end Find class
