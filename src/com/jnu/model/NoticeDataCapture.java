package com.jnu.model;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NoticeDataCapture {
	private static NoticeDataCapture instance = new NoticeDataCapture();
	private final static int STUDENT = 1;
	private final static int TEACHER = 2;
	private final static int NEWS = 1;
	private final static int NOTICES = 2;
	
	private NoticeDataCapture(){
		
	}
	
	public static NoticeDataCapture getInstance(){
		return instance;
	}
	//学校
	public static ArrayList<NoticeContainer> addSchoolNotices(int type) throws Exception {
		ArrayList<NoticeContainer> noticeList = new ArrayList<NoticeContainer>();
		String url = "https://zh.jnu.edu.cn/";
		String href = "";
		String PS = "";
		if(type==STUDENT){
			href = "/8378/list.psp";
			PS = "学生通知";
		}
		if(type==TEACHER){
			href = "/8379/list.psp";
			PS = "教师通知";
		}
		int index=0;
		while(!href.equals("javascript:void(0);")&&index<5){
			Document document = Jsoup.connect(url+href)
            .timeout(10000)
            .get();
			Elements ul = document.select("div.banner.list-all.announce-all").select("div").select("div").select("div.list-content.col-xs-12")
					.select("div.col-lg-9.col-lg-offset-1.col-md-8.col-md-offset-1.announce-right").select("div").select("div");
			Elements li = ul.select("li.media");
			
			NoticeContainer notice;
			for (Element element : li) {
				notice = new NoticeContainer();
				notice.setTitle(element.select("a").attr("title"));
				notice.setDate(element.select("a").select("div.media-left").select("small").text());
				notice.setHref(url+element.select("a").attr("href"));
				notice.setPublishingSource(PS);
				if(!notice.getTitle().equals("")&&!notice.getDate().equals(""))
					noticeList.add(notice);
			}
			href = document.getElementById("wp_paging_w5").select("ul").select("li.page_nav").select("a.next").attr("href");
			index++;
		}
		return noticeList;
	}
	//人文学院
	public static ArrayList<NoticeContainer> addHumanities(int type) throws Exception {
		ArrayList<NoticeContainer> noticeList = new ArrayList<NoticeContainer>();
		String url = "https://rwxy.jnu.edu.cn/";
		String href = "";
		String PS = "";
		if(type==NOTICES){
			href = "/11063/list.htm";
			PS = "人文通知";
		}
		if(type==NEWS){
			href = "/11064/list.htm";
			PS = "人文新闻";
		}
		int index=0;
		while(!href.equals("javascript:void(0);")&&index<5){
			Document document = Jsoup.connect(url+href)
            .timeout(10000)
            .get();
			Elements ul = document.select("div.col_news").select("div").select("div.col_news_con").select("div.col_news_list.listcon")
					.select("div").select("ul");
			Elements li = ul.select("li");
			
			NoticeContainer notice;
			for (Element element : li) {
				notice = new NoticeContainer();
				notice.setTitle(element.select("span.news_title").select("a").text());
				notice.setDate(element.select("span.news_meta").text());
				notice.setHref(url+element.select("span.news_title").select("a").attr("href"));
				notice.setPublishingSource(PS);
				if(!notice.getTitle().equals("")&&!notice.getDate().equals(""))
					noticeList.add(notice);
			}
			href = document.getElementById("wp_paging_w6").select("ul").select("li.page_nav").select("a.next").attr("href");
			index++;
		}
		return noticeList;
	}
	//国商
	public static ArrayList<NoticeContainer> addInternationalBusiness(int type) throws Exception {
		ArrayList<NoticeContainer> noticeList = new ArrayList<NoticeContainer>();
		String url = "https://gjsxy.jnu.edu.cn";
		String href = "";
		String PS = "";
		if(type==NOTICES){
			href = "javascript:void(0);";
			PS = "国商通知";
		}
		if(type==NEWS){
			href = "/xyxw_11817/list.htm";
			PS = "国商新闻";
		}
		int index=0;
		while(!href.equals("javascript:void(0);")&&index<5){
			Document document = Jsoup.connect(url+href)
            .timeout(10000)
            .get();
			
			Elements ul = document.select("div.common-wrapper").select("div.common-content").select("div").select("div.common-right.fr")
					.select("ul.common-list");
			Elements li = ul.select("li");
			NoticeContainer notice;
			for (Element element : li) {
				notice = new NoticeContainer();
				notice.setTitle(element.select("a").text());
				notice.setDate(element.select("span").text());
				notice.setHref(url+element.select("a").attr("href"));
				notice.setPublishingSource(PS);
				if(!notice.getTitle().equals("")&&!notice.getDate().equals(""))
					noticeList.add(notice);
			}
			href = document.getElementById("wp_paging_w15").select("ul").select("li.page_nav").select("a.next").attr("href");
			index++;
		}
		return noticeList;
	}
	//翻译学院
	public static ArrayList<NoticeContainer> addTranslationStudies(int type) throws Exception {
		ArrayList<NoticeContainer> noticeList = new ArrayList<NoticeContainer>();
		String url = "https://translation.jnu.edu.cn";
		String href = "";
		String PS = "";
		if(type==NOTICES){
			href = "/7832/list.htm";
			PS = "翻译通知";
		}
		if(type==NEWS){
			href = "/7831/list.htm";
			PS = "翻译新闻";
		}
		int index=0;
		while(!href.equals("javascript:void(0);")&&index<5){
			Document document = Jsoup.connect(url+href)
            .timeout(10000)
            .get();
			
			Elements ul = document.select("div.contenter").select("div.mid").select("div.mind").select("div.midr")
					.select("div:nth-child(2)").select("ul.xwlb");
			Elements li = ul.select("li");
			
			NoticeContainer notice;
			for (Element element : li) {
				notice = new NoticeContainer();
				notice.setTitle(element.select("a").text());
				notice.setDate(element.select("span").text());
				notice.setHref(url+element.select("a").attr("href"));
				notice.setPublishingSource(PS);
				if(!notice.getTitle().equals("")&&!notice.getDate().equals(""))
					noticeList.add(notice);
			}
			href = document.getElementById("wp_paging_w6").select("ul").select("li.page_nav").select("a.next").attr("href");
			index++;
		}
		return noticeList;
	}
	//智科
	public static ArrayList<NoticeContainer> addIntelligentScienceAndEngineering(int type) throws Exception {
		ArrayList<NoticeContainer> noticeList = new ArrayList<NoticeContainer>();
		/*String url = "https://seie.jnu.edu.cn";
		String href = "";
		if(type==NOTICES)
			href = "/7832/list.htm";
		if(type==NEWS)
			href = "/7831/list.htm";
		int index=0;
		while(!href.equals("javascript:void(0);")&&index<5){
			Document document = Jsoup.connect(url+href)
            .timeout(10000)
            .get();
			
			Elements ul = document.select("div.contenter").select("div.mid").select("div.mind").select("div.midr")
					.select("div:nth-child(2)").select("ul.xwlb");
			Elements li = ul.select("li");
			
			NoticeContainer notice;
			for (Element element : li) {
				notice = new NoticeContainer();
				notice.setTitle(element.select("a").text());
				notice.setDate(element.select("span").text());
				notice.setHref(url+element.select("a").attr("href"));
				if(!notice.getTitle().equals("")&&!notice.getDate().equals(""))
					noticeList.add(notice);
			}
			href = document.getElementById("wp_paging_w6").select("ul").select("li.page_nav").select("a.next").attr("href");
			index++;
		}*/
		return noticeList;
	}
	//电工
	public static ArrayList<NoticeContainer> addElectricalEngineering(int type) throws Exception {
		ArrayList<NoticeContainer> noticeList = new ArrayList<NoticeContainer>();
		/*String url = "https://translation.jnu.edu.cn";
		String href = "";
		if(type==NOTICES)
			href = "/7832/list.htm";
		if(type==NEWS)
			href = "/7831/list.htm";
		int index=0;
		while(!href.equals("javascript:void(0);")&&index<5){
			Document document = Jsoup.connect(url+href)
            .timeout(10000)
            .get();
			
			Elements ul = document.select("div.contenter").select("div.mid").select("div.mind").select("div.midr")
					.select("div:nth-child(2)").select("ul.xwlb");
			Elements li = ul.select("li");
			
			NoticeContainer notice;
			for (Element element : li) {
				notice = new NoticeContainer();
				notice.setTitle(element.select("a").text());
				notice.setDate(element.select("span").text());
				notice.setHref(url+element.select("a").attr("href"));
				if(!notice.getTitle().equals("")&&!notice.getDate().equals(""))
					noticeList.add(notice);
			}
			href = document.getElementById("wp_paging_w6").select("ul").select("li.page_nav").select("a.next").attr("href");
			index++;
		}*/
		return noticeList;
	}
	//包装
	public static ArrayList<NoticeContainer> addPackagingEngineering(int type) throws Exception {
		ArrayList<NoticeContainer> noticeList = new ArrayList<NoticeContainer>();
		String url = "https://pack.jnu.edu.cn/";
		String href = "";
		String PS = "";
		if(type==NOTICES){
			href = "/11282/list.htm";
			PS = "包装通知";
		}
		if(type==NEWS){
			href = "/11283/list.htm";
			PS = "包装新闻";
		}
		int index=0;
		while(!href.equals("javascript:void(0);")&&index<5){
			Document document = Jsoup.connect(url+href)
            .timeout(10000)
            .get();
			
			Elements ul = document.select("div.common-wrapper").select("div").select("div").select("div.common-right.pull-right")
					.select("ul.common-list");
			Elements li = ul.select("li");
			
			NoticeContainer notice;
			for (Element element : li) {
				notice = new NoticeContainer();
				notice.setTitle(element.select("a").text());
				notice.setDate(element.select("span").text());
				notice.setHref(url+element.select("a").attr("href"));
				notice.setPublishingSource(PS);
				if(!notice.getTitle().equals("")&&!notice.getDate().equals(""))
					noticeList.add(notice);
			}
			href = document.getElementById("wp_paging_w15").select("ul").select("li.page_nav").select("a.next").attr("href");
			index++;
		}
		return noticeList;
	}
	//教务处
	public static ArrayList<NoticeContainer> addAcademicAdminstrationNotices() throws Exception {
		ArrayList<NoticeContainer> noticeList = new ArrayList<NoticeContainer>();
		String url = "https://jwc.jnu.edu.cn/";
		String href = "SmallClass_index.asp?SmallClassName=%CD%A8%D6%AA&BigClassName=%BD%CC%CE%F1%B4%A6";
		String PS = "教务处通知";
		int index = 0;
		while(index<1){
			Document document = Jsoup.connect(url+href)
            .timeout(10000)
            .get();
			Elements tbody = document.select("tbody").select("tr:nth-child(7)").select("td:nth-child(2)")
					.select("table").select("tbody").select("tr:nth-child(3)").select("td").select("table").select("tbody");
			Elements tr = tbody.select("tr");
			
			NoticeContainer notice;
			for (Element element : tr) {
				notice = new NoticeContainer();
				notice.setTitle(element.select("td").select("a").text());
				notice.setPublishingSource(PS);
				Elements time = element.select("td").select("font.middle");
				if(time.size()!=0)
					notice.setDate(element.select("td").select("font.middle").get(0).text());
				notice.setHref(url+element.select("td").select("a").attr("href"));
				if(notice.getTitle()!=null&&notice.getDate()!=null&&!notice.getTitle().equals("")&&!notice.getDate().equals(""))
					noticeList.add(notice);
			}
			//href = document.select("");
			index++;
		}
		return noticeList;
	}
	//sina
		public static ArrayList<NoticeContainer> addSina() throws Exception {
			ArrayList<NoticeContainer> noticeList = new ArrayList<NoticeContainer>();
			String url = "https://news.sina.com.cn/";
//			String href = "/xyxw_11817/list.htm";
//			int index=0;
//			while(!href.equals("javascript:void(0);")&&index<5){
				Document document = Jsoup.connect(url)
	            .timeout(10000)
	            .get();
				
				Elements ul = document.getElementById("ad_entry_b2").select("ul");
				Elements li = ul.select("li");
				NoticeContainer notice;
				for (Element element : li) {
					notice = new NoticeContainer();
					notice.setTitle(element.select("a").text());
					notice.setHref(element.select("a").attr("href"));
					String test = notice.getHref();
					int index_date = test.indexOf("2019");
					notice.setDate(test.substring(index_date, index_date+10));
					notice.setPublishingSource("新浪新闻");
					if(!notice.getTitle().equals("")&&!notice.getDate().equals(""))
						noticeList.add(notice);
//				}
//				href = document.getElementById("wp_paging_w15").select("ul").select("li.page_nav").select("a.next").attr("href");
//				index++;
			}
			return noticeList;
		}
}
