package com.jnu.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Font;

public class PanelNoticeContainer extends JPanel {

	/**
	 * Create the panel.
	 */
	JTabbedPane tab= new JTabbedPane(JTabbedPane.TOP);
	
	public PanelNoticeContainer() {
		super(new BorderLayout());
		//往JTabbedPane添加Panel
		JPanel panel_school_notice = new PanelNotice();
		JPanel panel_college_notice = new PanelNotice();
		JPanel panel_academic_adminstration_notice = new PanelNotice();
		tab.setFont(new Font("新宋体", Font.BOLD, 20));
		tab.setForeground(Color.BLACK);
		
		tab.add(panel_school_notice,"学校公告");
		tab.add(panel_college_notice,"学院通知");
		tab.add(panel_academic_adminstration_notice,"教务处通知");
		
		add(tab);
	}

}
