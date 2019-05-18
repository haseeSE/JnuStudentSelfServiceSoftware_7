package com.jnu.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

/*
 * created by nizehang;
 */

public class PanelGradeRecord extends JPanel {
	
	private Logger Log = Logger.getLogger(getClass());

	/**
	 * Create the panel.
	 */
	public PanelGradeRecord() {
		// <----------	LOG: CREATED	------------>
		Log.info("CREATED");
		
		JTable table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u5B66\u5E74", "\u5B66\u671F", "\u8BFE\u7A0B\u540D\u79F0", "\u5B66\u5206", "\u6210\u7EE9", "\u7EE9\u70B9", "\u8BFE\u7A0B\u7C7B\u522B"},
				{"2016-2017", "\u4E0A", "\u4E2D\u56FD\u8FD1\u4EE3\u53F2\u7EB2\u8981", new Double(2.0), new Double(88.0), new Double(7.6), "\u5FC5\u4FEE\u8BFE"},
				{"2016-2017", "\u4E0A", "\u5927\u5B66\u82F1\u8BED\u4E2D\u7EA7", new Double(4.0), new Double(80.0), new Double(12.0), "\u5FC5\u4FEE\u8BFE"},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"\u5B66\u5E74", "\u5B66\u671F", "\u8BFE\u7A0B\u540D\u79F0", "\u5B66\u5206", "\u6210\u7EE9", "\u7EE9\u70B9", "\u8BFE\u7A0B\u7C7B\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.setBounds(70, 162, 683, 278);
		
		JLabel label = new JLabel("\u6210\u7EE9", JLabel.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 30));
		label.setBounds(340, 120, 120, 35);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(364)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(161)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(164, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addComponent(label)
					.addGap(124)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(192, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
