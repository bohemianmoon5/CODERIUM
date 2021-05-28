package Login;

import java.awt.Font;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VerifiedNum {
	
	JFrame frame = new JFrame();
	JLabel randomNum = new JLabel(randomNum());
	
	VerifiedNum() {
		
		randomNum.setBounds(0, 0, 200, 35);
		randomNum.setFont(new Font("twayair", Font.PLAIN, 20));
		
		frame.add(randomNum);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	String randomNum() {
		
		Random rd = new Random();
		String Num = "";
		
		for(int i = 0; i < 4; i++) {
			Num += rd.nextInt(9);
		}
		return Num;
	}
	
}
