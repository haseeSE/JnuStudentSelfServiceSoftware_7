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

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.jnu.model.NoticeContainer;
import com.jnu.model.UserManager;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;

public class PanelNotice extends JPanel implements ListSelectionListener {

	/**
	 * Create the panel.
	 */
	JScrollPane listScrollPane;
	private JList<String> notice_list;
	private DefaultListModel<String> listModel;
	private ArrayList<NoticeContainer> theNotices;
	
	public PanelNotice(ArrayList<NoticeContainer> notices) {
		super(new BorderLayout());
		listModel = new DefaultListModel<String>();
		this.theNotices = notices;
		//添加数据
		addData();
		
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
                    whenDbClickLst(theNotices.get(notice_list.getSelectedIndex()).getHref());   //Event  
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
////            	PanelWebBrowser web = new PanelWebBrowser();
////            	web.openDigitalJnu();
//            	ViewMain.openWeb(url);
//            }
//        });
//        NativeInterface.runEventPump();
		ViewMain.openWeb(url);
	}

	private void addData(){
		for(int index=0;index<theNotices.size();index++)
			listModel.addElement(theNotices.get(index).getDate()+"          "+theNotices.get(index).getTitle());
		
	}

}
