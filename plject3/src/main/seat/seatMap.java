package main.seat;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.pay.payment;

public class seatMap {

	private static JFrame frame;
	private static String seatNum="";
	private static JPanel seatPanel;
	private JButton seat24;
	payment p;
	private JPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seatMap window = new seatMap();
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
	public seatMap() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 0, 720, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		seatPan();
	}
	
	public static JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public static String getSeatInfo() {
		return seatNum;
	}

	public void setSeatInfo(String seatNum) {
		this.seatNum = seatNum;
	}
	
	public void seatPan() {
		setSeatPanel(new JPanel());
		getSeatPanel().setBounds(12, 43, 680, 870);
		frame.getContentPane().add(getSeatPanel());
		getSeatPanel().setLayout(null);
		
		seat24 = new JButton("24");
		seat24.setBounds(30, 373, 95, 70);
		getSeatPanel().add(seat24);
		
		//좌석을 선택하고 나면, 좌석 패널은 visible=false 한 후 결제/예약 패널로 넘어간다
		seat24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSeatInfo(e.getActionCommand());
				EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						p = new payment();
						p.getFrame().setVisible(true);
						payment.setInfo(getSeatInfo());

						// seatPanel에 있는 자식 컴포넌트 저장 후 payment로 넘김
						// c에 저장 시 결제창이 열리므로 버튼 비활성화 하기
						Component[] c = new Component[getSeatPanel().getComponentCount()];
						c=getSeatPanel().getComponents();
						for(int i=0; i<getSeatPanel().getComponentCount();i++) {
							c[i].setEnabled(false);
						}
						payment.setSeatCom(c);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			}
		});
		seat24.setFont(new Font("12롯데마트드림Bold", Font.PLAIN, 18));
		
		panel = new JPanel();
		panel.setBounds(12, 10, 680, 941);
		frame.getContentPane().add(panel);
//		chkPayEnable();
	}

	public void payPanel() {
		
	}

	public static JPanel getSeatPanel() {
		return seatPanel;
	}

	public void setSeatPanel(JPanel seatPanel) {
		this.seatPanel = seatPanel;
	}
}
