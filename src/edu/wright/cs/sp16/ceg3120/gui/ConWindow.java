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

package edu.wright.cs.sp16.ceg3120.gui;

import edu.wright.cs.sp16.ceg3120.CreateWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * 
 * @author devesh
 *     New CreateWindow to call the CreateWindow class.
 *
 */
public class ConWindow implements ActionListener {


	/**
	 * Perform action to the CreateWindow.
	 */
	public void actionPerformed(ActionEvent arg0) {
		final CreateWindow popthis = new CreateWindow();
		popthis.setVisible(true);
		popthis.pack();
		popthis.setLocationRelativeTo(null);
		/*popthis.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					int answer = JOptionPane.showConfirmDialog(popthis, 
							"Do you really want to quit?", 
							"Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (answer == JOptionPane.YES_OPTION) {
						popthis.dispose();
					} else {
						popthis.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}

				} // end of widowClosing

		}); // end of WindowListener */
	} 
}
