package se.kth.ict.pos.view;

import se.kth.ict.pos.controller.Controller;
import se.kth.ict.pos.model.ItemSpecification;

/**
 * The program lacks a real view, this is a placeholder for it.
 */
public class View {
    private Controller contr;
    
  /**
   * Constructor for view.
   * 
   * @param contr The controller that handles all system operations.
   */ 
  public View(Controller contr){
    
    this.contr = contr;
  }
  /**
   * Gives a simulation of user input leading to all system operations being 
   * executed.
   */     
  public void testExecution(){    
    
    contr.startSale();
    
    ItemSpecification regOne = contr.enterItemIdentifier(1,1);
    System.out.println("Item registered: " + regOne.toString()+ "\n");
    
    ItemSpecification regTwo = contr.enterItemIdentifier(2,4);
    System.out.println("Item registered: " + regTwo.toString()+ "\n");
    
    ItemSpecification regThree = contr.enterItemIdentifier(3,6);
    System.out.println("Item registered: " + regThree.toString() + "\n");
   
    ItemSpecification regFour = contr.enterItemIdentifier(4,3);
    System.out.println("Item registered: " + regFour.toString()+ "\n");

    int total = contr.endSale();

    System.out.println("Total to pay: "+ total + "\n");
   
    contr.enterPayment(150);
    
    contr.sendSaleInfo();
    
    
  }
}
