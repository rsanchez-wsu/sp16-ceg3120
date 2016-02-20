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




import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 * The application's main class.
 */


public class DbViewer extends JTabbedPane{
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;

/**DbViewer.
 * GUI for one of database
 * 
 */
	public DbViewer() {
		super();

	

		JTabbedPane tabbedPane = new JTabbedPane();

		DbContentView contentTab = new DbContentView();
		tabbedPane.addTab("Content",contentTab);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		DbStructureView structureTab = new DbStructureView();
		tabbedPane.addTab("Structure",structureTab);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		//Add the tabbed pane to this panel.
		
		DbRelationshipsView relationshipsTab = new DbRelationshipsView();
		tabbedPane.addTab("Relationships",relationshipsTab);
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		DbQueryBuilderView querybuilderTab = new DbQueryBuilderView();
		tabbedPane.addTab("Query Builder",querybuilderTab);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		DberdiagramView erdiagramTab = new DberdiagramView();
		tabbedPane.addTab("ER Diagram",erdiagramTab);
		tabbedPane.setMnemonicAt(4, KeyEvent.VK_5);

		DbBackupRestoreView backuprestoreTab = new DbBackupRestoreView();
		tabbedPane.addTab("Backup/Restore",backuprestoreTab);
		tabbedPane.setMnemonicAt(5, KeyEvent.VK_6);
		add(tabbedPane);

		//The following line enables to use scrolling tabs.
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

	}
/** main class
 *  create new JFrame and set content. 
 */ 
	public static void main(String[]args) {
		/* main class
		 *  create new JFrame and set content. 
		 */ 
		//1. Create the frame.
		JFrame window = new JFrame("experimentFrame");

		//2. Optional: What happens when the frame closes?
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DbViewer gui = new DbViewer();
		window.setContentPane(gui);
		window.pack();
		window.setVisible(true);
		window.setSize(600,500);
		
	}




}



