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

import edu.wright.cs.sp16.ceg3120.gui.other.FindWindow;
import edu.wright.cs.sp16.ceg3120.gui.other.ReplaceWindow;
import edu.wright.cs.sp16.ceg3120.gui.tabs.PreferencesPanel;
import edu.wright.cs.sp16.ceg3120.gui.tabs.Queries;

import java.awt.Component;
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
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	private JMenuItem saveAsItem = null;
	private JMenuItem newItem;
	private JMenuItem printItem;
	private JMenuItem disconnectItem;
	private JMenuItem topItem;
	private JMenuItem bottomItem;
	private JMenuItem findItem;
	private JMenuItem cutItem;
	private JMenuItem copyItem;
	private JMenuItem pasteItem;
	private JMenuItem replaceItem;
	//TODO decide if this is important
	private JMenuItem mntmPreferences;
	private JMenuItem mntmQueries;

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

	/**
	 * Creates the menu bar.
	 */
	private void createMenuBar() {

		// File menu
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);

		ImageIcon openIcon = new ImageIcon("img/Open File Icon.png");
		Image openImage = openIcon.getImage();
		Image newOpenImage = openImage.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		openIcon = new ImageIcon(newOpenImage);
		openItem = new JMenuItem("Open", openIcon);
		openItem.setToolTipText("Open SQL File");
		openItem.addActionListener(this);
		openItem.setCursor(new Cursor(Cursor.HAND_CURSOR));

		ImageIcon newFileIcon = new ImageIcon("img/New File Icon.png");
		Image newFileImage = newFileIcon.getImage();
		Image newFileImageTwo = newFileImage.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		newFileIcon = new ImageIcon(newFileImageTwo);
		newItem = new JMenuItem("New", newFileIcon);
		newItem.setToolTipText("New SQL File");
		newItem.setCursor(new Cursor(Cursor.HAND_CURSOR));

		ImageIcon saveIcon = new ImageIcon("img/Save File Icon.png");
		Image saveImage = saveIcon.getImage();
		Image newSaveImage = saveImage.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
		saveIcon = new ImageIcon(newSaveImage);
		saveItem = new JMenuItem("Save", saveIcon);
		saveItem.setToolTipText("Save SQL File");
		saveItem.addActionListener(this);
		saveItem.setCursor(new Cursor(Cursor.HAND_CURSOR));

		ImageIcon saveAsIcon = new ImageIcon("img/Save As Icon.png");
		Image saveAsImage = saveAsIcon.getImage();
		Image newSaveAsImage = saveAsImage.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		saveAsIcon = new ImageIcon(newSaveAsImage);
		saveAsItem = new JMenuItem("Save As", saveAsIcon);
		saveAsItem.setToolTipText("Save SQL File As");
		saveAsItem.addActionListener(this);
		saveAsItem.setCursor(new Cursor(Cursor.HAND_CURSOR));

		ImageIcon printIcon = new ImageIcon("img/Print Icon.png");
		Image printImage = printIcon.getImage();
		Image newPrintImage = printImage.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		printIcon = new ImageIcon(newPrintImage);
		printItem = new JMenuItem("Print", printIcon);
		printItem.setToolTipText("Send file/code to printer");
		printItem.addActionListener(this);
		printItem.setCursor(new Cursor(Cursor.HAND_CURSOR));

		exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic(KeyEvent.VK_E);
		exitItem.setToolTipText("Exit application");
		exitItem.addActionListener(this);
		exitItem.setCursor(new Cursor(Cursor.HAND_CURSOR));

		file.add(openItem);
		file.add(newItem);
		file.add(saveItem);
		file.add(saveAsItem);
		file.add(printItem);
		file.add(exitItem);
		file.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// Edit menu
		ImageIcon cutIcon = new ImageIcon("img/Cut Icon.png");
		Image cutImage = cutIcon.getImage();
		Image newCutImage = cutImage.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		cutIcon = new ImageIcon(newCutImage);
		cutItem = new JMenuItem("Cut", cutIcon);
		cutItem.setToolTipText("Cut text");
		cutItem.addActionListener(this);
		cutItem.setCursor(new Cursor(Cursor.HAND_CURSOR));

		ImageIcon copyIcon = new ImageIcon("img/Copy Icon.png");
		Image copyImage = copyIcon.getImage();
		Image newCopyImage = copyImage.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		copyIcon = new ImageIcon(newCopyImage);
		copyItem = new JMenuItem("Copy", copyIcon);
		copyItem.setToolTipText("Copy text");
		copyItem.addActionListener(this);
		copyItem.setCursor(new Cursor(Cursor.HAND_CURSOR));

		ImageIcon pasteIcon = new ImageIcon("img/Paste Icon.png");
		Image pasteImage = pasteIcon.getImage();
		Image newPasteImage = pasteImage.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		pasteIcon = new ImageIcon(newPasteImage);
		pasteItem = new JMenuItem("Paste", pasteIcon);
		pasteItem.setToolTipText("Paste text");
		pasteItem.addActionListener(this);
		pasteItem.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JMenu edit = new JMenu("Edit");

		edit.add(cutItem);
		edit.add(copyItem);
		edit.add(pasteItem);
		edit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//Preferences Panel
		mntmPreferences = new JMenuItem("Preferences");
		mntmPreferences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent preferences) {
				String paneTitle = "User Preferences";
				int index = tabPane.indexOfTab(paneTitle);
				if (index == -1) {
					JButton btnClose = new JButton("Close");
					btnClose.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							Component selected = tabPane.getSelectedComponent();
								if (selected != null) {
									tabPane.remove(selected);
								}
							}
					});
					btnClose.setVisible(true);
					PreferencesPanel preferences1 = new PreferencesPanel(btnClose);
					preferences1.add(btnClose);
					
					tabPane.addTab(paneTitle, preferences1);
				}
			}
		});
		edit.add(mntmPreferences);
		
		//Queries History panel
		mntmQueries = new JMenuItem("Recent Queries");
		mntmQueries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent queries) {
				//TODO ??
				int index = tabPane.indexOfTab("Recent Queries");
				if (index == -1) {
					JButton btnClose = new JButton("Close");
					btnClose.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							Component selected = tabPane.getSelectedComponent();
								if (selected != null) {
									tabPane.remove(selected);
								}
							}
					});
					btnClose.setVisible(true);

					Queries queries1 = new Queries(btnClose);
					queries1.add(btnClose);
					tabPane.addTab("Recent Queries", queries1);

				}
			}
		});
		edit.add(mntmQueries);

		// Search menu

		Action topAction = new DefaultEditorKit.CutAction();
		topAction.putValue(Action.NAME, "Top");

		ImageIcon topIcon = new ImageIcon("img/Top Icon.png");
		Image topImage = topIcon.getImage();
		Image newTopImage = topImage.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		topIcon = new ImageIcon(newTopImage);
		topItem = new JMenuItem("Top", topIcon);
		topItem.setToolTipText("Go to top of file");
		topItem.addActionListener(this);

		ImageIcon bottomIcon = new ImageIcon("img/Bottom Icon.png");
		Image bottomImage = bottomIcon.getImage();
		Image newBottomImage = bottomImage.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		bottomIcon = new ImageIcon(newBottomImage);
		bottomItem = new JMenuItem("Bottom", bottomIcon);
		bottomItem.setToolTipText("Go to bottom of file");
		bottomItem.addActionListener(this);

		Action goToLineAction = new DefaultEditorKit.PasteAction();
		goToLineAction.putValue(Action.NAME, "Go To Line");

		ImageIcon findIcon = new ImageIcon("img/Find Icon.png");
		Image findImage = findIcon.getImage();
		Image newFindImage = findImage.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		findIcon = new ImageIcon(newFindImage);
		findItem = new JMenuItem("Find", findIcon);
		findItem.setToolTipText("Search for keyword in the file");
		ActionListener findA = new FindWindow();
		findItem.addActionListener(findA);

		ImageIcon replaceIcon = new ImageIcon("img/Replace Icon.png");
		Image replaceImage = replaceIcon.getImage();
		Image newReplaceImage = replaceImage.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		replaceIcon = new ImageIcon(newReplaceImage);
		replaceItem = new JMenuItem("Replace", replaceIcon);
		replaceItem.setToolTipText("Replace characters or strings");
		ActionListener replaceA = new ReplaceWindow();
		replaceItem.addActionListener(replaceA);

		JMenu search = new JMenu("Search");

		search.add(topItem).setCursor(new Cursor(Cursor.HAND_CURSOR));
		search.add(bottomItem).setCursor(new Cursor(Cursor.HAND_CURSOR));
		search.add(goToLineAction).setCursor(new Cursor(Cursor.HAND_CURSOR));
		search.add(findItem).setCursor(new Cursor(Cursor.HAND_CURSOR));
		search.add(replaceItem).setCursor(new Cursor(Cursor.HAND_CURSOR));
		search.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// Session menu

		Action newSessionAction = new DefaultEditorKit.CutAction();
		newSessionAction.putValue(Action.NAME, "New Session");

		ImageIcon connectIcon = new ImageIcon("img/Connect Icon.png");
		Image connectImage = connectIcon.getImage();
		Image newConnectImage = connectImage.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		connectIcon = new ImageIcon(newConnectImage);
		connect = new JMenuItem("Connect To Database", connectIcon);
		connect.setToolTipText("Login and connect to a database");
		connect.addActionListener(this);

		ImageIcon disconnectIcon = new ImageIcon("img/Disconnect Icon.png");
		Image disconnectImage = disconnectIcon.getImage();
		Image newDisconnectImage = disconnectImage.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		disconnectIcon = new ImageIcon(newDisconnectImage);
		disconnectItem = new JMenuItem("Disconnect From Database", disconnectIcon);
		disconnectItem.setToolTipText("Close connection to the current database");
		disconnectItem.addActionListener(this);

		Action disconnectAllAction = new DefaultEditorKit.PasteAction();
		disconnectAllAction.putValue(Action.NAME, "Disconnect From All");

		Action driverAction = new DefaultEditorKit.PasteAction();
		driverAction.putValue(Action.NAME, "New Driver");

		JMenu session = new JMenu("Session");

		session.add(newSessionAction).setCursor(new Cursor(Cursor.HAND_CURSOR));
		session.add(connect).setCursor(new Cursor(Cursor.HAND_CURSOR));
		session.add(disconnectItem).setCursor(new Cursor(Cursor.HAND_CURSOR));
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

		ImageIcon fullscreenIcon = new ImageIcon("img/Full Screen Icon.png");
		Image fullscreenImage = fullscreenIcon.getImage();
		Image newFullscreenImage = fullscreenImage.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
		fullscreenIcon = new ImageIcon(newFullscreenImage);
		fullScreenItem = new JMenuItem("Full Screen", fullscreenIcon);
		fullScreenItem.setMnemonic(KeyEvent.VK_F);
		fullScreenItem.setToolTipText("Make application full screen");
		fullScreenItem.addActionListener(this);
		fullScreenItem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		JMenu window = new JMenu("Window");
		window.add(fullScreenItem);
		window.setCursor(new Cursor(Cursor.HAND_CURSOR));
		JMenu help = new JMenu("Help");

		welcomeMenuItem = new JMenuItem("Welcome");
		welcomeMenuItem.addActionListener(this);

		help.add(welcomeMenuItem);

		help.addSeparator();

		aboutMenuItem = new JMenuItem("About");
		aboutMenuItem.addActionListener(this);

		help.add(aboutMenuItem);

		// >>>>>>> fc4ff12e2a0f8d6a84f7f5a572205343703e800a

		JMenuBar menuBar = new JMenuBar();

		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(search);
		menuBar.add(session);
		menuBar.add(sql);
		menuBar.add(window);
		menuBar.add(help);
		menuBar.add(Box.createHorizontalGlue());

		setJMenuBar(menuBar);
	}

	/**
	 * Handles all actions on JMenu and any other actions that should be based
	 * in the Base Gui.
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource().equals(exitItem)) {
			// Close application
			setVisible(false);
			dispose();
		} else if (actionEvent.getSource().equals(fullScreenItem)) {

			// Make application full screen
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
			// <<<<<<< HEAD
		} else if (actionEvent.getSource().equals(openItem)) {

			// JFileChooser to browse and open the sql file
			// Waiting on Team 3 to get the SQL code window implemented
			// so that we can actually write/read files (this isn't fully
			// complete yet)
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
			// @author: Devesh Amin
			// Save the SQL File in the local system using JFileChooser

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
			// ==z=====
		} else if (actionEvent.getSource().equals(aboutMenuItem)) {
			// create a new frame About and set its properties
			JFrame frameAbout = new JFrame("About");
			makeDisabled();
			JLabel labelName = new JLabel("About");
			JLabel labelVersion = new JLabel("Version 0.0.0.0");

			frameAbout.getContentPane().add(labelName);
			frameAbout.getContentPane().add(labelVersion);

			frameAbout.setSize(300, 300);
			frameAbout.setLocationRelativeTo(null);
			frameAbout.setVisible(true);
			frameAbout.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent ev) {
					makeEnabled();
				}
			});

		} else if (actionEvent.getSource().equals(connect)) {
			tabPane.addNewConnectionTab();
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

	// <<<<<<< HEAD
	/**
	 * AboutSQLizard JMenuItem.
	 */
	public void aboutSqliz() {

		JPanel aboutPanel = new JPanel();
		JOptionPane.showMessageDialog(aboutPanel, "SQLizard IDE for Databases." + "\n\n"
				+ "Version: Lizard.0 Release (0.0.0)\n" + "Build id: 00000000-0000" + "\n\n"
				+ "(c) Copyright SQLizard contributors and others 2016. " + "All rights reserved."
				+ "\nSQLizard and the SQLizard logo are " 
				+ "trademarks of the SQLizard Foundation, Inc.,"
				+ "\nThe SQLizard logo cannot be altered without SQLizard's permission. "
				+ "SQLizard logos are provided for use under the SQLizard "
				+ "logo and trademark guidelines. "
				+ "\nOracle and Java are trademarks or registered " 
				+ "trademarks of Oracle and/or its affiliates. "
				+ "Other names may be trademarks of their respective owners."
				+ "\n\nThis product includes software developed by other open " 
				+ "source projects including "
				+ "the Apache Software Foundation, https://www.apache.org/.", "About SQLizard",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * connectionTutorialSqliz JMenuItem.
	 */
	public void connectionTutorialSqliz() {

		JPanel connectionTutorialPanel = new JPanel();
		JOptionPane.showMessageDialog(connectionTutorialPanel,
				"How to Set up a connection to a database?" + "\n\n" + "Step One: \n"
						+ "Click [Session] on the top menu bar" + "\n\n" + "Step Two: \n"
						+ "Click [Connect To Database] in the Session drop down menu" + "\n" 
						+ "Step Three: \n"
						+ "[Alias Name] is the name your database info will be saved under. \n"
						+ "Type a name into the [Alias Name] text field. \n" + "\n"
						+ "[Database Name] is the name of your actual database. \n"
						+ "Type a name into the [Database Name] text field. \n" + "\n"
						+ "[Database URL] is the URL of the data base you want to connect to. \n"
						+ "Type a URL into the [Database URL] text field. \n" + "\n"
						+ "[Username] is the name that is used to login to the database. \n"
						+ "Type your database username into the [Username] text field. \n" + "\n"
						+ "[Password] is the password that you use to connect to the database. \n"
						+ "Type your database password into the [Password] text field. \n" + "\n" 
						+ "Step Four: \n"
						+ "Click on the [Save Password] check box if you would like" 
						+ " to store your password \n"
						+ "If checked your password will be auto entered when you "
						+ "select this alias. \n" 
						+ "\n"
						+ "Step Five: \n" + "Click the [Choose a Driver] drop down menu and select"
						+ " the driver used by the database you want to connect to. \n" 
						+ "\n" + "Step Six: \n"
						+ "Click on the [Auto Connect] check box if you would like to connect"
						+ " to the database automatically from now on. \n"
						+ "Click the [Connect] button to connect to the database. \n"
						+ "The [Delete] button is used to delete a created alias. \n"
						+ "The [Clear] button is used to clear all the text fields "
						+ "on the window. \n" + "\n"
						+ "Step Seven: \n" + "After clicking [Connect] you will have "
								+ "three options. \n"
						+ "The [Save and Connect] button will save your alias"
								+ " and connect to the database \n"
						+ "The [Connect] button will connect to the database but "
						+ "will not save your alias\n"
						+ "The [Cancel] button will send you to the previous window. \n"
						+ "Select the [Save and Connect] or the [Connect] button.\n"
						+ "Congratulations you have successfully connected to the database!!" + "",
				"Connection Tutorial", JOptionPane.INFORMATION_MESSAGE);
	}

	private boolean isFullScreen = false;

	private JMenuItem aboutMenuItem;
	private JMenuItem welcomeMenuItem;

}
