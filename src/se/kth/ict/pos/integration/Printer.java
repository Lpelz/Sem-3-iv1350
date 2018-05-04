package se.kth.ict.pos.integration;

import se.kth.ict.pos.model.Receipt;

/**
 * Represents an instance of a Printer that will print the sales receipt.
 */
public class Printer {
        /**
         * Prints the sale receipt, in dummy implementation
         * by using System.out for output.
         * @param receipt The receipt that will be printed.
         */
        public void printSaleReceipt(Receipt receipt){
        System.out.println(receipt.constructReceiptString());
        }
       
}
