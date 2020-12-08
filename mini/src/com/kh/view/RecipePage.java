package com.kh.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RecipePage extends JPanel implements ActionListener{
   private JFrame mainFrame;
   public RecipePage(JFrame mf) {
      mainFrame = mf;
      
      Font ttfBase = null;
      Font ttfReal = null;
      try {
         BufferedInputStream myStream = new BufferedInputStream(new FileInputStream("BMJUA_ttf.ttf"));
         ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
         ttfReal = ttfBase.deriveFont(Font.PLAIN, 40);
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
      
      // 초록색
//      this.setBackground(new Color(106, 168, 79));
      this.setLayout(new BorderLayout());
//      this.setBorder(new EmptyBorder(0,50,0,50)); //위, 왼쪽, 아래, 오른쪽
      
       JPanel top = new JPanel();
         top.setBackground(new Color(241, 194, 50));
         top.setLayout(new BorderLayout());
         this.add(top,"North");
         
         JButton backTo = new JButton("<-");
        backTo.setFont(ttfReal.deriveFont(30.f));
        backTo.setBorderPainted(false);
        backTo.setBackground(new Color(241, 194, 50));
//        backTo.setHorizontalAlignment(JLabel.LEFT);
        
        backTo.addMouseListener(new MouseAdapter() {

              @Override
              public void mouseClicked(MouseEvent e) {

                 mf.getContentPane().removeAll();
                 mf.getContentPane().add(new ProductPage(mf));
                 mf.repaint();
                 mf.setVisible(true);

              }
           });

        top.add(backTo, "West");
        
        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(new Color(241, 194, 50));
         
         Image logo = new ImageIcon("image/logo.png").getImage().getScaledInstance(150, 150, 0);
         // 만들어진 이미지 객체를 JLabel에 넣기
         JLabel logo1 = new JLabel(new ImageIcon(logo));
//         logo1.setHorizontalAlignment(JLabel.CENTER);
         logoPanel.add(logo1);
      
      JLabel title = new JLabel("RECIPE PAGE");
      title.setHorizontalAlignment(JLabel.CENTER);
      title.setFont(ttfReal);
      logoPanel.add(title);
      
      top.add(logoPanel, "Center");
      
       JPanel btnPanel = new JPanel();
       btnPanel.setPreferredSize(new Dimension(500, 1000));
       btnPanel.setLayout(new GridLayout(4,0,0,20));
       btnPanel.setBorder(new EmptyBorder(200,50,0,50)); //위, 왼쪽, 아래, 오른쪽
       btnPanel.setBackground(new Color(106, 168, 79));
      
      JButton bToday = new JButton("오늘의 추천 메뉴");
      bToday.setFont(ttfReal);
//      bToday.setBackground(new Color(241, 194, 50));
      bToday.setBackground(Color.WHITE);
      JButton bIngre = new JButton("재료 카테고리");
      bIngre.setFont(ttfReal);
      //노란색
//      bIngre.setBackground(new Color(241, 194, 50));
      bIngre.setBackground(Color.WHITE);
      
      bToday.addActionListener(this);
      bIngre.addActionListener(this);
   
      
      btnPanel.add(bToday);
      btnPanel.add(bIngre);
      this.add(top, "North");
      this.add(btnPanel);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      JPanel changePanel = null;
      if(e.getSource() instanceof JButton) {
         JButton btn = (JButton)e.getSource();
         switch(btn.getText()) {
         case "오늘의 추천 메뉴":
            changePanel = new TodayPanel(mainFrame);
            break;
         case "재료 카테고리":
            changePanel = new CatePanel(mainFrame);
            break;
         }
         mainFrame.getContentPane().removeAll();
         mainFrame.getContentPane().add(changePanel);
         mainFrame.repaint();
         mainFrame.setVisible(true);
      }
      
   }


}