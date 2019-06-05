package com.jnu.model;

public class NoticeSetting {
	private static boolean schoolNotice = true;
	private static boolean collegeNotice_humanities = false;
	private static boolean collegeNotice_internationalBusiness = false;
	private static boolean collegeNotice_translationStudies = false;
	private static boolean collegeNotice_intelligentScienceAndEngineering = false;
	private static boolean collegeNotice_electricalEngineering = false;
	private static boolean collegeNotice_packagingEngineering = false;
	private static boolean academicAdministrationNotice = true;
	private static boolean newsAndTrends = true;
	private static boolean noticeAndAnnouncement = true;
	private static boolean hotRecruitment = true;
	private static boolean policyInterpretation = true;
	
	public static boolean isSchoolNotice() {
		return schoolNotice;
	}
	public static void setSchoolNotice(boolean schoolNotice) {
		NoticeSetting.schoolNotice = schoolNotice;
	}
	public static boolean isCollegeNotice_humanities() {
		return collegeNotice_humanities;
	}
	public static void setCollegeNotice_humanities(boolean collegeNotice_humanities) {
		NoticeSetting.collegeNotice_humanities = collegeNotice_humanities;
	}
	public static boolean isCollegeNotice_internationalBusiness() {
		return collegeNotice_internationalBusiness;
	}
	public static void setCollegeNotice_internationalBusiness(boolean collegeNotice_internationalBusiness) {
		NoticeSetting.collegeNotice_internationalBusiness = collegeNotice_internationalBusiness;
	}
	public static boolean isAcademicAdministrationNotice() {
		return academicAdministrationNotice;
	}
	public static void setAcademicAdministrationNotice(boolean academicAdministrationNotice) {
		NoticeSetting.academicAdministrationNotice = academicAdministrationNotice;
	}
	public static boolean isCollegeNotice_translationStudies() {
		return collegeNotice_translationStudies;
	}
	public static void setCollegeNotice_translationStudies(boolean collegeNotice_translationStudies) {
		NoticeSetting.collegeNotice_translationStudies = collegeNotice_translationStudies;
	}
	public static boolean isCollegeNotice_intelligentScienceAndEngineering() {
		return collegeNotice_intelligentScienceAndEngineering;
	}
	public static void setCollegeNotice_intelligentScienceAndEngineering(
			boolean collegeNotice_intelligentScienceAndEngineering) {
		NoticeSetting.collegeNotice_intelligentScienceAndEngineering = collegeNotice_intelligentScienceAndEngineering;
	}
	public static boolean isCollegeNotice_electricalEngineering() {
		return collegeNotice_electricalEngineering;
	}
	public static void setCollegeNotice_electricalEngineering(boolean collegeNotice_electricalEngineering) {
		NoticeSetting.collegeNotice_electricalEngineering = collegeNotice_electricalEngineering;
	}
	public static boolean isCollegeNotice_packagingEngineering() {
		return collegeNotice_packagingEngineering;
	}
	public static void setCollegeNotice_packagingEngineering(boolean collegeNotice_packagingEngineering) {
		NoticeSetting.collegeNotice_packagingEngineering = collegeNotice_packagingEngineering;
	}
	public static boolean isNewsAndTrends() {
		return newsAndTrends;
	}
	public static void setNewsAndTrends(boolean newsAndTrends) {
		NoticeSetting.newsAndTrends = newsAndTrends;
	}
	public static boolean isNoticeAndAnnouncement() {
		return noticeAndAnnouncement;
	}
	public static void setNoticeAndAnnouncement(boolean noticeAndAnnouncement) {
		NoticeSetting.noticeAndAnnouncement = noticeAndAnnouncement;
	}
	public static boolean isHotRecruitment() {
		return hotRecruitment;
	}
	public static void setHotRecruitment(boolean hotRecruitment) {
		NoticeSetting.hotRecruitment = hotRecruitment;
	}
	public static boolean isPolicyInterpretation() {
		return policyInterpretation;
	}
	public static void setPolicyInterpretation(boolean policyInterpretation) {
		NoticeSetting.policyInterpretation = policyInterpretation;
	}
}
