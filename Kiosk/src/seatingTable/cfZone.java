package seatingTable;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class cfZone extends JPanel {
	// �ӽ� db���� �ҷ�����!
	Dbfile db = new Dbfile();
	ArrayList<String> seat = null;
	ArrayList<String> r_time = null;
	ArrayList<String> time = null;
	ArrayList<String> startTime = null;
	ArrayList<String> endTime = null;
	ArrayList<String> rstartTime = null;
	ArrayList<String> rendTime = null;
	ArrayList<String> seat_all = null;
	Date start = new Date();
	Date end = new Date();
	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat fo = new SimpleDateFormat("HH:mm");

	public cfZone(JFrame frame) {
		setBounds(20, 130, 660, 870);
		setLayout(null);

		this.setVisible(false);
	}

	void btn(JButton[] btn, JPanel cfZone) {
		// seat�����ͺҷ�����
		seat = db.select("seat", "select * from payment;");
		r_time = db.select("r_start", "select * from payment;");
		time = db.select("start", "select * from payment;");
		startTime = db.select("start", "select * from payment;");
		endTime = db.select("end", "select * from payment;");
		rstartTime = db.select("r_start", "select * from payment;");
		rendTime = db.select("r_end", "select * from payment;");

		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton((i + 35) + "");
			btn[i].addActionListener(new seatButton(btn[i], i + 1));
			cfZone.add(btn[i]);
			btn[i].setContentAreaFilled(false);
			btn[i].setBorderPainted(false);
			btn[i].setFocusPainted(false);

			// db ���Ͽ� ������ seat ��ư�� �����ɴϴ�.
			for (int j = 0; j < seat.size(); j++) {
				// db ��ȣ�� �¼�ǥ db�� ������� �ڵ� ����
				if (btn[i].getText().equals(seat.get(j))) {
					// �ٷλ���� �ð��� �����Ͱ� �ִ� ��� ��������!
					if (time.get(j) != null) {
						btn[i].setBackground(new Color(000, 153, 102));
						btn[i].setContentAreaFilled(true);
//						�Ķ��� 102�� ��������!
						if (btn[i].getBackground().getBlue() == 102) {
							JButton J = btn[i];
							btn[i].addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									for (int z = 0; z < seat.size(); z++) {
										if (J.getText().equals(seat.get(z))) {
											try {
												start = f.parse(startTime.get(z));
												end = f.parse(endTime.get(z));

											} catch (ParseException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}

											String start_t = fo.format(start);
											String end_t = fo.format(end);

											JOptionPane.showMessageDialog(null, "<HTML>" + "������� �ڸ��Դϴ�." + "<br>"
													+ start_t + "~" + end_t + "</HTML>");
										}
									}

								}
							});
						}
					}
					// ���� �ð��� �����Ͱ� �ִ� ��� ��������
					else if (r_time.get(j) != null) {
						System.out.println("����ð�:" + r_time.get(j));
						try {
							start = f.parse(r_time.get(j));
							end = f.parse(rendTime.get(j));
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						// ���� �ð� �ѽð� ���� ���ϱ� ���� calendar���!
						Calendar cal = Calendar.getInstance();
						cal.setTime(start);
						cal.add(Calendar.HOUR, -1);
						System.out.println("cal:" + cal.getTime());
						String r_start = fo.format(cal.getTime());
						System.out.println("r_start:" + r_start);

						Date dt_now = new Date();
						String now = fo.format(dt_now);
						System.out.println("now:" + now);

						// ���� �ð��� db�ð��� ������ ���� �������� ����!
						if (r_start.equals(now)) {
							btn[i].setBackground(Color.yellow);
							btn[i].setContentAreaFilled(true);
							if (btn[i].getBackground().getBlue() == 0) {
								JButton c = btn[i];
								btn[i].addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {
										// for������ ������ ���������!
										for (int k = 0; k < seat.size(); k++) {
											if (c.getText().equals(seat.get(k))) {
												try {
													start = f.parse(rstartTime.get(k));
													end = f.parse(rendTime.get(k));
												} catch (ParseException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												String start_t = fo.format(start);
												String end_t = fo.format(end);

												JOptionPane.showMessageDialog(null, "<HTML>" + "���� ���� �ڸ��Դϴ�." + "<br>"
														+ start_t + "~" + end_t + "</HTML>");
											}
										}

									}

								});
							}
						}
					}

				}
			}
		}
		btn[0].setBounds(29, 40, 65, 65);
		btn[1].setBounds(29, 152, 65, 65);
		btn[2].setBounds(167, 40, 65, 65);
		btn[3].setBounds(167, 152, 65, 65);
		btn[4].setBounds(235, 40, 65, 65);
		btn[5].setBounds(235, 152, 65, 65);
		btn[6].setBounds(373, 40, 65, 65);
		btn[7].setBounds(373, 152, 65, 65);
		btn[8].setBounds(552, 80, 75, 75);
		btn[9].setBounds(552, 258, 75, 75);
		btn[10].setBounds(52, 550, 75, 75);
		btn[11].setBounds(52, 729, 75, 75);
		btn[12].setBounds(208, 550, 75, 75);
		btn[13].setBounds(208, 729, 75, 75);
		btn[14].setBounds(365, 550, 75, 75);
		btn[15].setBounds(365, 729, 75, 75);

	}

}
