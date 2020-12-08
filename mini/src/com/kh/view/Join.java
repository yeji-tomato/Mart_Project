package com.kh.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

public class Join extends JPanel {
   private JFrame mainFrame;
   private User user;
   private UserController uc = new UserController();
   private ArrayList<User> list = uc.openList();
   private Boolean tt;
   private boolean sameId;
   public Join(JFrame mf) {
      
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
      mainFrame = mf;
      this.setLayout(null);
      this.setBackground(new Color(106,168,79));
      JPanel p = new JPanel();
       Image icon = new ImageIcon("image/logo.png").getImage().getScaledInstance(250, 250, 0);
         JLabel label = new JLabel(new ImageIcon(icon));
         label.setBackground(Color.WHITE);
         add(label);
      JLabel l_id = new JLabel("아이디");
       l_id.setFont(ttfReal.deriveFont(15f));
      JButton idCheck = new JButton("중복확인");
       idCheck.setFont(ttfReal.deriveFont(15f));
      idCheck.setBackground(Color.white);
      JLabel l_pwd = new JLabel("비밀번호 ");
        l_pwd.setFont(ttfReal.deriveFont(15f));
      JLabel l_pwd2 = new JLabel("비밀번호 확인");
        l_pwd2.setFont(ttfReal.deriveFont(15f));
      JLabel l_pwdcheck = new JLabel("영문 대소문자 , 특수문자 포함 8글자 이상");
        l_pwdcheck.setFont(ttfReal.deriveFont(15f));
      JButton pwdCheck = new JButton("확인");
       pwdCheck.setFont(ttfReal.deriveFont(15f));
      pwdCheck.setBackground(Color.WHITE);
      JButton pwdCheck2 = new JButton("check");
        pwdCheck2.setFont(ttfReal.deriveFont(15f));
      pwdCheck2.setBackground(Color.WHITE);
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


      add(l_id);
      add(idCheck);
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
      TextField t_id = new TextField();
      TextField pwd = new TextField();
      TextField pwd2 = new TextField();
      TextField name = new TextField();
      TextField age = new TextField();
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
      JButton save = new JButton("가입");
        save.setFont(ttfReal.deriveFont(15f));
      save.setBackground(Color.white);
      JButton cancel = new JButton("취소");
        cancel.setFont(ttfReal.deriveFont(15f));
      cancel.setBackground(Color.white);
      add(save);
      add(cancel);
        label.setBounds(100, 25, 300, 800);
      l_id.setBounds(450, 180, 40, 40);            // x - > 33
      l_pwd.setBounds(440, 220, 60, 40);
      l_pwd2.setBounds(415, 300, 100, 38);
      l_name.setBounds(450, 365, 50, 38);

      l_age.setBounds(450, 420, 40, 40);
      l_address.setBounds(450, 460, 50, 40);
      l_cardNum.setBounds(435, 500, 50, 40);
      l_payNum.setBounds(415, 540, 90, 40);

      t_id.setBounds(520, 180, 200, 30);
      pwd.setBounds(520, 220, 200, 30);
      pwd2.setBounds(520, 300, 200, 30);
      name.setBounds(520, 370, 200, 30);

      age.setBounds(520, 420, 50, 30);
      address.setBounds(520, 460, 200, 30);
      cardNum.setBounds(520, 500, 200, 30);
      paypwd.setBounds(520, 540, 200, 30);

      save.setBounds(520, 600, 80, 30);
      cancel.setBounds(635, 600, 80, 30);
      idCheck.setBounds(723, 180, 90, 30);
      pwdCheck.setBounds(723, 220, 90, 30);
      pwdCheck2.setBounds(723, 300, 100, 30);
      l_pwdcheck.setBounds(520, 250, 300, 40);
      l_pwdcheck2.setBounds(520, 335, 100, 30);
      
      
      pwdCheck.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String pwPattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$";
            

            String a = pwd.getText().toString();

            tt = Pattern.matches(pwPattern, a);

            if (tt == true) {
               l_pwdcheck.setText("사용 가능한 비밀번호 입니다.");
               return;
            } else {
               l_pwdcheck.setText("사용 불가능한 비밀번호 입니다.");
               return;
            }
         }

      });

      setVisible(true);
      save.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent T) {// 회원가입 데이터 저장
            String pwdc1 = pwd.getText();
            String pwdc2 = pwd2.getText();
            try {

               if (t_id.getText().equals("")) {
                  JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
               } else if (pwd.getText().equals("")) {
                  JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
               } else if (name.getText().equals("")) {
                  JOptionPane.showMessageDialog(null, "이름을 입력하세요");
               } else if (age.getText().equals("")) {
                  JOptionPane.showMessageDialog(null, "나이를 입력하세요");
               } else if (address.getText().equals("")) {
                  JOptionPane.showMessageDialog(null, "주소를 입력하세요");
               } else if (cardNum.getText().equals("")) {
                  JOptionPane.showMessageDialog(null, "카드번호를 입력하세요");
               } else if (paypwd.getText().equals("")) {
                  JOptionPane.showMessageDialog(null, "결제비밀번호를 입력하세요");
               } else if (sameId) {
                  //중복된 아이디 
                  JOptionPane.showMessageDialog(null, "아이디를 확인해주세요");
               }else if (!tt) {
                  //사용불가능한 비밀번호  
                  JOptionPane.showMessageDialog(null, "사용가능한 비밀번호로 변경해주세요.");
               }else if (!pwdc1.equals(pwdc2)) {
                  //비밀번호와 비밀번호 확인 값이 다를경우  
                  JOptionPane.showMessageDialog(null, "비밀번호 확인을 해주세요.");
               }else {
                  String name1 = name.getText();
                  String pwd1 = pwd.getText();
                  String t_id1 = t_id.getText();
                  int age1 = Integer.parseInt(age.getText());
                  String address1 = address.getText();

                  int cardNum1 = Integer.parseInt(cardNum.getText());
                  String paypwd1 = paypwd.getText();

                  User user = new User(name1, age1, t_id1, pwd1, paypwd1, address1, cardNum1);
                  uc.addList(user);
                  uc.saveList(list);

                  JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!!");
                  mf.getContentPane().removeAll();
                  mf.getContentPane().add(new Login(mf));
                  mf.repaint();
                  mf.setVisible(true);
               }

            } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
            }

         }

      });
         idCheck.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
//                try {
//                
//                   for(int i = 0; i < list.size(); i++) {
//                      if (t_id.getText().equals(list.get(i).getId())) {
//                         JOptionPane.showMessageDialog(null, "중복된 아이디입니다.");
//                         break;
//                      }else {
//                         JOptionPane.showMessageDialog(null, "아이디 사용 가능");
//                      }
//                   }
//                   
//                   
//                   
//
//                }
//                catch (Exception ex) {
//                         JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
//                      }
                sameId = false;
                for(int i = 0; i < list.size(); i++) {
                      if (t_id.getText().equals(list.get(i).getId())) {
//                         JOptionPane.showMessageDialog(null, "중복된 아이디입니다.");
                         sameId = true;
                         break;
                      }else {
                         
                       //  JOptionPane.showMessageDialog(null, "아이디 사용 가능");
                      }
                   }
                if (sameId) {
                      JOptionPane.showMessageDialog(null, "중복된 아이디입니다.");
                      
                   }else {
                      
                      JOptionPane.showMessageDialog(null, "아이디 사용 가능");
                   }
                
             }

          });
      pwdCheck2.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String pwdc1 = pwd.getText();
            String pwdc2 = pwd2.getText();
            if (pwdc1.equals(pwdc2)) {
               l_pwdcheck2.setText("비밀번호 일치");
               return;
            } else {
               l_pwdcheck2.setText("비밀번호 불일치");
               return;
            }
         }

      });
      cancel.addActionListener(new ActionListener() { // 취소

            @Override
            public void actionPerformed(ActionEvent e) {
               // TODO Auto-generated method stub
               mf.getContentPane().removeAll();
               mf.getContentPane().add(new Login(mf));
               mf.repaint();
               mf.setVisible(true);
            }

         });


   }

}