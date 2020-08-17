package edu.westga.cs.babble;

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
     */
    public static void main(String[] args) {
    	//GuiWindowBuilderLayout gui = new GuiWindowBuilderLayout();
    	Gui gui = new Gui();
		gui.run();
    }

}
