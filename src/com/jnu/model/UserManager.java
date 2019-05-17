package com.jnu.model;

public class UserManager {
	private static User _user = new User();
	
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
}
