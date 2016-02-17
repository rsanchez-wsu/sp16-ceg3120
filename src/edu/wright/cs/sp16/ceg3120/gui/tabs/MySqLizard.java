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

package edu.wright.cs.sp16.ceg3120.gui.tabs;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**Second tab in start screen for tips and plugin installation.
 * @author Blizzri
 *
 */
public class MySqLizard {

	/**Create the tab.
	 * @author Blizzri
	 *
	 */
	public MySqLizard() {
		super();
		initComponents();
	}
	
	/** Initialize all tab information and structure.
	 * @author Blizzri
	 *
	 */
	private void initComponents() {
		JFrame frame = new JFrame("MySql");
		
		JButton pluginButton = new JButton();
		pluginButton.setText("Install plugins");
		
		JLabel tipLabel = new JLabel();
		tipLabel.setText("Tip of the day");
		
		frame.add(pluginButton);
		frame.add(tipLabel);
	}
}
