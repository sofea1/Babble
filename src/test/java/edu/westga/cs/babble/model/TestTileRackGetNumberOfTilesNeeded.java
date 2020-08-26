/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class tests the TileRack's getNumberOfTilesNeeded method
 * 
 * @author Sofiya Anikina
 * @version August 25, 2020
 *
 */
class TestTileRackGetNumberOfTilesNeeded {
	private TileRack testTileRack;

	/**
	 * Sets up the instance variable for each test method
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testTileRack = new TileRack();
	}

	/**
	 * This method tests an empty TileRack that receives the maximum number of tiles
	 * in a TileRack
	 */
	@Test
	public void emptyTileRackShouldNeedMaxSizeNumberOfTiles() {

		assertEquals(7, this.testTileRack.getNumberOfTilesNeeded());
		assertTrue(this.testTileRack.getNumberOfTilesNeeded() == TileRack.MAX_SIZE);
	}

	/**
	 * This method tests that a TileRack with one tile gets one less tile than the
	 * maximum size
	 */
	@Test
	public void tileRackWithOneTileShouldNeedMaxSizeMinusOneTiles() {

		Tile tile1 = new Tile('A');
		this.testTileRack.append(tile1);
		assertEquals(6, this.testTileRack.getNumberOfTilesNeeded());
		assertTrue(this.testTileRack.getNumberOfTilesNeeded() == TileRack.MAX_SIZE - 1);

	}

	/**
	 * This method tests that a rack with 4 tiles will need to have 3 tiles added
	 */
	@Test
	public void tileRackWithSeveralTilesShouldNeedSomeTiles() {

		this.testTileRack.append(new Tile('R'));
		this.testTileRack.append(new Tile('A'));
		this.testTileRack.append(new Tile('C'));
		this.testTileRack.append(new Tile('K'));
		assertEquals(3, this.testTileRack.getNumberOfTilesNeeded());
		assertTrue(this.testTileRack.getNumberOfTilesNeeded() == TileRack.MAX_SIZE - 4);
	}

	/**
	 * This method tests that a full rack receives no tiles
	 */
	@Test
	public void fullRackNeedsZeroTiles() {
		assertEquals(7, testTileRack.getNumberOfTilesNeeded());

		this.testTileRack.append(new Tile('M'));
		this.testTileRack.append(new Tile('O'));
		this.testTileRack.append(new Tile('K'));
		this.testTileRack.append(new Tile('L'));
		this.testTileRack.append(new Tile('E'));
		this.testTileRack.append(new Tile('N'));
		this.testTileRack.append(new Tile('C'));

		assertEquals(0, this.testTileRack.getNumberOfTilesNeeded());
		assertTrue(this.testTileRack.getNumberOfTilesNeeded() == 0);
	}

}
