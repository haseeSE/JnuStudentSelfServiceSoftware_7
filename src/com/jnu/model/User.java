package com.jnu.model;

public class User implements java.io.Serializable{
	private String _name = new String();
	private String _studentId = new String();
	private String _phoneNum = new String();
	private String _college = new String();
	private String _major = new String();
	private String _dormitory = new String();
	private String _JnuDCPId = new String();
	private String _JnuDCPPassword = new String();
	private String _JnuForumId = new String();
	private String _JnuForumPassword = new String();
	private String _JnuEduAdminSystemId = new String();
	private String _JnuEduAdminSystemPassword = new String();
	
	public String get_name() {
		return _name;
	}
	public void set_name(String name) {
		_name = name;
	}
	public String get_studentId() {
		return _studentId;
	}
	public void set_studentId(String studentId) {
		_studentId = studentId;
	}
	public String get_phoneNum() {
		return _phoneNum;
	}
	public void set_phoneNum(String phoneNumber) {
		_phoneNum = phoneNumber;
	}
	public String get_college() {
		return _college;
	}
	public void set_college(String college) {
		_college = college;
	}
	public String get_major() {
		return _major;
	}
	public void set_major(String major) {
		_major = major;
	}
	public String get_dormitory() {
		return _dormitory;
	}
	public void set_dormitory(String dormitory) {
		_dormitory = dormitory;
	}
	public String get_JnuDCPId() {
		return _JnuDCPId;
	}
	public void set_JnuDCPId(String JnuDCPId) {
		_JnuDCPId = JnuDCPId;
	}
	public String get_JnuDCPPassword() {
		return _JnuDCPPassword;
	}
	public void set_JnuDCPPassword(String JnuDCPPassword) {
		_JnuDCPPassword = JnuDCPPassword;
	}
	public String get_JnuForumId() {
		return _JnuForumId;
	}
	public  void set_JnuForumId(String JnuForumId) {
		_JnuForumId = JnuForumId;
	}
	public String get_JnuForumPassword() {
		return _JnuForumPassword;
	}
	public void set_JnuForumPassword(String JnuForumPassword) {
		_JnuForumPassword = JnuForumPassword;
	}
	public String get_JnuEduAdminSystemId() {
		return _JnuEduAdminSystemId;
	}
	public void set_JnuEduAdiminSystemId(String JnuEduAdminSystemId) {
		_JnuEduAdminSystemId = JnuEduAdminSystemId;
	}
	public String get_JnuEduAdminSystemPassword() {
		return _JnuEduAdminSystemPassword;
	}
	public void set_JnuEduAdminSystemPassword(String JnuEduAdminSystemPassword) {
		_JnuEduAdminSystemPassword = JnuEduAdminSystemPassword;
	}
}
