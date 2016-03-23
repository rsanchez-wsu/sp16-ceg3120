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

package edu.wright.cs.sp16.ceg3120.gui.listeners;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import java.net.URI;

import java.net.URISyntaxException;

import javax.swing.JButton;

/**Action event to handle clicking on a url in the interface.
 * @author Alex
 *
 */
public class OpenUrlAction implements ActionListener  {
	
	//action event for clicking on a url.
	@Override
	public void actionPerformed(ActionEvent evt) {
		
		//gather url from click event source
		JButton tempLabel = (JButton) evt.getSource();
		
		URI uri;
		
		try {
			uri = new URI(tempLabel.getToolTipText());
			open(uri);
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
	}
	
	/**Check if supported, open associated uri for user.
	 * @author Alex
	 *
	 */
	private static void open(URI uri) {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(uri);
			} catch (IOException e) {
				e.printStackTrace();
			}		
		} else {
			//TODO: what if it isn't supported?
		}
	}
}