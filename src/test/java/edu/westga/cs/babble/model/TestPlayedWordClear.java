/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class tests the clear method of the PlayedWord class
 * 
 * @author Sofiya Anikina
 * @version August 26, 2020
 *
 */
class TestPlayedWordClear {
	private PlayedWord testPlayedWord;

	/**
	 * Sets up the instance variable for the testing methods
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testPlayedWord = new PlayedWord();
	}

	/**
	 * This method tests that an empty word is cleared
	 */
	@Test
	public void shouldClearEmptyWord() {
		this.testPlayedWord.clear();
		assertEquals(true, this.testPlayedWord.getHand().isEmpty());
	}

	/**
	 * This method tests that a word with one tile is cleared
	 */
	@Test
	public void shouldClearWordWithOneTile() {

		this.testPlayedWord.append(new Tile('D'));
		this.testPlayedWord.clear();

		assertEquals(true, this.testPlayedWord.getHand().isEmpty());
	}

	/**
	 * This method tests that a word with many tiles is cleared
	 */
	@Test
	public void shouldClearWordWithManyTiles() {

		this.testPlayedWord.append(new Tile('W'));
		this.testPlayedWord.append(new Tile('O'));
		this.testPlayedWord.append(new Tile('R'));
		this.testPlayedWord.append(new Tile('D'));

		this.testPlayedWord.clear();

		assertEquals(true, this.testPlayedWord.getHand().isEmpty());
	}

}
