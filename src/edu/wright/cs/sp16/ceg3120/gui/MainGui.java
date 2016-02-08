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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * The Frame that holds the application and all the interactions to user.
 * 
 * @author codybutz
 */
public class MainGui extends JFrame implements ActionListener {

	private static final long serialVersionUID = -24143968339746394L;
	
	private JMenuItem exitItem = null;
	
	/**
	 * The constructor method that initializes the main application window.
	 */
	public MainGui() {
		super("Sequel Master");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(960, 600);
		initComponents();
	}
	
	/**
	 * The main method that configures the main application window.
	 */
	private void initComponents() {
		createMenuBar();
		
		createTabPane();
	}
	
	/**
	 * Derp.
	 */
	private void createTabPane() {
		
	}

	/**
	 * Creates the menu bar.
	 */
	private void createMenuBar() {
		
		// File menu
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);

		exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic(KeyEvent.VK_E);
		exitItem.setToolTipText("Exit application");
		exitItem.addActionListener(this);

		file.add(exitItem);

		// Edit menu
		JMenu edit = new JMenu("Edit");
		
		//TODO: Decide what to include in Edit Menu
		// - Copy
		// - Paste
		// - Cut
		
		// Window menu
		JMenu window = new JMenu("Window");

		//TODO: Decide what to include in Window Menu
		// - Full Screen
		
		// Help menu
		JMenu help = new JMenu("Help");

		//TODO: Decide what to include in Help Menu

		JMenuBar menuBar = new JMenuBar();

		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(window);
		menuBar.add(help);
		
		setJMenuBar(menuBar);
	}

	/**
	 * Handles all actions on JMenu and any other actions that should be based in the Base Gui.
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource().equals(exitItem)) {
			setVisible(false);
			dispose();
		}
	}

}
