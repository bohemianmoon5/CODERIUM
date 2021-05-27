package seatingTable;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.pay.data.db;


public class mainPanel extends JPanel{
	JButton back = new JButton(new ImageIcon("./src/image/back_btn.png"));
	JButton home = new JButton(new ImageIcon("./src/image/home_btn.png"));
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public mainPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setBounds(0, 0, 700, 1080);
		
		back.setBounds(600, 50, 50, 50);
		home.setBounds(500, 50, 50, 50);
		
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setFocusPainted(false);
		
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.setFocusPainted(false);
		
		this.add(back);
		this.add(home);
		
	}

/*	
	void seatChange_btn(JButton btn) {
		btn.setBackground(new Color(0, 191, 255));
		btn.setFont(new Font("Ƽ����_�װ�", Font.BOLD, 15));
		btn.setBounds(500, 25, 165, 65);
		btn.setVisible(true);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(true);
		btn.setFocusPainted(false);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result = JOptionPane.showConfirmDialog(null, "�ڸ��� �����Ͻðڽ��ϱ�?", "confirm", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					db d = new db();
					d.dml("update paydata set seatNum = null where id = 'wonho33';");
					System.out.println("�¼��� �ʱ�ȭ �Ǿ����ϴ�.!");
					
				}
				
			}
		});
		this.add(btn);
		
	}
*/
	public void back_img() {
		seatingImage home_img = new seatingImage(new ImageIcon("./src/Image/home_background.png").getImage());
		this.add(home_img);
	}
}
