package Login;

import javax.swing.JPanel;
import javax.swing.JTextField;

import reservation.RoundButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

public class NonMember extends JPanel{
	
	JPanel NonMember = new JPanel();
	RoundButton nonMemberButton = new RoundButton("비회원");
	JLabel cellPhoneNum = new JLabel("휴대폰 번호");
	JLabel verifiedNum = new JLabel("인증번호");
	JButton loginButtonNon = new JButton("로그인");
	JButton returnButton = new JButton("돌아가기");
	
	JTextField cellPhoneNumField;
	JTextField verifiedNumField;
	
	public NonMember() {
		
		NonMember.setLayout(null);
		NonMember.setToolTipText("");
		NonMember.setBackground(new Color(220, 220, 220));
		NonMember.setBounds(132, 214, 470, 266);
		
		// 비회원 버튼 
		nonMemberButton.setFont(new Font("twayair", Font.PLAIN, 14));
		nonMemberButton.setBounds(373, 211, 91, 34);
		
		// 휴대폰 번호 
		cellPhoneNum.setFont(new Font("twayair", Font.PLAIN, 19));
		cellPhoneNum.setBounds(60, 63, 151, 25);
		NonMember.add(cellPhoneNum);
		
		cellPhoneNumField = new JTextField();
		cellPhoneNumField.setBounds(60, 90, 340, 34);
		
		// 휴대폰 번호 포맷 바꾸기 & 인증번호 띄우기
//		cellPhoneNumField.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//				if(cellPhoneNumField.getText().length() == 11) {
//					cellPhoneNumField.setText(phone_format(cellPhoneNumField.getText()));
//					VerifiedNum verifiedNum = new VerifiedNum();
//					verifiedNum.randomNum();
//					
//				}
//				
//			}
//		});
		
		NonMember.add(cellPhoneNumField);
		
		// 인증번호 
		verifiedNum.setFont(new Font("twayair", Font.PLAIN, 19));
		verifiedNum.setBounds(60, 127, 168, 42);
		NonMember.add(verifiedNum);
		
		verifiedNumField = new JTextField();
		verifiedNumField.setBounds(60, 162, 340, 34);
		NonMember.add(verifiedNumField);
		
		// 비회원 로그인 버튼 
		loginButtonNon.setFont(new Font("twayair", Font.PLAIN, 15));
		loginButtonNon.setBounds(297, 211, 103, 35);
		NonMember.add(loginButtonNon);
		
		// 돌아가기 
		returnButton.setFont(new Font("twayair", Font.PLAIN, 14));
		returnButton.setBounds(373, 6, 91, 34);
		NonMember.add(returnButton);
		
	}
	
}
