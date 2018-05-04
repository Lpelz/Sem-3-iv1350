package se.kth.ict.pos.controller;

import se.kth.ict.pos.integration.Printer;
import se.kth.ict.pos.integration.ExternalCreator;
import se.kth.ict.pos.integration.Inventory;
import java.util.List;
import se.kth.ict.pos.model.ItemSpecification;
import se.kth.ict.pos.model.Sale;
import se.kth.ict.pos.model.SoldItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControllerTest {
    
    private Controller instance;
    private ExternalCreator ext;
    private Sale sale;
      
    @Before
    public void setUp() {
        Printer printer = new Printer();
        ext = new ExternalCreator();
        instance = new Controller(ext);
        sale = new Sale();

    }
    
    @After
    public void tearDown() {
        ext = null;
        instance = null;
        sale = null;
        
    }
    
    @Test
    public void testEnterItemIdentifier() {
        String expResult;
        String result;
        instance.startSale();
        int price = 10;
        int itemIdentifier = 2;
        ItemSpecification itemSpec = new ItemSpecification(price,"Coconut candy bar",itemIdentifier);
        expResult = itemSpec.toString();
        int quantity = 1;
        ItemSpecification listItem = instance.enterItemIdentifier(itemIdentifier, quantity);
        result = listItem.toString();
        assertEquals(result, expResult);
    }

    @Test
    public void testEnterPayment() {
        int itemIdentifier = 2;
        int quantity = 2;
        instance.startSale();
        instance.enterItemIdentifier(itemIdentifier,quantity);
        instance.endSale();
        
        int result = instance.enterPayment(30);
        int expResult = 30 - 10*2;
       
        assertEquals("False amount of change ", expResult, result);
    }    

  
    @Test
    public void testStartAndEndSale() {
        
        instance.startSale();
        
        int itemIdentifier = 4;
        int quantity = 2;
        instance.enterItemIdentifier(itemIdentifier, quantity);        
        
        int expResult = 15*2;
        int result = instance.endSale();
        assertEquals("Wrong total cost",expResult, result);
    }

  
    @Test
    public void testSendSaleInfo() {
   
    ExternalCreator ext = new ExternalCreator();
    Controller contr = new Controller(ext);
    int itemIdentifier = 2;
    int quantity = 4;
    contr.startSale();
    contr.enterItemIdentifier(itemIdentifier,quantity);
    Sale sale = contr.getSale(); 
    Inventory instance = ext.getInventory();
    instance.updateInventory(sale);
    List <SoldItem> items = instance.getList();
    int result = items.get(1).getQuantity();
    int expResult = 10 - 4;
        assertEquals("Sale info has not been properly sent",expResult,result);    
    }
    
}
