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

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Driver for testing the GUI.
 * 
 * @author codybutz
 *
 */
public class TestGui {

	/**
	 * Driver method that sets the system look and feel.
	 * @param args Arguments from command line.
	 */
	public static void main(String[] args) {
		try {
			
			SplashScreen screen = new SplashScreen();
			screen.showSplashScreen();
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

			MainGui gui = new MainGui();
			gui.setVisible(true);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
	}

}
