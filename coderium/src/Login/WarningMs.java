package Login;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WarningMs {
	
	JFrame frame = new JFrame();
	JLabel warning = new JLabel("");
	
	WarningMs() {
		
		warning.setBounds(150, 0, 400, 150);
		warning.setFont(new Font("twayair", Font.PLAIN, 20));
		frame.add(warning);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(465, 30, 500, 200);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

}
