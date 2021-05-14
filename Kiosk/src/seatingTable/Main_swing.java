package seatingTable;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;

public class Main_swing {

	private JFrame frame;
//	private JButton btn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_swing window = new Main_swing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_swing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 720, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		mainPanel main_panel = new mainPanel(frame);
		
//		panel.main_btn(btn);
		
		JButton lb_btn = new JButton("스터디존");
		JButton cf_btn = new JButton("카페존");
		JButton sr_btn = new JButton("스터디룸");
		JButton[] l_btn = new JButton[35];
		JButton[] c_btn = new JButton[16];
		JButton[] s_btn = new JButton[2];
		subPanel sub_panel = new subPanel(frame);
		
		
		sub_panel.cf_btn(cf_btn, sub_panel, frame, c_btn);
		sub_panel.sr_btn(sr_btn, sub_panel, frame, s_btn);
		sub_panel.lb_btn(lb_btn, sub_panel, frame, l_btn);
		
		seatingImage seatImg = new seatingImage(new ImageIcon("./image/seatting_table_1.jpg").getImage());
		sub_panel.add(seatImg);
		
		frame.getContentPane().add(main_panel);
		
	}
}
