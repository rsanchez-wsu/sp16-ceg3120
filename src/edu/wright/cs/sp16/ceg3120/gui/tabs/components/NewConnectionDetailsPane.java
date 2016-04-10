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

package edu.wright.cs.sp16.ceg3120.gui.tabs.components;

import edu.wright.cs.sp16.ceg3120.gui.MainTabPane;
import edu.wright.cs.sp16.ceg3120.gui.other.Inputs;
import edu.wright.cs.sp16.ceg3120.sql.DatabaseConnector;
import edu.wright.cs.sp16.ceg3120.sql.MySqlConnect;
import edu.wright.cs.sp16.ceg3120.sql.PostgreConnect;
import edu.wright.cs.sp16.ceg3120.util.PasswordEncryptionUtility;
import edu.wright.cs.sp16.ceg3120.util.XmlUtil;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 * @author Devesh Amin The CreateWindow class.
 * 
 */
public class NewConnectionDetailsPane extends JPanel {

	private static final long serialVersionUID = 1L;

	// used to test if connection to db was made
	private static boolean connected = false;

	// main tab used to add querybuilder tab
	private static MainTabPane mainTab;

	// input fields
	static int numOfComponents = 8;

	private static final JComponent[] inputFields = new JComponent[numOfComponents];
	static String[] driverNames = { 
			"Choose a Driver", "MySQL Driver", "PostgreSQL Driver", "Derby Driver"
	};
	private static JComboBox<String> aliases;

	// creating panels to add labels and text boxes
	private static JPanel svAlias = new JPanel();

	// ActionListener for buttons
	private static ActionListener actionHandler = new ActionHandler();

	/**
	 * Constructor for CreatWindow.
	 * 
	 * @author Devesh Amin, Nick Madden
	 */
	public NewConnectionDetailsPane(MainTabPane mainTabPane) {

		setMainTab(mainTabPane);
		// Title Panel and its position
		add(createTitlePanel(), BorderLayout.NORTH);

		// Create gui input fields
		JPanel gui = new JPanel();
		gui.setLayout(new GridLayout(8, 2, 30, 10));

		for (int i = 0; i <= 7; i++) {
			JPanel jpanel = new JPanel();
			JLabel jlabel = new JLabel(Inputs.get(i).toString());
			jlabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
			jpanel.setLayout(new GridLayout(0, 2, 10, 20));
			jpanel.add(jlabel);

			if (i == Inputs.driver.getId()) {
				jlabel.setText("");
				JComboBox<String> jcb = new JComboBox<String>(driverNames);
				jcb.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
				inputFields[i] = jcb;
				jpanel.add(jcb);
			} else if (i == Inputs.save.getId() || i == Inputs.autoCon.getId()) {
				jlabel.setText("");
				JCheckBox jcb = new JCheckBox();
				jcb.setText((i == Inputs.save.getId() ? "Save Password" : "Auto Connect"));
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
		add(gui, BorderLayout.CENTER);
		add(createControlPanel(), BorderLayout.SOUTH);
	}

	/**
	 * Adding title to panel.
	 * 
	 * @author Devesh Amin, Nick Madden
	 */
	private JPanel createTitlePanel() {
		// Get list of saved aliases for combobox
		JPanel jpanel = new JPanel();
		String[] listA = XmlUtil.populateAlias();
		aliases = new JComboBox<String>(listA);

		JLabel title = new JLabel("Create an Alias", SwingConstants.CENTER);
		jpanel.setLayout(new GridLayout(3, 1));
		jpanel.add(title);

		aliases.setActionCommand("Alias");
		aliases.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		aliases.addActionListener(actionHandler);
		jpanel.add(aliases);
		return jpanel;
	}

	/**
	 * Adds buttons to window.
	 * 
	 * @author Devesh Amin, Nick Madden
	 */
	private JPanel createControlPanel() {
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 20));

		JButton connect = new JButton("Connect");
		connect.setActionCommand("Connect");
		connect.addActionListener(actionHandler);
		jpanel.add(connect);

		JButton delete = new JButton("Delete");
		delete.setActionCommand("Delete");
		delete.addActionListener(actionHandler);
		jpanel.add(delete);

		JButton clear = new JButton("Clear");
		clear.setActionCommand("Clear");
		clear.addActionListener(actionHandler);
		jpanel.add(clear);

		return jpanel;
	}

	/**
	 * Save alias to file.
	 * 
	 * @author Nick Madden
	 */
	public static void saveAndConnect() {
		String alias = ((JTextField) inputFields[Inputs.alias.getId()]).getText();
		String dbName = ((JTextField) inputFields[Inputs.dbName.getId()]).getText();
		String dbAddress = ((JTextField) inputFields[Inputs.dbUrl.getId()]).getText();
		String dbUsername = ((JTextField) inputFields[Inputs.username.getId()]).getText();
		String dbPassword = ((JTextField) inputFields[Inputs.password.getId()]).getText();
		@SuppressWarnings("unchecked")
		int dbDriver = ((JComboBox<String>) inputFields[Inputs.driver.getId()]).getSelectedIndex();
		boolean svPass = ((JCheckBox) inputFields[Inputs.save.getId()]).isSelected();
		// Autoconnect not yet a feature.
		// boolean autoCon = ((JCheckBox)
		// inputFields[Inputs.autoCon.getId()]).isSelected();
		UIManager.put("OptionPane.yesButtonText", "Save and Connect");
		UIManager.put("OptionPane.noButtonText", "Connect");
		int sv = JOptionPane.showConfirmDialog(svAlias, "Do you want to save the \"" 
				+ alias + "\" alias?",
				"Save Alias?", JOptionPane.YES_NO_CANCEL_OPTION);
		UIManager.put("OptionPane.yesButtonText", "Yes");
		UIManager.put("OptionPane.noButtonText", "No");
		if (sv == JOptionPane.YES_OPTION) {
			String pass = "";
			if (svPass) {
				pass = dbPassword;
				pass = PasswordEncryptionUtility.encrypt(pass);
			}
			if (!XmlUtil.writeAlias(alias, dbName, dbAddress, dbUsername, pass, svPass, dbDriver)) {
				aliases.addItem(alias);
			}

		}
		if (sv != JOptionPane.CANCEL_OPTION) {
			switch (dbDriver) {
			// MySQL Driver
			case 1:
				MySqlConnect connect = new MySqlConnect(dbAddress, dbUsername, dbPassword, dbName);
				try {
					connect.configure();
					setConnected(true);
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					testConnection(getConnected(), connect);
				}
				break;
			// PostgreSQL Driver
			case 2:
				PostgreConnect postConnect = new PostgreConnect(
						dbAddress, dbUsername, dbPassword, dbName);
				try {
					postConnect.configure();
					setConnected(true);
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					//testConnection(getConnected(), postConnect);
				}
				break;
			// No driver
			default:
				System.out.println("ERROR: Driver not found!");
			}
		}
	}

	/**
	 * will do something whether the connection was successful. currently will
	 * open the querybuildertab when the database is connected.
	 * @param connected set if the database is connected
     */
	private static void testConnection(boolean connected, DatabaseConnector connector) {
		if (!connected) {
			//generate error
		} else {
			getMainTab().addQuerybuilderTab(connector);
			getMainTab().setSelectedIndex(getMainTab().getTabCount() - 1);
		}
	}

	/**
	 * Clears all input boxes.
	 * 
	 * @author Nick Madden
	 */
	@SuppressWarnings("unchecked")
	public static void clearInput() {
		for (int i = 0; i <= 4; i++) {
			((JTextField) inputFields[i]).setText("");
		}
		((JCheckBox) inputFields[Inputs.save.getId()]).setSelected(false);
		((JCheckBox) inputFields[Inputs.autoCon.getId()]).setSelected(false);
		((JComboBox<String>) inputFields[Inputs.driver.getId()]).setSelectedIndex(0);
		;
		((JTextField) inputFields[0]).grabFocus();
	}

	/**
	 * gets the maintab.
	 * @returns maintab
     */
	public static MainTabPane getMainTab() {
		return mainTab;
	}

	/**
	 * sets the maintab.
	 * @param mainTab for program
     */
	public static void setMainTab(MainTabPane mainTab) {
		NewConnectionDetailsPane.mainTab = mainTab;
	}

	/**
	 * gets connected.
	 * @return connected
     */
	public static boolean getConnected() {
		return connected;
	}

	/**
	 * sets connected.
	 * @param connected set if database is connected
     */
	public static void setConnected(boolean connected) {
		NewConnectionDetailsPane.connected = connected;
	}


	/**
	 * Handles all actions.
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
				int dbDriver = ((JComboBox<String>) inputFields[Inputs.driver.getId()])
									.getSelectedIndex();
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
					JOptionPane.showMessageDialog(svAlias, 
							"Can not proceed with empty fields!" + " Try again.",
							"Failed", JOptionPane.ERROR_MESSAGE);
					break;

				// No driver selected
				case 2:
					((JTextField) inputFields[Inputs.alias.getId()]).grabFocus();
					JOptionPane.showMessageDialog(svAlias, 
							"A driver must be selected!" + " Try again.", "Failed",
							JOptionPane.ERROR_MESSAGE);
					// No errors
					break;

				default:
					saveAndConnect();
				}
				break;

			case "Clear":
				clearInput();
				break;

			case "Delete":
				boolean deleted = XmlUtil.removeAlias(aliases.getSelectedItem().toString());
				if (deleted) {
					aliases.removeItem(aliases.getSelectedItem());
					clearInput();
				}
				break;

			case "Alias":
				String toRead = aliases.getSelectedItem().toString();
				if (!toRead.equals("Load an Alias")) {
					((JTextField) inputFields[Inputs.alias.getId()]).setText(toRead);
					((JTextField) inputFields[Inputs.alias.getId()]).grabFocus();
					XmlUtil.readAlias(toRead, inputFields);
				}
				break;

			default:
				System.out.println("ERROR: Action not found!");
			}
		}
	}
}