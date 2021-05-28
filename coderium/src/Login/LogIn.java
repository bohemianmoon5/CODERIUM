package Login;

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
	JButton loginButton = new JButton("로그인");
	
	public LogIn() {
		
		LogIn.setBounds(132, 214, 470, 266);
		LogIn.setToolTipText("");
		LogIn.setBackground(new Color(220, 220, 220));
		LogIn.setLayout(null);
		
		// Id
		userIDLabel.setBounds(60, 63, 91, 25);
		userIDLabel.setFont(new Font("twayair", Font.PLAIN, 20));
		LogIn.add(userIDLabel);
		
		userIDField.setBounds(60, 90, 340, 34);
		LogIn.add(userIDField);
		
		// Pw
		userPasswordLabel.setFont(new Font("twayair", Font.PLAIN, 20));
		userPasswordLabel.setBounds(60, 127, 111, 42);
		LogIn.add(userPasswordLabel);
		
		userPasswordField.setBounds(60, 162, 340, 34);
		LogIn.add(userPasswordField);
		
		// 로그인 
		loginButton.setFont(new Font("twayair", Font.PLAIN, 15));
		loginButton.setBounds(297, 211, 103, 35);
		LogIn.add(loginButton);
	
	}
}
