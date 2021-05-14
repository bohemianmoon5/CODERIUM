package main.pay;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class cash {
	JPanel panel;
	String font = "";
	int x = 85;
	int y;
	int width=120;
	int height = 60;

	public cash() {

	}

	public cash(JPanel panel, int y, String font) {
		this.panel = panel;
		this.y = y;
		this.font = font;
	}

	// cash �г� list ���� 
	public void makeCashTF(String str,int i) {
		JLabel tf = new JLabel(str);
		tf.setFont(new Font(font, Font.PLAIN, 18));
		tf.setBounds(x, y+(70*i), width, height);
		panel.add(tf);
	}

	// cash �г� list�� detail ����
	public JLabel makeCashD(String str,int i) {
		JLabel tf = new JLabel(str);
		tf.setFont(new Font(font, Font.PLAIN, 18));
		tf.setBounds(x+110, y+(70*i), width+160, height);
		panel.add(tf);
		return tf;
	}
	
	// cash �г� button ����
	public JButton makeCashB(String str, int i, int j) {
		JButton cashBtn = new JButton(str);
		cashBtn.setFont(new Font(font, Font.PLAIN, 18));
		cashBtn.setBounds(88+(290*i), y+(100*j), 198, 57);
		panel.add(cashBtn);
		return cashBtn;
	}

}
