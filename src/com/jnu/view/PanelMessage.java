package com.jnu.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import org.apache.log4j.Logger;

import com.jnu.model.NoticeCollection;
import com.jnu.model.NoticeContainer;
import com.jnu.model.NoticeSetting;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/*
 * created by fengsijian;
 */

public class PanelMessage extends JPanel {
	private Logger Log = Logger.getLogger(getClass());

	/**
	 * Create the panel.
	 */
	public PanelMessage() {
		// <----------	LOG: CREATED	------------>
		Log.info("CREATED");
		
		setSubMessage();
		
		// TODO		
		JPanel panel_notice_container = new PanelNoticeContainer();
		panel_notice_container.setBounds(34, 30, 630, 412);
		add(panel_notice_container);
		
		JCheckBox checkBox_collegeNotice_humanities = new JCheckBox("人文学院");
		checkBox_collegeNotice_humanities.setBounds(60, 451, 90, 27);
		if (NoticeSetting.isCollegeNotice_humanities())
			checkBox_collegeNotice_humanities.setSelected(true);
		checkBox_collegeNotice_humanities.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean selected = checkBox_collegeNotice_humanities.isSelected();
				if (selected == true)
				{
					NoticeSetting.setCollegeNotice_humanities(true);
					ViewMain.openMainMessage();
				}
				else
				{
					NoticeSetting.setCollegeNotice_humanities(false);
					ViewMain.openMainMessage();
				}
			}
		});
		add(checkBox_collegeNotice_humanities);
		
		JCheckBox checkBox_collegeNotcie_internationalBusiness = new JCheckBox("国商学院");
		checkBox_collegeNotcie_internationalBusiness.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean selected = checkBox_collegeNotcie_internationalBusiness.isSelected();
				if (selected == true)
					{
					NoticeSetting.setCollegeNotice_internationalBusiness(true);
					ViewMain.openMainMessage();
					}
				else
					{
					NoticeSetting.setCollegeNotice_internationalBusiness(false);
					ViewMain.openMainMessage();
					}
			}
		});
		checkBox_collegeNotcie_internationalBusiness.setBounds(160, 451, 90, 27);
		if (NoticeSetting.isCollegeNotice_internationalBusiness())
			checkBox_collegeNotcie_internationalBusiness.setSelected(true);
		add(checkBox_collegeNotcie_internationalBusiness);
		
		JCheckBox checkBox_collegeNotice_translationStudies = new JCheckBox("翻译学院");
		checkBox_collegeNotice_translationStudies.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean selected = checkBox_collegeNotice_translationStudies.isSelected();
				if (selected == true)
				{
					NoticeSetting.setCollegeNotice_translationStudies(true);
					ViewMain.openMainMessage();
				}
				else
				{
					NoticeSetting.setCollegeNotice_translationStudies(false);
					ViewMain.openMainMessage();
				}
			}
		});
		checkBox_collegeNotice_translationStudies.setBounds(260, 451, 90, 27);
		if (NoticeSetting.isCollegeNotice_translationStudies())
			checkBox_collegeNotice_translationStudies.setSelected(true);
		add(checkBox_collegeNotice_translationStudies);
		
		JCheckBox checkBox_collegeNotice_intelligentScienceAndEngineering = new JCheckBox("智科学院");
		checkBox_collegeNotice_intelligentScienceAndEngineering.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean selected = checkBox_collegeNotice_intelligentScienceAndEngineering.isSelected();
				if (selected == true)
				{
					NoticeSetting.setCollegeNotice_intelligentScienceAndEngineering(true);
					ViewMain.openMainMessage();
				}
				else
				{
					NoticeSetting.setCollegeNotice_intelligentScienceAndEngineering(false);
					ViewMain.openMainMessage();
				}
			}
		});
		checkBox_collegeNotice_intelligentScienceAndEngineering.setBounds(360, 451, 90, 27);
		if (NoticeSetting.isCollegeNotice_intelligentScienceAndEngineering())
			checkBox_collegeNotice_intelligentScienceAndEngineering.setSelected(true);
		add(checkBox_collegeNotice_intelligentScienceAndEngineering);
		
		JCheckBox checkBox_collegeNotice_electricalEngineering = new JCheckBox("电工学院");
		checkBox_collegeNotice_electricalEngineering.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean selected = checkBox_collegeNotice_electricalEngineering.isSelected();
				if (selected == true)
				{
					NoticeSetting.setCollegeNotice_electricalEngineering(true);
					ViewMain.openMainMessage();		
				}
				else
				{
					NoticeSetting.setCollegeNotice_electricalEngineering(false);
					ViewMain.openMainMessage();
				}
			}
		});
		checkBox_collegeNotice_electricalEngineering.setBounds(460, 451, 90, 27);
		if (NoticeSetting.isCollegeNotice_electricalEngineering())
			checkBox_collegeNotice_electricalEngineering.setSelected(true);
		add(checkBox_collegeNotice_electricalEngineering);
		
		JCheckBox checkBox_packagingEngineering = new JCheckBox("包装学院");
		checkBox_packagingEngineering.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean selected = checkBox_packagingEngineering.isSelected();
				if (selected == true)
				{
					NoticeSetting.setCollegeNotice_packagingEngineering(true);
					ViewMain.openMainMessage();
				}
				else
				{
					NoticeSetting.setCollegeNotice_packagingEngineering(false);
					ViewMain.openMainMessage();
				}
			}
		});
		checkBox_packagingEngineering.setBounds(560, 451, 90, 27);
		if (NoticeSetting.isCollegeNotice_packagingEngineering())
			checkBox_packagingEngineering.setSelected(true);
		add(checkBox_packagingEngineering);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(360, 4, 90, 24);
		comboBox.addItem("--------");
		comboBox.addItem("校内通知");
		comboBox.addItem("新浪新闻");
		comboBox.addItem("就业信息");
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int index = comboBox.getSelectedIndex();
				switch (index) {
				case 1:
					PanelNoticeContainer.change(0);
					ViewMain.openMainMessage();
					break;
				case 2:
					PanelNoticeContainer.change(1);
					ViewMain.openMainMessage();
					break;
				case 3:
					PanelNoticeContainer.change(2);
					ViewMain.openMainMessage();
					break;
				}
			}
		});
		add(comboBox);
		
		JButton btn_update = new JButton("更新");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				NoticeCollection noticeCollection_internationalBusiness = new NoticeCollection("internationalBusiness");
				NoticeCollection noticeCollection_humanities = new NoticeCollection("humanities");
				NoticeCollection noticeCollection_translationStudies = new NoticeCollection("translationStudies");
				NoticeCollection noticeCollection_packagingEngineering = new NoticeCollection("packagingEngineering");
				NoticeCollection noticeCollection_newsAndTrends = new NoticeCollection("newsAndTrends");
				NoticeCollection noticeCollection_noticeAndAnnouncement = new NoticeCollection("noticeAndAnnouncement");
				NoticeCollection noticeCollection_hotRecruitment = new NoticeCollection("hotRecruitment");
				NoticeCollection noticeCollection_policyInterpretation = new NoticeCollection("policyInterpretation");
				ArrayList<NoticeContainer> newlist = new ArrayList<NoticeContainer>();
				
				
				noticeCollection_internationalBusiness.save(newlist);
				noticeCollection_humanities.save(newlist);
				noticeCollection_translationStudies.save(newlist);
				noticeCollection_packagingEngineering.save(newlist);
				noticeCollection_newsAndTrends.save(newlist);
				noticeCollection_noticeAndAnnouncement.save(newlist);
				noticeCollection_hotRecruitment.save(newlist);
				noticeCollection_policyInterpretation.save(newlist);
				
				ViewMain.openMainMessage();
			}
		});
		btn_update.setBounds(551, 3, 113, 27);
		add(btn_update);

	}

	// Insert Sub Message Panel;
	private void setSubMessage() {
		setLayout(null);
		// TODO Auto-generated method stub
		JPanel panel_subMessage = new PanelSubMessage();
		panel_subMessage.setBounds(668, 27, 330, 352);
		add(panel_subMessage);
		
		

//		panel_subMessage.removeAll();
//		panel_subMessage.add(new PanelSubMessage(), BorderLayout.CENTER);
//		panel_subMessage.updateUI();
//		
	}
}
