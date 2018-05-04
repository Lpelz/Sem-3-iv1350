package se.kth.ict.pos.startup;

import se.kth.ict.pos.controller.Controller;
import se.kth.ict.pos.integration.ExternalCreator;
import se.kth.ict.pos.integration.Printer;
import se.kth.ict.pos.view.View;

/**
 * Main starts the program.
 */
public class Main {

    /**
     * Initializes the program.
     * @param args Program does not handle any command line parameters.
     */
    public static void main(String[] args) {
        
        ExternalCreator creator = new ExternalCreator();
        Printer printer = new Printer();
        Controller contr = new Controller(creator);
        View view = new View(contr);

        view.testExecution();

    }
    
}
