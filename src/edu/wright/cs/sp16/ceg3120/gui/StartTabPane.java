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

import java.awt.Component;

import javax.swing.JTabbedPane;

/**
 * StartTabPane.
 */
@SuppressWarnings("serial")
public class StartTabPane extends JTabbedPane {
	
	/**
	 * Initialize components.
	 */
	public StartTabPane() {
		super();
		
		initComponents();
	}
	
	/**
	 * Initialize components.
	 * */
	public void initComponents() {
		addLearnAndDiscoverTab();
		// Look below for info on these
		//addMySqLizardTab();
		//addWhatsNewTab();
	}
	
	/**
	 * Initialize learn and discover tab.
	 */
	public void addLearnAndDiscoverTab() {
		Component learnDiscoverTab = new LearnAndDiscoverTab();
		
		addTab("Learn and Discover", null, learnDiscoverTab, null);
	}
	
// NOT YET IMPLEMENTED. COMMENTED OUT DUE TO FINDBUGS ERRORS
// NP_LOAD_OF_KNOWN_NULL_VALUE: Load of known null value
// NP Load of known null value in edu.wright.cs.sp16.ceg3120.gui.StartTabPane.addMySqLizardTab()
// NP Load of known null value in edu.wright.cs.sp16.ceg3120.gui.StartTabPane.addWhatsNewTab()
//	/**
//	 * Initialize my sql lizard tab.
//	 */
//	public void addMySqLizardTab() {
//		//todo: add my sql lizard tab class
//		Component mySqLizardTab = null;
//		
//		addTab("My SqLizard", null, mySqLizardTab, null);
//	}
//	
//	/**
//	 * Initialize whats new tab.
//	 */
//	public void addWhatsNewTab() {
//		//todo: add whats new tab class
//		Component whatsNewTab = null;
//		
//		addTab("What's new", null, whatsNewTab, null);
//	}
//	

}
