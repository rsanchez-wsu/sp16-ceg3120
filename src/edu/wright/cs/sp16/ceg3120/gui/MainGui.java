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

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
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
	private JMenuItem connect = null;
	private JMenuItem openItem;
	private MainTabPane tabPane = null;
	private JMenuItem saveItem = null;
	private JMenuItem newItem;
	//private StartPageTab startPage = null;
	private boolean isFullScreen = false;
	
	/**
	 * The constructor method that initializes the main application window.
	 */
	public MainGui() {
		super("SQLizard");
		
		setSize(960, 600);
		setLocationRelativeTo(null);
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
	
//	/**
//	 * FindBugs Error: 
//	 * Private method edu.wright.cs.sp16.ceg3120.gui.MainGui.createStartPage() is never called
//	 */
//	@SuppressWarnings("unused")
//	private void createStartPage() {
//		startPage = new StartPageTab();
//		
//		add(startPage);
//	}

	/**
	 * Creates the menu bar.
	 */
	private void createMenuBar() {
		
		// File menu
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		
		ImageIcon icon =  new ImageIcon("img/Open File Icon.gif");
		Image image = icon.getImage();
		Image newImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon = new ImageIcon(newImage);
		openItem = new JMenuItem("Open", icon);
		openItem.setToolTipText("Open SQL File");
		openItem.addActionListener(this);
		openItem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		ImageIcon icon2 =  new ImageIcon("img/New File Icon.png");
		Image image2 = icon2.getImage();
		Image newImage2 = image2.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(newImage2);
		newItem = new JMenuItem("New", icon2);
		newItem.setToolTipText("New SQL File");
		//newItem.addActionListener(this);
		newItem.setCursor(new Cursor(Cursor.HAND_CURSOR));

		
		ImageIcon icon3 =  new ImageIcon("img/Save File Icon.png");
		Image image3 = icon3.getImage();
		Image newImage3 = image3.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon3 = new ImageIcon(newImage3);
		saveItem = new JMenuItem("Save", icon3);
		saveItem.setToolTipText("Save SQL File");
		saveItem.addActionListener(this);
		saveItem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		Action printAction = new DefaultEditorKit.CutAction();
		printAction.putValue(Action.NAME, "Print");

		exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic(KeyEvent.VK_E);
		exitItem.setToolTipText("Exit application");
		exitItem.addActionListener(this);
		exitItem.setCursor(new Cursor(Cursor.HAND_CURSOR));

		file.add(openItem);
		file.add(newItem);
		file.add(saveItem);
		file.add(printAction).setCursor(new Cursor(Cursor.HAND_CURSOR));
		file.add(exitItem);
		file.setCursor(new Cursor(Cursor.HAND_CURSOR));


		// Edit menu
		
		Action cutAction = new DefaultEditorKit.CutAction();
		cutAction.putValue(Action.NAME, "Cut");
		
		Action copyAction = new DefaultEditorKit.CopyAction();
		copyAction.putValue(Action.NAME, "Copy");
		
		Action pasteAction = new DefaultEditorKit.PasteAction();
		pasteAction.putValue(Action.NAME, "Paste");

		JMenu edit = new JMenu("Edit");
		
		edit.add(cutAction).setCursor(new Cursor(Cursor.HAND_CURSOR));
		edit.add(copyAction).setCursor(new Cursor(Cursor.HAND_CURSOR));
		edit.add(pasteAction).setCursor(new Cursor(Cursor.HAND_CURSOR));
		edit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		// Search menu
		
		Action topAction = new DefaultEditorKit.CutAction();
		topAction.putValue(Action.NAME, "Top");
		
		Action bottomAction = new DefaultEditorKit.CopyAction();
		bottomAction.putValue(Action.NAME, "Bottom");
		
		Action goToLineAction = new DefaultEditorKit.PasteAction();
		goToLineAction.putValue(Action.NAME, "Go To Line");
		
		Action findAction = new DefaultEditorKit.PasteAction();
		findAction.putValue(Action.NAME, "Find");

		Action replaceAction = new DefaultEditorKit.PasteAction();
		replaceAction.putValue(Action.NAME, "Replace");

		JMenu search = new JMenu("Search");
		
		search.add(topAction).setCursor(new Cursor(Cursor.HAND_CURSOR));
		search.add(bottomAction).setCursor(new Cursor(Cursor.HAND_CURSOR));
		search.add(goToLineAction).setCursor(new Cursor(Cursor.HAND_CURSOR));
		search.add(findAction).setCursor(new Cursor(Cursor.HAND_CURSOR));
		search.add(replaceAction).setCursor(new Cursor(Cursor.HAND_CURSOR));
		search.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		// Session menu
		
		Action newSessionAction = new DefaultEditorKit.CutAction();
		newSessionAction.putValue(Action.NAME, "New Session");
		
		connect = new JMenuItem("Connect To Database");
		ActionListener con = new ConWindow();
		connect.addActionListener(con);
		
		Action disconnectAction = new DefaultEditorKit.PasteAction();
		disconnectAction.putValue(Action.NAME, "Disconnect From Database");
		
		Action disconnectAllAction = new DefaultEditorKit.PasteAction();
		disconnectAllAction.putValue(Action.NAME, "Disconnect From All");
		
		Action driverAction = new DefaultEditorKit.PasteAction();
		driverAction.putValue(Action.NAME, "New Driver");

		JMenu session = new JMenu("Session");
		
		session.add(newSessionAction).setCursor(new Cursor(Cursor.HAND_CURSOR));
		session.add(connect).setCursor(new Cursor(Cursor.HAND_CURSOR));
		session.add(disconnectAction).setCursor(new Cursor(Cursor.HAND_CURSOR));
		session.add(disconnectAllAction).setCursor(new Cursor(Cursor.HAND_CURSOR));
		session.add(driverAction).setCursor(new Cursor(Cursor.HAND_CURSOR));
		session.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		// SQL menu
		
		Action executeAllAction = new DefaultEditorKit.CutAction();
		executeAllAction.putValue(Action.NAME, "Execute All");
		
		Action executeHighlightedAction = new DefaultEditorKit.CopyAction();
		executeHighlightedAction.putValue(Action.NAME, "Execute Highlighted");
		
		Action formatAction = new DefaultEditorKit.PasteAction();
		formatAction.putValue(Action.NAME, "Format SQL");
		
		Action commitAction = new DefaultEditorKit.PasteAction();
		commitAction.putValue(Action.NAME, "Commit SQL");

		Action rollbackAction = new DefaultEditorKit.PasteAction();
		rollbackAction.putValue(Action.NAME, "Rollback SQL");

		JMenu sql = new JMenu("SQL");
		
		sql.add(executeAllAction).setCursor(new Cursor(Cursor.HAND_CURSOR));
		sql.add(executeHighlightedAction).setCursor(new Cursor(Cursor.HAND_CURSOR));
		sql.add(formatAction).setCursor(new Cursor(Cursor.HAND_CURSOR));
		sql.add(commitAction).setCursor(new Cursor(Cursor.HAND_CURSOR));
		sql.add(rollbackAction).setCursor(new Cursor(Cursor.HAND_CURSOR));
		sql.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		// Window menu

		fullScreenItem = new JMenuItem("Full Screen");
		fullScreenItem.setMnemonic(KeyEvent.VK_F);
		fullScreenItem.setToolTipText("Make application full screen");
		fullScreenItem.addActionListener(this);
		fullScreenItem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		JMenu window = new JMenu("Window");
		window.add(fullScreenItem);
		window.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		// Help menu
		final JMenu help = new JMenu("Help");
		help.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		help.add("Welcome").addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				//disable the main window
				makeDisabled();
				//create a new frame About and set its properties
				JFrame frameWelcome = new JFrame("Welcome to SQLizard"); 
				JLabel labelName = new JLabel("SQLizard");
				JLabel labelVersion = new JLabel("Version: 0.0.0.0");

				frameWelcome.getContentPane().add(labelName);
				frameWelcome.getContentPane().add(labelVersion);
				
				frameWelcome.setSize(300, 300);
				frameWelcome.setLocationRelativeTo(null);
				frameWelcome.setVisible(true);
				frameWelcome.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent we) {
						makeEnabled();
					}
				});
			}
		});
		
		help.addSeparator();
		help.add("About SQLizard").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				aboutSqliz();
				
			}
		});
		//TODO: Decide what to include in Help Menu

		JMenuBar menuBar = new JMenuBar();

		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(search);
		menuBar.add(session);
		menuBar.add(sql);
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
			if (isFullScreen == false) {
				isFullScreen = true;
				fullScreenItem.setText("Undo Full Screen");
				fullScreenItem.setToolTipText("Reset application to original size");
				Toolkit tk = Toolkit.getDefaultToolkit();
				int width = ((int) tk.getScreenSize().getWidth());
				int height = ((int) tk.getScreenSize().getHeight());
				setSize(width, height);
				setLocation(0, 0);
			} else {
				isFullScreen = false;
				fullScreenItem.setText("Full Screen");
				fullScreenItem.setToolTipText("Make application full screen");
				setSize(960, 600);
			}
		} else if (actionEvent.getSource().equals(openItem)) {
			
			// JFileChooser to browse and open the sql file
			// Waiting on Team 3 to get the SQL code window implemented 
			// so that we can actually write/read files (this isn't fully complete yet)
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("SQL FILES", "sql");
			fileChooser.setFileFilter(filter);
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = fileChooser.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				File openedFile = fileChooser.getSelectedFile();
				System.out.println("Opened File: " + openedFile.getAbsolutePath());
			}
		} else if (actionEvent.getSource().equals(saveItem)) {
			//@author: Devesh Amin
			//Save the SQL File in the local system using JFileChooser

			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("SQL FILES", "sql");
			fileChooser.setFileFilter(filter);
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			fileChooser.setDialogTitle("Save");
			int selectFile = fileChooser.showSaveDialog(this);
			
			if (selectFile == JFileChooser.APPROVE_OPTION) {
				File savedFile = fileChooser.getSelectedFile();
				System.out.println("Save file: " + savedFile.getAbsolutePath());
			}
		}
	}
	
	
	
	/**
	 * Disables the main window.
	 */
	public void makeDisabled() {
		setEnabled(false);
	}
	
	/**
	 * Enables the main window.
	 */
	public void makeEnabled() {
		setEnabled(true);
	}
	
	/**
	 * AboutSQLizard JMenuItem.
	 */
	public void aboutSqliz() {
		
		JPanel aboutPanel = new JPanel();
		JOptionPane.showMessageDialog(aboutPanel, 
				"SQLizard IDE for Databases."
				+ "\n\n"
				+ "Version: Lizard.0 Release (0.0.0)\n"
				+ "Build id: 00000000-0000"
				+ "\n\n"
				+ "(c) Copyright SQLizard contributors and others 2016. "
				+ "All rights reserved."
				+ "\nSQLizard and the SQLizard logo are "
				+ "trademarks of the SQLizard Foundation, Inc.,"
				+ "\nThe SQLizard logo cannot be altered without SQLizard's permission. "
				+ "SQLizard logos are provided for use "
				+ "under the SQLizard logo and trademark guidelines. "
				+ "\nOracle and Java are trademarks or registered "
				+ "trademarks of Oracle and/or its affiliates. "
				+ "Other names may be trademarks of their respective owners."
				+ "\n\nThis product includes software developed by other open "
				+ "source projects including "
				+ "the Apache Software Foundation, https://www.apache.org/.", 
				"About SQLizard", 
				JOptionPane.INFORMATION_MESSAGE);
	}

}
