package com.jnu.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 * created by chenqinquan;
 */

public class PanelTemplate extends JPanel {
	
	private PanelTopBanner topBanner;
	private JPanel panel_basic;
	
	/**
	 * Create the panel.
	 */
	public PanelTemplate(JPanel panel) {
		setLayout(null);
		
		topBanner = new PanelTopBanner();
		topBanner.setBounds(0, 0, 1100, 50);
		add(topBanner);
		
		// TODO 子页面;
		panel_basic = panel;
		panel_basic.setBounds(0, 50, 1100, 500);
		add(panel_basic);
	}

}
