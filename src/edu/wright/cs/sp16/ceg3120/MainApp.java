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


//import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;



/**
 * The application's main class.
 */
public class MainApp {
	/**
	 * The main method that displays the main application window.
	 * 
	 * 
	 */
	private static void createWindow() {
		
		final JFrame frame = new JFrame("Hello World");
		JLabel label = new JLabel("Hello World");
		JButton b1 = new JButton("Profile");
		frame.getContentPane().add(label);
		frame.getContentPane().add(b1);
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ewa) {
				if (ewa.getActionCommand().equals("Profile")) {
					Profile newProfile = new Profile();
					System.out.println("Hi");
				}

				
			}
			
			
		});
		
		
		frame.addContainerListener(new ContainerListener() {
			
//			@Override
//			public void windowClosing(Window we) {
//				int close = JOptionPane.showConfirmDialog(frame, 
//						"Exit the application?", 
//						"Exit", 
//						JOptionPane.YES_NO_OPTION);
//				
//				if (close == JOptionPane.YES_OPTION) {
//					
//					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				} else {
//					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//				}
//			}

			@Override
			public void componentAdded(ContainerEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentRemoved(ContainerEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		
		
		
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	/**
	 * The main method that displays the main application window.
	 * 
	 * @param args The command-line arguments
	 */
	
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				
				createWindow();
			}
		});
		

		
	}
}
