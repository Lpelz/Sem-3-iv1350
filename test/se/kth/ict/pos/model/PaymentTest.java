package se.kth.ict.pos.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class PaymentTest {
  
    @Test
    public void testGetCost() {
       
        Sale sale = new Sale();
        
        int price = 20;
        int itemIdentifier = 3;
        String itemDescription = "white icecream";
        
        ItemSpecification spec = new ItemSpecification(price,itemDescription,itemIdentifier);    
        int quantity = 1;
        sale.addToSale(spec,quantity);
        int total = sale.calculateTotalWithTaxes();
        
        Payment instance = new Payment(0);
        sale.sendPayment(instance);
        
        instance.calculateTotalPayment(total);
        
        int expResult = price;
        int result = instance.getCost();
        
        assertEquals("False total cost", expResult, result);
    }

    /**
     */
    @Test
    public void testGetChange() {
     Sale sale = new Sale();
              
     int price = 15;
     int itemIdentifier = 3;
     String itemDescription = "green icecream";
     
       ItemSpecification spec = new ItemSpecification(price,itemDescription,itemIdentifier);    
        
       sale.addToSale(spec,1);
       int total = sale.calculateTotalWithTaxes();
       Payment instance = new Payment(30);
               
       sale.sendPayment(instance);
        
       int expResult = instance.paidAmount - price;
       int result = instance.getChange();
       assertEquals("Wrong amount of change",expResult,result);
    }

}
