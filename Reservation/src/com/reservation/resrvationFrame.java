package com.reservation;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDayChooser;

public class resrvationFrame {

	JScrollPane scrollPane;
	ImageIcon icon;
	// ++예약 패널 메인 컴포넌트
	// ++뒤로가기 시 필요함
	Component[] mainC;
	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					resrvationFrame window = new resrvationFrame();
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
	public resrvationFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\choim\\Desktop\\CODERIUM_Project\\CODERIUM_Icon.png"));
		frame.getContentPane().setFont(new Font("티웨이_항공", Font.BOLD, 20));
		frame.setTitle("CODERIUM");
		frame.setBounds(100, 0, 720, 1080);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		icon = new ImageIcon("C:\\Users\\choim\\Desktop\\CODERIUM_Project\\CODERIUM_Background.jpg");
		 
		
		// ++예약 메인 패널 생성
		JPanel mainReservation = new JPanel() {
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
		mainReservation.setBounds(0, 0, 714, 1051);
		frame.getContentPane().add(mainReservation);
		mainReservation.setLayout(null);
		
		// ++새로운 예약 패널 생성
//		JPanel newReservation = new JPanel() {
//			public void paintComponent(Graphics g) {
//            // Approach 1: Dispaly image at at full size
//            g.drawImage(icon.getImage(), 0, 0, null);
//            // Approach 2: Scale image to size of component
//            // Dimension d = getSize();
//            // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
//            // Approach 3: Fix the image position in the scroll pane
//            // Point p = scrollPane.getViewport().getViewPosition();
//            // g.drawImage(icon.getImage(), p.x, p.y, null);
//            setOpaque(false); //그림을 표시하게 설정,투명하게 조절
//            super.paintComponent(g);
//			}
//		}; 
//	    newReservation.setBounds(0, 0, 714, 1051);
//		frame.getContentPane().add(newReservation);
//		newReservation.setLayout(null);
//		newReservation.setVisible(false);
		
		// ++새로운 예약 확인 패널 생성
		JPanel checkReservation = new JPanel() {
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
		checkReservation.setBounds(0, 0, 714, 1051);
		frame.getContentPane().add(checkReservation);
		checkReservation.setLayout(null);
		checkReservation.setVisible(false);
		
		// ++새로운 예약 취소 패널 생성
		JPanel cancelReservation = new JPanel() {
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
		cancelReservation.setBounds(0, 0, 714, 1051);
		frame.getContentPane().add(cancelReservation);
		cancelReservation.setLayout(null);
		cancelReservation.setVisible(false);
		
		
		// ++메인 패널 component 1
		JLabel LavelmainReservation = new JLabel("예약");
		LavelmainReservation.setHorizontalAlignment(SwingConstants.CENTER);
		LavelmainReservation.setFont(new Font("티웨이_항공", Font.BOLD, 30));
		LavelmainReservation.setBounds(0, 0, 714, 110);
		mainReservation.add(LavelmainReservation);
		
		// 새로운 예약 버튼
		// ++main 패널 component 2
		JButton btn_newReservation = new JButton("새로운 예약");
		btn_newReservation.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_newReservation.setBounds(250, 190, 221, 54);
		btn_newReservation.setContentAreaFilled(false);
		btn_newReservation.setBorderPainted(false);
		btn_newReservation.setFocusPainted(false);
		btn_newReservation.setOpaque(false);
		mainReservation.add(btn_newReservation);
		btn_newReservation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ++새로운 예약 버튼 구현
				// ++새로운 예약 버튼 클릭 시 현재 mainReservation 패널에 추가되어 있는 component들 지운 후 
				// createNew 함수 내 구현되어 있는 component들 add시킴!
				mainReservation.removeAll();
				createNew(mainReservation);
				// ++패널 repaint() 안하면 제대로 구현 안되므로 필요한 작업
				mainReservation.repaint();
				
//				newReservation.setVisible(true);
//				mainReservation.setVisible(false);
//				checkReservation.setVisible(false);
//				cancelReservation.setVisible(false);
//				newReservation temp = new newReservation;
				
//				btn_pay.setvisible(false);  => 결제 버튼 비활성화 활성화 하고 싶은데 순서가 문제다 고민해보자,,,!
				
			}
		});
		
		// 예약 확인 버튼
		// ++main 패널 component 3
		JButton btn_checkReservation = new JButton("\uC608\uC57D \uD655\uC778");
		btn_checkReservation.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_checkReservation.setBounds(250, 470, 221, 54);
		btn_checkReservation.setContentAreaFilled(false);
		btn_checkReservation.setBorderPainted(false);
		btn_checkReservation.setFocusPainted(false);
		mainReservation.add(btn_checkReservation);
		btn_checkReservation.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				checkReservation.setVisible(true);
				mainReservation.setVisible(false);
//				newReservation.setVisible(false);
				cancelReservation.setVisible(false);
			}
		});
		
		// 예약 취소 버튼
		// ++main 패널 component 4
		JButton btn_cancelReservation = new JButton("\uC608\uC57D \uCDE8\uC18C");
		btn_cancelReservation.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_cancelReservation.setBounds(250, 775, 221, 54);
		btn_cancelReservation.setContentAreaFilled(false);
		btn_cancelReservation.setBorderPainted(false);
		btn_cancelReservation.setFocusPainted(false);
		mainReservation.add(btn_cancelReservation);
		//현재 예약 취소 패널로 옮기는 창 구현됨 => 예약 취소로 기존의 예약 회원 DB 좌석 DB 삭제 actionlistener 필요
		btn_cancelReservation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				checkReservation.setVisible(false);
				mainReservation.setVisible(false);
//				newReservation.setVisible(false);
				cancelReservation.setVisible(true);

			}
		});
		

		// ++main 컴포넌트 mainC에 저장
		mainC = mainReservation.getComponents();
//		System.out.println("mainC count " + mainC.length);

		
//		// ++새로운 예약 패널 component 1
////		JLabel LavelnewReservation = new JLabel("새로운 예약");
////		LavelnewReservation.setHorizontalAlignment(SwingConstants.CENTER);
////		LavelnewReservation.setFont(new Font("티웨이_항공", Font.BOLD, 30));
////		LavelnewReservation.setBounds(0, 0, 714, 110);
////		newReservation.add(LavelnewReservation);
//		JLabel LavelnewReservation = new JLabel("새로운 예약");
//		LavelnewReservation.setHorizontalAlignment(SwingConstants.CENTER);
//		LavelnewReservation.setFont(new Font("티웨이_항공", Font.BOLD, 30));
//		LavelnewReservation.setBounds(0, 0, 714, 110);
//		mainReservation.add(LavelnewReservation);
//		
//		// ++새로운 예약 패널 component 2
////		JLabel date = new JLabel("날짜");
////		date.setHorizontalAlignment(SwingConstants.CENTER);
////		date.setFont(new Font("티웨이_항공", Font.BOLD, 30));
////		date.setBounds(10, 190, 200, 80);
////		newReservation.add(date);
//
//		JLabel date = new JLabel("날짜");
//		date.setHorizontalAlignment(SwingConstants.CENTER);
//		date.setFont(new Font("티웨이_항공", Font.BOLD, 30));
//		date.setBounds(10, 190, 200, 80);
//		mainReservation.add(date);
//
//		// ++새로운 예약 패널 component 3
////		JLabel time = new JLabel("시간");
////		time.setHorizontalAlignment(SwingConstants.CENTER);
////		time.setFont(new Font("티웨이_항공", Font.BOLD, 30));
////		time.setBounds(10, 470, 200, 80);
////		newReservation.add(time);
//
//		JLabel time = new JLabel("시간");
//		time.setHorizontalAlignment(SwingConstants.CENTER);
//		time.setFont(new Font("티웨이_항공", Font.BOLD, 30));
//		time.setBounds(10, 470, 200, 80);
//		mainReservation.add(time);
//
//		// ++새로운 예약 패널 component 4
////		JLabel seat = new JLabel("좌석");
////		seat.setHorizontalAlignment(SwingConstants.CENTER);
////		seat.setFont(new Font("티웨이_항공", Font.BOLD, 30));
////		seat.setBounds(10, 775, 200, 80);
////		newReservation.add(seat);
//
//		JLabel seat = new JLabel("좌석");
//		seat.setHorizontalAlignment(SwingConstants.CENTER);
//		seat.setFont(new Font("티웨이_항공", Font.BOLD, 30));
//		seat.setBounds(10, 775, 200, 80);
//		mainReservation.add(seat);
//		
//		// 새로운 예약 => 좌석표 선택창 오픈 버튼
//		// ++새로운 예약 패널 component 5 
////		JButton btn_seat = new JButton("좌석 선택");
////		btn_seat.setFont(new Font("티웨이_항공", Font.BOLD, 25));
////		btn_seat.setBounds(250, 785, 221, 54);
////		btn_seat.setContentAreaFilled(false);
////		btn_seat.setBorderPainted(false);
////		btn_seat.setFocusPainted(false);
////		btn_seat.setOpaque(false);
////		newReservation.add(btn_seat);
////		// 좌석표 창 오픈해야되는 actionlistener필요
////		btn_seat.addActionListener(new ActionListener() {
////			@Override
////			public void actionPerformed(ActionEvent e) {
////			}
////		});
//
//		JButton btn_seat = new JButton("좌석 선택");
//		btn_seat.setFont(new Font("티웨이_항공", Font.BOLD, 25));
//		btn_seat.setBounds(250, 785, 221, 54);
//		btn_seat.setContentAreaFilled(false);
//		btn_seat.setBorderPainted(false);
//		btn_seat.setFocusPainted(false);
//		btn_seat.setOpaque(false);
//		mainReservation.add(btn_seat);
//		// 좌석표 창 오픈해야되는 actionlistener필요
//		btn_seat.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		
//		// 새로운 예약 => 결제 창으로 이동 버튼
//		// ++새로운 예약 패널 component 6
////		JButton btn_pay = new JButton("결제");
////		btn_pay.setFont(new Font("티웨이_항공", Font.BOLD, 25));
////		btn_pay.setBounds(558, 940, 158, 110);
////		btn_pay.setContentAreaFilled(false);
////		btn_pay.setBorderPainted(false);
////		btn_pay.setFocusPainted(false);
////		btn_pay.setOpaque(false);
////		newReservation.add(btn_pay);
////		// 결제창으로 이동하는 actionlistener필요
////		btn_seat.addActionListener(new ActionListener() {		
////			@Override
////			public void actionPerformed(ActionEvent e) {
////
////			}
////		});
//
//		JButton btn_pay = new JButton("결제");
//		btn_pay.setFont(new Font("티웨이_항공", Font.BOLD, 25));
//		btn_pay.setBounds(558, 940, 158, 110);
//		btn_pay.setContentAreaFilled(false);
//		btn_pay.setBorderPainted(false);
//		btn_pay.setFocusPainted(false);
//		btn_pay.setOpaque(false);
//		mainReservation.add(btn_pay);
//		// 결제창으로 이동하는 actionlistener필요
//		btn_seat.addActionListener(new ActionListener() {		
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
//		
//		//새로운 예약 창에서 예약 홈으로 이동
//		// ++새로운 예약 패널 component 7
////		JButton btn_back = new JButton("\uB4A4\uB85C");
////		btn_back.setFont(new Font("티웨이_항공", Font.BOLD, 25));
////		btn_back.setBounds(558, 0, 158, 110);
////		btn_back.setContentAreaFilled(false);
////		btn_back.setBorderPainted(false);
////		btn_back.setFocusPainted(false);
////		newReservation.add(btn_back);
////		btn_back.addActionListener(new ActionListener() {
////			@Override
////			public void actionPerformed(ActionEvent e) {
////				mainReservation.setVisible(true);
////				newReservation.setVisible(false);
////				checkReservation.setVisible(false);
////				cancelReservation.setVisible(false);
////			}
////			
////		});
//
//		JButton btn_back = new JButton("\uB4A4\uB85C");
//		btn_back.setFont(new Font("티웨이_항공", Font.BOLD, 25));
//		btn_back.setBounds(558, 0, 158, 110);
//		btn_back.setContentAreaFilled(false);
//		btn_back.setBorderPainted(false);
//		btn_back.setFocusPainted(false);
//		mainReservation.add(btn_back);
//		btn_back.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				mainReservation.setVisible(true);
//				newReservation.setVisible(false);
//				checkReservation.setVisible(false);
//				cancelReservation.setVisible(false);
//			}
//			
//		});
		
		// ++예약 확인 component 1
		JLabel LavelcheckReservation = new JLabel("예약 확인");
		LavelcheckReservation.setHorizontalAlignment(SwingConstants.CENTER);
		LavelcheckReservation.setFont(new Font("티웨이_항공", Font.BOLD, 30));
		LavelcheckReservation.setBounds(0, 0, 714, 110);
		checkReservation.add(LavelcheckReservation);
		
		// ++예약 확인 패널 component 2
		// 예약 확인 => 입실 버튼 활성화
		JButton btn_checkIn = new JButton("입실");
		btn_checkIn.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_checkIn.setBounds(558, 940, 158, 110);
		btn_checkIn.setContentAreaFilled(false);
		btn_checkIn.setBorderPainted(false);
		btn_checkIn.setFocusPainted(false);
		btn_checkIn.setOpaque(false);
		checkReservation.add(btn_checkIn);
		// 입실하는 actionlistener필요 => 좌석표 시간 활성화 및 예약 데이터 삭제? => 실시간 좌석 데이터로 전환? 가능?? 
		btn_checkIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});		
		
		//예약 확인 창에서 예약 홈으로 이동
		// ++예약 확인 패널 component 3
		JButton btn_back1 = new JButton("\uB4A4\uB85C");
		btn_back1.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_back1.setBounds(558, 0, 158, 110);
		btn_back1.setContentAreaFilled(false);
		btn_back1.setBorderPainted(false);
		btn_back1.setFocusPainted(false);
		checkReservation.add(btn_back1);
		btn_back1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainReservation.setVisible(true);
//				newReservation.setVisible(false);
				checkReservation.setVisible(false);
				cancelReservation.setVisible(false);
				
			}
			
		});
		
		// ++예약 취소 component 1
		JLabel LavelcancelReservation = new JLabel("예약 취소");
		LavelcancelReservation.setHorizontalAlignment(SwingConstants.CENTER);
		LavelcancelReservation.setFont(new Font("티웨이_항공", Font.BOLD, 30));
		LavelcancelReservation.setBounds(0, 0, 714, 110);
		cancelReservation.add(LavelcancelReservation);
		
		// ++예약 취소 패널에 생성되는 component들
		// ++예약 취소 패널 component 2
		// 선택한 예약 데이터 예약 취소 버튼
		JButton btn_reservationCancel = new JButton("예약 취소");
		btn_reservationCancel.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_reservationCancel.setBounds(558, 940, 158, 110);
		btn_reservationCancel.setContentAreaFilled(false);
		btn_reservationCancel.setBorderPainted(false);
		btn_reservationCancel.setFocusPainted(false);
		btn_reservationCancel.setOpaque(false);
		cancelReservation.add(btn_reservationCancel);
		// 선택한 예약 데이터 예약 취소 
		btn_reservationCancel.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});		
		
		//예약 취소 창에서 예약 홈으로 이동
		// ++예약 취소 패널 component 3
		JButton btn_back2 = new JButton("\uB4A4\uB85C");
		btn_back2.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_back2.setBounds(558, 0, 158, 110);
		btn_back2.setContentAreaFilled(false);
		btn_back2.setBorderPainted(false);
		btn_back2.setFocusPainted(false);
		cancelReservation.add(btn_back2);
		btn_back2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainReservation.setVisible(true);
//				newReservation.setVisible(false);
				checkReservation.setVisible(false);
				cancelReservation.setVisible(false);
				
			}
			
		});

		
//		// ++new 컴포넌트 mainC에 저장
//		newC = newReservation.getComponents();
//		System.out.println("newC count " + newC.length);
		
		
//		for(int i=0; i<mainReservation.getComponentCount(); i++) {			
//			System.out.println("main component " +i+ " "+ mainReservation.getComponent(i));
//		}

//		for(int i=0; i<newReservation.getComponentCount(); i++) {			
//			System.out.println("new component " +i+ " "+ newReservation.getComponent(i));
//		}
		
//		for(int i=0; i<checkReservation.getComponentCount(); i++) {			
//			System.out.println("check component " +i+ " "+ checkReservation.getComponent(i));
//		}
//		for(int i=0; i<cancelReservation.getComponentCount(); i++) {			
//			System.out.println("cancel component " +i+ " "+ cancelReservation.getComponent(i));
//		}
//		for(int i=0; i<frame.getContentPane().getComponentCount(); i++) {			
//			System.out.println("frame getContent component " +i+ " "+ frame.getContentPane().getComponent(i));
//		}
		
	}
	public static JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	// ++새로운 예약 패널 생성 후 new컴포넌트 저장
	public void createNew(JPanel panel) {
		// ++새로운 예약 패널 component 1
//		JLabel LavelnewReservation = new JLabel("새로운 예약");
//		LavelnewReservation.setHorizontalAlignment(SwingConstants.CENTER);
//		LavelnewReservation.setFont(new Font("티웨이_항공", Font.BOLD, 30));
//		LavelnewReservation.setBounds(0, 0, 714, 110);
//		newReservation.add(LavelnewReservation);
		JLabel LavelnewReservation = new JLabel("새로운 예약");
		LavelnewReservation.setHorizontalAlignment(SwingConstants.CENTER);
		LavelnewReservation.setFont(new Font("티웨이_항공", Font.BOLD, 30));
		LavelnewReservation.setBounds(0, 0, 714, 110);
		panel.add(LavelnewReservation);
		
		// ++새로운 예약 패널 component 2
//		JLabel date = new JLabel("날짜");
//		date.setHorizontalAlignment(SwingConstants.CENTER);
//		date.setFont(new Font("티웨이_항공", Font.BOLD, 30));
//		date.setBounds(10, 190, 200, 80);
//		newReservation.add(date);

		JLabel date = new JLabel("날짜");
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setFont(new Font("티웨이_항공", Font.BOLD, 30));
		date.setBounds(10, 190, 200, 80);
		panel.add(date);

		// ++새로운 예약 패널 component 3
//		JLabel time = new JLabel("시간");
//		time.setHorizontalAlignment(SwingConstants.CENTER);
//		time.setFont(new Font("티웨이_항공", Font.BOLD, 30));
//		time.setBounds(10, 470, 200, 80);
//		newReservation.add(time);

		JLabel time = new JLabel("시간");
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setFont(new Font("티웨이_항공", Font.BOLD, 30));
		time.setBounds(10, 470, 200, 80);
		panel.add(time);

		// ++새로운 예약 패널 component 4
//		JLabel seat = new JLabel("좌석");
//		seat.setHorizontalAlignment(SwingConstants.CENTER);
//		seat.setFont(new Font("티웨이_항공", Font.BOLD, 30));
//		seat.setBounds(10, 775, 200, 80);
//		newReservation.add(seat);

		JLabel seat = new JLabel("좌석");
		seat.setHorizontalAlignment(SwingConstants.CENTER);
		seat.setFont(new Font("티웨이_항공", Font.BOLD, 30));
		seat.setBounds(10, 775, 200, 80);
		panel.add(seat);
		
		// 새로운 예약 => 좌석표 선택창 오픈 버튼
		// ++새로운 예약 패널 component 5 
//		JButton btn_seat = new JButton("좌석 선택");
//		btn_seat.setFont(new Font("티웨이_항공", Font.BOLD, 25));
//		btn_seat.setBounds(250, 785, 221, 54);
//		btn_seat.setContentAreaFilled(false);
//		btn_seat.setBorderPainted(false);
//		btn_seat.setFocusPainted(false);
//		btn_seat.setOpaque(false);
//		newReservation.add(btn_seat);
//		// 좌석표 창 오픈해야되는 actionlistener필요
//		btn_seat.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//			}
//		});

		JButton btn_seat = new JButton("좌석 선택");
		btn_seat.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_seat.setBounds(250, 785, 221, 54);
		btn_seat.setContentAreaFilled(false);
		btn_seat.setBorderPainted(false);
		btn_seat.setFocusPainted(false);
		btn_seat.setOpaque(false);
		panel.add(btn_seat);
		// 좌석표 창 오픈해야되는 actionlistener필요
		btn_seat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		// 새로운 예약 => 결제 창으로 이동 버튼
		// ++새로운 예약 패널 component 6
//		JButton btn_pay = new JButton("결제");
//		btn_pay.setFont(new Font("티웨이_항공", Font.BOLD, 25));
//		btn_pay.setBounds(558, 940, 158, 110);
//		btn_pay.setContentAreaFilled(false);
//		btn_pay.setBorderPainted(false);
//		btn_pay.setFocusPainted(false);
//		btn_pay.setOpaque(false);
//		newReservation.add(btn_pay);
//		// 결제창으로 이동하는 actionlistener필요
//		btn_seat.addActionListener(new ActionListener() {		
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//			}
//		});

		JButton btn_pay = new JButton("결제");
		btn_pay.setFont(new Font("티웨이_항공", Font.BOLD, 25));
		btn_pay.setBounds(558, 940, 158, 110);
		btn_pay.setContentAreaFilled(false);
		btn_pay.setBorderPainted(false);
		btn_pay.setFocusPainted(false);
		btn_pay.setOpaque(false);
		panel.add(btn_pay);
		// 결제창으로 이동하는 actionlistener필요
		btn_seat.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		//새로운 예약 창에서 예약 홈으로 이동
		// ++새로운 예약 패널 component 7
//		JButton btn_back = new JButton("\uB4A4\uB85C");
//		btn_back.setFont(new Font("티웨이_항공", Font.BOLD, 25));
//		btn_back.setBounds(558, 0, 158, 110);
//		btn_back.setContentAreaFilled(false);
//		btn_back.setBorderPainted(false);
//		btn_back.setFocusPainted(false);
//		newReservation.add(btn_back);
//		btn_back.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				mainReservation.setVisible(true);
//				newReservation.setVisible(false);
//				checkReservation.setVisible(false);
//				cancelReservation.setVisible(false);
//			}
//			
//		});

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
}
