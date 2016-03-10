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

package edu.wright.cs.sp16.ceg3120.gui.tabs.startpagecomponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * "Tip of the day" pane on the start page.
 * This pane will be used to hold:
 * -Learn and Discover button
 * -"Tip of the day" label
 * -"Tip of the day" text
 * TODO:
 * -Create link for "Learn and Discover" button
 * -Update "Tip of the day" text to be something real
 * @author Sam
 *
 */
public class TipOfTheDayPane extends JPanel {

	private static final long serialVersionUID = -8610458384089735858L;
	
	/**
	 * Initialize "Tip of the Day" panel.
	 */
	public TipOfTheDayPane() {
		super(new GridBagLayout());
		
		initComponents();
	}
	
	/**
	 * Initialize this panes components.
	 * Components:
	 * "Learn and Discover" button
	 * "Tip of the Day" label
	 * "Tip of the day" text
	 */
	public void initComponents() {
		// setting border and background color for debug 
		setBorder(BorderFactory.createLineBorder(Color.black, 5));
		
		tipTitle = new JLabel("Tip of the day");
		tipTitle.setFont(new Font("TimesRoman", Font.BOLD, 24));
		
		// set size and positioning of components
		GridBagConstraints subConstraints = new GridBagConstraints();
		subConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		subConstraints.gridx = 0;
		subConstraints.gridy = 0;
		subConstraints.weightx = 0.5;
		subConstraints.weighty = 0.5;
		subConstraints.insets = new Insets(0, 10, 0, 0);
		
		add(tipTitle, subConstraints);
		
		learnDiscoverBtn = new JButton("Learn & Discover");
		learnDiscoverBtn.setFont(new Font("TimesRoman", Font.BOLD, 12));
		
		subConstraints = new GridBagConstraints();
		subConstraints.anchor = GridBagConstraints.PAGE_START;
		subConstraints.gridx = 0;
		subConstraints.gridy = 1;
		subConstraints.weightx = 0.5;
		subConstraints.weighty = 5.5;
		
		add(learnDiscoverBtn, subConstraints);
		
		String dummyTipText = "";
		
		for (int i = 0; i < 10; i++) {
			dummyTipText += "alskdfjalsdfjalsdkfj\n";
		}
		
		tipOfTheDayTxt = new JTextArea(dummyTipText);
		tipOfTheDayTxt.setFont(new Font("TimesRoman", Font.BOLD, 12));
		
		subConstraints = new GridBagConstraints();
		subConstraints.anchor = GridBagConstraints.PAGE_START;
		subConstraints.gridx = 0;
		subConstraints.gridy = 2;
		subConstraints.weightx = 0.5;
		subConstraints.weighty = 4.5;
		
		add(tipOfTheDayTxt, subConstraints);
	}
	
	/* properties */
	
	String tipText;
	
	// tip of the day label
	JLabel tipTitle;
	
	// learn and discover button
	JButton learnDiscoverBtn;
	
	// tip of the day text
	JTextArea tipOfTheDayTxt;
	
	/* property access */
	
	/**
	 * Get "tip of the day" text.
	 * 
	 * @return String tipText: tip of the day text.
	 */
	public String getTipText() {
		return tipText;
	}
	
	/**
	 * Sets the text for tip of the day.
	 * 
	 * @param str String you would like to set the tip of the day too.
	 */
	public void setTipText(String str) {
		tipText = str;
	}
	
	/**
	 * @return "Tip of the day" label.
	 */
	public JLabel getTipTitle() {
		return tipTitle;
	}

	/**
	 * Set "Tip of the Day" label.
	 * 
	 * @param label JLabel to replace "Tip of the day" label.
	 */
	public void setTipTitle(JLabel label) {
		tipTitle = label;
	}
	
	/**
	 * @return "Learn And Discover" button.
	 */
	public JButton getLearnDiscoverBtn() {
		return learnDiscoverBtn;
	}

	/**
	 * Set "Learn And Discover" button.
	 * 
	 * @param btn JButton to replace "Learn And Discover" button.
	 */
	public void setLearnDiscoverBtn(JButton btn) {
		learnDiscoverBtn = btn;
	}
	
	/**
	 * Gets the "Tip of the day" text area component.
	 * 
	 * @return JTextArea tipOfTheDayTxt
	 */
	public JTextArea getTipOfTheDayTxt() {
		return tipOfTheDayTxt;
	}
	
	/**
	 * 
	 * @param txt JTextArea to replace "Tip of the day" text.
	 */
	public void setTipOfTheDayTxt(JTextArea txt) {
		tipOfTheDayTxt = txt;
	}
	
}
