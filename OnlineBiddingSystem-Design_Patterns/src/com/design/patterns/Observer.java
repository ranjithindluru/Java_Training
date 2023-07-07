package com.design.patterns;

/**
 * The Observer interface represents an observer in the Observer design pattern.
 * It defines the method that should be implemented by the observers.
 */
public interface Observer {
    /**
     * update the Items 
     * @param item The updated item.
     */
    void update(Item item);
}

