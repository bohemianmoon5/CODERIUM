import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Locker_Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrame frame;

	public Locker_Frame(JFrame frame, JPanel panel) {
		frame.setBounds(0, 0, 685, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setLayout(new GridLayout(10, 5));
		panel.setBounds(0, 0, 685, 720);

		JButton[] bt = new JButton[50];

		for (int i = 0; i < bt.length; i++) {
			final int j = i; 
			bt[i] = new JButton((i + 1) + "번");
			bt[i].setFont(new Font("티웨이_항공", Font.BOLD, 15));
			panel.add(bt[i]);
			
			bt[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(bt[j].getBackground().getBlue()==102) {
						JOptionPane.showMessageDialog(null, "이미 예약된 자리입니다.");
					}else {
						bt[j].setBackground(new Color(000, 153, 102));
						JLabel used_lb_label = new JLabel("사용중");
						used_lb_label.setLayout(null);
//						used_lb_label.setBounds(13, 18, 55, 75);
						used_lb_label.setHorizontalAlignment(SwingConstants.CENTER);
						used_lb_label.setFont(new Font("티웨이_항공", Font.BOLD, 8));
						bt[j].add(used_lb_label);
					}
				}
			});
			}
		
		
			
		frame.setContentPane(panel);
		
	}
	
}
