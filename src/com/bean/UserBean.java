/**
 * 
 * @author Amit Bharat :it contains pojo  classes
 * 
 */
package com.bean;

import java.util.List;

public class UserBean {
	// required properties for bean
	// reusable component , part of model
	private static String user_id;
	private String password;
	private String fullName;
	private String email;
	private String joined;
	private String tweet;
	private String tweet1;
	private Integer TweetNo;
	private Integer FollowingNo;
	private Integer FollowerNo;
	private String search_id;
	private Integer Search_TweetNo;
	private Integer Search_FollowingNo;
	private Integer Search_FollowerNo;
	private Integer deleteCheck;
	private Integer deleteTweetCheck;
	private Integer editTweetCheck;
	private Integer followingInfoCheck;
	private String answer;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getFollowingInfoCheck() {
		return followingInfoCheck;
	}

	public void setFollowingInfoCheck(int followingInfoCheck) {
		this.followingInfoCheck = followingInfoCheck;
	}

	public int getEditTweetCheck() {
		return editTweetCheck;
	}

	public void setEditTweetCheck(int editTweetCheck) {
		this.editTweetCheck = editTweetCheck;
	}

	public int getDeleteTweetCheck() {
		return deleteTweetCheck;
	}

	public void setDeleteTweetCheck(int deleteTweetCheck) {
		this.deleteTweetCheck = deleteTweetCheck;
	}

	public int getDeleteCheck() {
		return deleteCheck;
	}

	public void setDeleteCheck(int deleteCheck) {
		this.deleteCheck = deleteCheck;
	}

	@SuppressWarnings("rawtypes")
	private List modifiedUserDetail;

	@SuppressWarnings("rawtypes")
	public List getModifiedUserDetail() {
		return modifiedUserDetail;
	}

	public void setModifiedUserDetail(@SuppressWarnings("rawtypes") List modifiedUserDetail) {
		this.modifiedUserDetail = modifiedUserDetail;
	}

	public String getSearch_id() {
		return search_id;
	}

	public void setSearch_id(String search_id) {
		this.search_id = search_id;
	}

	public int getSearch_TweetNo() {
		return Search_TweetNo;
	}

	public void setSearch_TweetNo(int search_TweetNo) {
		Search_TweetNo = search_TweetNo;
	}

	public int getSearch_FollowingNo() {
		return Search_FollowingNo;
	}

	public void setSearch_FollowingNo(int search_FollowingNo) {
		Search_FollowingNo = search_FollowingNo;
	}

	public int getSearch_FollowerNo() {
		return Search_FollowerNo;
	}

	public void setSearch_FollowerNo(int search_FollowerNo) {
		Search_FollowerNo = search_FollowerNo;
	}

	public int getTweetNo() {
		return TweetNo;
	}

	public void setTweetNo(int tweetNo) {
		TweetNo = tweetNo;
	}

	public int getFollowingNo() {
		return FollowingNo;
	}

	public void setFollowingNo(int followingNo) {
		FollowingNo = followingNo;
	}

	public int getFollowerNo() {
		return FollowerNo;
	}

	public void setFollowerNo(int followerNo) {
		FollowerNo = followerNo;
	}

	public String getTweet1() {
		return tweet1;
	}

	public void setTweet1(String tweet1) {
		this.tweet1 = tweet1;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public int active;

	public String getUser_id() {
		return user_id;
	}

	@SuppressWarnings("static-access")
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJoined() {
		return joined;
	}

	public void setJoined(String joined) {
		this.joined = joined;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

}
