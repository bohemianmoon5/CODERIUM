package main.pay;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import main.pay.done;
import main.seat.seatMap;

import javax.swing.JCheckBox;

public class payment {

	private JFrame frame;
	private JPanel select;
	private JPanel confirm;
	private JPanel containerPanel;
	private JPanel detailPanel;
	private JPanel cOc;
	private JPanel cash;
	private JButton nextBtn;
	private JButton backBtn;
	private static String seatInfo;
	private static Component[] c;
	// 결제 창의 첫번째 창
	private static Component[] FirstC;
	// 결제 창의 두번째 창
	private static Component[] SecondC;
	private String font = "티웨이_항공";
	payment p;

	// 결제 창 bounds 설정
//	int pointX = seatMap.getFrame().getX() + 10;
//	int pointY = seatMap.getFrame().getY() + 50;
//	int width = seatMap.getFrame().getWidth() - 20;
//	int height = seatMap.getFrame().getHeight() - 100;

	public payment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(110, 50, 700, 900);
		getFrame().setVisible(true);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// frame내 내용들을 모두 감싸는 container Panel 생성
		containerPanel = new JPanel();
		containerPanel.setBounds(12, 10, 660, 841);
		frame.getContentPane().add(containerPanel);
		containerPanel.setLayout(null);

		// 좌석 선택 시 처음으로 보이는 select panel 생성
		select = new JPanel();
		select.setBounds(0, 0, 660, 423);
		containerPanel.add(select);
		select.setLayout(null);

		// select panel 제목 생성
		JLabel selectTitle = new JLabel("select product");
		selectTitle.setFont(new Font(font, Font.BOLD, 18));
		selectTitle.setHorizontalAlignment(SwingConstants.CENTER);
		selectTitle.setBounds(12, 10, 150, 30);
		select.add(selectTitle);

		// select panel에서 상품 선택 시 좌석,상품,가격 확인하는 confirm panel 생성
		confirm = new JPanel();
		confirm.setBounds(0, 423, 660, 354);
		containerPanel.add(confirm);
		confirm.setLayout(null);

		// 결제 팝업의 exit 버튼 누를 시 결제 팝업창만 종료됨
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// 상품 선택 후 다음 패널로 전환하는 next 버튼 생성
		// 상품 선택해야 nextBtn 활성화하는 기능 적용
		nextBtn = new JButton("Next");
		nextBtn.setFont(new Font(font, Font.PLAIN, 20));
		nextBtn.setVisible(true);
		nextBtn.setEnabled(false);
		nextBtn.setBounds(478, 787, 170, 44);
		containerPanel.add(nextBtn);

		// next 버튼 클릭 시 select/confirm 패널 setVisible = false로 변경 후 detailPanel 생성
		nextBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				select.setVisible(false);
//				confirm.setVisible(false);
//				nextBtn.setVisible(false);
				containerPanel.removeAll();
				detailPanel(getInfo(), getProduct(), getPrice());
				cashOrCard();
				containerPanel.repaint();
				SecondC = containerPanel.getComponents();
				chkComponent(SecondC);
			}
		});

		// windowEvent 설정
		windowEvent();

		// 시간_기간 상품에 대한 내용 생성
		createProduct();

		FirstC = containerPanel.getComponents();
		chkComponent(FirstC);
	}

	public void chkComponent(Component[] cc) {
		for (int i = 0; i < cc.length; i++) {
			System.out.println(cc[i]);
		}
		System.out.println();
		System.out.println();
	}

	public void windowEvent() {
		getFrame().addWindowListener(new WindowListener() {
			@Override
			// 윈도우 처음 생성되었을 때
			public void windowOpened(WindowEvent e) {
			}

			@Override
			// 윈도우 시스템 메뉴의 닫기 시도할 때
			public void windowClosing(WindowEvent e) {
			}

			@Override
			// 윈도우가 닫힐 때
			// 결제 창이 닫히면 main 패널에 있는 자식 component 활성화
			public void windowClosed(WindowEvent e) {
				System.out.println("꺼졌다");
//				for (int i = 0; i < c.length; i++) {
//					getSeatCom()[i].setEnabled(true);
//				}
			}

			@Override
			// 윈도우가 최소화 되었을 때
			public void windowIconified(WindowEvent e) {
			}

			@Override
			// 윈도우가 최소화에서 최대화 되었을 때
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			// 윈도우가 활성화 되었을 때
			public void windowActivated(WindowEvent e) {
			}

			@Override
			// 윈도우가 비활성화 되었을 때
			public void windowDeactivated(WindowEvent e) {
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.setType(Type.UTILITY);
	}

	// 선택된 상품 내용
	String product = "";

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	// 선택된 상품의 가격 내용
	String price = "";

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	// 좌석 정보에 대한 내용 seatMap 에서 가져옴
	public String getInfo() {
		return seatInfo;
	}

	public static void setInfo(String info) {
		seatInfo = info;
	}

	// seat panel의 자식 컴포넌트 seatMap에서 가져옴
	// 결제 창 종료될 때 seatPanel의 자식 setEnabled true로 변경시킬 때 사용
	public Component[] getSeatCom() {
		return c;
	}

	public static void setSeatCom(Component[] info) {
		c = info;
	}

	// createProduct() 함수에서 생성한 checkBox 배열
	ArrayList<JCheckBox> chkArr = new ArrayList<JCheckBox>();

	// 시간_기간 상품 패널에 값 넣기
	// 배열 및 반복문 사용하여 진행 완료
	// 데이터 읽어와서 배열에 넣은 후 반복문을 이용하여 label 생성하기 완료
	void createProduct() {
		product a = new product();
		int length = a.arr.size();
		for (int i = 0; i < length; i++) {
			JLabel name = new JLabel("");
			JLabel price = new JLabel("");
			JCheckBox chkBox = new JCheckBox("");

			product contents = new product(select, name, price, chkBox, font);
			contents.createName(i);
			contents.createPrice(i);
			chkArr.add(contents.chkBox(i));
			chkEvent(contents.chkBox(i), name.getText(), price.getText());
		}
		System.out.println(chkArr.size());
	}

	// checkBox 이벤트
	// 상품 선택 시 confirm 패널에 선택한 상품에 대한 내용 생성
	// 체크박스가 선택되어 있으면 confirm 패널에 내용 생성, 아니면 confirm 패널에 내용 x
	// 체크박스가 선택되어 있으면 nextBtn 활성화, 아니면 nextBtn 비활성화
	// 체크박스가 선택되어 있으면 선택된 체크박스 이외 비활성화, 아니면 모두 활성화
	public void chkEvent(JCheckBox chk, String name, String price) {
		chk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chk.isSelected()) {
					setProduct(name);
					setPrice(price);
					createConfirm(getInfo(), getProduct(), getPrice());
					nextBtn.setEnabled(true);
					chkDisabled(chkArr);
				} else {
					confirm.removeAll();
					confirm.repaint();
					nextBtn.setEnabled(false);
					chkEnabled(chkArr);
				}
			}
		});
	}

	// 체크된 체크박스 이외 체크박스 비활성화
	public void chkDisabled(ArrayList<JCheckBox> cb) {
		for (int i = 0; i < cb.size(); i++) {
			if (cb.get(i).isSelected()) {
				for (int j = 0; j < cb.size(); j++) {
					if (i != j) {
						cb.get(j).setEnabled(false);
					}
				}
			}
		}
	}

	// 모든 체크박스 활성화
	public void chkEnabled(ArrayList<JCheckBox> cb) {
		for (int i = 0; i < cb.size(); i++) {
			cb.get(i).setEnabled(true);
		}
	}

	// 선택한 상품 확인하는 패널에 값 넣기
	// 각 클래스 생성하여 구현하기 목표 완료
	// 반복문 사용 가능한 내용은 살펴보고 반복문으로 코드 간결화 완료
	void createConfirm(String seat, String product, String price) {
		confirm confirmTitle = new confirm(confirm, 0, font);
		confirmTitle.createTitle("confirm product");

		String[] listArr = { "Seat Info : ", "product Info : ", "price Info : " };
		String[] detailArr = { seat + "번", product, price };

		for (int i = 0; i < listArr.length; i++) {
			confirm contents = new confirm(confirm, 53, font);
			contents.createList(listArr[i], i);
			contents.createDetail(detailArr[i], i);
		}
	}

	// 선택한 상품에 대한 상세내용 다시 확인하는 detailPanel에 값 넣기
	// 좌석 정보, 상품 이름, 시작시간~끝시간, 가격
	// 각 클래스 생성하여 구현하기 목표 완료
	// 반복문 사용 가능한 내용은 살펴보고 반복문으로 코드 간결화 완료
	// 뒤로 가기 버튼 구현 완료
	public void detailPanel(String seat, String product, String price) {
		detailPanel = new JPanel();
		detailPanel.setBounds(0, 94, 660, 218);
		containerPanel.add(detailPanel);
		detailPanel.setLayout(null);

		showDetail sd = new showDetail(detailPanel, 0, font);
		sd.createTitle("confirm product");

		String[] listArr = { "Seat Info : ", "product Info : ", "usage time : ", "price Info : " };
		String[] detailArr = { seat + "번", product, timeFormat(product), price };

		for (int i = 0; i < listArr.length; i++) {
			showDetail showPanel = new showDetail(detailPanel, 53, font);
			showPanel.createList(listArr[i], i);
			if (i != 2) {
				showPanel.createDetail(detailArr[i], i);
			} else {
				showPanel.createDetail2(detailArr[i], i);
			}
		}
		createBack(FirstC);
	}

	// 뒤로가기 구현
	public void createBack(Component[] target) {
		backBtn = new JButton("◀");
		backBtn.setFont(new Font(font, Font.PLAIN, 20));
		backBtn.setBounds(478, 30, 70, 50);
		containerPanel.add(backBtn);
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				backEvent(target);
			}
		});
	}

	// backBtn event 구현
	public void backEvent(Component[] target) {
		containerPanel.removeAll();
		for (int i = 0; i < target.length; i++) {
			containerPanel.add(target[i]);
		}
		payCash = 0;
		containerPanel.repaint();
	}

	// 현금으로 결제할건지 카드로 결제할건지 선택하는 패널 생성
	public void cashOrCard() {
		cOc = new JPanel();
		cOc.setBounds(0, 352, 660, 243);
		containerPanel.add(cOc);
		cOc.setLayout(null);

		JButton cashBtn = new JButton("Pay with cash");
		cashBtn.setBounds(51, 76, 221, 96);
		cashBtn.setFont(new Font(font, Font.PLAIN, 18));
		// 현금 결제 패널로 전환
		cashBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				containerPanel.removeAll();
				createBack(SecondC);
				makeCashPanel();
				containerPanel.repaint();
			}
		});
		cOc.add(cashBtn);

		makeCardBtn(cOc);
	}

	// cash 클래스 이용하여 cash panel 생성
	int payCash = 0;

	public void makeCashPanel() {
		cash = new JPanel();
		cash.setBounds(0, 36, 660, 741);
		containerPanel.add(cash);
		cash.setLayout(null);

		// cash 패널 list와 detail 생성
		String[] list = { "결제 금액 : ", "투입 금액 : " };
		String[] detail = { getPrice(), "0원" };
		ArrayList<JLabel> detailArr = new ArrayList<JLabel>();
		for (int i = 0; i < list.length; i++) {
			cash c = new cash(cash, 92, font);
			c.makeCashTF(list[i], i);
			detailArr.add(c.makeCashD(detail[i], i));
		}

		// cash 패널 button 생성
		String[] btnDetail = { "1000", "5000", "10000", "50000" };
		ArrayList<JButton> btnArr = new ArrayList<JButton>();

		for (int i = 0; i < btnDetail.length; i++) {
			cash c = new cash(cash, 278, font);
			int chkW = i % 2 != 0 ? 1 : 0;
			int chkY = i > 1 ? 1 : 0;
			btnArr.add(c.makeCashB(btnDetail[i], chkW, chkY));
		}

		// cash 패널 button event 생성
		for (int i = 0; i < btnArr.size(); i++) {
			String a = btnArr.get(i).getText();
			btnArr.get(i).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					payCash += Integer.parseInt(a);
					detailArr.get(1).setText(payCash + "원");
					if (payCash >= Integer.parseInt(detailArr.get(0).getText().substring(0, getPrice().length() - 1))) {
						fakeFrame("cash");
					}
				}
			});
		}
	}

	// cardBtn 생성
	public void makeCardBtn(JPanel panel) {
		JButton cardBtn = new JButton("Pay by card");
		cardBtn.setBounds(353, 76, 221, 96);
		cardBtn.setFont(new Font(font, Font.PLAIN, 18));

		// cardBtn 클릭 시 실제 결제되는 것 처럼 done 팝업창 호출
		// 3초 후 done팝업창과 payment 팝업 창 종료 후
		// main panel에 결제가 완료되었습니다. 감사합니다. + 응원문구 출력 패널 생성
		cardBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fakeFrame("card");
			}
		});
		panel.add(cardBtn);
	}

	public void fakeFrame(String type) {
		int mustCash = Integer.parseInt(getPrice().substring(0, getPrice().length() - 1));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					done d = new done(mustCash, payCash);
					d.getFrame().setVisible(true);
					doneTimerEvent(3000, d, type);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// 결제 완료 시 timerEvent 함수 구현
	public void doneTimerEvent(int time, done d,String type) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				doneEvent(d,type);
			}
		};
		timer.schedule(task, time);
	}

	// 결제 완료 시 event
	public void doneEvent(done d,String type) {
		d.getFrame().dispose();
		getFrame().dispose();
		// 응원문구 패널 생성
		fightingPan();
		storeData sData = new storeData(getInfo(), timeFormat(getProduct()), getProduct(), getPrice(),type);
		sData.store();
	}

	// ++수정 필요한 부분
	public void fightingPan() {
		// Main 페이지 내 패널 안에 있는 구성 요소 삭제
		seatMap.getSeatPanel().removeAll();

		// Main 페이지 내 패널에 감사합니다 + 응원문구 라벨 부착
		JLabel donePhrase = new JLabel("");
		JLabel fightPhrase = new JLabel("");

		fighting ft = new fighting(seatMap.getSeatPanel(), donePhrase, fightPhrase, font);
		ft.createDone("감사합니다.");
		ft.createFight();

		// 패널 repaint
		seatMap.getSeatPanel().repaint();

		// 5초 후 메인 패널로 전환
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				seatMap.getSeatPanel().removeAll();
				mainPanel();
			}
		};
		timer.schedule(task, 5000);
	}

	// 메인 패널 임시로 생성해 놓은 것 (test 용)
	public void mainPanel() {
		JLabel mainPhrase = new JLabel("coderium study cafe");
		mainPhrase.setFont(new Font(font, Font.PLAIN, 30));
		mainPhrase.setHorizontalAlignment(SwingConstants.CENTER);
		mainPhrase.setBounds(76, 153, 520, 126);
		seatMap.getSeatPanel().add(mainPhrase);

		// panel repaint 하기
		seatMap.getSeatPanel().repaint();

	}

	// 시작시간~끝시간에 대한 보여지는 시간 형식 지정
	// ++Date에 관한 윤년 적용해야 함
	public String timeFormat(String product) {
		String formatTime = "";
		Date date = new Date();
		String format = "YYYY년 MM월 dd일 HH시 mm분";
		SimpleDateFormat sd = new SimpleDateFormat(format);
		String now = sd.format(date.getTime());

		if (product.contains("시간")) {
			int productTime = Integer.parseInt(product.substring(0, product.length() - 2));
			int temp = date.getHours() + productTime;
			String endHour = temp >= 24 ? "0" + Integer.toString(temp - 24) : temp + "";
			String format2 = "YYYY년 MM월 dd일 " + endHour + "시 mm분";
			SimpleDateFormat sd2 = new SimpleDateFormat(format2);
			String end = sd2.format(date.getTime());

			formatTime = now + " ~ " + end;
		} else {
			int productDay = Integer.parseInt(product.substring(0, product.length() - 2));
			int temp = date.getDate() + productDay * 7;
			String endDay = Integer.toString(temp);
			String format2 = "YYYY년 MM월 " + endDay + "일 HH시 mm분";
			SimpleDateFormat sd2 = new SimpleDateFormat(format2);
			String end = sd2.format(date.getTime());

			formatTime = now + " ~ " + end;
		}
		return formatTime;
	}

}
