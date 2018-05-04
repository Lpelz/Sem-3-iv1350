package se.kth.ict.pos.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class SoldItemTest {
  
    @Test
    public void testGetItemInfo() {
        int itemIdentifier = 63;
        String itemDescription = "mango juice";
        int price = 15;
        int quantity = 2;
        
        ItemSpecification itemSpec = new ItemSpecification(price,itemDescription,itemIdentifier);
        SoldItem instance = new SoldItem(itemSpec,quantity);
        String expResult = "ItemDescription: "+ itemDescription + ", itemID:(" + itemIdentifier + "),"
        + " quantity: " + quantity + ", price: " + price*quantity;
        String result = instance.getItemInfo();
        assertEquals(expResult, result);
    }
    
}
