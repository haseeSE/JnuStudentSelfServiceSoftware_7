package com.jnu.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import org.apache.log4j.Logger;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class ViewWebBrowser {

	Logger Log = Logger.getLogger(getClass());
	
	private JFrame frame;
	
	private int width = 900;
	private int height = 500;
	
	public final static String URL_ELECTRICITY = "http://202.116.25.12";
	public final static String URL_DIGITAL_JNU = "https://icas.jnu.edu.cn/cas/login?service=http%3A%2F%2Fi.jnu.edu.cn%2Fdcp%2Findex.jsp";
	public final static String URL_FOURM = "http://www.ijnu.cn/";

	private JPanel panel_main;
	private JWebBrowser webBrowser = null;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewWebBrowser window = new ViewWebBrowser(null, "");
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public ViewWebBrowser(Component parent, String title) {
		Log.info("Create WebBrowser");
		initialize(parent, title);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Component parent, String title) {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Image/jnu.jpg"));
		frame.setTitle(title);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(parent);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));					
	}
	
	public void loadUrl(String url) {	
		Thread thread = new Thread() {
			@Override
			public void run() {
				UIUtils.setPreferredLookAndFeel();
				NativeInterface.open();
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						Log.info("打开网址： " + url);
						panel_main = new JPanel(new BorderLayout());
						webBrowser = new JWebBrowser();
						webBrowser.navigate(url);
				        webBrowser.setButtonBarVisible(false);
				        webBrowser.setMenuBarVisible(false);
				        webBrowser.setBarsVisible(false);
				        webBrowser.setStatusBarVisible(false);
				        panel_main.add(webBrowser, BorderLayout.CENTER);
				        frame.getContentPane().add(panel_main, "name_18902815292286");						
					}
				});
				NativeInterface.runEventPump();
			}
		};
		try {
			thread.run();
			thread.wait();
		}catch(Exception e) {
			e.printStackTrace();
		}
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
	
	public JFrame getFrame() {
		return frame;
	}
}
