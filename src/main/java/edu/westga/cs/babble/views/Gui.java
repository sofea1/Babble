package edu.westga.cs.babble.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import javax.swing.JList;
import javax.swing.text.*;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import edu.westga.cs.babble.controllers.GuiController;
import edu.westga.cs.babble.model.EmptyTileBagException;
import edu.westga.cs.babble.model.Tile;
import edu.westga.cs.babble.model.TileNotInGroupException;
import edu.westga.cs.babble.views.PlayedWordDocument.PlayedWordPlainDocument;

/**
 * This class extends GuiWindowBuilderLayout; used for any additional GUI
 * configuration code (including setting up model objects for Swing controls,
 * etc).
 * 
 * @author Sofiya Anikina
 * @version 08/15/2020
 *
 */
public class Gui extends GuiWindowBuilderLayout {

	private static final long serialVersionUID = 1L;
	private GuiWindowBuilderLayout gui;
	private TileListModel model;
	private GuiController game;
	private PlayedWordDocument documentD;
	private PlayedWordPlainDocument document;
	private JList<Tile> tileJList;
	private ScoreDocument scoreDocument;
	private MessageDocument messageDocument;

	/**
	 * Class constructor.
	 */
	public Gui() throws EmptyTileBagException {
		this.game = new GuiController();
		this.gui = new GuiWindowBuilderLayout();
	}

	/**
	 * Directs the flow of the application
	 * 
	 * @throws EmptyTileBagException
	 */
	public void run() throws EmptyTileBagException {

		this.game.startGame();
		try {

			this.gui.setTitle("Babble Game");
			this.gui.setVisible(true);
			this.gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.gui.setLayout(getLayout());
			this.gui.setBounds(100, 100, 280, 320);

			this.model = new TileListModel();
			this.tileJList = new JList<Tile>(this.model);
			this.tileJList.setModel(this.model);
			TileCellRenderer renderer = new TileCellRenderer();
			this.tileJList.setCellRenderer(renderer);
			this.tileJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
			this.tileJList.setSize(getMaximumSize());
			this.tileJList.setFixedCellWidth(15);
			this.tileJList.setVisibleRowCount(1);

			this.gui.panel.add(this.tileJList);
			this.gui.panel.setToolTipText("Displays the letters to select from to make a word");

			this.documentD = new PlayedWordDocument(90);
			this.document = this.documentD.new PlayedWordPlainDocument();
			
			this.gui.textFieldAnswer.setDocument(this.document);
			this.gui.textFieldAnswer.setToolTipText("Displays the selected letters");
			this.gui.textFieldAnswer.setText(this.documentD.getHand());

			this.gui.getAccessibleContext().getAccessibleStateSet();
			
			this.tileJList.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent lse) {
					if (!lse.getValueIsAdjusting()) {
						try {
							tileSelected();
							System.out.println("It works!");
							System.out.println("Test Doc Get Hand 2" + documentD.getHand());
							gui.textFieldAnswer.setText(documentD.getHand());
							TileCellRenderer renderer = new TileCellRenderer();
							tileJList.setCellRenderer(renderer);
							
						} catch (TileNotInGroupException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				}
			});

		} catch (IllegalArgumentException iae) {
			JOptionPane.showMessageDialog(null, iae.getMessage());
		}

		this.gui.btnReset.addActionListener(resetListener);
		this.gui.btnReset.setToolTipText("Reset Button");

		this.gui.btnPlayWord.addActionListener(playButtonListener);
		this.gui.btnPlayWord.setToolTipText("Play Word Button");

		this.scoreDocument = new ScoreDocument();
		this.gui.textFieldScore.setDocument(scoreDocument);
		this.gui.textFieldScore.setToolTipText("Shows the earned score");

		this.messageDocument = new MessageDocument();
		this.gui.textFieldMessage.setDocument(messageDocument);
		this.gui.textFieldMessage.setToolTipText("Message box");
	}

	ActionListener resetListener = new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			System.out.println(ae.getActionCommand());
			reset();
		}
	};

	ActionListener playButtonListener = new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			System.out.println(ae.getActionCommand());
			try {
				try {
					setButtonToPlayWord();
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			} catch (EmptyTileBagException e) {
				e.printStackTrace();
			}
		}
	};


	/**
	 * Moves a tile from the top rack to the played word area
	 * 
	 * @throws TileNotInGroupException
	 */
	private void tileSelected() throws TileNotInGroupException {
		Tile tile = this.tileJList.getSelectedValue();
		this.tileJList.getSelectionModel().clearSelection();

		if (tile != null) {
			this.game.moveTile(this.model.getTiles(), this.documentD.getTiles(), tile);
		}
	}

	/**
	 * Resets the Tile area. Removes a word from the word area.
	 * 
	 */
	private void reset() {
		while (this.documentD.getTiles().size() > 0) {
			Tile tile = this.documentD.getTiles().get(0);
			this.game.moveTile(this.documentD.getTiles(), this.model.getTiles(), tile);
			System.out.println("DOCUMENT size after reset " + this.documentD.getTiles().size());
			TileCellRenderer renderer = new TileCellRenderer();
			this.tileJList.setCellRenderer(renderer);
			this.gui.textFieldAnswer.setText("");
		}
	}

	/**
	 * Helper method for the Play Word button. Plays a word and checks if it is a
	 * word. Adds points and draws more tiles.
	 */
	private void setButtonToPlayWord() throws EmptyTileBagException, BadLocationException {
		if (this.game.getDictionary().isValidWord(this.documentD.getHand())) {

			System.out.println("DOCUMENT check word get hand " + this.documentD.getHand());
			int wordScore = this.documentD.getScore();
			this.game.addWordScore(wordScore);
			this.gui.textFieldMessage.setText("Played '" + this.documentD.getHand() + "' for " + wordScore + " points");
			this.documentD.clear();
			this.gui.textFieldScore.setText("" + this.game.getWordScore());
			this.model.fillRack();
			TileCellRenderer renderer = new TileCellRenderer();
			tileJList.setCellRenderer(renderer);
			this.gui.textFieldAnswer.setText("");
		} else {
			this.gui.textFieldMessage.setText("Not a valid word: " + this.documentD.getHand());
		}
	}
}
