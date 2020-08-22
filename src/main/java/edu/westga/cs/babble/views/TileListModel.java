/**
 * 
 */
package edu.westga.cs.babble.views;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import edu.westga.cs.babble.model.EmptyTileBagException;
import edu.westga.cs.babble.model.Tile;
import edu.westga.cs.babble.model.TileBag;
import edu.westga.cs.babble.model.TileRack;

/**
 * @author sofiya
 *
 */
public class TileListModel extends TileRack implements ListModel<Tile> {
	TileBag bag;
	
	/**
	 * Fills the tile rack with a random number of tiles from the bag
	 * @throws EmptyTileBagException 
	 */
	public TileListModel() throws EmptyTileBagException {
		this.bag = new TileBag();
		int numberOfTilesToDisplay = getNumberOfTilesNeeded();
		for(int i=0; i < numberOfTilesToDisplay; i++)
		{
			if(this.bag.isEmpty()) break;
			Tile tile;
			tile = this.bag.drawTile();
			append(tile);
		}
	}
	
	
	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public Tile getElementAt(int index) {
		//return null;
	
		return this.getTiles().get(index);
		//return super.tiles().size();
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
