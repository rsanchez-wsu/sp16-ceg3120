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

import java.awt.GridLayout;

import javax.swing.JPanel;


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
	private DbConnection dbConn;
	
	/**Constructor for the ConnectionPanel class.
	 * @param newConnection a successful connection to a DB
	 */
	ConnectionPanel(DbConnection newConnection) {
		super();
		dbConn = newConnection;
		dbConn.getDbName();
		setLayout(new GridLayout(1,2));
		System.out.println(this.getHeight() +  ", " + this.getWidth());
		dbDetails.setSize(this.getWidth() * (1 / 3), this.getHeight());
		dbViews.setSize(this.getWidth() * (2 / 3), this.getHeight());
		add(dbDetails);
		add(dbViews);
		
		setVisible(true);
		
	}
}
