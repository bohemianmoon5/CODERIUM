package seatingTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import reservation.resrvationMain;

import main.pay.payment;
import main.pay.data.db;

public class seatButton implements ActionListener {
	Dbfile db = new Dbfile();
	db d = new db();
	JButton btn = null;
//	ArrayList<String> seat = null;
	ArrayList<String> startTime = null;
	ArrayList<String> endTime = null;
	ArrayList<String> rstartTime = null;
	ArrayList<String> rendTime = null;
	ArrayList<String> seat_all = null;
	Date start = new Date();
	Date end = new Date();
	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat fo = new SimpleDateFormat("HH:mm:ss");
	resrvationMain rm = new resrvationMain();

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
		/*
		 * �¼����� ����! ������ 1. sql�� ����Ҷ� ���� payment�� �����ϱ�.. where ���ǹ���
		 * ������ ����.. ������ �𸣰���..�� ������ payment�� �׳� query ���� �ٷ� ����ϴ�
		 * ������ �ذ�.!
		 * 
		 */

		// �¼� ��ȣ db���� ������ ����
//		System.out.println("Main.type:"+Main.type);

//		seat = d.select("SeatNum", "paydata where Id = 'wonho33'");

//		if (seat.get(0)==null) {
		int result = JOptionPane.showConfirmDialog(null, btn.getText() + "를  선택하겠습니까?", "confirm",
				JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			if (Main.type.equals("reserve")) {
				System.out.println(btn.getText() + "번!!!");
				resrvationMain.btn_seat.setText(btn.getText() + "번 좌석");
				Main.getFrame().dispose();
				// 결제 버튼 활성화
				resrvationMain.btn_pay.setEnabled(true);
				Main.type = "";
			} else {
				payment p = new payment(btn.getText(), Main.getFrame(), "seat");
				p.getFrame().setVisible(true);

			}

//		} else {
//			System.out.println("현재 좌석번호:" + seat.get(0));
//		}

		}
	}
}
