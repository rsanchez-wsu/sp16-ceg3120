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

/**
 * 
 * @author Kenton Dover.
 *
 */
public class Querybuilder {

	private DatabaseConnector connector;

	/**
	 * Query builder constructor, accepts an open database connection. Will
	 * allow the user to construct SQL queries in the GUI.
	 * 
	 * @param connector
	 *            Open database connector that is already established.
	 */
	public Querybuilder(DatabaseConnector connector) {
		this.setConnector(connector);
	}

	/**
	 * Function which returns the open database connection.
	 * 
	 * @return the open database connection.
	 */
	public DatabaseConnector getConnector() {
		return connector;
	}

	/**
	 * Sets the internal connection variable which must be an open and
	 * configured database connection.
	 * 
	 * @param connector
	 *            Must be an open and connected connection object.
	 */
	public void setConnector(DatabaseConnector connector) {
		this.connector = connector;
	}
}
