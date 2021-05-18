package Login;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class swing_LoginPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swing_LoginPage window = new swing_LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param hashMap 
	 */
	ImagePanel ShowUp = new ImagePanel(new ImageIcon("/Users/masonna/Desktop/코더리움(스터디카페)/12(수정).png").getImage());
	
	JButton loginButton = new JButton("로그인");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("User ID");
	JLabel userPasswordLabel = new JLabel("Password");
	JPanel SignUp = new JPanel();
	
	private JPanel LogIn = new JPanel();
	private JTextField textField;
	private final JButton nonMemberButton = new JButton("비회원");
	private JTextField cellPhoneNumField;
	private JTextField verifiedNumField;
	private JTextField signUpIDField;
	private JPasswordField signUpPasswordField;
	private JLabel signUpName;
	private JTextField signUpNameField;
	private JLabel signUpGender;
	private JLabel signUpIDNum;
	private JTextField signUpIDNumField;
	private JLabel signUpPhoneNum;
	private JTextField signUpPhoneNumField;
	private JLabel signUpWord;

	public swing_LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 1080);
		frame.getContentPane().add(ShowUp);
		
		// 메인 버튼
		JButton Main_clickMe = new JButton("<HTML><body><center>All dreamers are here!<br>[Click Me]</center></body></HTML>");
		Main_clickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main_clickMe.setVisible(false);
				LogIn.setVisible(true);
			}
		});
		Main_clickMe.setIcon(new ImageIcon("/Users/masonna/Desktop/코더리움(스터디카페)/메인_버튼.png"));
		Main_clickMe.setBounds(198, 462, 340, 91);
		ShowUp.add(Main_clickMe);
		Main_clickMe.setForeground(new Color(0, 0, 204));
		Main_clickMe.setBackground(new Color(192, 192, 192));
		Main_clickMe.setFont(new Font("twayair", Font.PLAIN, 20));
		
		LogIn.setBounds(132, 214, 470, 266);
		ShowUp.add(LogIn);
		LogIn.setToolTipText("");
		LogIn.setBackground(new Color(220, 220, 220));
		LogIn.setLayout(null);
		if(Main_clickMe.isVisible()) 
			LogIn.setVisible(false);
		
		
		// ID
		userIDLabel.setBounds(60, 63, 91, 25);
		userIDLabel.setFont(new Font("twayair", Font.PLAIN, 20));
		LogIn.add(userIDLabel);
		
		// ID TextField
		userIDField.setBounds(60, 90, 340, 34);
		LogIn.add(userIDField);
		
		// Password
		userPasswordLabel.setFont(new Font("twayair", Font.PLAIN, 20));
		userPasswordLabel.setBounds(60, 127, 111, 42);
		LogIn.add(userPasswordLabel);
		
		// Password TextField
		userPasswordField.setBounds(60, 162, 340, 34);
		LogIn.add(userPasswordField);
		
		loginButton.setFont(new Font("twayair", Font.PLAIN, 15));
		loginButton.setBounds(297, 211, 103, 35);
		
		// 로그인 버튼
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// 로그인 정보 불러오기
				IdPassword idPassword = new IdPassword();
				
				String userID = userIDField.getText();
				String password = String.valueOf(userPasswordField.getPassword());
				
				if(idPassword.loginInfo.containsKey(userID)) {
					if(idPassword.loginInfo.get(userID).equals(password)) {
						WelcomePage welcomePage = new WelcomePage();
						welcomePage.welcomeLabel.setText("안녕하세요! " + userID + "님");
					}
					else {
						
					}
				}
				
			}
		});
		
		LogIn.add(loginButton);
		
		nonMemberButton.setFont(new Font("twayair", Font.PLAIN, 14));
		nonMemberButton.setBounds(373, 6, 91, 34);
		LogIn.add(nonMemberButton);
		
		JPanel NonMember = new JPanel();
		NonMember.setLayout(null);
		NonMember.setToolTipText("");
		NonMember.setBackground(new Color(220, 220, 220));
		NonMember.setBounds(132, 214, 470, 266);
		ShowUp.add(NonMember);
		if(Main_clickMe.isVisible()) 
			NonMember.setVisible(false);
		
		// 비회원
		nonMemberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				switchPanels(NonMember);
				NonMember.setVisible(true);
				
			}
		});
		
		JLabel cellPhoneNum = new JLabel("휴대폰 번호");
		cellPhoneNum.setFont(new Font("twayair", Font.PLAIN, 19));
		cellPhoneNum.setBounds(60, 63, 151, 25);
		NonMember.add(cellPhoneNum);
		
		cellPhoneNumField = new JTextField();
		cellPhoneNumField.setBounds(60, 90, 340, 34);
		
		// 휴대폰 번호 포맷 바꾸기 & 인증번호 띄우기
		cellPhoneNumField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(cellPhoneNumField.getText().length() == 11) {
					cellPhoneNumField.setText(phone_format(cellPhoneNumField.getText()));
					VerifiedNum verifiedNum = new VerifiedNum();
					verifiedNum.randomNum();
					
				}
				
			}
		});
		
		NonMember.add(cellPhoneNumField);
		
		JLabel verifiedNum = new JLabel("인증번호");
		verifiedNum.setFont(new Font("twayair", Font.PLAIN, 19));
		verifiedNum.setBounds(60, 127, 168, 42);
		NonMember.add(verifiedNum);
		
		verifiedNumField = new JTextField();
		verifiedNumField.setBounds(60, 162, 340, 34);
		NonMember.add(verifiedNumField);
		
		JButton loginButton_non = new JButton("로그인");
		loginButton_non.setFont(new Font("twayair", Font.PLAIN, 15));
		loginButton_non.setBounds(297, 211, 103, 35);
		
		// 비회원 로그인
		loginButton_non.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					WelcomePage welcomePage = new WelcomePage();
					welcomePage.welcomeLabel.setText("안녕하세요!");
					
			}
		});
		NonMember.add(loginButton_non);
		
		JButton returnButton = new JButton("돌아가기");
		returnButton.setFont(new Font("twayair", Font.PLAIN, 14));
		returnButton.setBounds(373, 6, 91, 34);
		
		// 돌아가기 
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				switchPanels(LogIn);
				LogIn.setVisible(true);
				
				}
				
			});
		NonMember.add(returnButton);
		
		SetSignUp signUpData = new SetSignUp();
		
		SignUp = new JPanel();
		SignUp.setLayout(null);
		SignUp.setToolTipText("");
		SignUp.setBackground(new Color(220, 220, 220));
		SignUp.setBounds(132, 72, 470, 733);
		ShowUp.add(SignUp);
		if(Main_clickMe.isVisible()) 
			SignUp.setVisible(false);
		
		JLabel signUp = new JLabel("회원이 아닌가요?");
		signUp.setBackground(new Color(204, 204, 204));
		signUp.setForeground(new Color(51, 102, 204));
		signUp.setFont(new Font("twayair", Font.PLAIN, 13));
		signUp.setBounds(8, 230, 143, 34);
		LogIn.add(signUp);
		
		JButton signUpButton = new JButton("회원가입");
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(SignUp);
				SignUp.setVisible(true);
				
			}
		});
		signUpButton.setFont(new Font("twayair", Font.PLAIN, 13));
		signUpButton.setBounds(102, 233, 75, 28);
		LogIn.add(signUpButton);
		
		JLabel signUpID = new JLabel("User ID");
		signUpID.setFont(new Font("twayair", Font.PLAIN, 20));
		signUpID.setBounds(60, 45, 91, 25);
		SignUp.add(signUpID);
		
		signUpIDField = new JTextField();
		signUpIDField.setBounds(60, 72, 340, 34);
		SignUp.add(signUpIDField);
		
		JLabel signUpPassword = new JLabel("Password");
		signUpPassword.setFont(new Font("twayair", Font.PLAIN, 20));
		signUpPassword.setBounds(60, 118, 111, 42);
		SignUp.add(signUpPassword);
		
		signUpPasswordField = new JPasswordField();
		signUpPasswordField.setBounds(60, 153, 340, 34);
		SignUp.add(signUpPasswordField);
		
		signUpName = new JLabel("이름");
		signUpName.setFont(new Font("twayair", Font.PLAIN, 19));
		signUpName.setBounds(60, 209, 91, 25);
		SignUp.add(signUpName);
		
		signUpNameField = new JTextField();
		signUpNameField.setBounds(60, 236, 340, 34);
		SignUp.add(signUpNameField);
		
		signUpGender = new JLabel("성별");
		signUpGender.setFont(new Font("twayair", Font.PLAIN, 19));
		signUpGender.setBounds(60, 292, 91, 25);
		SignUp.add(signUpGender);
		
		signUpIDNum = new JLabel("주민등록번호(생년월일)");
		signUpIDNum.setFont(new Font("twayair", Font.PLAIN, 19));
		signUpIDNum.setBounds(60, 375, 201, 25);
		SignUp.add(signUpIDNum);
		
		signUpIDNumField = new JTextField();
		signUpIDNumField.setBounds(60, 402, 340, 34);
		SignUp.add(signUpIDNumField);
		
		signUpPhoneNum = new JLabel("전화번호");
		signUpPhoneNum.setFont(new Font("twayair", Font.PLAIN, 19));
		signUpPhoneNum.setBounds(60, 455, 91, 25);
		SignUp.add(signUpPhoneNum);
		
		signUpPhoneNumField = new JTextField();
		signUpPhoneNumField.setBounds(60, 482, 340, 34);
		SignUp.add(signUpPhoneNumField);
		
		signUpWord = new JLabel("소망(꿈)");
		signUpWord.setFont(new Font("twayair", Font.PLAIN, 19));
		signUpWord.setBounds(60, 534, 91, 25);
		SignUp.add(signUpWord);
		
		JTextPane signUpWordTxt = new JTextPane();
		signUpWordTxt.setBounds(61, 565, 335, 97);
		SignUp.add(signUpWordTxt);
		
		JRadioButton GenderM = new JRadioButton("남");
		GenderM.setToolTipText("남");
		GenderM.setFont(new Font("twayair", Font.PLAIN, 16));
		GenderM.setBounds(70, 330, 54, 23);
		SignUp.add(GenderM);
		
		JRadioButton GenderW = new JRadioButton("여");
		GenderW.setToolTipText("여");
		GenderW.setFont(new Font("twayair", Font.PLAIN, 16));
		GenderW.setBounds(154, 330, 54, 23);
		SignUp.add(GenderW);
		
		// 성별 선택 버튼 그룹화
		ButtonGroup btnGender = new ButtonGroup();
		
		btnGender.add(GenderM);
		btnGender.add(GenderW);
		
		JButton completeBtn = new JButton("가입하기");
		completeBtn.setFont(new Font("twayair", Font.PLAIN, 15));
		completeBtn.setBounds(253, 688, 100, 35);
		
		// 가입버튼(데이터 저장, 화면 전환)
		completeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				signUpData.signUp.setId(signUpIDField.getText());
				
				// Pw 데이터 저장 
				String stringPassword = "";
				int i = 0;
				for(char a : signUpPasswordField.getPassword()) {
					stringPassword += signUpPasswordField.getPassword()[i];
					i++;
				}
				signUpData.signUp.setPw(stringPassword);
				
				signUpData.signUp.setName(signUpNameField.getText());
				signUpData.signUp.setIdNum(signUpIDNumField.getText());
				signUpData.signUp.setPhoneNum(signUpPhoneNumField.getText());
				signUpData.signUp.setWord(signUpWordTxt.getText());
				
				// 성별 데이터 저장
				if(GenderM.isSelected()) {
					signUpData.signUp.setGender(GenderM.getToolTipText());
				} else {
					signUpData.signUp.setGender(GenderW.getToolTipText());
				}
				
				System.out.println(signUpData.SetSignUp());
				
			}
		});
		SignUp.add(completeBtn);
		
		
		
		JButton cancelBtn = new JButton("취소하기");
		
		// 돌아가기 
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(LogIn);
				LogIn.setVisible(true);
				
			}
		});
		cancelBtn.setFont(new Font("twayair", Font.PLAIN, 15));
		cancelBtn.setBounds(360, 688, 100, 35);
		SignUp.add(cancelBtn);
		
		
		/*
		resetButton.setFont(new Font("twayair", Font.PLAIN, 15));
		resetButton.setBounds(245, 224, 103, 20);
		
		// 리셋 버튼
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				userIDField.setText("");
				userPasswordField.setText("");
						
				}
			});
		
		LogIn.add(resetButton);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		*/
	}
	
public void switchPanels(JPanel panel) {
	ShowUp.removeAll();
	ShowUp.add(panel);
	ShowUp.repaint();
	ShowUp.revalidate();
	}


// 휴대폰 번호 양식
public String phone_format(String number) { 
	String regEx = "(\\d{3})(\\d{3,4})(\\d{4})"; 
	return number.replaceAll(regEx, "$1-$2-$3"); 
	}
}

// 배경이미지 넣기
class ImagePanel extends JPanel {

	  private Image img;

	  public ImagePanel(String img) {
	    this(new ImageIcon(img).getImage());
	  }

	  public ImagePanel(Image img) {
	    this.img = img;
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	  }

	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	  }
}
