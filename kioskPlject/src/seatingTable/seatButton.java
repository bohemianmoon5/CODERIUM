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
		 * �¼����� ����! ������ 1. sql�� ����Ҷ� ���� payment�� �����ϱ�.. where ���ǹ��� ������ ����.. ������ �𸣰���..��
		 * ������ payment�� �׳� query ���� �ٷ� ����ϴ� ������ �ذ�.!
		 * 
		 */

		// �¼� ��ȣ db���� ������ ����
//		seat = db.select("seatNum", "select * from payment where id = 'wonho33';");
		seat = d.select("seatNum", "paydata where id = 'wonho33'");
//		seat_all = db.select("seatNum", "select * from payment;");
//		startTime = db.select("starttime", "select * from payment;");
//		endTime = db.select("endtime", "select * from payment;");
//		rstartTime = db.select("r_start", "select * from payment;");
//		rendTime = db.select("r_end", "select * from payment;");
		

		// �¼� ��ȣ�� null�̶�� �¼���ȣ ä���ֱ�! , id�� �������� where��!
		if (seat.get(0) == null) {
//			db.dml("update payment set seatNum =\"" + btn.getText() + "\"where id = 'wonho33';");
			int result = JOptionPane.showConfirmDialog(null, btn.getText()+"��  �����ϰڽ��ϱ�?", "confirm", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION) {
				payment p = new payment(btn.getText() ,Main_swing.getFrame(), "seat");
				p.getFrame().setVisible(true);
//				Dbfile db = new Dbfile();
//				db.dml("update payment set seat = null where id = 'wonho33';");
//				d.dml("update payment set seat = null where id = '����ȣ';");
//				System.out.println("�¼��� �ʱ�ȭ �Ǿ����ϴ�.!");
//				mainPanel main = new mainPanel();
//				main.back_img();
//			System.out.println("�ٲ� �¼� ��ȣ:" + btn.getText());
				System.out.println("�־ȵ�");
//				d.dml("update payment set seatNum =\"" + btn.getText() + "\"where id = '����ȣ';");
//				d.dml("update paydata set seatNum =\"" + btn.getText() + "\"where id = '����ȣ';");
		} else {
			System.out.println("���� �¼���ȣ!:" + seat.get(0));
		}



	}

}
}
