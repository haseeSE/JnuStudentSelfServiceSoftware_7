package com.jnu.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.jnu.model.NoticeContainer;
import com.jnu.model.UserManager;

public class PanelEmploymentInfo extends JPanel implements ListSelectionListener {

	private Logger Log = Logger.getLogger(getClass());

	/**
	 * Create the panel.
	 */
	JScrollPane listScrollPane;
	private JList<String> list_EmploymentInfo;
	private DefaultListModel<String> listModel;
	
//	private static final String noticeString = "CollegeNotice";
//	ArrayList<String> notice_date_container = new ArrayList<String>();
//	ArrayList<String> notice_content_container = new ArrayList<String>();
	
	public PanelEmploymentInfo(int employmentInfo_type) {
		super(new BorderLayout());
		
		// <----------	LOG: CREATED	------------>
		Log.info("CREATED");
		
		listModel = new DefaultListModel<String>();
		//添加数据
		try {
			addData(employmentInfo_type);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		list_EmploymentInfo = new JList<String>(listModel);
        list_EmploymentInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list_EmploymentInfo.setSelectedIndex(0);
        list_EmploymentInfo.addListSelectionListener(this);
        list_EmploymentInfo.setVisibleRowCount(5);
        list_EmploymentInfo.setFont(getFont().deriveFont((float) (getFont().getSize() + 3)));		// 设置字体大小
        list_EmploymentInfo.setSelectionForeground(Color.BLUE);										// 设置选中选项的字体颜色
        list_EmploymentInfo.setSelectionBackground(Color.CYAN);										// 设置选中条的颜色
        list_EmploymentInfo.setFixedCellWidth(200);													//设置是否限制字符长度
        listScrollPane = new JScrollPane(list_EmploymentInfo);
        list_EmploymentInfo.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent e){
                if(e.getClickCount()==2){ 
                //When double click JList  
                    whenDbClickLst(list_EmploymentInfo.getSelectedValue(),"");   //Event  
                }  
            }
        });
        add(listScrollPane);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//双击事件
	private void whenDbClickLst(Object value,String url){
//		ViewMain.changePanelTemplate(new PanelNoticeDetail());
//		UIUtils.setPreferredLookAndFeel();
//        NativeInterface.open();
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//            	PanelWebBrowser web = new PanelWebBrowser();
////            	web.openDigitalJnu();
//            	web.loadUrl(url, null);
//            	ViewMain.changePanelMain(web);
//            }
//        });
//        NativeInterface.runEventPump();
		ViewMain.openWeb(url);
	}

	private void addData(int employmentInfo_type) throws Exception{
		int index = 0;
		switch(employmentInfo_type){
			case 1:
				ArrayList<NoticeContainer> newsAndTrends = initializeNewsAndTrends();
				index = 0;
				while(newsAndTrends.get(index)!=null){
					listModel.addElement(newsAndTrends.get(index).getDate()+"          "+newsAndTrends.get(index).getTitle());
					index++;
				}
				break;
		
			case 2:
				ArrayList<NoticeContainer> noticeAndAnnouncement = initializeNoticeAndAnnouncement();
				index = 0;
				while(noticeAndAnnouncement.get(index)!=null){
					listModel.addElement(noticeAndAnnouncement.get(index).getDate()+"          "+noticeAndAnnouncement.get(index).getTitle());
					index++;
				}
				break;
				
			case 3:
				ArrayList<NoticeContainer> hotRecruitment = initializeHotRecruitment();
				index = 0;
				while(hotRecruitment.get(index)!=null){
					listModel.addElement(hotRecruitment.get(index).getDate()+"          "+hotRecruitment.get(index).getTitle());
					index++;
				}
				break;
			case 4:
				ArrayList<NoticeContainer> policyInterpretation = initializePolicyInterpretation();
				index = 0;
				while(policyInterpretation.get(index)!=null){
					listModel.addElement(policyInterpretation.get(index).getDate()+"          "+policyInterpretation.get(index).getTitle());
					index++;
				}
				break;
				
		}
		
	}
	
	
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
            		containerTem.setHref(title.attr("abs:href"));
            		Elements date = item.select(".gg_year");
            		containerTem.setDate(date.text());
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
            		containerTem.setHref(title.attr("abs:href"));
            		Elements date = item.select(".gg_year");
            		containerTem.setDate(date.text());
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
            		containerTem.setHref(title.attr("abs:href"));
            		Elements date = item.select(".gg_year");
            		containerTem.setDate(date.text());
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
	


