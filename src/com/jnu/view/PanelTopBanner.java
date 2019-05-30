package com.jnu.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import com.jnu.model.NoticeContainer;
import com.jnu.model.NoticeDataCapture;
import com.jnu.model.UserManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

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
		
		JButton btn_search = new JButton("搜索");
		btn_search.setBounds(215, 10, 69, 23);
		add(btn_search);
		//搜索btn点击事件
		btn_search.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str_search = textField_editSearch.getText();
				if(str_search != null && str_search != "") {
					
					ArrayList<NoticeContainer> searchResList = new ArrayList<NoticeContainer>();
					
					ArrayList<NoticeContainer> theNotices = new ArrayList<NoticeContainer>();
					try {
						theNotices.addAll(PanelNoticeContainer.school_notice);
						theNotices.addAll(PanelNoticeContainer.college_notice);
						theNotices.addAll(PanelNoticeContainer.academicAdminstration_notice);
						
						theNotices.addAll(PanelEmploymentInfoContainer.newsAndTrends);
						theNotices.addAll(PanelEmploymentInfoContainer.noticeAndAnnouncement);
						theNotices.addAll(PanelEmploymentInfoContainer.hotRecruitment);
						theNotices.addAll(PanelEmploymentInfoContainer.policyInterpretation);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					for(NoticeContainer searchItem:theNotices){
						if(searchItem.getTitle().contains(str_search))
							searchResList.add(searchItem);
					}
		
					JPanel searchPanel = new PanelNotice(searchResList);
					ViewMain.changePanelTemplate(searchPanel);
				}
				else {
					JOptionPane.showMessageDialog(ViewMain.getFrame(),"请输入关键词", "警告", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		
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
