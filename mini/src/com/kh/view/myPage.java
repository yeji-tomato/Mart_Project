package com.kh.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPage extends JPanel{
	//private ProductController pc = new ProductController();
	public MyPage(JFrame mf) {
		this.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("MYPAGE");
		title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title,"North");
		
	}
}
