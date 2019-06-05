package com.jnu.view;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import com.jnu.model.MyFileOperator;
import com.jnu.model.MyNumKeyAdapter;
import com.jnu.model.NoticeSetting;
import com.jnu.model.User;
import com.jnu.model.UserManager;
import com.jnu.model.WebTMSystem;
import java.awt.Color;
import javax.swing.JScrollPane;

/*
 * created by zhujiayu;
 */

public class PanelPersonalInfo extends JPanel {
	
	private Logger Log = Logger.getLogger(getClass());

	private WebTMSystem web = new WebTMSystem();
	
	private void initialize() {
		// TODO Auto-generated method stub
		web.initialize();
	}
	
	private void initializeNoticeSetting(String college) {
		if (college.contains("人文"))
			NoticeSetting.setCollegeNotice_humanities(true);
		else if (college.contains("国商") || college.contains("国际商务"))
			NoticeSetting.setCollegeNotice_internationalBusiness(true);
		else if (college.contains("翻院") || college.contains("翻译"))
			NoticeSetting.setCollegeNotice_translationStudies(true);
		else if (college.contains("智科") || college.contains("智能科学与工程"))
			NoticeSetting.setCollegeNotice_intelligentScienceAndEngineering(true);
		else if (college.contains("电工") || college.contains("电气工程"))
			NoticeSetting.setCollegeNotice_electricalEngineering(true);
		else if (college.contains("包装"))
			NoticeSetting.setCollegeNotice_packagingEngineering(true);
	}
	
	/**
	 * Create the panel.
	 */
	public PanelPersonalInfo() {
		// <----------	LOG: CREATED	------------>
		Log.info("CREATED");
		
		initialize();
		
		setLayout(null);
		
		JLabel label_personalInfo = new JLabel("\u4E2A\u4EBA\u4FE1\u606F", JLabel.CENTER);
		label_personalInfo.setBounds(93, 20, 794, 40);
		add(label_personalInfo);
		label_personalInfo.setFont(new Font("新宋体", Font.BOLD, 30));

		JLabel label_name = new JLabel("  姓名：");
		label_name.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_name.setBounds(173, 87, 80, 24);
		add(label_name);
		
		JTextField textField_Name = new JTextField();
		textField_Name.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Name.setBounds(263, 87, 150, 24);
		textField_Name.setText(UserManager.getUser().get_name());
		add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel label_studentId = new JLabel("  学号：");
		label_studentId.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_studentId.setBounds(173, 121, 80, 24);
		add(label_studentId);
		
		JLabel label_phoneNum = new JLabel("电话号码：");
		label_phoneNum.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_phoneNum.setBounds(158, 155, 100, 24);
		add(label_phoneNum);
		
		JLabel label_college = new JLabel("学院：");
		label_college.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_college.setBounds(575, 87, 80, 24);
		add(label_college);
		
		JLabel label_major = new JLabel("专业：");
		label_major.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_major.setBounds(575, 121, 80, 24);
		add(label_major);
		
		JLabel label_dormitory = new JLabel("宿舍：");
		label_dormitory.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_dormitory.setBounds(575, 155, 80, 24);
		add(label_dormitory);
		
		JTextField textField_studentId = new JTextField();
		textField_studentId.setHorizontalAlignment(SwingConstants.CENTER);
		textField_studentId.setColumns(10);
		textField_studentId.setBounds(263, 121, 150, 24);
		textField_studentId.setText(UserManager.getUser().get_studentId());
		textField_studentId.addKeyListener(new MyNumKeyAdapter());
		add(textField_studentId);
		
		JTextField textField_phoneNum = new JTextField();
		textField_phoneNum.setHorizontalAlignment(SwingConstants.CENTER);
		textField_phoneNum.setColumns(10);
		textField_phoneNum.setBounds(263, 155, 150, 24);
		textField_phoneNum.setText(UserManager.getUser().get_phoneNum());
		textField_phoneNum.addKeyListener(new MyNumKeyAdapter());
		add(textField_phoneNum);
		
		JTextField textField_college = new JTextField();
		textField_college.setHorizontalAlignment(SwingConstants.CENTER);
		textField_college.setColumns(10);
		textField_college.setBounds(655, 87, 150, 24);
		textField_college.setText(UserManager.getUser().get_college());
		add(textField_college);
		
		JTextField textField_major = new JTextField();
		textField_major.setHorizontalAlignment(SwingConstants.CENTER);
		textField_major.setColumns(10);
		textField_major.setBounds(655, 121, 150, 24);
		textField_major.setText(UserManager.getUser().get_major());
		add(textField_major);
		
		JTextField textField_dormitory = new JTextField();
		textField_dormitory.setHorizontalAlignment(SwingConstants.CENTER);
		textField_dormitory.setColumns(10);
		textField_dormitory.setBounds(655, 155, 150, 24);
		textField_dormitory.setText(UserManager.getUser().get_dormitory());
		textField_dormitory.addKeyListener(new MyNumKeyAdapter());
		add(textField_dormitory);
		
		JLabel label_jnuDCPId = new JLabel("数字暨大账号：");
		label_jnuDCPId.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuDCPId.setBounds(347, 212, 140, 24);
		add(label_jnuDCPId);
		
		JLabel label_jnuDCPPassword = new JLabel("数字暨大密码：");
		label_jnuDCPPassword.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuDCPPassword.setBounds(347, 246, 140, 24);
		add(label_jnuDCPPassword);
		
		JLabel label_jnuForumId = new JLabel("暨大论坛账号：");
		label_jnuForumId.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuForumId.setBounds(347, 280, 140, 24);
		add(label_jnuForumId);
		
		JLabel label_jnuForumPassword = new JLabel("暨大论坛密码：");
		label_jnuForumPassword.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuForumPassword.setBounds(347, 314, 140, 24);
		add(label_jnuForumPassword);
		
		JLabel label_jnuEduAdminSystemId = new JLabel("教务系统账号：");
		label_jnuEduAdminSystemId.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuEduAdminSystemId.setBounds(347, 346, 140, 24);
		add(label_jnuEduAdminSystemId);
		
		JLabel label_jnuEduAdminSystemPassword = new JLabel("教务系统密码：");
		label_jnuEduAdminSystemPassword.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuEduAdminSystemPassword.setBounds(347, 382, 140, 24);
		add(label_jnuEduAdminSystemPassword);
		
		JTextField textField_jnuDCPId = new JTextField();
		textField_jnuDCPId.setColumns(10);
		textField_jnuDCPId.setBounds(497, 212, 150, 24);
		textField_jnuDCPId.setText(UserManager.getUser().get_JnuDCPId());
		textField_jnuDCPId.addKeyListener(new MyNumKeyAdapter());
		add(textField_jnuDCPId);
		
		JTextField textField_jnuDCPPassword = new JPasswordField();
		textField_jnuDCPPassword.setColumns(10);
		textField_jnuDCPPassword.setBounds(497, 246, 150, 24);
		textField_jnuDCPPassword.setText(UserManager.getUser().get_JnuDCPPassword());
		add(textField_jnuDCPPassword);
		
		JTextField textField_jnuForumId = new JTextField();
		textField_jnuForumId.setColumns(10);
		textField_jnuForumId.setBounds(497, 280, 150, 24);
		textField_jnuForumId.setText(UserManager.getUser().get_JnuForumId());
		add(textField_jnuForumId);
		
		JTextField textField_jnuForumPassword = new JPasswordField();
		textField_jnuForumPassword.setColumns(10);
		textField_jnuForumPassword.setBounds(497, 314, 150, 24);
		textField_jnuForumPassword.setText(UserManager.getUser().get_JnuForumPassword());
		add(textField_jnuForumPassword);
		
		JTextField textField_jnuEduAdminSystemId = new JTextField();
		textField_jnuEduAdminSystemId.setColumns(10);
		textField_jnuEduAdminSystemId.setBounds(497, 346, 150, 24);
		textField_jnuEduAdminSystemId.setText(UserManager.getUser().get_JnuEduAdminSystemId());
		textField_jnuEduAdminSystemId.addKeyListener(new MyNumKeyAdapter());
		add(textField_jnuEduAdminSystemId);
		
		JTextField textField_jnuEduAdminSystemPassword = new JPasswordField();
		textField_jnuEduAdminSystemPassword.setColumns(10);
		textField_jnuEduAdminSystemPassword.setBounds(497, 382, 150, 24);
		textField_jnuEduAdminSystemPassword.setText(UserManager.getUser().get_JnuEduAdminSystemPassword());
		add(textField_jnuEduAdminSystemPassword);
		
		JButton button_save = new JButton("保存进入");
		button_save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				//保存学院信息到NoticeSetting（如果有的话）
				initializeNoticeSetting(textField_college.getText());
				
				User user = UserManager.getUser();	
				
				String jnuEduId = user.get_JnuEduAdminSystemId();
				String jnuEduPwd = user.get_JnuEduAdminSystemPassword();
				
				//将用户输入文本中的值依次赋给User
				user.set_name(textField_Name.getText());
				user.set_studentId(textField_studentId.getText());
				user.set_phoneNum(textField_phoneNum.getText());
				user.set_college(textField_college.getText());
				user.set_major(textField_major.getText());
				user.set_dormitory(textField_dormitory.getText());
				user.set_JnuDCPId(textField_jnuDCPId.getText());
				user.set_JnuDCPPassword(textField_jnuDCPPassword.getText());;
				user.set_JnuForumId(textField_jnuForumId.getText());
				user.set_JnuForumPassword(textField_jnuForumPassword.getText());
				user.set_JnuEduAdiminSystemId(textField_jnuEduAdminSystemId.getText());
				user.set_JnuEduAdminSystemPassword(textField_jnuEduAdminSystemPassword.getText());
				
				Log.info("保存到User.ser");
				// 保存到全局变量和文件；
//				UserManager.setUser(user);
				UserManager.saveUser();
	
				if(jnuEduId.equals(user.get_JnuEduAdminSystemId())
						&& jnuEduPwd.equals(user.get_JnuEduAdminSystemPassword()) && web.getIsLogined()) 
				{
					Log.info("保持当前教务系统的登陆: " + jnuEduId);
					ViewMain.openMainMessage();
				}
				else {
					web.loginOut();
					String options[] = {"登录","直接进入"};
					int value = JOptionPane.showOptionDialog(ViewMain.getFrame(), "尚未登陆到教务系统 ！",
							"提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,options, "登陆");
					if (value != JOptionPane.CLOSED_OPTION) {
						switch (value) {	
							case 0:	
								ImageIcon icon = web.gettxtFJM();
								if(icon == null) {
									JOptionPane.showMessageDialog(ViewMain.getFrame(), "请检查网络！", "提示", JOptionPane.WARNING_MESSAGE);
									break;
								}
								String input = (String)JOptionPane.showInputDialog(ViewMain.getFrame(), "请输入验证码", "提示",
										JOptionPane.INFORMATION_MESSAGE, icon, null, null);
								Log.info("验证码输入： " + input);
								if(input != null) {
									try {
										web.logintmsystem(user.get_JnuEduAdminSystemId(), user.get_JnuEduAdminSystemPassword(),
												input == null ? "" : input);	
									} catch(Exception e1) {
										e1.printStackTrace();
										Log.error("登录失败");
										JOptionPane.showMessageDialog(ViewMain.getFrame(), "请检查网络！", "提示", JOptionPane.WARNING_MESSAGE);
										break;
									}
									if(!web.getIsLogined()) {
										JOptionPane.showMessageDialog(ViewMain.getFrame(), "登录失败！", "登录教务系统", JOptionPane.ERROR_MESSAGE);
									}else
										ViewMain.openMainMessage();
								}
								break;
//								try {
//									web.logintmsystem(jnuEduId, jnuEduPwd, input == null ? "" : input);	
//								} catch(Exception e1) {
//									e1.printStackTrace();
//									Log.error("登录失败");						
//								}
//								if(!web.getIsLogined())	break;	
							case 1:	ViewMain.openMainMessage(); break;	
						}
					}			
				}			
			}
		});
		button_save.setBounds(437, 443, 113, 27);
		add(button_save);
	}
}
