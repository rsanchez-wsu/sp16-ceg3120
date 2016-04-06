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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**ContentView.
 * 
 */
public class DbContentView extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable dbContentTable;
	private final JScrollPane dbScrollPane;
	
	/**
	 * .
	 */
	public DbContentView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {30, 200, 30};
		gridBagLayout.rowHeights = new int[] {30, 200, 30};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0};
		setLayout(gridBagLayout);
		
		dbScrollPane = new JScrollPane();
		dbContentTable = new JTable();
		dbContentTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		dbContentTable.setColumnSelectionAllowed(true);
		dbContentTable.setCellSelectionEnabled(true);
		dbScrollPane.setViewportView(dbContentTable);
		
		
		GridBagConstraints gbcDbScrollPane = new GridBagConstraints();
		gbcDbScrollPane.fill = GridBagConstraints.BOTH;
		gbcDbScrollPane.insets = new Insets(0, 0, 5, 0);
		gbcDbScrollPane.gridx = 1;
		gbcDbScrollPane.gridy = 1;
		add(dbScrollPane, gbcDbScrollPane);
		
	}
	
	/**
	 * .
	 * @param newContent The content to be viewed as a table.
	 * @param colNames The names of the columns.
	 */
	public void setContent(String[][] newContent, String[] colNames) {
		dbContentTable = new JTable(newContent, colNames);
	}


}
