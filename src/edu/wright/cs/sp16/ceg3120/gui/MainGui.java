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

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.text.DefaultEditorKit;

/**
 * The Frame that holds the application and all the interactions to user.
 * 
 * @author codybutz
 */
public class MainGui extends JFrame implements ActionListener {

	private static final long serialVersionUID = -24143968339746394L;
	
	private JMenuItem exitItem = null;
	private JMenuItem fullScreenItem = null;
	private MainTabPane tabPane = null;
	
	/**
	 * The constructor method that initializes the main application window.
	 */
	public MainGui() {
		super("SQLizard");
		
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
	 * Creates the tab pane that holds all the tabs for the application.
	 */
	private void createTabPane() {
		tabPane = new MainTabPane();
		
		add(tabPane);
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
		
		Action cutAction = new DefaultEditorKit.CutAction();
		cutAction.putValue(Action.NAME, "Cut");
		
		Action copyAction = new DefaultEditorKit.CopyAction();
		copyAction.putValue(Action.NAME, "Copy");
		
		Action pasteAction = new DefaultEditorKit.PasteAction();
		pasteAction.putValue(Action.NAME, "Paste");

		JMenu edit = new JMenu("Edit");
		
		edit.add(cutAction);
		edit.add(copyAction);
		edit.add(pasteAction);
		
		// Window menu

		fullScreenItem = new JMenuItem("Full Screen");
		fullScreenItem.setMnemonic(KeyEvent.VK_F);
		fullScreenItem.setToolTipText("Make application full screen");
		fullScreenItem.addActionListener(this);

		JMenu window = new JMenu("Window");
		window.add(fullScreenItem);
		
		// Help menu
		JMenu help = new JMenu("Help");
		help.add("Welcome");
		help.add("About");
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
			// Close application
			
			setVisible(false);
			dispose();
		} else if (actionEvent.getSource().equals(fullScreenItem)) {
			// Make application fullscreen.
			
			Toolkit tk = Toolkit.getDefaultToolkit();
			int width = ((int) tk.getScreenSize().getWidth());
			int height = ((int) tk.getScreenSize().getHeight());
			setSize(width, height);
			setLocation(0, 0);
		}
	}

}
