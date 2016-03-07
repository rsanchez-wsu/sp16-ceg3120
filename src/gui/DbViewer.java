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

package gui;




import java.awt.event.KeyEvent;
import javax.swing.JTabbedPane;

/**
 * The application's main class.
 */


public class DbViewer extends JTabbedPane{
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;

/**The tabbed pane containing different views of the given
 * DB.
 * 
 */
	public DbViewer() {
		super();
		
		DbContentView contentTab = new DbContentView();
		addTab("Content",contentTab);
		setMnemonicAt(0, KeyEvent.VK_1);

		DbStructureView structureTab = new DbStructureView();
		addTab("Structure",structureTab);
		setMnemonicAt(1, KeyEvent.VK_2);
		//Add the tabbed pane to this panel.
		
		DbRelationshipsView relationshipsTab = new DbRelationshipsView();
		addTab("Relationships",relationshipsTab);
		setMnemonicAt(2, KeyEvent.VK_3);

		DbQueryBuilderView querybuilderTab = new DbQueryBuilderView();
		addTab("Query Builder",querybuilderTab);
		setMnemonicAt(3, KeyEvent.VK_4);

		DbErDiagramView erdiagramTab = new DbErDiagramView();
		addTab("ER Diagram",erdiagramTab);
		setMnemonicAt(4, KeyEvent.VK_5);

		DbBackupRestoreView backuprestoreTab = new DbBackupRestoreView();
		addTab("Backup/Restore",backuprestoreTab);
		setMnemonicAt(5, KeyEvent.VK_6);

		//The following line enables to use scrolling tabs.
		setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		
	}
///** Test main for testing functionality of the DbViewer class.
// */ 
//	public static void main(String[]args) {
//		/* main class
//		 *  create new JFrame and set content. 
//		 */ 
//		//1. Create the frame.
//		JFrame window = new JFrame("experimentFrame");
//
//		//2. Optional: What happens when the frame closes?
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		DbViewer gui = new DbViewer();
//		window.setContentPane(gui);
//		window.pack();
//		window.setVisible(true);
//		window.setSize(600,500);
//		
//	}
}



