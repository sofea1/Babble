
package edu.westga.cs.babble.views;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Custom Document class that is used as a model for the Message text field.
 * 
 * @author Sofiya Anikina
 * @version August 31, 2020
 */
public class MessageDocument extends PlainDocument {

	private static final long serialVersionUID = 1L;

	@Override
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		if (str == null) {
			return;
		}

		super.insertString(offs, str, a);
	}

}
