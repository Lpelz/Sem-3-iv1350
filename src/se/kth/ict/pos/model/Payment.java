package se.kth.ict.pos.model;

/**
 * Representing the payment for current sale.
 */
public class Payment {
    
  public int paidAmount;
  private int totalCost;
  private int change;
  
   /** 
   * Constructor for payment. Paidamount from sale entered.
   *
   * @param paidAmount amount payed for purchase by customer.
   */
   public Payment(int paidAmount){
       this.paidAmount = paidAmount;
   }
  
   /**
   * Calculates the total cost of the current sale
   *
   * @param totalWithTaxes Total cost for sale
   */
    void calculateTotalPayment(int totalWithTaxes){
        
        totalCost = totalWithTaxes;
    }
   
    /**
    * Calculates the total change from the current sale
    *
    * @param totalWithTaxes Total cost for sale
    */  
    void calculateTotalChange(int totalWithTaxes){
        
        change = paidAmount - totalWithTaxes;
    }
   
    /**
    * @return Total cost from the current sale
    */  
    int getCost(){
        return totalCost;
    }
   
    /**
    * @return Total change from the current sale
    */  
    int getChange(){
        return change;
    }
 }
       
    

