package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class tests the TileGroup's remove method
 * 
 * @author Sofiya Anikina
 * @version August 25, 2020
 *
 */
class TestTileGroupRemove {
	private TileGroup testTileGroup;

	class NewTileGroup extends TileGroup {

	}

	/**
	 * Sets up the instance variable for each test method
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testTileGroup = new NewTileGroup();
	}

	/**
	 * This method tests that the remove method does not allow null values
	 */
	@Test
	public void shouldNotAllowNull() {

		assertThrows(IllegalArgumentException.class, () -> {
			this.testTileGroup.remove(null);
		});
	}

	/**
	 * This method tests that the remove method does not remove a letter from the
	 * empty TileGroup
	 */
	@Test
	public void canNotRemoveFromEmptyTileGroup() {

		Tile newTile = new Tile('M');
		assertThrows(TileNotInGroupException.class, () -> {
			this.testTileGroup.remove(newTile);
		});
		assertTrue(this.testTileGroup.tiles().isEmpty());
	}

	/**
	 * This method tests that the remove method cannot remove a tile not appended to
	 * the TileGroup
	 */
	@Test
	public void canNotRemoveTileNotInTileGroup() {

		Tile newTile1 = new Tile('J');
		Tile newTile2 = new Tile('K');
		this.testTileGroup.append(newTile2);
		assertThrows(TileNotInGroupException.class, () -> {
			this.testTileGroup.remove(newTile1);
		});

	}

	/**
	 * This method tests that the remove method can remove the one tile
	 * 
	 * @throws TileNotInGroupException
	 */
	@Test
	public void canRemoveOnlyTileInTileGroup() {

		Tile newTile = new Tile('D');
		this.testTileGroup.append(newTile);

		try {

			this.testTileGroup.remove(this.testTileGroup.tiles().get(0));
		} catch (TileNotInGroupException e) {
			e.printStackTrace();
		}

		assertTrue(this.testTileGroup.tiles().isEmpty());
		assertEquals("", this.testTileGroup.getHand());
	}

	/**
	 * This method tests that the remove method removes the first tile in a
	 * collection
	 * 
	 * @throws TileNotInGroupException
	 */
	@Test
	public void canRemoveFirstOfManyTilesFromTileGroup() {

		this.testTileGroup.append(new Tile('T'));
		this.testTileGroup.append(new Tile('I'));
		this.testTileGroup.append(new Tile('L'));
		this.testTileGroup.append(new Tile('E'));
		this.testTileGroup.append(new Tile('S'));

		try {
			this.testTileGroup.remove(this.testTileGroup.tiles().get(0));
		} catch (TileNotInGroupException e) {
			e.printStackTrace();
		}

		assertEquals("ILES", this.testTileGroup.getHand());

	}

	/**
	 * This method tests the remove method removes the last tile in the TileGroup
	 * collection
	 * 
	 * @throws TileNotInGroupException
	 */
	@Test
	public void canRemoveLastOfManyTilesFromTileGroup() {

		this.testTileGroup.append(new Tile('G'));
		this.testTileGroup.append(new Tile('R'));
		this.testTileGroup.append(new Tile('O'));
		this.testTileGroup.append(new Tile('U'));
		this.testTileGroup.append(new Tile('P'));

		try {
			this.testTileGroup.remove(this.testTileGroup.tiles().get(4));
		} catch (TileNotInGroupException e) {

			e.printStackTrace();
		}

		assertEquals("GROU", this.testTileGroup.getHand());

	}

	/**
	 * This method tests that the remove method removes tiles from the middle of a
	 * collection
	 * 
	 * @throws TileNotInGroupException
	 */
	@Test
	public void canRemoveMiddleOfManyTilesFromTileGroup() {

		this.testTileGroup.append(new Tile('C'));
		this.testTileGroup.append(new Tile('H'));
		this.testTileGroup.append(new Tile('E'));
		this.testTileGroup.append(new Tile('C'));
		this.testTileGroup.append(new Tile('K'));

		try {
			this.testTileGroup.remove(this.testTileGroup.tiles().get(2));
		} catch (TileNotInGroupException e) {
			e.printStackTrace();
		}

		assertEquals("CHCK", this.testTileGroup.getHand());
	}

	/**
	 * This method tests that the remove method removes multiple tiles from a
	 * collection
	 * 
	 * @throws TileNotInGroupException
	 */
	@Test
	public void canRemoveMultipleTilesFromTileGroup() {

		this.testTileGroup.append(new Tile('R'));
		this.testTileGroup.append(new Tile('E'));
		this.testTileGroup.append(new Tile('M'));
		this.testTileGroup.append(new Tile('O'));
		this.testTileGroup.append(new Tile('V'));
		this.testTileGroup.append(new Tile('E'));
		this.testTileGroup.append(new Tile('S'));

		try {
			this.testTileGroup.remove(this.testTileGroup.tiles().get(2));
			this.testTileGroup.remove(this.testTileGroup.tiles().get(2));
			this.testTileGroup.remove(this.testTileGroup.tiles().get(4));
		} catch (TileNotInGroupException e) {
			e.printStackTrace();
		}

		assertEquals("REVE", this.testTileGroup.getHand());
	}

	/**
	 * This method tests that the remove method does not remove duplicate tiles from
	 * a TileGroup collection
	 * 
	 * @throws TileNotInGroupException
	 */
	@Test
	public void doesNotRemoveDuplicateTilesFromTileGroup() {

		this.testTileGroup.append(new Tile('H'));
		this.testTileGroup.append(new Tile('E'));
		this.testTileGroup.append(new Tile('L'));
		this.testTileGroup.append(new Tile('L'));
		this.testTileGroup.append(new Tile('O'));

		try {
			this.testTileGroup.remove(this.testTileGroup.tiles().get(2));
		} catch (TileNotInGroupException e) {
			e.printStackTrace();
		}

		assertEquals('L', testTileGroup.getHand().charAt(2));
		assertEquals('O', testTileGroup.getHand().charAt(3));
	}

}
