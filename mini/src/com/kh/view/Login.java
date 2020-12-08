package com.kh.view;

import java.awt.Color;
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
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.model.controller.UserController;
import com.kh.model.vo.User;

public class Login extends JPanel{
   Image img = null;
   private UserController uc = new UserController();
   private ArrayList<User> list = uc.openList();
   
   public Login(JFrame mf) {
      this.setLayout(null);
      
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
      
      
      
      
      Image icon = new ImageIcon("image/logo.png").getImage().getScaledInstance(250, 250, 0);
      JLabel label = new JLabel(new ImageIcon(icon));
      label.setBackground(Color.WHITE);
      add(label);
      JLabel labelId = new JLabel("아이디");
      add(labelId);
      labelId.setFont(ttfReal.deriveFont(15f));
      
      labelId.setBackground(new Color(106,168,79));
      JLabel labelPwd = new JLabel("비밀번호");
   labelPwd.setFont(ttfReal.deriveFont(15f));   
      add(labelPwd);
      labelPwd.setBackground(new Color(106,168,79));
      TextField IdF = new TextField();
      add(IdF);
      TextField pwdLabel = new TextField();
      add(pwdLabel);
      pwdLabel.setEchoChar('*');// 암호화
      JButton login = new JButton("로그인"); // 로그인 버튼
      add(login);
      login.setFont(ttfReal);
      JButton join = new JButton("회원가입"); // 회원가입 버튼
      join.setFont(ttfReal);
      add(join);
      login.setBackground(new Color(241,194,50));
      join.setBackground(new Color(241,194,50));
      //JPanel logo = new JPanel();
     // JLabel label2 = new JLabel(new ImageIcon("image/KHmart_logo.jpeg"));
      
      label.setBounds(100, 25, 300, 800);
      labelId.setBounds(443, 368, 40, 40);
      labelPwd.setBounds(433, 428, 60, 40);
      IdF.setBounds(520, 365, 250, 40);
      pwdLabel.setBounds(520, 425, 250, 40);
      login.setBounds(800, 365, 100, 100);
      join.setBounds(520, 475, 250, 30);
      
  //    this.setBounds(350,50,1100,900);
  //    this.setLocation(700, 400);
      
      
      setVisible(true);
      join.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            mf.getContentPane().removeAll();
            mf.getContentPane().add(new Join(mf));
            mf.repaint();
            mf.setVisible(true);
         }
      });
      ;
      
      login.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
         for(int i = 0; i < list.size(); i++) {
            if (IdF.getText().equals(list.get(i).getId()) && pwdLabel.getText().equals(list.get(i).getPwd())) {
               JOptionPane.showMessageDialog(null, "로그인이 되었습니다!!");
               
               uc.saveLogin(list.get(i));
               
               
               
                mf.getContentPane().removeAll();
                     mf.getContentPane().add(new ProductPage(mf));                                     //여기에 로그인 성공시 다음페이지 넣어주세요
                     mf.repaint();
                     mf.setVisible(true);
                     return;  
            }else if(IdF.getText().equals(list.get(i).getId()) && !pwdLabel.getText().equals(list.get(i).getPwd())){
               JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다");
               return;
            }
            if(IdF.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "아이디를 입력해주세요");
                    return;
                 }else if(pwdLabel.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요");
                    return;
                 }
         }
         JOptionPane.showMessageDialog(null, "로그인이 실패하였습니다.");
      }
         
      });
     
   }
}