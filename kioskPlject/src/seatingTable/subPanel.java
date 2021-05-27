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

	//subpanel studyzone ��ư!
	public void lb_btn(JButton btn, JPanel subPanel, JFrame frame, JButton btns[]) {
		
//		btn.setBackground(new Color(0, 191, 255));
		btn.setText("���͵���");
		btn.setFont(new Font("Ƽ����_�װ�", Font.BOLD, 15));
		btn.setBounds(260, 220, 165, 65);
		btn.setVisible(true);
		btn.setIcon(new ImageIcon("./src/Image/studyzone.jpg"));
		btn.setText("���͵���");
		lbZone lb = new lbZone(frame);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanel.setVisible(false);
				lb.setVisible(!lb.isVisible());
				lb.btn(btns, lb);
				seatingImage seatImg = new seatingImage(new ImageIcon("./src/image/lb_zone_1.jpg").getImage());
				lb.add(seatImg);
			}
		});
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		frame.getContentPane().add(lb);
		subPanel.add(btn);
	
	}

	
	// caffe zone ��ư!
	public void cf_btn(JButton btn, JPanel subPanel, JFrame frame, JButton[] btns) {
//		btn.setBackground(new Color(0, 191, 255));
		btn.setText("ī����");
		btn.setFont(new Font("Ƽ����_�װ�", Font.BOLD, 15));
//		btn.setBounds(82, 600, 165, 65);
		btn.setBounds(15, 510, 300, 380);
		btn.setVisible(true);
//		btn.setIcon(new ImageIcon("./src/Image/roompic.png"));
		cfZone cf = new cfZone(frame);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanel.setVisible(false);
				cf.setVisible(!cf.isVisible());
				cf.btn(btns, cf);
				seatingImage seatImg = new seatingImage(new ImageIcon("./src/Image/cf_zone_1.jpg").getImage());
				cf.add(seatImg);
			}
		});
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		frame.getContentPane().add(cf);
		subPanel.add(btn);
	}
	
// study room ��ư! 
	public void sr_btn(JButton btn, JPanel subPanel, JFrame frame, JButton[] btns) {
//		btn.setBackground(new Color(0, 191, 255));
		btn.setText("���͵��");
		btn.setFont(new Font("Ƽ����_�װ�", Font.BOLD, 15));
		btn.setBounds(445, 600, 165, 65);
		btn.setVisible(true);
		btn.setIcon(new ImageIcon("./src/Image/roompic.png"));
		srZone sr = new srZone(frame);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subPanel.setVisible(false);
				sr.setVisible(!sr.isVisible());
				sr.btn(btns, sr);
				seatingImage seatImg = new seatingImage(new ImageIcon("./src/Image/sr_zone_1.jpg").getImage());
				sr.add(seatImg);
			}
		});
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		subPanel.add(btn);
		frame.getContentPane().add(sr);
	}
	
// �ڸ� ���� ��ư
		
	
	public subPanel(JFrame frame) {

		setBounds(20, 130, 660, 870);
		setBackground(Color.white);
		setLayout(null);

		
	}
	
	public subPanel() {
		super();
		setBounds(20, 130, 660, 870);
		setBackground(Color.white);
		setLayout(null);
	}
}
