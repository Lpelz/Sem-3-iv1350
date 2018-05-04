package se.kth.ict.pos.integration;

import se.kth.ict.pos.controller.Controller;
import java.util.List;
import se.kth.ict.pos.model.Sale;
import se.kth.ict.pos.model.SoldItem;
import org.junit.Test;
import static org.junit.Assert.*;

public class InventoryTest {

    @Test
    public void testUpdateInventory() {
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
        assertEquals("Inventory has not been updated correctly",expResult,result);       

    }   
}
