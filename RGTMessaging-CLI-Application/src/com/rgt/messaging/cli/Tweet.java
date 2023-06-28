package com.rgt.messaging.cli;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Tweet implements Serializable {
	
	

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String tweetId;
	
	private String content;
	
	private String author;
	
	private LocalDateTime timestamp;
	
	private int likeCount;
    private List<String> likedUsers;
    private List<Tweet> retweets;
    private List<Tweet> replies;
    
    private User currentUser;

	
	public String getTweetId() {
		return tweetId;
	}

	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public List<String> getLikedUsers() {
		return likedUsers;
	}

	public void setLikedUsers(List<String> likedUsers) {
		this.likedUsers = likedUsers;
	}

	public List<Tweet> getRetweets() {
		return retweets;
	}

	public void setRetweets(List<Tweet> retweets) {
		this.retweets = retweets;
	}

	public List<Tweet> getReplies() {
		return replies;
	}

	public void setReplies(List<Tweet> replies) {
		this.replies = replies;
	}

	public Tweet(String tweetId, String content, String author, LocalDateTime timestamp) {
		this.tweetId = tweetId;
		this.content = content;
		this.author = author;
		this.timestamp = timestamp;
		this.likeCount = 0;
        this.likedUsers = new ArrayList<>();
        this.retweets = new ArrayList<>();
        this.replies = new ArrayList<>();
        this.currentUser = null;
	}
	
	public void like() {
        
        likeCount++;
        likedUsers.add(currentUser.getUsername());
        System.out.println("Tweet liked successfully.");
    }

    public void retweet() {
        
        Tweet retweet = new Tweet(tweetId, content, currentUser.getUsername(), LocalDateTime.now());
        retweets.add(retweet);
        System.out.println("Tweet retweeted successfully.");
    }


	public void reply(String replyContent) {
        Tweet reply = new Tweet(tweetId, replyContent, currentUser.getUsername(), LocalDateTime.now());
        replies.add(reply);
        System.out.println("Tweet replied successfully.");
    }

	
	
//  private String generateTweetId() {
//	UUID uuid = UUID.randomUUID();
//    return uuid.toString();
//}

	
	
}