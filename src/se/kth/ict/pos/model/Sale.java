package se.kth.ict.pos.model;

import java.util.List;
import java.util.ArrayList;
import se.kth.ict.pos.integration.Printer;
/**
 * Represents an instance of a sale in a retail store.
 */
public class Sale {
    
    private List <SoldItem> soldItems;
    private int totalAmount;
    private int totalChange;
    
    /**
     * Constructor for Sale, creating an ArrayList that will be used to store 
     * items sold in the sale.
     */
    public Sale()
    {
        soldItems = new ArrayList<>();
    }
    /**
     * Adds an Item and the quantity of it to the current sale, by creating an 
     * instance of a SoldItem and adding it to the SoldItem list.
     * 
     * @param itemSpec The specification of the sold item.
     * @param quantity The quantity of the sold item.
     */
    public void addToSale(ItemSpecification itemSpec, int quantity){
        SoldItem sold = new SoldItem(itemSpec,quantity);
       
        soldItems.add(sold);
    }
    /**
     * Calculates total cost of all SoldItem registered in sale, taxes are considered
     * to be included in the price of items. 
     * 
     * @return Total cost of all items registered in sale
     */
    public int calculateTotalWithTaxes(){
        int total = 0;
        for(SoldItem sold : soldItems){
            total = total + sold.getPrice();
        }
        totalAmount = total;
    return total;
    }
    
    /**
     * Calculates and returns change to give to customer, based on given payment
     * and total cost of purchase.
     * @param payment The payment that was given by the customer.
     * @return The total amount of change to give to the customer.
     */
    public int sendPayment(Payment payment){
        
        payment.calculateTotalChange(totalAmount);
        payment.calculateTotalPayment(totalAmount);
        
          totalChange = payment.getChange();
        return totalChange;

    }
    /**
     * Creates an instance of an receipt that represents the current sale.
     * Instance then sent to printer to be printed.
     * @param sale The sale the receipt will represent.
     * @param payment The payment for the items registered in the sale.
     * @param printer The printer that will print the receipt.
     * @return The created instance of the receipt.
     */
    public Receipt createReceipt(Sale sale, Payment payment, Printer printer){
        Receipt receipt = new Receipt(sale, payment);
        printer.printSaleReceipt(receipt);
        return receipt;
    }
    /**
     * @return List of items sold in sale.
     */
    public List getList(){
        return this.soldItems;
    }
    
    /**
     * 
     * @return Total amount of change to give to customer.
     */
    public int getTotalChange(){
        return totalChange;
    }
    /**
     * 
     * @return Total cost of all items registered in sale.
     */
    public int getTotal(){
        return totalAmount;
    }

    
}
