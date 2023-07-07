package com.design.patterns;


public class AutomaticBiddingStrategy implements BiddingStrategy {
	
	/**
	 * create double bid method with parameters item and user 
	 * declare the double to get the currentHighestBid
	 * declare the automaticBid 
	 */
	public double bid(Item item, User user,double amount) {
		double currentBid = item.getCurrentHighestBid();
        double automaticBid = currentBid + 1.0; // Place a bid that is 10 units higher than the current highest bid
        item.placeBid(user, automaticBid);
        return automaticBid;
		
    }
}
