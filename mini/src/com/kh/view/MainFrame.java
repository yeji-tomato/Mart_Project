package com.kh.view;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	public MainFrame() {
		this.setTitle("KHmart");
		this.setBounds(350,50,1100,900);
		
		//프레임이 가진 컨테이너 호출해서 이동하고자 하는 패널 추가
		//frame 매개변수 전달하면서
//		this.getContentPane().add(new Login(this));
		this.getContentPane().add(new ProductPage(this));
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
