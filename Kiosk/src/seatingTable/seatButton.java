package seatingTable;

import java.awt.Color;
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
import javax.swing.SwingConstants;

import main.pay.payment;

public class seatButton implements ActionListener  {
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

		if (btn.getBackground().getBlue() == 102) {
			JOptionPane.showMessageDialog(null, "�̹� ����� �ڸ��Դϴ�.");
		}

		else {
				Date start = new Date();
				Date end = new Date();
				p.getFrame().setVisible(true);
				p.setInfo(i + 1 + "");
				System.out.println("p����:" + p.getInfo());
				
				
//			 	�� �۾��� ������ ������ �ٲ����Ѵ�.!
				SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);
				
				try {
					start = f.parse("20:25:20");
					end = f.parse("22:25:20");
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println(start);
				long use = end.getTime()- start.getTime() ;
				long min = use/(60*1000);
				btn.setText(null);
				btn.setBackground(new Color(000, 153, 102));
				JLabel used_lb_label = new JLabel("<HTML>" + (i+1) + "��" + "<br>" + min+"��" + "</HTML>");
				used_lb_label.setLayout(null);
				used_lb_label.setHorizontalAlignment(SwingConstants.LEFT);
				used_lb_label.setFont(new Font("Ƽ����_�װ�", Font.BOLD, 10));
				used_lb_label.setSize(53, 90);

				btn.add(used_lb_label);
				btn.setVisible(true);
				btn.setContentAreaFilled(true);
				
			} 

//			if(p.getPrice().equals("4000")) {
//				btn.setText(null);
//				btn.setBackground(new Color(000, 153, 102));
//				JLabel used_lb_label = new JLabel("<HTML>"+(i+1)+"��"+"<br>"+"02:00:00"+"</HTML>");
//				used_lb_label.setLayout(null);
//				used_lb_label.setHorizontalAlignment(SwingConstants.LEFT);
//				used_lb_label.setFont(new Font("Ƽ����_�װ�", Font.BOLD, 10));
//				used_lb_label.setSize(53, 90);
//				
//				btn.add(used_lb_label);
//				btn.setVisible(true);
//				btn.setContentAreaFilled(true);
//			}

	}

}