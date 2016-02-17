package edu.wright.cs.sp16.ceg3120.gui.tabs;

import java.awt.*;

import javax.swing.*;
/**
 * Created by Sam on 2/17/2016.
 */
public class MySqLizardTab extends JPanel {

    public MySqLizardTab () {
        super(new GridLayout(3,1));

        initComponents();
    }

    /*
     * Initialize components
     */
    private void initComponents() {

        JLabel title = new JLabel();
        title.setText("My Sql Lizard");
        title.setSize(100, 100);
        title.setFont(new Font("Serif", Font.PLAIN, 22));

        add(title);
    }

    protected void paintComponent(Graphics g) {
        //todo: add constants for these dimensions
        super.paintComponent(g);
        g.drawRect(0,0,1000,100);
        g.setColor(Color.lightGray);
        g.fillRect(0,0,1000,100);

        super.paintComponent(g);
        g.drawRect(0,0,1000,400);
        g.setColor(Color.white);
        g.fillRect(0,100,1000,400);

        super.paintComponent(g);
        g.drawRect(0,0,1000,100);
        g.setColor(Color.lightGray);
        g.fillRect(0,0,1000,100);
    }
}
