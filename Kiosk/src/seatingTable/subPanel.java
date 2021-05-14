package seatingTable;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class subPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public subPanel(JFrame frame) {

		setBounds(20, 130, 660, 870);
		setBackground(Color.white);
		setLayout(null);
		frame.getContentPane().add(this);

		seatingImage seatImg = new seatingImage(new ImageIcon("./image/seatting_table_1.jpg").getImage());
		this.add(seatImg);

	}

	void lb_btn(JButton btn, JPanel subPanel, JFrame frame, JButton btns[]) {
		lbZone lb = new lbZone(frame);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanel.setVisible(false);
				lb.setVisible(!lb.isVisible());
				lb.btn(btns, lb);
				
			}
		});
		btn.setBackground(new Color(0, 191, 255));
		btn.setFont(new Font("티웨이_항공", Font.BOLD, 15));
		btn.setBounds(260, 220, 165, 65);
		subPanel.add(btn);
		frame.getContentPane().add(lb);
	}

	void cf_btn(JButton btn, JPanel subPanel, JFrame frame, JButton[] btns) {

		cfZone cf = new cfZone(frame);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanel.setVisible(false);
				cf.setVisible(!cf.isVisible());
				cf.btn(btns, cf);
			}
		});
		btn.setBackground(new Color(0, 191, 255));
		btn.setFont(new Font("티웨이_항공", Font.BOLD, 15));
		btn.setBounds(82, 600, 165, 65);
		subPanel.add(btn);
		frame.getContentPane().add(cf);
	}

	void sr_btn(JButton btn, JPanel subPanel, JFrame frame, JButton[] btns) {
		srZone sr = new srZone(frame);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanel.setVisible(false);
				sr.setVisible(!sr.isVisible());
				sr.btn(btns, sr);
			}
		});
		btn.setBackground(new Color(0, 191, 255));
		btn.setFont(new Font("티웨이_항공", Font.BOLD, 15));
		btn.setBounds(445, 600, 165, 65);
		subPanel.add(btn);
		frame.getContentPane().add(sr);
	}
}
