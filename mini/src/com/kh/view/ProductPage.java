package com.kh.view;

import java.awt.Color;
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

import com.kh.model.controller.UserController;
import com.kh.model.vo.User;

public class ProductPage extends JPanel implements ActionListener{
	private JFrame mainFrame;
	private UserController uc = new UserController();
	public ProductPage(JFrame mf) {
		mainFrame = mf;

		this.setLayout(null);
		
		JLabel productpage = new JLabel("PRODUCT PAGE");
		productpage.setBounds(575,0,100,30);
		this.add(productpage);
		
		JPanel top = new JPanel();
		top.setBounds(100,50,1000,500);
		
		//이미지 크기 지정하여 이미지 객체 생성
		Image logo = new ImageIcon("image/KHmart_logo.jpeg").getImage().getScaledInstance(500, 250, 0);
		//만들어진 이미지 객체를 JLabel에 넣기
		JLabel logo1 = new JLabel(new ImageIcon(logo));
		
		JButton mypage = new JButton("마이페이지");
		mypage.setPreferredSize(new Dimension(100, 80));
		JButton recipe = new JButton("레시피보기");
		recipe.setPreferredSize(new Dimension(100, 80));
		JButton cart = new JButton("장바구니");
		cart.setPreferredSize(new Dimension(100, 80));
	
		mypage.addActionListener(this);
	
		
		//유저이름 띄우기
		ArrayList<User>list = uc.getUserList();
		JLabel userName = new JLabel(list.get(0).getName());

		top.add(userName);
		top.add(logo1);
		top.add(mypage);
		top.add(recipe);
		top.add(cart);
		top.setBackground(Color.white);
		this.setBackground(Color.white);
		this.add(top,"Center");
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel changePanel = null;
		if(e.getSource() instanceof JButton) {
			JButton btn = (JButton)e.getSource();
			switch(btn.getText()) {
			case "마이페이지":
				changePanel = new myPage(mainFrame);
				break;
			case "레시피보기":
				changePanel = new myPage(mainFrame);
				break;
			case "장바구니":
				changePanel = new myPage(mainFrame);
				break;
			}
			mainFrame.getContentPane().removeAll();
			mainFrame.getContentPane().add(changePanel);
			mainFrame.repaint();
			mainFrame.setVisible(true);
		}
		
	}
}