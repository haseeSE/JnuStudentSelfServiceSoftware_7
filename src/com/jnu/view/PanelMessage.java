package com.jnu.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import org.apache.log4j.Logger;

import com.jnu.model.NoticeSetting;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

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
		
		setSubMessage();
		
		// TODO		
		JPanel panel_notice_container = new PanelNoticeContainer();
		panel_notice_container.setBounds(34, 30, 630, 412);
		add(panel_notice_container);
		
		JCheckBox checkBox_collegeNotice_humanities = new JCheckBox("人文学院");
		checkBox_collegeNotice_humanities.setBounds(60, 451, 90, 27);
		if (NoticeSetting.isCollegeNotice_humanities())
			checkBox_collegeNotice_humanities.setSelected(true);
		checkBox_collegeNotice_humanities.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean selected = checkBox_collegeNotice_humanities.isSelected();
				if (selected == true)
				{
					NoticeSetting.setCollegeNotice_humanities(true);
					
				}
				else
				{
					NoticeSetting.setCollegeNotice_humanities(false);
					
				}
			}
		});
		add(checkBox_collegeNotice_humanities);
		
		JCheckBox checkBox_collegeNotcie_internationalBusiness = new JCheckBox("国商学院");
		checkBox_collegeNotcie_internationalBusiness.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean selected = checkBox_collegeNotcie_internationalBusiness.isSelected();
				if (selected == true)
					{
					NoticeSetting.setCollegeNotice_internationalBusiness(true);
					
					}
				else
					{
					NoticeSetting.setCollegeNotice_internationalBusiness(false);
					}
			}
		});
		checkBox_collegeNotcie_internationalBusiness.setBounds(160, 451, 90, 27);
		if (NoticeSetting.isCollegeNotice_internationalBusiness())
			checkBox_collegeNotcie_internationalBusiness.setSelected(true);
		add(checkBox_collegeNotcie_internationalBusiness);
		
		JCheckBox checkBox_collegeNotice_translationStudies = new JCheckBox("翻译学院");
		checkBox_collegeNotice_translationStudies.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean selected = checkBox_collegeNotice_translationStudies.isSelected();
				if (selected == true)
				{
					NoticeSetting.setCollegeNotice_translationStudies(true);
					
				}
				else
				{
					NoticeSetting.setCollegeNotice_translationStudies(false);
					
				}
			}
		});
		checkBox_collegeNotice_translationStudies.setBounds(260, 451, 90, 27);
		if (NoticeSetting.isCollegeNotice_translationStudies())
			checkBox_collegeNotice_translationStudies.setSelected(true);
		add(checkBox_collegeNotice_translationStudies);
		
		JCheckBox checkBox_collegeNotice_intelligentScienceAndEngineering = new JCheckBox("智科学院");
		checkBox_collegeNotice_intelligentScienceAndEngineering.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean selected = checkBox_collegeNotice_intelligentScienceAndEngineering.isSelected();
				if (selected == true)
				{
					NoticeSetting.setCollegeNotice_intelligentScienceAndEngineering(true);
				}
				else
				{
					NoticeSetting.setCollegeNotice_intelligentScienceAndEngineering(false);
				}
			}
		});
		checkBox_collegeNotice_intelligentScienceAndEngineering.setBounds(360, 451, 90, 27);
		if (NoticeSetting.isCollegeNotice_intelligentScienceAndEngineering())
			checkBox_collegeNotice_intelligentScienceAndEngineering.setSelected(true);
		add(checkBox_collegeNotice_intelligentScienceAndEngineering);
		
		JCheckBox checkBox_collegeNotice_electricalEngineering = new JCheckBox("电工学院");
		checkBox_collegeNotice_electricalEngineering.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean selected = checkBox_collegeNotice_electricalEngineering.isSelected();
				if (selected == true)
				{
					NoticeSetting.setCollegeNotice_electricalEngineering(true);
					
				}
				else
				{
					NoticeSetting.setCollegeNotice_electricalEngineering(false);
					
				}
			}
		});
		checkBox_collegeNotice_electricalEngineering.setBounds(460, 451, 90, 27);
		if (NoticeSetting.isCollegeNotice_electricalEngineering())
			checkBox_collegeNotice_electricalEngineering.setSelected(true);
		add(checkBox_collegeNotice_electricalEngineering);
		
		JCheckBox checkBox_packagingEngineering = new JCheckBox("包装学院");
		checkBox_packagingEngineering.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean selected = checkBox_packagingEngineering.isSelected();
				if (selected == true)
				{
					NoticeSetting.setCollegeNotice_packagingEngineering(true);
					
				}
				else
				{
					NoticeSetting.setCollegeNotice_packagingEngineering(false);
					
				}
			}
		});
		checkBox_packagingEngineering.setBounds(560, 451, 90, 27);
		if (NoticeSetting.isCollegeNotice_packagingEngineering())
			checkBox_packagingEngineering.setSelected(true);
		add(checkBox_packagingEngineering);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(34, 3, 90, 24);
		comboBox.addItem("校内通知");
		comboBox.addItem("新浪新闻");
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int index = comboBox.getSelectedIndex();
				switch (index) {
				case 0:
					
					break;
				case 1:
					
					break;
				}
			}
		});
		add(comboBox);
		
		JButton btn_update = new JButton("更新");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*if (checkBox_collegeNotice_humanities.isSelected())
					NoticeSetting.setCollegeNotice_humanities(true);
				else
					NoticeSetting.setCollegeNotice_humanities(false);
				if (checkBox_collegeNotcie_internationalBusiness.isSelected())
					NoticeSetting.setCollegeNotice_internationalBusiness(true);
				else
					NoticeSetting.setCollegeNotice_internationalBusiness(false);
				if (checkBox_collegeNotice_translationStudies.isSelected())
					NoticeSetting.setCollegeNotice_translationStudies(true);
				else
					NoticeSetting.setCollegeNotice_translationStudies(false);
				if (checkBox_collegeNotice_intelligentScienceAndEngineering.isSelected())
					NoticeSetting.setCollegeNotice_intelligentScienceAndEngineering(true);
				else
					NoticeSetting.setCollegeNotice_intelligentScienceAndEngineering(false);
				if (checkBox_collegeNotice_electricalEngineering.isSelected())
					NoticeSetting.setCollegeNotice_electricalEngineering(true);
				else
					NoticeSetting.setCollegeNotice_electricalEngineering(false);
				if (checkBox_packagingEngineering.isSelected())
					NoticeSetting.setCollegeNotice_packagingEngineering(true);
				else
					NoticeSetting.setCollegeNotice_packagingEngineering(false);*/
			}
		});
		btn_update.setBounds(551, 3, 113, 27);
		add(btn_update);

	}

	// Insert Sub Message Panel;
	private void setSubMessage() {
		setLayout(null);
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
