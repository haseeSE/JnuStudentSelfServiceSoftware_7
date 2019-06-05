package com.jnu.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.apache.log4j.Logger;

import com.jnu.model.EmploymentInfoDataCapture;
import com.jnu.model.NoticeContainer;
import com.jnu.view.PanelEmploymentInfo;
import com.jnu.view.PanelNotice;

public class PanelEmploymentInfoContainer extends JPanel {
	
	private Logger Log = Logger.getLogger(getClass());

	/**
	 * Create the panel.
	 */
	JTabbedPane tab= new JTabbedPane(JTabbedPane.TOP);
	public static ArrayList<NoticeContainer> newsAndTrends;
	public static ArrayList<NoticeContainer> noticeAndAnnouncement;
	public static ArrayList<NoticeContainer> hotRecruitment;
	public static ArrayList<NoticeContainer> policyInterpretation;
	
	public PanelEmploymentInfoContainer() {
		super(new BorderLayout());
		
		// <----------	LOG: CREATED	------------>
		Log.info("CREATED");
		
		newsAndTrends = new ArrayList<NoticeContainer>();
		noticeAndAnnouncement = new ArrayList<NoticeContainer>();
		hotRecruitment = new ArrayList<NoticeContainer>();
		policyInterpretation = new ArrayList<NoticeContainer>();
		
		//获取各个版块的ArrayList
		try {
			newsAndTrends = EmploymentInfoDataCapture.initializeNewsAndTrends();
			noticeAndAnnouncement = EmploymentInfoDataCapture.initializeNoticeAndAnnouncement();
			hotRecruitment = EmploymentInfoDataCapture.initializeHotRecruitment();
			policyInterpretation = EmploymentInfoDataCapture.initializePolicyInterpretation();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//对象化面板
		JPanel panel_newsAndTrends = new PanelEmploymentInfo(newsAndTrends);
  
		JPanel panel_noticeAndAnnouncement = new PanelEmploymentInfo(noticeAndAnnouncement);
		
		JPanel panel_hotRecruitment = new PanelEmploymentInfo(hotRecruitment);
  
		JPanel panel_policyInterpretation = new PanelEmploymentInfo(policyInterpretation);

		tab.add(panel_newsAndTrends,"新闻动态");
        
		tab.add(panel_noticeAndAnnouncement,"通知公告");
		
		
		tab.add(panel_hotRecruitment,"招聘热点");
		
		
		tab.add(panel_policyInterpretation,"政策解读");
		add(tab);
		
	}



}
