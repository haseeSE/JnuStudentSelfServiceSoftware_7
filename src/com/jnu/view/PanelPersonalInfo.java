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

import com.jnu.model.MyFileOperator;
import com.jnu.model.MyLog;
import com.jnu.model.User;
import com.jnu.model.UserManager;

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
		textField_Name.setText(UserManager.get_name());
		add(textField_Name);
		textField_Name.setColumns(10);
		

		
		JLabel label_studentId = new JLabel("  学号：");
		label_studentId.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_studentId.setBounds(180, 128, 80, 24);
		add(label_studentId);
		
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
		
		JTextField textField_studentId = new JTextField();
		textField_studentId.setHorizontalAlignment(SwingConstants.CENTER);
		textField_studentId.setColumns(10);
		textField_studentId.setBounds(270, 128, 150, 24);
		textField_studentId.setText(UserManager.get_studentId());
		add(textField_studentId);
		
		JTextField textField_phoneNum = new JTextField();
		textField_phoneNum.setHorizontalAlignment(SwingConstants.CENTER);
		textField_phoneNum.setColumns(10);
		textField_phoneNum.setBounds(270, 162, 150, 24);
		textField_phoneNum.setText(UserManager.get_phoneNum());
		add(textField_phoneNum);
		
		JTextField textField_college = new JTextField();
		textField_college.setHorizontalAlignment(SwingConstants.CENTER);
		textField_college.setColumns(10);
		textField_college.setBounds(662, 94, 150, 24);
		textField_college.setText(UserManager.get_college());
		add(textField_college);
		
		JTextField textField_major = new JTextField();
		textField_major.setHorizontalAlignment(SwingConstants.CENTER);
		textField_major.setColumns(10);
		textField_major.setBounds(662, 128, 150, 24);
		textField_major.setText(UserManager.get_major());
		add(textField_major);
		
		JTextField textField_dormitory = new JTextField();
		textField_dormitory.setHorizontalAlignment(SwingConstants.CENTER);
		textField_dormitory.setColumns(10);
		textField_dormitory.setBounds(662, 162, 150, 24);
		textField_dormitory.setText(UserManager.get_dormitory());
		add(textField_dormitory);
		
		JLabel label_jnuDCPId = new JLabel("数字暨大账号：");
		label_jnuDCPId.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuDCPId.setBounds(336, 220, 140, 24);
		add(label_jnuDCPId);
		
		JLabel label_jnuDCPPassword = new JLabel("数字暨大密码：");
		label_jnuDCPPassword.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuDCPPassword.setBounds(336, 254, 140, 24);
		add(label_jnuDCPPassword);
		
		JLabel label_jnuForumId = new JLabel("暨大论坛账号：");
		label_jnuForumId.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuForumId.setBounds(336, 288, 140, 24);
		add(label_jnuForumId);
		
		JLabel label_jnuForumPassword = new JLabel("暨大论坛密码：");
		label_jnuForumPassword.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuForumPassword.setBounds(336, 322, 140, 24);
		add(label_jnuForumPassword);
		
		JLabel label_jnuEduAdminSystemId = new JLabel("教务系统账号：");
		label_jnuEduAdminSystemId.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuEduAdminSystemId.setBounds(336, 354, 140, 24);
		add(label_jnuEduAdminSystemId);
		
		JLabel label_jnuEduAdminSystemPassword = new JLabel("教务系统密码：");
		label_jnuEduAdminSystemPassword.setFont(new Font("新宋体", Font.PLAIN, 20));
		label_jnuEduAdminSystemPassword.setBounds(336, 390, 140, 24);
		add(label_jnuEduAdminSystemPassword);
		
		JTextField textField_jnuDCPId = new JTextField();
		textField_jnuDCPId.setColumns(10);
		textField_jnuDCPId.setBounds(486, 220, 150, 24);
		textField_jnuDCPId.setText(UserManager.get_JnuDCPId());
		add(textField_jnuDCPId);
		
		JTextField textField_jnuDCPPassword = new JTextField();
		textField_jnuDCPPassword.setColumns(10);
		textField_jnuDCPPassword.setBounds(486, 254, 150, 24);
		textField_jnuDCPPassword.setText(UserManager.get_JnuDCPPassword());
		add(textField_jnuDCPPassword);
		
		JTextField textField_jnuForumId = new JTextField();
		textField_jnuForumId.setColumns(10);
		textField_jnuForumId.setBounds(486, 288, 150, 24);
		textField_jnuForumId.setText(UserManager.get_JnuForumId());
		add(textField_jnuForumId);
		
		JTextField textField_jnuForumPassword = new JTextField();
		textField_jnuForumPassword.setColumns(10);
		textField_jnuForumPassword.setBounds(486, 322, 150, 24);
		textField_jnuForumPassword.setText(UserManager.get_JnuForumPassword());
		add(textField_jnuForumPassword);
		
		JTextField textField_jnuEduAdminSystemId = new JTextField();
		textField_jnuEduAdminSystemId.setColumns(10);
		textField_jnuEduAdminSystemId.setBounds(486, 354, 150, 24);
		textField_jnuEduAdminSystemId.setText(UserManager.get_JnuEduAdminSystemId());
		add(textField_jnuEduAdminSystemId);
		
		JTextField textField_jnuEduAdminSystemPassword = new JTextField();
		textField_jnuEduAdminSystemPassword.setColumns(10);
		textField_jnuEduAdminSystemPassword.setBounds(486, 390, 150, 24);
		add(textField_jnuEduAdminSystemPassword);
		
		JButton button_save = new JButton("\u4FDD\u5B58");
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
				
				JOptionPane.showMessageDialog(ViewMain.getFrame(), "保存成功", "用户信息修改", JOptionPane.PLAIN_MESSAGE);
				ViewMain.panelBack();
				
			}
		});
		button_save.setBounds(438, 458, 113, 27);
		add(button_save);
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
}
