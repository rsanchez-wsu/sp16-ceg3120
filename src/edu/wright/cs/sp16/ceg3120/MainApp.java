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

import gui.WinMain;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * The application's main class.
 */
public class MainApp {

	
	/**
	 * The main method that displays the main application window.
	 * 
	 * @param args The command-line arguments
	 */
	
	public static void main(String[] args) {
		WinMain programWindow = new WinMain();
		programWindow.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent we) {
				int close = JOptionPane.showConfirmDialog(programWindow, 
						"Exit the application?", 
						"Exit", 
						JOptionPane.YES_NO_OPTION);
				
				if (close == JOptionPane.YES_OPTION) {
					
					programWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} else {
					programWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});

	}
}