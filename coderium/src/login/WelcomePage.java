package login;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomePage {
	
	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel("");
	
	//폰트 설정
	String font = "twayair";
	
	WelcomePage() {
		
		welcomeLabel.setBounds(95, 15, 330, 130);
		welcomeLabel.setFont(new Font(font, Font.PLAIN, 20));
		frame.add(welcomeLabel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(540, 30, 350, 200);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

}
