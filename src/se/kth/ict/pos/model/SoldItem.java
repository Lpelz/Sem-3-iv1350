package se.kth.ict.pos.model;

/**
 * Represents an instance of an item sold in a sale.
 */
public class SoldItem {
    
  private ItemSpecification itemSpec;
  private int quantity;
    
    /**
     * Constructor for SoldItem.
     * @param itemSpec The specification of the SoldItem.
     * @param quantity The quantitiy of the SoldItem.
     */
    public SoldItem(ItemSpecification itemSpec, int quantity){
        this.itemSpec = itemSpec;
        this.quantity = quantity;
    }
    /**
     * 
     * @return The price of a SoldItem with regards to the quantity of it.
     */
    public int getPrice(){
        int cost = 0;
        cost = itemSpec.getItemPrice() * quantity;
        return cost;
    }
    /**
     * 
     * @return The quantity of a SoldItem
     */
    public int getQuantity(){
        return this.quantity;
    }
    
    /**
     * 
     * @return The itemspecification of a SoldItem
     */
    public ItemSpecification getItemSpecification(){
        return this.itemSpec;
    }
    /**
     * 
     * @return A string containing all information regarding the SoldItem.
     */
    public String getItemInfo(){
        String s = itemSpec.toStringWithoutPrice() + "quantity: " + quantity + ", price: " + 
        getPrice();
              
        return s;
    }
    /**
     * 
     * @param quantity The new quantity the SoldItem will have.
     */
    public void setQuantity(int quantity){
      this.quantity = quantity;
    }
    
}
