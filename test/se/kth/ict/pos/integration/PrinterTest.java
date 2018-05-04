package se.kth.ict.pos.integration;

import java.time.LocalDateTime;
import se.kth.ict.pos.model.ItemSpecification;
import se.kth.ict.pos.model.Payment;
import se.kth.ict.pos.model.Sale;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class PrinterTest {
    private ByteArrayOutputStream output;
    private PrintStream systemOut;
    
    @Before
    public void setUp() {
        systemOut = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        
    }
    
    @After
    public void tearDown() {
        output = null;
        System.setOut(systemOut);
    }

    @Test
    public void testPrintSaleReceipt() {
       Sale sale = new Sale();
       String itemDescription = "Orange carrot";
       int itemIdentifier = 29;
       int price = 2;
       int quantity = 4;
       ItemSpecification itemSpec = new ItemSpecification(price, itemDescription, itemIdentifier); 
       sale.addToSale(itemSpec,quantity);
      
       Payment payment = new Payment(15);
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
