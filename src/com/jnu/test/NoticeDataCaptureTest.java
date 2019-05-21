package com.jnu.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.jnu.model.NoticeContainer;
import com.jnu.model.NoticeDataCapture;

import junit.framework.Assert;

public class NoticeDataCaptureTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testAddSchoolNotices() throws Exception {
		ArrayList<NoticeContainer> testList = new ArrayList<NoticeContainer>();
		testList = NoticeDataCapture.addSchoolNotices();
		Assert.assertNotSame(0, testList.size());
	}

	@Test
	public void testAddCollegeNotices1() throws Exception {
		//人文
		ArrayList<NoticeContainer> testList = new ArrayList<NoticeContainer>();
		testList = NoticeDataCapture.addCollegeNotices(1);
		Assert.assertNotSame(0, testList.size());
		Assert.assertNotSame("没有可爬取的通知", testList.get(0).getTitle());
	}
	
	@Test
	public void testAddCollegeNotices2() throws Exception {
		//翻译
		ArrayList<NoticeContainer> testList = new ArrayList<NoticeContainer>();
		testList = NoticeDataCapture.addCollegeNotices(2);
		Assert.assertNotSame(0, testList.size());
		Assert.assertNotSame("没有可爬取的通知", testList.get(0).getTitle());
	}
	
	@Test
	public void testAddCollegeNotices3() throws Exception {
		//包装
		ArrayList<NoticeContainer> testList = new ArrayList<NoticeContainer>();
		testList = NoticeDataCapture.addCollegeNotices(3);
		Assert.assertNotSame(0, testList.size());
		Assert.assertNotSame("没有可爬取的通知", testList.get(0).getTitle());
	}
	
	@Test
	public void testAddCollegeNotices4() throws Exception {
		//其他学院
		ArrayList<NoticeContainer> testList = new ArrayList<NoticeContainer>();
		testList = NoticeDataCapture.addCollegeNotices(55);
		Assert.assertNotSame(0, testList.size());
		Assert.assertEquals("没有可爬取的通知", testList.get(0).getTitle());
	}

	@Test
	public void testAddAcademicAdminstrationNotices() throws Exception {
		ArrayList<NoticeContainer> testList = new ArrayList<NoticeContainer>();
		testList = NoticeDataCapture.addAcademicAdminstrationNotices();
		Assert.assertNotSame(0, testList.size());
	}

}
