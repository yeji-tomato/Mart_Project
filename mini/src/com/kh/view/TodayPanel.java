package com.kh.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
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

public class TodayPanel extends JPanel implements ActionListener{
   JLabel showFood = new JLabel();
   JPanel foodPanel = new JPanel();
   JButton cancel = new JButton("√Îº“");
   public TodayPanel(JFrame mf) {


         Font ttfBase = null;
            Font ttfReal = null;
            try {
               BufferedInputStream myStream = new BufferedInputStream(new FileInputStream("BMJUA_ttf.ttf"));
               ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
               ttfReal = ttfBase.deriveFont(Font.PLAIN, 15);
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
                 mf.getContentPane().add(new RecipePage(mf));
                 mf.repaint();
                 mf.setVisible(true);

              }
           });

        top.add(backTo, "West");
        
        JPanel logoPanel = new JPanel();
         
         Image logo = new ImageIcon("image/logo.png").getImage().getScaledInstance(150, 150, 0);
         // ∏∏µÈæÓ¡¯ ¿ÃπÃ¡ˆ ∞¥√º∏¶ JLabelø° ≥÷±‚
         JLabel logo1 = new JLabel(new ImageIcon(logo));
//         logo1.setHorizontalAlignment(JLabel.CENTER);
         logoPanel.add(logo1);
         
         JLabel text = new JLabel("ø¿¥√¿« √ﬂ√µ∏ﬁ¥∫");
//         text.setHorizontalAlignment(JLabel.CENTER);
         text.setFont(ttfReal.deriveFont(50f));
         logoPanel.add(text);
         logoPanel.setBackground(new Color(241, 194, 50));
         logoPanel.setBorder(new EmptyBorder(0,0,0,120));
         top.add(logoPanel, "Center");
         
         
         
         JPanel main = new JPanel();
         main.setBackground(new Color(106, 168, 79));
         main.setLayout(null);
         add(main);
         
         JButton[] button = new JButton[8];
         
         button[1] = new JButton("«—Ωƒ");
         button[1].setBackground(Color.white);
         button[1].setFont(ttfReal.deriveFont(30f));
         button[1].setBounds(0,0,135,100);
         main.add(button[1]);
         button[1].addActionListener(this);
         
         button[2] = new JButton("¿œΩƒ");
         button[2].setBackground(Color.white);
         button[2].setFont(ttfReal.deriveFont(30f));
         button[2].setBounds(130,0,135,100);
         main.add(button[2]);
         button[2].addActionListener(this);
         
         button[3] = new JButton("¡ﬂΩƒ");
         button[3].setBackground(Color.white);
         button[3].setFont(ttfReal.deriveFont(30f));
         button[3].setBounds(260,0,140,100);
         main.add(button[3]);
         button[3].addActionListener(this);
         
         
         button[4] = new JButton("∫–Ωƒ");
         button[4].setBackground(Color.white);
         button[4].setFont(ttfReal.deriveFont(30f));
         button[4].setBounds(400,0,140,100);
         main.add(button[4]);
         button[4].addActionListener(this);
         
         button[5] = new JButton("æÁΩƒ");
         button[5].setBackground(Color.white);
         button[5].setFont(ttfReal.deriveFont(30f));
         button[5].setBounds(540,0,140,100);
         main.add(button[5]);
         button[5].addActionListener(this);
         
         button[6] = new JButton("µµΩ√∂Ù");
         button[6].setBackground(Color.white);
         button[6].setFont(ttfReal.deriveFont(30f));
         button[6].setBounds(680,0,140,100);
         main.add(button[6]);
         button[6].addActionListener(this);
         
         button[7] = new JButton("∆Ø∫∞Ωƒ");
         button[7].setBackground(Color.white);
         button[7].setFont(ttfReal.deriveFont(30f));
         button[7].setBounds(820,0,140,100);
         main.add(button[7]);
         button[7].addActionListener(this);
         
         button[0] = new JButton("µ¿˙∆Æ");
         button[0].setBackground(Color.white);
         button[0].setFont(ttfReal.deriveFont(30f));
         button[0].setBounds(960,0,140,100);
         main.add(button[0]);
         button[0].addActionListener(this);
         
         
//         foodPanel.setBackground(Color.green);
         foodPanel.setPreferredSize(new Dimension(500, 600));
         foodPanel.setBackground(new Color(106, 168, 79));
         foodPanel.setLayout(null);
         this.add(foodPanel,"South");
         
         JLabel content = new JLabel("[πˆ∆∞¿ª ¥©∏£∏È ∑£¥˝¿∏∑Œ ¿ΩΩƒ¿Ã ≥™ø…¥œ¥Ÿ.]");
         content.setFont(ttfReal.deriveFont(30f));
         content.setForeground(Color.white);
         content.setBounds(300,0,600,50);
         foodPanel.add(content);
         
            cancel.setFont(ttfReal.deriveFont(20.f));
            cancel.setBorderPainted(false);
            cancel.setBackground(new Color(241, 194, 50));
            cancel.setBounds(500,530,100,50);
         
            cancel.addMouseListener(new MouseAdapter() {

               @Override
               public void mouseClicked(MouseEvent e) {

                  mf.getContentPane().removeAll();
                  mf.getContentPane().add(new TodayPanel(mf));
                  mf.repaint();
                  mf.setVisible(true);

               }
            });

      // πËø≠¿ª º±æ«œø© ø©∑Ø ∞≥¿« √º≈© π⁄Ω∫ ª˝º∫«‘
      JButton[] btnFood = new JButton[8];

   }
@Override
public void actionPerformed(ActionEvent e) {
   // TODO Auto-generated method stub
    if (e.getSource() instanceof JButton) {
       
       Font ttfBase = null;
         Font ttfReal = null;
         try {
            BufferedInputStream myStream = new BufferedInputStream(new FileInputStream("BMJUA_ttf.ttf"));
            ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
            ttfReal = ttfBase.deriveFont(Font.PLAIN, 15);
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
         
       
       
         JButton btn = (JButton) e.getSource();
         int num;
         switch (btn.getText()) {
         case "«—Ωƒ":
            String[] kor = { "¡∑πﬂ", "∞ˆ√¢", "¬Ú¥ﬂ", "∫∏Ω”", "≈¡", "∫Œƒß∞≥", "±πºˆ", "¡¶¿∞∫∫¿Ω" };
            num = (int) (Math.random() * kor.length);
            
            Image img = new ImageIcon("image/recipe/today/"+ kor[num].toString() +".jpg").getImage().getScaledInstance(400, 400, 0);
          JLabel showImg = new JLabel(new ImageIcon(img));
       
            showFood = new JLabel(kor[num].toString());
            showFood.setFont(ttfReal.deriveFont(50.0f));
            showFood.setForeground(Color.WHITE);
            foodPanel.add(showImg);
            foodPanel.add(showFood);
            showImg.setBounds(0,50,1100,400);
            showFood.setBounds(500,240,1200,500);
            foodPanel.add(cancel);
            break;
         case "¿œΩƒ":
            String[] jap = { "√ π‰", "∂Û∏‡", "≈∏ƒ⁄æﬂ≥¢", "Ω∫≥¢æﬂ≥¢", "»∏", "µ∑±ÓΩ∫", "ª˛∫Íª˛∫Í", "µ∑±ÓΩ∫" };
            num = (int) (Math.random() * jap.length);
            Image img2 = new ImageIcon("image/recipe/today/"+ jap[num].toString() +".jpg").getImage().getScaledInstance(400, 400, 0);
          JLabel showImg2 = new JLabel(new ImageIcon(img2));
          showFood = new JLabel(jap[num].toString());
            showFood.setFont(ttfReal.deriveFont(50.0f));
            showFood.setForeground(Color.WHITE);
            foodPanel.add(showImg2);
            foodPanel.add(showFood);
            showImg2.setBounds(0,50,1100,400);
            showFood.setBounds(500,240,1200,500);
            foodPanel.add(cancel);
            break;
         case "¡ﬂΩƒ":
            String[] cha = { "¬´ªÕ", "±Ò«≥±‚", "¬•¿Â∏È", "µø∆ƒ¿∞", "±ÒºÓªıøÏ", "æÁ≤øƒ°", "∏∂∂Û≈¡", "≈¡ºˆ¿∞" };
            num = (int) (Math.random() * cha.length);
            Image img3 = new ImageIcon("image/recipe/today/"+ cha[num].toString() +".jpg").getImage().getScaledInstance(400, 400, 0);
          JLabel showImg3 = new JLabel(new ImageIcon(img3));
          showFood = new JLabel(cha[num].toString());
            showFood.setFont(ttfReal.deriveFont(50.0f));
            showFood.setForeground(Color.WHITE);
            foodPanel.add(showImg3);
            foodPanel.add(showFood);
            showImg3.setBounds(0,50,1100,400);
            showFood.setBounds(500,240,1200,500);
            foodPanel.add(cancel);
            break;
         case "∫–Ωƒ":
            String[] bun = { "∂±∫∫¿Ã", "∆¢±Ë", "º¯¥Î", "∏∏µŒ", "∂Û∏È", "æÓπ¨", "±Ëπ‰", "∂Û∫∫¿Ã" };
            num = (int) (Math.random() * bun.length);

            Image img4 = new ImageIcon("image/recipe/today/"+ bun[num].toString() +".jpg").getImage().getScaledInstance(400, 400, 0);
          JLabel showImg4 = new JLabel(new ImageIcon(img4));
          showFood = new JLabel(bun[num].toString());
            showFood.setFont(ttfReal.deriveFont(50.0f));
            showFood.setForeground(Color.WHITE);
            foodPanel.add(showImg4);
            foodPanel.add(showFood);
            showImg4.setBounds(0,50,1100,400);
            showFood.setBounds(500,240,1200,500);
            foodPanel.add(cancel);
            break;
         case "æÁΩƒ":
            String[] yang = { "∆ƒΩ∫≈∏", "««¿⁄", "Ω∫≈◊¿Ã≈©", "ƒ°≈≤", "ª¯∑ØµÂ", "±◊∂Û≈¡", "πŸ∫£≈•", "«‹πˆ∞≈" };
            num = (int) (Math.random() * yang.length);

            Image img5 = new ImageIcon("image/recipe/today/"+ yang[num].toString() +".jpg").getImage().getScaledInstance(400, 400, 0);
          JLabel showImg5 = new JLabel(new ImageIcon(img5));
          showFood = new JLabel(yang[num].toString());
            showFood.setFont(ttfReal.deriveFont(50.0f));
            showFood.setForeground(Color.WHITE);
            foodPanel.add(showImg5);
            foodPanel.add(showFood);
            showImg5.setBounds(0,50,1100,400);
            showFood.setBounds(500,240,1200,500);
            foodPanel.add(cancel);
            break;
         case "µµΩ√∂Ù":
            String[] dosi = { "Ω∫∆‘∏∂ø‰", "¬ﬁ≤ŸπÃ¡§Ωƒ", "¥ﬂ∞≠¡§", "∫“∞Ì±‚", "«‘π⁄Ω∫≈◊¿Ã≈©", "ªÔ∞„ªÏ±∏¿Ã", "ø¨æÓµ§π‰", "«‘π⁄Ω∫≈◊¿Ã≈©" };
            num = (int) (Math.random() * dosi.length);

            Image img6 = new ImageIcon("image/recipe/today/"+ dosi[num].toString() +".jpg").getImage().getScaledInstance(400, 400, 0);
          JLabel showImg6 = new JLabel(new ImageIcon(img6));
          showFood = new JLabel(dosi[num].toString());
            showFood.setFont(ttfReal.deriveFont(50.0f));
            showFood.setForeground(Color.WHITE);
            foodPanel.add(showImg6);
            foodPanel.add(showFood);
            showImg6.setBounds(0,50,1100,400);
            showFood.setBounds(500,240,1200,500);
            foodPanel.add(cancel);
            break;
         case "∆Ø∫∞Ωƒ":
             String[] special = { "ø˘≥≤Ω”", "≈∏ƒ⁄", "∏∆æÿƒ°¡Ó", "∫–¬•", "∂Ûµ˚∂—¿Ã", "∫Í∏Æ∂«", "ƒ…π‰", "ª—∆Ã∆˛ƒø∏Æ" };
             num = (int) (Math.random() * special.length);

             Image img7 = new ImageIcon("image/recipe/today/"+ special[num].toString() +".jpg").getImage().getScaledInstance(400, 400, 0);
           JLabel showImg7 = new JLabel(new ImageIcon(img7));
           showFood = new JLabel(special[num].toString());
             showFood.setFont(ttfReal.deriveFont(50.0f));
             showFood.setForeground(Color.WHITE);
             foodPanel.add(showImg7);
             foodPanel.add(showFood);
             showImg7.setBounds(0,50,1100,400);
             showFood.setBounds(500,240,1200,500);
             foodPanel.add(cancel);
            break;
             
         case "µ¿˙∆Æ":
            String[] dessert = { "ƒø««", "∞˙¿œ", "øÕ«√", "ƒ…¿Ã≈©", "æ∆¿ÃΩ∫≈©∏≤", "∞˙¿⁄", "∏∂ƒ´∑’", "ø‰∞≈∆Æ" };
            num = (int) (Math.random() * dessert.length);
            
            Image img8 = new ImageIcon("image/recipe/today/"+ dessert[num].toString() +".jpg").getImage().getScaledInstance(400, 400, 0);
          JLabel showImg8 = new JLabel(new ImageIcon(img8));
          showFood = new JLabel(dessert[num].toString());
            showFood.setFont(ttfReal.deriveFont(50.0f));
            showFood.setForeground(Color.WHITE);
            foodPanel.add(showImg8);
            foodPanel.add(showFood);
            showImg8.setBounds(0,50,1100,400);
            showFood.setBounds(500,240,1200,500);
            foodPanel.add(cancel);
            break;
            
         }
      }

   
}

}