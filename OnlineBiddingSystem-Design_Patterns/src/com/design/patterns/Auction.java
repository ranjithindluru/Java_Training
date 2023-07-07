package com.design.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton design pattern.
 * 
 * The Auction class represents an auction system. 
 * It follows the Singleton design pattern, allowing only one instance of the class to exist.
 * 
 * what is Auction- a sale of property to the highest bidder
 */
public class Auction {
	private static Auction instance = null;
	private List<Item> items;

	/**
	 * Private constructor to create an instance of the Auction class. 
	 * Initializes the items list as an empty ArrayList.
	 */
	private Auction() {
		items = new ArrayList<>();
	
	}

	/**
	 * Returns the instance of the Auction class. If the instance is null, a new
	 * instance is created and returned.
	 * 
	 * @return The instance of the Auction class.
	 */
	public static Auction getInstance() {
		if (instance == null) {
			instance = new Auction();
		}
		return instance;
	}

	/**
	 * Adds an item to the auction.
	 * 
	 * @param item The item to be added.
	 */
	public void addItem(Item item) {
		items.add(item);
	}
}
