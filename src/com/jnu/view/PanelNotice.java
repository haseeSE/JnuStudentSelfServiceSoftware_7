package com.jnu.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.jnu.model.NoticeContainer;
import com.jnu.model.UserManager;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;

public class PanelNotice extends JPanel implements ListSelectionListener {
	
	private Logger Log = Logger.getLogger(getClass());

	/**
	 * Create the panel.
	 */
	JScrollPane listScrollPane;
	private JList<String> notice_list;
	private DefaultListModel<String> listModel;
	
	private static final String noticeString = "CollegeNotice";
	ArrayList<String> notice_date_container = new ArrayList<String>();
	ArrayList<String> notice_content_container = new ArrayList<String>();
	
	public PanelNotice(int notice_type) {
		super(new BorderLayout());
		
		// <----------	LOG: CREATED	------------>
		Log.info("CREATED");
		
		listModel = new DefaultListModel<String>();
		//添加数据
		try {
			addData(notice_type);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		notice_list = new JList<String>(listModel);
        notice_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        notice_list.setSelectedIndex(0);
        notice_list.addListSelectionListener(this);
        notice_list.setVisibleRowCount(5);
        notice_list.setFont(getFont().deriveFont((float) (getFont().getSize() + 3)));		// 设置字体大小
        notice_list.setSelectionForeground(Color.BLUE);										// 设置选中选项的字体颜色
        notice_list.setSelectionBackground(Color.CYAN);										// 设置选中条的颜色
        notice_list.setFixedCellWidth(200);													//设置是否限制字符长度
        listScrollPane = new JScrollPane(notice_list);
        notice_list.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent e){
                if(e.getClickCount()==2){ 
                //When double click JList  
                    whenDbClickLst(notice_list.getSelectedValue(),"");   //Event  
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

	private void addData(int notice_type) throws Exception{
		int index = 0;
		switch(notice_type){
			case 1:
				ArrayList<NoticeContainer> schoolNotices = addSchoolNotices();
				index = 0;
				while(schoolNotices.get(index)!=null){
					listModel.addElement(schoolNotices.get(index).getDate()+"          "+schoolNotices.get(index).getTitle());
					index++;
				}
				break;
		
			case 2:
				String college = UserManager.getUser().get_college();
				if(college.contains("人文")){
					ArrayList<NoticeContainer> collegeNotices = addCollegeNotices(1);
					index = 0;
					while(collegeNotices.get(index)!=null){
						listModel.addElement(collegeNotices.get(index).getDate()+"          "+collegeNotices.get(index).getTitle());
						index++;
					}
				}
				else if(college.contains("翻译")){
					ArrayList<NoticeContainer> collegeNotices = addCollegeNotices(2);
					index = 0;
					while(collegeNotices.get(index)!=null){
						listModel.addElement(collegeNotices.get(index).getDate()+"          "+collegeNotices.get(index).getTitle());
						index++;
					}
				}
				break;
				
			case 3:
				ArrayList<NoticeContainer> academicAdminstrationNotices = addAcademicAdminstrationNotices();
				index = 0;
				while(academicAdminstrationNotices.get(index)!=null){
					listModel.addElement(academicAdminstrationNotices.get(index).getDate()+"          "+academicAdminstrationNotices.get(index).getTitle());
					index++;
				}
				break;
				
		}
		
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
		return noticeList;
	}
	
	
	public ArrayList<NoticeContainer> addAcademicAdminstrationNotices() throws Exception {
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
