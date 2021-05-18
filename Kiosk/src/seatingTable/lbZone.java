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
//	db �ҷ�����.!
	Dbfile db = new Dbfile("reservation_db.txt");
	Date dt = new Date();
	SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.KOREA);
	/**
	 * ���͵��� �¼�ǥ ����!
	 */
	private static final long serialVersionUID = 1L;

	// ���͵��� JPanel ����
	public lbZone(JFrame frame) {
		setBounds(20, 130, 660, 870);
		setLayout(null);
		this.setVisible(false);

	}

	// �¼�ǥ ��ư ����
	void btn(JButton[] btn, JPanel lbZone) {

//		1~12���¼� ��ȣ ����
		for (int i = 0; i < btn.length; i++) {
			if (i < 12) {
				btn[i] = new JButton((i + 1) + "");

				btn[i].addActionListener(new seatButton(btn[i], i));

				// ��ư�� ��ġ�� ����ݴϴ�.
				btn[i].setBounds(13 + (i * 53), 23, 53, 90);
				lbZone.add(btn[i]);
			}
//		13~19���¼� ����	
			else if (i < 19) {
				btn[i] = new JButton((i + 1) + "");
				btn[i].addActionListener(new seatButton(btn[i], i));

				// ��ư�� ��ġ�� ����ݴϴ�.
				if (num2 < 7) {
					btn[i].setBounds(72 + (num2 * 53), 348, 53, 90);
					lbZone.add(btn[i]);
				}
				num2++;

			}
//		20~26�� �¼� ����
			else if (i < 26) {

				btn[i] = new JButton((i + 1) + "");
				btn[i].addActionListener(new seatButton(btn[i], i));

				// ��ư�� ��ġ�� ����ݴϴ�.
				if (num3 < 7) {
					btn[i].setBounds(72 + (num3 * 53), 440, 53, 90);
					lbZone.add(btn[i]);
				}
				num3++;
			}
//		27~34�� �¼�����			
			else {
				btn[i] = new JButton((i + 1) + "");
				btn[i].addActionListener(new seatButton(btn[i], i));

				// ��ư�� ��ġ�� ����ݴϴ�.
				if (num4 < 8) {
					btn[i].setBounds(13 + (num4 * 53), 755, 53, 90);
					lbZone.add(btn[i]);
				}
				num4++;
			}
			btn[i].setContentAreaFilled(false);
//		����� �¼��� ä���/ �ð����� �̱���!			

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
					JLabel used_lb_label = new JLabel("<HTML>" + (i+1) + "��" + "<br>" + time1  + "</HTML>");
					used_lb_label.setLayout(null);
					used_lb_label.setHorizontalAlignment(SwingConstants.LEFT);
					used_lb_label.setFont(new Font("Ƽ����_�װ�", Font.BOLD, 10));
					used_lb_label.setSize(53, 90);
					btn[i-1].add(used_lb_label);
				}else {
					System.out.println("�����ʾ�!");
				}
			}

		}
	}

}
