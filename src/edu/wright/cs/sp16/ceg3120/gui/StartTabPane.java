package edu.wright.cs.sp16.ceg3120.gui;

import edu.wright.cs.sp16.ceg3120.gui.tabs.BackupExportTab;
import edu.wright.cs.sp16.ceg3120.gui.tabs.ConnectionTab;
import edu.wright.cs.sp16.ceg3120.gui.tabs.LearnAndDiscoverTab;
import edu.wright.cs.sp16.ceg3120.gui.tabs.StartPageTab;

import java.awt.Component;

import javax.swing.JTabbedPane;

public class StartTabPane extends JTabbedPane {
	
	public StartTabPane(){
		super();
		
		initComponents();
	}
	
	/*
	 * Initialize componets
	 * */
	public void initComponents() {
		addLearnAndDiscoverTab();
		addMySqLizardTab();
		addWhatsNewTab();
	}
	
	/*
	 * Initialize learn and discover tab
	 * */
	public void addLearnAndDiscoverTab() {
		Component learnDiscoverTab = new LearnAndDiscoverTab();
		
		addTab("Learn and Discover", null, learnDiscoverTab, null);
	}
	
	/*
	 * Initialize my sql lizard tab
	 * */
	public void addMySqLizardTab() {
		//todo: add my sql lizard tab class
		Component mySqLizardTab = null;
		
		addTab("My SqLizard", null, mySqLizardTab, null);
	}
	
	/*
	 * Initialize whats new tab
	 * */
	public void addWhatsNewTab() {
		//todo: add whats new tab class
		Component whatsNewTab = null;
		
		addTab("What's new", null, whatsNewTab, null);
	}
	

}
