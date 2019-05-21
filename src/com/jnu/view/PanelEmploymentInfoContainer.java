package com.jnu.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.apache.log4j.Logger;

import com.jnu.view.PanelEmploymentInfo;
import com.jnu.view.PanelNotice;

public class PanelEmploymentInfoContainer extends JPanel {
	
	private Logger Log = Logger.getLogger(getClass());

	/**
	 * Create the panel.
	 */
	JTabbedPane tab= new JTabbedPane(JTabbedPane.TOP);
	
	public PanelEmploymentInfoContainer() {
		super(new BorderLayout());
		
		// <----------	LOG: CREATED	------------>
		Log.info("CREATED");
		
		//对象化面板
		JPanel panel_newsAndTrends = new PanelEmploymentInfo(1);
  
		JPanel panel_noticeAndAnnouncement = new PanelEmploymentInfo(2);
		
		JPanel panel_hotRecruitment = new PanelEmploymentInfo(3);
  
		JPanel panel_policyInterpretation = new PanelEmploymentInfo(4);

		tab.add(panel_newsAndTrends,"新闻动态");
        
		tab.add(panel_noticeAndAnnouncement,"通知公告");
		
		
		tab.add(panel_hotRecruitment,"招聘热点");
		
		
		tab.add(panel_policyInterpretation,"政策解读");
		add(tab);
		
	}



}
