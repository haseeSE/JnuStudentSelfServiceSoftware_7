package com.jnu.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.jnu.model.MyLog;
import com.jnu.model.UserManager;
import com.jnu.model.WebDigitalJnu;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import java.awt.SystemColor;

/*
 * create by chenqinquan;
 */

public class PanelSubMessage extends JPanel {
	
	private JLabel txt_dorm;
	private JLabel txt_elebalance;
	private JLabel txt_eleLog;
	
	private String eleBalance = "";
	
	private JLabel txt_cardID;
	private JLabel txt_cardBalance;
	private JLabel txt_cardLog;
	
	private String cardBalance = "";

	/**
	 * Create the panel.
	 */
	public PanelSubMessage() {
		setLayout(null);
		
		JPanel panel_electrity = new JPanel();
		panel_electrity.setBackground(Color.LIGHT_GRAY);
		panel_electrity.setBounds(51, 22, 228, 110);
		add(panel_electrity);
		panel_electrity.setLayout(null);
		
		JLabel label_electrityInfo = new JLabel("宿舍电费相关");
		label_electrityInfo.setFont(new Font("新宋体", Font.BOLD, 16));
		label_electrityInfo.setHorizontalAlignment(SwingConstants.LEFT);
		label_electrityInfo.setBounds(10, 6, 206, 25);
		panel_electrity.add(label_electrityInfo);
		
		JScrollPane line = new JScrollPane();
		line.setBounds(0, 30, 228, 2);
		panel_electrity.add(line);
		
		JLabel label_dorm = new JLabel("宿舍号：");
		label_dorm.setHorizontalAlignment(SwingConstants.LEFT);
		label_dorm.setFont(new Font("新宋体", Font.PLAIN, 14));
		label_dorm.setBounds(6, 40, 60, 15);
		panel_electrity.add(label_dorm);
		
		txt_dorm = new JLabel("");
		txt_dorm.setHorizontalAlignment(SwingConstants.LEFT);
		txt_dorm.setFont(new Font("新宋体", Font.PLAIN, 14));
		txt_dorm.setBounds(70, 40, 90, 15);
		panel_electrity.add(txt_dorm);
		
		txt_elebalance = new JLabel("");
		txt_elebalance.setHorizontalAlignment(SwingConstants.LEFT);
		txt_elebalance.setFont(new Font("新宋体", Font.PLAIN, 14));
		txt_elebalance.setBounds(70, 65, 90, 15);
		panel_electrity.add(txt_elebalance);
		
		JLabel label_eleBalance = new JLabel("余额：");
		label_eleBalance.setHorizontalAlignment(SwingConstants.LEFT);
		label_eleBalance.setFont(new Font("新宋体", Font.PLAIN, 14));
		label_eleBalance.setBounds(6, 65, 60, 15);
		panel_electrity.add(label_eleBalance);
		
		txt_eleLog = new JLabel("尚未加载，请点击更新！");
		txt_eleLog.setHorizontalAlignment(SwingConstants.LEFT);
		txt_eleLog.setFont(new Font("新宋体", Font.ITALIC, 12));
		txt_eleLog.setBounds(6, 90, 210, 15);
		panel_electrity.add(txt_eleLog);
		
		JLabel btn_eleTopUp = new JLabel("充值");
		btn_eleTopUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn_eleTopUp.setForeground(new Color(0, 255, 255));
		btn_eleTopUp.setHorizontalAlignment(SwingConstants.CENTER);
		btn_eleTopUp.setFont(new Font("新宋体", Font.PLAIN, 14));
		btn_eleTopUp.setBounds(170, 65, 50, 15);
		panel_electrity.add(btn_eleTopUp);
		
		JLabel btn_eleUpdate = new JLabel("更新");
		btn_eleUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btn_eleUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		btn_eleUpdate.setForeground(Color.CYAN);
		btn_eleUpdate.setFont(new Font("新宋体", Font.PLAIN, 14));
		btn_eleUpdate.setBounds(170, 41, 50, 15);
		panel_electrity.add(btn_eleUpdate);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(51, 170, 228, 110);
		add(panel);
		
		JLabel label_cardInfo = new JLabel("学生卡相关");
		label_cardInfo.setHorizontalAlignment(SwingConstants.LEFT);
		label_cardInfo.setFont(new Font("新宋体", Font.BOLD, 16));
		label_cardInfo.setBounds(10, 6, 206, 25);
		panel.add(label_cardInfo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 30, 228, 2);
		panel.add(scrollPane);
		
		JLabel label_cardID = new JLabel("宿舍号：");
		label_cardID.setHorizontalAlignment(SwingConstants.LEFT);
		label_cardID.setFont(new Font("新宋体", Font.PLAIN, 14));
		label_cardID.setBounds(6, 40, 60, 15);
		panel.add(label_cardID);
		
		txt_cardID = new JLabel("");
		txt_cardID.setHorizontalAlignment(SwingConstants.LEFT);
		txt_cardID.setFont(new Font("新宋体", Font.PLAIN, 14));
		txt_cardID.setBounds(70, 40, 90, 15);
		panel.add(txt_cardID);
		
		txt_cardBalance = new JLabel("");
		txt_cardBalance.setHorizontalAlignment(SwingConstants.LEFT);
		txt_cardBalance.setFont(new Font("新宋体", Font.PLAIN, 14));
		txt_cardBalance.setBounds(70, 65, 90, 15);
		panel.add(txt_cardBalance);
		
		JLabel label_cardBalance = new JLabel("余额：");
		label_cardBalance.setHorizontalAlignment(SwingConstants.LEFT);
		label_cardBalance.setFont(new Font("新宋体", Font.PLAIN, 14));
		label_cardBalance.setBounds(6, 65, 60, 15);
		panel.add(label_cardBalance);
		
		txt_cardLog = new JLabel("尚未加载，请点击更新！");
		txt_cardLog.setHorizontalAlignment(SwingConstants.LEFT);
		txt_cardLog.setFont(new Font("新宋体", Font.ITALIC, 12));
		txt_cardLog.setBounds(6, 90, 210, 15);
		panel.add(txt_cardLog);
		
		JLabel btn_cardTopUp = new JLabel("充值");
		btn_cardTopUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIUtils.setPreferredLookAndFeel();
		        NativeInterface.open();
		        SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		            	PanelWebBrowser web = new PanelWebBrowser();
		            	web.openDigitalJnu();
		            	ViewMain.changePanelMain(web);
		            }
		        });
		        NativeInterface.runEventPump();
			}
		});
		btn_cardTopUp.setHorizontalAlignment(SwingConstants.CENTER);
		btn_cardTopUp.setForeground(Color.CYAN);
		btn_cardTopUp.setFont(new Font("新宋体", Font.PLAIN, 14));
		btn_cardTopUp.setBounds(170, 65, 50, 15);
		panel.add(btn_cardTopUp);
		
		JLabel btn_cardUpdate = new JLabel("更新");
		btn_cardUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateCardInfo();
			}
			
		});
		btn_cardUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		btn_cardUpdate.setForeground(Color.CYAN);
		btn_cardUpdate.setFont(new Font("新宋体", Font.PLAIN, 14));
		btn_cardUpdate.setBounds(170, 41, 50, 15);
		panel.add(btn_cardUpdate);
		
		// 设置电费、卡费；
//		updateElectrityInfo();
//		updateCardInfo();
	}

	private void updateCardInfo() {
		// TODO Auto-generated method stub
		String username = UserManager.get_JnuDCPId();
		String password = UserManager.get_JnuDCPPassword();
		// 检查用户是否存在；
		if(username == null || username.equals("")
				|| password == null || password.equals("")) {
			txt_cardLog.setText("未检测到相关用户账户信息！");
			return;
		}
		txt_cardLog.setText("更新中。。。。。。");
		// 创建线程执行爬取卡费；
		UIUtils.setPreferredLookAndFeel();
        NativeInterface.open();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
//            	MyLog.write(getClass(), "Thread Start");
            	try {            		
            		WebDigitalJnu web = new WebDigitalJnu();
            		cardBalance = web.getBalance(username, password);
            		if (cardBalance.equals("")) {
            			txt_cardLog.setText("登录失败，请检查学号和密码！");
            		}
            		else {
            			txt_cardID.setText(username);
            			txt_cardBalance.setText(cardBalance);
            			txt_cardLog.setText("更新成功！");
            		}
            		            		
            	} catch(Exception e) {
            		e.printStackTrace();
            		txt_cardLog.setText("更新失败，请检查网络！");
            	}
            }
        });
        NativeInterface.runEventPump();
	}

	private void updateElectrityInfo() {
		// TODO Auto-generated method stub
		
	}
}
