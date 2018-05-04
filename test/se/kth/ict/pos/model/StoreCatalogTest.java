package se.kth.ict.pos.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class StoreCatalogTest {
    
    @Test
    public void testFindItemSpecificationFound() {
        int itemIdentifier = 3;
        int price = 3;
        StoreCatalog instance = StoreCatalog.getCatalog();
        ItemSpecification itemSpec = new ItemSpecification(price,"Ecological banana", itemIdentifier);
        ItemSpecification anotherItemSpec = instance.findItemSpecification(itemIdentifier);
        String result = anotherItemSpec.toString();
        String expResult = itemSpec.toString();
        assertEquals("Wrong ItemSpecification found", expResult, result);
    }
    @Test
    public void testFindItemSpecificationNotFound(){
        int itemIdentifier = 104;
        StoreCatalog instance = StoreCatalog.getCatalog();
        ItemSpecification result = instance.findItemSpecification(itemIdentifier);
        ItemSpecification expResult = null;
        assertEquals("Non existing ItemSpecification in catalog found", expResult, result);
        
    }
  
}
