package edu.westga.cs.babble.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JSeparator;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;

import edu.westga.cs.babble.model.Tile;

/**
 * @author sofiy
 *
 */
public class TileCellRenderer extends JLabel implements ListCellRenderer<Tile> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
	//private ListModel<Tile> model;
    
    public TileCellRenderer() {
        setOpaque(true);
        //setHorizontalAlignment(SwingConstants.LEFT);
       // setMaximumSize(new Dimension(300, 200));
       getMaximumSize();
    }

	// returns a Swing component from this method which does the rendering.
	@Override
	public Component getListCellRendererComponent(JList<? extends Tile> list, // the list
													Tile value, // value to display
													int index, // cell index
													boolean isSelected,  // is the cell selected
													boolean cellHasFocus) { // does the cell have focus) 
		
		Tile tileTest = (Tile)value;
       // setToolTipText(tile.toString());
		String testStr = String.valueOf(tileTest.getLetter());
		setText(testStr);
		if(isSelected) {
	            setBackground(HIGHLIGHT_COLOR);
				//this.gui.tileList.setBackground(Color.YELLOW);
	            setForeground(Color.white);
	        } else {
	            setBackground(Color.white);
	            setForeground(Color.black);
	        }

			return this;
	
	}

}
