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

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author Devesh Amin, Nick Madden.
 * 
 */
public class CreateWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	// title label
	private JLabel title = new JLabel("Aliases");

	// new buttons
	private JButton clear = new JButton("Clear");
	private JButton connect = new JButton("Connect");

	// input fields
	public static JComponent[] inputFields = new JComponent[8];
	static String[] driverNames = { "None Selected",
			"MySQL Driver", "PostgreSQL Driver", "Demo Driver 3" };
	private static JComboBox<String> aliases;

	// creating panels to add labels and text boxes
	private JPanel titlePanel = new JPanel();
	private JPanel controlPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private static JPanel svAlias = new JPanel();

	// ActionListener for buttons
	private static ActionListener actionHandler = new ActionHandler();

	/** Constructor for CreatWindow.
	 * @author Devesh Amin, Nick Madden
	 */
	public CreateWindow() {
		super("Connect to Database");

		// Title Panel and its position
		createTitlePanel(title);
		createControlPanel();
		getContentPane().add(titlePanel, BorderLayout.NORTH);

		// Create gui input fields
		JPanel gui = new JPanel();
		gui.setLayout(new GridLayout(8, 2, 30, 10));

		for (int i = 0; i <= 7; i++) {
			JPanel jpanel = new JPanel();
			jpanel.setLayout(new GridLayout(0, 2, 10, 0));
			jpanel.add(new JLabel(Inputs.get(i).toString()));

			if (i == Inputs.driver.getId()) {
				JComboBox<String> jcb = new JComboBox<String>(driverNames);
				inputFields[i] = jcb;
				jpanel.add(jcb);
			} else if (i == Inputs.save.getId() || i == Inputs.autoCon.getId()) {
				JCheckBox jcb = new JCheckBox();
				inputFields[i] = jcb;
				jpanel.add(jcb);
			} else if (i == Inputs.password.getId()) {
				JPasswordField jpf = new JPasswordField();
				inputFields[i] = jpf;
				jpanel.add(jpf);
			} else {
				JTextField jtf = new JTextField();
				inputFields[i] = jtf;
				jpanel.add(jtf);
			}
			gui.add(jpanel, BorderLayout.CENTER);
		}
		
		// Add to panels
		getContentPane().add(gui, BorderLayout.CENTER);
		getContentPane().add(controlPanel, BorderLayout.SOUTH);
	}

	/** Adding title to panel.
	 * @author Devesh Amin, Nick Madden
	 */
	private void createTitlePanel(JLabel tt) {
		// Get list of saved aliases for combobox
		String[] listA = XmlHandler.populateAlias();
		
		titlePanel.setLayout(new GridLayout(2, 1));
		titlePanel.add(tt);
		aliases = new JComboBox<String>(listA);
		aliases.setActionCommand("Alias");
		aliases.addActionListener(actionHandler);
		titlePanel.add(aliases);
	}

	/** Adds buttons to window.
	 * @author Devesh Amin, Nick Madden
	 */
	private void createControlPanel() {
		controlPanel.setLayout(new GridLayout(1, 2));
		buttonPanel.setLayout(new GridLayout(1, 2));
		buttonPanel.add(connect);
		buttonPanel.add(clear);
		clear.setActionCommand("Clear");
		clear.addActionListener(actionHandler);
		connect.setActionCommand("Connect");
		connect.addActionListener(actionHandler);
		controlPanel.add(buttonPanel);
	}

	/** Save alias to file.
	 * @author Nick Madden
	 */
	public static void saveAndConnect() {
		String alias = ((JTextField) inputFields[Inputs.alias.getId()]).getText();
		String dbName = ((JTextField) inputFields[Inputs.dbName.getId()]).getText();
		String dbAddress = ((JTextField) inputFields[Inputs.dbUrl.getId()]).getText();
		String dbUsername = ((JTextField) inputFields[Inputs.username.getId()]).getText();
		String dbPassword = ((JTextField) inputFields[Inputs.password.getId()]).getText();
		@SuppressWarnings("unchecked")
		int dbDriver = 
				((JComboBox<String>) inputFields[Inputs.driver.getId()]).getSelectedIndex();
		boolean svPass = ((JCheckBox) inputFields[Inputs.save.getId()]).isSelected();
		//Autoconnect not yet a feature.
		//boolean autoCon = ((JCheckBox) inputFields[Inputs.autoCon.getId()]).isSelected();
		
		int sv = JOptionPane.showConfirmDialog(svAlias, "Do you want to save "
				+ alias + " alias?", "Save Alias?", JOptionPane.YES_NO_CANCEL_OPTION);
		if (sv == JOptionPane.YES_OPTION) {
			String pass = "";
			if (svPass) {
				pass = dbPassword;
				pass = PasswordEncryptionService.encrypt(pass);
			}
			XmlHandler.writeAlias(alias, dbName, dbAddress, 
						dbUsername, pass, svPass, dbDriver);

		} else if (sv == JOptionPane.CANCEL_OPTION) {
			((JTextField) inputFields[Inputs.alias.getId()]).grabFocus();
		}
		
		switch (dbDriver) {
		// MySQL Driver
		case 1:
			MySqlConnect connect = new MySqlConnect(dbAddress, dbUsername, dbPassword, dbName);
			try {
				connect.configure();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		// PostgreSQL Driver
		case 2:
			PostgreConnect postgreConnect = 
					new PostgreConnect(dbAddress, dbUsername, dbPassword, dbName);
			try {
				postgreConnect.configure();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		// No driver
		default:
			System.out.println("ERROR: Driver not found!");
		}
	}
	
	/** Handles all actions.
	 * 
	 * @author Nick
	 *
	 */
	private static class ActionHandler implements ActionListener {
		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent ae) {
			String action = ae.getActionCommand();
			switch (action) {
			case "Connect": 
				int dbDriver = 
						((JComboBox<String>) inputFields[Inputs.driver.getId()]).getSelectedIndex();
				int error = 0;

				if (dbDriver == 0) {
					error = 2;
				}

				for (int i = 0; i <= 4; i++) {
					if (((JTextField) inputFields[i]).getText().equals("")) {
						error = 1;
						break;
					}
				}

				switch (error) {
				// Empty text fields
				case 1:
					((JTextField) inputFields[Inputs.alias.getId()]).grabFocus();
					JOptionPane.showMessageDialog(svAlias, "Can not proceed with empty fields!" 
							+ " Try again.", "Failed", JOptionPane.ERROR_MESSAGE);
					break;
					
				// No driver selected
				case 2:
					((JTextField) inputFields[Inputs.alias.getId()]).grabFocus();
					JOptionPane.showMessageDialog(svAlias, "A driver must be selected!" 
							+ " Try again.", "Failed", JOptionPane.ERROR_MESSAGE);
					// No errors
					break;
					
				default:
					saveAndConnect();
				}	
				break;
				
			case "Clear": 
				for (int i = 0; i <= 4; i++) {
					((JTextField) inputFields[i]).setText("");
				}
				((JCheckBox) inputFields[Inputs.save.getId()]).setSelected(false);
				((JCheckBox) inputFields[Inputs.autoCon.getId()]).setSelected(false);
				((JComboBox<String>) inputFields[Inputs.driver.getId()]).setSelectedIndex(0);;
				((JTextField) inputFields[0]).grabFocus();
				break;
				
			case "Alias":
				String toRead = aliases.getSelectedItem().toString();
				((JTextField) inputFields[Inputs.alias.getId()]).setText(toRead);
				((JTextField) inputFields[Inputs.alias.getId()]).grabFocus();
				XmlHandler.readAlias(toRead, inputFields);
				break;
				
			default: System.out.println("ERROR: Action not found!");
			}
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