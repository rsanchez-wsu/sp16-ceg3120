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
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;



/**
 * Replace JDialog implementation.
 * @author Devesh Patel
 *
 */
public class Replace extends JFrame {

	private static final long serialVersionUID = 355739661658564404L;
	private static boolean caseSensi;
	private JLabel findlbl = new JLabel("Find: ");
	private JLabel replacelbl = new JLabel("Replace: ");
	private static JTextField wordToFind = new JTextField(10);
	private static JTextField wordToReplace = new JTextField(10);
	private static JTextArea textArea = new JTextArea(10,10);
	private static JCheckBox caseSensitiveBox = new JCheckBox("Case Sensitive");
	private static JButton findnextBtn = new JButton("Find/Find Next");
	private static JButton replaceBtn = new JButton("Replace");
	private static JButton replaceAllBtn = new JButton("Relpace All");
	private static JButton closeBtn = new JButton("Close");
	
	private JPanel tempTextPanel = new JPanel();
	String str = "This is a temporary JTextArea. \nThis doesn't work completely.";
	
	static int initial;
	static int index;
	static String lastSearch = "";
	
	/**
	 * Constructor for Replace.
	 */
	public Replace() {
		super("Replace");
		
		//panel to add all the labels and textfields and their position
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(3,2));
		textPanel.add(findlbl);
		textPanel.add(wordToFind);
		textPanel.add(replacelbl);
		textPanel.add(wordToReplace);
		textPanel.add(caseSensitiveBox);
		getContentPane().add(textPanel, BorderLayout.NORTH);
		
		//panel to add all the button and their position
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,4));
		buttonPanel.add(findnextBtn);
		buttonPanel.add(replaceBtn);	
		buttonPanel.add(replaceAllBtn);	
		buttonPanel.add(closeBtn);
		//close button listener - can't have this static
		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
				dispose();
			}
		});
		
		getContentPane().add(buttonPanel, BorderLayout.CENTER);

		createFakeText();
		getContentPane().add(tempTextPanel, BorderLayout.SOUTH);
				
		//size of entire frame
		setSize(400,150);
		
		//call button listener to make button work
		buttonListener();
	} // end Replace constructor
	
	/**
	 * Just a temp text panel and position.
	 */
	private void createFakeText() {
		tempTextPanel.setLayout(new GridLayout(1,1));
		textArea.setLineWrap(true);
		textArea.setText(str);
		tempTextPanel.add(textArea);
	}
	
	/**
	 * Find/Find Next algorithm.
	 */
	private static void find() {
		try {
			String string = wordToFind.getText();
			Highlighter highlighter = textArea.getHighlighter();
			highlighter.removeAllHighlights();
			if (string != null) {
				String search = textArea.getText();
				if (!lastSearch.equals(string)) {
					initial = 0;
				}
				lastSearch = string;
				boolean endSearch = false;
				
				while (!endSearch) {
					index = 0;
					if (caseSensi) {
						index = search.indexOf(string, initial);
					} else {
						index = search.toLowerCase(Locale.US)
								.indexOf(string.toLowerCase(Locale.US), initial);
					}
					
					if (index != -1) {
						
						HighlightPainter painter = 
								new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
						highlighter.addHighlight(index, index + string.length(), painter);
						textArea.select(index, index + string.length());
						endSearch = true;
						initial = index + 1;
					} else {
						endSearch = true;
						JOptionPane.showMessageDialog(null, 
								"\"" + string + "\"" + " not found ");
						initial = 0;
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
			if (!caseSensi) {
				search = search.toLowerCase(Locale.US);
			}
			String replacing = wordToReplace.getText();
			if (replacing.length() > 0) {
				search = search.replaceAll(string, replacing);
				textArea.setText(search);
			} // end first inner if
		} // end most outer if
	} //end replaceAll
	
	/**
	 * Replace algorithm.
	 */
	private static void replace() {
		textArea.replaceSelection(wordToReplace.getText());
	} // end replace
	
	/**
	 * Make all the button listen and work.
	 */
	private static void buttonListener() {
		//find button listener
		findnextBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				find();
			}
		});
		
		
		//replaceAll button listener
		replaceAllBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				replaceAll();
			}
		});
		
		//replace button Listener
		replaceBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				replace();
				
			}
		});
		
		//case sensitive combo box listener
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
	
} //end Replace class
