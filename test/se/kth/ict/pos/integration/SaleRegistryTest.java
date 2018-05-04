package se.kth.ict.pos.integration;

import java.util.List;
import se.kth.ict.pos.model.Sale;
import org.junit.Test;
import static org.junit.Assert.*;

public class SaleRegistryTest {
        
    @Test
    public void testSaveSaleInfo() {
        Sale sale = new Sale();
        Sale anotherSale = new Sale();

        SaleRegistry instance = new SaleRegistry();
        
        instance.saveSaleInfo(sale);
        instance.saveSaleInfo(anotherSale);
        List <Sale> sales = instance.getList();
        int result = sales.size();
        int expResult = 2;
        assertEquals("Wrong number of sales stored in SaleRegistry", result, expResult);
   
    }
    @Test
    public void noStoredSales(){
        SaleRegistry instance = new SaleRegistry();
        List <Sale> sales = instance.getList();

        assertTrue("Sale appeared without any existing", sales.isEmpty());   
    }
    
}
