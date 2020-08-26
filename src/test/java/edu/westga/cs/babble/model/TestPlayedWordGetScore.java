/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class tests the getScore method of the PlayedWord class
 * 
 * @author Sofiya Anikina
 * @version August 25, 2020
 *
 */
class TestPlayedWordGetScore {
	private PlayedWord testPlayedWord;

	/**
	 * Sets up the instance variable for each test method
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testPlayedWord = new PlayedWord();
	}

	/**
	 * This method tests that an empty word has 0 as its score
	 */
	@Test
	public void emptyWordShouldHaveScoreOfZero() {
		assertEquals(0, this.testPlayedWord.getScore());
		assertTrue(this.testPlayedWord.getScore() == 0);
	}

	/**
	 * This method tests a one-tile word
	 */
	@Test
	public void scoreAOneTileWord() {

		Tile testTile = new Tile('A');
		this.testPlayedWord.append(testTile);

		assertEquals(1, this.testPlayedWord.getScore());
		assertTrue(this.testPlayedWord.getScore() == 1);
	}

	/**
	 * This method tests a word with differing tiles
	 */
	@Test
	public void scoreAWordWithMultipleDifferingTiles() {

		this.testPlayedWord.append(new Tile('S')); // 1
		this.testPlayedWord.append(new Tile('K')); // 5
		this.testPlayedWord.append(new Tile('Q')); // 10
		assertEquals(16, this.testPlayedWord.getScore());
		assertTrue(this.testPlayedWord.getScore() == 16);
	}

	/**
	 * This method ensures that a word with duplicate tiles can be scored
	 */
	@Test
	public void scoreAWordContainingDuplicateTiles() {

		this.testPlayedWord.append(new Tile('H')); // 4
		this.testPlayedWord.append(new Tile('E')); // 1
		this.testPlayedWord.append(new Tile('L')); // 1
		this.testPlayedWord.append(new Tile('L')); // 1
		this.testPlayedWord.append(new Tile('O')); // 1

		assertEquals(8, this.testPlayedWord.getScore());
		assertTrue(this.testPlayedWord.getScore() == 8);
	}
}
