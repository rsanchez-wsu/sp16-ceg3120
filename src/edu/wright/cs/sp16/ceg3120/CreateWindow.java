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

// Imports for GUI
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	private JLabel inputLabel1 = new JLabel("Alias Name: ");
	private JLabel inputLabel2 = new JLabel("Database URL: ");
	private JLabel inputLabel3 = new JLabel("Username: ");
	private JLabel inputLabel4 = new JLabel("Password: ");
	private JLabel inputLabel5 = new JLabel("Driver: ");
	private JLabel inputLabel6 = new JLabel("Save Password?");
	private JLabel inputLabel7 = new JLabel("Auto-Connect On Startup?");

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
	static String[] testStrings = { "None Selected", "MySQL Driver", "Demo Driver 2", 
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
	private JPanel inputPanel3 = new JPanel();
	private JPanel inputPanel4 = new JPanel();
	private JPanel inputPanel5 = new JPanel();
	private JPanel inputPanel6 = new JPanel();
	//private JPanel connectPanel = new JPanel();
	private static JPanel saveAlias = new JPanel();
	private JPanel bigPanel = new JPanel();
	private static JPanel failPanel = new JPanel();

	// ActionListener for clear button
	private static ActionListener clearListener = new ClearListener();
	//private static ActionListener saveListener = new SaveListener();
	private static ActionListener connectListener = new ConnectListener();
	// private ActionListener exitListener = new ExitListener();

	
	/**
	 * Constructor.
	 */
	public CreateWindow() {
		super("Create Window");

		// Title Panel and its position
		createTitlePanel(title);
		getContentPane().add(titlePanel, BorderLayout.NORTH);

		// input panel for Name and its position
		createInput1Panel();
		getContentPane().add(inputPanel1, BorderLayout.CENTER);

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
		
	} //end of CreateWindow constructor

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
		inputPanel1.add(inputLabel1);
		inputPanel1.add(name);
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
		bigPanel.setLayout(new GridLayout(6, 1));
		createInput1Panel();
		bigPanel.add(inputPanel1);
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
	 * @author kenton
	 *     make connect button work.
	 * 
	 * @author chris
	 *     make password encrypt and read/wite to the file.
	 *     
	 */
	private static class ConnectListener implements ActionListener {

		/**
		 * Write User's name, Database URL, Username, encrypted password and salt to a file. 
		 */
		public void writeEncrypt(byte[] encPass, byte[] salt) {
			try {
				if (new File("UserData").isFile() == false) {
					File dir = new File("UserData");
					if (dir.mkdir() == false) {
						System.out.print("");
					}
				}
				FileOutputStream output = new FileOutputStream("UserData/" + username.getText());
				try {
					output.write(encPass);
					output.write(System.getProperty("line.separator").getBytes("Cp1252"));
					output.write(salt);
					output.write(System.getProperty("line.separator").getBytes("Cp1252"));
					output.write(name.getText().getBytes("Cp1252"));
					output.write(System.getProperty("line.separator").getBytes("Cp1252"));
					output.write(databaseUrl.getText().getBytes("Cp1252"));
					output.write(System.getProperty("line.separator").getBytes("Cp1252"));
					output.write(username.getText().getBytes("Cp1252"));
					output.write(System.getProperty("line.separator").getBytes("Cp1252"));


				} finally {
					output.close();
				}
			} catch (FileNotFoundException ex) { 
				//"File not found.";
			} catch (IOException ex) {
				//log(ex);
			} 
		} //end of writeEncrypt
		
		/**
		 * Read all bytes in the file. 
		 */
		public static byte[] getBytesFromFile(File file) throws IOException {
			InputStream is = new FileInputStream(file);
			try {
				long length = file.length();
		
				byte[] bytes = new byte[(int)length];

				int offset = 0;
				int numRead = 0;
				while (offset < bytes.length
						&& (numRead = is.read( bytes, offset, bytes.length - offset )) >= 0) {
					offset += numRead;
				}

				if (offset < bytes.length) {
					is.close();
					throw new IOException("Could not completely read file " + file.getName());
				}

				is.close();
				return bytes;
			} finally {
				is.close();
				
			} 
		} //end of getBytesFromFile
		//public byte[] findNewLINE(InputStream inputSteam, )
		
		/**
		 * Read User's name, Database URL, Username, encrypted password and salt from a file. 
		 */
		public ArrayList<byte[]> readEncrypt(String userName) {
			String[] separated = null;
			final ArrayList<byte[]> userInfoLst = new ArrayList<byte[]>();
			try {
				File file = new File("UserData/" + userName);
				
				InputStream inputSteam = new FileInputStream(file);
				try {
					try {
											
						int endOfFile = 0;
						byte[] pass = new byte[20];
						byte[] line = new byte[2];
						byte[] salt = new byte[8];
						endOfFile = inputSteam.read(pass);
						endOfFile = inputSteam.read(line);
						endOfFile = inputSteam.read(salt);
				
						String filedata = new String(getBytesFromFile(file), "Cp1252");
						
						separated = filedata.split(System.getProperty("line.separator"));
						inputSteam.close();
						userInfoLst.add(separated[2].getBytes("Cp1252"));
						userInfoLst.add(separated[3].getBytes("Cp1252"));
						userInfoLst.add(separated[4].getBytes("Cp1252"));
						userInfoLst.add(pass);
						userInfoLst.add(salt);
						userInfoLst.add(line);
						
						
						if (endOfFile == -1) {
							inputSteam.close();
							System.out.print("endOfFile");
						} else {

							inputSteam.close();	
						}
						
					} finally {
						inputSteam.close();
						
					} 
				} catch (IOException ex) {
				
					//exception
				}
			} catch (FileNotFoundException ex) {
				//exception
			}
			return userInfoLst;
		} //end of readEncrypt 
		

		/**
		 * save alias?.
		 * 
		 */
		public void saveAlias() {
			int sv = JOptionPane.showConfirmDialog(saveAlias,
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
			if (savePassword.isSelected()) {
				String pass = password.getText();
				byte[] encPass;

				// Encryption
				final PasswordEncryptionService pes = new PasswordEncryptionService();
				try {
					byte[] salt = pes.generateSalt();
					encPass = pes.getEncryptedPassword(pass, salt);
					System.out.println("Pass: " + pass);
					System.out.println("Encrypted Pass: " + Arrays.toString(encPass));
					System.out.println("Encrypted Pass: " + Arrays.toString(salt));
					// Save salt and encrypted password to file
					
					//Testing for write and read functions
					writeEncrypt(encPass, salt);
					final ArrayList<byte[]> readDataEncrypt =
							readEncrypt(username.getText()); //testing
					System.out.println("Database Name: " 
							+ new String(readDataEncrypt.get(0), "Cp1252"));
					System.out.println("DataBase URL: " 
							+ new String(readDataEncrypt.get(1), "Cp1252"));
					System.out.println("Username: " 
							+ new String(readDataEncrypt.get(2), "Cp1252"));
					System.out.println("Stored Encrypted Pass: " 
							+ Arrays.toString(readDataEncrypt.get(3)));
					System.out.println("Stored Encrypted Pass: " 
							+ Arrays.toString(readDataEncrypt.get(4)));
					System.out.println("Is Pass Word Correct?: " 
							+ pes.authenticate(pass, readDataEncrypt.get(3),
									readDataEncrypt.get(4)));
					/*{
					
						Code to send the password to the text field
						for the autofill feature.
						
					}*/
				} catch (NoSuchAlgorithmException e) {
					System.err.println("Caught NoSuchAlgorithmException: " + e.getMessage());
				} catch (InvalidKeySpecException e) {
					System.err.println("Caught InvalidKeySpecException: " + e.getMessage());
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
			} //don't need an else statement here
			// Required alias name, database URL, and username to save
			if (name.getText().trim().length() == 0 || databaseUrl.getText().trim().length() == 0
					|| username.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(null,"Save failed: alias name, database URL, and"
						+ " username are required.");
			}			
		
			DbConnect connect = new DbConnect();
			String dbName = name.getText();
			String dbAddress = databaseUrl.getText();
			String dbUsername = username.getText();
			String dbPassword = password.getText();
			String dbDriver = driver.getSelectedItem().toString();
			System.out.println(dbDriver);
			
			// Requires that all boxes be completed (alias name, db URL, username, password, driver)
			if (name.getText().trim().length() == 0 ) {
				JOptionPane.showMessageDialog(null,"Connection failed: alias name is required.");
			} else if (databaseUrl.getText().trim().length() == 0 ) {
				JOptionPane.showMessageDialog(null,"Connection failed: database URL is required.");
			} else if (username.getText().trim().length() == 0 ) {
				JOptionPane.showMessageDialog(null,"Connection failed: username is required.");
			} else if (password.getText().trim().length() == 0 ) {
				JOptionPane.showMessageDialog(null,"Connection failed: password is required.");
			} else if (dbDriver.equals("MySQL Driver")) {
				connect = new DbConnect(dbAddress, dbUsername, dbPassword, dbName);
			} else {
				JOptionPane.showMessageDialog(failPanel, "Connection failed: "
						+ "driver selection is required.");
			}
			try {
				connect.configure();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}//end of actionPerformed
	}//end of ConnectListener
	
	/**
	 * make clear button to work.
	 */
	private static class ClearListener implements ActionListener {
		/**
		 * setting all the TextBoxes, CheckBoxes and ComboBoxes to its default
		 * state.
		 */
		public void actionPerformed(ActionEvent ae) {
			name.setText("");
			databaseUrl.setText("");
			username.setText("");
			password.setText("");
			driver.setSelectedIndex(0);
			savePassword.setSelected(false);
			autoConnect.setSelected(false);
		}//end of actionPerformed
	}//end of ClearListener 

	/**
	 * Main Method.
	 */
	public static void main(String[] args) {
		final CreateWindow cw = new CreateWindow();
		cw.setSize(500, 500); // set size of cw frame
		cw.setVisible(true);
		cw.setLocationRelativeTo(null); // centered
		cw.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // don't close on "X"
		cw.pack();
		cw.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				int answer = JOptionPane.showConfirmDialog(cw, "Do you really want to quit?", 
						"Quit",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (answer == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			} // end of widowClosing

		}); // end of WindowListener
		
	}// end of Main Method
	
}// end of CreateWindow
