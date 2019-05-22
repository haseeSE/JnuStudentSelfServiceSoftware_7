package com.jnu.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import org.apache.log4j.Logger;

import com.jnu.model.EditDoc;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * created by dingyiyuan;
 */

@SuppressWarnings("serial")
public class PanelLeaveDocEdit extends JPanel {
	
	private Logger Log = Logger.getLogger(getClass());

	/**
	 * Create the panel.
	 */
	public static String DocReason;
	public static String DocBeginYear;
	public static int DocBeginMonth;
	public static int DocBeginDay;
	public static String DocEndYear;
	public static int DocEndMonth;
	public static int DocEndDay;
	
	public PanelLeaveDocEdit() {
	// <----------	LOG: CREATED	------------>
	Log.info("CREATED");
		
	setLayout(null);
			
	JLabel label_beginYear = new JLabel("\u5E74");
	label_beginYear.setBounds(251, 176, 22, 18);
	label_beginYear.setFont(new Font("黑体", Font.PLAIN, 22));
	add(label_beginYear);
	
	JLabel label_beginMonth = new JLabel("\u6708");
	label_beginMonth.setBounds(335, 177, 22, 18);
	label_beginMonth.setFont(new Font("黑体", Font.PLAIN, 22));
	add(label_beginMonth);
	
	JLabel label_beginDay = new JLabel("\u65E5\u81F3");
	label_beginDay.setBounds(436, 177, 44, 18);
	label_beginDay.setFont(new Font("黑体", Font.PLAIN, 22));
	add(label_beginDay);
	
	final JComboBox comboBox_beginTimeMonth = new JComboBox();
	comboBox_beginTimeMonth.setMaximumRowCount(5);
	comboBox_beginTimeMonth.setBounds(277, 174, 51, 24);
	comboBox_beginTimeMonth.setFont(new Font("黑体", Font.PLAIN, 22));
	comboBox_beginTimeMonth.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
	add(comboBox_beginTimeMonth);
	
	final JComboBox comboBox_beginTimeDay = new JComboBox();
	comboBox_beginTimeDay.setMaximumRowCount(5);
	comboBox_beginTimeDay.setBounds(371, 174, 51, 24);
	comboBox_beginTimeDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
	comboBox_beginTimeDay.setFont(new Font("黑体", Font.PLAIN, 22));
	add(comboBox_beginTimeDay);
	
	final JComboBox comboBox_beginTimeYear = new JComboBox();
	comboBox_beginTimeYear.setBounds(170, 173, 81, 24);
	comboBox_beginTimeYear.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019", "2020", "2021", "2022"}));
	comboBox_beginTimeYear.setMaximumRowCount(5);
	comboBox_beginTimeYear.setFont(new Font("黑体", Font.PLAIN, 22));
	add(comboBox_beginTimeYear);
	
	final JComboBox comboBox_endTimeYear = new JComboBox();
	comboBox_endTimeYear.setBounds(494, 175, 81, 24);
	comboBox_endTimeYear.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019", "2020", "2021", "2022"}));
	comboBox_endTimeYear.setMaximumRowCount(5);
	comboBox_endTimeYear.setFont(new Font("黑体", Font.PLAIN, 22));
	add(comboBox_endTimeYear);
	
	JLabel label_endYear = new JLabel("\u5E74");
	label_endYear.setBounds(584, 176, 22, 18);
	label_endYear.setFont(new Font("黑体", Font.PLAIN, 22));
	add(label_endYear);
	
	final JComboBox comboBox_endTimeMonth = new JComboBox();
	comboBox_endTimeMonth.setMaximumRowCount(5);
	comboBox_endTimeMonth.setBounds(610, 174, 51, 24);
	comboBox_endTimeMonth.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
	comboBox_endTimeMonth.setFont(new Font("黑体", Font.PLAIN, 22));
	add(comboBox_endTimeMonth);
	
	JLabel label_endMonth = new JLabel("\u6708");
	label_endMonth.setBounds(668, 177, 22, 18);
	label_endMonth.setFont(new Font("黑体", Font.PLAIN, 22));
	add(label_endMonth);
	
	final JComboBox comboBox_endTimeDay = new JComboBox();
	comboBox_endTimeDay.setMaximumRowCount(5);
	comboBox_endTimeDay.setBounds(704, 174, 51, 24);
	comboBox_endTimeDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
	comboBox_endTimeDay.setFont(new Font("黑体", Font.PLAIN, 22));
	add(comboBox_endTimeDay);
	
	JTextPane textPane_editDocReason = new JTextPane();
	textPane_editDocReason.setEditable(false);
	textPane_editDocReason.setBounds(52, 30, 116, 36);
	textPane_editDocReason.setBackground(SystemColor.menu);
	textPane_editDocReason.setFont(new Font("黑体", Font.PLAIN, 22));
	textPane_editDocReason.setText("\u8BF7\u5047\u7406\u7531\uFF1A");
	add(textPane_editDocReason);
	
	JTextPane textPane_EditDocTime = new JTextPane();
	textPane_EditDocTime.setBounds(52, 166, 116, 32);
	textPane_EditDocTime.setEditable(false);
	textPane_EditDocTime.setText("\u8BF7\u5047\u65F6\u95F4\uFF1A");
	textPane_EditDocTime.setFont(new Font("黑体", Font.PLAIN, 22));
	textPane_EditDocTime.setBackground(SystemColor.menu);
	add(textPane_EditDocTime);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(167, 30, 573, 103);
	add(scrollPane);
	
	final JTextPane textPane_editDocReasonText = new JTextPane();
	scrollPane.setViewportView(textPane_editDocReasonText);
	textPane_editDocReasonText.setBackground(Color.WHITE);
	textPane_editDocReasonText.setFont(new Font("黑体", Font.PLAIN, 22));
	
	JButton button_editDocCommit = new JButton("\u63D0\u4EA4");
	button_editDocCommit.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			DocReason = textPane_editDocReasonText.getText();
			/*请假理由*/
			
			DocBeginYear = (String)comboBox_beginTimeYear.getSelectedItem();
			DocBeginMonth = comboBox_beginTimeMonth.getSelectedIndex()+1;
			DocBeginDay = comboBox_beginTimeDay.getSelectedIndex()+1;
			/*开始请假时间： 年，月，日  */
			
			DocEndYear= (String)comboBox_endTimeYear.getSelectedItem();
			DocEndMonth = comboBox_endTimeMonth.getSelectedIndex()+1;
			DocEndDay= comboBox_endTimeDay.getSelectedIndex()+1;
			/*结束请假时间： 年，月，日  */
			
			EditDoc doc = new EditDoc();
			doc.createWord();
			
			ViewMain.openToDownloadDoc();
			Log.info("点击了修改用户信息");
		}
	});
	button_editDocCommit.setBounds(381, 208, 113, 27);
	add(button_editDocCommit);

	JLabel label_endDay = new JLabel("\u65E5");
	label_endDay.setFont(new Font("黑体", Font.PLAIN, 22));
	label_endDay.setBounds(762, 176, 22, 18);
	add(label_endDay);

	}

}
