package edu.wright.cs.sp16.ceg3120;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class PreferenceGui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreferenceGui window = new PreferenceGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PreferenceGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 684, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDefaultDatabase = new JLabel("Default Database :");
		lblDefaultDatabase.setBounds(27, 21, 108, 19);
		frame.getContentPane().add(lblDefaultDatabase);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(210, 20, 210, 20);
		frame.getContentPane().add(comboBox);
		
		JCheckBox chckbxConnectToDefault = new JCheckBox("Connect to default on Startup");
		chckbxConnectToDefault.setBounds(210, 58, 210, 23);
		frame.getContentPane().add(chckbxConnectToDefault);
		
		JCheckBox chckbxmessageOfThe = new JCheckBox("\"Message of the day\" on startup ");
		chckbxmessageOfThe.setBounds(210, 94, 239, 23);
		frame.getContentPane().add(chckbxmessageOfThe);
		
		JLabel lblDefaultView = new JLabel("Default View :");
		lblDefaultView.setBounds(27, 147, 90, 14);
		frame.getContentPane().add(lblDefaultView);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(210, 144, 210, 20);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblDefaultEncoding = new JLabel("Default Encoding: ");
		lblDefaultEncoding.setBounds(27, 197, 118, 14);
		frame.getContentPane().add(lblDefaultEncoding);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(210, 194, 210, 20);
		frame.getContentPane().add(comboBox_2);
		
		JLabel lblTableViews = new JLabel("Table Views :");
		lblTableViews.setBounds(27, 244, 108, 14);
		frame.getContentPane().add(lblTableViews);
		
		JCheckBox chckbxUseMonospacedFonts = new JCheckBox("Use monospaced fonts");
		chckbxUseMonospacedFonts.setBounds(210, 240, 210, 23);
		frame.getContentPane().add(chckbxUseMonospacedFonts);
		
		JCheckBox chckbxDisplayVerticalGrid = new JCheckBox("Display vertical grid lines");
		chckbxDisplayVerticalGrid.setBounds(210, 283, 210, 23);
		frame.getContentPane().add(chckbxDisplayVerticalGrid);
		
		JLabel lblRememberLast = new JLabel("Remember last");
		lblRememberLast.setBounds(27, 329, 108, 14);
		frame.getContentPane().add(lblRememberLast);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(210, 326, 90, 20);
		frame.getContentPane().add(comboBox_3);
		
		JLabel lblQueries = new JLabel("Queries");
		lblQueries.setBounds(339, 329, 46, 14);
		frame.getContentPane().add(lblQueries);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(451, 382, 71, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(532, 382, 102, 23);
		frame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				System.exit(0);
				}
			});
	}
	}
