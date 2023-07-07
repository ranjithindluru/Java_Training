package com.design.patterns;

/**
 * The Item class represents an item available for auction.
 */
public class Item {
	
	//Declare the Private field for storing the name of the Item
	private String name;
	private String description;
	private double currentHighestBid;
	private User highestBidder;

	/**
	 * Constructor for creating an Item object.
	 * 
	 * @param name        The name of the item.
	 * @param description The description of the item.
	 * @param startingBid The starting bid for the item.
	 */
	public Item(String name, String description, double startingBid) {
		this.name = name;
		this.description = description;
		this.currentHighestBid = startingBid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCurrentHighestBid() {
		return currentHighestBid;
	}

	public void setCurrentHighestBid(double currentHighestBid) {
		this.currentHighestBid = currentHighestBid;
	}

	public User getHighestBidder() {
		return highestBidder;
	}

	public void setHighestBidder(User highestBidder) {
		this.highestBidder = highestBidder;
	}
	
	

//    public void addObserver(UserObserver observer) {
//        observers.add(observer);
//    }
//
//    private void notifyObservers() {
//        for (UserObserver observer : observers) {
//            observer.update(this);
//        }
//    }

	/**
	 * Places a bid on the item. If the bid amount is higher than the current
	 * highest bid.
	 * 
	 * @param user         The user placing the bid.
	 * @param bidAmount    The amount of the bid.
	 */
	public void placeBid(User user, double bidAmount) {
		if (bidAmount > currentHighestBid) {
			currentHighestBid = bidAmount;
			highestBidder = user;
		}
	}
}
