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

	void lb_btn(JButton btn, JPanel subPanel, JFrame frame, JButton btns[]) {
		
		btn.setBackground(new Color(0, 191, 255));
		btn.setText("스터디존");
		btn.setFont(new Font("티웨이_항공", Font.BOLD, 15));
		btn.setBounds(260, 220, 165, 65);
//		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
//		btn.setOpaque(false);
		btn.setVisible(true);
		
		lbZone lb = new lbZone(frame);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanel.setVisible(false);
				lb.setVisible(!lb.isVisible());
				lb.btn(btns, lb);
				seatingImage seatImg = new seatingImage(new ImageIcon("./image/lb_zone_1.jpg").getImage());
				lb.add(seatImg);
				
			}
		});
		
		frame.getContentPane().add(lb);
		subPanel.add(btn);
	
	}

	
	
	void cf_btn(JButton btn, JPanel subPanel, JFrame frame, JButton[] btns) {
		btn.setBackground(new Color(0, 191, 255));
		btn.setFont(new Font("티웨이_항공", Font.BOLD, 15));
		btn.setBounds(82, 600, 165, 65);
		btn.setVisible(true);
		cfZone cf = new cfZone(frame);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanel.setVisible(false);
				cf.setVisible(!cf.isVisible());
				cf.btn(btns, cf);
				seatingImage seatImg = new seatingImage(new ImageIcon("./image/cf_zone_1.jpg").getImage());
				cf.add(seatImg);
			}
		});
//		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		frame.getContentPane().add(cf);
		subPanel.add(btn);
	}

	void sr_btn(JButton btn, JPanel subPanel, JFrame frame, JButton[] btns) {
		btn.setBackground(new Color(0, 191, 255));
		btn.setFont(new Font("티웨이_항공", Font.BOLD, 15));
		btn.setBounds(445, 600, 165, 65);
		btn.setVisible(true);
		srZone sr = new srZone(frame);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanel.setVisible(false);
				sr.setVisible(!sr.isVisible());
				sr.btn(btns, sr);
				seatingImage seatImg = new seatingImage(new ImageIcon("./image/sr_zone_1.jpg").getImage());
				sr.add(seatImg);
			}
		});
//		btn.setContentAreaFilled(false);
//		btn.setBorderPainted(false);
//		btn.setFocusPainted(false);
		subPanel.add(btn);
		frame.getContentPane().add(sr);
	}
	
	public subPanel(JFrame frame) {

		setBounds(20, 130, 660, 870);
		setBackground(Color.white);
		setLayout(null);
//		seatingImage seatImg = new seatingImage(new ImageIcon("./image/seatting_table_1.jpg").getImage());
//		this.add(seatImg);
		frame.getContentPane().add(this);
		
	}
}
