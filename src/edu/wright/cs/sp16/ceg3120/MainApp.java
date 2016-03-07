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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	static JTabbedPane tabbedPane = new JTabbedPane();
	
	
	/**
	 * The main method that displays the main application window.
	 * 
	 * 
	 */
	private static void createWindow() {
		
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
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
				Preferences preferences1 = new Preferences();
				tabbedPane.addTab("User Preferences", preferences1);
			}
		});
		mnEdit.add(mntmPreferences);
		
		JMenu mnWindow = new JMenu("Window");
		menuBar.add(mnWindow);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		

		tabbedPane.setVisible(true);
		
		
		
	}
	
	/**
	 * This will remove tabs from the tabbed pane.
	 * @param title A string containing the title of the tab to be closed.
	 */
	static void removeTab(String title) {
		int index = tabbedPane.indexOfTab(title);
		if ( index != -1) {
			tabbedPane.removeTabAt(index);
		}
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
