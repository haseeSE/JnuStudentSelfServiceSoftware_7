package com.jnu.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jnu.model.User;

import junit.framework.Assert;

public class UserTest {

	private User user;
	
	@Before
	public void setUp() throws Exception {
		user = new User();
	}

	@Test
	public void testGet_name() {
		assertNotNull(user.get_name());
	}

	@Test
	public void testSet_name() {
		String name = "name";
		user.set_name(name);
		assertEquals(name, user.get_name());
	}

	@Test
	public void testGet_studentId() {
		assertNotNull(user.get_studentId());
	}

	@Test
	public void testSet_studentId() {
		String id = "Stundet ID";
		user.set_studentId(id);
		assertEquals(id, user.get_studentId());
	}

	@Test
	public void testGet_phoneNum() {
		assertNotNull(user.get_phoneNum());
	}

	@Test
	public void testSet_phoneNum() {
		String phone = "12345678";
		user.set_phoneNum(phone);
		assertEquals(phone, user.get_phoneNum());
	}

	@Test
	public void testGet_college() {
		assertNotNull(user.get_college());
	}

	@Test
	public void testSet_college() {
		String college = "college";
		user.set_college(college);
		assertEquals(college, user.get_college());
	}

	@Test
	public void testGet_major() {
		assertNotNull(user.get_major());
	}

	@Test
	public void testSet_major() {
		String major = "major";
		user.set_major(major);
		assertEquals(major, user.get_major());
	}

	@Test
	public void testGet_dormitory() {
		assertNotNull(user.get_dormitory());
	}

	@Test
	public void testSet_dormitory() {
		String dorm = "1111";
		user.set_dormitory(dorm);
		assertEquals(dorm, user.get_dormitory());
	}

	@Test
	public void testGet_JnuDCPId() {
		assertNotNull(user.get_JnuDCPId());
	}

	@Test
	public void testSet_JnuDCPId() {
		String id = "dcp id";
		user.set_JnuDCPId(id);
		assertEquals(id, user.get_JnuDCPId());
	}

	@Test
	public void testGet_JnuDCPPassword() {
		assertNotNull(user.get_JnuDCPPassword());
	}

	@Test
	public void testSet_JnuDCPPassword() {
		String pwd = "password";
		user.set_JnuDCPPassword(pwd);
		assertEquals(pwd, user.get_JnuDCPPassword());
	}

	@Test
	public void testGet_JnuForumId() {
		assertNotNull(user.get_JnuForumId());
	}

	@Test
	public void testSet_JnuForumId() {
		String id = "fourm id";
		user.set_JnuForumId(id);
		assertEquals(id, user.get_JnuForumId());
	}

	@Test
	public void testGet_JnuForumPassword() {
		assertNotNull(user.get_JnuForumPassword());
	}

	@Test
	public void testSet_JnuForumPassword() {
		String pwd = "password";
		user.set_JnuForumPassword(pwd);
		assertEquals(pwd, user.get_JnuForumPassword());
	}

	@Test
	public void testGet_JnuEduAdminSystemId() {
		assertNotNull(user.get_JnuEduAdminSystemId());
	}

	@Test
	public void testSet_JnuEduAdiminSystemId() {
		String id = "tms id";
		user.set_JnuEduAdiminSystemId(id);
		assertEquals(id, user.get_JnuEduAdminSystemId());
	}

	@Test
	public void testGet_JnuEduAdminSystemPassword() {
		assertNotNull(user.get_JnuEduAdminSystemPassword());
	}

	@Test
	public void testSet_JnuEduAdminSystemPassword() {
		String pwd = "password";
		user.set_JnuEduAdminSystemPassword(pwd);
		assertEquals(pwd, user.get_JnuEduAdminSystemPassword());
	}

}
