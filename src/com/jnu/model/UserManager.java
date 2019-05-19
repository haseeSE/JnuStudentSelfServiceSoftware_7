package com.jnu.model;

import java.util.ArrayList;

public class UserManager {

	private static User _user = new User();
	private static ArrayList<Score> scores = new ArrayList<>();
	
	public static User getUser() {
		return _user;
	}
	
	public static void setUser(User user) {
		_user = user;
	}
	
	public static boolean loadUser() {
		MyFileOperator operator = new MyFileOperator();
		setUser(operator.load());
		if(_user != null)
			return true;
		_user = new User();
		return false;
	}
	
	public static boolean saveUser() {
		MyFileOperator operator = new MyFileOperator();
		return operator.save(_user);
	}

	public static ArrayList<Score> getScores() {
		return scores;
	}

	public static void setScores(ArrayList<Score> scores) {
		UserManager.scores = scores;
	}
	
}
