package com.jnu.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

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
	private String[] header = {"通知概要","发布时间","发布源"};
	Object[][] noticeTableItem;
	private JScrollPane listScrollPane;
	private JTable notice_table;
	private DefaultTableModel tableModel;
	private ArrayList<NoticeContainer> theNotices;
	
	public PanelNotice() {
		super(new BorderLayout());
		//初始化
		theNotices = new ArrayList<NoticeContainer>();
		notice_table = new JTable(){
			public boolean isCellEditable(int row, int column){
				 return false;
			 }
		};

		tableModel = new DefaultTableModel(noticeTableItem,header);
		listScrollPane = new JScrollPane(notice_table);
		//组件设置
		notice_table.setModel(tableModel);
		notice_table.setEnabled(true);
		notice_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        notice_table.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent e){
                if(e.getClickCount()==2){ 
                //When double click JList  
                	if(notice_table.getSelectedRow()!=-1)
                		whenDbClickLst(theNotices.get(notice_table.getSelectedRow()).getHref());   //Event  
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
		ViewMain.openWeb(url);
	}

	public void setData(ArrayList<NoticeContainer> notices){
		this.theNotices = notices;
		Object[][] noticeItem = new Object[this.theNotices.size()][3];
		for(int row_index=0;row_index<notices.size();row_index++){
			noticeItem[row_index][0] = notices.get(row_index).getTitle();
			noticeItem[row_index][1] = notices.get(row_index).getDate();
			noticeItem[row_index][2] = notices.get(row_index).getPublishingSource();
		}
		tableModel.setDataVector(noticeItem, header);
	}
	
}
