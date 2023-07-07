package com.design.patterns;

import java.util.ArrayList;
import java.util.List;

public class ItemManagementService {
	
	private Auction auction;
	
	private List<Item> items;

	
	/**
     * Constructs a new ItemManagementService object.
     * Initializes the auction instance by getting the singleton instance of the Auction class.
     */
    public ItemManagementService() {
        this.auction = Auction.getInstance();
        this.items = new ArrayList<>();
        
        Item item1 = ItemFactory.createItem("Men's North Face Jacket", "A waterproof jacket for men", 1000.0);
        Item item2 = ItemFactory.createItem("Women's Columbia Jacket", "A warm and stylish jacket for women", 750.0);
        Item item3 = ItemFactory.createItem("Men Slim Mid Rise Light Blue Jeans","A Skinny fit with a waist & comfortably",600.0);
        Item item4 = ItemFactory.createItem("Men Slim Mid Rise Black Jeans","This fits snug on the thighs",700.0);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
    }

    /**
     * Adds a new item to the auction.
     * Creates an item using the ItemFactory and adds it to the auction using the Auction class.
     * @param startingBid2 
     * @param description2 
     * @param name 
     * 
     * @param name           The name of the item.
     * @param description    The description of the item.
     * @param startingBid    The starting bid amount for the item.
     */
    public void addItem(String name, String description, double startingBid) {
    	
        Item item = ItemFactory.createItem(name, description, startingBid);
        auction.addItem(item);
        
    }

    /**
     * Searches for items in the auction based on a given keyword.
     * This method returns a list of items matching the keyword.
     * 
     * @param keyword   The keyword to search for in item names or descriptions.
     * @return          A list of items matching the keyword.
     */

    public List<Item> searchItems(String keyword) {
    	List<Item> searchResults = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    item.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(item);
            }
        }
        return searchResults;
    }

    public Item getItemByName(String itemName) {
        
		for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null; // Item not found
    }
    
//    public void addItem() {
//    	Scanner scanner = new Scanner(System.in);
//		String itemname;
//		System.out.println("Enter item Name");
//		itemname = scanner.next();
//		itemname += scanner.nextLine();
//		System.out.println("Enter item Description");
//		String description = scanner.nextLine();
//		System.out.println("Enter startingBid");
//		double startingBid = scanner.nextDouble();
//		addItem(itemname, description, startingBid);
//		System.out.println("item added sucessfully...");
//		
//	}

}
