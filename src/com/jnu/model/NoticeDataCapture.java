package com.jnu.model;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NoticeDataCapture {
	
	public NoticeDataCapture(){
		
	}
	
	public static ArrayList<NoticeContainer> addSchoolNotices() throws Exception {
		ArrayList<NoticeContainer> noticeList = new ArrayList<NoticeContainer>();
		String url = "https://zh.jnu.edu.cn/";
		String href = "/8366/list.htm";
		while(!href.equals("javascript:void(0);")){
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
				if(!notice.getTitle().equals("")&&!notice.getDate().equals(""))
					noticeList.add(notice);
			}
			href = document.getElementById("wp_paging_w5").select("ul").select("li.page_nav").select("a.next").attr("href");
		}
		return noticeList;
	}
	
	
	public static ArrayList<NoticeContainer> addCollegeNotices(int collegeType) throws Exception {
		ArrayList<NoticeContainer> noticeList = new ArrayList<NoticeContainer>();
		if(collegeType==1){
			//人文学院
			String url = "https://rwxy.jnu.edu.cn/";
			String href = "/11063/list.htm";
			while(!href.equals("javascript:void(0);")){
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
					if(!notice.getTitle().equals("")&&!notice.getDate().equals(""))
						noticeList.add(notice);
				}
				href = document.getElementById("wp_paging_w6").select("ul").select("li.page_nav").select("a.next").attr("href");
			}
		}
		else if(collegeType==2){
			//翻译学院
			String url = "https://translation.jnu.edu.cn";
			String href = "/7832/list.htm";
			while(!href.equals("javascript:void(0);")){
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
			}
		}
		else if(collegeType==3){
			String url = "https://pack.jnu.edu.cn/";
			String href = "/11282/list.htm";
			while(!href.equals("javascript:void(0);")){
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
					if(!notice.getTitle().equals("")&&!notice.getDate().equals(""))
						noticeList.add(notice);
				}
				href = document.getElementById("wp_paging_w15").select("ul").select("li.page_nav").select("a.next").attr("href");
			}
		}
		if(noticeList.size()==0){
			NoticeContainer emptyNotice = new NoticeContainer();
			emptyNotice.setTitle("没有可爬取的通知");
			noticeList.add(emptyNotice);
		}			
		return noticeList;
	}
	
	
	public static ArrayList<NoticeContainer> addAcademicAdminstrationNotices() throws Exception {
		ArrayList<NoticeContainer> noticeList = new ArrayList<NoticeContainer>();
		String url = "https://jwc.jnu.edu.cn/";
		String href = "SmallClass_index.asp?SmallClassName=%CD%A8%D6%AA&BigClassName=%BD%CC%CE%F1%B4%A6";
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
}
