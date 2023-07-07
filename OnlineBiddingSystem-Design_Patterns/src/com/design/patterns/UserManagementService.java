package com.design.patterns;

import java.util.ArrayList;
import java.util.List;


public class UserManagementService {
	 private List<User> users;

	    public UserManagementService() {
	        this.users = new ArrayList<>();
	    }

	    /**
	     * Create the user with the username and password
	     * @param username The username of the user
	     * @param password The password of the user
	     */
	    public void createUser(String username, String password) {
	        User user = new User(username, password);
	        users.add(user);
	    }

	    public User authenticateUser(String username, String password) {
	        for (User user : users) {
	            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
	                return user;
	            }
	        }
	        return null;
	    }
	    
	    /**
	     * Updates the password of a user with the specified username.
	     * @param username The username of the user.
	     * @param newPassword The new password to set for the user.
	     * @return true if the password was successfully updated, false if the user was not found.
	     */
	    public boolean updatePassword(String username, String newPassword) {
	        for (User user : users) {
	            if (user.getUsername().equals(username)) {
	                user.setPassword(newPassword);
	                return true;
	            }
	        }
	        return false;
	    }

	}