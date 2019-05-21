package com.jnu.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.jnu.model.Score;
import com.jnu.model.UserManager;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

/*
 * created by nizehang;
 */

public class PanelGradeRecord extends JPanel {
	

	private JTable table;
	/**
	 * Create the panel.
	 */
	public PanelGradeRecord() {
		setBackground(Color.LIGHT_GRAY);
		setBounds(0, 0, 982, 524);
		setLayout(null);
		
		JPanel SeekGrade_panel = new JPanel();
		SeekGrade_panel.setBackground(Color.WHITE);
		SeekGrade_panel.setBounds(0, 0, 982, 524);
		add(SeekGrade_panel);
		SeekGrade_panel.setLayout(null);
		String[] arr1=new String[] {"学年","学期","课程名称","学分","成绩","绩点","考试日期","性质","类别","休学类别","取消否"};
		Object[][] cellData = null;
		//table = new JTable(,arr1);
		//DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
		DefaultTableModel tableModel=new DefaultTableModel(null, arr1);
		tableModel.setRowCount(0);
		tableModel.setColumnCount(11);
		UserManager.setScores();
		for(Score score:UserManager.getScores()) {
			String[] arr=new String[11];
			arr[0]=score.getAcademic_year();
		    arr[1]=score.getTerm();
		    arr[2]=score.getCourse();
		    arr[3]=score.getCredit();
		    arr[4]=score.getGrades();
		    arr[5]=score.getGPA();
		    arr[6]=score.getExam_date();
		    arr[7]=score.getExam_properties();
		    arr[8]=score.getCourse_type();
		    arr[9]=score.getStudy_type();
		    arr[10]=score.getStatus();
			tableModel.addRow(arr);
		}
		JTable table =new JTable(tableModel);
		table.invalidate();
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(28, 65, 940, 446);
		table.setRowHeight(30);
		//添加滚动条
        //table.setPreferredScrollableViewportSize(new Dimension(450,63));
        //table.setFillsViewportHeight(true);
        
		JScrollPane jScrollPane=new JScrollPane(table);
		jScrollPane.setVisible(true);
		jScrollPane.setBounds(28, 48, 940, 446);
		SeekGrade_panel.add(jScrollPane);

	}

}
