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

import edu.wright.cs.sp16.ceg3120.gui.tabs.components.NewConnectionDetailsPane;
import edu.wright.cs.sp16.ceg3120.gui.tabs.components.NewConnectionFavorites;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * The tab that contains all the components for creating a new connection.
 * 
 * @author cody
 *
 */
public class NewConnectionTab extends JPanel {

	private static final long serialVersionUID = -2518312376192094011L;

	/**
	 * Default constructor, initializes components.
	 */
	public NewConnectionTab() {
		super(new GridBagLayout());

		initComponents();
	}

	/**
	 * TODO: create all components for this window and initialize them here.
	 */
	private void initComponents() {

		// dummy list of favorite connections
		List<String> dummyFavoriteList = Arrays.asList("1", "2", "3");
		
		NewConnectionFavorites favPane = new NewConnectionFavorites(dummyFavoriteList);
		
		favPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		subConstraints = new GridBagConstraints();
		subConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		subConstraints.gridx = 0;
		subConstraints.gridy = 0;
		subConstraints.insets = new Insets(0, 0, 0, 30);
		
		add(favPane);
		
		NewConnectionDetailsPane pane = new NewConnectionDetailsPane();
		
		pane.setBorder(BorderFactory.createLineBorder(Color.black));
		
		subConstraints = new GridBagConstraints();
		subConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
		subConstraints.gridx = 1;
		subConstraints.gridy = 0;
		subConstraints.insets = new Insets(0, 50, 0, 50);
		
		add(pane);
	}
	
	/**
	 * Constraints for grid bag layout.
	 */
	GridBagConstraints subConstraints;
}
