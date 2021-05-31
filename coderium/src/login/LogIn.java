package login;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class LogIn extends JPanel{
	
	JPanel LogIn = new JPanel();
	JLabel userIDLabel = new JLabel("User ID");
	JLabel userPasswordLabel = new JLabel("Password");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	RoundButton loginButton = new RoundButton("로그인");
	
	//폰트 설정
	String font = "twayair";
	
	public LogIn() {
		
		LogIn.setBounds(132, 214, 470, 266);
		LogIn.setToolTipText("");
		LogIn.setBackground(new Color(220, 220, 220));
		LogIn.setLayout(null);
		
		// Id
		userIDLabel.setBounds(60, 63, 91, 25);
		userIDLabel.setFont(new Font(font, Font.PLAIN, 20));
		LogIn.add(userIDLabel);
		
		userIDField.setBounds(60, 90, 340, 34);
		LogIn.add(userIDField);
		
		// Pw
		userPasswordLabel.setFont(new Font(font, Font.PLAIN, 20));
		userPasswordLabel.setBounds(60, 127, 111, 42);
		LogIn.add(userPasswordLabel);
		
		userPasswordField.setBounds(60, 162, 340, 34);
		LogIn.add(userPasswordField);
		
		// 로그인 
		loginButton.setFont(new Font(font, Font.PLAIN, 15));
		loginButton.setBounds(310, 211, 90, 30);
		LogIn.add(loginButton);
	
	}
}
