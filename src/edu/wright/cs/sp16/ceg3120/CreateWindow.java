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
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

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

/**
 * The Create_GUI class.
 */
public class CreateWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	// title label
	private JLabel title = new JLabel("Create Window");

	// input labels
	private JLabel inputLabel1 = new JLabel("Name: ");
	private JLabel inputLabel2 = new JLabel("Database URL: ");
	private JLabel inputLabel3 = new JLabel("Username: ");
	private JLabel inputLabel4 = new JLabel("Password: ");
	private JLabel inputLabel5 = new JLabel("Driver: ");
	private JLabel inputLabel6 = new JLabel("Save Password?");
	private JLabel inputLabel7 = new JLabel("Auto-Connect On Startup?");

	// new buttons
	private JButton save = new JButton("Save");
	private JButton clear = new JButton("Clear");
	// private JButton exit = new JButton("Exit");

	// input fields for the labels
	private static JTextField name = new JTextField(10);
	private static JTextField databaseUrl = new JTextField(10);
	private static JTextField username = new JTextField(10);
	private static JTextField password = new JTextField(10);
	static String[] testStrings = { "None Selected", "Demo Driver 1", "Demo Driver 2", 
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
	private JPanel bigPanel = new JPanel();

	// ActionListener for clear button
	private static ActionListener clearListener = new ClearListener();
	private static ActionListener saveListener = new SaveListener();
	// private ActionListener exitListener = new ExitListener();

	/**
	 * Constructor.
	 */
	public CreateWindow() {
		super("Create");

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
		buttonPanel.setLayout(new GridLayout(1, 2));
		buttonPanel.add(save);
		buttonPanel.add(clear);
		clear.addActionListener(clearListener);
		save.addActionListener(saveListener);
		// exit.addActionListener(exitListener);
		controlPanel.add(buttonPanel);
	}

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
		}
	}

	/**
	 * make save button to work.
	 */
	private static class SaveListener implements ActionListener {
		
		/**
		 * Write User's name, Database URL, Username, encrypted password and salt to a file. 
		 */

		public void writeEncrypt(byte[] encPass, byte[] salt) {
			try {
				FileOutputStream output = new FileOutputStream("UserData/" + username.getText());
				try {
					output.write(name.getText().getBytes());
					output.write(System.getProperty("line.separator").getBytes());
					output.write(databaseUrl.getText().getBytes());
					output.write(System.getProperty("line.separator").getBytes());
					output.write(username.getText().getBytes());
					output.write(System.getProperty("line.separator").getBytes());
					output.write(encPass);
					output.write(System.getProperty("line.separator").getBytes());
					output.write(salt);
					
					
				} finally {
					output.close();
				}
			} catch (FileNotFoundException ex) { 
				//"File not found.";
			} catch (IOException ex) {
				//log(ex);
			} 
		}
		
		/**
		 * Read User's name, Database URL, Username, encrypted password and salt from a file. 
		 */
		public void readEncrypt(String userName) {
			try {
			//final PasswordEncryptionService pes = new PasswordEncryptionService(); //testing
				File file = new File("UserData/" + userName);
				
				InputStream inputSteam = new FileInputStream(file);
				byte[] readName = new byte[(int)name.getText().getBytes().length ];
				byte[] readDatabase = new byte[(int) databaseUrl.getText().getBytes().length];
				byte[] readUser = new byte[(int) username.getText().getBytes().length];
				byte[] pass = new byte[(int) 20];
				byte[] line = new byte[(int) 2];
				byte[] salt = new byte[(int) 8];
				final ArrayList<byte[]> userInfoLst = new ArrayList<byte[]>();
				inputSteam.read(readName);
				inputSteam.read(line);	
				inputSteam.read(readDatabase);
				inputSteam.read(line);
				inputSteam.read(readUser);
				inputSteam.read(line);
				inputSteam.read(pass);
				inputSteam.read(line);
				inputSteam.read(salt);
					
				userInfoLst.add(readName);
				userInfoLst.add(readDatabase);
				userInfoLst.add(readUser);
				userInfoLst.add(pass);
				userInfoLst.add(salt);
				inputSteam.close();
				//System.out.println(pes.authenticate(password.getText(), 
				//userInfoLst.get(3) , userInfoLst.get(4)));
				//System.out.println((new String(userInfoLst.get(0)))); //testing
				//System.out.println(((new String(userInfoLst.get(1))))); //testing
				//System.out.println(((new String(userInfoLst.get(2))))); //testing
				//System.out.println(Arrays.toString(userInfoLst.get(3))); //testing
				//System.out.println(Arrays.toString(userInfoLst.get(4))); //testing
			} catch (IOException ex) {
			//exception
			}
				
		}
		
		/**
		 * Listen for save button click.
		 */
		
		public void actionPerformed(ActionEvent ae) {
			
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
					writeEncrypt(encPass, salt);
					readEncrypt(username.getText()); //testing
				} catch (NoSuchAlgorithmException e) {
					System.err.println("Caught NoSuchAlgorithmException: " + e.getMessage());
				} catch (InvalidKeySpecException e) {
					System.err.println("Caught InvalidKeySpecException: " + e.getMessage());
				}
				

				
			} //else {
				
			//}
			JOptionPane.showMessageDialog(null, "This button is not yet implemented. " 
					+ "This can be milestone 2.");
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
		// end of Main Method
	}
	// end of CreateWindow
}
