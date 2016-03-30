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

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 * A window for entering DB connection details
 * @author carl.heritage
 *
 */
public class NewConnectionTab extends JPanel {
	private static final long serialVersionUID = 1L;
	private WinMain mainWinRef;
	private DbConnection dbConn;
	private final JLabel favLabel = new JLabel("Favorites");
	private final DefaultListModel<String> favListData = new DefaultListModel<String>();
	
	private final JPanel connContentPanel = new JPanel();
	private static final JLabel dburlLabel = new JLabel("Database URL: ");
	private final JTextField dburlTextField = new JTextField();
	private static final JLabel jdbcTypesLabel = new JLabel("JDBC Type: ");
	private static final String[] jdbcStrings = {"derby","mysql","postgresql"};
	private static DefaultComboBoxModel<String> jdbcTypes = 
			new DefaultComboBoxModel<String>(jdbcStrings);
	private final JComboBox<String> jdbcTypesBox = new JComboBox<String>(jdbcTypes);
	private static final JLabel userLabel = new JLabel("User Name: ");
	private final JTextField userTextField = new JTextField();
	private static final JLabel passLabel = new JLabel("Password: ");
	private final JTextField passTextField = new JTextField();
	private final JButton submitConnButton = new JButton("Submit");
	private final JList<String> favList = new JList<String>();
	private GridBagConstraints gbcFavList;
	
	/**
	 * Constructor for a CreateConnWindow.
	 * @param mainRef Reference to the window using it.
	 */
	public NewConnectionTab(WinMain mainRef) {
		super();
		
		mainWinRef = mainRef;
		
		//Test Values. Delete for Final version
		favListData.addElement("DB 1");
		favListData.addElement("DB 2");
		favListData.addElement("DB 3");
		favListData.addElement("DB 4");
		favListData.addElement("DB 5");
		favListData.addElement("DB 6");
		GridBagLayout newConngbLayout = new GridBagLayout();
		newConngbLayout.rowHeights = new int[]{0, 267, 294};
		newConngbLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		newConngbLayout.rowWeights = new double[]{0.0, 0.0, 1.0};
		newConngbLayout.columnWidths = new int[] {30, 100, 30, 276, 30};
		setLayout(newConngbLayout);
		GridBagConstraints gbcFavLabel = new GridBagConstraints();
		gbcFavLabel.gridy = 0;
		gbcFavLabel.gridx = 1;
		gbcFavLabel.anchor = GridBagConstraints.NORTH;
		gbcFavLabel.insets = new Insets(0, 0, 5, 5);
		add(favLabel, gbcFavLabel);
		favLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		GridBagConstraints gbcList = new GridBagConstraints();
		gbcList.insets = new Insets(0, 0, 0, 5);
		gbcList.fill = GridBagConstraints.BOTH;
		
		gbcFavList = new GridBagConstraints();
		gbcFavList.insets = new Insets(0, 0, 5, 5);
		gbcFavList.fill = GridBagConstraints.BOTH;
		gbcFavList.gridx = 1;
		gbcFavList.gridy = 1;
		//favList.setMaximumSize(new Dimension(200, 0));
		//favList.setPreferredSize(new Dimension(200, 0));
		add(favList, gbcFavList);
		//connContentPanel.setBounds(new Rectangle(0, 0, 100, 100));
		connContentPanel.setBackground(UIManager.getColor("Button.background"));
		GridBagLayout gblConnContentPanel = new GridBagLayout();
		connContentPanel.setLayout(gblConnContentPanel);
		jdbcTypesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		jdbcTypesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbcJdbcTypesLabel = new GridBagConstraints();
		gbcJdbcTypesLabel.anchor = GridBagConstraints.EAST;
		gbcJdbcTypesLabel.fill = GridBagConstraints.VERTICAL;
		gbcJdbcTypesLabel.insets = new Insets(0, 0, 5, 5);
		connContentPanel.add(jdbcTypesLabel, gbcJdbcTypesLabel);
		GridBagConstraints gbcJdbcTypesBox = new GridBagConstraints();
		gbcJdbcTypesBox.fill = GridBagConstraints.HORIZONTAL;
		gbcJdbcTypesBox.insets = new Insets(0, 0, 5, 0);
		gbcJdbcTypesBox.gridx = 1;
		gbcJdbcTypesBox.gridy = 0;
		jdbcTypesBox.setEditable(true);
		connContentPanel.add(jdbcTypesBox, gbcJdbcTypesBox);
		GridBagConstraints gbcDbUrlLabel = new GridBagConstraints();
		gbcDbUrlLabel.insets = new Insets(0, 0, 5, 5);
		gbcDbUrlLabel.gridx = 0;
		gbcDbUrlLabel.gridy = 1;
		dburlLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		connContentPanel.add(dburlLabel, gbcDbUrlLabel);
		GridBagConstraints gbcDbUrlTextField = new GridBagConstraints();
		gbcDbUrlTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcDbUrlTextField.insets = new Insets(0, 0, 5, 0);
		gbcDbUrlTextField.gridx = 1;
		gbcDbUrlTextField.gridy = 1;
		//dburlTextField.setBounds(new Rectangle(0, 0, 200, 20));
		dburlTextField.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		dburlTextField.setColumns(20);
		connContentPanel.add(dburlTextField, gbcDbUrlTextField);
		userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		userLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbcUserLabel = new GridBagConstraints();
		gbcUserLabel.anchor = GridBagConstraints.EAST;
		gbcUserLabel.insets = new Insets(0, 0, 5, 5);
		gbcUserLabel.gridx = 0;
		gbcUserLabel.gridy = 2;
		connContentPanel.add(userLabel, gbcUserLabel);
		GridBagConstraints gbcUserTextField = new GridBagConstraints();
		gbcUserTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcUserTextField.insets = new Insets(0, 0, 5, 0);
		gbcUserTextField.gridx = 1;
		gbcUserTextField.gridy = 2;
		connContentPanel.add(userTextField, gbcUserTextField);
		GridBagConstraints gbcConnContentPanel = new GridBagConstraints();
		gbcConnContentPanel.insets = new Insets(0, 0, 5, 0);
		gbcConnContentPanel.fill = GridBagConstraints.BOTH;
		gbcConnContentPanel.gridx = 3;
		gbcConnContentPanel.gridy = 1;
		add(connContentPanel, gbcConnContentPanel);
		//connContentPanel.setMaximumSize(new Dimension(200,200));
		passLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		passLabel.setMaximumSize(new Dimension(41, 14));
		passLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbcPassLabel = new GridBagConstraints();
		gbcPassLabel.anchor = GridBagConstraints.EAST;
		gbcPassLabel.insets = new Insets(0, 0, 5, 5);
		gbcPassLabel.gridx = 0;
		gbcPassLabel.gridy = 3;
		connContentPanel.add(passLabel, gbcPassLabel);
		GridBagConstraints gbcPassTextField = new GridBagConstraints();
		gbcPassTextField.fill = GridBagConstraints.HORIZONTAL;
		gbcPassTextField.insets = new Insets(0, 0, 5, 0);
		gbcPassTextField.gridx = 1;
		gbcPassTextField.gridy = 3;
		connContentPanel.add(passTextField, gbcPassTextField);
		GridBagConstraints gbcSubmitConnButton = new GridBagConstraints();
		gbcSubmitConnButton.insets = new Insets(0, 0, 5, 0);
		gbcSubmitConnButton.gridx = 1;
		gbcSubmitConnButton.gridy = 4;
		connContentPanel.add(submitConnButton, gbcSubmitConnButton);
		submitConnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				try {
					dbConn = new DbConnection(dburlTextField.getText(),
							jdbcTypesBox.getSelectedItem().toString(),
							userTextField.getText(),
							passTextField.getText());
					mainWinRef.notifyConnResult();					
				} catch (Exception except) {
					except.printStackTrace();
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
