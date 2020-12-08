package com.kh.run;

import com.kh.view.CateInput;
import com.kh.view.MainFrame;

public class Run {

	public static void main(String[] args) {
		new MainFrame();
//		CateInput ci = new CateInput();
//	      ci.mainMenu();
	}

}




/*

package com.kh.pay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.model.controller.ProductController;
import com.kh.model.controller.UserController;
import com.kh.model.vo.Product;
import com.kh.model.vo.User;

public class Payment extends JPanel {
	
	private JFrame mainFrame;
	
	// 장바구니 주문하기 버튼 클릭시 --> 이벤트발생 --> 결제 창으로 넘어오면서 최종 결제 금액 출력하기
	// 회원 총 보유 포인트도 이벤트 발생해야하나 ? 
	// 결제 후 보유 포인트 : 총 결제 금액 - 회원 총 보유 포인트 
	
	ProductController pc = new ProductController();
	UserController uc = new UserController();
	ArrayList<User> userList = uc.getUserList();
	ArrayList<Product> productList = pc.getProductList();
	int pointSum = 0;
	int priceSum = 0;
	JTextField remainPointText = new JTextField(15);
	
	public Payment() {}
	
	public Payment(JFrame mf) {
		
		mainFrame = mf;
		
		//this.setBounds(50,50,1200,1200);
		//this.setPreferredSize(new Dimension(1200,1200));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//this.setBackground(new Color(106, 168, 79));

		JPanel titlePanel = new JPanel();	
		JLabel title = new JLabel("KHMart Payment");
		title.setFont(new Font("맑은고딕",Font.BOLD,50));
		titlePanel.setBackground(new Color(106, 168, 79));
		titlePanel.add(title);
		title.setBorder(new EmptyBorder(100,0,0,0)); //위, 왼쪽, 아래, 오른쪽
		
		JPanel userPanel = new JPanel(); 
		
		userPanel.setBackground(new Color(241, 194, 50));
		userPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK,2),"User's info"));
		userPanel.setLayout(new GridLayout(2,2,1,1));
		userPanel.setSize(1200,1200);
		
			
		JLabel name = new JLabel("회원 성명 :");
		name.setHorizontalAlignment(JLabel.RIGHT);
		name.setFont(new Font("맑은고딕",Font.BOLD,25));
		userPanel.add(name);
		
		JTextField nameText = new JTextField(15);
		nameText.setEditable(false);
		nameText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		nameText.setFont(new Font("맑은고딕",Font.BOLD,25));
		nameText.setHorizontalAlignment(JTextField.LEFT);
		nameText.setBackground(new Color(241, 194, 50));
		userPanel.add(nameText);
		
		for(int i = 0; i < userList.size(); i++) {
			nameText.setText(userList.get(i).getName() +" ");
		}
		
		JLabel address = new JLabel("회원 주소 :");
		address.setHorizontalAlignment(JLabel.RIGHT);
		address.setFont(new Font("맑은고딕",Font.BOLD,25));
		userPanel.add(address);
		
		JTextField addressText = new JTextField(15);
		addressText.setEditable(false);
		addressText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		addressText.setFont(new Font("맑은고딕",Font.BOLD,25));
		addressText.setHorizontalAlignment(JTextField.LEFT);
		addressText.setBackground(new Color(241, 194, 50));
		userPanel.add(addressText);
		
		for(int i = 0; i < userList.size(); i++) {
			addressText.setText(userList.get(i).getAddress() +" ");
		}
		
		// 1. 최종 결제 금액 :  0000포인트   / 장바구니에서 총 계 가져오기 / 수정 못하게
		JPanel payPanel = new JPanel(); 
		
		payPanel.setBackground(new Color(241, 194, 50));
		payPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK,2),"Payment"));
		payPanel.setLayout(new GridLayout(1,2,1,1));
		payPanel.setSize(500,500);
		
		JLabel totalPay = new JLabel("총 결제 금액  :");
		totalPay.setHorizontalAlignment(JLabel.RIGHT);
		totalPay.setFont(new Font("맑은고딕",Font.BOLD,25));
		payPanel.add(totalPay);
		
		JTextField totalPayText = new JTextField(15);
		totalPayText.setEditable(false);
		totalPayText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		totalPayText.setFont(new Font("맑은고딕",Font.BOLD,25));
		totalPayText.setHorizontalAlignment(JTextField.LEFT);
		totalPayText.setBackground(new Color(241, 194, 50));
		payPanel.add(totalPayText);
		
		for(int i = 0; i < productList.size(); i++) {
			priceSum += productList.get(i).getPrice();
			totalPayText.setText(priceSum +"  point");
		}
		
		
		// 2. 회원 총 보유 포인트 : 0000 포인트 / 회원정보에서 보유포인트 가져오기 / 수정 못하게
		JPanel pointPanel = new JPanel(); 
		
		pointPanel.setBackground(new Color(241, 194, 50));
		pointPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK,2),"Point"));
		pointPanel.setLayout(new GridLayout(2,2,1,1));
		pointPanel.setSize(500,500);
		
		JLabel point = new JLabel("총 보유 포인트  :");
		point.setHorizontalAlignment(JLabel.RIGHT);
		point.setFont(new Font("맑은고딕",Font.BOLD,25));
		pointPanel.add(point);
		
		JTextField pointText = new JTextField(15);
		pointText.setEditable(false);
		pointText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		pointText.setFont(new Font("맑은고딕",Font.BOLD,25));
		pointPanel.add(pointText);
		pointText.setHorizontalAlignment(JTextField.LEFT);
		pointText.setBackground(new Color(241, 194, 50));
		pointPanel.add(pointText);
		
		
		for(int i = 0; i < userList.size(); i++) {
			pointSum = userList.get(i).getPoint();
			pointText.setText(pointSum +"  point");
		}
		
		
		// 3. 결제 후 포인트 : 00000 포인트  / 결제 후 포인트를 마이페이지에서 수정가능하게 / 수정 못하게 
		
		JLabel remainPoint = new JLabel("결제 후 포인트  :");
		remainPoint.setFont(new Font("맑은고딕",Font.BOLD,25));
		remainPoint.setHorizontalAlignment(JLabel.RIGHT);
		pointPanel.add(remainPoint);
	
		
		remainPointText.setEditable(false);
		remainPointText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		remainPointText.setFont(new Font("맑은고딕",Font.BOLD,25));
		pointPanel.add(remainPointText);
		remainPointText.setHorizontalAlignment(JTextField.LEFT);
		remainPointText.setBackground(new Color(241, 194, 50));
		pointPanel.add(remainPointText);

		afterPoint();
		

		JPanel pnlCenter = new JPanel(new GridLayout(3,1));
		pnlCenter.setBackground(new Color(241, 194, 50));
		pnlCenter.add(userPanel);
		pnlCenter.add(pointPanel);
		pnlCenter.add(payPanel);

		
		// 4. 취소 버튼 (장바구니로 back) , 결제 버튼 (클릭시 --> 이벤트 처리) 
		// [결제 클릭시] 
		// 1. 결제 되는 경우: 결제 비밀번호 치는 창 뜨게 --> userPWD 입력 --> 틀리면 다시 입력 --> 맞을 경우 결제 완료 창 뜨게
		// 2. 보유 포인트 < 총 결제 금액 : 보유 포인트가 부족합니다. 창 떠서 결제 못하게 --> 취소 버튼 눌러서 장바구니창으로 back
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.setBackground(new Color(106, 168, 79));
		
		JButton btn1 = new JButton("취소");
		JButton btn2 = new JButton("결제");
		buttonPanel.add(btn1);
		buttonPanel.add(btn2);
		btn1.setFont(new Font("맑은고딕", Font.BOLD, 25));
		btn1.setBackground(Color.BLACK);
		btn1.setForeground(Color.WHITE);
		btn2.setFont(new Font("맑은고딕", Font.BOLD, 25));
		btn2.setBackground(Color.BLACK);
		btn2.setForeground(Color.WHITE);
		buttonPanel.setBorder(new EmptyBorder(100,0,0,0)); //위, 왼쪽, 아래, 오른쪽
		
		
		// paypwd 입력시 **** 나오게 ... 
		
		String pwd = userPwd() + "";
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (pointSum < priceSum) {
					JOptionPane.showMessageDialog(null, "보유 포인트가 부족합니다.");
				} else {
					JPanel paypwdPanel = new JPanel();
					JLabel pwdLabel = new JLabel("결제 비밀번호를 입력하세요.");
					JPasswordField pass = new JPasswordField(10);
					paypwdPanel.add(pwdLabel);
					paypwdPanel.add(pass);
					String[] options = new String[] { "확인", "취소" };
					int option = JOptionPane.showOptionDialog(null, paypwdPanel, "The title", JOptionPane.NO_OPTION,
							JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
					if (option == 0) { // 확인 버튼 누를 시
						if (pass.equals(pwd)) {
							char[] password = pass.getPassword();
							System.out.println("결제 비밀번호 : " + new String(password));
							JOptionPane.showMessageDialog(null, "결제 완료 입니다.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호를 다시 입력해주세요.", "비밀번호 오류", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		
		// 예시로 비번 설정 (실제, user 클래스에서 실제 paypwd 가져와야함 )
		//String paypwd = "1234";
		String pwd = userPwd() + "";
		
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// if, 보유 포인트 > 총 결제 금액 --> 결제 비밀번호 입력 창 (잘못 입력 받은 경우 다시 입력하게) 
				//JPasswordField pwd = new JPasswordField(30);
				if (pointSum < priceSum) {
					JOptionPane.showMessageDialog(null, "보유 포인트가 부족합니다.");
				} else {
					String pass = JOptionPane.showInputDialog("결제 비밀번호를 입력하세요.");
					if (pass.equals(pwd)) {
						JOptionPane.showMessageDialog(null, "결제 완료 입니다.");
						// 창 닫하게,,
						// System.out.println(pass);
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호를 다시 입력해주세요.", "비밀번호 오류", JOptionPane.ERROR_MESSAGE);
					}
				}
				// else, 보유 포인트가 < 총 결제 금액 --> 보유 포인트가 부족합니다 창 뜨게 --> 취소 버튼 누른 후 장바구니로 이동
			}
			
			
		});
		
	
		this.add(titlePanel);
		this.add(pnlCenter);
		this.add(buttonPanel);
		
		this.setVisible(true);
		
	}
	
	
	public int afterPoint() {
		//결제 후 포인트 : 00000 포인트 
		//결제후 포인트를 마이페이지에서 수정가능하게
		int remainPoint = pointSum - priceSum;
		remainPointText.setText(remainPoint +"  point");
		
		return remainPoint;
	}	
	
	public String userPwd() { //210
		String pwd = " ";
		
		for (int i = 0; i < userList.size(); i++) {
			pwd = userList.get(i).getPaypwd();
			System.out.println(pwd);
		}
		return pwd;
	}
	
}*/
