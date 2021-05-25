package seatingTable;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import main.pay.payment;
import main.pay.data.db;

public class seatButton implements ActionListener {
	Dbfile db = new Dbfile();
	db d = new db();
	JButton btn = null;
	ArrayList<String> seat = null;
	ArrayList<String> startTime = null;
	ArrayList<String> endTime = null;
	ArrayList<String> rstartTime = null;
	ArrayList<String> rendTime = null;
	ArrayList<String> seat_all = null;
	Date start = new Date();
	Date end = new Date();
	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat fo = new SimpleDateFormat("HH:mm:ss");
	
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
		 * 좌석변경 구현! 문제점 1. sql문 사용할때 변수 payment를 넣으니까.. where 조건문이 먹히지 않음.. 왜인지 모르겠음..ㅠ
		 * 하지만 payment를 그냥 query 문에 바로 사용하니 문제점 해결.!
		 * 
		 */


		// 좌석 번호 db에서 가지고 오기
//		seat = db.select("seatNum", "select * from payment where id = 'wonho33';");
		seat = d.select("seatNum", "paydata where id = '정원호'");
//		seat_all = db.select("seatNum", "select * from payment;");
//		startTime = db.select("starttime", "select * from payment;");
//		endTime = db.select("endtime", "select * from payment;");
//		rstartTime = db.select("r_start", "select * from payment;");
//		rendTime = db.select("r_end", "select * from payment;");
		

		// 좌석 번호가 null이라면 좌석번호 채워주기! , id와 필히연동 where문!
		if (seat.get(0) == null) {
//			db.dml("update payment set seatNum =\"" + btn.getText() + "\"where id = 'wonho33';");
			int result = JOptionPane.showConfirmDialog(null, btn.getText()+"를  선택하겠습니까?", "confirm", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION) {
				payment p = new payment(btn.getText() ,Main_swing.getFrame(), "seat");
				p.getFrame().setVisible(true);
//				Dbfile db = new Dbfile();
//				db.dml("update payment set seat = null where id = 'wonho33';");
//				d.dml("update payment set seat = null where id = '정원호';");
//				System.out.println("�¼��� �ʱ�ȭ �Ǿ����ϴ�.!");
//				mainPanel main = new mainPanel();
//				main.back_img();
//			System.out.println("�ٲ� �¼� ��ȣ:" + btn.getText());
				System.out.println("�־ȵ�");
//				d.dml("update payment set seatNum =\"" + btn.getText() + "\"where id = '정원호';");
//				d.dml("update paydata set seatNum =\"" + btn.getText() + "\"where id = '정원호';");
		} else {
			System.out.println("현재 좌석번호!:" + seat.get(0));
		}



	}

}
}
