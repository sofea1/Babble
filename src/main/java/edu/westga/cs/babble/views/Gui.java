package edu.westga.cs.babble.views;

import javax.swing.JFrame;

/**
 * This class extends GuiWindowBuilderLayout; used for any additional GUI configuration code 
 * (including setting up model objects for Swing controls, etc).
 * 
 * @author Sofiya Anikina
 * @version 08/15/2020
 *
 */
public class Gui extends GuiWindowBuilderLayout {
	
	private JFrame frame;
	private GuiWindowBuilderLayout gui;
	
	/**
	 * Directs the flow of the application
	 */
	public void run() {	
	
		this.frame = new JFrame();
		this.gui = new GuiWindowBuilderLayout();
		
		this.gui.setTitle("Babble Game");
		this.gui.setVisible(true);
		this.gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.gui.setLayout(getLayout());
		this.gui.setBounds(100, 100, 400, 300);
		
	
	}
}
