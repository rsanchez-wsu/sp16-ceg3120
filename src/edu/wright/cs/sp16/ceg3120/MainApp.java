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

import edu.wright.cs.sp16.ceg3120.gui.MainGui;
import edu.wright.cs.sp16.ceg3120.gui.other.SplashScreen;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * The main application starting point.
 * 
 * @author sam
 *
 */
public class MainApp {

	/**
	 * Driver method that sets the system look and feel.
	 * 
	 * @param args
	 *            Arguments from command line.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

			SplashScreen screen = new SplashScreen();
			screen.showSplashScreen();

			MainGui gui = new MainGui();
			gui.setVisible(true);
			gui.setLocationRelativeTo(null); // centered
			gui.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			gui.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					int answer = JOptionPane.showConfirmDialog(gui, "Quit SQLizard?", 
							"Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (answer == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				} // end of widowClosing
			}); // end of WindowListener
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
