package com.kh.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.model.controller.UserController;
import com.kh.model.vo.User;

public class EditInfo extends JPanel {

	UserController uc = new UserController();
	User user = uc.getLogin();

	private ArrayList<User> list = uc.openList();
	private int UserNum;

	public EditInfo(JFrame mf) {

		this.setLayout(null);
		this.setBackground(new Color(106,168,79));
		
		
		
		  Font ttfBase = null;
	         Font ttfReal = null;
	         try {
	            BufferedInputStream myStream = new BufferedInputStream(new FileInputStream("BMJUA_ttf.ttf"));
	            ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
	            ttfReal = ttfBase.deriveFont(Font.PLAIN, 15);
	            System.out.println(ttfReal);
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
		
		
		
		
		JPanel p = new JPanel();
		JLabel pic = new JLabel(new ImageIcon("image/change.jpg"));
		JLabel l_id = new JLabel("아이디");
		l_id.setFont(ttfReal.deriveFont(15f));
		JButton idCheck = new JButton("중복확인");
		idCheck.setFont(ttfReal.deriveFont(15f));
		JLabel l_pwd = new JLabel("비밀번호 ");
		l_pwd.setFont(ttfReal.deriveFont(15f));
		JLabel l_pwd2 = new JLabel("비밀번호 확인");
		
		l_pwd2.setFont(ttfReal.deriveFont(15f));
		JLabel l_pwdcheck = new JLabel("영문 대소문자 , 특수문자 포함 8글자 이상");
		l_pwdcheck.setFont(ttfReal.deriveFont(15f));
		JButton pwdCheck = new JButton("확인");
		pwdCheck.setFont(ttfReal.deriveFont(15f));
		pwdCheck.setBackground(new Color(241,194,50));
		JButton pwdCheck2 = new JButton("check");
		pwdCheck2.setFont(ttfReal.deriveFont(15f));
		pwdCheck2.setBackground(new Color(241,194,50));
		JLabel l_name = new JLabel("이름");
		l_name.setFont(ttfReal.deriveFont(15f));
		JLabel l_age = new JLabel("나이");
		l_age.setFont(ttfReal.deriveFont(15f));
		JLabel l_address = new JLabel("주소");
		l_address.setFont(ttfReal.deriveFont(15f));
		JLabel l_cardNum = new JLabel("카드번호");
		l_cardNum.setFont(ttfReal.deriveFont(15f));
		JLabel l_payNum = new JLabel("결제 비밀번호");
		l_payNum.setFont(ttfReal.deriveFont(15f));
		JLabel l_pwdcheck2 = new JLabel("");
		l_pwdcheck2.setFont(ttfReal.deriveFont(15f));

		add(pic);
		add(l_id);

		add(pwdCheck);
		add(pwdCheck2);
		add(l_pwd);
		add(l_pwd2);
		add(l_pwdcheck);
		add(l_pwdcheck2);
		add(l_name);
		add(l_age);
		add(l_address);
		add(l_cardNum);
		add(l_payNum);
		TextField t_id = new TextField(user.getId());
		t_id.setEditable(false);
		TextField pwd = new TextField();
		TextField pwd2 = new TextField();
		TextField name = new TextField(user.getName());
		name.setEditable(false);
		TextField age = new TextField(user.getAge() + "");
		System.out.println(user.getAge());
		age.setEditable(false);
		TextField address = new TextField();
		TextField cardNum = new TextField();
		TextField paypwd = new TextField();

		add(t_id);
		add(pwd);
		add(pwd2);
		add(name);
		add(age);
		add(address);
		add(cardNum);
		add(paypwd);
		pwd.setEchoChar('*');
		paypwd.setEchoChar('*');
		pwd2.setEchoChar('*');
		JButton save = new JButton("저장");
		save.setFont(ttfReal.deriveFont(15f));
		save.setBackground(new Color(241,194,50));
		JButton cancel = new JButton("취소");
		cancel.setFont(ttfReal.deriveFont(15f));
		cancel.setBackground(new Color(241,194,50));
		add(save);
		add(cancel);
		pic.setBounds(250, 0, 700, 100);
		l_id.setBounds(410, 130, 40, 40);
		l_pwd.setBounds(400, 170, 70, 40);
		l_pwd2.setBounds(373, 250, 100, 38);
		l_name.setBounds(422, 315, 50, 38);

		l_age.setBounds(422, 370, 40, 40);
		l_address.setBounds(422, 410, 50, 40);
		l_cardNum.setBounds(400, 450, 50, 40);
		l_payNum.setBounds(373, 490, 90, 40);

		t_id.setBounds(480, 130, 200, 30);
		pwd.setBounds(480, 170, 200, 30);
		pwd2.setBounds(480, 250, 200, 30);
		name.setBounds(480, 320, 200, 30);

		age.setBounds(480, 370, 200, 30);
		address.setBounds(480, 410, 200, 30);
		cardNum.setBounds(480, 450, 200, 30);
		paypwd.setBounds(480, 490, 200, 30);

		save.setBounds(445, 570, 80, 30);
		cancel.setBounds(560, 570, 80, 30);
		idCheck.setBounds(690, 130, 90, 30);
		pwdCheck.setBounds(690, 170, 90, 30);
		pwdCheck2.setBounds(690, 250, 100, 30);
		l_pwdcheck.setBounds(480, 200, 300, 40);
		l_pwdcheck2.setBounds(480, 280, 100, 30);
		this.setVisible(true);
		pwdCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String pwPattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$";

				String a = pwd.getText().toString();
				String b = user.getPwd();
				Boolean tt = Pattern.matches(pwPattern, a);

				if (tt == true) {
					l_pwdcheck.setText("사용 가능한 비밀번호 입니다.");
					return;
				} else if (a.equals(b)) {
					l_pwdcheck.setText("same pwd");
				}

				else {

					l_pwdcheck.setText("사용 불가능한 비밀번호 입니다.");
					return;
				}
			}

		});
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				System.out.println("현재 로그인된 회원 " + user.toString());
				// userList.dat파일에 있는 유저중 현재 로그인한 유저의 인덱스값찾기
				for (int i = 0; i < list.size(); i++) {
					if (user.getId().equals(list.get(i).getId())) {
						list.get(i).setPwd(pwd.getText());
						list.get(i).setAddress(address.getText());
						list.get(i).setCardNum(Integer.parseInt(cardNum.getText()));
						list.get(i).setPaypwd(paypwd.getText());

					}
				}
				uc.saveList(list);
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).toString());

				}
				JOptionPane.showMessageDialog(null, "정보가 변경되었습니다."); // change
				mf.getContentPane().removeAll();
				mf.getContentPane().add(new Login(mf));
				mf.repaint();
				mf.setVisible(true);

			}

		});

		cancel.addActionListener(new ActionListener() { // 취소

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mf.getContentPane().removeAll();
				mf.getContentPane().add(new MyPage(mf));
				mf.repaint();
				mf.setVisible(true);
			}

		});

		pwdCheck2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String pwdc1 = pwd.getText();
				String pwdc2 = pwd2.getText();
				String pwdc3 = user.getPwd();
				if (pwdc1.equals(pwdc2)) {
					l_pwdcheck2.setText("확인되었습니다.");
					return;
				} else {
					l_pwdcheck2.setText("비밀번호가 다릅니다.");
					return;
				}

			}

		});

	}
}