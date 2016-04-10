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

package edu.wright.cs.sp16.ceg3120.util;

import edu.wright.cs.sp16.ceg3120.gui.other.Inputs;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;



/**
 * Handles all XML for aliases.
 * 
 * @author Nick Madden
 * 
 */
public class XmlUtil {

	private static JPanel ovrAlias = new JPanel();

	/**
	 * The removeAlias method removes a given alias.
	 * 
	 * @param alias
	 *            // Alias to remove
	 */
	public static boolean removeAlias(String alias) {
		try {
			File file = new File("UserData/aliases.xml");
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			docFactory.setValidating(true);
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc;

			if (file.exists()) {
				doc = docBuilder.parse("UserData/aliases.xml");
				NodeList aliasList = doc.getElementsByTagName("alias");
				for (int i = 0; i < aliasList.getLength(); i++) {
					Node currentNode = aliasList.item(i);
					Element curElement = (Element) currentNode;
					if (currentNode.getNodeType() == Node.ELEMENT_NODE
							&& alias.equals(curElement.getAttribute("name"))) {
						UIManager.put("OptionPane.yesButtonText", "Delete \"" + alias + "\"");
						UIManager.put("OptionPane.noButtonText", "Cancel");
						int sv = JOptionPane.showConfirmDialog(ovrAlias,
								"Are you sure you want to remove \"" + alias 
								+ "\"?", "Overwrite Alias?",
								JOptionPane.YES_NO_OPTION);
						UIManager.put("OptionPane.yesButtonText", "Yes");
						UIManager.put("OptionPane.noButtonText", "No");
						if (sv == JOptionPane.YES_OPTION) {
							curElement.getParentNode().removeChild(curElement);
							// write the content into xml file
							TransformerFactory transformerFactory = 
									TransformerFactory.newInstance();
							Transformer transformer = transformerFactory.newTransformer();
							DOMSource source = new DOMSource(doc);
							transformer.setOutputProperty(OutputKeys.INDENT, "yes");
							transformer.setOutputProperty("{http://xml.apache.org/xalan}line-separator", " ");
							transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
							transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "aliases.dtd");
							StreamResult result = new StreamResult(
									new File("UserData/aliases.xml")
									);
							transformer.transform(source, result);
							return true;
						} else if (sv == JOptionPane.NO_OPTION) {
							return false;
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Populates a list of aliases saved in the aliases.xml file.
	 * 
	 * @author Nick Madden
	 * @return list of aliases
	 */
	public static String[] populateAlias() {
		String[] listA = { "No Saved Aliases" };
		try {
			File xmlFile = new File("UserData/aliases.xml");
			if (xmlFile.exists()) {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				dbFactory.setValidating(true);
				DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
				Document doc = docBuilder.parse(xmlFile);
				doc.getDocumentElement().normalize();
				NodeList aliasList = doc.getElementsByTagName("alias");
				int length = aliasList.getLength();
				listA = new String[length + 1];
				listA[0] = "Load an Alias";
				for (int i = 0; i < length; i++) {
					Node currentNode = aliasList.item(i);
					Element curElement = (Element) currentNode;
					listA[i + 1] = curElement.getAttribute("name");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return listA;
	}

	/**
	 * Writes Alias to File.
	 * 
	 * @param alias
	 *            alias name
	 * @param dbName
	 *            database name
	 * @param dbUrl
	 *            database url
	 * @param userName
	 *            User name
	 * @param password
	 *            password
	 * @param savePass
	 *            Whether to save password or not
	 * @param driver
	 *            Driver to connect
	 * @throws IOException
	 *             Throws Input Output exceptions
	 * @throws SAXException
	 *             Throws SAX exceptions
	 */
	public static boolean writeAlias(String alias, String dbName, String dbUrl, String userName, 
			String password, boolean savePass, int driver) {
		try {
			File file = new File("UserData/aliases.xml");
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			docFactory.setValidating(true);
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Element root;
			Document doc;
			boolean overwrite = false;

			// root elements
			if (file.exists()) {
				doc = docBuilder.parse("UserData/aliases.xml");
				root = doc.getDocumentElement();
				NodeList aliasList = doc.getElementsByTagName("alias");
				for (int i = 0; i < aliasList.getLength(); i++) {
					Node currentNode = aliasList.item(i);
					Element curElement = (Element) currentNode;
					if (currentNode.getNodeType() == Node.ELEMENT_NODE
							&& alias.equals(curElement.getAttribute("name"))) {
						UIManager.put("OptionPane.yesButtonText", "Overwrite \"" + alias + "\"");
						UIManager.put("OptionPane.noButtonText", "Cancel");
						int sv = JOptionPane.showConfirmDialog(ovrAlias,
								"Alias \"" + alias 
								+ "\" already exists, do you want to overwrite it?",
								"Overwrite Alias?", JOptionPane.YES_NO_OPTION);
						UIManager.put("OptionPane.yesButtonText", "Yes");
						UIManager.put("OptionPane.noButtonText", "No");
						if (sv == JOptionPane.YES_OPTION) {
							curElement.getParentNode().removeChild(curElement);
							overwrite = true;
						} else if (sv == JOptionPane.NO_OPTION) {
							return true;
						}
					}
				}
			} else {
				boolean fileStatus = false;
				File userDir = new File("UserData");

				// if the directory does not exist, create it
				if (!userDir.exists()) {
					try {
						fileStatus = userDir.mkdir();
						if (fileStatus == false) {
							System.out.println(fileStatus);
						}
					} catch (SecurityException se) {
						// handle it
						System.out.println(fileStatus);
					}
				}
				doc = docBuilder.newDocument();
				root = doc.createElement("aliases");
				doc.appendChild(root);
			}

			Element al = doc.createElement("alias");
			al.setAttribute("name", alias);
			root.appendChild(al);

			Element db = doc.createElement("dbName");
			db.appendChild(doc.createTextNode(dbName));
			al.appendChild(db);

			Element ur = doc.createElement("dbURL");
			ur.appendChild(doc.createTextNode(dbUrl));
			al.appendChild(ur);

			Element nm = doc.createElement("userName");
			nm.appendChild(doc.createTextNode(userName));
			al.appendChild(nm);

			Element dv = doc.createElement("driver");
			dv.appendChild(doc.createTextNode(Integer.toString(driver)));
			al.appendChild(dv);

			Element ps = doc.createElement("password");
			ps.setAttribute("saved", (savePass ? "true" : "false"));
			al.appendChild(ps);

			Element sps = doc.createElement("pass");
			sps.appendChild(doc.createTextNode((savePass ? password : "")));
			ps.appendChild(sps);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xalan}line-separator", " ");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "aliases.dtd");
			StreamResult result = new StreamResult(new File("UserData/aliases.xml"));
			transformer.transform(source, result);
			return overwrite;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Reads an alias based on name.
	 * 
	 * @author Nick Madden
	 * @param alias
	 *            Alias name to read
	 * @param inputFields
	 *            Input fields from gui
	 */

	public static void readAlias(String alias, JComponent[] inputFields) {
		

		try {
			File xmlFile = new File("UserData/aliases.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			dbFactory.setValidating(true);
			DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			NodeList aliasList = doc.getElementsByTagName("alias");
			for (int i = 0; i < aliasList.getLength(); i++) {
				Node currentNode = aliasList.item(i);
				Element curElement = (Element) currentNode;
				if (currentNode.getNodeType() == Node.ELEMENT_NODE 
						&& alias.equals(curElement.getAttribute("name"))) {
					setCurrentAlias(curElement, inputFields);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Puts all the alias information in the form.
	 * 
	 * @param curElement the alias element
	 * @param inputFields the fields of input from the database
	 */
	private static void setCurrentAlias(Element curElement, JComponent[] inputFields) {
		JTextField name = ((JTextField) inputFields[Inputs.dbName.getId()]);
		
		name.setText(curElement.getElementsByTagName("dbName").item(0).getTextContent());

		JTextField databaseUrl = ((JTextField) inputFields[Inputs.dbUrl.getId()]);
		databaseUrl.setText(curElement.getElementsByTagName("dbURL").item(0).getTextContent());

		JTextField username = ((JTextField) inputFields[Inputs.username.getId()]);
		username.setText(curElement.getElementsByTagName("userName").item(0).getTextContent());

		@SuppressWarnings("unchecked")
		JComboBox<String> driver = ((JComboBox<String>) inputFields[Inputs.driver.getId()]);
		driver.setSelectedIndex(Integer.parseInt(
				curElement.getElementsByTagName("driver").item(0).getTextContent()
				));
		curElement = (Element) curElement.getElementsByTagName("password").item(0);
		String holdPass = curElement.getElementsByTagName("pass").item(0).getTextContent();

		JTextField password = ((JTextField) inputFields[Inputs.password.getId()]);
		password.setText(PasswordEncryptionUtility.decrypt(holdPass));
		
		JCheckBox savePassword = ((JCheckBox) inputFields[Inputs.save.getId()]);
		savePassword.setSelected(Boolean.valueOf(curElement.getAttribute("saved")));
	}
	
	/**
	 * Wraps a NodeList as a List collection. Useful for foreach loops.
	 * 
	 * 
	 * @param nl
	 *            NodeList
	 * @return NodeList as List
	 */
	public static List<Node> asList(NodeList nl) {
		return nl.getLength() == 0 ? Collections.<Node>emptyList() : new NodeListWrapper(nl);
	}

	/**
	 * List wrapper for NodeList.
	 */
	static final class NodeListWrapper extends AbstractList<Node> implements RandomAccess {
		private final NodeList list;

		/**
		 * Wraps a NodeList as a List
		 * 
		 * @param nl
		 *            NodeList.
		 */
		NodeListWrapper(NodeList nl) {
			list = nl;
		}

		@Override
		public Node get(int index) {
			return list.item(index);
		}

		@Override
		public int size() {
			return list.getLength();
		}
	}
}