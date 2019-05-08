package com.jnu.view;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;

/*
 * created by zhujiayu;
 */

public class PanelEmploymentInfo extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelEmploymentInfo() {
		setLayout(new CardLayout(0, 0));
		
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
		add(tab, "name_61410775837642");

//
//		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setFont(new Font("新宋体",Font.BOLD, 20));
		tab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		add(tab, "name_61410775837642");
		
		//对象化面板
		JPanel p1 = new JPanel();
  
		JPanel p2 = new JPanel();
		
		JPanel p3 = new JPanel();
  
		JPanel p4 = new JPanel();

		tab.add(p1,"新闻动态");
        
        JLabel label = new JLabel("\u6211\u68212018\u5E74\u7B80\u5386\u8BBE\u8BA1\u53CA\u6A21\u62DF\u9762\u8BD5\u5927\u8D5B\u5706\u6EE1\u843D\u5E55");
        label.setFont(new Font("新宋体", Font.PLAIN, 16));
        
        JLabel label_1 = new JLabel("\u5173\u4E8E\u53D1\u5E03\u300A\u66A8\u5357\u5927\u5B662018\u5E74\u5EA6\u6BD5\u4E1A\u751F\u5C31\u4E1A\u8D28\u91CF\u62A5\u544A\u300B\u7684\u516C\u544A");
        label_1.setFont(new Font("新宋体", Font.PLAIN, 16));
        GroupLayout gl_p1 = new GroupLayout(p1);
        gl_p1.setHorizontalGroup(
        	gl_p1.createParallelGroup(Alignment.LEADING)
        		.addComponent(label, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
        		.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
        );
        gl_p1.setVerticalGroup(
        	gl_p1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_p1.createSequentialGroup()
        			.addComponent(label)
        			.addGap(6)
        			.addComponent(label_1))
        );
        p1.setLayout(gl_p1);
		tab.add(p2,"通知公告");
		
		JLabel label_3 = new JLabel("\u66A8\u5357\u5927\u5B662019\u5C4A\u6BD5\u4E1A\u751F\u6C42\u804C\u521B\u4E1A\u8865\u8D34\u540D\u5355\u7684\u516C\u793A");
		label_3.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		JLabel label_4 = new JLabel("\u5E7F\u897F\u58EE\u65CF\u81EA\u6CBB\u533A2019\u5E74\u9009\u8C03\u5E94\u5C4A\u4F18\u79C0\u5927\u5B66\u6BD5\u4E1A\u751F\u5DE5\u4F5C\u516C\u544A");
		label_4.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		GroupLayout gl_p2 = new GroupLayout(p2);
		gl_p2.setHorizontalGroup(
			gl_p2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p2.createSequentialGroup()
					.addGroup(gl_p2.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(289, Short.MAX_VALUE))
		);
		gl_p2.setVerticalGroup(
			gl_p2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p2.createSequentialGroup()
					.addComponent(label_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_4)
					.addContainerGap(285, Short.MAX_VALUE))
		);
		p2.setLayout(gl_p2);
		tab.add(p3,"招聘热点");
		
		JLabel label_5 = new JLabel("\u519C\u884C\u5E7F\u4E1C\u7701\u5206\u884C2019\u5E74\u6625\u5B63\u6821\u56ED\u62DB\u8058\u516C\u544A");
		label_5.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		JLabel label_6 = new JLabel("\u6B22\u8FCE\u52A0\u5165\u5E7F\u5DDE\u8B66\u961F\uFF01");
		label_6.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		GroupLayout gl_p3 = new GroupLayout(p3);
		gl_p3.setHorizontalGroup(
			gl_p3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p3.createSequentialGroup()
					.addGroup(gl_p3.createParallelGroup(Alignment.LEADING)
						.addComponent(label_5)
						.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
					.addGap(289))
		);
		gl_p3.setVerticalGroup(
			gl_p3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p3.createSequentialGroup()
					.addComponent(label_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_6)
					.addContainerGap(285, Short.MAX_VALUE))
		);
		p3.setLayout(gl_p3);
		tab.add(p4,"政策解读");
		
		JLabel label_2 = new JLabel("\u5F81\u9014\u6D69\u6DFC\uFF0C\u8E0F\u6D6A\u524D\u884C-\u66A8\u5357\u5927\u5B662017\u5E74\u5B66\u751F\u5C31\u4E1A\u521B\u4E1A\u98CE\u91C7\u96C6");
		label_2.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		JLabel label_7 = new JLabel("\u66A8\u5357\u5927\u5B662018\u5E74\u6BD5\u4E1A\u751F\u5C31\u4E1A\u521B\u4E1A\u98CE\u91C7\u96C6");
		label_7.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		GroupLayout gl_p4 = new GroupLayout(p4);
		gl_p4.setHorizontalGroup(
			gl_p4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p4.createSequentialGroup()
					.addGroup(gl_p4.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(289, Short.MAX_VALUE))
		);
		gl_p4.setVerticalGroup(
			gl_p4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p4.createSequentialGroup()
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_7)
					.addContainerGap(285, Short.MAX_VALUE))
		);
		p4.setLayout(gl_p4);
	}

}

