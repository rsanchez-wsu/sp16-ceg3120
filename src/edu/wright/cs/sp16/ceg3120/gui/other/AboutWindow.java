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

package edu.wright.cs.sp16.ceg3120.gui.other;

import edu.wright.cs.sp16.ceg3120.gui.MainGui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.Timer;

/**
 * The Frame that holds different panels. Mainly created for the slideShow of images
 * 
 * @author kirill kultinov
 */
public class AboutWindow extends JPanel implements ActionListener{

	private static final long serialVersionUID = -24143968339746394L;
	private int count = 1;
	private Timer timer;
	private JPanel frameContainer = new JPanel();
	private JPanel imagesPanel = new JPanel();
	private JPanel descriptionsPanel = new JPanel();
	private JLabel images = new JLabel();
	private JLabel description = new JLabel("There is no much to put right now.. ");
	public JFrame frame = new JFrame("Welcome");
	private ImageIcon pictures1 = new ImageIcon("img/LizardSample1.jpg");
	private ImageIcon pictures2 = new ImageIcon("img/LizardSample2.jpg");
	private ImageIcon pictures3 = new ImageIcon("img/LizardSample3.jpg");
	private ImageIcon pictures4 = new ImageIcon("img/LizardSample4.jpg");
	
	
	/**
	 * The Frame that holds different panels. Mainly created for the slideShow of images
	 * 
	 */
	public AboutWindow() {

		frame.setLocationByPlatform(true);

		frame.getContentPane().add(this);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				timer.stop();
				new MainGui();
			}
		});
		imagesPanel.add(images);
		imagesPanel.setPreferredSize(new Dimension(500, 400));
		descriptionsPanel.add(description);
		frameContainer.setLayout(new BoxLayout(frameContainer, BoxLayout.Y_AXIS));
		frameContainer.add(descriptionsPanel);
		frameContainer.add(imagesPanel);
		add(frameContainer);
		images.setIcon(pictures1);
		frame.setSize(500, 400);
		frame.setVisible(true); 
		timer = new Timer(1500, this);    
		timer.start();  
	}
	
	/**
     * The method used to change images inside of a panel depending on
     * a value of counter.
     */
	public void actionPerformed(ActionEvent ae) {                       
		count++;

		if (count == 1) {
			images.setIcon(pictures1);
			description.setText("So Just enjoy Lizardzzzz");
		}
		if (count == 2) {
			images.setIcon(pictures2);  
			description.setText("So Just enjoy Lizardzzzz");
		}
		if (count == 3) {
			images.setIcon(pictures3);
			description.setText("zoooo cool");
		}
		if (count == 4) {
			images.setIcon(pictures4); 
			description.setText("izn't it?");
		}
		if (count == 5) {
			count = 0;
			description.setText("zzz");
		}
		revalidate();
		repaint();
	}
}