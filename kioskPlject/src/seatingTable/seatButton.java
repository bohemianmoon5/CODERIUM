package seatingTable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.pay.payment;
import main.pay.windowEvent;

public class seatButton implements ActionListener {
	JButton btn = null;
	int i = 0;
	JPanel j;
	Component[] btnStat;

	public seatButton(JButton btn) {
		this.btn = btn;
	}

	public seatButton(JButton btn, int i) {
		this.btn = btn;
		this.i = i;
	}

	public seatButton(JButton btn, int i, JPanel j) {
		this.btn = btn;
		this.i = i;
		this.j = j;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// ++js modify
		payment p = new payment(i + 1 + "");
		// ++
		
		if (btn.getBackground().getBlue() == 102) {
			JOptionPane.showMessageDialog(null, "이미 예약된 자리입니다.");
		}

		else {
			Date start = new Date();
			Date end = new Date();
			p.getFrame().setVisible(true);
			// ++js modify
			btnStat = j.getComponents();
			System.out.println(btnStat.length);
			for (int i = 0; i < btnStat.length; i++) {
				btnStat[i].setEnabled(false);
			}
			windowEvent.setComponent(btnStat);
			// ++

			//이 작업이 끝나고 색상이 바뀌어야한다.!
			SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);

			try {
				start = f.parse("20:25:20");
				end = f.parse("22:25:20");
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

//				System.out.println(start);
			long use = end.getTime() - start.getTime();
			long min = use / (60 * 1000);
			btn.setText(null);
			btn.setBackground(new Color(000, 153, 102));
			JLabel used_lb_label = new JLabel("<HTML>" + (i + 1) + "번" + "<br>" + min + "분" + "</HTML>");
			used_lb_label.setLayout(null);
			used_lb_label.setHorizontalAlignment(SwingConstants.LEFT);
			used_lb_label.setFont(new Font("티웨이_항공", Font.BOLD, 10));
			used_lb_label.setSize(53, 90);

			btn.add(used_lb_label);
			btn.setVisible(true);
			btn.setContentAreaFilled(true);

		}

//			if(p.getPrice().equals("4000")) {
//				btn.setText(null);
//				btn.setBackground(new Color(000, 153, 102));
//				JLabel used_lb_label = new JLabel("<HTML>"+(i+1)+"번"+"<br>"+"02:00:00"+"</HTML>");
//				used_lb_label.setLayout(null);
//				used_lb_label.setHorizontalAlignment(SwingConstants.LEFT);
//				used_lb_label.setFont(new Font("티웨이_항공", Font.BOLD, 10));
//				used_lb_label.setSize(53, 90);
//				
//				btn.add(used_lb_label);
//				btn.setVisible(true);
//				btn.setContentAreaFilled(true);
//			}

	}

}
