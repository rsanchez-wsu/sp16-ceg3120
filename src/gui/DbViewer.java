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
	private static final long serialVersionUID = 1L;
	private DbContentView contentTab = new DbContentView();
	private DbStructureView structureTab = new DbStructureView();
	private DbRelationshipsView relationshipsTab = new DbRelationshipsView();
	private DbQueryBuilderView querybuilderTab = new DbQueryBuilderView();
	private DbErDiagramView erdiagramTab = new DbErDiagramView();
	private DbBackupRestoreView backuprestoreTab = new DbBackupRestoreView();

	
	
	
	/**The tabbed pane containing different views of the given
	 * DB.
	 * 
	 */
	public DbViewer() {
		super();
		
		addTab("Content",contentTab);
		setMnemonicAt(0, KeyEvent.VK_1);

		addTab("Structure",structureTab);
		setMnemonicAt(1, KeyEvent.VK_2);

		addTab("Relationships",relationshipsTab);
		setMnemonicAt(2, KeyEvent.VK_3);

		addTab("Query Builder",querybuilderTab);
		setMnemonicAt(3, KeyEvent.VK_4);

		addTab("ER Diagram",erdiagramTab);
		setMnemonicAt(4, KeyEvent.VK_5);

		addTab("Backup/Restore",backuprestoreTab);
		setMnemonicAt(5, KeyEvent.VK_6);

		//The following line enables to use scrolling tabs.
		setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}




	/**
	 * Retrieves the DB Content panel.
	 * @return the contentTab
	 */
	public DbContentView getContentTab() {
		return contentTab;
	}




	/**
	 * Retrieves the DB Structure panel.
	 * @return the structureTab
	 */
	public DbStructureView getStructureTab() {
		return structureTab;
	}
	
	
	
	
	/**
	 * Retrieves the Relationships panel.
	 * @return the relationshipsTab
	 */
	public DbRelationshipsView getRelationshipsTab() {
		return relationshipsTab;
	}
	
	
	
	
	/**
	 * Retrieves the Query Builder panel.
	 * @return the querybuilderTab
	 */
	public DbQueryBuilderView getQuerybuilderTab() {
		return querybuilderTab;
	}
	
	
	
	
	/**
	 * Retrieves the ER Diagram panel.
	 * @return the erdiagramTab
	 */
	public DbErDiagramView getErdiagramTab() {
		return erdiagramTab;
	}
	
	
}



