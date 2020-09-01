/**
 * 
 */
package edu.westga.cs.babble.views;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import edu.westga.cs.babble.model.EmptyTileBagException;
import edu.westga.cs.babble.model.Tile;
import edu.westga.cs.babble.model.TileBag;
import edu.westga.cs.babble.model.TileRack;

/**
 * Custom list model that implements the ListModel interface. Has functionality
 * of TileRack and used as a model for JList.
 * 
 * @author Sofiya Anikina
 *
 */
public class TileListModel extends TileRack implements ListModel<Tile> {
	private TileBag bag;

	/**
	 * Model's constructor.
	 * 
	 * @throws EmptyTileBagException
	 */
	public TileListModel() throws EmptyTileBagException {
		this.bag = new TileBag();
		fillRack();
	}

	/**
	 * Fills the TileRack with Tiles from the TileBag
	 * 
	 * @throws EmptyTileBagException
	 */
	public void fillRack() throws EmptyTileBagException {
		int numberOfTilesToDisplay = this.getNumberOfTilesNeeded();
		for (int i = 0; i < numberOfTilesToDisplay; i++) {
			if (this.bag.isEmpty())
				break;
			Tile tile;
			tile = this.bag.drawTile();
			this.append(tile);
		}
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tile getElementAt(int index) {
		// return null;

		return this.getTiles().get(index);
		// return super.tiles().size();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.getTiles().size();
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

}
