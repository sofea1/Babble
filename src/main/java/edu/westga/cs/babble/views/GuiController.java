package edu.westga.cs.babble.views;

import edu.westga.cs.babble.controllers.WordDictionary;
import edu.westga.cs.babble.model.EmptyTileBagException;
import edu.westga.cs.babble.model.PlayedWord;
import edu.westga.cs.babble.model.Tile;
import edu.westga.cs.babble.model.TileBag;
import edu.westga.cs.babble.model.TileRack;

/**
 * All GUI behavior located in this class. Uses this class to create model objects with getters; 
 * the Gui class should have an instance variable of this class and use those getters 
 * to set the models for the various components.
 * 
 * @author Sofiya Anikina
 * @version 08/15/2020
 *
 */
public class GuiController {
	
	private Tile tile;
	private TileBag bag;
	private WordDictionary dictionary;
	private TileRack rack;
	private int score;
	private PlayedWord playedWord;
	
	/**
	 * Class constructor that creates a new controller.
	 */
	public GuiController() {
		//this.tile = null;
		this.bag = null;
		this.rack = null;
		this.score = 0;
		this.dictionary = new WordDictionary();
	}
	
	/**
	 * Initializes a new game. Must be called before any other methods.
	 */
	public void startGame()
	{
		this.bag = new TileBag();
		this.rack = new TileRack();
		this.score = 0;
		
		
	}
	
	/**
	 * Gets the Tile bag.
	 * 
	 * @return tile bag
	 */
	public TileBag getBag() {
		return this.bag;
	}
	
	

}
