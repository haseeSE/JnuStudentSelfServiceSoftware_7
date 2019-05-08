package com.jnu.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.jnu.model.MyLog;

import java.awt.Font;
import javax.swing.JScrollPane;

/*
 * create by chenqinquan;
 */

public class PanelSubMessage extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelSubMessage() {
		setLayout(null);
		
		JTextArea textArea_dom = new JTextArea();
		textArea_dom.setEditable(false);
		textArea_dom.setFont(new Font("新宋体", Font.PLAIN, 14));
		textArea_dom.setText("\u5BBF\u820D\u53F7\uFF1A");
		textArea_dom.setBackground(Color.LIGHT_GRAY);
		textArea_dom.setBounds(51, 62, 228, 25);
		add(textArea_dom);
		
		JButton button_electAdd = new JButton("\u5145\u503C");
		button_electAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO
				
				MyLog.write(PanelSubMessage.class, "点击了电费充值");
			}
		});
		button_electAdd.setBackground(Color.CYAN);
		button_electAdd.setBounds(210, 87, 69, 25);
		add(button_electAdd);
		
		JTextArea textArea_elect = new JTextArea();
		textArea_elect.setEditable(false);
		textArea_elect.setFont(new Font("新宋体", Font.BOLD, 16));
		textArea_elect.setText("\u6C34\u7535\u8D39\u76F8\u5173");
		textArea_elect.setBackground(Color.LIGHT_GRAY);
		textArea_elect.setBounds(51, 37, 228, 25);
		add(textArea_elect);
		
		JTextArea textArea_electLast = new JTextArea();
		textArea_electLast.setEditable(false);
		textArea_electLast.setFont(new Font("新宋体", Font.PLAIN, 14));
		textArea_electLast.setText("\u4F59\u989D\uFF1A");
		textArea_electLast.setBackground(Color.LIGHT_GRAY);
		textArea_electLast.setBounds(51, 87, 160, 25);
		add(textArea_electLast);
		
		JButton button_electFresh = new JButton("\u5237\u65B0");
		button_electFresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO
				
				MyLog.write(PanelSubMessage.class, "点击了电费信息更新");
			}
		});
		button_electFresh.setBackground(Color.CYAN);
		button_electFresh.setBounds(210, 112, 69, 25);
		add(button_electFresh);
		
		JTextArea txtrTime = new JTextArea();
		txtrTime.setEditable(false);
		txtrTime.setText("Time:");
		txtrTime.setFont(new Font("新宋体", Font.PLAIN, 14));
		txtrTime.setBackground(Color.LIGHT_GRAY);
		txtrTime.setBounds(51, 112, 160, 25);
		add(txtrTime);
		
		JTextArea textArea_card = new JTextArea();
		textArea_card.setEditable(false);
		textArea_card.setFont(new Font("新宋体", Font.BOLD, 16));
		textArea_card.setText("\u5B66\u751F\u996D\u5361\u76F8\u5173");
		textArea_card.setBackground(Color.LIGHT_GRAY);
		textArea_card.setBounds(51, 177, 228, 25);
		add(textArea_card);
		
		JTextArea textArea_cardID = new JTextArea();
		textArea_cardID.setEditable(false);
		textArea_cardID.setFont(new Font("新宋体", Font.PLAIN, 14));
		textArea_cardID.setText("\u996D\u5361\u53F7\uFF1A");
		textArea_cardID.setBackground(Color.LIGHT_GRAY);
		textArea_cardID.setBounds(51, 202, 228, 25);
		add(textArea_cardID);
		
		JTextArea textArea_cardLast = new JTextArea();
		textArea_cardLast.setEditable(false);
		textArea_cardLast.setFont(new Font("新宋体", Font.PLAIN, 14));
		textArea_cardLast.setText("\u4F59\u989D\uFF1A");
		textArea_cardLast.setBackground(Color.LIGHT_GRAY);
		textArea_cardLast.setBounds(51, 227, 160, 25);
		add(textArea_cardLast);
		
		JTextArea txtrTime_1 = new JTextArea();
		txtrTime_1.setEditable(false);
		txtrTime_1.setFont(new Font("新宋体", Font.PLAIN, 14));
		txtrTime_1.setText("Time:");
		txtrTime_1.setBackground(Color.LIGHT_GRAY);
		txtrTime_1.setBounds(51, 252, 160, 25);
		add(txtrTime_1);
		
		JButton button_cardFresh = new JButton("\u5237\u65B0");
		button_cardFresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				MyLog.write(PanelSubMessage.class, "点击了饭卡信息刷新");
			}
		});
		button_cardFresh.setBackground(Color.CYAN);
		button_cardFresh.setBounds(210, 252, 69, 25);
		add(button_cardFresh);
		
		JButton button_cardAdd = new JButton("\u5145\u503C");
		button_cardAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO
				
				MyLog.write(PanelSubMessage.class, "点击了饭卡充值");
			}
		});
		button_cardAdd.setBackground(Color.CYAN);
		button_cardAdd.setBounds(210, 227, 69, 25);
		add(button_cardAdd);
	}
}
