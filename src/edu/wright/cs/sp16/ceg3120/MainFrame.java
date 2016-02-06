package edu.wright.cs.sp16.ceg3120;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/**
 * Main Frame for application
 * @author Bonnie Shields
 */
public class MainFrame{

	static JFrame frame;
	public static void main(String[] args) {
		frame = new JFrame("Sequel Master");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//display the menu bar on the top of the page
		displayMenu();
		frame.setVisible(true);
		frame.setSize(650, 500);
	}
	/**
	 * This will display the menu bar in the main application
	 * @author Bonnie
	 */
	public static void displayMenu(){
		JMenuBar menuBar = new JMenuBar();
		
		//File Menu
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		//File > Connect
		JMenuItem connMenuItem = new JMenuItem("Connect");
		fileMenu.add(connMenuItem);
		
		ActionListener connect = new ConnectWindow();
		connMenuItem.addActionListener(connect);
		
		frame.setJMenuBar(menuBar);		
	}	
	/**
	 * 	Add listener to Connect button from File menu
	 * @author Bonnie
	 */
	private static class ConnectWindow implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			CreateWindow popup = new CreateWindow();
			popup.setVisible(false);	
		}
	}
}

