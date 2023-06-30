package com.OnilneShoopingSystem;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * maps `Product` objects to their quantities.
	 * 
	 */
	private HashMap<Product, Integer> items;

	// constructor
	public ShoppingCart() {
		items = new HashMap<>();
	}

	/**
	 * adds a product and its quantity to the shopping cart.
	 * 
	 * @param product
	 * @param quantity
	 */
	public void addItem(Product product, int quantity) {
		if (items.containsKey(product)) {
			int currentQuantity = items.get(product);
			items.put(product, currentQuantity + quantity);
		} else {
			items.put(product, quantity);
		}
	}

	/**
	 * removes a product from the shopping cart.
	 * 
	 * @param product
	 */
	public void removeItem(Product product) {
		items.remove(product);
	}

	/**
	 * returns the total price of all the items in the shopping cart.
	 * 
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		double totalPrice = 0.0;
		for (Map.Entry<Product, Integer> entry : items.entrySet()) {
			Product product = entry.getKey();
			int quantity = entry.getValue();
			totalPrice += product.getPrice() * quantity;
		}
		return totalPrice;
	}

	public HashMap<Product, Integer> getItems() {
		return items;
	}

	// clear the Cart items to the Shopping cart
	public void clearCart() {
		items.clear();

	}

	/**
	 * display the Cart details to the quantity.
	 * 
	 */
	public void displayCart() {
		for (Map.Entry<Product, Integer> entry : items.entrySet()) {
			Product product = entry.getKey();
			int quantity = entry.getValue();
			System.out.println(product + ", Quantity: " + quantity);
		}
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}

}
