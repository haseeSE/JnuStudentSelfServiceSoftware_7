package com.jnu.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import org.apache.log4j.Logger;

public class PanelNoticeDetail extends JPanel {

	private Logger Log = Logger.getLogger(getClass());
	
	/**
	 * Create the panel.
	 */
	JScrollPane scrollPane;
	JPanel p = new JPanel();
	
	public PanelNoticeDetail() {
		// <----------	LOG: CREATED	------------>
		Log.info("CREATED");
		
		JTextPane text = new JTextPane();
		text.setEditable(false);
		text.setText("通知详情");
		text.setFont(getFont().deriveFont((float) (getFont().getSize() + 220)));
		text.setBackground(Color.YELLOW);
		
		scrollPane = new JScrollPane(text);
		add(scrollPane);

	}

}
