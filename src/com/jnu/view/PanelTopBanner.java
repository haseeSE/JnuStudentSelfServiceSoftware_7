package com.jnu.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import com.jnu.model.UserManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * created by chenqinquan;
 */

public class PanelTopBanner extends JPanel {
	
	private Logger Log = Logger.getLogger(getClass());
	
	private JTextField textField_editSearch;
	
	/**
	 * Create the panel.
	 */
	public PanelTopBanner() {
		// <----------	LOG: CREATED	------------>
		Log.info("CREATED");
		
		setLayout(null);
		
		textField_editSearch = new JTextField();
		textField_editSearch.setBounds(70, 12, 143, 21);
		add(textField_editSearch);
		textField_editSearch.setColumns(10);
		
		JButton btn_search = new JButton("New button");
		btn_search.setBounds(215, 10, 46, 23);
		add(btn_search);
		
		String name = UserManager.getUser().get_name();
		JLabel lblUsera = new JLabel( (name != null && !name.equals("")) ? name : "未登陆" );
		lblUsera.setFont(new Font("新宋体", Font.BOLD, 22));
		lblUsera.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsera.setBounds(750, 10, 120, 28);
		add(lblUsera);
		
		JLabel lblEdit = new JLabel( (name != null && !name.equals("")) ? "注销" : "登录" );
		lblEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Switch to PanelPersonalInfo;
				ViewMain.openPersonal();
				Log.info("点击了修改用户信息");
			}
		});
		lblEdit.setForeground(Color.RED);
		lblEdit.setFont(new Font("新宋体", Font.PLAIN, 12));
		lblEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdit.setBounds(860, 23, 40, 15);
		add(lblEdit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(-100, 45, 1100, 2);
		add(scrollPane);
	}

}
