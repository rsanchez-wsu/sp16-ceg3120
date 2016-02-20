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

import testconnection.DBconnection;

import javax.swing.JPanel;


/**
 * ConnectionPanel holds the components/descriptions and view of a 
 * database for the program SQLizard.
 * @author carl.heritage
 *
 */
public class ConnectionPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	//private static final JPanel dbDetails = new JPanel();
	//private static final JTabbedPane dbViews = new JTabbedPane();
	private DBconnection dbConn;
	
	/**Constructor for the ConnectionPanel class.
	 * @param newConnection a successful connection to a DB
	 */
	ConnectionPanel(DBconnection newConnection) {
		super();
		dbConn = newConnection;
		dbConn.getDbName();
		setVisible(true);
		
	}
}
