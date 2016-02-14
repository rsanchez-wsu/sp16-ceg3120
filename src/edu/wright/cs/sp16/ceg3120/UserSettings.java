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
 * Representation of a user's settings.
 *
 */
public class UserSettings {
	private String database;
	private String username;
	// TODO password
	private String firstName;
	private String lastName;
	private String department;
	// enum?
	private String accountType;

	/**
	 * A getter/setter.
	 * 
	 * @return the database
	 */
	public String getDatabase() {
		return database;
	}

	/**
	 * A getter/setter.
	 * 
	 * @param database the database to set
	 */
	public void setDatabase(String database) {
		this.database = database;
	}

	/**
	 * A getter/setter.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * A getter/setter.
	 * 
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * A getter/setter.
	 * 
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * A getter/setter.
	 * 
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * A getter/setter.
	 * 
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * A getter/setter.
	 * 
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * A getter/setter.
	 * 
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * A getter/setter.
	 * 
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * A getter/setter.
	 * 
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * A getter/setter.
	 * 
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}