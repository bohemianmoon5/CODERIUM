package main.pay;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class confirm {
	JPanel panel;
	JLabel list;
	JLabel detail;

	int x = 12;
	int y;
	int width = 150;
	int height = 30;

	String font;

	public confirm() {

	}

	public confirm(JPanel panel, int y, String font) {
		this.panel = panel;
		this.y = y;
		this.font = font;
	}

	public void createTitle(String str) {
		JLabel title = new JLabel(str);
		title.setBounds(x, y, width, height);
		panel.add(title);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font(font, Font.BOLD, 18));
	}

	public void createList(String str, int i) {
		JLabel list = new JLabel(str);
		list.setBounds(x, y + (40 * i), width, height);
		panel.add(list);
		list.setHorizontalAlignment(SwingConstants.CENTER);
		list.setFont(new Font(font, Font.PLAIN, 18));
	}

	public void createDetail(String str, int i) {
		JLabel detail = new JLabel(str);
		detail.setBounds(x + 130, y + (40 * i), width - 70, height);
		panel.add(detail);
		detail.setHorizontalAlignment(SwingConstants.CENTER);
		detail.setFont(new Font(font, Font.PLAIN, 18));
	}

}
