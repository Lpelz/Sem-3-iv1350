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

    }   @Test
        public void testLoadInventory() {

                ExternalCreator ext = new ExternalCreator();
                Inventory instance = ext.getInventory();
                List <SoldItem> inventory  = instance.getList();
                ItemSpecification itemSpec = new ItemSpecification(10,"Coconut candy bar" ,2);
                SoldItem sold = new SoldItem(itemSpec,10);
                SoldItem anotherSold = inventory.get(1);
                String itemInfo = sold.getItemInfo();
                String anotherItemInfo = anotherSold.getItemInfo();
                assertEquals("Item not loaded into inventory, ",itemInfo,anotherItemInfo);
        }
    
    
}
