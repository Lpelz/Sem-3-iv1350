package se.kth.ict.pos.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class ItemSpecificationTest {
    
    @Test
    public void testToString() {

        String itemDescription = "green apple";
        int itemIdentifier = 3;
        int price = 10;
               
        ItemSpecification instance = new ItemSpecification(price,itemDescription,itemIdentifier);
         String expResult = "ItemDescription: "+ itemDescription + ", itemID:(" + itemIdentifier + "), " +
         "Price: " + price;
        String result = instance.toString();
        assertEquals("Wrong string by result",expResult, result);
    }

    @Test
    public void testEquals() {
    
    String itemDescription = "red apple";
    int itemIdentifier = 7;
    int price = 5;
    
    ItemSpecification instance = new ItemSpecification(price,itemDescription,itemIdentifier);
    ItemSpecification equalInstance = instance;
    boolean expResult = true;
    boolean result = instance.equals(equalInstance);
    assertEquals("ItemSpecification instances are not equal", expResult, result);
}
    @Test
    public void testNotEqualPrice(){
        
        String itemDescription = "yellow apple";
        int itemIdentifier = 10;
        int price = 6;
        
        ItemSpecification instance = new ItemSpecification(price,itemDescription,itemIdentifier);
        ItemSpecification notEqualPriceInstance = new ItemSpecification(4,itemDescription,itemIdentifier);
        
        boolean expResult = false;
        boolean result = instance.equals(notEqualPriceInstance);
        assertEquals("instances with diffrent prices are equal", expResult,result);
    }
    @Test
    public void testNotEqualItemIdentifier(){
        
       String itemDescription = "yellow banana";
       int itemIdentifier = 15;
       int price = 7;
       
       ItemSpecification instance = new ItemSpecification(price,itemDescription,itemIdentifier);
       ItemSpecification notEqualInstance = new ItemSpecification(price,itemDescription,14);
       
       boolean expResult = false;
       boolean result = instance.equals(notEqualInstance);
       assertEquals("instances with diffrent itemID are equal",expResult,result);
    }
    @Test
    public void testNotEqualItemDescription(){
        
        String itemDescription = "red flower";
        int itemIdentifier = 42;
        int price = 10;
        
        ItemSpecification instance = new ItemSpecification(price,itemDescription,itemIdentifier);
        ItemSpecification notEqualInstance = new ItemSpecification(price,"green flower",itemIdentifier);
        
        boolean expResult = false;
        boolean result = instance.equals(notEqualInstance);
        assertEquals("instances with diffrent itemDescriptions are equal",expResult,result);
    }
    
    @Test
    public void testNotEqualToNull(){
        
        String itemDescription = "blue flower";
        int itemIdentifier = 45;
        int price = 8;
        
        ItemSpecification instance = new ItemSpecification(price,itemDescription,itemIdentifier);
        Object notEqualInstance = null;
        
        boolean expResult = false;
        boolean result = instance.equals(notEqualInstance);
        assertEquals("ItemSpecification equal to null",expResult,result); 
    }
    
    
}

