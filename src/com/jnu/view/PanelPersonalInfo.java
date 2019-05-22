package com.jnu.view;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import com.jnu.model.MyFileOperator;
import com.jnu.model.User;
import com.jnu.model.UserManager;
import com.jnu.model.WebTMSystem;
import java.awt.Color;

/*
 * created by zhujiayu;
 */

public class PanelPersonalInfo extends JPanel {
	
	private Logger Log = Logger.getLogger(getClass());
	
	private JLabel src_signal;
	private JTextField txt_signal;
	private WebTMSystem web = new WebTMSystem();
	
	private void initialize() {
		// TODO Auto-generated method stub
		web.initialize();
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
		label_name.setBounds(173, 79, 80, 24);
		add(label_name);
		
		JTextField textField_Name = new JTextField();
		textField_Name.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Name.setBounds(263, 79, 150, 24);
		textField_Name.setText(UserManager.getUser().get_name());
		add(textField_Name);
		textField_Name.setColumns(10);
		

		
		JLabel label_studentId = new JLabel("  学号：");
		label_studentId.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_studentId.setBounds(173, 113, 80, 24);
		add(label_studentId);
		
		JLabel label_phoneNum = new JLabel("电话号码：");
		label_phoneNum.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_phoneNum.setBounds(158, 147, 100, 24);
		add(label_phoneNum);
		
		JLabel label_college = new JLabel("学院：");
		label_college.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_college.setBounds(575, 79, 80, 24);
		add(label_college);
		
		JLabel label_major = new JLabel("专业：");
		label_major.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_major.setBounds(575, 113, 80, 24);
		add(label_major);
		
		JLabel label_dormitory = new JLabel("宿舍：");
		label_dormitory.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_dormitory.setBounds(575, 147, 80, 24);
		add(label_dormitory);
		
		JTextField textField_studentId = new JTextField();
		textField_studentId.setHorizontalAlignment(SwingConstants.CENTER);
		textField_studentId.setColumns(10);
		textField_studentId.setBounds(263, 113, 150, 24);
		textField_studentId.setText(UserManager.getUser().get_studentId());
		add(textField_studentId);
		
		JTextField textField_phoneNum = new JTextField();
		textField_phoneNum.setHorizontalAlignment(SwingConstants.CENTER);
		textField_phoneNum.setColumns(10);
		textField_phoneNum.setBounds(263, 147, 150, 24);
		textField_phoneNum.setText(UserManager.getUser().get_phoneNum());
		add(textField_phoneNum);
		
		JTextField textField_college = new JTextField();
		textField_college.setHorizontalAlignment(SwingConstants.CENTER);
		textField_college.setColumns(10);
		textField_college.setBounds(655, 79, 150, 24);
		textField_college.setText(UserManager.getUser().get_college());
		add(textField_college);
		
		JTextField textField_major = new JTextField();
		textField_major.setHorizontalAlignment(SwingConstants.CENTER);
		textField_major.setColumns(10);
		textField_major.setBounds(655, 113, 150, 24);
		textField_major.setText(UserManager.getUser().get_major());
		add(textField_major);
		
		JTextField textField_dormitory = new JTextField();
		textField_dormitory.setHorizontalAlignment(SwingConstants.CENTER);
		textField_dormitory.setColumns(10);
		textField_dormitory.setBounds(655, 147, 150, 24);
		textField_dormitory.setText(UserManager.getUser().get_dormitory());
		add(textField_dormitory);
		
		JLabel label_jnuDCPId = new JLabel("数字暨大账号：");
		label_jnuDCPId.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuDCPId.setBounds(329, 205, 140, 24);
		add(label_jnuDCPId);
		
		JLabel label_jnuDCPPassword = new JLabel("数字暨大密码：");
		label_jnuDCPPassword.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuDCPPassword.setBounds(329, 239, 140, 24);
		add(label_jnuDCPPassword);
		
		JLabel label_jnuForumId = new JLabel("暨大论坛账号：");
		label_jnuForumId.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuForumId.setBounds(329, 273, 140, 24);
		add(label_jnuForumId);
		
		JLabel label_jnuForumPassword = new JLabel("暨大论坛密码：");
		label_jnuForumPassword.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuForumPassword.setBounds(329, 307, 140, 24);
		add(label_jnuForumPassword);
		
		JLabel label_jnuEduAdminSystemId = new JLabel("教务系统账号：");
		label_jnuEduAdminSystemId.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuEduAdminSystemId.setBounds(329, 339, 140, 24);
		add(label_jnuEduAdminSystemId);
		
		JLabel label_jnuEduAdminSystemPassword = new JLabel("教务系统密码：");
		label_jnuEduAdminSystemPassword.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuEduAdminSystemPassword.setBounds(329, 375, 140, 24);
		add(label_jnuEduAdminSystemPassword);
		
		JTextField textField_jnuDCPId = new JTextField();
		textField_jnuDCPId.setColumns(10);
		textField_jnuDCPId.setBounds(479, 205, 150, 24);
		textField_jnuDCPId.setText(UserManager.getUser().get_JnuDCPId());
		add(textField_jnuDCPId);
		
		JTextField textField_jnuDCPPassword = new JPasswordField();
		textField_jnuDCPPassword.setColumns(10);
		textField_jnuDCPPassword.setBounds(479, 239, 150, 24);
		textField_jnuDCPPassword.setText(UserManager.getUser().get_JnuDCPPassword());
		add(textField_jnuDCPPassword);
		
		JTextField textField_jnuForumId = new JTextField();
		textField_jnuForumId.setColumns(10);
		textField_jnuForumId.setBounds(479, 273, 150, 24);
		textField_jnuForumId.setText(UserManager.getUser().get_JnuForumId());
		add(textField_jnuForumId);
		
		JTextField textField_jnuForumPassword = new JPasswordField();
		textField_jnuForumPassword.setColumns(10);
		textField_jnuForumPassword.setBounds(479, 307, 150, 24);
		textField_jnuForumPassword.setText(UserManager.getUser().get_JnuForumPassword());
		add(textField_jnuForumPassword);
		
		JTextField textField_jnuEduAdminSystemId = new JTextField();
		textField_jnuEduAdminSystemId.setColumns(10);
		textField_jnuEduAdminSystemId.setBounds(479, 339, 150, 24);
		textField_jnuEduAdminSystemId.setText(UserManager.getUser().get_JnuEduAdminSystemId());
		add(textField_jnuEduAdminSystemId);
		
		JTextField textField_jnuEduAdminSystemPassword = new JPasswordField();
		textField_jnuEduAdminSystemPassword.setColumns(10);
		textField_jnuEduAdminSystemPassword.setBounds(479, 375, 150, 24);
		textField_jnuEduAdminSystemPassword.setText(UserManager.getUser().get_JnuEduAdminSystemPassword());
		add(textField_jnuEduAdminSystemPassword);
		
		JButton button_save = new JButton("登录");
		button_save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO
/*
				JOptionPane.showMessageDialog(ViewMain.getFrame(), "保存成功", "用户信息修改", JOptionPane.PLAIN_MESSAGE);
//				ViewMain.panelBack();
				ViewMain.changePanelTemplate(new PanelMessage());
*
*	逻辑错误，应该先保存到UserManage 再刷新Panel;
*/				
				// TODO Auto-generated method stub
				//将用户输入文本中的值依次赋给User
				User user = UserManager.getUser();				
				
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
				
				UserManager.setUser(user);
				UserManager.saveUser();
				boolean res = false;
				try {
					String vc = txt_signal.getText();
					res = web.logintmsystem(user.get_JnuEduAdminSystemId(),
						user.get_JnuEduAdminSystemPassword(), vc);
					
				} catch(Exception e1) {
					e1.printStackTrace();
					Log.error("联网失败");
					
				}
				
				JOptionPane.showMessageDialog(ViewMain.getFrame(), res ? "登录教务系统成功" : 
					"登录教务系统失败，将导致选课、查询成绩、培养方案无法使用！", "提示信息", JOptionPane.PLAIN_MESSAGE);
				
				ViewMain.openMainMessage();
				
			}
		});
		button_save.setBounds(430, 456, 113, 27);
		add(button_save);
		
		txt_signal = new JTextField();
		txt_signal.setColumns(10);
		txt_signal.setBounds(479, 409, 80, 24);
		add(txt_signal);
		
		src_signal = new JLabel("联网失败");
		src_signal.setForeground(Color.RED);
		src_signal.setFont(new Font("新宋体", Font.ITALIC, 12));
		src_signal.setHorizontalAlignment(SwingConstants.CENTER);
		setVcIcon();
		src_signal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVcIcon();
			}
		});
		
		src_signal.setBounds(399, 409, 70, 24);
		add(src_signal);
		/*button_save.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0e) {
				// TODO Auto-generated method stub
				//将用户输入文本中的值依次赋给User
				UserManager.set_name(textField_Name.getText());
				UserManager.set_studentId(textField_studentId.getText());
				UserManager.set_phoneNum(textField_phoneNum.getText());
				UserManager.set_college(textField_college.getText());
				UserManager.set_major(textField_major.getText());
				UserManager.set_dormitory(textField_dormitory.getText());
				UserManager.set_JnuDCPId(textField_jnuDCPId.getText());
				UserManager.set_JnuDCPPassword(textField_jnuDCPPassword.getText());;
				UserManager.set_JnuForumId(textField_jnuForumId.getText());
				UserManager.set_JnuForumPassword(textField_jnuForumPassword.getText());
				UserManager.set_JnuEduAdiminSystemId(textField_jnuEduAdminSystemId.getText());
				UserManager.set_JnuEduAdminSystemPassword(textField_jnuEduAdminSystemPassword.getText());
				
				User user = new User(new UserManager());
				MyFileOperator.save(user);
				//MyFileOperator.save(new User());
			}		
		});*/


	}

	protected void setVcIcon() {
		// TODO Auto-generated method stub
		// 设置验证码图片；
		ImageIcon icon = web.gettxtFJM();
		if(icon != null) {
			src_signal.removeAll();
			src_signal.setIcon(icon);
			src_signal.updateUI();
		}
	}
}
