/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class tests the TileGroup's append method
 * 
 * @author Sofiya Anikina
 * @version August 25, 2020
 *
 */
class TestTileGroupAppend {
	private TileGroup testTileGroup;

	class NewTileGroup extends TileGroup {

	}

	/**
	 * Sets up the instance variable for the test methods
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testTileGroup = new NewTileGroup();
	}

	/**
	 * This method tests the append method that does not allow null values
	 */
	@Test
	public void shouldNotAllowNull() {
	
		assertThrows(IllegalArgumentException.class, () -> {
		    this.testTileGroup.append(null); });
	}
	
	/**
	 * This method tests an empty group that should be empty
	 */
	@Test
	public void emptyGroupShouldBeEmpty() {
		
		assertEquals(0, this.testTileGroup.tiles().size());
		assertTrue(this.testTileGroup.tiles().isEmpty());
	}
	/**
	 * This method tests a group with one tile ensuring it contains only one tile
	 */
	@Test
	public void shouldHaveOneTileInTileGroup() {
		
		Tile newTile = new Tile('S');
		this.testTileGroup.append(newTile);
		assertEquals(1, this.testTileGroup.tiles().size());
		assertEquals('S', this.testTileGroup.tiles().get(0).getLetter());
	}
	
	/**
	 * This method tests that the append method adds multiple tiles
	 * to a TileGroup 
	 */
	@Test
	public void shouldHaveManyTilesInTileGroup() {
		
		this.testTileGroup.append(new Tile('T'));
		this.testTileGroup.append(new Tile('I'));
		this.testTileGroup.append(new Tile('L'));
		this.testTileGroup.append(new Tile('E'));
		assertEquals('T', this.testTileGroup.tiles().get(0).getLetter());
		assertEquals('I', this.testTileGroup.tiles().get(1).getLetter());
		assertEquals('L', this.testTileGroup.tiles().get(2).getLetter());
		assertEquals('E', this.testTileGroup.tiles().get(3).getLetter());
		assertEquals(4, this.testTileGroup.tiles().size());
	}
	
	
	/**
	 * This method tests that duplicate tiles can be added
	 */
	@Test
	public void shouldHaveManyTilesIncludingDuplicatesInTileGroup() {
		
		this.testTileGroup.append(new Tile('H'));
		this.testTileGroup.append(new Tile('E'));
		this.testTileGroup.append(new Tile('L'));
		this.testTileGroup.append(new Tile('L'));
		this.testTileGroup.append(new Tile('O'));
		assertEquals('H', this.testTileGroup.tiles().get(0).getLetter());
		assertEquals('E', this.testTileGroup.tiles().get(1).getLetter());
		assertEquals('L', this.testTileGroup.tiles().get(2).getLetter());
		assertEquals('L', this.testTileGroup.tiles().get(3).getLetter());
		assertEquals('O', this.testTileGroup.tiles().get(4).getLetter());
		assertEquals(5, this.testTileGroup.tiles().size());
	}
	
}
