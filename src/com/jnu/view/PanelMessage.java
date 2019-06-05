package com.jnu.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import org.apache.log4j.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * created by fengsijian;
 */

public class PanelMessage extends JPanel {
	private Logger Log = Logger.getLogger(getClass());

	/**
	 * Create the panel.
	 */
	public PanelMessage() {
		// <----------	LOG: CREATED	------------>
		Log.info("CREATED");
		
		setLayout(null);
		
		setSubMessage();
		
		// TODO		
		JPanel panel_notice_container = new PanelNoticeContainer();
		panel_notice_container.setBounds(34, 30, 630, 412);
		add(panel_notice_container);
		
		JButton btn_noticeSetting = new JButton("通知设置");
		btn_noticeSetting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
//				ViewMain.getFrame().setEnabled(false);
				JFrame NoticeSetting = new ViewNoticeSetting(ViewMain.getFrame());
				NoticeSetting.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
//						ViewMain.getFrame().setEnabled(true);
					}
				});
				NoticeSetting.setVisible(true);
				
			}
		});
		btn_noticeSetting.setBounds(551, 455, 113, 27);
		add(btn_noticeSetting);

	}

	// Insert Sub Message Panel;
	private void setSubMessage() {
		// TODO Auto-generated method stub
		JPanel panel_subMessage = new PanelSubMessage();
		panel_subMessage.setBounds(668, 27, 330, 352);
		add(panel_subMessage);
		
		

//		panel_subMessage.removeAll();
//		panel_subMessage.add(new PanelSubMessage(), BorderLayout.CENTER);
//		panel_subMessage.updateUI();
//		
	}
	
}
