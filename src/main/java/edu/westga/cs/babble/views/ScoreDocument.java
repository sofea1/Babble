
package edu.westga.cs.babble.views;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Custom Document class that is used as a model for the Score text field.
 * 
 * @author Sofiya Anikina
 *
 */
public class ScoreDocument extends PlainDocument {
	private static final long serialVersionUID = 1L;

	/**
	 * Blocks other than integer inputs
	 * 
	 * @param offs @see PlainDocument
	 * @param str  @see PlainDocument
	 * @param a    @see PlainDocument
	 * @throws BadLocationException @see PlainDocument
	 */
	@Override
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		if (str != null) {
			try {
				Integer.decode(str);
				super.insertString(offs, str, a);
			} catch (NumberFormatException ex) {

			}
		}
	}
}
