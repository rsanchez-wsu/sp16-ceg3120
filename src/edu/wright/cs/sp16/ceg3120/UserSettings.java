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
	private String defaultDatabase;
	private boolean connectOnStartup;
	private boolean messageOfTheDay;
	private String defaultView;
	private String defaultEncoding;
	private boolean monspacedFonts;
	private boolean showGridLines;
	private String numberOfQueries;
	
	/**
	 * Returns the default database.
	 * @return defaultDatabase
	 */
	public String getDefaultDatabase() {
		return defaultDatabase;
	}
	
	/**
	 * Sets the default database.
	 * @param defaultDatabase database returned
	 */
	public void setDefaultDatabase(String defaultDatabase) {
		this.defaultDatabase = defaultDatabase;
	}
	
	/**
	 * Returns if there's a connection on startup.
	 * @return connectOnStartup
	 */
	public boolean isConnectOnStartup() {
		return connectOnStartup;
	}
	
	/**
	 * Sets if there's a connection on startup.
	 * @param connectOnStartup startup connection
	 */
	public void setConnectOnStartup(boolean connectOnStartup) {
		this.connectOnStartup = connectOnStartup;
	}
	
	/**
	 * Returns if there's a message of the day.
	 * @return messageOfTheDay
	 */
	public boolean isMessageOfTheDay() {
		return messageOfTheDay;
	}
	
	/**
	 * Sets the message of the day.
	 * @param messageOfTheDay message of the day
	 */
	public void setMessageOfTheDay(boolean messageOfTheDay) {
		this.messageOfTheDay = messageOfTheDay;
	}
	
	/**
	 * Returns the default view.
	 * @return defaultView
	 */
	public String getDefaultView() {
		return defaultView;
	}
	
	/**
	 * Sets the default view.
	 * @param defaultView default view
	 */
	public void setDefaultView(String defaultView) {
		this.defaultView = defaultView;
	}
	
	/**
	 * Returns the default encoding.
	 * @return defaultEncoding
	 */
	public String getDefaultEncoding() {
		return defaultEncoding;
	}
	
	/**
	 * Sets the default encoding.
	 * @param defaultEncoding default encoding
	 */
	public void setDefaultEncoding(String defaultEncoding) {
		this.defaultEncoding = defaultEncoding;
	}
	
	/**
	 * Returns if font is monospaced.
	 * @return monospacedFonts
	 */
	public boolean isMonspacedFonts() {
		return monspacedFonts;
	}
	
	/**
	 * Sets if the font is monospaced.
	 * @param monspacedFonts monospaced fonts
	 */
	public void setMonspacedFonts(boolean monspacedFonts) {
		this.monspacedFonts = monspacedFonts;
	}
	
	/**
	 * Returns if the grid lines are shown.
	 * @return showGridLines
	 */
	public boolean isShowGrinLines() {
		return showGridLines;
	}
	
	/**
	 * Sets if the grid lines are shown.
	 * @param showGrinLines shows grid lines
	 */
	public void setShowGrinLines(boolean showGrinLines) {
		this.showGridLines = showGrinLines;
	}
	
	/**
	 * Returns the number of queries.
	 * @return numberOfQueries
	 */
	public String getNumberOfQueries() {
		return numberOfQueries;
	}
	
	/**
	 * Sets the number of queries.
	 * @param numberOfQueries number of queries
	 */
	public void setNumberOfQueries(String numberOfQueries) {
		this.numberOfQueries = numberOfQueries;
	}
}