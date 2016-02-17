package edu.wright.cs.sp16.ceg3120.gui;

import edu.wright.cs.sp16.ceg3120.gui.tabs.*;

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
		LearnAndDiscoverTab learnDiscoverTab = new LearnAndDiscoverTab();
		
		addTab("Learn and Discover", null, learnDiscoverTab, null);
	}
	
	/*
	 * Initialize my sql lizard tab
	 * */
	public void addMySqLizardTab() {
		MySqLizardTab mySqLizardTab = new MySqLizardTab();
		
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
