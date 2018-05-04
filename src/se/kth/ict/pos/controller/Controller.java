package se.kth.ict.pos.controller;

import se.kth.ict.pos.model.Sale;
import se.kth.ict.pos.model.CashRegister;
import se.kth.ict.pos.model.Payment;
import se.kth.ict.pos.model.StoreCatalog;
import se.kth.ict.pos.model.ItemSpecification;
import se.kth.ict.pos.integration.ExternalCreator;
import se.kth.ict.pos.integration.Inventory;
import se.kth.ict.pos.integration.Printer;
import se.kth.ict.pos.integration.SaleRegistry;
import se.kth.ict.pos.integration.Accounting;

/**
 *  The only controller of the program, handles communication 
 *  between the layers of the program.
 */
public class Controller {
    
    private StoreCatalog storeCatalog;
    private Sale sale;
    private Payment payment;
    private CashRegister cashRegister;
    private Printer printer;
    private SaleRegistry saleRegistry;
    private Accounting acc;
    private Inventory inventory;
    
    /**
    * Constructor for controller.
    * @param creator Creates all external systems.
    */
    public Controller (ExternalCreator creator){
    storeCatalog = StoreCatalog.getCatalog();
    cashRegister = new CashRegister();
    printer = creator.getPrinter();
    saleRegistry = creator.getSaleRegistry();
    acc = creator.getAccounting();
    inventory = creator.getInventory();
    }
    /**
    * Search for the ItemSpecification matching the given itemIdentifier, and
    * add it to the current sale.
    *
    * @param itemIdentifier Key for item in StoreCatalog
    * @param quantity Amount of same item to be registered
    *
    * @return ItemSpecification matching given itemIdentifier
    */
    
    public ItemSpecification enterItemIdentifier(int itemIdentifier, int quantity){
        
        ItemSpecification itemSpec = storeCatalog.findItemSpecification(itemIdentifier);
        sale.addToSale(itemSpec,quantity);
                
      return itemSpec;
    }
    /**
    * Handles entered payment by updating balance of cashRegister. Creating and 
    * printing a receipt. Returning the amount of change to give.
    *
    * @param amount The payed amount.
    * @return The amount of change to give to the customer.
    */
    public int enterPayment(int amount){
        
        payment = new Payment(amount);
        cashRegister.addPay(payment);
        sale.createReceipt(sale, payment, printer);
        int change = sale.sendPayment(payment);
        return change;
       
    }
    
  /**
   * Initializes the sale, by creating a new instance of a Sale. 
   */
    public void startSale(){
        this.sale = new Sale();
    }
    
  /**
   * Ends the sale, and gives the total cost.
   *
   * @return total Full cost of the sale. 
   */ 
    public int endSale(){
        int total = sale.calculateTotalWithTaxes();
        return total;
    }
   /**
    * Sends the sale information from the completed sale to external systems.
    */
    public void sendSaleInfo(){
        
        saleRegistry.saveSaleInfo(sale);
        inventory.updateInventory(sale);
        acc.sendSaleInfo(sale);
    }
    /**
     * @return The current instance of the Sale.
    */ 
    public Sale getSale(){
        return this.sale;
    }
        
    
    
}
