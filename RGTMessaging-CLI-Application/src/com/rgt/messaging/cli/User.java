package com.rgt.messaging.cli;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {

	

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	private String name;

	private String bio;

	private Set<String> followings;

	private Set<String> followers;

	private Set<String> tweets;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Set<String> getFollowings() {
		return followings;
	}

	public void setFollowings(Set<String> followings) {
		this.followings = followings;
	}

	public Set<String> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<String> followers) {
		this.followers = followers;
	}

	public Set<String> getTweets() {
		return tweets;
	}

	public void setTweets(Set<String> tweets) {
		this.tweets = tweets;
	}

	public User(String username, String password, String name, String bio) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.bio = bio;
		this.followings = new HashSet<>();
		this.followers = new HashSet<>();
		this.tweets = new HashSet<>();
	}

	public void follow(User user) {
		
		followings.add(user.getUsername());
		user.followers.add(username);
		System.out.println("You have successfully followed @" + user.getUsername());
	}

	public void unfollow(User user) {
		followings.remove(user.getUsername());
		user.followers.remove(username);
		System.out.println("You have successfully unfollowed @" + user.getUsername());
	}

	public void postTweet(String tweetId) {
		tweets.add(tweetId);
		System.out.println("Tweet posted successfully.");
	}

	public void deleteTweet(String tweetId) {
		tweets.remove(tweetId);
		System.out.println("Tweet deleted successfully.");
	}
	
}
