package edu.wright.cs.sp16.ceg3120;

import static edu.wright.cs.sp16.ceg3120.XmlUtil.asList;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Reads settings.xml. Contains template code to be expanded.
 *
 */
public class SettingsReader {

	// tags
	static final String CONFIG = "config";
	static final String PROFILES = "profiles";
	static final String USER = "user";
	static final String DATABASE = "database";
	static final String USERNAME = "username";
	static final String PASSWORD = "password";
	static final String FIRST_NAME = "firstName";
	static final String LAST_NAME = "lastName";
	static final String ACCOUNT_TYPE = "accountType";
	static final String DEPARTMENT = "department";
	static final String APP_SETTINGS = "appSettings";
	static final String SHOW_MOTD = "showMotd";

	// tags without relevant meaning
	static final String TEXT = "#text";
	static final String COMMENT = "#comment";
	static final ArrayList<String> IGNORE;

	static {
		IGNORE = new ArrayList<>();
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
		readXml("Profile.xml");
	}

	/**
	 * Reads an xml file and does some stuff. Sample Method
	 * 
	 * @param xml
	 *            file path
	 */
	public static void readXml(String xml) {
		// rolev = new ArrayList<String>();
		Document dom;
		// Make an instance of the DocumentBuilderFactory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();

			dom = db.parse(xml);
			Element doc = dom.getDocumentElement();

			// user profiles
			NodeList profiles = doc.getElementsByTagName(PROFILES).item(0).getChildNodes();
			for (Node userTag : asList(profiles)) {
				if (IGNORE.contains(userTag.getNodeName())) {
					continue;
				}
				// only meaningful child type of profiles is user
				assert userTag.getNodeName().equals(USER);

				NodeList userTags = userTag.getChildNodes();
				UserSettings user = new UserSettings();

				for (Node tag : asList(userTags)) {
					// System.out.println(tag.getNodeName());
					switch (tag.getNodeName()) {
					case DATABASE:
						user.setDatabase(tag.getTextContent());
						break;
					case USERNAME:
						user.setUsername(tag.getTextContent());
						break;
					case PASSWORD:

						// TODO password decrypt password
						break;
					case FIRST_NAME:
						user.setFirstName(tag.getTextContent());
						break;
					case LAST_NAME:
						user.setLastName(tag.getTextContent());
						break;
					case ACCOUNT_TYPE:
						user.setAccountType(tag.getTextContent());
						break;
					case DEPARTMENT:
						user.setDepartment(tag.getTextContent());
						break;
					case COMMENT:
						break;
					case TEXT:
						break;
					default:

						System.err.println("unhandled case " + tag.getNodeName());
						break;
					}
				}
				System.out.println(DATABASE + " = " + user.getDatabase());
			}

			// app settings
			NodeList appSettings = doc.getElementsByTagName(APP_SETTINGS).item(0).getChildNodes();

			for (Node setting : asList(appSettings)) {
				switch (setting.getNodeName()) {
				case SHOW_MOTD:
					boolean showMotd = false;
					String value = setting.getTextContent();
					if (value != null) {
						showMotd = Boolean.parseBoolean(value);
					}
					System.out.println(SHOW_MOTD + " = " + showMotd);
					break;
				case COMMENT:
					break;
				case TEXT:
					break;
				default:
					System.err.println("unhandled case " + setting.getNodeName());
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

	}

	/**
	 * Debug print loop.
	 * 
	 * @param nl
	 *            NodeList
	 */
	@SuppressWarnings("unused")
	private static void printList(NodeList nl) {
		for (Node n : asList(nl)) {
			boolean verbose = true;
			if (!verbose) {
				if (IGNORE.contains(n.getNodeName())) {
					continue;
				}
			}
			System.out.println(n.getNodeType() + " " + n.getNodeName() + " " + n.getNodeValue());
		}
		System.exit(0);
	}

}
