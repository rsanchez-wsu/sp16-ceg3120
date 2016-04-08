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

import testconnection.DbConnection;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;


/**
 * ConnectionPanel holds the components/descriptions and view of a 
 * database for the program SQLizard.
 * @author carl.heritage
 *
 */
public class ConnectionPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final JPanel dbDetails = new JPanel();
	private final DbViewer dbViews = new DbViewer();
	private transient DbConnection dbConn;
	private DefaultListModel<String> tablesArray = new DefaultListModel<String>();
	private final JScrollPane dbTablesScrollPane = new JScrollPane();
	private final JLabel tablesLabel = new JLabel("Tables");
	private JList<String> tablesJlist = new JList<String>();
	private final JLabel lblNewLabel = new JLabel("Database Information");
	private final JLabel tableNumLabel = new JLabel("111");
	private final JLabel usrLabel = new JLabel("Root");
	
	/**Constructor for the ConnectionPanel class.
	 * @param newConnection a successful connection to a DB
	 */
	ConnectionPanel(DbConnection newConnection) {
		super();
		setPreferredSize(new Dimension(600, 400));
		dbConn = newConnection;
		dbConn.getDbName();
		GridLayout gridLayout = new GridLayout(0,2);
		gridLayout.setHgap(5);
		setLayout(gridLayout);
		System.out.println(this.getHeight() +  ", " + this.getWidth());
		dbDetails.setAlignmentY(Component.TOP_ALIGNMENT);
		dbDetails.setAlignmentX(Component.LEFT_ALIGNMENT);
		dbDetails.setMaximumSize(new Dimension(5, 32767));
		dbDetails.setSize(this.getWidth() * (1 / 3), this.getHeight());
		dbViews.setSize(this.getWidth() * (2 / 3), this.getHeight());
		ArrayList<String[]> list = dbConn.sendQuery(new String("SELECT * FROM SYS.SYSTABLES"));
		
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				tablesArray.addElement(list.get(i)[1]);
				System.out.println(tablesArray.getElementAt(i));
			}
			tablesJlist.setModel(tablesArray);
			tableNumLabel.setText(String.valueOf(list.size()));
		}
		
		add(dbDetails);
		GridBagLayout gblDbDetails = new GridBagLayout();
		gblDbDetails.columnWidths = new int[]{18, 168, 90, 0};
		gblDbDetails.rowHeights = new int[]{188, 0, 22, 20, 0};
		gblDbDetails.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gblDbDetails.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		dbDetails.setLayout(gblDbDetails);
		
		tablesJlist.setVisibleRowCount(10);
		tablesJlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		dbTablesScrollPane.setViewportBorder(new TitledBorder(null, "", 
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		dbTablesScrollPane.add(tablesJlist);
		
		dbTablesScrollPane.setViewportView(tablesJlist);
		GridBagConstraints gbcDbTablesScrollPane = new GridBagConstraints();
		gbcDbTablesScrollPane.fill = GridBagConstraints.HORIZONTAL;
		gbcDbTablesScrollPane.insets = new Insets(0, 0, 5, 0);
		gbcDbTablesScrollPane.gridwidth = 2;
		gbcDbTablesScrollPane.gridx = 1;
		gbcDbTablesScrollPane.gridy = 0;
		dbDetails.add(dbTablesScrollPane, gbcDbTablesScrollPane);
		tablesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dbTablesScrollPane.setColumnHeaderView(tablesLabel);
		tablesLabel.setLabelFor(dbTablesScrollPane);
		tablesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		tablesLabel.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 16));
		lblNewLabel.setFont(new Font("Nirmala UI", Font.PLAIN, 16));
		GridBagConstraints gbcLblNewLabel = new GridBagConstraints();
		gbcLblNewLabel.gridwidth = 2;
		gbcLblNewLabel.anchor = GridBagConstraints.NORTH;
		gbcLblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbcLblNewLabel.gridx = 1;
		gbcLblNewLabel.gridy = 1;
		dbDetails.add(lblNewLabel, gbcLblNewLabel);
		
		JLabel tblNumLabel = new JLabel("Number of Tables:");
		tblNumLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		tblNumLabel.setSize(new Dimension(87, 0));
		GridBagConstraints gbcTblNumLabel = new GridBagConstraints();
		gbcTblNumLabel.anchor = GridBagConstraints.EAST;
		gbcTblNumLabel.insets = new Insets(0, 0, 5, 5);
		gbcTblNumLabel.gridx = 1;
		gbcTblNumLabel.gridy = 2;
		dbDetails.add(tblNumLabel, gbcTblNumLabel);
		tblNumLabel.setLabelFor(tableNumLabel);
		GridBagConstraints gbcTableNumLabel = new GridBagConstraints();
		gbcTableNumLabel.anchor = GridBagConstraints.WEST;
		gbcTableNumLabel.insets = new Insets(0, 0, 5, 0);
		gbcTableNumLabel.gridx = 2;
		gbcTableNumLabel.gridy = 2;
		dbDetails.add(tableNumLabel, gbcTableNumLabel);
		
		JLabel usrLabelLabel = new JLabel("Current User:");
		usrLabelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbcUsrLabelLabel = new GridBagConstraints();
		gbcUsrLabelLabel.anchor = GridBagConstraints.EAST;
		gbcUsrLabelLabel.insets = new Insets(0, 0, 0, 5);
		gbcUsrLabelLabel.gridx = 1;
		gbcUsrLabelLabel.gridy = 3;
		dbDetails.add(usrLabelLabel, gbcUsrLabelLabel);
		usrLabelLabel.setLabelFor(usrLabel);
		
		GridBagConstraints gbcUsrLabel = new GridBagConstraints();
		gbcUsrLabel.anchor = GridBagConstraints.WEST;
		gbcUsrLabel.gridx = 2;
		gbcUsrLabel.gridy = 3;
		dbDetails.add(usrLabel, gbcUsrLabel);
		add(dbViews);
		
		tablesJlist.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				String dbName = tablesJlist.getSelectedValue();
				ArrayList<String[]> result = dbConn.sendQuery(
						"SELECT * FROM " + dbName);
				System.out.println("SELECT * FROM " + tablesJlist.getSelectedValue());
				
				dbViews.getContentTab().setContent(dbName, 
						result.toArray(new String[5][5]), result.get(1));
			}
		});
		
		setVisible(true);
		
	}
}		

