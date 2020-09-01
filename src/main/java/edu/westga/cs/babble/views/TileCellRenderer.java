package edu.westga.cs.babble.views;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import edu.westga.cs.babble.model.Tile;

/**
 * Custom CellRenderer class to implement ListModel<Tile> and display the values
 * in the view
 * 
 * @author Sofiya Anikina
 *
 */
public class TileCellRenderer extends JLabel implements ListCellRenderer<Tile> {

	private static final long serialVersionUID = 1L;
	private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

	public TileCellRenderer() {
		setOpaque(true);

	}

	/**
	 * Returns a Swing component from this method which does the rendering.
	 */
	@Override
	public Component getListCellRendererComponent(JList<? extends Tile> list, // the list
			Tile value, // value to display
			int index, // cell index
			boolean isSelected, // is the cell selected
			boolean cellHasFocus) { // does the cell have focus)

		Tile tileTest = (Tile) value;
		String testStr = String.valueOf(tileTest.getLetter());
		setText(testStr);
		setToolTipText(testStr);

		if (isSelected) {
			setBackground(HIGHLIGHT_COLOR);
			setForeground(Color.white);
		} else {
			setBackground(Color.white);
			setForeground(Color.black);
		}

		return this;

	}

}
