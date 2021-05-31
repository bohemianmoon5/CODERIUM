package Login;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Connect {
	
	JPanel Connect = new JPanel();
	JButton Today = new JButton("바로 이용하기");
	JButton Reservation = new JButton("예약");
	JButton In = new JButton("입실");
	JButton Out = new JButton("퇴실");
	JButton SeatChange = new JButton("자리바꾸기");
	
	public Connect() {
		
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
		
	}

}
