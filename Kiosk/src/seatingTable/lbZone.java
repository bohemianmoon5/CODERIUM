package seatingTable;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class lbZone extends JPanel {
	int num2 = 0;
	int num3 = 0;
	int num4 = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public lbZone(JFrame frame) {
		setBounds(20, 130, 660, 870);
		setLayout(null);

		seatingImage seatImg = new seatingImage(new ImageIcon("./image/lb_zone_1.jpg").getImage());
		this.add(seatImg);
		this.setVisible(false);

	}

	void btn(JButton[] btn, JPanel lbZone) {
		for (int i = 0; i < btn.length; i++) {
			final int j = i;
			if (i < 12) {
				btn[i] = new JButton((i + 1) + "");

				btn[i].addActionListener(new seatButton(btn[i], i));

				// 버튼의 위치를 잡아줍니다.
				btn[i].setBounds(13 + (i * 53), 23, 53, 90);
				lbZone.add(btn[i]);
			}

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

		}
	}

	void btn2(JButton btn, JPanel lbZone) {

		// btn1에서 if문으로 배열로 해결하기

		btn.setBounds(13, 755, 53, 90);
		lbZone.add(btn);
	}
}
