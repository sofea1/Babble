package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class tests the Tile constructor
 * @author Sofiya Anikina
 * @version August 25, 2020
 *
 */
class TestTileConstructor {

	/**
	 * This method tests to ensure that the constructor only accepts letters
	 */
	@Test
	public void shouldNotAllowNonLetters() {
		
		assertThrows(IllegalArgumentException.class, () -> {
		    new Tile('1'); });
		assertThrows(IllegalArgumentException.class, () -> {
		    new Tile(' '); });
		assertThrows(IllegalArgumentException.class, () -> {
		    new Tile('?'); });
		assertThrows(IllegalArgumentException.class, () -> {
		    new Tile('%'); });
	}
	
	/**
	 * This method tests to check that all the 1-point tiles can be
	 * made from the appropriate upper- and lower-case letters
	 * and that they have the appropriate point value
	 */
	@Test
	public void shouldCreateOnePointTiles() {
		Tile testTileA = new Tile('A');
		assertEquals('A', testTileA.getLetter());
		assertEquals(1, testTileA.getPointValue());
		assertTrue(1 == testTileA.getPointValue());
		Tile testTilea = new Tile('a');
		assertEquals('A', testTilea.getLetter());
		assertEquals(1, testTilea.getPointValue());
		assertTrue(1 == testTilea.getPointValue());
		
		Tile testTileO = new Tile('O');
		assertEquals('O', testTileO.getLetter());
		assertEquals(1, testTileO.getPointValue());
		assertTrue(1 == testTileO.getPointValue());
		Tile testTileo = new Tile('o');
		assertEquals('O', testTileo.getLetter());
		assertEquals(1, testTileo.getPointValue());
		assertTrue(1 == testTileo.getPointValue());
		
		assertTrue(1 == new Tile('e').getPointValue());
		assertTrue(1 == new Tile('E').getPointValue());
		assertTrue(1 == new Tile('i').getPointValue());
		assertTrue(1 == new Tile('I').getPointValue());
		assertTrue(1 == new Tile('n').getPointValue());
		assertTrue(1 == new Tile('N').getPointValue());
		assertTrue(1 == new Tile('r').getPointValue());
		assertTrue(1 == new Tile('R').getPointValue());
		assertTrue(1 == new Tile('t').getPointValue());
		assertTrue(1 == new Tile('T').getPointValue());
		assertTrue(1 == new Tile('l').getPointValue());
		assertTrue(1 == new Tile('L').getPointValue());
		assertTrue(1 == new Tile('s').getPointValue());
		assertTrue(1 == new Tile('S').getPointValue());
		assertTrue(1 == new Tile('u').getPointValue());
		assertTrue(1 == new Tile('U').getPointValue());
		
	}
	
	/**
	 * Similar to above.
	 * This method tests to ensure that all of two-point letters are
	 * created from both capital and lowercase letters
	 */
	@Test
	public void shouldCreateTwoPointTiles() {
		Tile testTileD = new Tile('D');
		assertEquals('D', testTileD.getLetter());
		assertEquals(2, testTileD.getPointValue());
		assertTrue(2 == testTileD.getPointValue());
		Tile testTiled = new Tile('d');
		assertEquals('D', testTiled.getLetter());
		assertEquals(2, testTiled.getPointValue());
		assertTrue(2 == testTiled.getPointValue());
		
		Tile testTileG = new Tile('G');
		assertEquals('G', testTileG.getLetter());
		assertEquals(2, testTileG.getPointValue());
		assertTrue(2 == testTileG.getPointValue());
		Tile testTileg = new Tile('g');
		assertEquals('G', testTileg.getLetter());
		assertEquals(2, testTileg.getPointValue());
		assertTrue(2 == testTileg.getPointValue());
		
	}
	
	/**
	 * Similar to above.
	 * This method tests to ensure that all of three-point letters are
	 * created from both capital and lowercase letters
	 */
	@Test
	public void shouldCreateThreePointTiles() {
		
		Tile testTileM= new Tile('M');
		assertEquals('M', testTileM.getLetter());
		assertEquals(3, testTileM.getPointValue());
		assertTrue(3 == testTileM.getPointValue());
		Tile testTilem = new Tile('m');
		assertEquals('M', testTilem.getLetter());
		assertEquals(3, testTilem.getPointValue());
		assertTrue(3 == testTilem.getPointValue());
		
		Tile testTileP= new Tile('P');
		assertEquals('P', testTileP.getLetter());
		assertEquals(3, testTileP.getPointValue());
		assertTrue(3 == testTileP.getPointValue());
		
		Tile testTilep= new Tile('p');
		assertEquals('P', testTilep.getLetter());
		assertEquals(3, testTilep.getPointValue());
		assertTrue(3 == testTilep.getPointValue());
		
		assertTrue(3 == new Tile('b').getPointValue());
		assertTrue(3 == new Tile('B').getPointValue());
		assertTrue(3 == new Tile('c').getPointValue());
		assertTrue(3 == new Tile('C').getPointValue());
		
	}
	
	/**
	 * Similar to above.
	 * This method tests to ensure that all of four-point letters are
	 * created from both capital and lowercase letters
	 */
	@Test
	public void shouldCreateFourPointTiles() {
		
		Tile testTileH = new Tile('H');
		assertEquals('H', testTileH.getLetter());
		assertEquals(4, testTileH.getPointValue());
		assertTrue(4 == testTileH.getPointValue());
		Tile testTileh = new Tile('h');
		assertEquals('H', testTileh.getLetter());
		assertEquals(4, testTileh.getPointValue());
		assertTrue(4 == testTileh.getPointValue());
		
		Tile testTileV = new Tile('V');
		assertEquals('V', testTileV.getLetter());
		assertEquals(4, testTileV.getPointValue());
		assertTrue(4 == testTileV.getPointValue());
		Tile testTilev = new Tile('v');
		assertEquals('V', testTilev.getLetter());
		assertEquals(4, testTilev.getPointValue());
		assertTrue(4 == testTilev.getPointValue());
		
		assertTrue(4 == new Tile('f').getPointValue());
		assertTrue(4 == new Tile('F').getPointValue());
		assertTrue(4 == new Tile('w').getPointValue());
		assertTrue(4 == new Tile('W').getPointValue());
		assertTrue(4 == new Tile('y').getPointValue());
		assertTrue(4 == new Tile('Y').getPointValue());
		
		
	}
	
	/**
	 * Similar to above.
	 * This method tests to ensure that all of five-point letters are
	 * created from both capital and lowercase letters
	 */
	@Test
	public void shouldCreateFivePointTiles() {
		
		Tile testTileK = new Tile('K');
		assertEquals('K', testTileK.getLetter());
		assertEquals(5, testTileK.getPointValue());
		assertTrue(5 == testTileK.getPointValue());
		Tile testTilek = new Tile('k');
		assertEquals('K', testTilek.getLetter());
		assertEquals(5, testTilek.getPointValue());
		assertTrue(5 == testTilek.getPointValue());
		
	}
	
	/**
	 * Similar to above.
	 * This method tests to ensure that all of eight-point letters are
	 * created from both capital and lowercase letters
	 */
	@Test
	public void shouldCreateEightPointTiles() {
		
		Tile testTileJ = new Tile('J');
		assertEquals('J', testTileJ.getLetter());
		assertEquals(8, testTileJ.getPointValue());
		assertTrue(8 == testTileJ.getPointValue());
		
		Tile testTilej = new Tile('j');
		assertEquals('J', testTilej.getLetter());
		assertEquals(8, testTilej.getPointValue());
		assertTrue(8 == testTilej.getPointValue());
		
		assertTrue(8 == new Tile('x').getPointValue());
		assertTrue(8 == new Tile('X').getPointValue());
		
	}
	
	/**
	 * Similar to above.
	 * This method tests to ensure that all of ten-point letters are
	 * created from both capital and lowercase letters
	 */
	@Test
	public void shouldCreateTenPointTiles() {
		
		Tile testTileQ = new Tile('Q');
		assertEquals('Q', testTileQ.getLetter());
		assertEquals(10, testTileQ.getPointValue());
		assertTrue(10 == testTileQ.getPointValue());
		
		Tile testTileq = new Tile('q');
		assertEquals('Q', testTileq.getLetter());
		assertEquals(10, testTileq.getPointValue());
		assertTrue(10 == testTileq.getPointValue());
		
		assertTrue(10 == new Tile('z').getPointValue());
		assertTrue(10 == new Tile('Z').getPointValue());
		
	}
}
