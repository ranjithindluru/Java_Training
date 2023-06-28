package com.rgt.messaging.cli;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class RGTMessaging {

	

	private Map<String, User> users;

	private List<Tweet> tweets;

	private User currentUser;
	

	public Map<String, User> getUsers() {
		return users;
	}

	public void setUsers(HashMap<String, User> users) {
		this.users = users;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public void setUsers(Map<String, User> users) {
		this.users = users;
	}

	public RGTMessaging() {
		this.users = new HashMap<String, User>();
		this.tweets = new ArrayList<Tweet>();
		this.currentUser = null;
        this.loadData(); 
		
	}

	public void registerUser(Scanner scanner) {
		System.out.println("Enter a username: ");
		String username = scanner.next();
		if (users.containsKey(username)) {
			System.out.println("username already exists.. ");
			return;
		}
		System.out.println("Enter a password: ");
		String password = scanner.next();

		System.out.println("Enter a name: ");
		String name = scanner.next();

		System.out.println("Enter a bio: ");
		String bio = scanner.next();

		User newUser = new User(username, password, name, bio);
		users.put(username, newUser);

		System.out.println("User Registered Successfully.. ");
	}

	public void login(Scanner scanner) {

		System.out.println("Enter a username: ");
		String username = scanner.next();

		System.out.println("Enter a password: ");
		String password = scanner.next();

		User user = users.get(username);
		if (user != null && user.getPassword().equals(password)) {
			currentUser = user;
			System.out.println("Welcome to RGTMessaging App " + currentUser.getName() + "!");
			boolean logout = false;
			while (!logout) {
				System.out.println("");
				System.out.println("1. Post a tweet ");
				System.out.println("2. View your  timeline");
				System.out.println("3. Search for users");
				System.out.println("4. Search for tweets");
				System.out.println("5. View your profile");
				System.out.println("6. Load Data");
				System.out.println("7. Save Data");
				System.out.println("8. Logout");
				System.out.println("");
				System.out.print("Enter your choice: ");
				System.out.println("");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					postTweet(scanner);
					break;
				case 2:
					getTimeline(scanner);
					break;
				case 3:
					searchUser(scanner);
					break;
				case 4:
					searchTweet(scanner);
					break;
				case 5:
					getProfile(scanner);
					break;
				case 6:
					loadData();
					break;
				case 7:
					saveData();
					break;
				case 8:
					logout = true;
					System.out.println("Logging out user: " + currentUser.getUsername());
					currentUser = null;
					System.out.println("Logged out successfully.");
					break;

				default:
					System.out.println("Invalid option. Please try again.");
					break;
				}
			}
		} else {
			System.out.println("Entered Username or passord Invalid. Please try again.");
		}
	}

	public void logout() {

		System.out.println("Logging out user: " + currentUser.getUsername());
		currentUser = null;
		System.out.println("Logged out successfully.");
	}

	public void searchUser(Scanner scanner) {
		System.out.println("Enter the username to search for:");
		String username = scanner.next();

		if (users.containsKey(username)) {
			User user = users.get(username);
			System.out.println("User found:");
			System.out.println("Username: " + user.getUsername());
			System.out.println("Name: " + user.getName());
			System.out.println("Bio: " + user.getBio());
		} else {
			System.out.println("User not found.");
		}
	}

	public void searchTweet(Scanner scanner) {
		System.out.println("Enter the tweet ID to search for:");
		String tweetId = scanner.next();

		for (Tweet tweet : tweets) {
			if (tweet.getTweetId().equals(tweetId)) {
				System.out.println("Tweet found:");
				System.out.println("ID: " + tweet.getTweetId());
				System.out.println("Content: " + tweet.getContent());
				System.out.println("Author: " + tweet.getAuthor());
				System.out.println("Timestamp: " + tweet.getTimestamp());
				return;
			}
		}

		System.out.println("Tweet not found.");
	}

	public void getTimeline(Scanner scanner) {

		System.out.println("Timeline for user: " + currentUser.getUsername());
		for (Tweet tweet : tweets) {
			if (currentUser.getTweets().contains(tweet.getTweetId())) {
				System.out.println("ID: " + tweet.getTweetId());
				System.out.println("Content: " + tweet.getContent());
				System.out.println("Author: " + tweet.getAuthor());
				System.out.println("Timestamp: " + tweet.getTimestamp());
				System.out.println("Likes: " + tweet.getLikedUsers().size());
				System.out.println("Replies: " + tweet.getReplies().toString());
				System.out.println("Retweets: " + tweet.getRetweets().toString());
				System.out.println();
			}
			boolean back = false;
			while (!back) {
				System.out.println("");
				System.out.println("1. Like a tweet");
				System.out.println("2. Retweet");
				System.out.println("3. Reply to tweet");
				System.out.println("4. Back to menu");
				System.out.println("");
				System.out.print("Enter your choice: ");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter the tweetId of the tweet you want to like: ");
					String tweetId = scanner.next();
					for (Tweet tweet2 : tweets) {
						if (tweet2 != null && tweet2.getTweetId().equals(tweetId)) {
							tweet2.setCurrentUser(currentUser);
							tweet2.like();
						}
					}
					break;
				case 2:
					System.out.println("Enter the tweetId of the tweet you want to retweet: ");
					String retweetId = scanner.next();
					for (Tweet tweet2 : tweets) {
						if (tweet2 != null && tweet2.getTweetId().equals(retweetId)) {
							tweet2.setCurrentUser(currentUser);
							tweet2.retweet();
						}
					}
					break;
				case 3:
					System.out.println("Enter the tweetId of the tweet you want to reply to: ");
					String replyTweetId = scanner.next();
					// scanner.next();
					System.out.println("Enter your reply: ");
					String replyContent = scanner.next();
					for (Tweet tweet2 : tweets) {
						if (tweet2 != null && tweet2.getTweetId().equals(replyTweetId)) {
							tweet2.setCurrentUser(currentUser);
							tweet2.reply(replyContent);
						}
					}
					break;
				case 4:
					back = true;
					System.out.println("Returning to the menu.");
					break;
				default:
					System.out.println("Invalid option. Please try again.");
					break;
				}
			}
		}
	}

	public void getProfile(Scanner scanner) {

		System.out.println("Profile for user: " + currentUser.getUsername());
		System.out.println("Name: " + currentUser.getName());
		System.out.println("Bio: " + currentUser.getBio());
		System.out.println("Followers: " + currentUser.getFollowers().size());
		System.out.println("Following: " + currentUser.getFollowings().size());
		System.out.println("Tweets: " + currentUser.getTweets().toString());

		boolean back = false;
		while (!back) {
			System.out.println("");
			System.out.println("1. follow  ");
			System.out.println("2. unfollow");
			System.out.println("3. back");
			System.out.println("");
			System.out.print("Enter your choice: ");
			System.out.println("");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter your username: ");
				String username = scanner.next();

				User user = users.get(username);

				if (user != null) {
					currentUser.follow(user);
				}

				break;
			case 2:
				System.out.println("Enter your username: ");
				String username2 = scanner.next();

				User user1 = users.get(username2);
				if (user1 != null) {
					currentUser.unfollow(user1);
				}
				break;
			case 3:
				back = true;
				System.out.println("back the profile.");
				break;

			default:
				System.out.println("Invalid option. Please try again.");
				break;
			}
		}

	}

	public void postTweet(Scanner scanner) {

		System.out.println("Enter your tweetId: ");
		String tweetId = scanner.next();

		System.out.println("Enter your tweet content: ");
		String content = scanner.next();

		Tweet tweet = new Tweet(tweetId, content, currentUser.getUsername(), LocalDateTime.now());
		tweets.add(tweet);
		currentUser.postTweet(tweetId);

	}
	

//    private void saveData() {
//        dataStore.saveData(users, tweets);
//    }
//
//    private void loadData() {
//        Map<String, User> loadedUsers = dataStore.loadUsers();
//        List<Tweet> loadedTweets = dataStore.loadTweets();
//
//        if (loadedUsers != null && loadedTweets != null) {
//            users = loadedUsers;
//            tweets = loadedTweets;
//        }
//    }
	
	public void loadData() {
	    users = DataStore.loadUsers();
	    tweets = DataStore.loadTweets();
	}
	
	public void saveData() {
	    DataStore.saveUsers(users);
	    DataStore.saveTweets(tweets);
	    System.out.println("Data saved successfully.");
	}

}
