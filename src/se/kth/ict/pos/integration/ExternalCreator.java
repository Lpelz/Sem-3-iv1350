package se.kth.ict.pos.integration;

/**
 * The ExternalCreator creates the external systems.
 */
public class ExternalCreator {
    
    private Accounting account = new Accounting();
    private Inventory inventory = new Inventory();
    private SaleRegistry saleRegistry = new SaleRegistry();
    private Printer printer = new Printer();   
    
    /**
     * 
     * @return The created instance of the Printer.
     */
    public Printer getPrinter(){
        return this.printer;
    }
    /**
     * 
     * @return The created instance of the Accounting.
     */
    public Accounting getAccounting(){
        return this.account;
    }
    /**
     * 
     * @return The created instance of the SaleRegistry.
     */
    public SaleRegistry getSaleRegistry(){
        return this.saleRegistry;
    }
    /**
     * 
     * @return The created instance of the Inventory. 
     */
    public Inventory getInventory(){
        return this.inventory;
    }
}
