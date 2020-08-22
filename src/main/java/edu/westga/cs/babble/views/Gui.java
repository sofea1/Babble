package edu.westga.cs.babble.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;

import edu.westga.cs.babble.model.EmptyTileBagException;
import edu.westga.cs.babble.model.Tile;
import edu.westga.cs.babble.model.TileRack;

/**
 * This class extends GuiWindowBuilderLayout; used for any additional GUI configuration code 
 * (including setting up model objects for Swing controls, etc).
 * 
 * @author Sofiya Anikina
 * @version 08/15/2020
 *
 */
public class Gui extends GuiWindowBuilderLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GuiWindowBuilderLayout gui;
	private TileListModel model;
	private GuiController game;
	
	
	public Gui() {
		this.game = new GuiController();
		
	}
	
	/**
	 * Directs the flow of the application
	 * @throws EmptyTileBagException 
	 */
	public void run() throws EmptyTileBagException {	
	
		this.game.startGame();
		try {
				this.gui = new GuiWindowBuilderLayout();
				this.gui.setTitle("Babble Game");
				this.gui.setVisible(true);
				this.gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.gui.setLayout(getLayout());
				this.gui.setBounds(100, 100, 400, 300);
				
				this.model = new TileListModel();
				JList<Tile> tileJList = new JList<Tile>(this.model);
				tileJList.setModel(this.model);
				TileCellRenderer renderer =  new TileCellRenderer();  
				tileJList.setCellRenderer(renderer);
				tileJList.setSelectedIndex(0);
				tileJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
				this.gui.panel.add(tileJList);
		
		} catch (IllegalArgumentException iae) {
			JOptionPane.showMessageDialog(null, iae.getMessage());
		}
		
		
	}

}
