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

import static edu.wright.cs.sp16.ceg3120.XmlUtil.asList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Reads settings.xml. Contains template code to be expanded.
 *
 */
public class SettingsReader {

	// tags
	static final String PROFILES = "profiles";

	static final String USER_PREFERENCES = "userPreferences";

	static final String DEFAULT_DATABASE = "defaultDatabase";
	static final String CONNECT_ON_STARTUP = "connectOnStartup";
	static final String MESSAGE_ON_STARTUP = "messageOnStartup";
	static final String DEFAULT_VIEW = "defaultView";
	static final String DEFAULT_ENCODING = "defaultEncoding";
	static final String MONOSPACED_FONT = "monospacedFont";
	static final String VERTICAL_GRID_LINES = "verticalGridLines";
	static final String REMEMBER_LAST_QUERIES = "rememberLastQueries";

	// tags without relevant meaning
	static final String TEXT = "#text";
	static final String COMMENT = "#comment";
	static final Set<String> IGNORE;

	static {
		IGNORE = new HashSet<>();
		IGNORE.add(TEXT);
		IGNORE.add(COMMENT);
	}

	/**
	 * Tests reading from xml.
	 * 
	 * @param args
	 *            no args
	 */
	public static void main(String[] args) {
		UserSettings us = readXml("Preferences.xml");
		System.out.printf("%s%n%s%n%s", us.getDefaultDatabase(), us.getDefaultEncoding(), 
				us.getDefaultView());
	}

	/**
	 * Instantiates a UserSettings object based on an xml file.
	 * 
	 * @param xmlFileName
	 *            file path name
	 */
	public static UserSettings readXml(String xmlFileName) {

		UserSettings userSettings = new UserSettings();

		Document dom;
		// Make an instance of the DocumentBuilderFactory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringComments(true);
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setValidating(true);
		dbf.setNamespaceAware(true);

		try {
			DocumentBuilder db = dbf.newDocumentBuilder();

			dom = db.parse(xmlFileName);
			Element doc = dom.getDocumentElement();

			Node temp = doc.getElementsByTagName(USER_PREFERENCES).item(0);
			NodeList preferences = temp.getChildNodes();
			for (Node prefTag : asList(preferences)) {
				if (IGNORE.contains(prefTag.getNodeName())) {
					continue;
				}

				String tagText = prefTag.getTextContent();

				switch (prefTag.getNodeName()) {
				case DEFAULT_DATABASE:
					userSettings.setDefaultDatabase(tagText);
					break;
				case CONNECT_ON_STARTUP:
					// validate true/false with dtd?
					boolean connect = Boolean.parseBoolean(tagText);
					userSettings.setConnectOnStartup(connect);
					break;
				case MESSAGE_ON_STARTUP:
					boolean message = Boolean.parseBoolean(tagText);
					userSettings.setMessageOfTheDay(message);
					break;
				case DEFAULT_VIEW:
					userSettings.setDefaultView(tagText);
					break;
				case DEFAULT_ENCODING:
					userSettings.setDefaultEncoding(tagText);
					break;
				case MONOSPACED_FONT:
					boolean mono = Boolean.parseBoolean(tagText);
					userSettings.setMonspacedFonts(mono);
					break;
				case VERTICAL_GRID_LINES:
					boolean vert = Boolean.parseBoolean(tagText);
					userSettings.setShowGridLines(vert);
					break;
				case REMEMBER_LAST_QUERIES:
					userSettings.setNumberOfQueries(NumberOfQueries.valueOf(tagText));
					break;
				default:

					System.err.println("unhandled case " + prefTag.getNodeName());
					break;
				}

			}

		} catch (ParserConfigurationException pce) {
			System.out.println(pce.getMessage());
		} catch (SAXException se) {
			System.out.println(se.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		
		
		return userSettings;
	}

	// /**
	// * Debug print loop.
	// *
	// * @param nl
	// * NodeList
	// */
	// @SuppressWarnings("unused")
	// private static void printList(NodeList nl) {
	// for (Node n : asList(nl)) {
	// boolean verbose = true;
	// if (!verbose) {
	// if (IGNORE.contains(n.getNodeName())) {
	// continue;
	// }
	// }
	// System.out.println(n.getNodeType() + " " + n.getNodeName() + " " +
	// n.getNodeValue());
	// }
	// System.exit(0);
	// }

}
