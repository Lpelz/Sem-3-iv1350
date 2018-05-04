package se.kth.ict.pos.integration;
import java.util.List;
import se.kth.ict.pos.model.Sale;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountingTest {
   
    @Test
    public void testSendSaleInfoStorage() {
        Sale sale = new Sale();
        Sale anotherSale = new Sale();
        Accounting instance = new Accounting();
        
        instance.sendSaleInfo(sale);
        instance.sendSaleInfo(anotherSale);
        List <Sale> sales = instance.getList();
        int result = sales.size();
        int expResult = 2;
        assertEquals("Wrong number of sales stored in Accounting", result, expResult);
    }
     @Test
     public void testNoStoredSales(){
        Accounting instance = new Accounting();
        List <Sale> sales = instance.getList();

        assertTrue("Sale appeared without any existing", sales.isEmpty());   
    }
    
}
