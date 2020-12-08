package com.kh.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.kh.model.controller.UserController;
import com.kh.model.vo.User;

public class MyPage extends JPanel {

	UserController uc = new UserController();
	User userList = uc.getLogin();

	public MyPage(JFrame mf) {

		Font ttfBase = null;
		Font ttfReal = null;
		try {
			BufferedInputStream myStream = new BufferedInputStream(new FileInputStream("BMJUA_ttf.ttf"));
			ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
			ttfReal = ttfBase.deriveFont(Font.PLAIN, 15);
			System.out.println(ttfReal);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (FontFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		this.setLayout(new BorderLayout());
		this.setBackground(Color.white);

		// this.setLayout(null);
		// this.setBackground(Color.red);

		JPanel top = new JPanel();
		top.setBackground(new Color(241, 194, 50));
		// top.setPreferredSize(new Dimension(150, 50));
		this.add(top, "North");

		Image logo = new ImageIcon("image/logo.png").getImage().getScaledInstance(150, 150, 0);
		// 만들어진 이미지 객체를 JLabel에 넣기
		JLabel logo1 = new JLabel(new ImageIcon(logo));
		top.add(logo1, BorderLayout.WEST);

		JLabel text = new JLabel("MY PAGE");
		top.add(text);
		text.setFont(ttfReal.deriveFont(50f));

		JLabel title = new JLabel("MYPAGE");
		title.setFont(new Font("맑은고딕", Font.BOLD, 20));
		title.setBounds(310, 220, 100, 30);
//      this.add(title);

		JPanel main = new JPanel();
		main.setBackground(new Color(106, 168, 79));
		main.setLayout(null);
		add(main);
		// Main
		JButton editInfoButton = new JButton("회원정보 관리");
		editInfoButton.setFont(ttfReal.deriveFont(30f));
		editInfoButton.setBackground(Color.WHITE);
		editInfoButton.setBounds(280, 150, 250, 70);
		main.add(editInfoButton);

		JButton managePointButton = new JButton("포인트 관리");
		managePointButton.setFont(ttfReal.deriveFont(30f));
		managePointButton.setBackground(Color.WHITE);
		managePointButton.setBounds(550, 150, 250, 70);
		main.add(managePointButton);

		editInfoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String userPwd = "";
				userPwd = userList.getPwd();

				// JOptionPane.showMessageDialog(null, "아래 비밀번호를 확인해주세요.");
				// String pass = JOptionPane.showInputDialog("비밀번호를 입력하세요.");

				// ButtonDialog start
				Dialog checkPwdDialog = new Dialog(mf, "비밀번호 확인");
				checkPwdDialog.setBounds(750, 400, 250, 70);
				checkPwdDialog.setSize(300, 200);
				checkPwdDialog.setLayout(null);

				JLabel text1 = new JLabel("비밀번호를 입력하세요");
				text1.setBounds(30, 30, 150, 20);
				checkPwdDialog.add(text1);

				TextField pass = new TextField();
				pass.setBounds(30, 50, 200, 100);
				pass.setEchoChar('*');
				JButton ok = new JButton("확인");
				checkPwdDialog.add(ok);
				ok.setBounds(30, 150, 60, 20);
				checkPwdDialog.add(pass);

				ok.addActionListener(new ActionListener() {
					User user = uc.getLogin();
					String userPwd = "";

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if (pass.getText().equals(user.getPwd())) {
							JOptionPane.showMessageDialog(null, "확인되었습니다.");
							mf.getContentPane().removeAll();
							mf.getContentPane().add(new EditInfo(mf));
							mf.repaint();
							mf.setVisible(true);
							checkPwdDialog.dispose();

							// 창 닫하게,,
							// System.out.println(pass);
						} else {
							JOptionPane.showMessageDialog(null, "비밀번호를 다시 입력해주세요.", "비밀번호 오류",
									JOptionPane.ERROR_MESSAGE);
						}
					}

				});
				JButton cancel = new JButton("취소");
				checkPwdDialog.add(cancel);
				cancel.setBounds(90, 150, 60, 20);
				checkPwdDialog.setVisible(true);

				cancel.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						checkPwdDialog.dispose();

					}

				});
				checkPwdDialog.add(pass);

				// main.add(checkPwdDialog);
//         
//            editInfoButton.addMouseListener(new MouseAdapter() {
//
//               @Override
//               public void mouseClicked(MouseEvent e) {
//
//                  checkPwdDialog.setVisible(true);
//
//               }
//            });

				/*
				 * if (pass.equals(userPwd)) { JOptionPane.showMessageDialog(null, "확인되었습니다.");
				 * mf.getContentPane().removeAll(); mf.getContentPane().add(new EditInfo(mf));
				 * mf.repaint(); mf.setVisible(true); // 창 닫하게,, // System.out.println(pass); }
				 * else { JOptionPane.showMessageDialog(null, "비밀번호를 다시 입력해주세요.", "비밀번호 오류",
				 * JOptionPane.ERROR_MESSAGE); }
				 */

			}

		});

		/*
		 * // ButtonDialog start Dialog checkPwdDialog = new Dialog(mf, "비밀번호 확인");
		 * checkPwdDialog.setBounds(250, 150, 250, 70); // main.add(checkPwdDialog);
		 * 
		 * editInfoButton.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent e) {
		 * 
		 * checkPwdDialog.setVisible(true);
		 * 
		 * } });
		 * 
		 * // Dialog field Label checkedPwd = new Label("비밀번호");
		 * checkedPwd.setBackground(Color.WHITE); // checkedPwd.setBounds(20, 50, 60,
		 * 40); // checkPwdDialog.add(checkedPwd, "North"); TextField pwdLabel = new
		 * TextField(); pwdLabel.setEchoChar('*'); // String insertPwd =
		 * pwdLabel.getText(); // pwdLabel.setBounds(20, 50, 200, 30); //
		 * checkPwdDialog.add(pwdLabel, "Center");
		 * 
		 * JPanel button2Panel = new JPanel(); JButton button2 = new JButton("확인");
		 * button2Panel.add(button2); // checkPwdDialog.add(button2Panel, "South");
		 * 
		 * User user= uc.getLogin(); String userPwd = ""; //
		 * System.out.println(user.getPaypwd()); // System.out.println(list.toString());
		 * button2.addActionListener(new ActionListener() { String userPwd = "";
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * 
		 * 
		 * if (pwdLabel.getText().equals(user.getPwd())) { System.out.println(userPwd);
		 * JOptionPane.showMessageDialog(null, "확인되었습니다!!");
		 * 
		 * mf.getContentPane().removeAll(); mf.getContentPane().add(new EditInfo(mf));
		 * mf.repaint(); mf.setVisible(true);
		 * 
		 * checkPwdDialog.dispose(); return; } else {
		 * JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다."); checkPwdDialog.dispose();
		 * } }
		 * 
		 * });
		 */

		// Manage Point

		managePointButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				mf.getContentPane().removeAll();
				mf.getContentPane().add(new ManagePoint(mf));
				mf.repaint();
				mf.setVisible(true);

			}
		});

		JButton backToHome = new JButton("뒤로가기");
		backToHome.setBounds(700, 280, 330, 100);
//      this.add(backToHome);

		backToHome.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				mf.getContentPane().removeAll();
				mf.getContentPane().add(new ProductPage(mf));
				mf.repaint();
				mf.setVisible(true);

			}

		});

	}
}