package seatingTable;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class lbZone extends JPanel {
	int num2 = 0;
	int num3 = 0;
	int num4 = 0;
	ArrayList<Integer> seat = new ArrayList<Integer>();
//	db 불러오기.!
	Dbfile db = new Dbfile("reservation_db.txt");
	Date dt = new Date();
	SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.KOREA);
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
//		예약된 좌석들 채우기/ 시간까진 미구현!			

			String time1 = format.format(dt);
			System.out.println(time1);
			for (int j = 1; j < db.arr.size(); j++) {
				seat.add(Integer.parseInt(db.arr.get(j).split(",")[4]));
				System.out.println("seatnum:"+seat.get(j-1));
				if (i == seat.get(j-1)) {
					System.out.println("seatnum:" + i);
					btn[i-1].setText(null);
					btn[i - 1].setBackground(Color.yellow);
					btn[i - 1].setContentAreaFilled(true);
					JLabel used_lb_label = new JLabel("<HTML>" + (i+1) + "번" + "<br>" + time1  + "</HTML>");
					used_lb_label.setLayout(null);
					used_lb_label.setHorizontalAlignment(SwingConstants.LEFT);
					used_lb_label.setFont(new Font("티웨이_항공", Font.BOLD, 10));
					used_lb_label.setSize(53, 90);
					btn[i-1].add(used_lb_label);
				}else {
					System.out.println("같지않아!");
				}
			}

		}
	}

}
