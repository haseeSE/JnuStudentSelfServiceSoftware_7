package com.jnu.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.jnu.model.MyLog;

/*
 * created by nizehang;
 */

public class PanelCourseSelection extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelCourseSelection() {	
		setLayout(null);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(154, 96, 325, 53);
		add(textField_1);
		textField_1.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(154, 234, 634, 110);
		panel_1.setVisible(false);
		add(panel_1);
		
		JTable table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"课程编号", "课程名称", "学分", "类别", "时间安排", "教师", "上课地点", "备注"},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		panel_1.add(table);
		
		
		
		JButton btnNewButton = new JButton("搜索课程");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(true);
				MyLog.write(PanelCourseSelection.class, "点击了搜素课程");
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(630, 96, 158, 53);
		add(btnNewButton);
		
	}

}
