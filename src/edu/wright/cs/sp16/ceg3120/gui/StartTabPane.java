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

import edu.wright.cs.sp16.ceg3120.gui.tabs.LearnAndDiscoverTab;
import edu.wright.cs.sp16.ceg3120.gui.tabs.MySqLizardTab;

import java.awt.Component;

import javax.swing.JTabbedPane;


/**Tab element for start page containing subtabs for optional navigation.
 * @author Sam, Alex
 *
 */
public class StartTabPane extends JTabbedPane  {
	
	private static final long serialVersionUID = -6246467852166589297L;
	
	/**Create the container for start tabs.
	 * @author Alex, Sam
	 * */
	public StartTabPane() {
		super();
		
		initComponents();
	}
	
	/**Initialize components.
	 *@author Sam
	 * */
	public void initComponents() {
		addLearnAndDiscoverTab();
		addMySqLizardTab();
		//addWhatsNewTab();
	}
	
	/**Initialize learn and discover tab.
	 *@author Sam
	 */
	public void addLearnAndDiscoverTab() {
		LearnAndDiscoverTab learnDiscoverTab = new LearnAndDiscoverTab();
		
		addTab("Learn and Discover", null, learnDiscoverTab, null);
	}
	
	/**Initialize my sql lizard tab.
	 *@author Sam
	 *
	 */
	public void addMySqLizardTab() {
		MySqLizardTab mySqLizardTab = new MySqLizardTab();
		
		addTab("My SqLizard", null, mySqLizardTab, null);
	}
	
	/**Initialize what' new tab.
	 * @author Sam
	 */
	/*public void addWhatsNewTab() {
		//TODO: add what's new tab class
		Component whatsNewTab = null;
		
		addTab("What's new", null, whatsNewTab, null);
	}*/
}
