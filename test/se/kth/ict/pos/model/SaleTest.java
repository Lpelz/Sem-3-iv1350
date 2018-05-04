package se.kth.ict.pos.model;

import se.kth.ict.pos.integration.Printer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SaleTest {
    
    ByteArrayOutputStream output;
    PrintStream systemOut;

    @Before
    public void setUp() {
        systemOut = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @After
    public void cleanUp() {
        output = null;
        System.setOut(systemOut);
    }


    @Test
    public void testAddToSale() {

        Sale instance = new Sale();
        List <SoldItem> soldItems = instance.getList();
        int price = 10;
        int itemIdentifier = 6;
        ItemSpecification itemSpec = new ItemSpecification(price,"Apple juice",itemIdentifier);
        int quantity = 3;
        instance.addToSale(itemSpec,quantity);
        SoldItem sold = soldItems.get(0);
        SoldItem sameSold = new SoldItem(itemSpec,quantity); 
        String result = sold.getItemInfo();
        String expResult = sameSold.getItemInfo();
        
        assertEquals("Item was not added to sale",result,expResult);
    }


    @Test
    public void testSendPayment() {
        Payment payment = new Payment(35);
        Sale instance = new Sale();
        String ItemDescription = "Orange juice";
        int quantity = 3;
        int price = 10;
        int itemIdentifier = 94;
        ItemSpecification itemSpec = new ItemSpecification(price,ItemDescription,itemIdentifier);
        instance.addToSale(itemSpec,quantity);
        instance.calculateTotalWithTaxes();
        int result = instance.sendPayment(payment);
        int expResult = payment.paidAmount - (quantity * price);
        assertEquals("Invalid amount of change", expResult, result);
    }

    @Test
    public void testCreateReceipt() {
       Sale sale = new Sale();
       String itemDescription = "Red tomato";
       int itemIdentifier = 18;
       int price = 4;
       int quantity = 4;
       ItemSpecification itemSpec = new ItemSpecification(price, itemDescription, itemIdentifier); 
       sale.addToSale(itemSpec,quantity);
      
       Payment payment = new Payment(50);
       sale.createReceipt(sale,payment,new Printer());
       
       String expResultContains = "ItemDescription: "+ itemDescription + ", itemID:(" + itemIdentifier + "),"+
        " quantity: " + quantity + ", price: " + price*quantity;

       LocalDateTime timeOfSale = LocalDateTime.now();

       String result = output.toString();
       
       assertTrue("Invalid receipt string.", result.contains(expResultContains));
       assertTrue("Wrong year of sale", result.contains(Integer.toString(timeOfSale.getYear())));
       assertTrue("Wrong day of sale.", result.contains(Integer.toString(timeOfSale.getDayOfMonth())));
       assertTrue("Wrong hour of sale.", result.contains(Integer.toString(timeOfSale.getHour())));
       assertTrue("Wrong minute of sale.", result.contains(Integer.toString(timeOfSale.getMinute())));
       
    }
    
}
