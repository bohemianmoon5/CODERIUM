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
	// ���� â�� ù��° â
	private static Component[] FirstC;
	// ���� â�� �ι�° â
	private static Component[] SecondC;
	private String font = "Ƽ����_�װ�";
	payment p;

	// ���� â bounds ����
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

		// frame�� ������� ��� ���δ� container Panel ����
		containerPanel = new JPanel();
		containerPanel.setBounds(12, 10, 660, 841);
		frame.getContentPane().add(containerPanel);
		containerPanel.setLayout(null);

		// �¼� ���� �� ó������ ���̴� select panel ����
		select = new JPanel();
		select.setBounds(0, 0, 660, 423);
		containerPanel.add(select);
		select.setLayout(null);

		// select panel ���� ����
		JLabel selectTitle = new JLabel("select product");
		selectTitle.setFont(new Font(font, Font.BOLD, 18));
		selectTitle.setHorizontalAlignment(SwingConstants.CENTER);
		selectTitle.setBounds(12, 10, 150, 30);
		select.add(selectTitle);

		// select panel���� ��ǰ ���� �� �¼�,��ǰ,���� Ȯ���ϴ� confirm panel ����
		confirm = new JPanel();
		confirm.setBounds(0, 423, 660, 354);
		containerPanel.add(confirm);
		confirm.setLayout(null);

		// ���� �˾��� exit ��ư ���� �� ���� �˾�â�� �����
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// ��ǰ ���� �� ���� �гη� ��ȯ�ϴ� next ��ư ����
		// ��ǰ �����ؾ� nextBtn Ȱ��ȭ�ϴ� ��� ����
		nextBtn = new JButton("Next");
		nextBtn.setFont(new Font(font, Font.PLAIN, 20));
		nextBtn.setVisible(true);
		nextBtn.setEnabled(false);
		nextBtn.setBounds(478, 787, 170, 44);
		containerPanel.add(nextBtn);

		// next ��ư Ŭ�� �� select/confirm �г� setVisible = false�� ���� �� detailPanel ����
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

		// windowEvent ����
		windowEvent();

		// �ð�_�Ⱓ ��ǰ�� ���� ���� ����
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

	// �ð�_�Ⱓ ��ǰ �гο� �� �ֱ�
	// �迭 �� �ݺ��� ����Ͽ� ���� �Ϸ�
	// ������ �о�ͼ� �迭�� ���� �� �ݺ����� �̿��Ͽ� label �����ϱ� �Ϸ�
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

	// ������ ��ǰ Ȯ���ϴ� �гο� �� �ֱ�
	// �� Ŭ���� �����Ͽ� �����ϱ� ��ǥ �Ϸ�
	// �ݺ��� ��� ������ ������ ���캸�� �ݺ������� �ڵ� ����ȭ �Ϸ�
	void createConfirm(String seat, String product, String price) {
		confirm confirmTitle = new confirm(confirm, 0, font);
		confirmTitle.createTitle("confirm product");

		String[] listArr = { "Seat Info : ", "product Info : ", "price Info : " };
		String[] detailArr = { seat + "��", product, price };

		for (int i = 0; i < listArr.length; i++) {
			confirm contents = new confirm(confirm, 53, font);
			contents.createList(listArr[i], i);
			contents.createDetail(detailArr[i], i);
		}
	}

	// ������ ��ǰ�� ���� �󼼳��� �ٽ� Ȯ���ϴ� detailPanel�� �� �ֱ�
	// �¼� ����, ��ǰ �̸�, ���۽ð�~���ð�, ����
	// �� Ŭ���� �����Ͽ� �����ϱ� ��ǥ �Ϸ�
	// �ݺ��� ��� ������ ������ ���캸�� �ݺ������� �ڵ� ����ȭ �Ϸ�
	// �ڷ� ���� ��ư ���� �Ϸ�
	public void detailPanel(String seat, String product, String price) {
		detailPanel = new JPanel();
		detailPanel.setBounds(0, 94, 660, 218);
		containerPanel.add(detailPanel);
		detailPanel.setLayout(null);

		showDetail sd = new showDetail(detailPanel, 0, font);
		sd.createTitle("confirm product");

		String[] listArr = { "Seat Info : ", "product Info : ", "usage time : ", "price Info : " };
		String[] detailArr = { seat + "��", product, timeFormat(product), price };

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

	// �ڷΰ��� ����
	public void createBack(Component[] target) {
		backBtn = new JButton("��");
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

	// backBtn event ����
	public void backEvent(Component[] target) {
		containerPanel.removeAll();
		for (int i = 0; i < target.length; i++) {
			containerPanel.add(target[i]);
		}
		payCash = 0;
		containerPanel.repaint();
	}

	// �������� �����Ұ��� ī��� �����Ұ��� �����ϴ� �г� ����
	public void cashOrCard() {
		cOc = new JPanel();
		cOc.setBounds(0, 352, 660, 243);
		containerPanel.add(cOc);
		cOc.setLayout(null);

		JButton cashBtn = new JButton("Pay with cash");
		cashBtn.setBounds(51, 76, 221, 96);
		cashBtn.setFont(new Font(font, Font.PLAIN, 18));
		// ���� ���� �гη� ��ȯ
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

	// cash Ŭ���� �̿��Ͽ� cash panel ����
	int payCash = 0;

	public void makeCashPanel() {
		cash = new JPanel();
		cash.setBounds(0, 36, 660, 741);
		containerPanel.add(cash);
		cash.setLayout(null);

		// cash �г� list�� detail ����
		String[] list = { "���� �ݾ� : ", "���� �ݾ� : " };
		String[] detail = { getPrice(), "0��" };
		ArrayList<JLabel> detailArr = new ArrayList<JLabel>();
		for (int i = 0; i < list.length; i++) {
			cash c = new cash(cash, 92, font);
			c.makeCashTF(list[i], i);
			detailArr.add(c.makeCashD(detail[i], i));
		}

		// cash �г� button ����
		String[] btnDetail = { "1000", "5000", "10000", "50000" };
		ArrayList<JButton> btnArr = new ArrayList<JButton>();

		for (int i = 0; i < btnDetail.length; i++) {
			cash c = new cash(cash, 278, font);
			int chkW = i % 2 != 0 ? 1 : 0;
			int chkY = i > 1 ? 1 : 0;
			btnArr.add(c.makeCashB(btnDetail[i], chkW, chkY));
		}

		// cash �г� button event ����
		for (int i = 0; i < btnArr.size(); i++) {
			String a = btnArr.get(i).getText();
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
		cardBtn.setBounds(353, 76, 221, 96);
		cardBtn.setFont(new Font(font, Font.PLAIN, 18));

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

	// ���� �Ϸ� �� event
	public void doneEvent(done d,String type) {
		d.getFrame().dispose();
		getFrame().dispose();
		// �������� �г� ����
		fightingPan();
		storeData sData = new storeData(getInfo(), timeFormat(getProduct()), getProduct(), getPrice(),type);
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

	// ���۽ð�~���ð��� ���� �������� �ð� ���� ����
	// ++Date�� ���� ���� �����ؾ� ��
	public String timeFormat(String product) {
		String formatTime = "";
		Date date = new Date();
		String format = "YYYY�� MM�� dd�� HH�� mm��";
		SimpleDateFormat sd = new SimpleDateFormat(format);
		String now = sd.format(date.getTime());

		if (product.contains("�ð�")) {
			int productTime = Integer.parseInt(product.substring(0, product.length() - 2));
			int temp = date.getHours() + productTime;
			String endHour = temp >= 24 ? "0" + Integer.toString(temp - 24) : temp + "";
			String format2 = "YYYY�� MM�� dd�� " + endHour + "�� mm��";
			SimpleDateFormat sd2 = new SimpleDateFormat(format2);
			String end = sd2.format(date.getTime());

			formatTime = now + " ~ " + end;
		} else {
			int productDay = Integer.parseInt(product.substring(0, product.length() - 2));
			int temp = date.getDate() + productDay * 7;
			String endDay = Integer.toString(temp);
			String format2 = "YYYY�� MM�� " + endDay + "�� HH�� mm��";
			SimpleDateFormat sd2 = new SimpleDateFormat(format2);
			String end = sd2.format(date.getTime());

			formatTime = now + " ~ " + end;
		}
		return formatTime;
	}

}
