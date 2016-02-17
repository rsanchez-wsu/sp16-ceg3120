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

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;



/**
 * Created by Sam on 2/17/2016.
 */
public class MySqLizardTab extends JPanel {

	private static final long serialVersionUID = -797683451675465457L;
	
	/**Initialize the mySqlizard tab.
	 * @author Alex
	 */
	public MySqLizardTab() {
		super(new GridLayout(3,1));

		initComponents();
	}

	/**Initialize components.
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
	
	/**Draw components on.
	 * @author Alex
     * 
     */
	protected void paintComponent(Graphics graphic) {
		//TODO: add constants for these dimensions
		super.paintComponent(graphic);
		graphic.drawRect(0,0,1000,100);
		graphic.setColor(Color.lightGray);
		graphic.fillRect(0,0,1000,100);

		super.paintComponent(graphic);
		graphic.drawRect(0,0,1000,400);
		graphic.setColor(Color.white);
		graphic.fillRect(0,100,1000,400);

		super.paintComponent(graphic);
		graphic.drawRect(0,0,1000,100);
		graphic.setColor(Color.lightGray);
		graphic.fillRect(0,0,1000,100);
	}
}
