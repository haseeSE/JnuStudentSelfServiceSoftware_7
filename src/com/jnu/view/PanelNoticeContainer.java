package com.jnu.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingWorker;

import com.jnu.model.EmploymentInfoDataCapture;
import com.jnu.model.NoticeCollection;
import com.jnu.model.NoticeContainer;
import com.jnu.model.NoticeDataCapture;
import com.jnu.model.NoticeSetting;
import com.jnu.model.UserManager;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class PanelNoticeContainer extends JPanel {
	private final static int STUDENT = 1;
	private final static int TEACHER = 2;
	private final static int NEWS = 1;
	private final static int NOTICES = 2;
	
	private static enum NoticeStatus {
		SCHOOL, EMPLOYMENT, SINA
	};
	private static NoticeStatus notice_Status = NoticeStatus.SCHOOL;
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
	private ArrayList<NoticeContainer> sinalist;
	
	private static JPanel panel_notice;


	
	private static SwingWorker<ArrayList<NoticeContainer>, String> baseNotices = null;
	private static SwingWorker<ArrayList<NoticeContainer>, String> collegeNotices1 = null;
	private static SwingWorker<ArrayList<NoticeContainer>, String> collegeNotices2 = null;
	private static SwingWorker<ArrayList<NoticeContainer>, String> collegeNotices3 = null;
	private static SwingWorker<ArrayList<NoticeContainer>, String> collegeNotices4 = null;
	private static SwingWorker<ArrayList<NoticeContainer>, String> employmentInfoNotices1 = null;
	private static SwingWorker<ArrayList<NoticeContainer>, String> employmentInfoNotices2 = null;
	private static SwingWorker<ArrayList<NoticeContainer>, String> employmentInfoNotices3 = null;
	private static SwingWorker<ArrayList<NoticeContainer>, String> employmentInfoNotices4 = null;
	private static SwingWorker<ArrayList<NoticeContainer>, String> sina = null;
	
	public PanelNoticeContainer() {
		super(new BorderLayout());
		
		initData();				//初始化数组

		
//		if(NoticeSetting.isSchoolNotice())
//			
//		if(NoticeSetting.isAcademicAdministrationNotice())
//			
//		if(NoticeSetting.isCollegeNotice_internationalBusiness())
//			
//		if(NoticeSetting.isCollegeNotice_humanities())
//			
//		if(NoticeSetting.isCollegeNotice_translationStudies())
//			
//		if(NoticeSetting.isCollegeNotice_intelligentScienceAndEngineering())
//		
//		if(NoticeSetting.isCollegeNotice_intelligentScienceAndEngineering())
//	
//		if(NoticeSetting.isCollegeNotice_packagingEngineering())
//		
//		if(NoticeSetting.isNewsAndTrends())
//
//		if(NoticeSetting.isNoticeAndAnnouncement())
//		
//		if(NoticeSetting.isHotRecruitment())
//	
//		if(NoticeSetting.isPolicyInterpretation())
//	
		
		add(panel_notice);
		
/*		addData_base();
		baseNotices.execute();*/
		if(notice_Status==NoticeStatus.SCHOOL){
			addData_college();
			collegeNotices1.execute();
			collegeNotices2.execute();
			collegeNotices3.execute();
			collegeNotices4.execute();
		}
		if(notice_Status==NoticeStatus.SINA){
			addData_sina();
			sina.execute();
		}
			
		if(notice_Status==NoticeStatus.EMPLOYMENT){
			addData_employmentInfo();
			employmentInfoNotices1.execute();
			employmentInfoNotices2.execute();
			employmentInfoNotices3.execute();
			employmentInfoNotices4.execute();
		}
		
	}
	
	

	private void addData_base(){
		baseNotices = new SwingWorker<ArrayList<NoticeContainer>,String>(){

			@Override
			protected ArrayList<NoticeContainer> doInBackground() throws Exception {
				// TODO Auto-generated method stub
				try {
					//创建学校公告的ArrayList
					if(NoticeSetting.isSchoolNotice())
						school_notice = NoticeDataCapture.addSchoolNotices(1);
					//创建教务处通知的ArrayList
					if(NoticeSetting.isAcademicAdministrationNotice())
						academicAdminstration_notice = NoticeDataCapture.addAcademicAdminstrationNotices();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
			
			protected void done(){
//				((PanelNotice) panel_notice).addData(school_notice,"学校");
				allNotices.addAll(school_notice);
//				((PanelNotice) panel_notice).addData(academicAdminstration_notice,"教务处");
				allNotices.addAll(school_notice);
				
				updateData();
			}
			
		};
	}
	
	private void addData_college(){
		collegeNotices1 = new SwingWorker<ArrayList<NoticeContainer>,String>(){

			@Override
			protected ArrayList<NoticeContainer> doInBackground() throws Exception {
				// TODO Auto-generated method stub
				//创建各学院通知的ArrayList
				NoticeCollection noticeCollection_internationalBusiness = new NoticeCollection("internationalBusiness");
				try {
					if(NoticeSetting.isCollegeNotice_internationalBusiness()){
						collegeNotice_internationalBusiness = noticeCollection_internationalBusiness.load();
						if(collegeNotice_internationalBusiness.size()==0){
							collegeNotice_internationalBusiness.addAll(NoticeDataCapture.addInternationalBusiness(NEWS));
							collegeNotice_internationalBusiness.addAll(NoticeDataCapture.addInternationalBusiness(NOTICES));
							noticeCollection_internationalBusiness.save(collegeNotice_internationalBusiness);
						}
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}
			
			protected void done(){
				if(NoticeSetting.isCollegeNotice_internationalBusiness()){
//					((PanelNotice) panel_notice).addData(collegeNotice_internationalBusiness,"国商");
					allNotices.addAll(collegeNotice_internationalBusiness);
				}
				updateData();
			}
			
		};
		
		collegeNotices2 = new SwingWorker<ArrayList<NoticeContainer>,String>(){

			@Override
			protected ArrayList<NoticeContainer> doInBackground() throws Exception {
				// TODO Auto-generated method stub
				//创建各学院通知的ArrayList
				NoticeCollection noticeCollection_humanities = new NoticeCollection("humanities");
				try {
					if(NoticeSetting.isCollegeNotice_humanities()){
						collegeNotice_humanities = noticeCollection_humanities.load();
						if(collegeNotice_humanities.size()==0){
							collegeNotice_humanities.addAll(NoticeDataCapture.addHumanities(NEWS));
							collegeNotice_humanities.addAll(NoticeDataCapture.addHumanities(NOTICES));
							noticeCollection_humanities.save(collegeNotice_humanities);
						}
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}
			
			protected void done(){

				if(NoticeSetting.isCollegeNotice_humanities()){
//					((PanelNotice) panel_notice).addData(collegeNotice_humanities,"人文");
					allNotices.addAll(collegeNotice_humanities);
				}
				updateData();
			}
			
		};
		
		collegeNotices3 = new SwingWorker<ArrayList<NoticeContainer>,String>(){

			@Override
			protected ArrayList<NoticeContainer> doInBackground() throws Exception {
				// TODO Auto-generated method stub
				//创建各学院通知的ArrayList
				NoticeCollection noticeCollection_translationStudies = new NoticeCollection("translationStudies");
				try {	
					if(NoticeSetting.isCollegeNotice_translationStudies()){
						collegeNotice_translationStudies = noticeCollection_translationStudies.load();
						if(collegeNotice_translationStudies.size()==0){
							collegeNotice_translationStudies.addAll(NoticeDataCapture.addTranslationStudies(NEWS));
							collegeNotice_translationStudies.addAll(NoticeDataCapture.addTranslationStudies(NOTICES));
							noticeCollection_translationStudies.save(collegeNotice_translationStudies);
						}
					}
						
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}
			
			protected void done(){
	
				if(NoticeSetting.isCollegeNotice_translationStudies()){
//					((PanelNotice) panel_notice).addData(collegeNotice_translationStudies,"翻译");
					allNotices.addAll(collegeNotice_translationStudies);
				}	
				updateData();
			}
			
		};
		
		collegeNotices4 = new SwingWorker<ArrayList<NoticeContainer>,String>(){

			@Override
			protected ArrayList<NoticeContainer> doInBackground() throws Exception {
				// TODO Auto-generated method stub
				//创建各学院通知的ArrayList
				NoticeCollection noticeCollection_packagingEngineering = new NoticeCollection("packagingEngineering");
				try {
					
					if(NoticeSetting.isCollegeNotice_packagingEngineering()){
						collegeNotice_packagingEngineering = noticeCollection_packagingEngineering.load();
						if(collegeNotice_packagingEngineering.size()==0){
							collegeNotice_packagingEngineering.addAll(NoticeDataCapture.addPackagingEngineering(NEWS));
							collegeNotice_packagingEngineering.addAll(NoticeDataCapture.addPackagingEngineering(NOTICES));
							noticeCollection_packagingEngineering.save(collegeNotice_packagingEngineering);
						}
					}
						
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}
			
			protected void done(){
				if(NoticeSetting.isCollegeNotice_packagingEngineering()){
//					((PanelNotice) panel_notice).addData(collegeNotice_packagingEngineering,"包装");
					allNotices.addAll(collegeNotice_packagingEngineering);
				}
				
				updateData();
			}
			
		};
		
		
	}
	
	private void addData_employmentInfo(){
		employmentInfoNotices1 = new SwingWorker<ArrayList<NoticeContainer>,String>(){

			@Override
			protected ArrayList<NoticeContainer> doInBackground() throws Exception {
				// TODO Auto-generated method stub
				//创建各学院通知的ArrayList
				NoticeCollection noticeCollection_newsAndTrends = new NoticeCollection("newsAndTrends");
				try {
					if(NoticeSetting.isNewsAndTrends()){
						newsAndTrends = noticeCollection_newsAndTrends.load();
						if(newsAndTrends.size()==0){
							newsAndTrends = EmploymentInfoDataCapture.initializeNewsAndTrends();
							noticeCollection_newsAndTrends.save(newsAndTrends);
						}
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}
			
			protected void done(){
				if(NoticeSetting.isNewsAndTrends()){
//					((PanelNotice) panel_notice).addData(newsAndTrends,"新闻动态");
					allNotices.addAll(newsAndTrends);
				}			
				updateData();
			}
			
		};
		
		employmentInfoNotices2 = new SwingWorker<ArrayList<NoticeContainer>,String>(){

			@Override
			protected ArrayList<NoticeContainer> doInBackground() throws Exception {
				// TODO Auto-generated method stub
				//创建各学院通知的ArrayList
				NoticeCollection noticeCollection_noticeAndAnnouncement = new NoticeCollection("noticeAndAnnouncement");
				try {
					if(NoticeSetting.isNoticeAndAnnouncement()){
						noticeAndAnnouncement = noticeCollection_noticeAndAnnouncement.load();
						if(noticeAndAnnouncement.size()==0){
							noticeAndAnnouncement = EmploymentInfoDataCapture.initializeNoticeAndAnnouncement();
							noticeCollection_noticeAndAnnouncement.save(noticeAndAnnouncement);
						}
					}			
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}
			
			protected void done(){
				if(NoticeSetting.isNoticeAndAnnouncement()){
//					((PanelNotice) panel_notice).addData(noticeAndAnnouncement,"通知公告");
					allNotices.addAll(noticeAndAnnouncement);
				}
				updateData();
			}
			
		};
		
		employmentInfoNotices3 = new SwingWorker<ArrayList<NoticeContainer>,String>(){

			@Override
			protected ArrayList<NoticeContainer> doInBackground() throws Exception {
				// TODO Auto-generated method stub
				//创建各学院通知的ArrayList
				NoticeCollection noticeCollection_hotRecruitment = new NoticeCollection("hotRecruitment");
				try {
					if(NoticeSetting.isHotRecruitment()){
						hotRecruitment = noticeCollection_hotRecruitment.load();
						if(hotRecruitment.size()==0){
							hotRecruitment = EmploymentInfoDataCapture.initializeHotRecruitment();
							noticeCollection_hotRecruitment.save(hotRecruitment);
						}
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}
			
			protected void done(){
				if(NoticeSetting.isHotRecruitment()){
//					((PanelNotice) panel_notice).addData(hotRecruitment,"招聘热点");
					allNotices.addAll(hotRecruitment);
				}
				updateData();
			}
			
		};
		
		employmentInfoNotices4 = new SwingWorker<ArrayList<NoticeContainer>,String>(){

			@Override
			protected ArrayList<NoticeContainer> doInBackground() throws Exception {
				// TODO Auto-generated method stub
				//创建各学院通知的ArrayList
				NoticeCollection noticeCollection_policyInterpretation = new NoticeCollection("policyInterpretation");
				try {
					if(NoticeSetting.isPolicyInterpretation()){
						policyInterpretation = noticeCollection_policyInterpretation.load();
						if(policyInterpretation.size()==0){
							policyInterpretation = EmploymentInfoDataCapture.initializePolicyInterpretation();
							noticeCollection_policyInterpretation.save(policyInterpretation);
						}
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}
			
			protected void done(){
				if(NoticeSetting.isPolicyInterpretation()){
//					((PanelNotice) panel_notice).addData(policyInterpretation,"政策解读");
					allNotices.addAll(policyInterpretation);
				}
				
				updateData();
			}
			
		};
	}
	
	private void addData_sina(){
		sina = new SwingWorker<ArrayList<NoticeContainer>,String>(){

			@Override
			protected ArrayList<NoticeContainer> doInBackground() throws Exception {
				// TODO Auto-generated method stub
				sinalist = NoticeDataCapture.addSina();
				return null;
			}
		
			protected void done(){
				allNotices.addAll(sinalist);
				updateData();
			}
		};
	}
	
	private void initData(){
		panel_notice = new PanelNotice();
		allNotices.clear();
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
		sinalist = new ArrayList<NoticeContainer>();
	}
	
	public static ArrayList<NoticeContainer> getAllNotices(){
		return allNotices;
	}
	
	public static void updateData(){
		allNotices.sort(new sortBy());
		((PanelNotice) panel_notice).setData(allNotices);
	}
	
	public static void change(int TYPE){
		if(TYPE==0)
			notice_Status = NoticeStatus.SCHOOL;
		if(TYPE==1)
			notice_Status = NoticeStatus.SINA;
		if(TYPE==2)
			notice_Status = NoticeStatus.EMPLOYMENT;
	}
}

class sortBy implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
        	Date dt1 = format.parse(((NoticeContainer)o1).getDate());
        	Date dt2 = format.parse(((NoticeContainer)o2).getDate());
			if (dt1.getTime() > dt2.getTime()) {
                return -1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return 1;
            } else {
                return 0;
            }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
}
