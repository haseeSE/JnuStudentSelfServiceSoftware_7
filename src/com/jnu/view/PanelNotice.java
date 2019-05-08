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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PanelNotice extends JPanel implements ListSelectionListener {

	/**
	 * Create the panel.
	 */
	JScrollPane listScrollPane;
	private JList<String> notice_list;
	private DefaultListModel<String> listModel;
	
	private static final String noticeString = "CollegeNotice";
	ArrayList<String> notice_date_container = new ArrayList<String>();
	ArrayList<String> notice_content_container = new ArrayList<String>();
	
	public PanelNotice() {
		super(new BorderLayout());
		listModel = new DefaultListModel<String>();
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
                    whenDbClickLst(notice_list.getSelectedValue());   //Event  
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
	private void whenDbClickLst(Object value){
		//ViewMain.changePanelTemplate(new    );
	}

	private void addData(){
		notice_date_container.add("2019-4-24");
		notice_content_container.add("包装工程学院举行“思想育人、模范育人、实践育人‘三位一体’党建领航工程”之“党建引领、逐梦数模”品牌活动基地揭牌仪式");
		notice_date_container.add("2019-4-19");
		notice_content_container.add("树立正确的入党动机，以实际行动争取早日入党 ——校区党工委常务副书记林晓灵为第83期分党校学员作专题辅导报告");
		notice_date_container.add("2019-4-17");
		notice_content_container.add("第九届“勇源杯”商业精英挑战赛圆满落幕，校企合作助力大学生创新创业");
		for(int i=0;i<notice_date_container.size();i++)
			listModel.addElement(notice_date_container.get(i)+"                        "+notice_content_container.get(i));
	}

}
