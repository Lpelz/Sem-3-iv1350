package se.kth.ict.pos.integration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import se.kth.ict.pos.model.ItemSpecification;
import se.kth.ict.pos.model.Sale;
import se.kth.ict.pos.model.SoldItem;
import se.kth.ict.pos.model.StoreCatalog;

/**
 * The inventory contains dummy items available for sale.
 */
public class Inventory {
    private List <SoldItem> inventory;
    private StoreCatalog storeCatalog;
    
    /**
     * Creates an inventory based on the dummy items in the StoreCatalog.
     */
    public Inventory(){
       storeCatalog = StoreCatalog.getCatalog();
       inventory = new ArrayList<>();
       loadInventory();
    }
    /**
     * Updates the inventory in regards to the completed sale, by removing the
     * sold items from the inventory.
     * @param sale The completed sale.
     */
    public void updateInventory (Sale sale){
      
      List <SoldItem> soldItem = sale.getList();
      
     for(SoldItem sold : soldItem){
       for(SoldItem inventoryItem : inventory){
         if(sold.getItemSpecification().equals(inventoryItem.getItemSpecification()))
            inventoryItem.setQuantity(inventoryItem.getQuantity() - sold.getQuantity());
     }
       }
    }
    /**
     * Fills the inventory with the dummy items from the StoreCatalog, with 
     * 10 of each of them.
     */
    private void loadInventory(){
        
        ItemSpecification itemSpec;
        int quantity = 10;
        Map <Integer,ItemSpecification> items = storeCatalog.getMap();
        
        for(int i = 0; i < items.size(); i++){
              itemSpec = items.get(i+1);
             inventory.add(new SoldItem(itemSpec,quantity));
                                      
        }
    }
    /**
     * 
     * @return The list of items in inventory.
     */
    public List getList(){
        return inventory;
    }
}
