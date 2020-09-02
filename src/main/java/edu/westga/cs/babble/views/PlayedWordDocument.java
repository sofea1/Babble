
package edu.westga.cs.babble.views;

import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.*;

import edu.westga.cs.babble.model.EmptyTileBagException;
import edu.westga.cs.babble.model.PlayedWord;
import edu.westga.cs.babble.model.Tile;

/**
 * Custom Document class that is used as a model for the Played Word object and text field.
 * 
 * @author Sofiya Anikina
 * @version September 1, 2020
 */
public class PlayedWordDocument extends PlayedWord implements Document {
	private PlayedWord playedWord;
	private int limit;
	private TileListModel model;

	public PlayedWordDocument(int limit) throws EmptyTileBagException {
		this.playedWord = new PlayedWord();
		this.model = new TileListModel();
		Tile tile;
		for (int i = 0; i < this.playedWord.getTiles().size(); i++) {
			if (this.playedWord.getTiles().isEmpty()) {
				break;
			}
			tile = this.model.getTiles().get(i);
			this.playedWord.append(tile);
		}

	}

	@Override
	public void addDocumentListener(DocumentListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addUndoableEditListener(UndoableEditListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Position createPosition(int arg0) throws BadLocationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element getDefaultRootElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position getEndPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getProperty(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element[] getRootElements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position getStartPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText(int arg0, int arg1) throws BadLocationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getText(int arg0, int arg1, Segment arg2) throws BadLocationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		if (str == null)
			return;

		if ((getLength() + str.length()) <= limit) {
			// super.insertString(offset, str, attr);
			super.getHand();
		}
	}

	@Override
	public void putProperty(Object wordValue, Object newScore) {

	}

	@Override
	public void remove(int arg0, int arg1) throws BadLocationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeDocumentListener(DocumentListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUndoableEditListener(UndoableEditListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Runnable arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Custom PlainDocument class to access from textFieldAnswer JTextField.
	 */
	public class PlayedWordPlainDocument extends PlainDocument {

		private static final long serialVersionUID = 1L;

		public PlayedWordPlainDocument() throws EmptyTileBagException {

		}

		@Override
		public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
			if (str == null) {
				return;
			}
		}
	}

}
