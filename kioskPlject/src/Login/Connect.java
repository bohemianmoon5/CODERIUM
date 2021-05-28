package Login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.pay.data.db;
import reservation.resrvationMain;
import seatingTable.Main;

public class Connect {
	JFrame frame;
	JPanel panel;
	JPanel Connect = new JPanel();
	JButton Today = new JButton("바로 이용하기");
	JButton Reservation = new JButton("예약");
	JButton In = new JButton("입실");
	JButton Out = new JButton("퇴실");
	JButton SeatChange = new JButton("자리바꾸기");

	public Connect() {

	}

	public Connect(JFrame frame, JPanel panel) {
		this.frame = frame;
		this.panel = panel;
		Connect.setBounds(0, 0, 720, 1080);
		Connect.setLayout(null);
		Connect.setToolTipText("");
		Connect.setBackground(new Color(255, 255, 255));
		Connect.setVisible(false);

		// 바로 이용하기
		Today.setBounds(170, 270, 164, 56);
		Today.setFont(new Font("twayair", Font.PLAIN, 16));

		// 예약
		Reservation.setBounds(390, 270, 164, 56);
		Reservation.setFont(new Font("twayair", Font.PLAIN, 16));

		// 입실
		In.setBounds(170, 390, 164, 56);
		In.setFont(new Font("twayair", Font.PLAIN, 16));

		// 퇴실
		Out.setBounds(390, 390, 164, 56);
		Out.setFont(new Font("twayair", Font.PLAIN, 16));

		// 자리바꾸기
		SeatChange.setBounds(280, 330, 164, 56);
		SeatChange.setFont(new Font("twayair", Font.PLAIN, 16));

		todayEvent(Today);
		reservEvent(Reservation);
	}

	public void todayEvent(JButton btn) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("번호 들어간다");
				int result = JOptionPane.showConfirmDialog(null, "바로 사용하시겠습니까?", "confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					panel.setVisible(false);
					db d = new db();
					d.dml("update paydata set seatNum = null where id = 'wonho33';");
					System.out.println("좌석이 초기화 되었습니다.!");
				}
				if (Main.t.equals("now")) {
					System.out.println("다시 돌아가");
					for (int i = 0; i < Main.Main_p.length; i++) {
						Main.main_panel.add(Main.Main_p[i]);
					}
					frame.add(Main.main_panel);
				} else {
					Main m = new Main("now", frame, panel);
				}
			}
		});
	}

	public void reservEvent(JButton btn) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("예약 들어간다");
				int result = JOptionPane.showConfirmDialog(null, "예약하시겠습니까?", "confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					panel.setVisible(false);
				}
				resrvationMain rm = new resrvationMain(frame, "re");
			}
		});
	}
}
