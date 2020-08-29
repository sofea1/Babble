/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class tests the drawTile method of the TileBag class
 * 
 * @author Sofiya Anikina
 * @version August 29, 2020
 *
 */
class TestTileBagDrawTile {
	private TileBag testTileBag;

	/**
	 * Sets up the instance variable for each method
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testTileBag = new TileBag();
	}

	/**
	 * This method tests that 98 tiles - the total number of Scrabble tiles -- can
	 * be drawn
	 * 
	 * @throws EmptyTileBagException
	 */
	@Test
	public void canDrawAllTiles() {

		for (int index = 0; index < 98; index++) {

			try {
				this.testTileBag.drawTile();
			} catch (EmptyTileBagException e) {
				e.printStackTrace();
			}

		}

		assertEquals(true, this.testTileBag.isEmpty());
	}
	
	/**
	 * This method checks that attempting to draw a 99th tile throws the appropriate exception
	 * @throws EmptyTileBagException
	 */
	@Test
	public void canNotDrawTooManyTiles() {
		
		for (int index = 0; index < 98; index++) {
			
			try {
				this.testTileBag.drawTile();
			} catch (EmptyTileBagException e) {
				e.printStackTrace();
				assert(false);
			}
			
		}
		
		assertThrows(EmptyTileBagException.class, () -> {
		    this.testTileBag.drawTile(); });		
	}

	
	/**
	 * This method checks that the tiles in the tile bag are distributed according to 
	 * the standard Scrabble distribution
	 * @throws EmptyTileBagException
	 */
	@Test 
	public void hasProperTileDistribution() {
		
		char tile;
		ArrayList<Character> testTiles = new ArrayList<Character>();
		ArrayList<Character> tileBenchmark = new ArrayList<Character>(
			  Arrays.asList('A','A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', //9
							'B', 'B', //2
							'C', 'C', //2
							'D', 'D', 'D', 'D', //4
							'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E','E', 'E', //12
							'F', 'F', //2
							'G', 'G', 'G', //3
							'H', 'H', //2
							'I', 'I', 'I', 'I', 'I','I','I', 'I', 'I', //9
							'J', //1
							'K', //1
							'L', 'L', 'L', 'L', //4
							'M', 'M', //2
							'N', 'N', 'N', 'N', 'N', 'N', //6
							'O', 'O', 'O', 'O', 'O','O', 'O', 'O',//8 
							'P', 'P', //2
							'Q', //1
							'R', 'R', 'R', 'R', 'R', 'R',//6 
							'S', 'S', 'S', 'S', //4
							'T', 'T', 'T', 'T', 'T', 'T',//6 
							'U','U', 'U', 'U', //4
							'V', 'V', //2
							'W', 'W', //2
							'X', //1
							'Y', 'Y',//2
							'Z'));//1
						
		
			try {
				for (int index = 0; index < 98; index++) {
				tile = this.testTileBag.drawTile().getLetter();
				testTiles.add(tile);
				}
				
			} catch (EmptyTileBagException e) {
				e.printStackTrace();
			}
			
			Collections.sort(testTiles);

			assertEquals(true, testTiles.equals(tileBenchmark));
			assertEquals(98, tileBenchmark.size());
			assertEquals(98, testTiles.size());
	
	}
}
