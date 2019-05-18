package com.jnu.model;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

/*
 * create by chenqinquan;
 * 用于登陆数字暨大，获取饭卡余额；
 */
public class WebDigitalJnu {
	
	private Logger Log = Logger.getLogger(getClass());

	// 数字暨大登陆链接、主页链接；
	public final static String LOGIN_URL = "https://icas.jnu.edu.cn/cas/login?service=http%3A%2F%2Fi.jnu.edu.cn%2Fdcp%2Findex.jsp";
	public final static String HOME_URL = "https://i.jnu.edu.cn/dcp/forward.action?path=/portal/portal&p=home";
	
	private static Set<Cookie> cookies;
	
	// 模拟浏览器；
	private WebDriver driver;
	
	public WebDigitalJnu() {
		// <----------	LOG: CREATED	------------>
		Log.info("CREATED");
		
		System.setProperty("phantomjs.binary.path", "Software/phantomjs.exe");
		
		driver = new PhantomJSDriver();
		// 设置js异步加载等待时间：10s；
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		// 访问登陆页面；
		driver.get(LOGIN_URL);	
		
		Log.info("模拟浏览器创建成功");
	}
	
	
	public Boolean login(String username, String password) {
		
		Log.info("模拟登陆开始");
		
		// 获取输入框和登陆按钮；
		WebElement userInput = driver.findElement(By.id("un")); 		
		WebElement pwdInput = driver.findElement(By.id("pd"));
		WebElement btn = driver.findElement(By.id("index_login_btn"));
		
		Log.info("模拟输入：" + username + " 密码长度： " + password.length());
		// 输入用户名和密码 并登陆；
		userInput.sendKeys(username);
		pwdInput.sendKeys(password);
		
		btn.click();
		
		String resUrl = driver.getCurrentUrl();
		
		Log.info("登录网址：" + resUrl);
		
		// 更新cookies；
		cookies = driver.manage().getCookies();
		Log.info("Cookies: " + cookies);
		
		// 验证是否成功登入；
		return HOME_URL.equals(resUrl);
	}
	
	
	public String getBalance(String username, String password) {
		if (!login(username, password))
			return "";
		Log.info("模拟登陆成功");
		
		// 获取饭卡余额；
		WebElement sso_balance = driver.findElement(By.className("green_font"));
		
		Log.info("卡费：" + sso_balance.getText());
		
		return sso_balance.getText();
	}
	
	public static Set<Cookie> getCookies() {
		return cookies;
	}
}
