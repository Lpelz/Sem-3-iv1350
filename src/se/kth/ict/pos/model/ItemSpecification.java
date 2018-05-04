package se.kth.ict.pos.model;

/**
 *
 * Represents the specifications of an item the retail store has to sell.
 */
public class ItemSpecification {
    private int price;
    private String itemDescription;
    private int itemIdentifier;
    /**
     * Constructor for ItemSpecification, creates an instance based on the specifications
     * of an dummy item.
     * @param price The price of the dummy item.
     * @param itemDescription The simple description of the dummy item.
     * @param Itemidentifier The identifier matching the dummy item in the StoreCatalog.
     */
    public ItemSpecification(int price, String itemDescription, int Itemidentifier){
        this.itemDescription = itemDescription;
        this.price = price;
        this.itemIdentifier = Itemidentifier;
    }
    /**
     * 
     * @return The price of the dummy item.
     */
    public int getItemPrice()
    {
        return this.price;
    }
    /**
     * 
     * @return The description of the dummy item.
     */
    public String getItemDescription(){
        return this.itemDescription;
    }
    
    /**
     * 
     * @return String containing all ItemSpecifications.
     */
    public String toString(){
          return toStringWithoutPrice() + "Price: " + price;
    }
     /**
      * 
      * @return String containing all ItemSpecifications except the price.
      */
     public String toStringWithoutPrice(){
          return "ItemDescription: "+ itemDescription + ", itemID:(" + itemIdentifier + "), ";
     }
}
    
    
    

