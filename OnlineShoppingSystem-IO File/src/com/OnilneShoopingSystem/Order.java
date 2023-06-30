package com.OnilneShoopingSystem;

import java.io.Serializable;
import java.util.HashMap;


public class Order implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static int nextConfirmationNumber = 1;

    private int confirmationNumber;
    private HashMap<Product, Integer> items;
    private double totalPrice;

    public Order(HashMap<Product, Integer> items, double totalPrice) {
        this.confirmationNumber = nextConfirmationNumber++;
        this.items = items;
        this.totalPrice = totalPrice;
    }
    
    

    public int getConfirmationNumber() {
        return confirmationNumber;
    }

    public HashMap<Product, Integer> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    
    @Override
    public String toString() {
        return "Order Confirmation Number: " + confirmationNumber +
                ", Items: " + items +
                ", Total Price: $" + totalPrice;
    }

}
