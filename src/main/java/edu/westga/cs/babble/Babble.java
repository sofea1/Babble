package edu.westga.cs.babble;

import edu.westga.cs.babble.model.EmptyTileBagException;
import edu.westga.cs.babble.views.Gui;
import edu.westga.cs.babble.views.GuiWindowBuilderLayout;

/**
 * Main class for the Babble project
 * 
 * @author Sofiya Anikina
 * @version cs6241
 */
public class Babble {

	
    /**
     * Start point for the application.
     * 
     * @param args not used
     * @throws EmptyTileBagException 
     */
    public static void main(String[] args) throws EmptyTileBagException {
    	Gui gui = new Gui();
		gui.run();
    }

}
