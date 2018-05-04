package se.kth.ict.pos.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Represents the one and only instance of a StoreCatalog containing the dummy 
 * items.
 */
public class StoreCatalog {
    
    
    private final static StoreCatalog storeCatalog = new StoreCatalog();

    
    private final Map <Integer, ItemSpecification> items = new HashMap <>();
    
    /**
     * Constructor for StoreCatalog, dummy items put into the Catalog.
     * 
    */
    private StoreCatalog(){
        
        items.put(1, new ItemSpecification(40,"Low fat vanilla cake",1));
        items.put(2, new ItemSpecification(10,"Coconut candy bar" ,2));
        items.put(3, new ItemSpecification(3,"Ecological banana", 3));
        items.put(4, new ItemSpecification(15,"Zero sugar diet soda",4));        

    }
    /**
     * Find an item in the StoreCatalog.
     * @param itemIdentifier Corresponds to the item to find.
     * @return The ItemSpecification matching the identifier.
     */
    public ItemSpecification findItemSpecification(int itemIdentifier){
        
        return items.get(itemIdentifier);  
    }
    
    /**
     * 
     * @return The only created instance of the StoreCatalog. 
     */
    public static StoreCatalog getCatalog(){
        return storeCatalog;
    }
    /**
     * 
     * @return Map for dummy items.
     */
    public Map getMap(){
        return items;
    }
   
}
