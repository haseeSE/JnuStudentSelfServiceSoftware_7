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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.webbrowser.SimpleWebBrowserExample;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * created by chenqinquan;
 */

public class ViewMain {

	private static JFrame frame;
	// 顶部菜单栏；
	private JMenuBar menuBar_top;
	private static JPanel panel_main;
	
	private static ArrayList<JPanel> records;
	
	private int x = 100;
	private int y = 100;
	private int width = 1000;
	private int height = 600;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("暨南大学珠海校区学生自助程序");
		frame.setResizable(false);
		frame.setBounds(x, y, width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar_top = new JMenuBar();
		frame.setJMenuBar(menuBar_top);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		panel_main = new JPanel();
		panel_main.setLayout(new CardLayout(0, 0));
		frame.getContentPane().add(panel_main, "name_18902815292286");
		
		records = new ArrayList<JPanel>();
		
		topMenuAddItem();
		
		// TODO
		// 替换panel_main;
		changePanelTemplate(new PanelMessage());

		
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
			}
		});
		menu_campuInquire.add(menuItem_message);
		
		JMenuItem menuItem_grade = new JMenuItem("成绩");
		menuItem_grade.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO
				changePanelTemplate(new PanelGradeRecord());
			}
		});
		menu_campuInquire.add(menuItem_grade);
		
		JMenuItem menuItem_jobInfo = new JMenuItem("就业信息");
		menuItem_jobInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO
//				JOptionPane.showMessageDialog(frame, "JOB", "Message", JOptionPane.PLAIN_MESSAGE);
				changePanelTemplate(new PanelEmploymentInfo());
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
				changePanelTemplate(new PanelCourseSelection());
			}
		});
		menu_study.add(menuItem_courseSelection);
		
		JMenuItem menuItem_trainingProgram = new JMenuItem("培养方案");
		menuItem_trainingProgram.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO
				changePanelTemplate(new PanelTrainingProgram());
			}
		});
		menu_study.add(menuItem_trainingProgram);
		
		JMenuItem menuItem_leave = new JMenuItem("请假");
		menuItem_leave.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO
				changePanelTemplate(new PanelLeaveDocEdit());
			}
		});
		menu_study.add(menuItem_leave);
		
		JMenu menu_other = new JMenu("其他功能");
		menuBar_top.add(menu_other);
		
		JMenuItem menuItem_download = new JMenuItem("模板下载");
		menuItem_download.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO
				frame.setEnabled(false);
				ViewDownloadDoc windows = new ViewDownloadDoc(x + 200, y + 100);
				windows.frame.setVisible(true);
				windows.frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				windows.frame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						frame.setEnabled(true);
					}
				});
			}
			
		});
		menu_other.add(menuItem_download);
		
		JMenuItem menuItem_fourm = new JMenuItem("校园论坛");
		menuItem_fourm.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UIUtils.setPreferredLookAndFeel();
		        NativeInterface.open();
		        SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		            	PanelWebBrowser web = new PanelWebBrowser();
		            	web.openFourm();
		            	changePanelMain(web);
		            }
		        });
		        NativeInterface.runEventPump();
			}
			
		});
		menu_other.add(menuItem_fourm);
		
	}
	
	// 切换模板；
	public static void changePanelTemplate(JPanel panel) {
		changePanelMain(new PanelTemplate(panel));
	}
	
	// 切换整个面板；
	public static void changePanelMain(JPanel panel) {
		panel_main.removeAll();
		panel_main.add(panel);
		panel_main.updateUI();
		records.add(panel);
		// 防止过多记录；
		if (records.size() > 10) {
			records.remove(0);
		}
	}
	
	public static JFrame getFrame() {
		return frame;
	}
	
	public static void panelBack() {
		int size = records.size();
		if (size - 1 > 0) {
			JPanel panel = records.get(size - 2);
			// fresh;
			panel.updateUI();
			records.remove(size - 1);
			panel_main.removeAll();
			panel_main.add(panel);
			panel_main.updateUI();
		}
	}
	
}
