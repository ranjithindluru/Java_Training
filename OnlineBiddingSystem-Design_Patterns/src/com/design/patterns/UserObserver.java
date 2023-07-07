package com.design.patterns;

/**
 * The UserObserver class represents an observer that notifies a user of being outbid on an item.
 * It implements the Observer interface.
 */
public class UserObserver implements Observer {
	
    private User user;

    /**
     * Constructs a UserObserver object with the specified user.
     * @param user The user to be observed.
     */
    public UserObserver(User user) {
        this.user = user;
    }
    

    public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	/**
     * 
     * Notifies the user of being outbid on the item with update.
     * @param item The updated item.
     */
	@Override
	public void update(Item item) {
		 // Notify user of being outbid
		if (item.getHighestBidder() != null && !item.getHighestBidder().equals(user)) {
			System.out.println("You have been outbid on item: " + item.getName());
		}
	   // System.out.println("You have been outbid on the item: " + item.getName());
	}
}
