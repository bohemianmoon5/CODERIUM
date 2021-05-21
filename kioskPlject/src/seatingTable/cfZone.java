package seatingTable;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class cfZone extends JPanel {

	public cfZone(JFrame frame) {
		setBounds(20, 130, 660, 870);
		setLayout(null);



		this.setVisible(false);
	}

	void btn(JButton[] btn, JPanel cfZone) {
		
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton((i+35)+"");
			//++js modify
			cfZone.add(btn[i]);
			System.out.println("cfZone Component : "+cfZone.getComponentCount());
			btn[i].addActionListener(new seatButton(btn[i], i+1,cfZone));
			//++
			btn[i].setContentAreaFilled(false);
			btn[i].setBorderPainted(false);
			btn[i].setFocusPainted(false);
		}
		btn[0].setBounds(29, 40, 65, 65);
		btn[1].setBounds(29, 152, 65, 65);
		btn[2].setBounds(167, 40, 65, 65);
		btn[3].setBounds(167, 152, 65, 65);
		btn[4].setBounds(235, 40, 65, 65);
		btn[5].setBounds(235, 152, 65, 65);
		btn[6].setBounds(373, 40, 65, 65);
		btn[7].setBounds(373, 152, 65, 65);
		btn[8].setBounds(552, 80, 75, 75);
		btn[9].setBounds(552, 258, 75, 75);
		btn[10].setBounds(52, 550, 75, 75);
		btn[11].setBounds(52, 729, 75, 75);
		btn[12].setBounds(208, 550, 75, 75);
		btn[13].setBounds(208, 729, 75, 75);
		btn[14].setBounds(365, 550, 75, 75);
		btn[15].setBounds(365, 729, 75, 75);
		
	
	}

}
