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

package edu.wright.cs.sp16.ceg3120;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;


/**
 * The application's main class.
 */
public class MainApp {
	
	static final String PREFERENCES_PATH = "Preferences.xml";
	static JTabbedPane tabbedPane = new JTabbedPane(); 
	static UserSettings globalConfig = UserSettings.loadXmlEncodedBean(PREFERENCES_PATH);
	
	
	/**
	 * The main method that displays the main application window.
	 * 
	 * 
	 */
	private static void createWindow() {
		//TODO control real motd.
		if (globalConfig.isMessageOfTheDay()) {
			System.out.println("MOTD:");
		}
		
		final JFrame frmSqlizard = new JFrame("SQLizard");
		frmSqlizard.setTitle("SQLizard");
		
		frmSqlizard.addWindowListener(new java.awt.event.WindowAdapter() {
			
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				int close = JOptionPane.showConfirmDialog(frmSqlizard, 
						"Exit the application?", 
						"Exit", 
						JOptionPane.YES_NO_OPTION);
				
				if (close == JOptionPane.YES_OPTION) {
					frmSqlizard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} else {
					frmSqlizard.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}

			//@Override
			//public void componentAdded(ContainerEvent arg0) {
				// TODO Auto-generated method stub
				
			//}

			//@Override
			//public void componentRemoved(ContainerEvent arg0) {
				// TODO Auto-generated method stub
				
		//	}
			
			
		});

		frmSqlizard.setSize(800, 600);
		frmSqlizard.setLocationRelativeTo(null);
		frmSqlizard.setVisible(true);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmSqlizard.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frmSqlizard.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent exit) {
				frmSqlizard.dispose();
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmPreferences = new JMenuItem("Preferences");
		mntmPreferences.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent preferences) {
				String paneTitle = "User Preferences";
				int index = tabbedPane.indexOfTab(paneTitle);
				if (index == -1) {
					JButton btnClose = new JButton("Close");
					btnClose.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							Component selected = tabbedPane.getSelectedComponent();
								if (selected != null) {
									tabbedPane.remove(selected);
								}
							}
					});
					btnClose.setVisible(true);
					PreferencesPanel preferences1 = new PreferencesPanel(btnClose);
					preferences1.add(btnClose);
					
					tabbedPane.addTab(paneTitle, preferences1);
				}
			}
		});
		mnEdit.add(mntmPreferences);
		
		JMenuItem mntmQueries = new JMenuItem("Queries Panel");
		mntmQueries.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent queries) {
				//TODO ??
				int index = tabbedPane.indexOfTab("Queries Panel");
				if (index == -1) {
					JButton btnClose = new JButton("Close");
					btnClose.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							Component selected = tabbedPane.getSelectedComponent();
								if (selected != null) {
									tabbedPane.remove(selected);
								}
							}
					});
					btnClose.setVisible(true);

					Queries queries1 = new Queries(btnClose);
					queries1.add(btnClose);
					tabbedPane.addTab("Queries Panel", queries1);

				}
			}
		});
		mnEdit.add(mntmQueries);
		
		JMenu mnWindow = new JMenu("Window");
		menuBar.add(mnWindow);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		

		tabbedPane.setVisible(true);
		
		
		
	}
	
	/**
	 * Updates global config to new settings.
	 * 
	 * @param settings
	 *            config to change to
	 */
	static void updateGlobalSettings(UserSettings settings) {
		globalConfig = settings;
	}
	
	/**
	 * The main method that displays the main application window.
	 * 
	 * @param args The command-line arguments
	 */
	
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {

				createWindow();
			}
		});
	}
}
