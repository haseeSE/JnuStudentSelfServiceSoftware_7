package com.jnu.model;

import org.apache.log4j.Logger;

public class MyLog {

	public static void write(Class myClass, String log) {
		Logger logger = Logger.getLogger(myClass);
		logger.info(log);
	}
}
