package com.jnu.model;

public class UserManager {
	private static String _name;
	private static String _studentId;
	private static String _phoneNum;
	private static String _college;
	private static String _major;
	private static String _dormitory;
	private static String _JnuDCPId;
	private static String _JnuDCPPassword;
	private static String _JnuForumId;
	private static String _JnuForumPassword;
	private static String _JnuEduAdminSystemId;
	private static String _JnuEduAdminSystemPassword;
	
	public UserManager() {
		
	}
	public UserManager(User user){
		_name = user.get_name();
		_studentId = user.get_studentId();
		_phoneNum = user.get_phoneNum();
		_college = user.get_college();
		_major = user.get_major();
		_dormitory = user.get_dormitory();
		_JnuDCPId = user.get_JnuDCPId();
		_JnuDCPPassword = user.get_JnuDCPPassword();
		_JnuForumId = user.get_JnuForumId();
		_JnuForumPassword = user.get_JnuForumPassword();
		_JnuEduAdminSystemId = user.get_JnuEduAdminSystemId();
		_JnuEduAdminSystemPassword = user.get_JnuEduAdminSystemPassword();
	}
	
	public static String get_name() {
		return _name;
	}
	public static void set_name(String name) {
		_name = name;
	}
	public static String get_studentId() {
		return _studentId;
	}
	public static void set_studentId(String studentId) {
		_studentId = studentId;
	}
	public static String get_phoneNum() {
		return _phoneNum;
	}
	public static void set_phoneNum(String phoneNumber) {
		_phoneNum = phoneNumber;
	}
	public static String get_college() {
		return _college;
	}
	public static void set_college(String college) {
		_college = college;
	}
	public static String get_major() {
		return _major;
	}
	public static void set_major(String major) {
		_major = major;
	}
	public static String get_dormitory() {
		return _dormitory;
	}
	public static void set_dormitory(String dormitory) {
		_dormitory = dormitory;
	}
	public static String get_JnuDCPId() {
		return _JnuDCPId;
	}
	public static void set_JnuDCPId(String JnuDCPId) {
		_JnuDCPId = JnuDCPId;
	}
	public static String get_JnuDCPPassword() {
		return _JnuDCPPassword;
	}
	public static void set_JnuDCPPassword(String JnuDCPPassword) {
		_JnuDCPPassword = JnuDCPPassword;
	}
	public static String get_JnuForumId() {
		return _JnuForumId;
	}
	public static void set_JnuForumId(String JnuForumId) {
		_JnuForumId = JnuForumId;
	}
	public static String get_JnuForumPassword() {
		return _JnuForumPassword;
	}
	public static void set_JnuForumPassword(String JnuForumPassword) {
		_JnuForumPassword = JnuForumPassword;
	}
	public static String get_JnuEduAdminSystemId() {
		return _JnuEduAdminSystemId;
	}
	public static void set_JnuEduAdiminSystemId(String JnuEduAdminSystemId) {
		_JnuEduAdminSystemId = JnuEduAdminSystemId;
	}
	public static String get_JnuEduAdminSystemPassword() {
		return _JnuEduAdminSystemPassword;
	}
	public static void set_JnuEduAdminSystemPassword(String JnuEduAdminSystemPassword) {
		_JnuEduAdminSystemPassword = JnuEduAdminSystemPassword;
	}

}
