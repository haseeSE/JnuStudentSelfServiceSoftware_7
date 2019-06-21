package com.jnu.model;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class EmploymentInfoDataCapture {
	
	private static String hrefBase = "https://career.jnu.edu.cn";

	public static ArrayList<NoticeContainer> initializeNewsAndTrends() throws Exception {
		ArrayList<NoticeContainer> newsAndTrends = new ArrayList<NoticeContainer>();
		String urlBase = "https://career.jnu.edu.cn/eweb/jygl/index.so?modcode=jyw_xwgg&subsyscode=jyw&type=searchNews&newsType=xwdt";
		String urlAdditional = "type=goPager&requestPager=pager&pageMethod=next&currentPage=";
		int page = 0;
		String url;
//        Connection connect;
        Document document;
		Elements items;
        
        try {

            //循环读取每一页的内容，共3页
            for(; page < 3; page++) {
            	url = urlBase + "&" + urlAdditional + page;
            	
		    	CloseableHttpClient closeableHttpClient = HttpClients.createDefault() ;
		        HttpPost httpPost = new HttpPost(url) ;
		        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpPost) ;
		        HttpEntity entity = closeableHttpResponse.getEntity();
		        String s = EntityUtils.toString(entity);
		        
		        document = Jsoup.parse(s);
            	
            	
//            	// 利用Jsoup获得连接新闻动态的首页
//                connect = Jsoup.connect(url).timeout(1000000);
//                // 得到Document对象
//                document = connect.get();
                //items中保存每一页所有的（10则）新闻
            	items = document.select(".sy_inf li");
            	for(Element item: items)
            	{
            		//必需在循环内创建（new）一个containerTem，在循环外创建containerTem会导致newsAndTrends.add()方法覆盖之前的内容
            		NoticeContainer containerTem = new NoticeContainer();
            		//获取一则新闻动态并添加到newsAndTrends
            		Elements title = item.select("a");
            		containerTem.setTitle(title.text());
            		//由于不是通过Jsoup.connect(url)的方法连接，因此没有将url视为base url，无法使用attr("abs:href")获取绝对网址，只能获取相对网址，再合并得到绝对网址
            		containerTem.setHref(hrefBase + title.attr("href"));
            		Elements date = item.select(".gg_year");
            		containerTem.setDate(date.text());
            		containerTem.setPublishingSource("新闻动态");
            		newsAndTrends.add(containerTem);
            	}
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }	
        return newsAndTrends;
	}

	//初始化通知公告noticeAndAnnouncement
	public static ArrayList<NoticeContainer>  initializeNoticeAndAnnouncement() throws Exception{
		ArrayList<NoticeContainer> noticeAndAnnouncement = new ArrayList<NoticeContainer>();
		String urlBase = "https://career.jnu.edu.cn/eweb/jygl/index.so?modcode=jyw_tzgg&subsyscode=jyw&type=searchNews&newsType=tzgg";
		String urlAdditional = "type=goPager&requestPager=pager&pageMethod=next&currentPage=";
		int page = 0;
		String url;
//        Connection connect;
        Document document;
		Elements items;
        
        try {

            //循环读取每一页的内容，共14页
            for(; page < 14; page++) {
            	url = urlBase + "&" + urlAdditional + page;
            	
		    	CloseableHttpClient closeableHttpClient = HttpClients.createDefault() ;
		        HttpPost httpPost = new HttpPost(url) ;
		        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpPost) ;
		        HttpEntity entity = closeableHttpResponse.getEntity();
		        String s = EntityUtils.toString(entity);
		        
		        document = Jsoup.parse(s);
//                connect = Jsoup.connect(url);
//                // 得到Document对象
//                document = connect.get();
            	items = document.select(".sy_inf li");
            	for(Element item: items)
            	{
            		//必需在循环内创建（new）一个containerTem，在循环外创建containerTem会导致newsAndTrends.add()方法覆盖之前的内容
            		NoticeContainer containerTem = new NoticeContainer();
            		Elements title = item.select("a");
            		containerTem.setTitle(title.text());
            		containerTem.setHref(hrefBase + title.attr("abs:href"));
            		Elements date = item.select(".gg_year");
            		containerTem.setDate(date.text());
            		containerTem.setPublishingSource("通知公告");
            		noticeAndAnnouncement.add(containerTem);
            	}
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		return noticeAndAnnouncement;	
	}
	
    //初始化招聘热点hotRecruitment
	public static ArrayList<NoticeContainer>  initializeHotRecruitment()  throws Exception{
		ArrayList<NoticeContainer> hotRecruitment = new ArrayList<NoticeContainer>();
		String urlBase = "https://career.jnu.edu.cn/eweb/jygl/zpfw.so?modcode=jygl_scfwzpxx&subsyscode=zpfw&type=searchZprd&sysType=TPZPFW&zpxxType=new";
		String urlAdditional = "type=goPager&requestPager=pager&pageMethod=next&currentPage=";
		String hrefBase = "https://career.jnu.edu.cn/eweb/jygl/zpfw.so?modcode=jygl_zpfwzpgg&subsyscode=zpfw&type=view&id=";
		int page = 0;
		String url;
//        Connection connect;
        Document document;
		Elements items;
        
        try {

            //循环读取每一页的内容，共7页
            for(; page < 3; page++) {
            	Boolean item1 = true;
            	url = urlBase + "&" + urlAdditional + page;
            	
		    	CloseableHttpClient closeableHttpClient = HttpClients.createDefault() ;
		        HttpPost httpPost = new HttpPost(url) ;
		        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpPost) ;
		        HttpEntity entity = closeableHttpResponse.getEntity();
		        String s = EntityUtils.toString(entity);
		        
		        document = Jsoup.parse(s);
//                connect = Jsoup.connect(url).timeout(20000);
//                // 得到Document对象
//                document = connect.timeout(20000).get();
            	items = document.select(".z_newsl li");
            	for(Element item: items)
            	{
            		//跳过每一页的第一项
            		if (item1 == true)
            		{
            			item1 = false;
            			continue;
            		}
            		//必需在循环内创建（new）一个containerTem，在循环外创建containerTem会导致newsAndTrends.add()方法覆盖之前的内容
            		NoticeContainer containerTem = new NoticeContainer();
            		Elements title = item.select("a");
            		containerTem.setTitle(title.text());
            		//href由hrefBase加上 去掉首部的viewZpxx('和尾部的', 'new')的title.attr("onclick") 组成
            		containerTem.setHref(hrefBase + title.attr("onclick").replace("viewZpxx('", "").replace("', 'news')", ""));
            		Elements date = item.select("div").next();
            		containerTem.setDate(date.text());
            		containerTem.setPublishingSource("招聘热点");
            		hotRecruitment.add(containerTem);
            	}
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		return hotRecruitment;	
	}
	
	//初始化政策解读policyInterpretation
	public static ArrayList<NoticeContainer> initializePolicyInterpretation()  throws Exception{
		ArrayList<NoticeContainer> policyInterpretation = new ArrayList<NoticeContainer>();
		String urlBase = "https://career.jnu.edu.cn/eweb/jygl/index.so?modcode=jyw_xwgg&subsyscode=jyw&type=searchNews&newsType=dfzc";
		String urlAdditional = "type=goPager&requestPager=pager&pageMethod=next&currentPage=";
		int page = 0;
		String url;
//        Connection connect;
        Document document;
		Elements items;
        
        try {

            //循环读取每一页的内容，共3页
            for(; page < 3; page++) {
            	url = urlBase + "&" + urlAdditional + page;
            	
		    	CloseableHttpClient closeableHttpClient = HttpClients.createDefault() ;
		        HttpPost httpPost = new HttpPost(url) ;
		        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpPost) ;
		        HttpEntity entity = closeableHttpResponse.getEntity();
		        String s = EntityUtils.toString(entity);
		        
		        document = Jsoup.parse(s);  	
            	
//                connect = Jsoup.connect(url);
//                // 得到Document对象
//                document = connect.get();
                
            	items = document.select(".sy_inf li");
            	for(Element item: items)
            	{
            		//必需在循环内创建（new）一个containerTem，在循环外创建containerTem会导致newsAndTrends.add()方法覆盖之前的内容
            		NoticeContainer containerTem = new NoticeContainer();
            		Elements title = item.select("a");
            		containerTem.setTitle(title.text());
            		containerTem.setHref(hrefBase + title.attr("abs:href"));
            		Elements date = item.select(".gg_year");
            		containerTem.setDate(date.text());
            		containerTem.setPublishingSource("政策解读");
            		policyInterpretation.add(containerTem);
            	}
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error");
        }
		return policyInterpretation;	
	}
}
