package com.kh.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.kh.model.controller.ProductController;
import com.kh.model.controller.UserController;
import com.kh.model.dao.ProductDao;
import com.kh.model.vo.Product;
import com.kh.model.vo.User;

public class pa extends JPanel {

   private JFrame mainFrame;

   // 장바구니 주문하기 버튼 클릭시 --> 이벤트발생 --> 결제 창으로 넘어오면서 최종 결제 금액 출력하기
   // 회원 총 보유 포인트도 이벤트 발생해야하나 ?
   // 결제 후 보유 포인트 : 총 결제 금액 - 회원 총 보유 포인트

   ProductController pc = new ProductController();
   ProductDao pd = new ProductDao();
   UserController uc = new UserController();
   User userList = uc.getLogin();
   ArrayList<Product> productList = pc.getProductList();
   ArrayList<Product> list = pc.getBasketList();
   int pointSum = 0;
   int priceSum;
   int remainpoint;
   JTextField remainPointText = new JTextField(15);

   public pa() {
   }

   public pa(JFrame mf, int totalSum) {

      
      mainFrame = mf;
      
      //폰트 
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
         this.setLayout(new BorderLayout());
         this.setBackground(Color.white);

      

      //   this.setLayout(null);
      //   this.setBackground(Color.red);
         JLabel label = new JLabel(new ImageIcon("image/KHmart_logo.jpeg"));
         label.setBounds(0, 0, 700, 255);
//         this.add(label);
      
         JPanel top = new JPanel();
         top.setBackground(new Color(241, 194, 50)); // 노란색 
         //top.setPreferredSize(new Dimension(150, 50));
         this.add(top,BorderLayout.NORTH);
         
         Image logo = new ImageIcon("image/logo.png").getImage().getScaledInstance(150, 150, 0);
            // 만들어진 이미지 객체를 JLabel에 넣기
            JLabel logo1 = new JLabel(new ImageIcon(logo));top.add(logo1, BorderLayout.WEST);
         
           JLabel text = new JLabel("결제하기");
         top.add(text);
         text.setFont(ttfReal.deriveFont(50f));
         
         JLabel title = new JLabel("MYPAGE");
         title.setFont(new Font("맑은고딕", Font.BOLD, 20));
         title.setBounds(310, 220, 100, 30);
//         this.add(title);
         
         

      //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      //this.setBorder(new EmptyBorder(0, 150, 0, 150));
      //this.setBackground(new Color(106, 168, 79));

      /*JPanel titlePanel = new JPanel();
      JLabel title1 = new JLabel("KHMart Payment");
      title1.setFont(ttfReal.deriveFont(40.0f));
      //title.setFont(new Font("맑은고딕", Font.BOLD, 50));
      titlePanel.setBackground(new Color(106, 168, 79));
      title.setBorder(new EmptyBorder(50, 0, 50, 0));
      titlePanel.add(title1);*/
         
         
      JPanel main = new JPanel();
      main.setBackground(new Color(106, 168, 79)); // 초록색
      main.setLayout(null);
      
      this.add(main,BorderLayout.CENTER);

       JLabel t1 = new JLabel("주문자 정보");
       t1.setFont(ttfReal.deriveFont(30f));
      t1.setForeground(Color.WHITE);
      main.add(t1);
       
       JLabel name = new JLabel("이름:");
       name.setBackground(new Color(106, 168, 79));
       name.setFont(ttfReal.deriveFont(30f));
       name.setForeground(Color.WHITE);
       name.setBounds(190, 80, 145, 200);
       main.add(name);
       
      JTextField nameText = new JTextField(15);
      nameText.setEditable(false);
      nameText.setFont(ttfReal.deriveFont(25f));
      nameText.setBackground(new Color(106, 168, 79));
      nameText.setBounds(270, 165, 200, 30);
      main.add(nameText);
      
      JLabel add = new JLabel("주소:");
      add.setBackground(new Color(106, 168, 79));
      add.setFont(ttfReal.deriveFont(30f));
      add.setForeground(Color.WHITE);
      add.setBounds(name.getX(), name.getY()+80, 145, 200);
      main.add(add);
      
      
      JTextField addText = new JTextField(15);
      addText.setEditable(false);
      addText.setFont(ttfReal.deriveFont(25f));
      addText.setBackground(new Color(106, 168, 79));
      addText.setBounds(nameText.getX(), nameText.getY()+80, 200, 30);
      main.add(addText);
      
      JLabel point = new JLabel("포인트:");
      point.setBackground(new Color(106, 168, 79));
      point.setFont(ttfReal.deriveFont(30f));
      point.setForeground(Color.WHITE);
      point.setBounds(add.getX() -25, add.getY()+80, 145, 200);
      main.add(point);
      
      JTextField pointText = new JTextField(15);
      pointText.setEditable(false);
      pointText.setFont(ttfReal.deriveFont(25f));
      pointText.setBackground(new Color(106, 168, 79));
      pointText.setBounds(addText.getX(), addText.getY()+80, 200, 30);
      main.add(pointText);
      
      JLabel pointSum = new JLabel("총 보유 포인트:");
      pointSum.setBackground(new Color(106, 168, 79));
      pointSum.setFont(ttfReal.deriveFont(30f));
      pointSum.setForeground(Color.WHITE);
      pointSum.setBounds(name.getX() +400, name.getY(), 200, 200);
      main.add(pointSum);
      
      JTextField pointSumText = new JTextField(15);
      pointSumText.setEditable(false);
      pointSumText.setFont(ttfReal.deriveFont(25f));
      pointSumText.setBackground(new Color(106, 168, 79));
      pointSumText.setBounds(name.getX()+580, name.getY()+87, 200, 30);
      main.add(pointSumText);
      
      JLabel resultPoint = new JLabel("결제 후 포인트:");
      resultPoint.setBackground(new Color(106, 168, 79));
      resultPoint.setFont(ttfReal.deriveFont(30f));
      resultPoint.setForeground(Color.WHITE);
      resultPoint.setBounds(add.getX() +400, add.getY(), 200, 200);
      main.add(resultPoint);
      
      JTextField rpText = new JTextField(15);
      rpText.setEditable(false);
      rpText.setFont(ttfReal.deriveFont(25f));
      rpText.setBackground(new Color(106, 168, 79));
      rpText.setBounds(pointSumText.getX(), addText.getY(), 200, 30);
      main.add(rpText);
      
      JLabel tSum = new JLabel("총 결제 금액:");
      tSum.setBackground(new Color(106, 168, 79));
      tSum.setFont(ttfReal.deriveFont(30f));
      tSum.setForeground(Color.WHITE);
      tSum.setBounds(point.getX() +450, point.getY(), 200, 200);
      main.add(tSum);
      
      JTextField tSumText = new JTextField(15);
      tSumText.setEditable(false);
      tSumText.setFont(ttfReal.deriveFont(25f));
      tSumText.setBackground(new Color(106, 168, 79));
      tSumText.setBounds(rpText.getX(), pointText.getY(), 200, 30);
      main.add(tSumText);
      
      
      
      
    
      
      //if (remainpoint < 0) {
          JButton plus = new JButton("포인트충전");
          plus.setFont(ttfReal.deriveFont(25f));
          plus.setForeground(Color.WHITE);
          plus.setBackground(new Color(241, 194, 50));
          main.add(plus);
          plus.setBounds(800,375, 170, 30);
          plus.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                mf.getContentPane().removeAll();
                mf.getContentPane().add(new AddPoint2(mf, totalSum));
                mf.repaint();
                mf.setVisible(true);

             }

          });
          
          
          

      // }
          
          
          JButton payB = new JButton("결제");
          
          
          payB.setFont(ttfReal.deriveFont(40f));
          payB.setForeground(Color.WHITE);
          payB.setBackground(new Color(241, 194, 50));
          payB.setBounds(770,470,200,120);
          main.add(payB);
          
          JButton l3 = new JButton("이전");
          l3.setForeground(Color.WHITE);
          l3.setFont(ttfReal.deriveFont(40f));
          l3.setBackground(new Color(241, 194, 50));
          l3.setBounds(550,470, 200, 120);
          
          main.add(l3);
          
          
          JLabel text1 = new JLabel("주문자 정보");
          text1.setForeground(Color.white);
          text1.setFont(ttfReal.deriveFont(25f));
          text1.setBackground(new Color(106, 168, 79));
          text1.setBounds(270,80,200,30);
          
          main.add(text1);
          
          JLabel text2 = new JLabel("결제 및 포인트 정보");
          text2.setForeground(Color.white);
          text2.setFont(ttfReal.deriveFont(25f));
          text2.setBackground(new Color(106, 168, 79));
          text2.setBounds(700,80,600,30);
          
          main.add(text2);
          
          
          
          
          
          
          
          JPanel paymentRequest = new JPanel();
          paymentRequest.setBackground(new Color(106, 168, 79));
          paymentRequest.setLayout(new GridLayout(3, 0, 0, 10));
          paymentRequest.setSize(800, 300);

          JPanel t3Panel = new JPanel();
          t3Panel.setBackground(new Color(106, 168, 79));
          JLabel t3 = new JLabel("주문 요청 사항 ");
          t3.setFont(ttfReal.deriveFont(30f));
          t3.setForeground(Color.WHITE);
          t3Panel.add(t3);
          paymentRequest.add(t3Panel);

          String[] request = { "벨은 누르지 말아주세요.", "도착 전 미리 연락 주세요.", "그냥 문 앞에 놓아주시면 돼요.", "경비실에 맡겨주세요." };

          JComboBox requestList = new JComboBox(request);
          requestList.setSelectedIndex(1);

          JPanel rPanel = new JPanel();
          JLabel requestLabel = new JLabel();
          rPanel.setBackground(new Color(255, 255, 255));
          rPanel.add(requestLabel);

          requestList.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String tx = (String) cb.getSelectedItem();
                requestLabel.setText(tx);

             }

          });

          
          
          
    }

      
       
       
   }
   
       
       
         
         
         
        ///////////////////////////////////////////////////////// 
      // 주문자 정보 userInfo 패널 
         
/*      JPanel userInfo = new JPanel();
      userInfo.setBackground(new Color(106, 168, 79));
      //userInfo.setSize(800, 300);

      //JPanel t1Panel = new JPanel();
      //t1Panel.setBackground(new Color(106, 168, 79));
      
      JPanel panel1 = new JPanel();
      
      JLabel t1 = new JLabel("주문자 정보");
      t1.setFont(ttfReal.deriveFont(30f));
      t1.setForeground(Color.WHITE);
      t1.add(panel1);
      
      //t1Panel.add(t1);
      //userInfo.add(t1);

      //JPanel nPanel = new JPanel();
      //nPanel.setBackground(new Color(106, 168, 79));
      JPanel panel2 = new JPanel(new GridLayout(3,2));
      
      JLabel name = new JLabel("이름: ");
      name.setFont(ttfReal.deriveFont(30f));
      name.setForeground(Color.WHITE);
      //nPanel.add(name);
      panel2.add(name);

      JTextField nameText = new JTextField(15);
      nameText.setEditable(false);
      nameText.setFont(ttfReal.deriveFont(25f));
      nameText.setBackground(new Color(106, 168, 79));
      panel2.add(nameText);

      // 이름 값 가져오기

      nameText.setText(userList.getName() + " ");

      //JPanel aPanel = new JPanel();
      //aPanel.setBackground(new Color(106, 168, 79));
      JLabel address = new JLabel("주소: ");
      address.setFont(ttfReal.deriveFont(30f));
      address.setForeground(Color.WHITE);
      //aPanel.add(address);
      panel2.add(address);

      JTextField addressText = new JTextField(15);
      addressText.setEditable(false);
      addressText.setFont(ttfReal.deriveFont(25f));
      addressText.setBackground(new Color(106, 168, 79));
      panel2.add(addressText);

      // 주소값 가져오기

      addressText.setText(userList.getAddress() + " ");

      //JPanel pPanel = new JPanel();
      //pPanel.setBackground(new Color(106, 168, 79));
      JLabel point = new JLabel("포인트: ");
      point.setFont(ttfReal.deriveFont(30f));
      point.setForeground(Color.WHITE);
      panel2.add(point);
      //userInfo.add(pPanel);

      JTextField pointText = new JTextField(15);
      pointText.setEditable(false);
      pointText.setFont(ttfReal.deriveFont(25f));
      pointText.setBackground(new Color(106, 168, 79));
      panel2.add(pointText);

      // 총 포인트 가져오기

      pointText.setText(userList.getPoint() + " point");

      // 주문 요청 선택

      JPanel paymentRequest = new JPanel();
      paymentRequest.setBackground(new Color(106, 168, 79));
      paymentRequest.setLayout(new GridLayout(3, 0, 0, 10));
      paymentRequest.setSize(800, 300);

      JPanel t3Panel = new JPanel();
      t3Panel.setBackground(new Color(106, 168, 79));
      JLabel t3 = new JLabel("주문 요청 사항 ");
      t3.setFont(ttfReal.deriveFont(30f));
      t3.setForeground(Color.WHITE);
      t3Panel.add(t3);
      paymentRequest.add(t3Panel);

      String[] request = { "벨은 누르지 말아주세요.", "도착 전 미리 연락 주세요.", "그냥 문 앞에 놓아주시면 돼요.", "경비실에 맡겨주세요." };

      JComboBox requestList = new JComboBox(request);
      requestList.setSelectedIndex(1);

      JPanel rPanel = new JPanel();
      JLabel requestLabel = new JLabel();
      rPanel.setBackground(new Color(255, 255, 255));
      rPanel.add(requestLabel);

      requestList.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            String tx = (String) cb.getSelectedItem();
            requestLabel.setText(tx);

         }

      });

      requestLabel.setHorizontalAlignment(JLabel.LEFT);
      paymentRequest.add(requestList);
      paymentRequest.add(rPanel);
      

      // 결제 및 포인트 정보 paypointInfo 패널 
      
      JPanel paypointInfo = new JPanel();
      paypointInfo.setBackground(new Color(106, 168, 79));
      paypointInfo.setLayout(new GridLayout(3, 2));
      paypointInfo.setSize(800, 300);

      //JPanel t2Panel = new JPanel();
      //t2Panel.setBackground(new Color(106, 168, 79));
      JLabel t2 = new JLabel("결제 및 포인트 정보");
      t2.setFont(ttfReal.deriveFont(30f));
      t2.setForeground(Color.WHITE);
      paypointInfo.add(t2);
      //paypointInfo.add(t2Panel);
      
      //JPanel pointPanel = new JPanel();
      //pointPanel.setBackground(new Color(106, 168, 79));
      JLabel totalPoint = new JLabel("총 보유 포인트: ");
      totalPoint.setFont(ttfReal.deriveFont(30f));
      totalPoint.setForeground(Color.WHITE);
      totalPoint.setBackground(new Color(106, 168, 79));
      //paypointInfo.add(pointPanel);
      paypointInfo.add(totalPoint);

      JTextField totalText = new JTextField(15);
      totalText.setEditable(false);
      totalText.setFont(new Font("맑은 고딕", Font.BOLD, 25));
      totalText.setBackground(new Color(106, 168, 79));
      paypointInfo.add(totalText);
      
      // 총 포인트 가져오기
      pointSum = userList.getPoint();
      totalText.setText(pointSum + "  point");

      //JPanel pointafterPanel = new JPanel();
      //pointafterPanel.setBackground(new Color(106, 168, 79));
      JLabel remainPoint = new JLabel("결제 후 포인트: ");
      remainPoint.setFont(ttfReal.deriveFont(30f));
      remainPoint.setForeground(Color.WHITE);
      //paypointInfo.add(paypointInfo);
      paypointInfo.add(remainPoint);

      // JTextField remainPointText = new JTextField(15); // 필드에 선언함
      remainPointText.setEditable(false);
      remainPointText.setFont(new Font("맑은 고딕", Font.BOLD, 25));
      remainPointText.setBackground(new Color(106, 168, 79));
      paypointInfo.add(remainPointText);

      //JPanel paymentPanel = new JPanel();
      //paymentPanel.setBackground(new Color(106, 168, 79));
      JLabel pay = new JLabel("총  결제  금액: ");
      pay.setFont(ttfReal.deriveFont(30f));
      pay.setForeground(Color.WHITE);
      //paypointInfo.add(paymentPanel);
      paypointInfo.add(pay);

      JTextField paymentText = new JTextField(15);
      paymentText.setEditable(false);
      paymentText.setFont(new Font("맑은 고딕", Font.BOLD, 25));
      paymentText.setBackground(new Color(106, 168, 79));
      paypointInfo.add(paymentText);
      
      // pointafterPanel , paypointInfo
      JPanel big = new JPanel(new GridLayout(1,2));
      big.setBackground(new Color(106, 168, 79));
      big.add(userInfo);
      big.add(paypointInfo);

      

      // 장바구니 최종 결제 가져오기

      priceSum = totalSum;
      System.out.println(priceSum + "원");
      paymentText.setText(priceSum + " point");

      
       * for(int i = 0; i < productList.size(); i++) { priceSum +=
       * productList.get(i).getPrice(); paymentText.setText(priceSum +" point"); }
       

      // 결제 후 포인트 가져오기
      remainpoint = pointSum - priceSum;
      remainPointText.setText(remainpoint + "  point");

      // 중간 부분 제일 큰 패널
      //JPanel pnlCenter = new JPanel(new GridLayout(3, 1, 0, 20));
      //pnlCenter.setBackground(new Color(106, 168, 79));
      //pnlCenter.add(userInfo);
      //pnlCenter.add(paymentRequest);
      //pnlCenter.add(paypointInfo);

      // 버튼 + 총 결제 값 레이블

      JPanel buttonPanel = new JPanel();

      buttonPanel.setBackground(new Color(106, 168, 79));

      JButton btn1 = new JButton("이전");
      JButton btn2 = new JButton("결제");
      
      
      btn2.setFont(ttfReal.deriveFont(30f));
      btn2.setForeground(Color.WHITE);
      btn2.setBackground(new Color(241, 194, 50));
      
      btn1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
      btn1.setBackground(Color.BLACK);
      btn1.setForeground(Color.WHITE);
   
      //buttonPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

      JLabel payL = new JLabel("결제 금액: ");
      payL.setFont(ttfReal.deriveFont(30f));
      payL.setForeground(Color.WHITE);

      JTextField pText = new JTextField(15);
      pText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      pText.setEditable(false);
      pText.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      pText.setBackground(new Color(106, 168, 79));

      
       * int priceSum1 = 0; for(int i = 0; i < productList.size(); i++) { priceSum1 +=
       * productList.get(i).getPrice(); pText.setText(priceSum1 +" point"); }
       

      //buttonPanel.add(payL);
      //buttonPanel.add(pText);
      buttonPanel.add(btn2);
      buttonPanel.add(btn1);
      
      btn1.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            mf.getContentPane().removeAll();
            mf.getContentPane().add(new Basket(mf));
            mf.repaint();
            mf.setVisible(true);

         }

      });

      String pwd = userList.getPaypwd();

      btn2.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            // if, 보유 포인트 > 총 결제 금액 --> 결제 비밀번호 입력 창 (잘못 입력 받은 경우 다시 입력하게)
            // JPasswordField pwd = new JPasswordField(30);
            if (pointSum < priceSum) {
               JOptionPane.showMessageDialog(null, "보유 포인트가 부족합니다.");
            } else {
               String pass = JOptionPane.showInputDialog("결제 비밀번호를 입력하세요.");
               if (pass.equals(pwd)) {
                  //JOptionPane.showMessageDialog(null, "결제 완료 입니다.");
                  // basket list -> list
                  // productList
                  mf.getContentPane().removeAll();
                  mf.getContentPane().add(new ProductPage(mf));
                  mf.repaint();
                  mf.setVisible(true);
                  // 콘솔창 확인 코드 
                  for (int i = 0; i < list.size(); i++) {
                     System.out.println(list);
                     System.out.println("장바구니 선택된 수량:" + list.get(i).getCnt());
                     System.out.println("상품페이지 수량 : " + productList.get(i).getCnt());
                     System.out.println("상품페이지 남은 수량 :" + (productList.get(i).getCnt() - list.get(i).getCnt()) + "");
                  }
                  
                  for (int i = 0; i < list.size(); i++) {
                     for(int j = 0; j < productList.size(); j ++)
                     if (productList.get(j).getpName().equals(list.get(i).getpName())) {
                        productList.get(j).setCnt((productList.get(j).getCnt() - list.get(i).getCnt()));
                     }
                  }
                  // 상품파일에 저장하기 
                  pc.saveProductFile(productList);
                  
                  // 바뀐 수량 확인하기 
                  System.out.println(productList);
               } else {
                  JOptionPane.showMessageDialog(null, "비밀번호를 다시 입력해주세요.", "비밀번호 오류", JOptionPane.ERROR_MESSAGE);
               }
            }
            // else, 보유 포인트가 < 총 결제 금액 --> 보유 포인트가 부족합니다 창 뜨게 --> 취소 버튼 누른 후 장바구니로 이동
         }

      }); 
      

      JPanel center = new JPanel(new GridLayout(3,1));
      center.add(big);
      center.add(buttonPanel);
      center.add(paymentRequest);
      
      
      main.add(center);
      
     // center.setBorder(new EmptyBorder(100, 0, 100, 0));
      
      //center.setBorder(new EmptyBorder(0, 150, 0, 150));

      
      //this.add(titlePanel);
      //this.add(label);
      //main.add(pnlCenter);
      
      //main.add(big);
      //main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));
      //main.add(buttonPanel);
      //main.add(paymentRequest);
      

      this.setVisible(true);
      if (remainpoint < 0) {
         JButton plus = new JButton("포인트충전");
         plus.setFont(ttfReal.deriveFont(30f));
         plus.setForeground(Color.WHITE);
         plus.setBackground(new Color(241, 194, 50));
         buttonPanel.add(plus);
         plus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               mf.getContentPane().removeAll();
               mf.getContentPane().add(new AddPoint2(mf, totalSum));
               mf.repaint();
               mf.setVisible(true);

            }

         });

      }
   }

   
    * public int afterPoint() { //결제 후 포인트 : 00000 포인트 //결제후 포인트를 마이페이지에서 수정가능하게
    * int remainPoint = pointSum - priceSum; remainPointText.setText(remainPoint
    * +"  point"); System.out.println(remainPoint);
    * 
    * return remainPoint; }
    

}
*/