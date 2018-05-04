package se.kth.ict.pos.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.ict.pos.model.Sale;


/**
 * Represents an instance of a SaleRegistry that stores all completed sales.
 */
public class SaleRegistry {
    
    private List <Sale> sales = new ArrayList<>();
  
  SaleRegistry(){    
  }
  /**
   * Adds the completed sale to the list.
   * @param sale 
   */
  public void saveSaleInfo(Sale sale){
        sales.add(sale);
  }
  /**
   * 
   * @return List of completed sales.
   */
  public List getList(){
      return sales;
  }
}