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

package edu.wright.cs.sp16.ceg3120.gui.tabs.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NewConnectionFavorites extends JPanel {
	

	/**
	 * Generated serial version UID.
	 */
	private static final long serialVersionUID = -5493957121395902521L;

	/**
	 * New connection Favorites Panel default constructor.
	 */
	public NewConnectionFavorites() {
		super(new GridBagLayout());
		
		initComponents();
	}
	
	/**
	 * New connection Favorites Panel default constructor.
	 */
	public NewConnectionFavorites(List<String> fav) {
		super(new GridBagLayout());
		
		favorites = fav;
		
		initComponents();
		
		displaySubComponents();
	}
	
	/**
	 * Initialize sub components.
	 */
	void initComponents(){
		title = new JLabel("Favorite connections");
		
		// Is it dirty to test if something has been initialized?
		if(favorites != null && favorites.size() > 0) {
			favoriteConnectionButtons = new ArrayList<JButton>();
			
			for(int i = 0; i < favorites.size(); i++) {
				favoriteConnectionButtons.add((new JButton("Favorite connection: " + i)));
			}
		} 
		else {
			noFavoritesLabel = new JLabel("No favorite connections");
		}
	}
	
	/**
	 * Display sub components.
	 */
	void displaySubComponents() {
		
		setBorder(BorderFactory.createLineBorder(getBackground()));
		
		subConstraints = new GridBagConstraints();
		subConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		subConstraints.gridx = 0;
		subConstraints.gridy = 0;
		subConstraints.weightx = 0.5;
		subConstraints.weighty = 0.1;
		subConstraints.insets = new Insets(0, 10, 0, 0);
		
		// display this panels title
		add(title, subConstraints);
		
		// display favorite connection buttons
		for(int i = 0; i < favoriteConnectionButtons.size(); i++) {
			
			subConstraints = new GridBagConstraints();
			subConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
			subConstraints.gridx = 0;
			subConstraints.gridy = i + 1;
			subConstraints.weightx = 0.5;
			subConstraints.weighty = 0.1;
			subConstraints.insets = new Insets(0, 10, 0, 0);
			
			add(favoriteConnectionButtons.get(i), subConstraints);
		}
	}
	
	/**
	 * Constraints for grid bag layout.
	 */
	GridBagConstraints subConstraints;
	
	/**
	 * Title for this panel.
	 */
	JLabel title;
	
	/**
	 * List to hold favorite connections.
	 */
	List<String> favorites;
	
	/**
	 * List of buttons to link to favorite connection windows.
	 */
	List<JButton> favoriteConnectionButtons;
	
	/**
	 * Label to display if there are no current favorites.
	 */
	JLabel noFavoritesLabel;
}
