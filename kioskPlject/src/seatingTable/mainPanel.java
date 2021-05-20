package seatingTable;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public mainPanel(JFrame jframe) {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setBounds(0, 0, 700, 1080);
//		jframe.getContentPane().add(this);
		
		seatingImage home_img = new seatingImage(new ImageIcon("./src/Image/home_background.png").getImage());
		this.add(home_img);
		
	}
	
	public void main_btn(JButton btn[]) {
//		btn.setBackground(new Color());
		System.out.println("잘들어가니?");
		for (int i = 0; i < btn.length; i++) {
			btn[i].setBackground(new Color(0, 191, 255));
			btn[i].setFont(new Font("티웨이_항공", Font.BOLD, 18));
			btn[i].setBounds((60*i)+50, 21, 120, 70);
			this.add(btn[i]);
			
		}
	}
	
}
