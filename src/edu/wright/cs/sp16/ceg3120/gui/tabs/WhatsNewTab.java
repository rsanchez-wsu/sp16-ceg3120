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

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**What's new tab for main page.
 * @author Alex
 * 
 */
public class WhatsNewTab extends JPanel{

	private static final long serialVersionUID = -797678469999457L;
	
	/** Create the tab.
	 *@author Alex
	 * 
	 */
	public WhatsNewTab() {
		super();
		initComponents();
	}
	
	/**Initialize components for tab.
	 * @author Alex
	 * 
	 */
	private void initComponents() {
		JLabel title = new JLabel();
		title.setText("My Sql Lizard");
		title.setSize(100, 100);
		title.setFont(new Font("Serif", Font.PLAIN, 22));

		add(title);
	}

}
