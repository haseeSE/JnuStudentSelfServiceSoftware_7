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
	public static ArrayList<NoticeContainer> school_notice = new ArrayList<NoticeContainer>();
	public static ArrayList<NoticeContainer> college_notice = new ArrayList<NoticeContainer>();
	public static ArrayList<NoticeContainer> academicAdminstration_notice = new ArrayList<NoticeContainer>();
	
	
	public PanelNoticeContainer() {
		super(new BorderLayout());
		//获取通知数据
		
		//创建学校公告的ArrayList
		if(school_notice.size()==0){
			try {
				school_notice = NoticeDataCapture.addSchoolNotices();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		JPanel panel_school_notice = new PanelNotice(school_notice);
		
		//创建各学院通知的ArrayList
		if(college_notice.size()==0||college_notice.size()==1&&college_notice.get(0).getDate()==null){
			int collegeType = -1;
			if(UserManager.getUser().get_college().contains("人文"))
				collegeType = 1;
			else if(UserManager.getUser().get_college().contains("翻译"))
				collegeType = 2;
			else if(UserManager.getUser().get_college().contains("包装"))
				collegeType = 3;
			try {
				college_notice = NoticeDataCapture.addCollegeNotices(collegeType);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		JPanel panel_college_notice = new PanelNotice(college_notice);
		
		//创建教务处通知的ArrayList
		if(academicAdminstration_notice.size()==0){
			try {
				academicAdminstration_notice = NoticeDataCapture.addAcademicAdminstrationNotices();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		JPanel panel_academic_adminstration_notice = new PanelNotice(academicAdminstration_notice);
		
		tab.setFont(new Font("新宋体", Font.BOLD, 20));
		tab.setForeground(Color.BLACK);
		
		//往JTabbedPane添加Panel
		tab.add(panel_school_notice,"学校公告");
		tab.add(panel_college_notice,"学院通知");
		tab.add(panel_academic_adminstration_notice,"教务处通知");
		
		add(tab);
	}

}
