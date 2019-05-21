package com.jnu.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class WebElectrity {
	private Logger Log = Logger.getLogger(getClass());
	
	public String getBalance(String dorm) {
		Log.info("开始调用getele。exe获取电费");
		
		try {
			Process getele = Runtime.getRuntime().exec("Software/getele.exe" + " " + dorm);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(getele.getInputStream(), "UTF-8"));  
		    String line = null;  
		    StringBuilder build = new StringBuilder();  
		    while ((line = br.readLine()) != null)  
		        build.append(line);
		    Log.info("电费爬取结果： " + build.toString());
		    
		    return build.toString();
			
		} catch(Exception e) {
			e.printStackTrace();
			Log.error("getele.exe爬取电费出错");
			return null;
		}
	}
	
	
}
