package seatingTable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class srZone extends JPanel {

	srZone(JFrame frame) {
		setBounds(20, 130, 660, 870);
		setLayout(null);

		

		this.setVisible(false);
	}
	
	void btn(JButton[] btn, JPanel srZone) {
		btn[0] = new JButton("51");
		btn[0].addActionListener(new seatButton(btn[0], 1));
		btn[0].setBounds(115, 300, 111, 100);
		srZone.add(btn[0]);
		btn[0].setContentAreaFilled(false);
		btn[0].setBorderPainted(false);
		btn[0].setFocusPainted(false);

		btn[1] = new JButton("52");
		btn[1].addActionListener(new seatButton(btn[1], 2));
		btn[1].setBounds(438, 300, 111, 100);
		srZone.add(btn[1]);
		btn[1].setContentAreaFilled(false);
		btn[1].setBorderPainted(false);
		btn[1].setFocusPainted(false);
		
	}
	
}
