package com.jnu.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingWorker;

import com.jnu.model.EmploymentInfoDataCapture;
import com.jnu.model.NoticeContainer;
import com.jnu.model.NoticeDataCapture;
import com.jnu.model.NoticeSetting;
import com.jnu.model.UserManager;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class PanelNoticeContainer extends JPanel {

	/**
	 * Create the panel.
	 */
	private static ArrayList<NoticeContainer> allNotices = new ArrayList<NoticeContainer>();
	private ArrayList<NoticeContainer> school_notice;
	private ArrayList<NoticeContainer> collegeNotice_humanities;
	private ArrayList<NoticeContainer> collegeNotice_internationalBusiness;
	private ArrayList<NoticeContainer> collegeNotice_translationStudies;
	private ArrayList<NoticeContainer> collegeNotice_intelligentScienceAndEngineering;
	private ArrayList<NoticeContainer> collegeNotice_electricalEngineering;
	private ArrayList<NoticeContainer> collegeNotice_packagingEngineering;
	private ArrayList<NoticeContainer> academicAdminstration_notice;
	private ArrayList<NoticeContainer> newsAndTrends;
	private ArrayList<NoticeContainer> noticeAndAnnouncement;
	private ArrayList<NoticeContainer> hotRecruitment;
	private ArrayList<NoticeContainer> policyInterpretation;
	
	JTabbedPane tab= new JTabbedPane(JTabbedPane.TOP);
	
	private JPanel panel_school_notice;
	private JPanel panel_collegeNotice_internationalBusiness;
	private JPanel panel_collegeNotice_humanities;
	private JPanel panel_collegeNotice_translationStudies;
	private JPanel panel_collegeNotice_intelligentScienceAndEngineering;
	private JPanel panel_collegeNotice_electricalEngineering;
	private JPanel panel_collegeNotice_packagingEngineering;
	private JPanel panel_academic_adminstration_notice;
	private JPanel panel_newsAndTrends;
	private JPanel panel_noticeAndAnnouncement;
	private JPanel panel_hotRecruitment;
	private JPanel panel_policyInterpretation;

	
	private static SwingWorker<ArrayList<NoticeContainer>, String> baseNotices = null;
	private static SwingWorker<ArrayList<NoticeContainer>, String> collegeNotices = null;
	private static SwingWorker<ArrayList<NoticeContainer>, String> employmentInfoNotices = null;
	
	public PanelNoticeContainer() {
		super(new BorderLayout());
		
		initData();
		
		tab.setFont(new Font("新宋体", Font.BOLD, 20));
		tab.setForeground(Color.BLACK);
		
		//往JTabbedPane添加Panel
		
		if(NoticeSetting.isSchoolNotice())
			tab.add(panel_school_notice,"学校公告");
		if(NoticeSetting.isAcademicAdministrationNotice())
			tab.add(panel_academic_adminstration_notice,"教务处通知");
		if(NoticeSetting.isCollegeNotice_internationalBusiness())
			tab.add(panel_collegeNotice_internationalBusiness,"国商通知");
		if(NoticeSetting.isCollegeNotice_humanities())
			tab.add(panel_collegeNotice_humanities,"人文通知");
		if(NoticeSetting.isCollegeNotice_translationStudies())
			tab.add(panel_collegeNotice_translationStudies,"翻译通知");
		if(NoticeSetting.isCollegeNotice_intelligentScienceAndEngineering())
			tab.add(panel_collegeNotice_intelligentScienceAndEngineering,"智科通知");
		if(NoticeSetting.isCollegeNotice_intelligentScienceAndEngineering())
			tab.add(panel_collegeNotice_electricalEngineering,"电工通知");
		if(NoticeSetting.isCollegeNotice_packagingEngineering())
			tab.add(panel_collegeNotice_packagingEngineering,"包装通知");
		if(NoticeSetting.isNewsAndTrends())
			tab.add(panel_newsAndTrends,"新闻动态");
		if(NoticeSetting.isNoticeAndAnnouncement())
			tab.add(panel_noticeAndAnnouncement,"通知公告");
		if(NoticeSetting.isHotRecruitment())
			tab.add(panel_hotRecruitment,"招聘热点");
		if(NoticeSetting.isPolicyInterpretation())
			tab.add(panel_policyInterpretation,"政策解读");
		
		
		add(tab);
		
		addpanel_base();
		baseNotices.execute();
		addpanel_college();
		collegeNotices.execute();
		addpanel_employmentInfo();
		employmentInfoNotices.execute();
	}
	
	

	private void addpanel_base(){
		baseNotices = new SwingWorker<ArrayList<NoticeContainer>,String>(){

			@Override
			protected ArrayList<NoticeContainer> doInBackground() throws Exception {
				// TODO Auto-generated method stub
				//创建学校公告的ArrayList
				if(NoticeSetting.isSchoolNotice())
					try {
						school_notice = NoticeDataCapture.addSchoolNotices();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				//创建教务处通知的ArrayList
				try {
					academicAdminstration_notice = NoticeDataCapture.addAcademicAdminstrationNotices();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
			
			protected void done(){
				((PanelNotice) panel_school_notice).addData(school_notice);
				allNotices.addAll(school_notice);
				((PanelNotice) panel_academic_adminstration_notice).addData(academicAdminstration_notice);
				allNotices.addAll(school_notice);
			}
			
		};
	}
	
	private void addpanel_college(){
		collegeNotices = new SwingWorker<ArrayList<NoticeContainer>,String>(){

			@Override
			protected ArrayList<NoticeContainer> doInBackground() throws Exception {
				// TODO Auto-generated method stub
				//创建各学院通知的ArrayList
				try {
					if(NoticeSetting.isCollegeNotice_internationalBusiness())
						collegeNotice_internationalBusiness = NoticeDataCapture.addCollegeNotices(4);
					if(NoticeSetting.isCollegeNotice_humanities())
						collegeNotice_humanities = NoticeDataCapture.addCollegeNotices(1);
					if(NoticeSetting.isCollegeNotice_translationStudies())
						collegeNotice_translationStudies = NoticeDataCapture.addCollegeNotices(2);
					if(NoticeSetting.isCollegeNotice_intelligentScienceAndEngineering())
						collegeNotice_intelligentScienceAndEngineering = NoticeDataCapture.addCollegeNotices(5);
					if(NoticeSetting.isCollegeNotice_electricalEngineering())
						collegeNotice_electricalEngineering = NoticeDataCapture.addCollegeNotices(6);
					if(NoticeSetting.isCollegeNotice_packagingEngineering())
						collegeNotice_packagingEngineering = NoticeDataCapture.addCollegeNotices(3);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}
			
			protected void done(){
				if(NoticeSetting.isCollegeNotice_internationalBusiness()){
					((PanelNotice) panel_collegeNotice_internationalBusiness).addData(collegeNotice_internationalBusiness);
					allNotices.addAll(collegeNotice_internationalBusiness);
				}
				if(NoticeSetting.isCollegeNotice_humanities()){
					((PanelNotice) panel_collegeNotice_humanities).addData(collegeNotice_humanities);
					allNotices.addAll(collegeNotice_humanities);
				}
				if(NoticeSetting.isCollegeNotice_translationStudies()){
					((PanelNotice) panel_collegeNotice_translationStudies).addData(collegeNotice_translationStudies);
					allNotices.addAll(collegeNotice_translationStudies);
				}	
				if(NoticeSetting.isCollegeNotice_intelligentScienceAndEngineering()){
					((PanelNotice) panel_collegeNotice_intelligentScienceAndEngineering).addData(collegeNotice_intelligentScienceAndEngineering);
					allNotices.addAll(collegeNotice_intelligentScienceAndEngineering);
				}
				if(NoticeSetting.isCollegeNotice_electricalEngineering()){
					((PanelNotice) panel_collegeNotice_electricalEngineering).addData(collegeNotice_electricalEngineering);
					allNotices.addAll(collegeNotice_electricalEngineering);
				}
				if(NoticeSetting.isCollegeNotice_packagingEngineering()){
					((PanelNotice) panel_collegeNotice_packagingEngineering).addData(collegeNotice_packagingEngineering);
					allNotices.addAll(collegeNotice_packagingEngineering);
				}
			}
			
		};
	}
	
	private void addpanel_employmentInfo(){
		employmentInfoNotices = new SwingWorker<ArrayList<NoticeContainer>,String>(){

			@Override
			protected ArrayList<NoticeContainer> doInBackground() throws Exception {
				// TODO Auto-generated method stub
				//创建各学院通知的ArrayList
				try {
					if(NoticeSetting.isNewsAndTrends())
						newsAndTrends = EmploymentInfoDataCapture.initializeNewsAndTrends();
					if(NoticeSetting.isNoticeAndAnnouncement())
						noticeAndAnnouncement = EmploymentInfoDataCapture.initializeNoticeAndAnnouncement();
					if(NoticeSetting.isHotRecruitment())
						hotRecruitment = EmploymentInfoDataCapture.initializeHotRecruitment();
					if(NoticeSetting.isPolicyInterpretation())
						policyInterpretation = EmploymentInfoDataCapture.initializePolicyInterpretation();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}
			
			protected void done(){
				if(NoticeSetting.isNewsAndTrends()){
					((PanelNotice) panel_newsAndTrends).addData(newsAndTrends);
					allNotices.addAll(newsAndTrends);
				}
				if(NoticeSetting.isNoticeAndAnnouncement()){
					((PanelNotice) panel_noticeAndAnnouncement).addData(noticeAndAnnouncement);
					allNotices.addAll(noticeAndAnnouncement);
				}
				if(NoticeSetting.isHotRecruitment()){
					((PanelNotice) panel_hotRecruitment).addData(hotRecruitment);
					allNotices.addAll(hotRecruitment);
				}
				if(NoticeSetting.isPolicyInterpretation()){
					((PanelNotice) panel_policyInterpretation).addData(policyInterpretation);
					allNotices.addAll(policyInterpretation);
				}
			}
			
		};
	}
	
	private void initData(){
		allNotices.clear();
		
		panel_school_notice = new PanelNotice();
		panel_academic_adminstration_notice = new PanelNotice();
		
		panel_collegeNotice_internationalBusiness = new PanelNotice();
		panel_collegeNotice_humanities = new PanelNotice();
		panel_collegeNotice_translationStudies = new PanelNotice();
		panel_collegeNotice_intelligentScienceAndEngineering = new PanelNotice();
		panel_collegeNotice_electricalEngineering = new PanelNotice();
		panel_collegeNotice_packagingEngineering = new PanelNotice();

		panel_newsAndTrends = new PanelNotice();
		panel_noticeAndAnnouncement = new PanelNotice();
		panel_hotRecruitment = new PanelNotice();
		panel_policyInterpretation = new PanelNotice();
		
		//*****************************************************
		school_notice = new ArrayList<NoticeContainer>();
		collegeNotice_humanities = new ArrayList<NoticeContainer>();
		collegeNotice_internationalBusiness = new ArrayList<NoticeContainer>();
		collegeNotice_translationStudies = new ArrayList<NoticeContainer>();
		collegeNotice_intelligentScienceAndEngineering = new ArrayList<NoticeContainer>();
		collegeNotice_electricalEngineering = new ArrayList<NoticeContainer>();
		collegeNotice_packagingEngineering = new ArrayList<NoticeContainer>();
		academicAdminstration_notice = new ArrayList<NoticeContainer>();
		newsAndTrends = new ArrayList<NoticeContainer>();
		noticeAndAnnouncement = new ArrayList<NoticeContainer>();
		hotRecruitment = new ArrayList<NoticeContainer>();
		policyInterpretation = new ArrayList<NoticeContainer>();
	}
	
	public static ArrayList<NoticeContainer> getAllNotices(){
		return allNotices;
	}
	
}
