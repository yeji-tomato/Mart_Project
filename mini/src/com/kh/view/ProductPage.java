package com.kh.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.model.vo.Product;

public class ProductPage extends JPanel implements ActionListener{
	private JFrame mainFrame;
	
	public ProductPage(JFrame mf) {
		mainFrame = mf;
		
		
		this.setLayout(null);
		
		
		JLabel productpage = new JLabel("PRODUCT PAGE");
		productpage.setBounds(575,0,100,30);
		this.add(productpage);
		
		//이미지 크기 지정하여 이미지 객체 생성
		Image logo = new ImageIcon("image/KHmart_logo.jpeg").getImage().getScaledInstance(500, 250, 0);
		//만들어진 이미지 객체를 JLabel에 넣기
		JLabel label1 = new JLabel(new ImageIcon(logo));
		
		JButton mypage = new JButton("마이페이지");
		mypage.setPreferredSize(new Dimension(100, 80));
		JButton recipe = new JButton("레시피보기");
		recipe.setPreferredSize(new Dimension(100, 80));
	
		JPanel top = new JPanel();
		top.setBounds(350,50,500,500);
		
		top.add(label1);
	
		top.add(mypage);
		top.add(recipe);
		this.add(top);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
