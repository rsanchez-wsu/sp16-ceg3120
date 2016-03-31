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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * The Frame that holds different panels. Mainly created for the slideShow of
 * images
 * 
 * @author kirillkultinov
 */
public class SlideShow extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private int count = 0;
	private Timer timer;
	private JLabel images = new JLabel();
	public JFrame frame = new JFrame("Welcome");
	private ImageIcon pictures1 = new ImageIcon("img/Logical.png");
	private ImageIcon pictures2 = new ImageIcon("img/Relational.png");
	private ImageIcon pictures3 = new ImageIcon("img/SQLizard.png");
	private ImageIcon pictures4 = new ImageIcon("img/sqlSample.png");

	/**
	 * The Frame that holds different panels. Mainly created for the slideShow
	 * of images
	 * 
	 */
	public SlideShow() {

		frame.setLocationByPlatform(true);

		frame.getContentPane().add(this);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				timer.stop();
				try {
					MainGui.class.newInstance().makeEnabled();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		});
		add(images);
		images.setIcon(pictures1);
		frame.setSize(500, 600);
		frame.setVisible(true);
		timer = new Timer(1500, this);
		timer.start();
	}

	/**
	 * Action performed.
	 */
	public void actionPerformed(ActionEvent ae) {
		count++;

		if (count == 1) {
			images.setIcon(pictures1);

		}
		if (count == 2) {
			images.setIcon(pictures2);
		}
		if (count == 3) {
			images.setIcon(pictures3);
		}
		if (count == 4) {
			images.setIcon(pictures4);
		}
		if (count == 5) {
			count = 0;
		}
		revalidate();
		repaint();
	}

}