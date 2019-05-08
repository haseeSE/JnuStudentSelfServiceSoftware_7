package com.jnu.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

import com.jnu.model.MyLog;

/*
 * created by zhujiayu;
 */

public class PanelPersonalInfo extends JPanel {


	/**
	 * Create the panel.
	 */
	public PanelPersonalInfo() {
		setLayout(null);
		
		JLabel label_personalInfo = new JLabel("\u4E2A\u4EBA\u4FE1\u606F", JLabel.CENTER);
		label_personalInfo.setBounds(93, 29, 794, 40);
		add(label_personalInfo);
		label_personalInfo.setFont(new Font("新宋体", Font.BOLD, 30));

		JLabel label_name = new JLabel("  姓名：");
		label_name.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_name.setBounds(180, 94, 80, 24);
		add(label_name);
		
		JTextField textField_Name = new JTextField();
		textField_Name.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Name.setBounds(270, 94, 150, 24);
		add(textField_Name);
		textField_Name.setColumns(10);
		

		
		JLabel label_studentID = new JLabel("  学号：");
		label_studentID.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_studentID.setBounds(180, 128, 80, 24);
		add(label_studentID);
		
		JLabel label_phoneNum = new JLabel("电话号码：");
		label_phoneNum.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_phoneNum.setBounds(165, 162, 100, 24);
		add(label_phoneNum);
		
		JLabel label_college = new JLabel("学院：");
		label_college.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_college.setBounds(582, 94, 80, 24);
		add(label_college);
		
		JLabel label_major = new JLabel("专业：");
		label_major.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_major.setBounds(582, 128, 80, 24);
		add(label_major);
		
		JLabel label_dormitory = new JLabel("宿舍：");
		label_dormitory.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_dormitory.setBounds(582, 162, 80, 24);
		add(label_dormitory);
		
		JTextField textField_studentID = new JTextField();
		textField_studentID.setHorizontalAlignment(SwingConstants.CENTER);
		textField_studentID.setColumns(10);
		textField_studentID.setBounds(270, 128, 150, 24);
		add(textField_studentID);
		
		JTextField textField_phoneNum = new JTextField();
		textField_phoneNum.setHorizontalAlignment(SwingConstants.CENTER);
		textField_phoneNum.setColumns(10);
		textField_phoneNum.setBounds(270, 162, 150, 24);
		add(textField_phoneNum);
		
		JTextField textField_college = new JTextField();
		textField_college.setHorizontalAlignment(SwingConstants.CENTER);
		textField_college.setColumns(10);
		textField_college.setBounds(662, 94, 150, 24);
		add(textField_college);
		
		JTextField textField_major = new JTextField();
		textField_major.setHorizontalAlignment(SwingConstants.CENTER);
		textField_major.setColumns(10);
		textField_major.setBounds(662, 128, 150, 24);
		add(textField_major);
		
		JTextField textField_dormitory = new JTextField();
		textField_dormitory.setHorizontalAlignment(SwingConstants.CENTER);
		textField_dormitory.setColumns(10);
		textField_dormitory.setBounds(662, 162, 150, 24);
		add(textField_dormitory);
		
		JLabel label_jnuDCPID = new JLabel("数字暨大账号：");
		label_jnuDCPID.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuDCPID.setBounds(336, 220, 140, 24);
		add(label_jnuDCPID);
		
		JLabel label_jnuDCPPassword = new JLabel("数字暨大密码：");
		label_jnuDCPPassword.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuDCPPassword.setBounds(336, 254, 140, 24);
		add(label_jnuDCPPassword);
		
		JLabel label_jnuForumID = new JLabel("暨大论坛账号：");
		label_jnuForumID.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuForumID.setBounds(336, 288, 140, 24);
		add(label_jnuForumID);
		
		JLabel label_jnuForumPassword = new JLabel("暨大论坛密码：");
		label_jnuForumPassword.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuForumPassword.setBounds(336, 322, 140, 24);
		add(label_jnuForumPassword);
		
		JLabel label_jnuEduAdminSystemID = new JLabel("教务系统账号：");
		label_jnuEduAdminSystemID.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuEduAdminSystemID.setBounds(336, 354, 140, 24);
		add(label_jnuEduAdminSystemID);
		
		JLabel label_jnuEduAdminSystemPassword = new JLabel("教务系统密码：");
		label_jnuEduAdminSystemPassword.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuEduAdminSystemPassword.setBounds(336, 390, 140, 24);
		add(label_jnuEduAdminSystemPassword);
		
		JTextField textField_jnuDCPID = new JTextField();
		textField_jnuDCPID.setColumns(10);
		textField_jnuDCPID.setBounds(486, 220, 150, 24);
		add(textField_jnuDCPID);
		
		JTextField textField_jnuDCPPassword = new JTextField();
		textField_jnuDCPPassword.setColumns(10);
		textField_jnuDCPPassword.setBounds(486, 254, 150, 24);
		add(textField_jnuDCPPassword);
		
		JTextField textField_jnuForumID = new JTextField();
		textField_jnuForumID.setColumns(10);
		textField_jnuForumID.setBounds(486, 288, 150, 24);
		add(textField_jnuForumID);
		
		JTextField textField_jnuForumPassword = new JTextField();
		textField_jnuForumPassword.setColumns(10);
		textField_jnuForumPassword.setBounds(486, 322, 150, 24);
		add(textField_jnuForumPassword);
		
		JTextField textField_jnuEduAdminSystemID = new JTextField();
		textField_jnuEduAdminSystemID.setColumns(10);
		textField_jnuEduAdminSystemID.setBounds(486, 354, 150, 24);
		add(textField_jnuEduAdminSystemID);
		
		JTextField textField_jnuEduAdminSystemPassword = new JTextField();
		textField_jnuEduAdminSystemPassword.setColumns(10);
		textField_jnuEduAdminSystemPassword.setBounds(486, 390, 150, 24);
		add(textField_jnuEduAdminSystemPassword);
		
		JButton button_save = new JButton("\u4FDD\u5B58");
		button_save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO
				
				JOptionPane.showMessageDialog(ViewMain.getFrame(), "保存成功", "用户信息修改", JOptionPane.PLAIN_MESSAGE);
//				ViewMain.panelBack();
				MyLog.write(PanelPersonalInfo.class, "点击了个人信息保存");
			}
		});
		button_save.setBounds(429, 456, 113, 27);
		add(button_save);

	}
}
