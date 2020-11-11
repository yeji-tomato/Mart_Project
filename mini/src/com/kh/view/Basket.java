package com.kh.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kh.model.controller.ProductController;
import com.kh.model.vo.Product;

public class Basket extends JPanel {
	private JFrame mainFrame;
	private ProductController pc = new ProductController();
	private int countNum;
	public Basket(JFrame mf) {
		mainFrame = mf;
		this.setLayout(null);

		JLabel title = new JLabel("장바구니페이지");
		title.setBounds(575, 0, 100, 30);
		this.add(title);
		
		JPanel showProduct = new JPanel();
		showProduct.setBounds(150, 300, 1000, 500);
		showProduct.setLayout(new GridLayout(0, 5));

		
		ArrayList<Product> plist = pc.getBasketList();
		System.out.println(plist.size());
		JPanel sp = new JPanel();
		sp.setBackground(Color.cyan);
		sp.setSize(new Dimension(150, 150));
		sp.add(new JLabel("장바구니테스트"));
        TextField suja[] = new TextField[plist.size()];
		for (int i = 0; i < plist.size(); i++) {
		//JButton[] btn = new JButton[plist.size()];
	
		Image icon = new ImageIcon(plist.get(i).getImg()).getImage().getScaledInstance(150, 150, 0);
		sp.add(new JLabel(new ImageIcon(icon)));
		sp.add(new JLabel("상품이름 : "+plist.get(i).getpName()));
		suja[i] = new TextField("0");
		
		countNum=1;
		JTextArea taCnt = new JTextArea(countNum+"");
//		JLabel count = new JLabel(countNum+"");
//		sp.add(taCnt);
		
		JButton dct = new JButton("<");
		sp.add(dct);
		dct.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				countNum--;
				sp.add(taCnt);
				System.out.println(countNum);
			}
			
		});
//		sp.add(new JLabel(countNum+""));
		JButton ict = new JButton(">");
		sp.add(ict);
		ict.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				countNum++;
				System.out.println(countNum);
			}
			
		});
		
		
		sp.add(new JLabel(plist.get(0).getPrice() + "원"));
	
		int totalSum = countNum*plist.get(0).getPrice();
		JLabel total = new JLabel("총합계 : "+totalSum);	
		sp.add(total);
		showProduct.add(sp);
		}

		this.add(showProduct, "Center");
		title.setHorizontalAlignment(JLabel.CENTER);


	}
}