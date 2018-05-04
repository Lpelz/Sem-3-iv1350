package se.kth.ict.pos.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Receipt representing information from current sale.
 */
public class Receipt {
    
    private final Sale sale;
    private final Payment payment;
  
/**
 *   Constructor for Receipt for sale.
 *
 *   @param sale Current sale receipt is made for.
 *   @param payment Payment that payed for purchase.
 */ 
 public Receipt(Sale sale, Payment payment){
        this.sale = sale;
        this.payment = payment;
  }
  /**
  * Creates a formatted string representing the sales receipt.
  *
  * @return The string representing the sales receipt.
  */  
 
 public String constructReceiptString(){
     
     StringBuilder sb = new StringBuilder();
     addString(sb, "Receipt of sale");
     newLine(sb);
     
     LocalDateTime timeOfSale = LocalDateTime.now();
     sb.append("Time of sale:");
     addString(sb, timeOfSale.toString());
     newLine(sb);
     
     sb.append("Purchased Items:");
     newLine(sb);
     itemListString(sale,sb);
     newLine(sb);
     
     String payedAmount = Integer.toString(payment.paidAmount);
     sb.append("Paid amount: ");
     addString(sb, payedAmount);
     
     String total = Integer.toString(sale.calculateTotalWithTaxes());
     sb.append("Total cost: " + total);
     newLine(sb);
     
     String change = Integer.toString(payment.paidAmount - sale.calculateTotalWithTaxes());
     sb.append("Total change: " + change);
     
     return sb.toString();
 }
  /**
  * Adds all the sold items information to the receipt string.
  *
  * @param sale Current sale that receipt will represent.
  * @param sb Stringbuilder that appends the sold items information.
  */   
   private void itemListString(Sale sale, StringBuilder sb){
   
       List <SoldItem> soldItemList = sale.getList();
       for(SoldItem sold : soldItemList){
        
          sb.append(sold.getItemInfo());
          newLine(sb);
        
       }
   
   }
  /**
  * Adds string to stringbuilder and then goes onto new line.
  *
  * @param sb Stringbuilder that appends string.
  * @param string String that is appended to the stringbuilder.
  */ 
  private void addString(StringBuilder sb, String string){
      
      sb.append(string);
      newLine(sb);
      
  }
  
  /**
  * Goes onto new line.
  * @param sb Stringbuilder where new line is created.
  */ 
  private void newLine(StringBuilder sb){
      sb.append("\n");
  }
   
}
