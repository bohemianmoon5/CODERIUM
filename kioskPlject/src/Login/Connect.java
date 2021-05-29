package Login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.pay.component.fighting;
import main.pay.data.db;
import main.pay.data.modiData;
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
	String font = "twayair";
	Component[] first;
	JTextField loginId;
	JTextField loginPwd;
	String now="";

	public Connect() {

	}

	public Connect(JFrame frame, JPanel panel, Component[] first,
			JTextField loginId, JTextField loginPwd,String now) {
		this.frame = frame;
		this.panel = panel;
		this.first = first;
		this.loginId = loginId;
		this.loginPwd = loginPwd;
		this.now=now;
		Connect.setBounds(0, 0, 720, 1080);
		Connect.setLayout(null);
		Connect.setToolTipText("");
		Connect.setBackground(new Color(255, 255, 255));
		Connect.setVisible(false);

		// 바로 이용하기
		Today.setBounds(170, 270, 164, 56);
		Today.setFont(new Font(font, Font.PLAIN, 16));

		// 예약
		Reservation.setBounds(390, 270, 164, 56);
		Reservation.setFont(new Font(font, Font.PLAIN, 16));

		// 입실
		In.setBounds(170, 390, 164, 56);
		In.setFont(new Font(font, Font.PLAIN, 16));

		// 퇴실
		Out.setBounds(390, 390, 164, 56);
		Out.setFont(new Font(font, Font.PLAIN, 16));

		// 자리바꾸기
		SeatChange.setBounds(280, 330, 164, 56);
		SeatChange.setFont(new Font(font, Font.PLAIN, 16));

		seatEvent(Today,"now");
		seatEvent(SeatChange,"change");
		inEvent(In);
		reservEvent(Reservation);
	}

	//좌석 관련 이벤트 구현
	public void seatEvent(JButton btn, String menuType) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("번호 들어간다");
				String str = "";
				//바로이용하기 클릭한 경우
				if(menuType.equals("now")) {
					str = "바로 사용하시겠습니까?";
				}else {	//자리변경하기 클릭한 경우
					str = "자리를 변경하시겠습니까?";
				}
				int result = JOptionPane.showConfirmDialog(null, str, "confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					panel.setVisible(false);
					if(!menuType.equals("today")) {
						db d = new db();
						d.dml("update paydata set SeatNum = null where id = '" + MainF.user + "';");	
					}
					Main m = new Main(menuType, frame, panel);
				}
			}
		});
	}

	//예약 이벤트 구현
	public void reservEvent(JButton btn) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("예약 들어간다");
				int result = JOptionPane.showConfirmDialog(null, "예약하시겠습니까?", "confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					panel.setVisible(false);
					resrvationMain rm = new resrvationMain("re", frame, panel);
				}
			}
		});
	}

	
	//입실 이벤트 구현
	public void inEvent(JButton btn) {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> data = new ArrayList<String>();
				System.out.println("입실 들어간다");
				int result = JOptionPane.showConfirmDialog(null, "입실하시겠습니까?", "confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					db d = new db();
					//조건에 맞는 데이터 검색하여 저장
					data = d.select("*","paydata WHERE Id='"+MainF.user+"' AND StartTime IS NOT NULL AND StartTime>='"+now+"' AND EndTime>='"+now+"'");
					//조건에 맞는 데이터가 있으면 메인으로 돌아감
					if(data.size()==1) {
						for (int i = 0; i < panel.getComponentCount(); i++) {
							panel.getComponent(i).setVisible(false);
						}
						for (int i = 0; i < first.length; i++) {
							panel.add(first[i]);
						}
						for (int i = 0; i < panel.getComponentCount(); i++) {
							if (panel.getComponent(i).toString().contains("Button")) {
								panel.getComponent(i).setVisible(true);
							}else {
								panel.getComponent(i).setVisible(false);							
							}
						}
						MainF.user="";
					}else {	//조건에 맞는 데이터가 없으면 message
						JOptionPane.showMessageDialog(null, "입실할 수 없는 사용자입니다.","Message", result, null);
					}
					//login 시 입력했던 field 초기화
					loginId.setText("");
					loginPwd.setText("");
				}
			}
		});
	}

}
