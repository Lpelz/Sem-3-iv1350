package se.kth.ict.pos.model;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class ReceiptTest {
   
  
    @Test
    public void testConstructReceiptString() {
     
       Sale sale = new Sale();
       String itemDescription = "Green apple";
       int itemIdentifier = 16;
       int price = 6;
       int quantity = 2;
       ItemSpecification itemSpec = new ItemSpecification(price, itemDescription, itemIdentifier); 
       sale.addToSale(itemSpec,quantity);
      
       Payment payment = new Payment(50);
       Receipt instance = new Receipt(sale,payment);
       
       String expResultContains = "ItemDescription: "+ itemDescription + ", itemID:(" + itemIdentifier + "),"+
        " quantity: " + quantity + ", price: " + price*quantity;

       LocalDateTime timeOfSale = LocalDateTime.now();

       String result = instance.constructReceiptString();
       
       assertTrue("Invalid receipt string.", result.contains(expResultContains));
       assertTrue("Wrong year of sale", result.contains(Integer.toString(timeOfSale.getYear())));
       assertTrue("Wrong day of sale.", result.contains(Integer.toString(timeOfSale.getDayOfMonth())));
       assertTrue("Wrong hour of sale.", result.contains(Integer.toString(timeOfSale.getHour())));
       assertTrue("Wrong minute of sale.", result.contains(Integer.toString(timeOfSale.getMinute())));



    }
    
    
    
    
}
