package se.kth.ict.pos.integration;

import se.kth.ict.pos.controller.Controller;
import java.util.List;
import se.kth.ict.pos.model.Sale;
import se.kth.ict.pos.model.SoldItem;
import se.kth.ict.pos.model.ItemSpecification;
import org.junit.Test;
import static org.junit.Assert.*;

public class InventoryTest {

   @Test
        public void testInventoryStorage() {

                ExternalCreator ext = new ExternalCreator();
                Inventory instance = ext.getInventory();
                List <SoldItem> inventory  = instance.getList();
                ItemSpecification itemSpec = new ItemSpecification(10,"Coconut candy bar" ,2);
                SoldItem sold = new SoldItem(itemSpec,10);
                SoldItem anotherSold = inventory.get(1);
                String itemInfo = sold.getItemInfo();
                String anotherItemInfo = anotherSold.getItemInfo();
                assertEquals("Item has not been stored in inventory",itemInfo,anotherItemInfo);
        }
    
    
}
