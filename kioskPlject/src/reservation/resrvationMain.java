package reservation;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import main.pay.payment;
import main.pay.data.reservData;
import seatingTable.Main;

public class resrvationMain {

	JScrollPane scrollPane;
	ImageIcon icon;
	public static String seatnum = "좌석선택";
	public static JButton btn_seat;
	Component[] mainC;
	private static JFrame frame;

	//++js modify
	private JPanel mainReservation;
	//++
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					resrvationMain window = new resrvationMain();
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
	public resrvationMain() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("./src/Image/CODERIUM_Icon.png"));
		frame.getContentPane().setFont(new Font("티웨이_항공", Font.BOLD, 20));
		frame.setTitle("CODERIUM");
		frame.setBounds(100, 100, 720, 1080);
//		frame.setLocationRelativeTo(null);
//		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		icon = new ImageIcon("./src/Image/CODERIUM_Background.jpg");
		 
		
		
		setMainReserv(new JPanel() {
            public void paintComponent(Graphics g) {
                // Approach 1: Dispaly image at at full size
                g.drawImage(icon.getImage(), 0, 0, null);
                // Approach 2: Scale image to size of component
                // Dimension d = getSize();
                // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                // Approach 3: Fix the image position in the scroll pane
                // Point p = scrollPane.getViewport().getViewPosition();
                // g.drawImage(icon.getImage(), p.x, p.y, null);
                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
                super.paintComponent(g);
            }
        });
		getMainReserv().setBounds(0, 0, 714, 1051);
		frame.getContentPane().add(getMainReserv());
		getMainReserv().setLayout(null);
		
		JLabel LavelmainRe = new JLabel("예약");
		LavelmainRe.setHorizontalAlignment(SwingConstants.CENTER);
		LavelmainRe.setFont(new Font("티웨이_항공", Font.BOLD, 30));
		LavelmainRe.setBounds(0, 0, 714, 110);
		getMainReserv().add(LavelmainRe);
		
		// 새로운 예약 버튼
		JButton btn_newReservation = new JButton("새로운 예약");
		btn_newReservation.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_newReservation.setBounds(250, 190, 221, 54);
		btn_newReservation.setContentAreaFilled(false);
		btn_newReservation.setBorderPainted(false);
		btn_newReservation.setFocusPainted(false);
		btn_newReservation.setOpaque(false);
		getMainReserv().add(btn_newReservation);
		btn_newReservation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ++새로운 예약 버튼 구현
				// ++새로운 예약 버튼 클릭 시 현재 mainReservation 패널에 추가되어 있는 component들 지운 후 
				// createNew 함수 내 구현되어 있는 component들 add시킴!
				getMainReserv().removeAll();
				createNewRe(getMainReserv());
				// ++패널 repaint() 안하면 제대로 구현 안되므로 필요한 작업
				getMainReserv().repaint();
				
//				newReservation.setVisible(true);
//				mainReservation.setVisible(false);
//				checkReservation.setVisible(false);
//				cancelReservation.setVisible(false);
//				newReservation temp = new newReservation;
				
//				btn_pay.setvisible(false);  => 결제 버튼 비활성화 활성화 하고 싶은데 순서가 문제다 고민해보자,,,!
				
			}
		});
		
		
		
		// 예약 확인 버튼
		JButton btn_checkRe = new JButton("\uC608\uC57D \uD655\uC778");
		btn_checkRe.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_checkRe.setBounds(250, 470, 221, 54);
		btn_checkRe.setContentAreaFilled(false);
		btn_checkRe.setBorderPainted(false);
		btn_checkRe.setFocusPainted(false);
		getMainReserv().add(btn_checkRe);
		btn_checkRe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ++새로운 예약 버튼 구현
				// ++새로운 예약 버튼 클릭 시 현재 mainReservation 패널에 추가되어 있는 component들 지운 후 
				// createNew 함수 내 구현되어 있는 component들 add시킴!
				getMainReserv().removeAll();
				checkRe(getMainReserv());
				// ++패널 repaint() 안하면 제대로 구현 안되므로 필요한 작업
				getMainReserv().repaint();

			}
		});
		
		// 예약 취소 버튼
		JButton btn_cancelRe = new JButton("\uC608\uC57D \uCDE8\uC18C");
		btn_cancelRe.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_cancelRe.setBounds(250, 775, 221, 54);
		btn_cancelRe.setContentAreaFilled(false);
		btn_cancelRe.setBorderPainted(false);
		btn_cancelRe.setFocusPainted(false);
		getMainReserv().add(btn_cancelRe);
		//현재 예약 취소 패널로 옮기는 창 구현됨 => 예약 취소로 기존의 예약 회원 DB 좌석 DB 삭제 actionlistener 필요
		btn_cancelRe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ++새로운 예약 버튼 구현
				// ++새로운 예약 버튼 클릭 시 현재 mainReservation 패널에 추가되어 있는 component들 지운 후 
				// createNew 함수 내 구현되어 있는 component들 add시킴!
				getMainReserv().removeAll();
				cancelRe(getMainReserv());
				// ++패널 repaint() 안하면 제대로 구현 안되므로 필요한 작업
				getMainReserv().repaint();

			}
		});
		
		
		mainC = getMainReserv().getComponents();
		System.out.println("mainC count " + mainC.length);
		
		
		
	}
		
		
	public static JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.setType(Type.UTILITY);

	}
	
	
	public void createNewRe (JPanel panel) {
		
		icon = new ImageIcon("./src/Image/CODERIUM_Background.jpg");

		
		JPanel createNewRe = new JPanel() {
			public void paintComponent(Graphics g) {
            // Approach 1: Dispaly image at at full size
            g.drawImage(icon.getImage(), 0, 0, null);
            // Approach 2: Scale image to size of component
            // Dimension d = getSize();
            // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
            // Approach 3: Fix the image position in the scroll pane
            // Point p = scrollPane.getViewport().getViewPosition();
            // g.drawImage(icon.getImage(), p.x, p.y, null);
            setOpaque(false); //그림을 표시하게 설정,투명하게 조절
            super.paintComponent(g);
			}
		}; 
		createNewRe.setBounds(0, 0, 714, 1051);
		frame.getContentPane().add(createNewRe);
		createNewRe.setLayout(null);
		createNewRe.setVisible(false);
		
		
		JLabel LavelnewRe= new JLabel("새로운 예약");
		LavelnewRe.setHorizontalAlignment(SwingConstants.CENTER);
		LavelnewRe.setFont(new Font("티웨이_항공", Font.BOLD, 30));
		LavelnewRe.setBounds(0, 0, 714, 110);
		panel.add(LavelnewRe);
		
		JLabel date = new JLabel("날짜");
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setFont(new Font("티웨이_항공", Font.BOLD, 30));
		date.setBounds(10, 190, 200, 80);
		panel.add(date);
		
		selectDate selectDate = new selectDate(panel);
		selectDate.setBounds(150, 210, 500, 80);
		selectDate.setBackground(new Color (255,0,0,0));
		panel.setVisible(true);
		panel.add(selectDate);

		
		JLabel time = new JLabel("시간");
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setFont(new Font("티웨이_항공", Font.BOLD, 30));
		time.setBounds(10, 470, 200, 80);
		panel.add(time);
		
		selectMenu selectMenu = new selectMenu(panel);
		selectMenu.setBounds(160, 483, 400, 80);
		selectMenu.setBackground(new Color(255,0,0,0));
		panel.setVisible(true);
		panel.add(selectMenu);
		
		
		JLabel seat = new JLabel("좌석");
		seat.setHorizontalAlignment(SwingConstants.CENTER);
		seat.setFont(new Font("티웨이_항공", Font.BOLD, 30));
		seat.setBounds(10, 775, 200, 80);
		panel.add(seat);
		
		// 새로운 예약 => 좌석표 선택창 오픈 버튼 
		btn_seat = new JButton("좌석 선택");
		btn_seat.setFont(new Font("티웨이_항공", Font.BOLD, 25));
//		btn_seat.setBounds(250, 785, 221, 54);
		btn_seat.setBounds(250, 600, 221, 54);
		btn_seat.setBackground(new Color(255,0,0,0));
		btn_seat.setContentAreaFilled(false);
		btn_seat.setBorderPainted(false);
		btn_seat.setFocusPainted(false);
		btn_seat.setOpaque(false);
		panel.add(btn_seat);
		// 좌석표 창 오픈해야되는 actionlistener필요
		btn_seat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main seat = new Main("reserve");
				seat.getFrame().setVisible(true);

			}
		});
		 
		// 새로운 예약 => 결제 창으로 이동 버튼
		JButton btn_pay = new JButton("결제");
		btn_pay.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_pay.setBounds(558, 940, 158, 110);
		btn_pay.setContentAreaFilled(false);
		btn_pay.setBorderPainted(false);
//		btn_pay.setBorder(new LineBorder(Color.BLUE));
		btn_pay.setFocusPainted(false);
		btn_pay.setOpaque(false);

		panel.add(btn_pay);
		// 결제창으로 이동하는 actionlistener필요
		
		btn_pay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectDate.yearBox.getSelectedItem().toString();
				selectDate.monthBox.getSelectedItem().toString();
				selectDate.dayBox.getSelectedItem().toString();
				
				//++js modify
				String year=selectDate.yearBox.getSelectedItem().toString();
				String month=selectDate.monthBox.getSelectedItem().toString();
				String day=selectDate.dayBox.getSelectedItem().toString();
				String hour=selectDate.timelist.getSelectedItem().toString();
				String stdDate= year+"/"+month+"/"+day+"/"+hour+":00";
				reservData rd = new reservData();
				rd.modiProd(selectMenu.menuList.getSelectedItem().toString());
				String prodName=rd.getProd();
				String price=rd.getPrice();
				String seatN=btn_seat.getText();
				payment p = new payment(seatN.substring(0,seatN.length()-4),frame,"reserv",prodName,price,stdDate,panel);
				p.getFrame().setVisible(true);
				//++
			}
			
		});
		
		
		JButton btn_back = new JButton("\uB4A4\uB85C");
		btn_back.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_back.setBounds(558, 0, 158, 110);
		btn_back.setContentAreaFilled(false);
		btn_back.setBorderPainted(false);
		btn_back.setFocusPainted(false);
		panel.add(btn_back);
		btn_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// ++뒤로가기 버튼 구현
				// ++뒤로가기 클릭 시 현재 추가되어 있는 새로운 예약 구현 시 add했던 component들 지운 후 
				// 저장해놓은 mainC add시킴!
				panel.removeAll();
				for(int i=0; i<mainC.length;i++) {
					panel.add(mainC[i]);
				}
				// ++패널 repaint() 안하면 제대로 구현 안되므로 필요한 작업
				panel.repaint();
			}
		});
		
	}
	
	

	public void checkRe (JPanel panel) {
		JPanel checkRe = new JPanel() {
			public void paintComponent(Graphics g) {
            // Approach 1: Dispaly image at at full size
            g.drawImage(icon.getImage(), 0, 0, null);
            // Approach 2: Scale image to size of component
            // Dimension d = getSize();
            // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
            // Approach 3: Fix the image position in the scroll pane
            // Point p = scrollPane.getViewport().getViewPosition();
            // g.drawImage(icon.getImage(), p.x, p.y, null);
            setOpaque(false); //그림을 표시하게 설정,투명하게 조절
            super.paintComponent(g);
			}
		}; 
		checkRe.setBounds(0, 0, 714, 1051);
		frame.getContentPane().add(checkRe);
		checkRe.setLayout(null);
		checkRe.setVisible(false);
		
		JPanel selectRe = new selectRe(panel);
		selectRe.setBounds(230, 300, 500, 600);
		selectRe.setBackground(new Color(255,0,0,0));
		selectRe.setOpaque(false);
		panel.setVisible(true);
		panel.add(selectRe);
		
		
		JLabel LavelcheckRe = new JLabel("예약 확인");
		LavelcheckRe.setHorizontalAlignment(SwingConstants.CENTER);
		LavelcheckRe.setFont(new Font("티웨이_항공", Font.BOLD, 30));
		LavelcheckRe.setBounds(0, 0, 714, 110);
		panel.add(LavelcheckRe);
		
		
		
		// 예약 확인 => 입실 버튼 활성화
		JButton btn_checkIn = new JButton("입실");
		btn_checkIn.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_checkIn.setBounds(558, 940, 158, 110);
		btn_checkIn.setContentAreaFilled(false);
		btn_checkIn.setBorderPainted(false);
		btn_checkIn.setFocusPainted(false);
		btn_checkIn.setOpaque(false);
		panel.add(btn_checkIn);
		// 입실하는 actionlistener필요 => 좌석표 시간 활성화 및 예약 데이터 삭제? => 실시간 좌석 데이터로 전환? 가능?? 
		btn_checkIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});	
		
		JButton btn_back = new JButton("\uB4A4\uB85C");
		btn_back.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_back.setBounds(558, 0, 158, 110);
		
		btn_back.setContentAreaFilled(false);
		btn_back.setBorderPainted(false);
		btn_back.setFocusPainted(false);
		panel.add(btn_back);
		btn_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				mainReservation.setVisible(true);
//				newReservation.setVisible(false);
//				checkReservation.setVisible(false);
//				cancelReservation.setVisible(false);
				
				// ++뒤로가기 버튼 구현
				// ++뒤로가기 클릭 시 현재 추가되어 있는 새로운 예약 구현 시 add했던 component들 지운 후 
				// 저장해놓은 mainC add시킴!
				panel.removeAll();
				for(int i=0; i<mainC.length;i++) {
					panel.add(mainC[i]);
				}
				// ++패널 repaint() 안하면 제대로 구현 안되므로 필요한 작업
				panel.repaint();
			}
		});
		
	}
	
	public void cancelRe (JPanel panel) {
		JPanel cancelRe = new JPanel() {
			public void paintComponent(Graphics g) {
            // Approach 1: Dispaly image at at full size
            g.drawImage(icon.getImage(), 0, 0, null);
            // Approach 2: Scale image to size of component
            // Dimension d = getSize();
            // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
            // Approach 3: Fix the image position in the scroll pane
            // Point p = scrollPane.getViewport().getViewPosition();
            // g.drawImage(icon.getImage(), p.x, p.y, null);
            setOpaque(false); //그림을 표시하게 설정,투명하게 조절
            super.paintComponent(g);
			}
		}; 
		cancelRe.setBounds(0, 0, 714, 1051);
		frame.getContentPane().add(cancelRe);
		cancelRe.setLayout(null);
		cancelRe.setVisible(false);
		
		JLabel LavelcancelRe = new JLabel("예약 취소");
		LavelcancelRe.setHorizontalAlignment(SwingConstants.CENTER);
		LavelcancelRe.setFont(new Font("티웨이_항공", Font.BOLD, 30));
		LavelcancelRe.setBounds(0, 0, 714, 110);
		panel.add(LavelcancelRe);
		
		JPanel selectCanceRe = new selectCanceRe(panel);
		selectCanceRe.setBounds(230, 300, 500, 600);
		selectCanceRe.setBackground(new Color(255,0,0,0));
		selectCanceRe.setOpaque(false);
		panel.setVisible(true);
		panel.add(selectCanceRe);
		
		// 선택한 예약 데이터 예약 취소 버튼
		JButton btn_reCancel = new JButton("예약 취소");
		btn_reCancel.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_reCancel.setBounds(558, 940, 158, 110);
		btn_reCancel.setContentAreaFilled(false);
		btn_reCancel.setBorderPainted(false);
		btn_reCancel.setFocusPainted(false);
		btn_reCancel.setOpaque(false);
		panel.add(btn_reCancel);
		// 선택한 예약 데이터 예약 취소 
		btn_reCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});		
		
		JButton btn_back = new JButton("\uB4A4\uB85C");
		btn_back.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_back.setBounds(558, 0, 158, 110);
		btn_back.setContentAreaFilled(false);
		btn_back.setBorderPainted(false);
		btn_back.setFocusPainted(false);
		panel.add(btn_back);
		btn_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				mainReservation.setVisible(true);
//				newReservation.setVisible(false);
//				checkReservation.setVisible(false);
//				cancelReservation.setVisible(false);
				
				// ++뒤로가기 버튼 구현
				// ++뒤로가기 클릭 시 현재 추가되어 있는 새로운 예약 구현 시 add했던 component들 지운 후 
				// 저장해놓은 mainC add시킴!
				panel.removeAll();
				for(int i=0; i<mainC.length;i++) {
					panel.add(mainC[i]);
				}
				// ++패널 repaint() 안하면 제대로 구현 안되므로 필요한 작업
				panel.repaint();
			}
		});
	}

	public JPanel getMainReserv() {
		return mainReservation;
	}

	public void setMainReserv(JPanel mainReservation) {
		this.mainReservation = mainReservation;
	}
}
