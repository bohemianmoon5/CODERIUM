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


public class mainPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public mainPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setBounds(0, 0, 700, 1080);
//		jframe.getContentPane().add(this);

		
	}

	
	void seatChange_btn(JButton btn) {
		btn.setBackground(new Color(0, 191, 255));
		btn.setFont(new Font("티웨이_항공", Font.BOLD, 15));
		btn.setBounds(500, 25, 165, 65);
		btn.setVisible(true);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(true);
		btn.setFocusPainted(false);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result = JOptionPane.showConfirmDialog(null, "자리를 변경하시겠습니까?", "confirm", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					Dbfile db = new Dbfile();
					db.dml("update payment set seatNum = null where id = 'wonho33';");
					System.out.println("좌석이 초기화 되었습니다.!");
					mainPanel main = new mainPanel();
					main.back_img();

				}
				
			}
		});
		this.add(btn);
		
	}
	
	void back_img() {
		seatingImage home_img = new seatingImage(new ImageIcon("./src/image/home_background.png").getImage());
		this.add(home_img);
	}
}