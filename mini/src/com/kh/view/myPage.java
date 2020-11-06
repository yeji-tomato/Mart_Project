package com.kh.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.model.controller.ProductController;

public class myPage extends JPanel{
	private ProductController pc = new ProductController();
	public myPage(JFrame mf) {
		this.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("MYPAGE");
		title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title,"North");
		
	}
}
