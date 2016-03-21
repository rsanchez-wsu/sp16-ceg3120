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

import edu.wright.cs.sp16.ceg3120.gui.SplashScreen;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 * The application's main class.
 */
public class MainApp{
	
	/**
	 * The main method that displays the main application window.
	 */
	private static void closeWindow() {
		
		final JFrame frame = new JFrame("Hello World");
		JLabel label = new JLabel("Hello World");
		frame.getContentPane().add(label);
		frame.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent we) {
				int close = JOptionPane.showConfirmDialog(frame, 
						"Exit the application?", 
						"Exit", 
						JOptionPane.YES_NO_OPTION);
				
				if (close == JOptionPane.YES_OPTION) {
					
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} else {
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	/**
	 * The main method that displays the main application window.
	 * 
	 * @param args The command-line arguments
	 */
	
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		
		SplashScreen screen = new SplashScreen();
		screen.showSplashScreen();
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				
				closeWindow();

			}
		});
	}
}
