package seatingTable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import main.pay.payment;


public class seatButton implements ActionListener {
	JButton btn = null;
	int i = 0; 
	public seatButton(JButton btn) {
		this.btn = btn;
	}
	
	public seatButton(JButton btn, int i) {
		this.btn = btn;
		this.i = i;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		payment p = new payment();
		p.getFrame().setVisible(true);
		p.setInfo(i+1+"");

		btn.setText(null);
		if (btn.getBackground().getBlue() == 102) {
			JOptionPane.showMessageDialog(null, "�̹� ����� �ڸ��Դϴ�.");
		} else {
			btn.setBackground(new Color(000, 153, 102));

			JLabel used_lb_label = new JLabel("<HTML>"+(i+1)+"��"+"<br>"+"120"+"</HTML>");
			used_lb_label.setLayout(null);
			used_lb_label.setHorizontalAlignment(SwingConstants.LEFT);
			used_lb_label.setFont(new Font("Ƽ����_�װ�", Font.BOLD, 10));
			used_lb_label.setSize(53, 90);
			
			btn.add(used_lb_label);
			btn.setVisible(true);
			btn.setContentAreaFilled(true);

		}

	}
}