package com.design.patterns;

public class Bid {
	
	//Declare the reference object  for storing the item of the Bid
	private Item item;
	//Declare the private reference object for storing the bidder of the Bid
	private User bidder;
	//Declare the private amount field for storing of the Bid
	private double amount;
	//Declare the private winningBid field for storing the boolean value  of the Bid
	private boolean winningBid;

	public Bid(Item item, User bidder, double amount) {
		this.item = item;
		this.bidder = bidder;
		this.amount = amount;
		this.winningBid = false;
	}

	public Item getItem() {
		return item;
	}

	public User getBidder() {
		return bidder;
	}

	public double getAmount() {
		return amount;
	}

	public boolean isWinningBid() {
		return winningBid;
	}

	public void setWinningBid(boolean winningBid) {
		this.winningBid = winningBid;
	}

}
