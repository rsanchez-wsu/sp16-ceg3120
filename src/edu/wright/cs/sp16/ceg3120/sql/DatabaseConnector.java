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

package edu.wright.cs.sp16.ceg3120.sql;

import java.io.Serializable;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author Kenton Dover.
 *
 */
public abstract class DatabaseConnector implements Serializable {
	
	/**serial id.
	 * 
	 */
	private static final long serialVersionUID = 12L;

	/**
	 * Generic class to provide interface for all the different drivers.
	 * 
	 */
	public DefaultTableModel executeQuery(String in) throws SQLException {
		return null;
	}
	
	/**
	 *  Generic method to allow updating the tables.
	 * @param in input variable for query to execute.
	 * @return int to show success or fail.
	 * @throws SQLException when an error occurs.
	 */
	public int updateQuery(String in) throws SQLException {
		return 0;
	}
}
