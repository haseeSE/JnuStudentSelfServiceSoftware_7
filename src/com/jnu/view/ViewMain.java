package com.jnu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.jnu.model.MyFileOperator;
import com.jnu.model.User;
import com.jnu.model.UserManager;
import com.jnu.model.WebTMSystem;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;

/*
 * created by chenqinquan;
 */

public class ViewMain {
	
	private Logger Log = Logger.getLogger(getClass());

	private static WebTMSystem web =new WebTMSystem();
	
	private static JFrame frame;
	// 顶部菜单栏；
	private JMenuBar menuBar_top;
	private static JPanel panel_main;
	
	private int width = 1000;
	private int height = 600;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// TODO read File;
		// TODO 读取UserData中的用户信息到user,再将user中的值保存到userManager
		//这么做的原因是：userManager为全局变量，无法序列化和反序列化；而user不是全局变量，可序列化和反序列化
		UserManager.loadUser();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMain window = new ViewMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewMain() {
		// <----------	LOG: CREATED	------------>
		Log.info("CREATED");
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Image/jnu.jpg"));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				Log.info("关闭程序窗口");
			}
			@Override
			public void windowOpened(WindowEvent e) {
				Log.info("打开程序窗口");
			}
		});
		frame.setTitle("暨南大学珠海校区学生自助程序");
		frame.setResizable(false);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);//在屏幕中居中显示
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar_top = new JMenuBar();
		frame.setJMenuBar(menuBar_top);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		panel_main = new JPanel();
		panel_main.setLayout(new CardLayout(0, 0));
		frame.getContentPane().add(panel_main, "name_18902815292286");
		
		topMenuAddItem();
		
		// TODO
		// 替换panel_main;
		// 主界面改为用户信息界面；
		changePanelMain(new PanelPersonalInfo());

		
	}

	// 为顶部菜单栏添加Item;
	private void topMenuAddItem() {
		JMenu menu_campuInquire = new JMenu("校园查询");
		menuBar_top.add(menu_campuInquire);
		
		JMenuItem menuItem_message = new JMenuItem("通知及余额");
		menuItem_message.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO
				changePanelTemplate(new PanelMessage());
				Log.info("点击了查看通知及余额");
			}
		});
		menu_campuInquire.add(menuItem_message);
		
		JMenuItem menuItem_grade = new JMenuItem("成绩");
		menuItem_grade.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO
				if(!WebTMSystem.getIsLogined()) {
					JOptionPane.showMessageDialog(frame, "尚未成功登录教务系统，请重新登录！", "提示", JOptionPane.WARNING_MESSAGE);
					changePanelMain(new PanelPersonalInfo());
				}
				else
					changePanelTemplate(new PanelGradeRecord());
				Log.info("点击了查询成绩");
			}
		});
		menu_campuInquire.add(menuItem_grade);
		
		JMenuItem menuItem_jobInfo = new JMenuItem("就业信息");
		menuItem_jobInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO
//				JOptionPane.showMessageDialog(frame, "JOB", "Message", JOptionPane.PLAIN_MESSAGE);
				changePanelTemplate(new PanelEmploymentInfoContainer());
				Log.info("点击了查看就业信息");
			}
		});
		menu_campuInquire.add(menuItem_jobInfo);
		
		JMenu menu_study = new JMenu("学习生活");
		menuBar_top.add(menu_study);
		
		JMenuItem menuItem_courseSelection = new JMenuItem("选课");
		menuItem_courseSelection.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO
//				changePanelTemplate(new PanelCourseSelection());
				JOptionPane.showMessageDialog(frame, "选课系统目前关闭，无法使用！", "提示", JOptionPane.WARNING_MESSAGE);
				Log.info("点击了选课");
			}
		});
		menu_study.add(menuItem_courseSelection);
		
		JMenuItem menuItem_trainingProgram = new JMenuItem("培养方案");
		menuItem_trainingProgram.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO
				if(!WebTMSystem.getIsLogined()) {
					JOptionPane.showMessageDialog(frame, "尚未成功登录教务系统，请重新登录！", "提示", JOptionPane.WARNING_MESSAGE);
					changePanelMain(new PanelPersonalInfo());
				}
				else
					changePanelTemplate(new PanelTrainingProgram(web.GetTrainPlan()));
				Log.info("点击了查看培养方案");
			}
		});
		menu_study.add(menuItem_trainingProgram);
		
		JMenuItem menuItem_leave = new JMenuItem("请假");
		menuItem_leave.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO
				String name = UserManager.getUser().get_name();
				String id = UserManager.getUser().get_studentId();
				if(name == null || name.equals("") || id == null || id.equals("")) {
					JOptionPane.showMessageDialog(frame, "姓名或学号为空，请重新登录！", "提示", JOptionPane.WARNING_MESSAGE);
					changePanelMain(new PanelPersonalInfo());
				}
				else
					changePanelTemplate(new PanelLeaveDocEdit());
				Log.info("点击了打开请假功能");
			}
		});
		menu_study.add(menuItem_leave);
		
		JMenu menu_other = new JMenu("其他功能");
		menuBar_top.add(menu_other);
		
		JMenuItem menuItem_download = new JMenuItem("模板下载");
		menuItem_download.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				/*frame.setEnabled(false);
				ViewDownloadDoc windows = new ViewDownloadDoc();
				windows.frame.setVisible(true);
				windows.frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				windows.frame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						frame.setEnabled(true);
					}
				});*/
				openDownloadDoc();
				Log.info("点击了打开模板下载");
			}
			
		});
		menu_other.add(menuItem_download);
		
		JMenuItem menuItem_userInfo = new JMenuItem("个人信息");
		menuItem_userInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				openPersonal();
			}
		});
		menu_other.add(menuItem_userInfo);
		
	}
	
	// 切换模板；
	public static void changePanelTemplate(JPanel panel) {
		changePanelMain(new PanelTemplate(panel));
	}
	
	// 切换整个面板；
	private static void changePanelMain(JPanel panel) {
		panel_main.removeAll();
		panel_main.add(panel);
		panel_main.updateUI();
	}
	
	// 切换到下载页面；
	private static void changeFrame(ViewDownloadDoc windows) {
		frame.setEnabled(false);
		windows.frame.setVisible(true);
		windows.frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		windows.frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.setEnabled(true);
			}
		});
	}
	
	public static JFrame getFrame() {
		return frame;
	}
	
	// 打开通知主界面；
	public static void openMainMessage() {
		changePanelTemplate(new PanelMessage());
	}
	
	// 打开个人信息界面；
	public static void openPersonal() {
		changePanelMain(new PanelPersonalInfo());
	}
	
	public static void openWebBrowser(String title, String url) {
		if(url == null && url.equals("")) {
			Logger log = Logger.getLogger(ViewMain.class);
			log.error("打开空网址");
			JOptionPane.showMessageDialog(frame,"正打开一个空网址", "警告", JOptionPane.ERROR_MESSAGE);
			return;
		}
		ViewWebBrowser webBrowser = new ViewWebBrowser(frame, title);
		webBrowser.loadUrl(url);
		webBrowser.getFrame().setVisible(true);
		webBrowser.getFrame().setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	// 打开网页；
	public static void openWeb(String url) {		
		openWebBrowser("内嵌浏览器", url);
	}
	
			
	// 打开下载页面；
	public static void openDownloadDoc() {
		
		changeFrame(new ViewDownloadDoc());
		
	}
		
	public static void openWebDigitalJnu() {
		// TODO Auto-generated method stub	
		openWebBrowser("数字暨大", ViewWebBrowser.URL_DIGITAL_JNU);
	}
	
	public static void openWebFourm() {
		openWebBrowser("暨大论坛", ViewWebBrowser.URL_FOURM);
	}
	
	public static void openWebElectrity() {
		openWebBrowser("电费学生查询平台", ViewWebBrowser.URL_ELECTRICITY);
	}
}
