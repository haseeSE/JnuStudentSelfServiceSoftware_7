package com.jnu.model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyNumKeyAdapter extends KeyAdapter{

	public void keyTyped(KeyEvent e) {
		int keyChar = e.getKeyChar();				
		if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
			
		}else{
			e.consume(); //关键，屏蔽掉非法输入
		}
	}
	
}
