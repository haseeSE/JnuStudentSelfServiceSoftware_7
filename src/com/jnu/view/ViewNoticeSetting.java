package com.jnu.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.jnu.model.NoticeSetting;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViewNoticeSetting extends JFrame {

	private JPanel contentPane;

	public static boolean IsExisted = false;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewNoticeSetting frame = new ViewNoticeSetting();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ViewNoticeSetting(Component parent) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				IsExisted = false;
			}
		});
		
		setTitle("通知设置");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(391, 337);
		setLocationRelativeTo(parent);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox checkBox_schoolNotice = new JCheckBox("学校公告");
		checkBox_schoolNotice.setSelected(true);
		checkBox_schoolNotice.setBounds(50, 20, 133, 27);
		contentPane.add(checkBox_schoolNotice);
		
		JCheckBox checkBox_collegeNotice_humanities = new JCheckBox("人文学院通知");
		checkBox_collegeNotice_humanities.setBounds(200, 20, 133, 27);
		if (NoticeSetting.isCollegeNotice_humanities())
			checkBox_collegeNotice_humanities.setSelected(true);
		contentPane.add(checkBox_collegeNotice_humanities);
		
		JCheckBox checkBox_collegeNotcie_internationalBusiness = new JCheckBox("国商学院通知");
		checkBox_collegeNotcie_internationalBusiness.setBounds(200, 52, 133, 27);
		if (NoticeSetting.isCollegeNotice_internationalBusiness())
			checkBox_collegeNotcie_internationalBusiness.setSelected(true);
		contentPane.add(checkBox_collegeNotcie_internationalBusiness);
		
		JCheckBox checkBox_collegeNotice_translationStudies = new JCheckBox("翻译学院通知");
		checkBox_collegeNotice_translationStudies.setBounds(200, 84, 133, 27);
		if (NoticeSetting.isCollegeNotice_translationStudies())
			checkBox_collegeNotice_translationStudies.setSelected(true);
		contentPane.add(checkBox_collegeNotice_translationStudies);
		
		JCheckBox checkBox_collegeNotice_intelligentScienceAndEngineering = new JCheckBox("智科学院通知");
		checkBox_collegeNotice_intelligentScienceAndEngineering.setBounds(200, 116, 133, 27);
		if (NoticeSetting.isCollegeNotice_intelligentScienceAndEngineering())
			checkBox_collegeNotice_intelligentScienceAndEngineering.setSelected(true);
		contentPane.add(checkBox_collegeNotice_intelligentScienceAndEngineering);
		
		JCheckBox checkBox_collegeNotice_electricalEngineering = new JCheckBox("电工学院通知");
		checkBox_collegeNotice_electricalEngineering.setBounds(200, 148, 133, 27);
		if (NoticeSetting.isCollegeNotice_electricalEngineering())
			checkBox_collegeNotice_electricalEngineering.setSelected(true);
		contentPane.add(checkBox_collegeNotice_electricalEngineering);
		
		JCheckBox checkBox_packagingEngineering = new JCheckBox("包装学院通知");
		checkBox_packagingEngineering.setBounds(200, 180, 133, 27);
		if (NoticeSetting.isCollegeNotice_packagingEngineering())
			checkBox_packagingEngineering.setSelected(true);
		contentPane.add(checkBox_packagingEngineering);
		
		JCheckBox checkBox_academicAdministrationNotice = new JCheckBox("教务处通知");
		checkBox_academicAdministrationNotice.setSelected(true);
		checkBox_academicAdministrationNotice.setBounds(50, 52, 133, 27);
		contentPane.add(checkBox_academicAdministrationNotice);
		
		JCheckBox checkBox_newsAndTrends = new JCheckBox("新闻动态");
		checkBox_newsAndTrends.setSelected(true);
		checkBox_newsAndTrends.setBounds(50, 84, 133, 27);
		contentPane.add(checkBox_newsAndTrends);
		
		JCheckBox checkBox_noticeAndAnnouncement = new JCheckBox("通知公告");
		checkBox_noticeAndAnnouncement.setSelected(true);
		checkBox_noticeAndAnnouncement.setBounds(50, 116, 133, 27);
		contentPane.add(checkBox_noticeAndAnnouncement);
		
		JCheckBox checkBox_hotRecruitment = new JCheckBox("招聘热点");
		checkBox_hotRecruitment.setSelected(true);
		checkBox_hotRecruitment.setBounds(50, 148, 133, 27);
		contentPane.add(checkBox_hotRecruitment);
		
		JCheckBox checkBox_policyInterpretation = new JCheckBox("政策解读");
		checkBox_policyInterpretation.setSelected(true);
		checkBox_policyInterpretation.setBounds(50, 180, 133, 27);
		contentPane.add(checkBox_policyInterpretation);
		
		JButton button_OK = new JButton("确定");
		button_OK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {		
				if (checkBox_schoolNotice.isSelected())
					NoticeSetting.setSchoolNotice(true);
				else
					NoticeSetting.setSchoolNotice(false);
				if (checkBox_collegeNotice_humanities.isSelected())
					NoticeSetting.setCollegeNotice_humanities(true);
				else
					NoticeSetting.setCollegeNotice_humanities(false);
				if (checkBox_collegeNotcie_internationalBusiness.isSelected())
					NoticeSetting.setCollegeNotice_internationalBusiness(true);
				else
					NoticeSetting.setCollegeNotice_internationalBusiness(false);
				if (checkBox_collegeNotice_translationStudies.isSelected())
					NoticeSetting.setCollegeNotice_translationStudies(true);
				else
					NoticeSetting.setCollegeNotice_translationStudies(false);
				if (checkBox_collegeNotice_intelligentScienceAndEngineering.isSelected())
					NoticeSetting.setCollegeNotice_intelligentScienceAndEngineering(true);
				else
					NoticeSetting.setCollegeNotice_intelligentScienceAndEngineering(false);
				if (checkBox_collegeNotice_electricalEngineering.isSelected())
					NoticeSetting.setCollegeNotice_electricalEngineering(true);
				else
					NoticeSetting.setCollegeNotice_electricalEngineering(false);
				if (checkBox_packagingEngineering.isSelected())
					NoticeSetting.setCollegeNotice_packagingEngineering(true);
				else
					NoticeSetting.setCollegeNotice_packagingEngineering(false);
				if (checkBox_academicAdministrationNotice.isSelected())
					NoticeSetting.setAcademicAdministrationNotice(true);
				else
					NoticeSetting.setAcademicAdministrationNotice(false);
				if (checkBox_newsAndTrends.isSelected())
					NoticeSetting.setNewsAndTrends(true);
				else
					NoticeSetting.setNewsAndTrends(false);
				if (checkBox_noticeAndAnnouncement.isSelected())
					NoticeSetting.setNoticeAndAnnouncement(true);
				else
					NoticeSetting.setNoticeAndAnnouncement(false);
				if (checkBox_hotRecruitment.isSelected())
					NoticeSetting.setHotRecruitment(true);
				else
					NoticeSetting.setHotRecruitment(false);
				if (checkBox_policyInterpretation.isSelected())
					NoticeSetting.setPolicyInterpretation(true);
				else
					NoticeSetting.setPolicyInterpretation(false);
				
				// TODO add you code here
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				////////
				
				myClose();
				
			}
		});
		button_OK.setBounds(119, 233, 113, 27);
		contentPane.add(button_OK);
	}

	@Override
	public void setVisible(boolean b) {
		if(!IsExisted) {
			IsExisted = true;
			super.setVisible(b);
		}
	}
	
	public void myClose() {
//		this.dispose();
		IsExisted = false;
		ViewMain.getFrame().setEnabled(true);
		ViewMain.openMainMessage();
	}
}
