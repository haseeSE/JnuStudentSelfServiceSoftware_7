package com.jnu.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * created by dingyiyuan;
 */

public class PanelLeaveDocEdit extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelLeaveDocEdit() {
setLayout(null);
		
		JLabel label_2 = new JLabel("\u5E74");
		label_2.setBounds(303, 251, 22, 18);
		label_2.setFont(new Font("黑体", Font.PLAIN, 22));
		add(label_2);
		
		JLabel label_3 = new JLabel("\u6708");
		label_3.setBounds(387, 252, 22, 18);
		label_3.setFont(new Font("黑体", Font.PLAIN, 22));
		add(label_3);
		
		JLabel label_4 = new JLabel("\u65E5\u81F3");
		label_4.setBounds(488, 252, 74, 18);
		label_4.setFont(new Font("黑体", Font.PLAIN, 22));
		add(label_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(5);
		comboBox.setBounds(329, 249, 51, 24);
		comboBox.setFont(new Font("黑体", Font.PLAIN, 22));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setMaximumRowCount(5);
		comboBox_1.setBounds(423, 249, 51, 24);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_1.setFont(new Font("黑体", Font.PLAIN, 22));
		add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(222, 248, 81, 24);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019", "2020", "2021", "2022"}));
		comboBox_2.setMaximumRowCount(5);
		comboBox_2.setFont(new Font("黑体", Font.PLAIN, 22));
		add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(546, 250, 81, 24);
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019", "2020", "2021", "2022"}));
		comboBox_3.setMaximumRowCount(5);
		comboBox_3.setFont(new Font("黑体", Font.PLAIN, 22));
		add(comboBox_3);
		
		JLabel label_5 = new JLabel("\u5E74");
		label_5.setBounds(636, 251, 22, 18);
		label_5.setFont(new Font("黑体", Font.PLAIN, 22));
		add(label_5);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setMaximumRowCount(5);
		comboBox_4.setBounds(662, 249, 51, 24);
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_4.setFont(new Font("黑体", Font.PLAIN, 22));
		add(comboBox_4);
		
		JLabel label_6 = new JLabel("\u6708");
		label_6.setBounds(720, 252, 22, 18);
		label_6.setFont(new Font("黑体", Font.PLAIN, 22));
		add(label_6);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setMaximumRowCount(5);
		comboBox_5.setBounds(756, 249, 51, 24);
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_5.setFont(new Font("黑体", Font.PLAIN, 22));
		add(comboBox_5);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBounds(104, 85, 116, 36);
		textPane_1.setBackground(SystemColor.menu);
		textPane_1.setFont(new Font("黑体", Font.PLAIN, 22));
		textPane_1.setText("\u8BF7\u5047\u7406\u7531\uFF1A");
		add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(104, 241, 132, 32);
		textPane_2.setEditable(false);
		textPane_2.setText("\u8BF7\u5047\u65F6\u95F4\uFF1A");
		textPane_2.setFont(new Font("黑体", Font.PLAIN, 22));
		textPane_2.setBackground(SystemColor.menu);
		add(textPane_2);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.WHITE);
		textPane.setBounds(231, 85, 561, 146);
		add(textPane);
		textPane.setFont(new Font("黑体", Font.PLAIN, 22));
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO
				
				JOptionPane.showMessageDialog(ViewMain.getFrame(), "提交成功", "请假文档上传", JOptionPane.PLAIN_MESSAGE);
				ViewMain.panelBack();
			}
		});
		btnNewButton.setBounds(433, 333, 113, 27);
		add(btnNewButton);

	}

}
