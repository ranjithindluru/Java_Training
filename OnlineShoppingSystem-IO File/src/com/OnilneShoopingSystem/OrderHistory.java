package com.OnilneShoopingSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class OrderHistory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Order> orders;

	public OrderHistory() {
		orders = new ArrayList<>();
	}

	/** adds an order to the order history
	 * 
	 * @param order
	 */
	public void addOrder(Order order) {
		orders.add(order);
	}

	// 
	public void displayOrderHistory() {
		for (Order order : orders) {
			System.out.println(order);
		}
	}

	/**loads the order history from a file using serialization
	 * 
	 * @param fileName
	 */
	public void loadOrderHistory(String fileName) {
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			orders = (ArrayList<Order>) objectIn.readObject();
			objectIn.close();
			fileIn.close();
			System.out.println("Order history loaded successfully.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error loading order history: " + e.getMessage());
		}
	}

	/** saves the order history to a file using serialization
	 * 
	 * @param fileName
	 */
	public void saveOrderHistory(String fileName) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(orders);
			objectOut.close();
			fileOut.close();
			System.out.println("Order history saved successfully.");
		} catch (IOException e) {
			System.out.println("Error saving order history: " + e.getMessage());
		}
	}

}
