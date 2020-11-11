package com.kh.recipe.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TodayPanel extends JPanel {
	public TodayPanel(JFrame mf) {
		
		this.setLayout(new GridLayout(5,1));
		
		Font fontKor = new Font("한컴 백제 B", Font.TRUETYPE_FONT, 30);
		
		JLabel title = new JLabel("오늘의 추천 메뉴");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(fontKor);
		this.add(title,"North");
		
		// 배열을 선언하여 여러 개의 체크 박스 생성함
		String[] foodType = {"한식", "일식", "중식", "분식", "한식", "도시락", "특별식", "디저트"};
		JButton[] btnFood = new JButton[8];
		JPanel btnPanel = new JPanel();
//		btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS));
		
		for(int i = 0; i < foodType.length; i++) {
			btnFood[i] = new JButton(foodType[i].toString());
			btnPanel.add(btnFood[i]);
			// 각 버튼 클릭시 별도의 화면 이동 이벤트 작성하기 
			
			btnFood[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JPanel changePanel = null;
					
					if(e.getSource() instanceof JButton) {
						JButton btn = (JButton)e.getSource();
					}
					
				}
				
			});
		}
		this.add(btnPanel);
		
		/*JCheckBox[] check = new JCheckBox[8];
		
		for(int i = 0; i < check.length; i++) {
			check[i] = new JCheckBox(foodType[i]);
		}
		
		
		//여러 개의 체크박스를 반복문을 사용하여 부착
		JPanel checkPanel = new JPanel();
		for(int i = 0; i< check.length; i++) {
			checkPanel.add(check[i]);
		}
		
		this.add(checkPanel);*/
		
		
		//결과 영역
		
	}

}
