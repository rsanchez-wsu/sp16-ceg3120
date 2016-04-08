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


import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

/**ContentView.
 * 
 */
public class DbContentView extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable dbContentTable;
	private final JScrollPane dbScrollPane;
	private final String panelLabelText = "Content for: ";
	JLabel dbContentLabel = new JLabel(panelLabelText);
	
	/**
	 * .
	 */
	public DbContentView() {
		dbContentLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dbContentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(dbContentLabel);
		
		dbScrollPane = new JScrollPane();
		dbContentTable = new JTable();
		dbContentTable.setFillsViewportHeight(true);
		
		dbContentTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		dbContentTable.setColumnSelectionAllowed(true);
		dbContentTable.setCellSelectionEnabled(true);
		dbScrollPane.setViewportView(dbContentTable);
		add(dbScrollPane, "cell 0 0,grow");
		
	}
	
	/**
	 * .
	 * @param newContent The content to be viewed as a table.
	 * @param colNames The names of the columns.
	 */
	public void setContent(String newDbName, String[][] newContent, String[] colNames) {
		for (int i = 0; i < colNames.length; i++) {
			System.out.print(colNames[i] + " ");
		}
		System.out.println();
		for (int i = 0; i <  5; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(newContent[i][j] + " ");
			}
			System.out.println();
		}
		dbContentLabel.setText(panelLabelText + newDbName);
		dbContentTable = new JTable(newContent, colNames);
		dbScrollPane.setViewportView(dbContentTable);
	}


}
