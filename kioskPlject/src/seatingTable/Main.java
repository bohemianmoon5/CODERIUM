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
	
public class Main {
	public static String type = "";
	private static JFrame frame;
	
	public Main() {
		initialize();
	}
	
	public Main(String type) {
		this.type = type;
		initialize();
	}
	public Main(JFrame frame) {
		setFrame(frame);
		initialize();
	}
	
	private void initialize() {
		//++js modify
		if(type.equals("reserve")) {
			setFrame(new JFrame());
		}
		//++
		
		getFrame().setBounds(0, 0, 720, 1080);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//++js modify
		// 현재 팝업창만 종료됨
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//++
		
		System.out.println(type);
		mainPanel main_panel = new mainPanel();
//		JButton seatchange = new JButton("좌석변경");
//		main_panel.seatChange_btn(seatchange);
		main_panel.back_img();
		

		
		JButton lb_btn = new JButton("스터디존");
		JButton cf_btn = new JButton("카페존");
		JButton sr_btn = new JButton("스터디룸");
		
		JButton[] l_btn = new JButton[35];
		JButton[] c_btn = new JButton[16];
		JButton[] s_btn = new JButton[2];
		subPanel sub_panel = new subPanel(getFrame());
		
		
		sub_panel.cf_btn(cf_btn, sub_panel, getFrame(), c_btn);
		sub_panel.sr_btn(sr_btn, sub_panel, getFrame(), s_btn);
		sub_panel.lb_btn(lb_btn, sub_panel, getFrame(), l_btn);
		
		seatingImage seatImg = new seatingImage(new ImageIcon("./src/Image/seatting_table_1.jpg").getImage());
		sub_panel.add(seatImg);
		
		
		getFrame().getContentPane().add(sub_panel);
		getFrame().getContentPane().add(main_panel);	
	}
	public static JFrame getFrame() {
		return frame;
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
