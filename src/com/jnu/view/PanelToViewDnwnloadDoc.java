package com.jnu.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class PanelToViewDnwnloadDoc extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelToViewDnwnloadDoc() {
		setLayout(null);
		
		JLabel LabelText = new JLabel("提交成功。若想下载模版，请点击");
		LabelText.setFont(new Font("黑体", Font.PLAIN, 22));
		LabelText.setBounds(14, 41, 338, 28);
		add(LabelText);
		
		JButton Button_download = new JButton("下载");
		Button_download.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewMain.openDownloadDoc();
			}
		});
		Button_download.setBounds(343, 41, 63, 27);
		add(Button_download);

	}
}
