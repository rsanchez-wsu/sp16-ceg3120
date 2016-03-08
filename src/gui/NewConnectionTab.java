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

package gui;

import testconnection.DbConnection;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A window for entering DB connection details
 * @author carl.heritage
 *
 */
public class NewConnectionTab extends JPanel {
	private static final long serialVersionUID = 1L;
	private WinMain mainWinRef;
	private DbConnection dbConn;
	
	private final JPanel connContentPanel = new JPanel();
	private static final JLabel dburlLabel = new JLabel("Database URL: ");
	private final JTextField dburlTextField = new JTextField();
	private static final JLabel jdbcTypesLabel = new JLabel("JDBC Type: ");
	private static final String[] jdbcTypes = {"derby","mysql","postgresql"};
	private final JComboBox<String> jdbcTypesBox = new JComboBox<String>(jdbcTypes);
	private static final JLabel userLabel = new JLabel("User Name: ");
	private final JTextField userTextField = new JTextField();
	private static final JLabel passLabel = new JLabel("Password: ");
	private final JTextField passTextField = new JTextField();
	private final JButton submitConnButton = new JButton("Submit");
	
	
	/**
	 * Constructor for a CreateConnWindow.
	 * @param mainRef Reference to the window using it.
	 */
	public NewConnectionTab(WinMain mainRef) {
		super();
		
		mainWinRef = mainRef;
		setLayout(new BorderLayout());
		add(new JLabel("The left side"), BorderLayout.PAGE_START);
		
		connContentPanel.setLayout(new GridLayout(5,2));
		connContentPanel.add(jdbcTypesLabel);
		connContentPanel.add(jdbcTypesBox);
		connContentPanel.add(dburlLabel);
		connContentPanel.add(dburlTextField);
		connContentPanel.add(userLabel);
		connContentPanel.add(userTextField);
		connContentPanel.add(passLabel);
		connContentPanel.add(passTextField);
		connContentPanel.add(submitConnButton);
		connContentPanel.setMaximumSize(new Dimension(100, 200));
		add(connContentPanel, BorderLayout.CENTER);
		setSize(new Dimension(100, 200));
		submitConnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				try {
					dbConn = new DbConnection(dburlTextField.getText(),
							jdbcTypesBox.getSelectedItem().toString(),
							userTextField.getText(),
							passTextField.getText());
					mainWinRef.notifyConnResult();					
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("DB connection failed.");
				}
			}
			
		});

		setVisible(true);
	}
		
	/**
	 * Returns the DBConnection.
	 * @return the DBConnection
	 */
	public DbConnection getDbConnection() {
		return dbConn;
	}
	
	/**
	 * Resets the fields of the window.
	 */
	public void reset() {
		jdbcTypesBox.setSelectedIndex(0);;
		dburlTextField.setText("");
		userTextField.setText("");
		passTextField.setText("");
		
		dbConn = null;
	}
}
