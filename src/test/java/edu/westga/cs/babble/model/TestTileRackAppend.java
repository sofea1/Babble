/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class tests the append method of the TileRack class which is an override
 * of TileGroup#append()
 * 
 * @author Sofiya Anikina
 * @version August 25, 2020
 *
 */
class TestTileRackAppend {
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
	 * This method tests that the append method does not append a new element to a
	 * full rack
	 */
	@Test
	void shouldNotAppendToFullRack() {

		this.testTileRack.append(new Tile('A'));
		this.testTileRack.append(new Tile('B'));
		this.testTileRack.append(new Tile('C'));
		this.testTileRack.append(new Tile('D'));
		this.testTileRack.append(new Tile('E'));
		this.testTileRack.append(new Tile('F'));
		this.testTileRack.append(new Tile('G'));

		assertThrows(TileRackFullException.class, () -> {
			this.testTileRack.append(new Tile('H'));
		});
	}

}
