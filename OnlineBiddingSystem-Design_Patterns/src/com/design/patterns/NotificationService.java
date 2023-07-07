package com.design.patterns;

public class NotificationService {
	
	public void notifyUser(User user, Item item) {
		UserObserver observer = new UserObserver(user);
		observer.update(item);
        System.out.println("You have been outbid on item: " + item.getName());
    }

}
