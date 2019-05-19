package com.jnu.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.jnu.model.Score;
import com.jnu.model.User;
import com.jnu.model.UserManager;

public class UserManagerTest {
	private User user;
	private ArrayList<Score> scores;	
	
	@Before
	public void setUp() throws Exception {
		user = new User();
		user.set_name("name");
		user.set_college("college");
		user.set_dormitory("dormitory");
		user.set_JnuDCPId("JnuDCPId");
		user.set_JnuDCPPassword("JnuDCPPassword");
		user.set_JnuEduAdiminSystemId("JnuEduAdminSystemId");
		user.set_JnuEduAdminSystemPassword("JnuEduAdminSystemPassword");
		user.set_JnuForumId("JnuForumId");
		user.set_JnuForumPassword("JnuForumPassword");
		user.set_major("major");
		user.set_phoneNum("phoneNumber");
		user.set_studentId("studentId");
		
		scores = new ArrayList<>();
		Score s1 = new Score();
		s1.setCourse("s1 course");
		scores.add(s1);
		Score s2 = new Score();
		s2.setCourse("s2 course");
		scores.add(s2);
	}

	@Test
	public void testGetUser() {
		assertNotNull(UserManager.getUser());
	}

	@Test
	public void testSetUser() {
		UserManager.setUser(user);
		User tmp = UserManager.getUser();
		assertEquals(tmp.get_college(),		user.get_college());
		assertEquals(tmp.get_dormitory(),	user.get_dormitory());
		assertEquals(tmp.get_JnuDCPId(),		user.get_JnuDCPId());
		assertEquals(tmp.get_JnuDCPPassword(),	user.get_JnuDCPPassword());
		assertEquals(tmp.get_JnuEduAdminSystemId(),			user.get_JnuEduAdminSystemId());
		assertEquals(tmp.get_JnuEduAdminSystemPassword(), 	user.get_JnuEduAdminSystemPassword());
		assertEquals(tmp.get_JnuForumId(), 		user.get_JnuForumId());
		assertEquals(tmp.get_JnuForumPassword(),user.get_JnuForumPassword());
		assertEquals(tmp.get_major(),	user.get_major());
		assertEquals(tmp.get_name(),	user.get_name());
		assertEquals(tmp.get_phoneNum(),	user.get_phoneNum());
		assertEquals(tmp.get_studentId(),	user.get_studentId());
	}

	@Test
	public void testLoadUser() {
		UserManager.setUser(user);
		assertTrue(UserManager.saveUser());
		assertTrue(UserManager.loadUser());
		User tmp = UserManager.getUser();
		assertEquals(tmp.get_college(),		user.get_college());
		assertEquals(tmp.get_dormitory(),	user.get_dormitory());
		assertEquals(tmp.get_JnuDCPId(),		user.get_JnuDCPId());
		assertEquals(tmp.get_JnuDCPPassword(),	user.get_JnuDCPPassword());
		assertEquals(tmp.get_JnuEduAdminSystemId(),			user.get_JnuEduAdminSystemId());
		assertEquals(tmp.get_JnuEduAdminSystemPassword(), 	user.get_JnuEduAdminSystemPassword());
		assertEquals(tmp.get_JnuForumId(), 		user.get_JnuForumId());
		assertEquals(tmp.get_JnuForumPassword(),user.get_JnuForumPassword());
		assertEquals(tmp.get_major(),	user.get_major());
		assertEquals(tmp.get_name(),	user.get_name());
		assertEquals(tmp.get_phoneNum(),	user.get_phoneNum());
		assertEquals(tmp.get_studentId(),	user.get_studentId());
	}

	@Test
	public void testSaveUser() {
		assertTrue(UserManager.saveUser());
	}

	@Test
	public void testGetScores() {
		assertNotNull(UserManager.getScores());
	}

	@Test
	public void testSetScores() {
		UserManager.setScores(scores);
		ArrayList<Score> tmp = UserManager.getScores();
		assertEquals(tmp.size(), scores.size());
		assertEquals(tmp.get(0).getCourse(), scores.get(0).getCourse());
	}

}
