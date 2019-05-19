package com.jnu.test;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.jnu.model.WebElectrity;

import junit.framework.Assert;

public class WebElectrityTest {
	
	private Logger Log;
	private WebElectrity web;

	@Before
	public void setUp() throws Exception {
		Log = Logger.getLogger(getClass());
		web = new WebElectrity();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetBalance() {
		String result = web.getBalance("3313");
		Log.info("GetBalance Result:" + result);
		assertNotNull(result);
	}
	
	@Test
	public void testNetWork() {
		String result = web.getBalance("3313");
		Log.info("联网检测：" + (result != ""));
		assertTrue(result != "");
	}

}
