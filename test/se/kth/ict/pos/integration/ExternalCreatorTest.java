package se.kth.ict.pos.integration;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExternalCreatorTest {
    
    @Test
    public void testGetPrinter() {
        ExternalCreator instance = new ExternalCreator();
        Printer result = instance.getPrinter();
        assertTrue("Printer has not been created", result instanceof Printer);
  
    }

    @Test
    public void testCreateAccounting() {  
        ExternalCreator instance = new ExternalCreator();
        Accounting result = instance.getAccounting();
        assertTrue("Accounting has not been created", result instanceof Accounting);
    
    }

    @Test
    public void testCreateSaleRegistry() {
        ExternalCreator instance = new ExternalCreator();
        SaleRegistry result = instance.getSaleRegistry();
        assertTrue("Printer has not been created", result instanceof SaleRegistry);
      
    }

    @Test
    public void testCreateInventory() {
        ExternalCreator instance = new ExternalCreator();
        Inventory result = instance.getInventory();
        assertTrue("Inventory has not been created", result instanceof Inventory);
     
    }
    
}
