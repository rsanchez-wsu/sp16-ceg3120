/*
 * Copyright (C) 2016
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

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

/**This is the splash screen class for the application. It simply loads the 
 *splash screen image onto a window for a small amount of time before 
 *displaying the main screen of the application.
 *
 * @author Alex Vance
 */
public class SplashScreen{

	/**Construct a splash screen.*/
	public void showSplashScreen() {
		// create window, apply image
		JWindow window = new JWindow();
		ImageIcon icon = new ImageIcon("img/splashscreen_pic.png");
		JLabel label = new JLabel(icon);
		
		window.add(label);
		window.setBounds(225, 125, 900, 500);
		window.setVisible(true);
		
		//provide splash screen loading effect
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		window.setVisible(false);
	}
}
