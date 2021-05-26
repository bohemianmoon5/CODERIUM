package seatingTable;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.pay.payment;
import main.pay.data.db;

public class lbZone extends JPanel {

	int num2 = 0;
	int num3 = 0;
	int num4 = 0;
//	Dbfile db = new Dbfile();
	db d = new db();
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
	

//	db 불러오기.!

//	SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd/HH:mm");
//	ArrayList<String> time = new ArrayList<String>();
//	ArrayList<String> timer = new ArrayList<String>();
	/**
	 * 스터디존 좌석표 생성!
	 */
	private static final long serialVersionUID = 1L;

	// 스터디존 JPanel 생성
	public lbZone(JFrame frame) {
		setBounds(20, 130, 660, 870);
		setLayout(null);
		this.setVisible(false);
	}

	// 좌석표 버튼 생성

	void btn(JButton[] btn, JPanel lbZone) {
		// seat data 불러오기
//		seat = db.select("seatNum", "select * from payment;");
//		r_time = db.select("r_start", "select * from payment;");
//		time = db.select("startTime", "select * from payment;");
//		startTime = db.select("starttime", "select * from payment;");
//		endTime = db.select("endtime", "select * from payment;");
//		rstartTime = db.select("r_start", "select * from payment;");
//		rendTime = db.select("r_end", "select * from payment;");
		seat = d.select("seatNum", "paydata");
//		r_time = db.select("r_start", "paydata");
		time = d.select("startTime", "paydata");
		startTime = d.select("startTime", "paydata");
		endTime = d.select("endTime", "paydata");
//		rstartTime = db.select("r_start", "paydata");
//		rendTime = d.select("r_end", "paydata");

//		1~12번좌석 번호 생성
		for (int i = 0; i < btn.length; i++) {
			if (i < 12) {
				btn[i] = new JButton((i + 1) + "");

				btn[i].addActionListener(new seatButton(btn[i], i));

				// 버튼의 위치를 잡아줍니다.
				btn[i].setBounds(13 + (i * 53), 23, 53, 90);
				lbZone.add(btn[i]);
			}
//		13~19번좌석 생성	
			else if (i < 19) {
				btn[i] = new JButton((i + 1) + "");
				btn[i].addActionListener(new seatButton(btn[i], i));

				// 버튼의 위치를 잡아줍니다.
				if (num2 < 7) {
					btn[i].setBounds(72 + (num2 * 53), 348, 53, 90);
					lbZone.add(btn[i]);
				}
				num2++;

			}
//		20~26번 좌석 생성
			else if (i < 26) {

				btn[i] = new JButton((i + 1) + "");
				btn[i].addActionListener(new seatButton(btn[i], i));

				// 버튼의 위치를 잡아줍니다.
				if (num3 < 7) {
					btn[i].setBounds(72 + (num3 * 53), 440, 53, 90);
					lbZone.add(btn[i]);
				}
				num3++;
			}
//		27~34번 좌석생성			
			else {
				btn[i] = new JButton((i + 1) + "");
				btn[i].addActionListener(new seatButton(btn[i], i));

				// 버튼의 위치를 잡아줍니다.
				if (num4 < 8) {
					btn[i].setBounds(13 + (num4 * 53), 755, 53, 90);
					lbZone.add(btn[i]);
				}
				num4++;
			}
			btn[i].setContentAreaFilled(false);
			
			// db 파일에 저장한 seat 버튼을 가져옵니다.
			for (int j = 0; j < seat.size(); j++) {
				// db 번호와 좌석표 db와 같은경우 코드 실행
				
				if (btn[i].getText().equals(seat.get(j))) {
					// 바로사용의 시간에 데이터가 있는 경우 색상지정!
					System.out.println("btn[i]:" + btn[i].getText());
					System.out.println("seat:"+seat.get(j));
					System.out.println("time:" + time.get(j));
					if (time.get(j) != null) {
						btn[i].setBackground(new Color(000, 153, 102));
						btn[i].setContentAreaFilled(true);
//						파란색 102번 가져오기!
						if (btn[i].getBackground().getBlue() == 102) {
							JButton J = btn[i];
							btn[i].addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									payment p = new payment(J.getText() ,Main_swing.getFrame(), "seat");
									p.getFrame().setVisible(true);
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

											JOptionPane.showMessageDialog(null, "<HTML>" + "사용중인 자리입니다." + "<br>"
													+ start_t + "~" + end_t + "</HTML>");
										}
									}

								}
							});
						}
					}
					// 예약 시간에 데이터가 있는 경우 색상지정
//					else if (r_time.get(j) != null) {
//						System.out.println("예약시간:" + r_time.get(j));
//						try {
//							start = f.parse(r_time.get(j));
//							end = f.parse(rendTime.get(j));
//						} catch (ParseException e1) {
//							e1.printStackTrace();
//						}
//						// 예약 시간 한시간 전을 구하기 위한 calendar사용!
//						Calendar cal = Calendar.getInstance();
//						cal.setTime(start);
//						cal.add(Calendar.HOUR, -1);
//						System.out.println("cal:" + cal.getTime());
//						String r_start = fo.format(cal.getTime());
//						System.out.println("r_start:" + r_start);
//
//						Date dt_now = new Date();
//						String now = fo.format(dt_now);
//						System.out.println("now:" + now);
//
//						// 현재 시간과 db시간이 같으면 예약 색상으로 변경!
//						if (r_start.equals(now)) {
//							btn[i].setBackground(Color.yellow);
//							btn[i].setContentAreaFilled(true);
//							if (btn[i].getBackground().getBlue() == 0) {
//								JButton c = btn[i];
//								btn[i].addActionListener(new ActionListener() {
//
//									@Override
//									public void actionPerformed(ActionEvent e) {
//										// for문으로 데이터 가지고오기!
//										for (int k = 0; k < seat.size(); k++) {
//											if (c.getText().equals(seat.get(k))) {
//												try {
//													start = f.parse(rstartTime.get(k));
//													end = f.parse(rendTime.get(k));
//												} catch (ParseException e1) {
//													// TODO Auto-generated catch block
//													e1.printStackTrace();
//												}
//												String start_t = fo.format(start);
//												String end_t = fo.format(end);
//
//												JOptionPane.showMessageDialog(null, "<HTML>" + "예약 중인 자리입니다." + "<br>"
//														+ start_t + "~" + end_t + "</HTML>");
//											}
//										}
//
//									}
//
//								});
//							}
//						}
//					}

				}
			}

		}

	}
}
