package se.kth.ict.pos.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.ict.pos.model.Sale;

/**
 *
 * Stores the sale information for future accounting.
 */
public class Accounting {
  
    private List <Sale> sales = new ArrayList<>();
    /**
     * Creates list that will hold the information of the completed sales,
     * that will be used for accounting.
     */
    public Accounting(){
    }
    /**
     * Adds the completed sale to the List.
     * @param sale 
     */
    public void sendSaleInfo(Sale sale){
        sales.add(sale);
    }
    /**
     * 
     * @return The list of completed sales
     */
    public List getList(){
        return sales;
    }
}
