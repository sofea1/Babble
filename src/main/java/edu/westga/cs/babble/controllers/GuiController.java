package edu.westga.cs.babble.controllers;

import java.util.List;

import edu.westga.cs.babble.model.EmptyTileBagException;
import edu.westga.cs.babble.model.Tile;
import edu.westga.cs.babble.model.TileNotInGroupException;
import edu.westga.cs.babble.views.GuiWindowBuilderLayout;
import edu.westga.cs.babble.views.MessageDocument;
import edu.westga.cs.babble.views.PlayedWordDocument;
import edu.westga.cs.babble.views.TileListModel;

/**
 * All GUI behavior located in this class. Uses this class to create model
 * objects with getters; the Gui class should have an instance variable of this
 * class and use those getters to set the models for the various components.
 * 
 * @author Sofiya Anikina
 * @version 08/15/2020
 *
 */
public class GuiController {

	private WordDictionary dictionary;
	private int score;
	private GuiWindowBuilderLayout builder;
	private TileListModel tileModel;
	private PlayedWordDocument document;
	private MessageDocument messageDocument;

	/**
	 * Class constructor that creates a new controller.
	 * 
	 * @throws EmptyTileBagException
	 */
	public GuiController() throws EmptyTileBagException {
		this.score = 0;
		this.dictionary = new WordDictionary();

		this.document = new PlayedWordDocument(7);
		this.builder = new GuiWindowBuilderLayout();
	}

	/**
	 * Initializes a new game. Must be called before any other methods.
	 * 
	 * @throws EmptyTileBagException
	 */
	public void startGame() throws EmptyTileBagException {
		this.score = 0;
		this.tileModel = new TileListModel();
		this.messageDocument = new MessageDocument();
	}

	/**
	 * Gets the TileListModel object.
	 * 
	 * @return model
	 */
	public TileListModel getTileModel() {
		return this.tileModel;
	}

	/**
	 * Gets the PlayedWordDocument object.
	 * 
	 * @return document
	 */
	public PlayedWordDocument getPlayedWordDocument() {
		return this.document;
	}

	/**
	 * Gets the MessageDocument object.
	 * 
	 * @return messageDocument
	 */
	public MessageDocument getMessageDocument() {
		return this.messageDocument;
	}

	/**
	 * Gets the WordDictionary object.
	 * 
	 * @return dictionary
	 */
	public WordDictionary getDictionary() {
		return this.dictionary;
	}

	/**
	 * Gets the total score earned
	 * 
	 * @return the score
	 */
	public int getWordScore() {
		return this.score;
	}

	/**
	 * Adds a score to the total score.increases the user's score by the amount the
	 * played word is worth
	 * 
	 * @param score
	 * @return the score
	 */
	public void addWordScore(int score) {
		this.score += score;
	}

	/**
	 * Moves a Tile from a list to another list
	 * 
	 * @param fromRack The List<Tile> the Tile should move FROM
	 * @param document The List<Tile> the Tile should move TO
	 * @param tile     The Tile to be moved
	 * @throws TileNotInGroupException
	 */
	public void moveTile(List<Tile> fromRack, List<Tile> toRack, Tile tile) {
		fromRack.remove(tile);
		toRack.add(tile);

	}

}