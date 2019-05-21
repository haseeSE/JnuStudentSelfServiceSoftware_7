package com.jnu.view;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JPanel;

import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;

import com.jnu.model.WebDigitalJnu;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserNavigationParameters;

/*
 * created by chenqinquan;
 */

public class PanelWebBrowser extends JPanel {
	
	private Logger Log = Logger.getLogger(getClass());

	private final static String URL_ELECTRICITY = "http://202.116.25.12";
	private final static String URL_DIGITAL_JNU = "https://icas.jnu.edu.cn/cas/login?service=http%3A%2F%2Fi.jnu.edu.cn%2Fdcp%2Findex.jsp";
	private final static String URL_FOURM = "http://www.ijnu.cn/";
	
	private JWebBrowser webBrowser = null;
	
	/**
	 * Create the panel.
	 */
	public PanelWebBrowser() {
		super(new BorderLayout());
		
		// <----------	LOG: CREATED	------------>
		Log.info("CREATED");
		
        JPanel webBrowserPanel = new JPanel(new BorderLayout());
        webBrowser = new JWebBrowser();
        webBrowser.setButtonBarVisible(false);
        webBrowser.setMenuBarVisible(false);
        webBrowser.setBarsVisible(false);
        webBrowser.setStatusBarVisible(false);
        webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
        add(webBrowserPanel, BorderLayout.CENTER);
        //执行Js代码
        //webBrowser.executeJavascript("alert('hello swing')");
	}

	public void openFourm() {
		loadUrl(URL_FOURM, null);
	}
	
	public void openElecticity() {
		loadUrl(URL_ELECTRICITY, null);
	}
	
	public void openDigitalJnu() {
		loadUrl(WebDigitalJnu.HOME_URL, WebDigitalJnu.getCookies());
	}
	
	public void loadUrl(String url, Set<Cookie> cookies) {
		// 设置cookies；

		Log.info(" 打开网址: " + url);
		
		if(cookies != null) {
			String cookie = cookies.toString();
		
			Log.info("Cookie: " + cookie);
		
			webBrowser.setCookie(url, cookie);
		}	
		
		webBrowser.navigate(url);
           
	}
}
