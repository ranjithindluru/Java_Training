package com.design.patterns;

import java.util.ArrayList;
import java.util.List;


public class User {
	
   // Declare the Private field for storing the username of the user
	private String username;
    private String password;
    private List<Bid> biddingHistory;
    
    /**
     * Constructor for creating a User object.
     * @param username The username of the user.
     * @param password The password of the user.
     * Initializes the biddingHistory list as an empty ArrayList.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.biddingHistory = new ArrayList<>();
    }
    
    
    /**
     * Setter method for setting the username of the user.
     * @param username The new username to set.
     */
    public void setUsername(String username) {
		this.username = username;
	}
    
    /**
     * Getter method for retrieving the username of the user.
     * @return The username of the user.
     */
	public String getUsername() {
        return username;
    }

	 /**
     * Setter method for setting the password of the user.
     * @param password The new password to set.
     */
	public void setPassword(String password) {
		this.password = password;
	}
	
    /**
     * Getter method for retrieving the password of the user.
     * @return The password of the user.
     */
    public String getPassword() {
		return password;
	}

    /**
	 * Setter method for setting the bidding history of the user.
	 * @param biddingHistory The new bidding history to set.
	 */
	public void setBiddingHistory(List<Bid> biddingHistory) {
		this.biddingHistory = biddingHistory;
	}

	/**
	 * Getter method for retrieving the bidding history of the user.
	 * @return The bidding history of the user.
	 */
	public List<Bid> getBiddingHistory() {
		return biddingHistory;
	}

	
	
	/**
	 * Method for adding a bid to the bidding history of the user.
	 * @param bid The bid to add.
	 */

	public void addBid(Bid bid) {
        biddingHistory.add(bid);
    }

}
