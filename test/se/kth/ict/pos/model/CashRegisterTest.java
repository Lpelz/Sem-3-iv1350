package se.kth.ict.pos.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class CashRegisterTest {
    
    @Test
    public void testAddPay() {
        int paymentAmount = 30;
        Payment payment = new Payment(paymentAmount);
        CashRegister instance = new CashRegister();
      
        instance.addPay(payment);
        int result = instance.getTotal();
        int expResult = paymentAmount;
        assertEquals("Wrong amount stored in CashRegister",result,expResult);
    }
    
}
