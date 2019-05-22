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
	private ArrayList<NoticeContainer> EmploymentInfos;
	
//	private static final String noticeString = "CollegeNotice";
//	ArrayList<String> notice_date_container = new ArrayList<String>();
//	ArrayList<String> notice_content_container = new ArrayList<String>();
	
	public PanelEmploymentInfo(ArrayList<NoticeContainer> EI) {
		super(new BorderLayout());
		
		// <----------	LOG: CREATED	------------>
		Log.info("CREATED");
		
		listModel = new DefaultListModel<String>();
		this.EmploymentInfos = EI;
		//添加数据
		try {
			addData();
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
                    whenDbClickLst(EmploymentInfos.get(list_EmploymentInfo.getSelectedIndex()).getHref());   //Event  
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
	private void whenDbClickLst(String url){
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

	private void addData() {
		for (int index = 0; index < EmploymentInfos.size(); index++)
			listModel.addElement(EmploymentInfos.get(index).getDate()+"          "+EmploymentInfos.get(index).getTitle());
	}
	
	
	
    
}
	


