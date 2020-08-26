/**
 * 
 */
package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class tests the match method of the PlayedWord class
 * 
 * @author Sofiya Anikina
 * @version August 26, 2020
 *
 */
class TestPlayedWordMatches {
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
	 * This method tests the matches method with a multiple-letter word
	 */
	@Test
	public void hasTilesForAMultipleLetterWord() {

		this.testPlayedWord.append(new Tile('P'));
		this.testPlayedWord.append(new Tile('L'));
		this.testPlayedWord.append(new Tile('A'));
		this.testPlayedWord.append(new Tile('N'));
		this.testPlayedWord.append(new Tile('T'));

		assertEquals(true, this.testPlayedWord.matches("PLANT"));
		assertTrue(this.testPlayedWord.matches(this.testPlayedWord.getHand()));
	}

	/**
	 * This method tests the match method with a one-letter word
	 */
	@Test
	public void hasTilesForASingleLetterWord() {

		Tile testTile = new Tile('A');
		this.testPlayedWord.append(testTile);

		assertEquals(true, this.testPlayedWord.matches("A"));
		assertTrue(this.testPlayedWord.matches(this.testPlayedWord.getHand()));
	}

	/**
	 * This method tests that the match method does not match scrambled words that
	 * have the same letters in a different order
	 */
	@Test
	public void cannotMatchWordWhenTilesAreScrambled() {

		this.testPlayedWord.append(new Tile('G'));
		this.testPlayedWord.append(new Tile('E'));
		this.testPlayedWord.append(new Tile('T'));

		assertEquals(false, this.testPlayedWord.matches("TGE"));
	}

	/**
	 * This method tests that words don't match when the new word has insufficient
	 * letters to match the other word
	 */
	@Test
	public void cannotMatchWordIfInsufficientTiles() {

		this.testPlayedWord.append(new Tile('C'));
		this.testPlayedWord.append(new Tile('A'));
		assertEquals(false, this.testPlayedWord.matches("CAT"));
	}

	/**
	 * This method tests that the match method matches words with duplicate letters
	 */
	@Test
	public void canMatchWordWithDuplicateLetters() {

		this.testPlayedWord.append(new Tile('H'));
		this.testPlayedWord.append(new Tile('E'));
		this.testPlayedWord.append(new Tile('L'));
		this.testPlayedWord.append(new Tile('L'));
		this.testPlayedWord.append(new Tile('O'));

		assertEquals(true, this.testPlayedWord.matches("HELLO"));
		assertTrue(this.testPlayedWord.matches(this.testPlayedWord.getHand()));
	}

	/**
	 * This method tests that a non-empty word is not be an empty text
	 */
	@Test
	public void nonEmptyWordShouldNotMatchEmptyText() {

		this.testPlayedWord.append(new Tile('M'));
		assertEquals(false, this.testPlayedWord.matches(""));
	}

	/**
	 * This method tests that a empty word does not match an empty text
	 */
	@Test
	public void emptyWordShouldNotMatchEmptyText() {
		assertEquals(false, this.testPlayedWord.matches(""));
	}

	/**
	 * This method tests that the match method does not allow null values
	 */
	@Test
	public void shouldNotAllowNull() {

		assertThrows(IllegalArgumentException.class, () -> this.testPlayedWord.matches(null));

	}
}
