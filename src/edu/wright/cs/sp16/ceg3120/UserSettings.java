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
	 * 
	 * @return defaultDatabase
	 */
	public String getDefaultDatabase() {
		return defaultDatabase;
	}

	/**
	 * Default constructor.
	 */
	public UserSettings() {
	}

	/**
	 * Copy constructor.
	 * 
	 * @param other
	 *            object to copy
	 */
	public UserSettings(UserSettings other) {

		defaultDatabase = other.defaultDatabase;
		connectOnStartup = other.connectOnStartup;
		messageOfTheDay = other.messageOfTheDay;
		defaultView = other.defaultView;
		defaultEncoding = other.defaultEncoding;
		monspacedFonts = other.monspacedFonts;
		showGridLines = other.showGridLines;
		numberOfQueries = other.numberOfQueries;
	}

	/**
	 * Sets the default database.
	 * 
	 * @param defaultDatabase
	 *            database returned
	 */
	public void setDefaultDatabase(String defaultDatabase) {
		this.defaultDatabase = defaultDatabase;
	}

	/**
	 * Returns if there's a connection on startup.
	 * 
	 * @return connectOnStartup
	 */
	public boolean isConnectOnStartup() {
		return connectOnStartup;
	}

	/**
	 * Sets if there's a connection on startup.
	 * 
	 * @param connectOnStartup
	 *            startup connection
	 */
	public void setConnectOnStartup(boolean connectOnStartup) {
		this.connectOnStartup = connectOnStartup;
	}

	/**
	 * Returns if there's a message of the day.
	 * 
	 * @return messageOfTheDay
	 */
	public boolean isMessageOfTheDay() {
		return messageOfTheDay;
	}

	/**
	 * Sets the message of the day.
	 * 
	 * @param messageOfTheDay
	 *            message of the day
	 */
	public void setMessageOfTheDay(boolean messageOfTheDay) {
		this.messageOfTheDay = messageOfTheDay;
	}

	/**
	 * Returns the default view.
	 * 
	 * @return defaultView
	 */
	public String getDefaultView() {
		return defaultView;
	}

	/**
	 * Sets the default view.
	 * 
	 * @param defaultView
	 *            default view
	 */
	public void setDefaultView(String defaultView) {
		this.defaultView = defaultView;
	}

	/**
	 * Returns the default encoding.
	 * 
	 * @return defaultEncoding
	 */
	public String getDefaultEncoding() {
		return defaultEncoding;
	}

	/**
	 * Sets the default encoding.
	 * 
	 * @param defaultEncoding
	 *            default encoding
	 */
	public void setDefaultEncoding(String defaultEncoding) {
		this.defaultEncoding = defaultEncoding;
	}

	/**
	 * Returns if font is monospaced.
	 * 
	 * @return monospacedFonts
	 */
	public boolean isMonspacedFonts() {
		return monspacedFonts;
	}

	/**
	 * Sets if the font is monospaced.
	 * 
	 * @param monspacedFonts
	 *            monospaced fonts
	 */
	public void setMonspacedFonts(boolean monspacedFonts) {
		this.monspacedFonts = monspacedFonts;
	}

	/**
	 * Returns if the grid lines are shown.
	 * 
	 * @return showGridLines
	 */
	public boolean isShowGridLines() {
		return showGridLines;
	}

	/**
	 * Sets if the grid lines are shown.
	 * 
	 * @param showGrinLines
	 *            shows grid lines
	 */
	public void setShowGridLines(boolean showGrinLines) {
		this.showGridLines = showGrinLines;
	}

	/**
	 * Returns the number of queries.
	 * 
	 * @return numberOfQueries
	 */
	public String getNumberOfQueries() {
		return numberOfQueries;
	}

	/**
	 * Sets the number of queries.
	 * 
	 * @param numberOfQueries
	 *            number of queries
	 */
	public void setNumberOfQueries(String numberOfQueries) {
		this.numberOfQueries = numberOfQueries;
	}

	@Override
	public int hashCode() {
		// auto generated
		final int prime = 31;
		int result = 1;
		result = prime * result + (connectOnStartup ? 1231 : 1237);
		result = prime * result + ((defaultDatabase == null) ? 0 : defaultDatabase.hashCode());
		result = prime * result + ((defaultEncoding == null) ? 0 : defaultEncoding.hashCode());
		result = prime * result + ((defaultView == null) ? 0 : defaultView.hashCode());
		result = prime * result + (messageOfTheDay ? 1231 : 1237);
		result = prime * result + (monspacedFonts ? 1231 : 1237);
		result = prime * result + ((numberOfQueries == null) ? 0 : numberOfQueries.hashCode());
		result = prime * result + (showGridLines ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// Auto generated
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		UserSettings other = (UserSettings) obj;

		if (connectOnStartup != other.connectOnStartup) {
			return false;
		}
		if (defaultDatabase == null) {
			if (other.defaultDatabase != null) {
				return false;
			}
		} else if (!defaultDatabase.equals(other.defaultDatabase)) {
			return false;
		}
		if (defaultEncoding == null) {
			if (other.defaultEncoding != null) {
				return false;
			}
		} else if (!defaultEncoding.equals(other.defaultEncoding)) {
			return false;
		}
		if (defaultView == null) {
			if (other.defaultView != null) {
				return false;
			}
		} else if (!defaultView.equals(other.defaultView)) {
			return false;
		}
		if (messageOfTheDay != other.messageOfTheDay) {
			return false;
		}
		if (monspacedFonts != other.monspacedFonts) {
			return false;
		}
		if (numberOfQueries == null) {
			if (other.numberOfQueries != null) {
				return false;
			}
		} else if (!numberOfQueries.equals(other.numberOfQueries)) {
			return false;
		}
		if (showGridLines != other.showGridLines) {
			return false;
		}
		return true;
	}

}