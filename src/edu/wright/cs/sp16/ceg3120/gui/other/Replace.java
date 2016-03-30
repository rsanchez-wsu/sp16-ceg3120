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
 * Replace JDialog implementation.
 * 
 * @author Devesh Amin
 *
 */
public class Replace extends JDialog {

	private static final long serialVersionUID = 355739661658564404L;
	private static boolean caseSensi;
	private static JFrame frame = null;
	private JLabel findlbl = new JLabel("Find: ");
	private JLabel replacelbl = new JLabel("Replace: ");
	private static JTextField wordToFind = new JTextField(10);
	private static JTextField wordToReplace = new JTextField(10);
	private static JTextArea textArea = new JTextArea(10, 10);
	private static JCheckBox caseSensitiveBox = new JCheckBox("Case Sensitive");
	private static JButton findBtn = new JButton("Find Next");
	private static JButton replaceBtn = new JButton("Replace");
	private static JButton replaceAllBtn = new JButton("Relpace All");
	private static JButton closeBtn = new JButton("Close");

	private JPanel tempTextPanel = new JPanel();
	String str = "This is a temporary JTextArea. \nThis doesn't work completely.";

	static int initial;
	static int index;

	/**
	 * Constructor for Replace.
	 */
	public Replace() {
		super(frame, "Replace");

		// panel to add all the labels and textfields and their position
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(3, 2));
		textPanel.add(findlbl);
		textPanel.add(wordToFind);
		textPanel.add(replacelbl);
		textPanel.add(wordToReplace);
		textPanel.add(caseSensitiveBox);
		getContentPane().add(textPanel, BorderLayout.NORTH);

		// panel to add all the button and their position
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 4));
		buttonPanel.add(findBtn);
		buttonPanel.add(replaceBtn);
		buttonPanel.add(replaceAllBtn);
		buttonPanel.add(closeBtn);
		// close button listener - can't have this static
		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
			}
		});

		getContentPane().add(buttonPanel, BorderLayout.CENTER);

		createFakeText();
		getContentPane().add(tempTextPanel, BorderLayout.SOUTH);

		// size of entire frame
		setSize(400, 150);

		// call button listener to make button work
		buttonListener();
	} // end Replace constructor

	/**
	 * Just a temp text panel and position.
	 */
	private void createFakeText() {
		tempTextPanel.setLayout(new GridLayout(1, 1));
		textArea.setLineWrap(true);
		textArea.setText(str);
		tempTextPanel.add(textArea);
	}

	/**
	 * Find algorithm.
	 */
	private static void find() {
		try {
			String string = wordToFind.getText();

			if (string != null) {
				String search = textArea.getText();

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
						textArea.select(index, index + string.length());
						initial = textArea.getCaretPosition();
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
	} // end find

	/**
	 * ReplaceAll algorithm.
	 */
	private static void replaceAll() {

		String string = wordToFind.getText();
		if (string != null) {
			String search = textArea.getText();
			String replacing = wordToReplace.getText();
			if (replacing.length() > 0) {
				if (caseSensi) {
					index = search.indexOf(string, initial);
				} else {
					index = search.toLowerCase(Locale.US)
							.indexOf(string.toLowerCase(Locale.US), initial);
				}
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "\"" + string + "\"" + " not found ");
				} else {
					while (index != -1) {
						int end = index + string.length();
						textArea.replaceRange(replacing, index, end);
						initial = initial + replacing.length() + 1;
						search = textArea.getText();
						index = search.indexOf(string, initial);
					} // end while
				}
			} // end first inner if
		} // end most outer if
	} // end replaceAll

	/**
	 * Replace algorithm.
	 */
	private static void replace() {

		String string = wordToFind.getText();
		if (string != null) {
			String replacer = wordToReplace.getText();
			if (index >= 0 && replacer.length() > 0) {
				int end = index + string.length();
				textArea.replaceRange(replacer, index, end);
				initial = textArea.getCaretPosition();
			}
		}
	} // end replace

	/**
	 * Make all the button listen and work.
	 */
	private static void buttonListener() {
		// find button listener
		findBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				find();
			}
		});

		// replaceAll button listener
		replaceAllBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				replaceAll();
			}
		});

		// replace button Listener
		replaceBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				replace();

			}
		});

		// case sensitive combo box listener
		caseSensitiveBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				if (caseSensitiveBox.isSelected()) {
					caseSensi = true;
				} else {
					caseSensi = false;
				}
			}
		});
	} // end buttonListener;

} // end Replace class
