package com.jnu.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

/*
 * created by chenqinquan;
 */

public class PanelWebBrowser extends JPanel {

	private final static String URL_ELECTRICITY = "http://202.116.25.12";
	private final static String URL_DIGITAL_JNU = "https://icas.jnu.edu.cn/cas/login?service=http%3A%2F%2Fi.jnu.edu.cn%2Fdcp%2Findex.jsp";
	private final static String URL_FOURM = "http://www.ijnu.cn/";
	
	private static JWebBrowser webBrowser = null;
	
	/**
	 * Create the panel.
	 */
	public PanelWebBrowser() {
		super(new BorderLayout());
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
		loadUrl(URL_FOURM);
	}
	
	public void openElecticity() {
		loadUrl(URL_ELECTRICITY);
	}
	
	public void openDigitalJnu() {
		loadUrl(URL_DIGITAL_JNU);
	}
	
	public void loadUrl(String url) {
        webBrowser.navigate(url);
	}
}
