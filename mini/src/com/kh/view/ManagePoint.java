package com.kh.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.model.controller.UserController;
import com.kh.model.vo.User;

public class ManagePoint extends JPanel {

   UserController uc = new UserController();
   Payment pm = new Payment();

   public ManagePoint(JFrame mf) {

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

      User user = uc.getLogin();
      String userName = "";
      String name = null;

      JPanel top = new JPanel();
      top.setBackground(new Color(241, 194, 50));
      // top.setPreferredSize(new Dimension(150, 50));
      this.add(top, "North");

      Image logo = new ImageIcon("image/logo.png").getImage().getScaledInstance(150, 150, 0);
      // 만들어진 이미지 객체를 JLabel에 넣기
      JLabel logo1 = new JLabel(new ImageIcon(logo));
      top.add(logo1, BorderLayout.WEST);

      JLabel text = new JLabel("Point");
      top.add(text);
      text.setFont(ttfReal.deriveFont(50f));

      JLabel title = new JLabel("MYPAGE");
      title.setFont(new Font("맑은고딕", Font.BOLD, 20));
      title.setBounds(310, 220, 100, 30);

      JPanel main = new JPanel();
      main.setBackground(new Color(106, 168, 79));
      main.setLayout(null);
      add(main);

      name = user.getName();

      // System.out.println(name);
      JPanel viewPanel = new JPanel();
   viewPanel.setLayout(new BorderLayout());
      JLabel viewLabel = new JLabel(name + "님의 포인트입니다. \n");
      JLabel viewPoint = new JLabel(user.getPoint() + "Point");
   //   viewPanel.add(viewPoint);
      //viewLabel.add(viewLabel,"Center");
      viewPanel.setBackground(new Color(241, 194, 50));
      viewPanel.setBounds(350, 150, 500, 150);
   //   viewLabel.setBounds(350, 150, 500, 150);
      viewLabel.setFont(ttfReal.deriveFont(25f));
      viewPoint.setFont(ttfReal.deriveFont(80f));
      
      main.add(viewPanel);
      viewPanel.add(viewLabel, "North");
      viewPanel.add(viewPoint, "South");
      JPanel viewPointPanel = new JPanel();
      
      //viewPoint.setFont("맑은고딕", Font.BOLD, 10);
      /*viewPointPanel.add(viewPoint);
      viewPointPanel.setBackground(new Color(241, 194, 50));
      viewLabel.setBounds(300, 100, 600, 200);
      main.add(viewLabel);*/

      JLabel currentPoint = new JLabel();

      JButton addPointButton = new JButton("포인트 충전하기");
      addPointButton.setFont(ttfReal.deriveFont(25f));
      addPointButton.setBackground(new Color(241, 194, 50));
      addPointButton.setBounds(300, 310, 300, 80);
      main.add(addPointButton);

      addPointButton.addMouseListener(new MouseAdapter() {

         @Override
         public void mouseClicked(MouseEvent e) {

            mf.getContentPane().removeAll();
            mf.getContentPane().add(new AddPoint(mf));
            mf.repaint();
            mf.setVisible(true);

         }
      });

      JButton backToHome = new JButton("홈으로 돌아가기");
      backToHome.setFont(ttfReal.deriveFont(25f));
      backToHome.setBackground(new Color(241, 194, 50));
      backToHome.setBounds(600, 310, 300, 80);
      main.add(backToHome);

      backToHome.addMouseListener(new MouseAdapter() {

         @Override
         public void mouseClicked(MouseEvent e) {
            mf.getContentPane().removeAll();
            mf.getContentPane().add(new ProductPage(mf));
            mf.repaint();
            mf.setVisible(true);

         }

      });

      /*
       * JButton backTo = new JButton("뒤로가기"); backTo.setBounds(100,100,100,100);
       * main.add(backTo);
       * 
       * backTo.addMouseListener(new MouseAdapter() {
       * 
       * @Override public void mouseClicked(MouseEvent e) {
       * mf.getContentPane().removeAll(); mf.getContentPane().add(new MyPage(mf));
       * mf.repaint(); mf.setVisible(true);
       * 
       * }
       * 
       * });
       */

   }
}