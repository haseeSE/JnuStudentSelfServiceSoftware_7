package com.jnu.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import org.apache.log4j.Logger;

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
