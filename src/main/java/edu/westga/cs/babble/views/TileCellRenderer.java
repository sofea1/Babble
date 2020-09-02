package edu.westga.cs.babble.views;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import edu.westga.cs.babble.model.Tile;

/**
 * Custom CellRenderer class to implement ListModel<Tile> and display the values
 * in the view
 * 
 * @author Sofiya Anikina
 * @version September 1, 2020
 *
 */
public class TileCellRenderer extends JLabel implements ListCellRenderer<Tile> {

	private static final long serialVersionUID = 1L;
	private Border border;

	public TileCellRenderer() {
		setOpaque(true);
		this.border = BorderFactory.createLineBorder(Color.GRAY, 1);
		setBorder(border);
		this.setHorizontalAlignment(SwingConstants.CENTER);

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

		Tile tile = (Tile) value;
		String tileString = String.valueOf(tile.getLetter());
		setText(tileString);
		setToolTipText(tileString);
		this.setPreferredSize(getMaximumSize());
		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionBackground());

		} else {

			setBackground(list.getBackground());
			setForeground(Color.black);
		}

		return this;

	}

}
