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


import java.awt.Insets;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import edu.wright.cs.sp16.ceg3120.gui.MainGui;
import edu.wright.cs.sp16.ceg3120.gui.other.SplashScreen;
import edu.wright.cs.sp16.ceg3120.util.UserSettings;


/**
 * The main application starting point.
 * 
 * @author sam
 *
 */
public class MainApp {

	
	static final String PREFERENCES_PATH = "Preferences.xml";
//<<<<<<< HEAD
	//static JTabbedPane tabbedPane = new JTabbedPane(); 
//=======
	
//>>>>>>> Team-1-Dev
	static UserSettings globalConfig = UserSettings.loadXmlEncodedBean(PREFERENCES_PATH);
	
	
	
	/**
	 * Updates global config to new settings.
	 * 
	 * @param initSettings
	 *            config to change to
	 */
	//TODO figure out if we need this
	public static void updateGlobalSettings(UserSettings initSettings) {
		globalConfig = initSettings;
	}
	

	/**
	 * Driver method that sets the system look and feel.
	 * 
	 * @param args
	 *            Arguments from command line.
	 */
	public static void main(String[] args) {
		try {

			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.put("TabbedPane.tabInsets", new Insets(2, 2, 2, 50));
			
			SplashScreen screen = new SplashScreen();
			screen.showSplashScreen();

			MainGui gui = new MainGui();
			
			//TODO use global config
			System.out.println("Defailt database is" + globalConfig.getDefaultDatabase());
			
			gui.setVisible(true);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

	}
}
