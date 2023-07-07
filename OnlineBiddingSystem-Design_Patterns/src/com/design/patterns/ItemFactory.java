package com.design.patterns;

/**
 * Factory design pattern.
 * 
 * The ItemFactory class represents a factory for creating Item objects.
 * It follows the Factory design pattern, providing a static method to create items.
 */
public class ItemFactory {

    /**
     * Creates and returns an Item object with the specified name, description, and starting bid.
     * @param name The name of the item.
     * @param description The description of the item.
     * @param startingBid The starting bid for the item.
     * @return The created Item object.
     */
    public static Item createItem(String name, String description, double startingBid) {
        return new Item(name, description, startingBid);
    }
}

