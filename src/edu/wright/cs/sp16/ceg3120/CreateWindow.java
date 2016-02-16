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

//import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
//import java.io.FileOutputStream;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

//import javafx.scene.control.ComboBox;

/**
 * @author Devesh Amin
 *     The CreateWindow class.
 * 
 */
public class CreateWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	// title label
	private JLabel title = new JLabel("Create Database");

	// input labels
	private JLabel inputLabel1 = new JLabel("Database Name: ");
	private JLabel inputLabel2 = new JLabel("Database URL: ");
	private JLabel inputLabel3 = new JLabel("Username: ");
	private JLabel inputLabel4 = new JLabel("Password: ");
	private JLabel inputLabel5 = new JLabel("Driver: ");
	private JLabel inputLabel6 = new JLabel("Save Password?");
	private JLabel inputLabel7 = new JLabel("Auto-Connect On Startup?");
	private JLabel inputLabel8 = new JLabel("Alias Name");

	// new buttons
	//private JButton save = new JButton("Save");
	private JButton clear = new JButton("Clear");
	private JButton connect = new JButton("Connect");
	// private JButton exit = new JButton("Exit");

	// input fields for the labels
	private static JTextField name = new JTextField(10);
	private static JTextField databaseUrl = new JTextField(10);
	private static JTextField username = new JTextField(10);
	private static JTextField password = new JTextField(10);
	private static JTextField alias = new JTextField(10);
	static String[] testStrings = { "None Selected", "MySQL Driver", "PostgreSQL Driver",
			"Demo Driver 3" };
	private static JComboBox<?> driver = new JComboBox<Object>(testStrings);
	private static JCheckBox savePassword = new JCheckBox();
	private static JCheckBox autoConnect = new JCheckBox();

	// creating panels to add labels and text boxes
	private JPanel titlePanel = new JPanel();
	private JPanel controlPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JPanel inputPanel1 = new JPanel();
	private JPanel inputPanel2 = new JPanel();
	private JPanel inputPanel2a2 = new JPanel();
	private JPanel inputPanel3 = new JPanel();
	private JPanel inputPanel4 = new JPanel();
	private JPanel inputPanel5 = new JPanel();
	private JPanel inputPanel6 = new JPanel();
	//private JPanel connectPanel = new JPanel();
	private JPanel bigPanel = new JPanel();
	private static JPanel svAlias = new JPanel();

	// ActionListener for clear button
	private static ActionListener clearListener = new ClearListener();
	//private static ActionListener saveListener = new SaveListener();
	private static ActionListener connectListener = new ConnectListener();
	// private ActionListener exitListener = new ExitListener();

	/**
	 * Constructor.
	 */
	public CreateWindow() {
		super("Connect to Database");

		// Title Panel and its position
		createTitlePanel(title);
		getContentPane().add(titlePanel, BorderLayout.NORTH);

		// input panel for Name and its position
		createInput1Panel();
		getContentPane().add(inputPanel1, BorderLayout.CENTER);
		
		//input panel for databaseName and its position
		createInput2a2Panel();
		getContentPane().add(inputPanel2a2, BorderLayout.CENTER);

		// input panel for databaseUrl and its position
		createInput2Panel();
		getContentPane().add(inputPanel2, BorderLayout.CENTER);

		// input panel for Username and its position
		createInput3Panel();
		getContentPane().add(inputPanel3, BorderLayout.CENTER);

		// input panel for password and its position
		createInput4Panel();
		getContentPane().add(inputPanel4, BorderLayout.CENTER);

		// input panel for driver and its position
		createInput5Panel();
		getContentPane().add(inputPanel5, BorderLayout.CENTER);

		// bigPanel for all the other panels
		createBigPanel();
		getContentPane().add(bigPanel, BorderLayout.CENTER);

		// control panel for buttons and its position
		createControlPanel();
		getContentPane().add(controlPanel, BorderLayout.SOUTH);
	}

	/**
	 * Adding title to panel.
	 */
	private void createTitlePanel(JLabel tt) {
		titlePanel.add(tt);
	}

	/**
	 * Adding grid, label and TextField for Name.
	 */
	private void createInput1Panel() {
		inputPanel1.setLayout(new GridLayout(1, 2));
		inputPanel1.add(inputLabel8);
		inputPanel1.add(alias);
	}

	/**
	 * Adding grid, label and TextField for Database Name.
	 */
	private void createInput2a2Panel() {
		inputPanel2a2.setLayout(new GridLayout(1, 2));
		inputPanel2a2.add(inputLabel1);
		inputPanel2a2.add(name);
	}
	
	/**
	 * Adding grid, label and TextField for DatabaseUrl.
	 */
	private void createInput2Panel() {
		inputPanel2.setLayout(new GridLayout(1, 2));
		inputPanel2.add(inputLabel2);
		inputPanel2.add(databaseUrl);
	}


	/**
	 * Adding grid, label and TextField for Username.
	 */
	private void createInput3Panel() {
		inputPanel3.setLayout(new GridLayout(1, 2));
		inputPanel3.add(inputLabel3);
		inputPanel3.add(username);
	}

	/**
	 * Adding grid, label and TextField for Password and 'Save Password.'
	 */
	private void createInput4Panel() {
		inputPanel4.setLayout(new GridLayout(2, 2));
		inputPanel4.add(inputLabel4);
		inputPanel4.add(password);
		inputPanel4.add(inputLabel6);
		inputPanel4.add(savePassword);
	}

	/**
	 * Adding grid, label and TextField for Driver.
	 */
	private void createInput5Panel() {
		inputPanel5.setLayout(new GridLayout(1, 2));
		inputPanel5.add(inputLabel5);
		inputPanel5.add(driver);
	}

	/**
	 * Adding grid, label and TextField for 'AutoConnect.'
	 */
	private void createInput6Panel() {
		inputPanel6.setLayout(new GridLayout(1, 2));
		inputPanel6.add(inputLabel7);
		inputPanel6.add(autoConnect);
	}

	/**
	 * Adding all the panels in one big panel with grid.
	 */
	private void createBigPanel() {
		bigPanel.setLayout(new GridLayout(7, 1));
		createInput1Panel();
		bigPanel.add(inputPanel1);
		createInput2a2Panel();
		bigPanel.add(inputPanel2a2);
		createInput2Panel();
		bigPanel.add(inputPanel2);
		createInput3Panel();
		bigPanel.add(inputPanel3);
		createInput4Panel();
		bigPanel.add(inputPanel4);
		createInput5Panel();
		bigPanel.add(inputPanel5);
		createInput6Panel();
		bigPanel.add(inputPanel6);
	}

	/**
	 * Adding buttons and setting grid for the buttons.
	 */
	private void createControlPanel() {
		controlPanel.setLayout(new GridLayout(1, 2));
		//connectPanel.setLayout(new GridLayout(1, 2));
		//connectPanel.add(connect);
		buttonPanel.setLayout(new GridLayout(1, 2));
		//buttonPanel.add(save);
		buttonPanel.add(connect);
		buttonPanel.add(clear);
		clear.addActionListener(clearListener);
		//save.addActionListener(saveListener);
		connect.addActionListener(connectListener);
		// exit.addActionListener(exitListener);
		//controlPanel.add(connectPanel);
		controlPanel.add(buttonPanel);
	}

	/**
	 * make connect button work.
	 * 
	 * @author kenton
	 *
	 */
	private static class ConnectListener implements ActionListener {
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
		 * @param salt
		 *            password salt
		 * @param savePass
		 *            Whether to save password or not
		 * @param driver
		 *            Driver to connect
		 * @throws IOException
		 *             Throws Input Output exceptions
		 * @throws SAXException
		 *             Throws SAX exceptions
		 */
		public static void writeAlias(String alias, String dbName, String dbUrl, String userName,
				String password, String salt, boolean savePass, String driver)
						throws SAXException, IOException {
			System.out.println("writing");
			try {

				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

				// root elements
				Document doc = docBuilder.parse("UserData\\aliases.xml");
				Element root = doc.getDocumentElement();

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

				Element ps = doc.createElement("password");
				ps.setAttribute("saved", (savePass ? "true" : "false"));
				if (savePass) {
					ps.appendChild(doc.createTextNode(password));
				}
				al.appendChild(ps);

				Element sl = doc.createElement("salt");
				sl.appendChild(doc.createTextNode((savePass ? salt : "")));
				ps.appendChild(sl);

				Element dv = doc.createElement("driver");
				dv.appendChild(doc.createTextNode(driver));
				al.appendChild(nm);

				// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File("UserData\\aliases.xml"));
				transformer.transform(source, result);

				System.out.println("File saved!");
			} catch (ParserConfigurationException pce) {
				pce.printStackTrace();
			} catch (TransformerException tfe) {
				tfe.printStackTrace();
			}

		}
		

		/** Reads an alias based on name.
		 * @param alias Alias name to read
		 */
		public static void readAlias(String alias) {
			try {
				File xmlFile = new File("UserData\\aliases.xml");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
				Document doc = docBuilder.parse(xmlFile);
				doc.getDocumentElement().normalize();
				System.out.println("reading");
				NodeList aliasList = doc.getElementsByTagName("alias");
				for (int i = 0; i < aliasList.getLength(); i++) {
					Node currentNode = aliasList.item(i);
					Element curElement = (Element) currentNode;
					if (currentNode.getNodeType() == Node.ELEMENT_NODE
							&& alias.equals(curElement.getAttribute("name"))) {
						System.out.println("dbName: "
								+ curElement.getElementsByTagName(""
										+ "dbName"
										).item(0).getTextContent());
						System.out.println("dbUrl: "
								+ curElement.getElementsByTagName(""
										+ "dbURL").item(0).getTextContent());
						System.out.println("userName: "
								+ curElement.getElementsByTagName(""
										+ "userName").item(0).getTextContent());
						curElement = (Element) curElement.getElementsByTagName("password").item(0);
						System.out.println("password: " + curElement.getTextContent().trim());
						System.out.println("salt: "
								+ curElement.getElementsByTagName("salt").item(0).getTextContent()
								+ "\n");
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
		 * save alias?.
		 * 
		 */
		public void saveAlias() {
			int sv = JOptionPane.showConfirmDialog(svAlias,
					"Do you want to save this alias?" ,
					"Save Alias?",
					JOptionPane.YES_NO_CANCEL_OPTION);
			if (sv == JOptionPane.CANCEL_OPTION) {
				JOptionPane option = new JOptionPane();
				option.setVisible(false);
			} //else if {...}
		}


		/**
		 * setting up the connection to a database.
		 */
		public void actionPerformed(ActionEvent ae) {
			/**
			 * @author Devesh Amin
			 *     Save alias while connecting to the database?.
			 */
			saveAlias();
			
			/**
			 * Saving password: make sure to encrypt.
			 */
			String passA = "";
			String saltA = "";
			if (savePassword.isSelected()) {
				String pass = password.getText();
				byte[] encPass;

				// Encryption
				final PasswordEncryptionService pes = new PasswordEncryptionService();
				try {
					byte[] salt = pes.generateSalt();
					encPass = pes.getEncryptedPassword(pass, salt);
					passA = Arrays.toString(encPass);
					saltA = Arrays.toString(salt);
				} catch (NoSuchAlgorithmException e) {
					System.err.println("Caught NoSuchAlgorithmException: " + e.getMessage());
				} catch (InvalidKeySpecException e) {
					System.err.println("Caught InvalidKeySpecException: " + e.getMessage());
				}

			}
			try {
				writeAlias(alias.getText(), name.getText(), databaseUrl.getText(),
						username.getText(), passA, saltA, savePassword.isSelected(),
						String.valueOf(driver.getSelectedItem()));
				readAlias("test");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			}
	
			String dbName = name.getText();
			String dbAddress = databaseUrl.getText();
			String dbUsername = username.getText();
			String dbPassword = password.getText();
			String dbDriver = driver.getSelectedItem().toString();
			System.out.println(dbDriver);
			if (dbDriver.equals("MySQL Driver")) {
				MySqlConnect connect = new MySqlConnect(dbAddress, dbUsername, dbPassword, dbName);
				try {
					connect.configure();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (dbDriver.equals("PostgreSQL Driver")) {
				PostgreConnect postgreConnect = new PostgreConnect(dbAddress, dbUsername,
						dbPassword, dbName);
				try {
					postgreConnect.configure();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}

	/**
	 * make clear button to work.
	 */
	private static class ClearListener implements ActionListener {
		/**
		 * setting all the TextBoxes, CheckBoxes and ComboBoxes to its default state.
		 */
		public void actionPerformed(ActionEvent ae) {
			name.setText("");
			databaseUrl.setText("");
			username.setText("");
			password.setText("");
			driver.setSelectedIndex(0);
			savePassword.setSelected(false);
			autoConnect.setSelected(false);
		}
	}

	/**
	 * Main Method.
	 */
	public static void main(String[] args) {
		final CreateWindow cw = new CreateWindow();
		cw.setSize(500, 500); // set size of cw frame
		cw.setVisible(true);
		cw.setLocationRelativeTo(null); // centered
		cw.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // don't close
																	// on "X"
		cw.pack();
		cw.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				int answer = JOptionPane.showConfirmDialog(cw, "Do you really want to quit?",
						"Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (answer == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			} // end of widowClosing

		}); // end of WindowListener
		// end of Main Method
	}
	// end of CreateWindow
}