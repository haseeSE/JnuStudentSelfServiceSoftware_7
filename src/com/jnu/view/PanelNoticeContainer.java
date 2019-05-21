package com.jnu.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.jnu.model.NoticeContainer;
import com.jnu.model.NoticeDataCapture;
import com.jnu.model.UserManager;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

public class PanelNoticeContainer extends JPanel {

	/**
	 * Create the panel.
	 */
	JTabbedPane tab= new JTabbedPane(JTabbedPane.TOP);
	
	public PanelNoticeContainer() {
		super(new BorderLayout());
		//获取通知数据
		ArrayList<NoticeContainer> noticeList = new ArrayList<NoticeContainer>();
		
		//创建学校公告的ArrayList
		try {
			noticeList = NoticeDataCapture.addSchoolNotices();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel panel_school_notice = new PanelNotice(noticeList);
		
		//创建各学院通知的ArrayList
		int collegeType = -1;
		if(UserManager.getUser().get_college().contains("人文"))
			collegeType = 1;
		else if(UserManager.getUser().get_college().contains("翻译"))
			collegeType = 2;
		else if(UserManager.getUser().get_college().contains("包装"))
			collegeType = 3;
		try {
			noticeList = NoticeDataCapture.addCollegeNotices(collegeType);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JPanel panel_college_notice = new PanelNotice(noticeList);
		
		//创建教务处通知的ArrayList
		try {
			noticeList = NoticeDataCapture.addAcademicAdminstrationNotices();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel panel_academic_adminstration_notice = new PanelNotice(noticeList);
		
		tab.setFont(new Font("新宋体", Font.BOLD, 20));
		tab.setForeground(Color.BLACK);
		
		//往JTabbedPane添加Panel
		tab.add(panel_school_notice,"学校公告");
		tab.add(panel_college_notice,"学院通知");
		tab.add(panel_academic_adminstration_notice,"教务处通知");
		
		add(tab);
	}

}
