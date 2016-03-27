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

import net.miginfocom.swing.MigLayout;
import testconnection.DbConnection;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
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
	private final JLabel TablesLabel = new JLabel("  Tables");
	private JList<String> list_showup = new JList();
	private final JLabel lblNewLabel = new JLabel("  Database Information");
	private final JLabel label = new JLabel("");
	private final JLabel lblIntnumberoutput = new JLabel("111");
	
	/**Constructor for the ConnectionPanel class.
	 * @param newConnection a successful connection to a DB
	 */
	ConnectionPanel(DbConnection newConnection) {
		super();
		lblNewLabel.setFont(new Font("Nirmala UI", Font.PLAIN, 16));
		dbConn = newConnection;
		dbConn.getDbName();
		GridLayout gridLayout = new GridLayout(0,2);
		gridLayout.setHgap(1);
		setLayout(gridLayout);
		System.out.println(this.getHeight() +  ", " + this.getWidth());
		dbDetails.setAlignmentY(Component.TOP_ALIGNMENT);
		dbDetails.setAlignmentX(Component.LEFT_ALIGNMENT);
		dbDetails.setMaximumSize(new Dimension(5, 32767));
		dbDetails.setSize(this.getWidth() * (1 / 3), this.getHeight());
		dbViews.setSize(this.getWidth() * (2 / 3), this.getHeight());
		ArrayList<String> list = null;
		try {
			list = dbConn.sendQuery(new String("SELECT * FROM SYS.SYSTABLES"));
			for(int i=0;i<list.size();i++){
				tablesArray.addElement(list.get(i));
				System.out.println(tablesArray.getElementAt(i));
				JList listYa = new JList(list.toArray()); 
				list_showup=listYa;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(dbDetails);
		list_showup.setVisibleRowCount(10);
		list_showup.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		dbTablesScrollPane.setViewportBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		dbTablesScrollPane.add(list_showup);
		TablesLabel.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 16));
		
		dbTablesScrollPane.setColumnHeaderView(TablesLabel);
		
		dbTablesScrollPane.setViewportView(list_showup);
		dbDetails.setLayout(new MigLayout("", "[32.00px][43.00px][84px]", "[189px][29px][1px][23px][][15px]"));
		dbDetails.add(label, "cell 0 2,alignx right,aligny top");
		dbDetails.add(dbTablesScrollPane, "cell 0 0 3 1,growx,aligny top");
		
		JLabel lblNewLabel_1 = new JLabel("Number of Tables:");
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setSize(new Dimension(87, 0));
		dbDetails.add(lblNewLabel_1, "cell 1 3,grow");
		dbDetails.add(lblIntnumberoutput, "cell 2 3,alignx left,aligny center");
		dbDetails.add(lblNewLabel, "cell 0 1 3 1,alignx left,growy");
		
		JLabel Label_2 = new JLabel("Current User:");
		Label_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		dbDetails.add(Label_2, "cell 1 4,growx,aligny top");
		add(dbViews);
		
		setVisible(true);
		
	}
}		

