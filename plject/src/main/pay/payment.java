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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.JCheckBox;

import main.pay.done;
import main.seat.seatMap;
//import test.Main;

//import com.reservation.*;
import java.awt.SystemColor;

public class payment {

	private JFrame frame;

	private JPanel containerPanel;
	private JPanel select;
	private JPanel content;
	private JPanel detailPanel;
	private JPanel cOc;
	private JPanel cash;

	private JButton category;
	private JButton btnNewButton_1;
	private JButton nextBtn;
	private JButton backBtn;

	private static String seatInfo;

	private static Component[] c;
	// ���� â�� ù��° â
	private static Component[] FirstC;
	// ���� â�� �ι�° â
	private static Component[] SecondC;
	// ���� â�� ����° â
	private static Component[] ThirdC;
	private String font = "Ƽ����_�װ�";

	// ���� â bounds ����
//	resrvationFrame a = new resrvationFrame();
//	int pointX = a.getFrame().getX() + 10;
//	int pointY = a.getFrame().getY() + 50;
//	int width = a.getFrame().getWidth() - 20;
//	int height = a.getFrame().getHeight() - 100;

//	int pointX = a.getFrame().getX();
//	int pointY = a.getFrame().getY();
//	int width = a.getFrame().getWidth();
//	int height = a.getFrame().getHeight();

	Color background = new Color(255, 255, 255);
	Color btnC = new Color(206, 237, 222);
	Color btnC2 = new Color(245, 242, 205);

	public payment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(110, 300, 720, 1080);
		getFrame().setTitle("����");
//		System.out.println("a "+ pointX +" " +pointY+" " +width+" " +height);
//		getFrame().setBounds(pointX,pointY,width,height);
		getFrame().setVisible(true);
		frame.getContentPane().setLayout(null);

		// frame�� ������� ��� ���δ� container Panel ����
		containerPanel = new JPanel();
		containerPanel.setBounds(0, 0, 684, 361);
		frame.getContentPane().add(containerPanel);
		containerPanel.setLayout(null);

		// �¼� ���� �� ó������ ���̴� select panel ����
		select = new JPanel();
		select.setBackground(background);
		select.setBounds(0, 0, 684, 361);
		containerPanel.add(select);
		select.setLayout(null);

		// select panel ���� ����
		JLabel selectTitle = new JLabel("select product");
		selectTitle.setFont(new Font(font, Font.BOLD, 18));
		selectTitle.setHorizontalAlignment(SwingConstants.CENTER);
		selectTitle.setBounds(246, 22, 150, 30);
		select.add(selectTitle);

		// ���� �˾��� exit ��ư ���� �� ���� �˾�â�� �����
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// ��ǰ ���� �� ���� �гη� ��ȯ�ϴ� next ��ư ����
		// ��ǰ �����ؾ� nextBtn Ȱ��ȭ�ϴ� ��� ����
		nextBtn = new JButton("Next");
		nextBtn.setFont(new Font(font, Font.PLAIN, 20));
		designBtn(nextBtn, btnC);
		nextBtn.setVisible(true);
		nextBtn.setEnabled(false);
		nextBtn.setBounds(500, 295, 170, 44);
		select.add(nextBtn);

		content = new JPanel();
		content.setBounds(25, 90, 633, 195);
		content.setBackground(background);
		select.add(content);

		createCategory("�ð���", 0);
		createCategory("�Ⱓ��", 1);

		// next ��ư Ŭ�� �� select/confirm �г� setVisible = false�� ���� �� detailPanel ����
		nextBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				containerPanel.removeAll();
				detailPanel(getInfo(), getProduct(), getPrice());
				containerPanel.repaint();
				SecondC = containerPanel.getComponents();
			}
		});

		// windowEvent ����
		windowEvent();

		FirstC = containerPanel.getComponents();
	}

	public void designBtn(JButton btn, Color c) {
		btn.setBackground(c);
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
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
			// ������ ó�� �����Ǿ��� ��
			public void windowOpened(WindowEvent e) {
			}

			@Override
			// ������ �ý��� �޴��� �ݱ� �õ��� ��
			public void windowClosing(WindowEvent e) {
			}

			@Override
			// �����찡 ���� ��
			// ���� â�� ������ main �гο� �ִ� �ڽ� component Ȱ��ȭ
			public void windowClosed(WindowEvent e) {
				System.out.println("������");
//				for (int i = 0; i < c.length; i++) {
//					getSeatCom()[i].setEnabled(true);
//				}
			}

			@Override
			// �����찡 �ּ�ȭ �Ǿ��� ��
			public void windowIconified(WindowEvent e) {
			}

			@Override
			// �����찡 �ּ�ȭ���� �ִ�ȭ �Ǿ��� ��
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			// �����찡 Ȱ��ȭ �Ǿ��� ��
			public void windowActivated(WindowEvent e) {
			}

			@Override
			// �����찡 ��Ȱ��ȭ �Ǿ��� ��
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

	// ���õ� ��ǰ ����
	String product = "";

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	// ���õ� ��ǰ�� ���� ����
	String price = "";

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	// �¼� ������ ���� ���� seatMap ���� ������
	public String getInfo() {
		return seatInfo;
	}

	public static void setInfo(String info) {
		seatInfo = info;
	}

	// seat panel�� �ڽ� ������Ʈ seatMap���� ������
	// ���� â ����� �� seatPanel�� �ڽ� setEnabled true�� �����ų �� ���
	public Component[] getSeatCom() {
		return c;
	}

	public static void setSeatCom(Component[] info) {
		c = info;
	}

	// createProduct() �Լ����� ������ checkBox �迭
	ArrayList<JCheckBox> chkArr = new ArrayList<JCheckBox>();

	// �ð�_�Ⱓ ��ǰ ī�װ� ����
	void createCategory(String str, int i) {
		category = new JButton(str);
		category.setBounds(25 + (i * 95), 65, 90, 30);
		category.setFont(new Font(font, Font.PLAIN, 15));
		designBtn(category, background);
		select.add(category);
		category.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				content.removeAll();
				chkArr.removeAll(chkArr);
				System.out.println(chkArr.size());
				// �ð�_�Ⱓ ��ǰ�� ���� ���� ����
				if (str.contains("�ð�")) {
					createProduct("timePro");
				} else {
					createProduct("termPro");
				}
				content.repaint();
			}
		});
	}

	// �ð�_�Ⱓ ��ǰ �гο� �� �ֱ�
	// �迭 �� �ݺ��� ����Ͽ� ���� �Ϸ�
	// ������ �о�ͼ� �迭�� ���� �� �ݺ����� �̿��Ͽ� label �����ϱ� �Ϸ�
	void createProduct(String tableName) {
		product a = new product(tableName);
		int length = a.nameArr.size();
		System.out.println(length);
		product ctnt = new product(content, font, tableName);
		for (int i = 0; i < length; i++) {
			ctnt.createName(i);
			ctnt.createPrice(i);
			chkArr.add(ctnt.chkBox(i));
			chkEvent(chkArr.get(i), ctnt.nameArr.get(i), ctnt.priceArr.get(i));
		}
	}

	// checkBox �̺�Ʈ
	// ��ǰ ���� �� confirm �гο� ������ ��ǰ�� ���� ���� ����
	// üũ�ڽ��� ���õǾ� ������ confirm �гο� ���� ����, �ƴϸ� confirm �гο� ���� x
	// üũ�ڽ��� ���õǾ� ������ nextBtn Ȱ��ȭ, �ƴϸ� nextBtn ��Ȱ��ȭ
	// üũ�ڽ��� ���õǾ� ������ ���õ� üũ�ڽ� �̿� ��Ȱ��ȭ, �ƴϸ� ��� Ȱ��ȭ
	public void chkEvent(JCheckBox chk, String name, String price) {
		chk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chk.isSelected()) {
					setProduct(name);
					setPrice(price);
					nextBtn.setEnabled(true);
					chkDisabled(chkArr);
				} else {
					nextBtn.setEnabled(false);
					chkEnabled(chkArr);
				}
			}
		});
	}

	// üũ�� üũ�ڽ� �̿� üũ�ڽ� ��Ȱ��ȭ
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

	// ��� üũ�ڽ� Ȱ��ȭ
	public void chkEnabled(ArrayList<JCheckBox> cb) {
		for (int i = 0; i < cb.size(); i++) {
			cb.get(i).setEnabled(true);
		}
	}

	// ������ ��ǰ�� ���� �󼼳��� �ٽ� Ȯ���ϴ� detailPanel�� �� �ֱ�
	// �¼� ����, ��ǰ �̸�, ���۽ð�~���ð�, ����
	// �� Ŭ���� �����Ͽ� �����ϱ� ��ǥ �Ϸ�
	// �ݺ��� ��� ������ ������ ���캸�� �ݺ������� �ڵ� ����ȭ �Ϸ�
	// �ڷ� ���� ��ư ���� �Ϸ�
	public void detailPanel(String seat, String product, String price) {
		detailPanel = new JPanel();
		detailPanel.setBounds(0, 0, 700, 400);
		detailPanel.setBackground(background);
		containerPanel.add(detailPanel);
		detailPanel.setLayout(null);

		showDetail sd = new showDetail(detailPanel, 0, font);
		sd.createTitle("confirm product");

		modiData md = new modiData();

		String[] listArr = { "Seat Info : ", "product Info : ", "usage time : ", "price Info : " };
		String[] detailArr = { seat + "��", product, md.start() + "-" + md.end(product), price };

		for (int i = 0; i < listArr.length; i++) {
			showDetail showPanel = new showDetail(detailPanel, 90, font);
			showPanel.createList(listArr[i], i);
			if (i != 2) {
				showPanel.createDetail(detailArr[i], i);
			} else {
				showPanel.createDetail2(detailArr[i], i);
			}
		}
		createBack(FirstC, detailPanel);
		createNext();

	}

	// �ڷΰ��� ����
	public JButton createBack(Component[] target, JPanel panel) {
		backBtn = new JButton("��");
		backBtn.setFont(new Font(font, Font.PLAIN, 20));
		backBtn.setBounds(400, 295, 100, 45);
		designBtn(backBtn, btnC);
		panel.add(backBtn);
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				backEvent(target);
			}
		});
		return backBtn;
	}

	// backBtn event ����
	public void backEvent(Component[] target) {
		containerPanel.removeAll();
		for (int i = 0; i < target.length; i++) {
			containerPanel.add(target[i]);
		}
		payCash = 0;
		containerPanel.repaint();
	}

	// ���� ����
	// ++���� next ��ư�� �Լ� ��ĥ��
	public void createNext() {
		JButton nextBtn1 = new JButton("��");
		nextBtn1.setFont(new Font(font, Font.PLAIN, 20));
		nextBtn1.setBounds(550, 295, 100, 45);
		designBtn(nextBtn1, btnC);
		detailPanel.add(nextBtn1);
		nextBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				containerPanel.removeAll();
				cashOrCard();
				containerPanel.repaint();
				ThirdC = containerPanel.getComponents();
			}
		});
	}

	// �������� �����Ұ��� ī��� �����Ұ��� �����ϴ� �г� ����
	public void cashOrCard() {
		cOc = new JPanel();
		cOc.setBounds(0, 0, 700, 400);
		cOc.setBackground(background);
		containerPanel.add(cOc);
		cOc.setLayout(null);

		JButton cashBtn = new JButton("Pay with cash");
		cashBtn.setBounds(65, 110, 221, 96);
		cashBtn.setFont(new Font(font, Font.PLAIN, 18));
		designBtn(cashBtn, btnC2);

		// ���� ���� �гη� ��ȯ
		cashBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				containerPanel.removeAll();
				makeCashPanel();
				JButton fifthBack = new JButton("");
				fifthBack = createBack(ThirdC, cash);
				fifthBack.setLocation(500, 10);
				containerPanel.repaint();
			}
		});
		cOc.add(cashBtn);

		makeCardBtn(cOc);
		JButton fourthBack = new JButton("");
		fourthBack = createBack(SecondC, cOc);
		fourthBack.setLocation(500, 295);
	}

	// cash Ŭ���� �̿��Ͽ� cash panel ����
	int payCash = 0;

	public void makeCashPanel() {
		cash = new JPanel();
		cash.setBounds(0, 0, 700, 400);
		cash.setBackground(background);
		containerPanel.add(cash);
		cash.setLayout(null);

		// cash �г� list�� detail ����
		String[] list = { "���� �ݾ� : ", "���� �ݾ� : " };
		String[] detail = { getPrice(), "0��" };
		ArrayList<JLabel> detailArr = new ArrayList<JLabel>();
		for (int i = 0; i < list.length; i++) {
			cash c = new cash(cash, 30, font);
			c.makeCashTF(list[i], i);
			detailArr.add(c.makeCashD(detail[i], i));
		}

		// cash �г� button ����
		String[] btnDetail = { "1000", "5000", "10000", "50000" };
		ArrayList<JButton> btnArr = new ArrayList<JButton>();

		for (int i = 0; i < btnDetail.length; i++) {
			cash c = new cash(cash, 200, font);
			int chkW = i % 2 != 0 ? 1 : 0;
			int chkY = i > 1 ? 1 : 0;
			btnArr.add(c.makeCashB(btnDetail[i], chkW, chkY));
		}

		// cash �г� button event ����
		// button style ����
		for (int i = 0; i < btnArr.size(); i++) {
			String a = btnArr.get(i).getText();
			designBtn(btnArr.get(i), btnC2);
			btnArr.get(i).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					payCash += Integer.parseInt(a);
					detailArr.get(1).setText(payCash + "��");
					if (payCash >= Integer.parseInt(detailArr.get(0).getText().substring(0, getPrice().length() - 1))) {
						fakeFrame("cash");
					}
				}
			});
		}
	}

	// cardBtn ����
	public void makeCardBtn(JPanel panel) {
		JButton cardBtn = new JButton("Pay by card");
		cardBtn.setBounds(370, 110, 221, 96);
		cardBtn.setFont(new Font(font, Font.PLAIN, 18));
		designBtn(cardBtn, btnC2);

		// cardBtn Ŭ�� �� ���� �����Ǵ� �� ó�� done �˾�â ȣ��
		// 3�� �� done�˾�â�� payment �˾� â ���� ��
		// main panel�� ������ �Ϸ�Ǿ����ϴ�. �����մϴ�. + �������� ��� �г� ����
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

	// ���� �Ϸ� �� timerEvent �Լ� ����
	public void doneTimerEvent(int time, done d, String type) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				doneEvent(d, type);
			}
		};
		timer.schedule(task, time);
	}

	// ���� �Ϸ� �� event
	public void doneEvent(done d, String type) {
		d.getFrame().dispose();
		getFrame().dispose();
		// �������� �г� ����
		fightingPan();
		modiData md = new modiData();
		String stSeat = getInfo();
		String stStart = md.start();
		String stUse = md.use(getProduct());
		String stEnd = md.end(getProduct());
		String stPro = md.modiPro(getProduct());
		String stPri = md.modiPri(getPrice());
		storeData sData = new storeData(stSeat, stStart, stUse, stEnd, stPro, stPri, type);
		sData.store();
	}

	// ++���� �ʿ��� �κ�
	public void fightingPan() {
		// Main ������ �� �г� �ȿ� �ִ� ���� ��� ����
		seatMap.getSeatPanel().removeAll();

		// Main ������ �� �гο� �����մϴ� + �������� �� ����
		JLabel donePhrase = new JLabel("");
		JLabel fightPhrase = new JLabel("");

		fighting ft = new fighting(seatMap.getSeatPanel(), donePhrase, fightPhrase, font);
		ft.createDone("�����մϴ�.");
		ft.createFight();

		// �г� repaint
		seatMap.getSeatPanel().repaint();

		// 5�� �� ���� �гη� ��ȯ
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

	// ���� �г� �ӽ÷� ������ ���� �� (test ��)
	public void mainPanel() {
		JLabel mainPhrase = new JLabel("coderium study cafe");
		mainPhrase.setFont(new Font(font, Font.PLAIN, 30));
		mainPhrase.setHorizontalAlignment(SwingConstants.CENTER);
		mainPhrase.setBounds(76, 153, 520, 126);
		seatMap.getSeatPanel().add(mainPhrase);

		// panel repaint �ϱ�
		seatMap.getSeatPanel().repaint();

	}

}
