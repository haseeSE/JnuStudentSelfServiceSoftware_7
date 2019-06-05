package com.jnu.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jnu.model.MyFileOperator;
import com.jnu.model.User;

public class MyFileOperatorTest {

	private User user;
	private User backup;
	
	@Before
	public void setUp() throws Exception {
		// 保存备份；
		backup = MyFileOperator.load();
		
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
	}

	@Test
	public void testLoad() {
		assertTrue(MyFileOperator.save(user));
		User tmp = MyFileOperator.load();
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
	public void testSave() {
		assertTrue(MyFileOperator.save(user));		
	}

	@After
	public void TearDown() {
		// 恢复备份；
		MyFileOperator.save(backup);
	}
}
