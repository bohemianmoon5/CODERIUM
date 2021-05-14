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

		// seatPanel에 있는 자식 컴포넌트 저장 후 payment로 넘김
		// c에 저장 시 결제창이 열리므로 버튼 비활성화 하기
//		Component[] c = new Component[p.getSeatPanel().getComponentCount()];
//		c=p.getSeatPanel().getComponents();
//		for(int i=0; i<p.getSeatPanel().getComponentCount();i++) {
//			c[i].setEnabled(false);
//		}
//		payment.setSeatCom(c);
//		
		btn.setText(null);
		if (btn.getBackground().getBlue() == 102) {
			JOptionPane.showMessageDialog(null, "이미 예약된 자리입니다.");
		} else {
			btn.setBackground(new Color(000, 153, 102));

//			btn.setText("<HTML><body><left>현재<br>사용중</left><body></HTML>");
//			btn.setHorizontalAlignment(SwingConstants.LEFT);
//			btn.setFont(new Font("티웨이_항공", Font.BOLD, 8));
			JLabel used_lb_label = new JLabel("<HTML>"+(i+1)+"번"+"<br>"+"120"+"</HTML>");
			used_lb_label.setLayout(null);
			used_lb_label.setHorizontalAlignment(SwingConstants.LEFT);
			used_lb_label.setFont(new Font("티웨이_항공", Font.BOLD, 10));
//			used_lb_label.setPreferredSize(new Dimension(53, 90));
			used_lb_label.setSize(53, 90);
			btn.add(used_lb_label);

		}

	}
}