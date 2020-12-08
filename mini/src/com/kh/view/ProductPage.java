package com.kh.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.model.controller.ProductController;
import com.kh.model.controller.UserController;
import com.kh.model.vo.Product;
import com.kh.model.vo.User;

public class ProductPage extends JPanel implements ActionListener {
	private JFrame mainFrame;
	private UserController uc = new UserController();
	private ProductController pc = new ProductController();
	private int ctn = 0;
	private JPanel changePanel;
	private User userl;

	public ProductPage(JFrame mf) {

		Font ttfBase = null;
		Font ttfReal = null;
		try {
			BufferedInputStream myStream = new BufferedInputStream(new FileInputStream("BMJUA_ttf.ttf"));
			ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
			ttfReal = ttfBase.deriveFont(Font.PLAIN, 18);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		mainFrame = mf;

		this.setLayout(new BorderLayout());

		JPanel top = new JPanel();
		top.setLayout(new BorderLayout());

		// 이미지 크기 지정하여 이미지 객체 생성
		Image logo = new ImageIcon("image/logo.png").getImage().getScaledInstance(150, 150, 0);
		// 만들어진 이미지 객체를 JLabel에 넣기
		JLabel logo1 = new JLabel(new ImageIcon(logo));
//      top.setLayout(new FlowLayout(FlowLayout.LEFT));

		JPanel menuPanel = new JPanel();

//		JButton login = new JButton("로그인/회원가입");
//		login.setBorderPainted(false);
//		login.setForeground(Color.BLACK);
//		login.setBackground(new Color(241, 194, 50));
//		login.setPreferredSize(new Dimension(150, 50));
		
		//로그인 된 회원정보 가져오기
		userl = uc.getLogin();
		// 유저이름 띄우기
		userl = uc.getLogin();
		JLabel userName = new JLabel();

		if (userl.getName() == null) {
			userName = new JLabel("환영합니다.");
		} else {
			userName = new JLabel(userl.getName() + "님");
		}
		userName.setForeground(new Color(102, 102, 255));
		menuPanel.add(userName);

		JLabel userPoint = new JLabel("    "+userl.getPoint()+"포인트");
		userPoint.setForeground(new Color(102, 102, 255));
		menuPanel.add(userPoint);
		
		JButton login = new JButton();
		JButton logout = new JButton();

		if (userl.getName() == null) {
			login = new JButton("로그인/회원가입");
			login.setBorderPainted(false);
			login.setForeground(Color.BLACK);
			login.setBackground(new Color(241, 194, 50));
			login.setPreferredSize(new Dimension(150, 50));
			menuPanel.add(login);
		} else if (userl.getName() != null) {
			logout = new JButton("로그아웃");
			logout.setBorderPainted(false);
			logout.setForeground(Color.BLACK);
			logout.setBackground(new Color(241, 194, 50));
			logout.setPreferredSize(new Dimension(150, 50));

			menuPanel.add(logout);
		}

		JButton mypage = new JButton("마이페이지");
		mypage.setForeground(Color.BLACK);
		mypage.setBorderPainted(false);
		mypage.setBackground(new Color(241, 194, 50));
		mypage.setPreferredSize(new Dimension(120, 50));
		JButton recipe = new JButton("레시피보기");
		recipe.setBorderPainted(false);
		recipe.setBackground(new Color(241, 194, 50));
		recipe.setPreferredSize(new Dimension(120, 50));
		recipe.setForeground(Color.BLACK);

		login.addActionListener(this);
		logout.addActionListener(this);
		mypage.addActionListener(this);
		recipe.addActionListener(this);

		top.add(logo1, BorderLayout.WEST);

		JLabel khMart = new JLabel("KH MART");
		khMart.setFont(ttfReal.deriveFont(50f));
		khMart.setForeground(Color.BLACK);
		top.add(khMart);


		userPoint.setFont(ttfReal);
		userName.setFont(ttfReal);
		logout.setFont(ttfReal);
		login.setFont(ttfReal);
		mypage.setFont(ttfReal);
		recipe.setFont(ttfReal);

		menuPanel.add(mypage);
		menuPanel.add(recipe);
		menuPanel.setBackground(new Color(241, 194, 50));

		top.add(menuPanel, BorderLayout.EAST);
		top.setBackground(new Color(241, 194, 50));
		this.add(top, "North");

//      this.setBackground(Color.white);

		JPanel showProduct = new JPanel();
		showProduct.setLayout(new GridLayout(0, 5));

		// 상품을 선택할 수 있는 체크박스 만들기
		JCheckBox[] buttons = new JCheckBox[100];
		
		ArrayList<Product> plist = pc.getProductList();
		for (int i = 0; i < plist.size(); i++) {
			JPanel sp = new JPanel();
			sp.setSize(new Dimension(170, 170));
			Image icon = new ImageIcon(plist.get(i).getImg()).getImage().getScaledInstance(170, 150, 0);
			sp.add(new JLabel(new ImageIcon(icon)));
			
			/// 품절표기
			//System.out.println(plist.get(i).toString());
			if (plist.get(i).getCnt() >= 1) {
				buttons[i] = new JCheckBox(plist.get(i).getpName());
			} else {		
				buttons[i] = new JCheckBox("품절 상품");
				buttons[i].setEnabled(false);
				buttons[i].setForeground(Color.BLACK);
				
			}
			buttons[i].setFont(ttfReal.deriveFont(20f));
			buttons[i].setBackground(new Color(106, 168, 79));
			buttons[i].setForeground(Color.WHITE);
			
			sp.add(buttons[i]);

			JLabel price = new JLabel(plist.get(i).getPrice() + "원");
			price.setForeground(Color.WHITE);
			sp.add(price);
			price.setFont(ttfReal.deriveFont(20f));
			sp.setBackground(new Color(106, 168, 79));
			showProduct.setBackground(new Color(106, 168, 79));
			showProduct.add(sp);

		}

		//장바구니.dat파일에 담을 arraylist
		ArrayList<Product> containP = new ArrayList<>();
		JPanel bottom = new JPanel();
		bottom.setBackground(new Color(106, 168, 79));

		JButton jb = new JButton("장바구니 담기");
		jb.setBackground(new Color(241, 194, 50));
		jb.setBorderPainted(false);
		jb.setFont(ttfReal);
		bottom.add(jb);
		bottom.setPreferredSize(new Dimension(100, 80));

		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				containP.removeAll(plist);
				for (int i = 0; i < plist.size(); i++) {
					if (buttons[i].isSelected()) {
						if (plist.get(i).isAdult()) {
							if (userl.getAge() > 20) {
								ctn++;
								Product contain = new Product();
								contain = new Product(plist.get(i).getpName(), plist.get(i).getPrice(),
										plist.get(i).getCnt(), plist.get(i).getImg(), plist.get(i).isAdult());
								containP.add(contain);
							} else {
								JOptionPane.showMessageDialog(null, "청소년 구매 불가 상품이 포함되어있습니다.\n다시 선택해주세요");
								return;
							}
						} else {
							ctn++;
							Product contain = new Product();
							contain = new Product(plist.get(i).getpName(), plist.get(i).getPrice(),
									plist.get(i).getCnt(), plist.get(i).getImg(), plist.get(i).isAdult());
							containP.add(contain);
						}
					}

				}
				if (ctn == 0) {
					JOptionPane.showMessageDialog(null, "선택한 상품이 없습니다");
				} else if ((ctn == 0 && userl.getName() == null) || userl.getName() == null) {
					JOptionPane.showMessageDialog(null, "로그인이 필요합니다.");
					changePanel = new Login(mainFrame);
					mainFrame.getContentPane().removeAll();
					mainFrame.getContentPane().add(changePanel);
					mainFrame.repaint();
					mainFrame.setVisible(true);
				} else {
					// 담을 거 파일로 만들어서내보내기
					pc.saveBasketFile(containP);
					changePanel = new Basket(mainFrame);
					mainFrame.getContentPane().removeAll();
					mainFrame.getContentPane().add(changePanel);
					mainFrame.repaint();
					mainFrame.setVisible(true);

				}

			}

		});

		// bottom.setBounds(500,400, 100, 100);

		this.add(showProduct, "Center");
		this.add(bottom, "South");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		changePanel = null;

		if (e.getSource() instanceof JButton) {
			JButton btn = (JButton) e.getSource();
			switch (btn.getText()) {
			case "로그인/회원가입":
				changePanel = new Login(mainFrame);
				break;
			case "로그아웃":
				userl = new User();
				uc.logOut(userl);
				changePanel = new ProductPage(mainFrame);
				break;

			case "마이페이지":
				changePanel = new MyPage(mainFrame);
				break;
			case "레시피보기":
				changePanel = new RecipePage(mainFrame);
//            changePanel = new CatePanel(mainFrame);
				break;
			case "장바구니":
				changePanel = new MyPage(mainFrame);
				break;
			}
			mainFrame.getContentPane().removeAll();
			mainFrame.getContentPane().add(changePanel);
			mainFrame.repaint();
			mainFrame.setVisible(true);
		}

	}
}