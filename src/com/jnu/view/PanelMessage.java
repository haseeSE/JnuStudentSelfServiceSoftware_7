package com.jnu.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/*
 * created by fengsijian;
 */

public class PanelMessage extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelMessage() {
		setLayout(null);
		
		setSubMessage();
		
		// TODO		

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
