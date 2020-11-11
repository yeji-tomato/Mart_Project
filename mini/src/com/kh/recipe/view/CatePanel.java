package com.kh.recipe.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.kh.recipe.model.controller.CateController;
import com.kh.recipe.model.vo.Category;

public class CatePanel extends JPanel{
	private JFrame mainFrame;
	private CateController cc = new CateController();
	private ArrayList<Category> cateList = cc.getCateList();
	private int count = 0;
public CatePanel(JFrame mf) {
	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	
	Font fontKor = new Font("한컴 백제 B", Font.TRUETYPE_FONT, 30);
	
	JPanel panel1 = new JPanel();
	panel1.setBackground(Color.WHITE);
	JLabel title = new JLabel("재료 카테고리");
	title.setBorder(new EmptyBorder(50,0,0,0)); //위, 왼쪽, 아래, 오른쪽
	title.setFont(fontKor);
	panel1.add(title);
	
	JPanel panel2 = new JPanel();
	panel2.setBackground(Color.GRAY);
	// 재료 입력 창
	JTextField input = new JTextField("재료를 입력해주세요", 15);
	input.setFont(fontKor.deriveFont(20.0f));
	
	input.addMouseListener(new MouseAdapter() {
		@Override
        public void mouseClicked(MouseEvent e){
			input.setText("");
			input.requestFocus();
        }
		
	});
	
	JButton search = new JButton("검색");
	search.setFont(fontKor.deriveFont(20.0f));
	panel2.add(input);
	panel2.add(search);
	
	JPanel panel3 = new JPanel();
//	panel3.setBackground(Color.GREEN);
	panel3.setPreferredSize(new Dimension(10,800));

	
	JTextArea ta = new JTextArea(0, 0); // 출력용 텍스트 영역
	panel3.add(ta);
	
	JPanel resultPanel = new JPanel();
	JButton resultButton = new JButton();
	JLabel fNameL = new JLabel();
	
	// 출력 값 
//	int count = 0;

	// 검색 버튼 클릭시 이벤트
	search.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String text = input.getText();
			panel3.setBackground(Color.LIGHT_GRAY);
//			ta.append(text);
//			panel3.add(ta);
		
			
			if(cateList.isEmpty()) {
				panel3.add(new JLabel("목록이 존재하지 않습니다."));
			}else {
				ta.append("<검색 결과>");
				for(Category c : cateList) {
					count++;
					String[] ingreArr = c.getIngre();
					for(int i = 0; i < ingreArr.length; i++) {
						if(ingreArr[i].contains(text)) {
							
							resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
							Image icon = new ImageIcon(c.getfImagePath()).getImage().getScaledInstance(150, 150, 0);
							resultPanel.add(new JLabel(new ImageIcon(icon)));
							JLabel fNameL = new JLabel(c.getfName());
							resultButton.add(fNameL);
							resultPanel.add(resultButton);
							panel3.add(resultPanel);
							
							JPanel recipePanel = new JPanel();
							recipePanel.setPreferredSize(new Dimension(1200,600));
							// 버튼 클릭 시  해당 레시피 출력
							resultButton.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									panel3.removeAll();
									panel3.revalidate();
									panel3.add(recipePanel);
									recipePanel.setBackground(Color.white);
									
									String title = null;
									for(int i = 0; i < cateList.size(); i++) {
										title = cateList.get(i).getfName();
										if(fNameL.getText().equals(title)) {
											// 요리 이름
											recipePanel.add(new JLabel(cateList.get(i).getfName()));
											// 요리 사진
											Image icon = new ImageIcon(c.getfImagePath()).getImage().getScaledInstance(150, 150, 0);
											recipePanel.add(new JLabel(new ImageIcon(icon)));
											// 인분
											recipePanel.add(new JLabel(cateList.get(i).getAmount()));
											// 요리 시간
											recipePanel.add(new JLabel(cateList.get(i).getTime()));
											// 레시피
											String recipeArr[] = c.getRecipe();
											for(int j = 0; j < recipeArr.length; j++) {
												recipePanel.add(new JLabel(recipeArr[j]));
											}
										}
									}
									
									
									
									panel3.repaint();
								}
								
							});
							
//							return;
						}
					} // 재료 반복문
				} // Category ArrayList 반복문
//				ta.append("<검색 결과>");
				if(count == 0) {
					panel3.add(new JLabel("검색된 재료에 알맞은 레시피가 없습니다."));	
				}
				
//				return;

//				panel3.add(new JLabel("검색된 재료에 알맞은 레시피가 없습니다."));
			} // 파일에 값이 비어있지 않으면
		}
	}); // 검색 이벤트 끝
	

	
	
//	resultButton.addActionListener(new ActionListener() {
	/*resultButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			panel3.removeAll();
			panel3.revalidate();
			panel3.add(recipePanel);
			recipePanel.setBackground(Color.GREEN);

			JLabel title2 = new JLabel("재료 넣기");
			recipePanel.add(title2);
			
			
			System.out.println(e.getSource() instanceof JButton);
			
			if(e.getSource() instanceof JButton) {
				JButton btn = (JButton)e.getSource();
//				System.out.println(btn.getText());
				String title = null;
				System.out.println("테스트");
				
				System.out.println(btn.getText());
				System.out.println(resultButton.getText());
				
				for(int i = 0; i < cateList.size(); i++) {
					title = cateList.get(i).getfName();
					
					
					
//					if(btn.getText().equals("삼겹살김치말이찜")) {
//						recipePanel.add(new JLabel("안녕"));
//					}else {
//						recipePanel.add(new JLabel("같지 않아"));
//						System.out.println("안녕");
//						System.out.println(resultButton.getText());
//					}
				}
			}

			panel3.repaint();
		}
		
		
	});*/
	
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
	}
/*@Override
public void actionPerformed(ActionEvent e) {
	JPanel cp = new JPanel();
	if(e.getSource() instanceof JButton) {
		JButton btn = (JButton)e.getSource();

		
		String title = null;
		for(int i = 0; i < cateList.size(); i++) {
			title = cateList.get(i).getfName();
				System.out.println(title);
				System.out.println(btn);
			
		}
		
		this.removeAll();
		this.revalidate();
		this.add(cp);
		cp.setBackground(Color.GREEN);
		this.repaint();
	}
	
	
}*/



}
