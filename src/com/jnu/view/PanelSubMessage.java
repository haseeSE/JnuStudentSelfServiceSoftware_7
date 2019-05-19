package com.jnu.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.jnu.model.UserManager;
import com.jnu.model.WebDigitalJnu;
import com.jnu.model.WebElectrity;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import org.apache.log4j.Logger;

import javax.swing.JTextField;
import java.awt.SystemColor;

/*
 * create by chenqinquan;
 */

public class PanelSubMessage extends JPanel {
	
	private Logger Log = Logger.getLogger(getClass());
	
	private JLabel txt_dorm;
	private JLabel txt_eleBalance;
	private JLabel txt_eleLog;
	
	private JLabel txt_cardID;
	private JLabel txt_cardBalance;
	private JLabel txt_cardLog;
	
	private static String dorm = "";
	private static String cardID = "";
	private static String password = "";
	
	private static String eleBalance = "";
	private static String eleLog = "尚未加载，请点击加载！";
	
	private static String cardBalance = "";
	private static String cardLog = "尚未加载，请点击加载！";
	
	// 自定义枚举类型；
	private static enum ExecStatus {
		UNINITIALIZED, START, SUCCESS, FAIL, NETWORK_ERROR;
	};
	
	private static ExecStatus exec_card = ExecStatus.UNINITIALIZED;
	private static ExecStatus exec_ele = ExecStatus.UNINITIALIZED;
	
	private SimpleDateFormat dateFormat;
	
	// 爬虫线程；
	private static SwingWorker<String, Object> eleTask = null;
	private static SwingWorker<String, Object> cardTask = null;
	
	private static SwingWorker<String, Integer> logTaskForEle = null;
	private static SwingWorker<String, Integer> logTaskForCard = null;
	
	private void initialize() {
		// TODO Auto-generated method stub
		dorm = UserManager.getUser().get_dormitory();
		cardID = UserManager.getUser().get_JnuDCPId();
		password = UserManager.getUser().get_JnuDCPPassword();
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		// 线程初始化；
//		initThreadForEle();
//		initThreadForCard();
		initThreadForEleLog();
		initThreadForCardLog();
	}

	/**
	 * Create the panel.
	 */
	public PanelSubMessage() {
		// <----------	LOG: CREATED	------------>
		Log.info("CREATED");
		
		// 初始化各变量；
		initialize();
		
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
		
		txt_dorm = new JLabel(dorm);
		txt_dorm.setHorizontalAlignment(SwingConstants.LEFT);
		txt_dorm.setFont(new Font("新宋体", Font.PLAIN, 14));
		txt_dorm.setBounds(70, 40, 90, 15);
		panel_electrity.add(txt_dorm);
		
		txt_eleBalance = new JLabel(eleBalance);
		txt_eleBalance.setHorizontalAlignment(SwingConstants.LEFT);
		txt_eleBalance.setFont(new Font("新宋体", Font.PLAIN, 14));
		txt_eleBalance.setBounds(70, 65, 90, 15);
		panel_electrity.add(txt_eleBalance);
		
		JLabel label_eleBalance = new JLabel("余额：");
		label_eleBalance.setHorizontalAlignment(SwingConstants.LEFT);
		label_eleBalance.setFont(new Font("新宋体", Font.PLAIN, 14));
		label_eleBalance.setBounds(6, 65, 60, 15);
		panel_electrity.add(label_eleBalance);
		
		txt_eleLog = new JLabel(eleLog);
		txt_eleLog.setHorizontalAlignment(SwingConstants.LEFT);
		txt_eleLog.setFont(new Font("新宋体", Font.ITALIC, 12));
		txt_eleLog.setBounds(6, 90, 210, 15);
		panel_electrity.add(txt_eleLog);
		
		JLabel btn_eleTopUp = new JLabel("充值");
		btn_eleTopUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewMain.openWebElectrity();
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
				// 避免多次重复查询；
				if(exec_ele != ExecStatus.START)
					updateElectrityInfo();
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
		
		txt_cardID = new JLabel(cardID);
		txt_cardID.setHorizontalAlignment(SwingConstants.LEFT);
		txt_cardID.setFont(new Font("新宋体", Font.PLAIN, 14));
		txt_cardID.setBounds(70, 40, 90, 15);
		panel.add(txt_cardID);
		
		txt_cardBalance = new JLabel(cardBalance);
		txt_cardBalance.setHorizontalAlignment(SwingConstants.LEFT);
		txt_cardBalance.setFont(new Font("新宋体", Font.PLAIN, 14));
		txt_cardBalance.setBounds(70, 65, 90, 15);
		panel.add(txt_cardBalance);
		
		JLabel label_cardBalance = new JLabel("余额：");
		label_cardBalance.setHorizontalAlignment(SwingConstants.LEFT);
		label_cardBalance.setFont(new Font("新宋体", Font.PLAIN, 14));
		label_cardBalance.setBounds(6, 65, 60, 15);
		panel.add(label_cardBalance);
		
		txt_cardLog = new JLabel(cardLog);
		txt_cardLog.setHorizontalAlignment(SwingConstants.LEFT);
		txt_cardLog.setFont(new Font("新宋体", Font.ITALIC, 12));
		txt_cardLog.setBounds(6, 90, 210, 15);
		panel.add(txt_cardLog);
		
		JLabel btn_cardTopUp = new JLabel("充值");
		btn_cardTopUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewMain.openWebDigitalJnu();
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
				// 避免多次重复查询；
				if(exec_card != ExecStatus.START)
					updateCardInfo();
			}
			
		});
		btn_cardUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		btn_cardUpdate.setForeground(Color.CYAN);
		btn_cardUpdate.setFont(new Font("新宋体", Font.PLAIN, 14));
		btn_cardUpdate.setBounds(170, 41, 50, 15);
		panel.add(btn_cardUpdate);
		
		if(exec_ele == ExecStatus.START) {
			eleTask.execute();
			logTaskForEle.execute();			
		}
		if(exec_card == ExecStatus.START) {
			cardTask.execute();
			logTaskForCard.execute();
		}
		// 设置电费、卡费；
		if(exec_ele == ExecStatus.UNINITIALIZED) updateElectrityInfo();
		if(exec_card == ExecStatus.UNINITIALIZED) updateCardInfo();
	}

	private void updateCardInfo() {
		// TODO Auto-generated method stub
		// 检查用户是否存在；
		if(cardID == null || cardID.equals("") || password == null || password.equals("")) {
			txt_cardLog.setText("未检测到相关用户账户信息！");
			return;
		}
//		txt_cardLog.setText("更新中。。。。。。");
		initThreadForCard();
		initThreadForCardLog();
		// 状态：启动；
		exec_card = ExecStatus.START;					
		// 动态更新LOG启动；
		logTaskForCard.execute();		
		// 启动线程执行爬取卡费；   
        cardTask.execute();
        
	}

	private void updateElectrityInfo() {
		// TODO Auto-generated method stub
		if(dorm == null || dorm.equals("")) {
			txt_eleLog.setText("未检测到宿舍信息");
			return;
		}
		initThreadForEle();
		initThreadForEleLog();
		// 状态：启动；
		exec_ele = ExecStatus.START;		
		// 动态更新LOG启动；
		logTaskForEle.execute();		
		// 启动线程执行爬取电费；   
		eleTask.execute();
	}
	
	private void initThreadForEle() {
		// TODO Auto-generated method stub
		//线程为null时初始化；
		eleTask = new SwingWorker<String, Object>() {
			@Override
			protected String doInBackground() throws Exception {
				// TODO Auto-generated method stub
				Log.info("电费爬取线程启动");
				WebElectrity web = new WebElectrity();
				return web.getBalance(dorm);
			}	        	
			@Override
			protected void done() {
				try {
					eleBalance = get();
					if (eleBalance == null || eleBalance.equals("")) exec_ele = ExecStatus.FAIL;
            		else exec_ele = ExecStatus.SUCCESS;
				} catch(Exception e) {
					e.printStackTrace();
            		exec_ele = ExecStatus.NETWORK_ERROR;
            		Log.error("电费爬取线程出错");
				} finally {
//					txt_eleBalance.setText(eleBalance);
					Log.info("电费爬取线程结束");
				}
			}
        };
	}
	
	private void initThreadForCard() {
		// TODO Auto-generated method stub
		cardTask = new SwingWorker<String, Object>() {
			@Override
			protected String doInBackground() throws Exception {
				// TODO Auto-generated method stub
				Log.info("卡费爬取线程启动");
				WebDigitalJnu web = new WebDigitalJnu();
				return web.getBalance(cardID, password);
			}
			@Override
			protected void done() {
				try {
					cardBalance = get();
					if (cardBalance == null || cardBalance.equals("")) exec_card = ExecStatus.FAIL;
            		else exec_card = ExecStatus.SUCCESS;
				} catch(Exception e) {
					e.printStackTrace();
            		exec_card = ExecStatus.NETWORK_ERROR;
            		Log.error("卡费爬取线程出错");
				} finally {
//					txt_cardBalance.setText(cardBalance);
					Log.info("卡费爬取线程结束");
				}
			}
        };
	}
	
	private void initThreadForEleLog() {
		// TODO Auto-generated method stub
		logTaskForEle = new SwingWorker<String, Integer>() {
			private int cnt = 0;	
			@Override
			protected String doInBackground() throws Exception {
				// TODO Auto-generated method stub
				Log.info("电费爬取状态输出开始");
				while(exec_ele == ExecStatus.START) {
					Thread.sleep(200);
					setProgress(1);
					publish(1);
				}
				return "Hello";
			}
			@Override
			protected void process(List<Integer> chunks) {
				int i = cnt++ % 6;
				String text = "更新中";
				while(i-- > 0) text += "。";
				txt_eleLog.setText(text);
			}	
			@Override
			protected void done() {
				try {
					switch(exec_ele) {
						case NETWORK_ERROR:	eleLog = "更新失败，请检查网络！"; break;
						case FAIL:			eleLog = "登录失败，请检查宿舍号！"; break;
						case SUCCESS:		eleLog = "更新成功！ " + dateFormat.format(new Date()); break;
						default:
					}
				} catch(Exception e) {
					e.printStackTrace();
					Log.error("电费爬取状态输出出错");
				}finally {
					txt_eleBalance.setText(eleBalance);
					txt_eleLog.setText(eleLog);
					Log.info("电费爬取状态输出结束");
				}
			}			
		};
	}
	
	private void initThreadForCardLog() {
		// TODO Auto-generated method stub
		logTaskForCard = new SwingWorker<String, Integer>() {
			private int cnt = 0;	
			@Override
			protected String doInBackground() throws Exception {
				// TODO Auto-generated method stub
				Log.info("卡费爬取状态输出开始");
				while(exec_card == ExecStatus.START) {
					Thread.sleep(200);
					setProgress(1);
					publish(1);
				}
				return "Hello";
			}		
			@Override
			protected void process(List<Integer> chunks) {
				int i = cnt++ % 6;
				String text = "更新中";
				while(i-- > 0) text += "。";
				txt_cardLog.setText(text);
			}			
			@Override
			protected void done() {
				try {
					switch(exec_card) {
						case NETWORK_ERROR:	cardLog = "更新失败，请检查网络！"; break;
						case FAIL:			cardLog = "登录失败，请检查学号和密码！"; break;
						case SUCCESS:		cardLog = "更新成功！ " + dateFormat.format(new Date()); break;
						default:
					}
				} catch(Exception e) {
					e.printStackTrace();
					Log.info("卡费爬取状态出错");
				}finally {
					txt_cardBalance.setText(cardBalance);
					txt_cardLog.setText(cardLog);
					Log.info("卡费爬取状态输出结束");
				}
			}		
		};
	}
}
