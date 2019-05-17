package com.jnu.model;

import java.util.ArrayList;

public class UserManager {

	private static User _user = new User();
	private static ArrayList<Score> scores;
	
	public static User getUser() {
		return _user;
	}
	
	public static void setUser(User user) {
		_user = user;
	}
	
	public static void loadUser() {
		MyFileOperator operator = new MyFileOperator();
		setUser(operator.load());
	}
	
	public static void saveUser() {
		MyFileOperator operator = new MyFileOperator();
		operator.save(_user);
	}

	public static ArrayList<Score> getScores() {
		return scores;
	}

	public static void setScores(ArrayList<Score> scores) {
		UserManager.scores = scores;
	}
	
}
