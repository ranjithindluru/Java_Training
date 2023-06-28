package com.rgt.messaging.cli;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class DataStore {
	
	private static final String USERS_FILE = "users.txt";
	private static final String TWEETS_FILE = "tweets.txt";

	
	public static void saveData(Map<String, User> users, List<Tweet> tweets) {
	    saveUsers(users);
	    saveTweets(tweets);
	}

	public static Map<String, User> loadDataUsers() {
	    return loadUsers();
	}

	public static List<Tweet> loadDataTweets() {
	    return loadTweets();
	}

	static void saveUsers(Map<String, User> users) {
	    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
	        oos.writeObject(users);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	static Map<String, User> loadUsers() {
	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERS_FILE))) {
	        return (Map<String, User>) ois.readObject();
	    } catch (IOException | ClassNotFoundException e) {
	        return new HashMap<>();
	    }
	}

	static void saveTweets(List<Tweet> tweets) {
	    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TWEETS_FILE))) {
	        oos.writeObject(tweets);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	static List<Tweet> loadTweets() {
	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TWEETS_FILE))) {
	        return (List<Tweet>) ois.readObject();
	    } catch (IOException | ClassNotFoundException e) {
	        return new ArrayList<>();
	    }
	}
	public static String generateTweetId() {
	    String uniqueId = UUID.randomUUID().toString(); 
	    LocalDateTime currentTime = LocalDateTime.now(); 

	    String tweetId = uniqueId + "_" + currentTime.toString();

	    return tweetId;
	}
}
