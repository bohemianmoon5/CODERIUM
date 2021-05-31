package login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pay.data.db;

public class MainF extends JFrame implements ActionListener{
	
	public static JFrame frame;
	JButton Main_clickMe;
	LogIn login;
	NonMember nonMember;
	SignUp signUp;
	Connect connectP;
	WelcomePage welcomePage;
	SignUpDAO signUpData;
	WarningMs warningMs;
	
	//폰트 설정
	String font = "twayair";
	
	ImagePanel ShowUp = new ImagePanel(new ImageIcon("./src/image/12(수정).png").getImage());
	ImagePanel connect = new ImagePanel(new ImageIcon("./src/image/new.png").getImage());
	
	ArrayList<String> forVerifiedNum = new ArrayList<String>();
	ArrayList<String> phoneNumData = new ArrayList<String>();
	
	//++js modify
	//다시 메인 화면으로 돌아가기 위함
	Component[] first;
	//++
	
	public static String user ="";
	
	// DB form
	String userID;
	String password;
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	// 유효성 검사 
	CheckForm check;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainF main = new MainF();
					main.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainF() {
		
		String form = "yyyy/MM/dd/HH:mm";
		SimpleDateFormat s = new SimpleDateFormat(form);
		Date now = new Date();
		db d = new db();
		d.delete("paydata", s.format(now));
		
		frame = new JFrame();
		frame.setBounds(350, 350, 720, 1080);
		frame.getContentPane().add(ShowUp);
		
		setFrame(frame);
		setShowUp(ShowUp);
		
		
		// 메인 버튼
		Main_clickMe = new JButton("<HTML><body><center>All dreamers are here!<br>[Click Me]</center></body></HTML>");
		Main_clickMe.setIcon(new ImageIcon("./src/image/메인_버튼.png"));
		Main_clickMe.setBounds(198, 462, 340, 91);
		Main_clickMe.setForeground(new Color(0, 0, 204));
		Main_clickMe.setBackground(new Color(192, 192, 192));
		Main_clickMe.setFont(new Font(font, Font.PLAIN, 20));
		Main_clickMe.setActionCommand("start");
		Main_clickMe.addActionListener(this);
		ShowUp.add(Main_clickMe);
		
		// 로그인
		login = new LogIn();
		ShowUp.add(login.LogIn);
		if(Main_clickMe.isVisible()) 
			login.LogIn.setVisible(false);
		login.loginButton.setActionCommand("login");
		login.loginButton.addActionListener(this);
		
		// 비회원 로그인 
		nonMember = new NonMember();
		login.LogIn.add(nonMember.nonMemberButton);
		ShowUp.add(nonMember.NonMember);
		if(Main_clickMe.isVisible()) 
			nonMember.NonMember.setVisible(false);
		nonMember.nonMemberButton.setActionCommand("nonMember");
		nonMember.nonMemberButton.addActionListener(this);
		nonMember.returnButton.setActionCommand("return");
		nonMember.returnButton.addActionListener(this);
		nonMember.loginButtonNon.setActionCommand("loginNon");
		nonMember.loginButtonNon.addActionListener(this);
		nonMember.cellPhoneNumField.setActionCommand("phone");
		nonMember.cellPhoneNumField.addActionListener(this);
		
		// 가입하기
		signUp = new SignUp();
		login.LogIn.add(signUp.SignUp);
		login.LogIn.add(signUp.signUp);
		login.LogIn.add(signUp.signUpButton);
		ShowUp.add(signUp.SignUp);
		if(Main_clickMe.isVisible()) 
			signUp.SignUp.setVisible(false);
		signUp.cancelBtn.setActionCommand("cancel");
		signUp.cancelBtn.addActionListener(this);
		signUp.signUpButton.setActionCommand("signUp");
		signUp.signUpButton.addActionListener(this);
		signUp.completeBtn.setActionCommand("complete");
		signUp.completeBtn.addActionListener(this);
		
		// 유효성 검사(form) 
		// check = new CheckForm();
		// 유효성 검사 
		signUp.signUpIDField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(signUp.signUpIDField.getText().equals("")) {
					warningMs = new WarningMs();
					warningMs.warning.setBounds(95, 20, 330, 130);
					warningMs.warning.setText("ID를 입력해주세요!");
					offFrame(warningMs.frame);
				}else if(signUp.signUpIDField.getText().length() < 5 || signUp.signUpIDField.getText().length() > 10) {
					warningMs = new WarningMs();
					warningMs.warning.setBounds(65, 10, 400, 150);
					warningMs.warning.setText("ID 글자수는 5 ~ 10 입니다!");
					offFrame(warningMs.frame);	
				}else if(Integer.parseInt(signUp.signUpIDField.getText()) >= 0 || Integer.parseInt(signUp.signUpIDField.getText()) < 0) {
					warningMs = new WarningMs();
					warningMs.warning.setBounds(60, 10, 400, 150);
					warningMs.warning.setText("ID에 숫자 사용은 불가합니다!");
					offFrame(warningMs.frame);
				}
			}
		});
		signUp.signUpPasswordField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//비밀번호 양식 
				String checkPw = "";
				int c = 0;
				for(char a : signUp.signUpPasswordField.getPassword()) {
					checkPw += signUp.signUpPasswordField.getPassword()[c];
					c++;
				}
				if(checkPw.equals("")) {
					warningMs = new WarningMs();
					warningMs.warning.setBounds(95, 20, 330, 130);
					warningMs.warning.setText("PW를 입력해주세요!");
					offFrame(warningMs.frame);
				}else if(checkPw.length() < 6 || checkPw.length() > 12) {
					warningMs = new WarningMs();
					warningMs.warning.setBounds(60, 10, 400, 150);
					warningMs.warning.setText("PW 자리수는 6 ~ 12 입니다!");
					offFrame(warningMs.frame);
				}
			}
		});
		signUp.signUpNameField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(signUp.signUpNameField.getText().equals("")) {
					warningMs = new WarningMs();
					warningMs.warning.setBounds(95, 20, 330, 130);
					warningMs.warning.setText("이름을 입력해주세요!");
					offFrame(warningMs.frame);
				}else if(signUp.signUpNameField.getText().length() < 1 || signUp.signUpNameField.getText().length() > 10) {
					warningMs = new WarningMs();
					warningMs.warning.setBounds(60, 10, 400, 150);
					warningMs.warning.setText("이름은 1 ~ 10자까지 입니다!");
					offFrame(warningMs.frame);
				}else if(Integer.parseInt(signUp.signUpNameField.getText()) >= 0 || Integer.parseInt(signUp.signUpNameField.getText()) < 0) {
					warningMs = new WarningMs();
					warningMs.warning.setBounds(50, 10, 400, 150);
					warningMs.warning.setText("이름에 숫자 사용은 불가합니다!");
					offFrame(warningMs.frame);
				}
			}
		});
		signUp.signUpIDNumField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(signUp.signUpIDNumField.getText().equals("")) {
					warningMs = new WarningMs();
					warningMs.warning.setBounds(75, 15, 330, 130);
					warningMs.warning.setText("생년월일을 입력해주세요!");
					offFrame(warningMs.frame);
				}else if(signUp.signUpIDNumField.getText().length() > 6 || signUp.signUpIDNumField.getText().length() < 6) {
					warningMs = new WarningMs();
					warningMs.warning.setBounds(50, 10, 400, 150);
					warningMs.warning.setText("생년월일을 다시 입력해주세요!");
					offFrame(warningMs.frame);
				}
			}
		});
		signUp.signUpPhoneNumField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(signUp.signUpPhoneNumField.getText().equals("")) {
					warningMs = new WarningMs();
					warningMs.warning.setBounds(60, 15, 330, 130);
					warningMs.warning.setText("휴대폰 번호를 입력해주세요!");
					offFrame(warningMs.frame);
				}else if(signUp.signUpPhoneNumField.getText().length() < 11 || signUp.signUpPhoneNumField.getText().length() > 11) {
					warningMs = new WarningMs();
					warningMs.warning.setBounds(30, 10, 400, 150);
					warningMs.warning.setText("입력하신 번호를 다시 확인해주세요!");
					offFrame(warningMs.frame);
				}
			}
		});
		
		first = ShowUp.getComponents();
		System.out.println(first.length);
		
		// 연결 패널 
		connectP = new Connect(frame, ShowUp, first, login.userIDField, login.userPasswordField, s.format(now));
		connectP.Connect.add(connect);
		connect.add(connectP.Today);
		connect.add(connectP.Reservation);
		connect.add(connectP.SeatChange);
		connect.add(connectP.In);
		connect.add(connectP.Out);
		
		ShowUp.add(connectP.Connect);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "start" :
				Main_clickMe.setVisible(false);
				login.LogIn.setVisible(true);
				break;
			case "nonMember" :
				switchPanels(nonMember.NonMember);
				nonMember.NonMember.setVisible(true);
				break;
			case "phone" :
				if(nonMember.cellPhoneNumField.getText().length() == 11) {
					phoneNumData.add(nonMember.cellPhoneNumField.getText());
					nonMember.cellPhoneNumField.setText(phone_format(nonMember.cellPhoneNumField.getText()));
					VerifiedNum verifiedNum = new VerifiedNum();
					forVerifiedNum.add(verifiedNum.randomNum());
					verifiedNum.randomNum.setText(forVerifiedNum.get(0));
					vnOffFrame(verifiedNum.frame);
				}
				break;
			case "loginNon" :
				if(forVerifiedNum.get(0).equals(nonMember.verifiedNumField.getText())) {
					welcomePage = new WelcomePage();
					welcomePage.welcomeLabel.setText("    " + "안녕하세요!");
					switchPanels(connect);
					connect.setVisible(true);
					offFrame(welcomePage.frame);
				}
				break;	
			case "cancel" :
				deleteAll();
				switchPanels(login.LogIn);
				login.LogIn.setVisible(true);
				break;
			case "return" :
				nonMember.cellPhoneNumField.setText("");
				nonMember.verifiedNumField.setText("");
				switchPanels(login.LogIn);
				login.LogIn.setVisible(true);
				break;
			case "login" :
				userID = login.userIDField.getText();
				password = String.valueOf(login.userPasswordField.getPassword());
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registerInfo?autoReconnect=true&useSSL=false", "root", "root");
					stmt = con.createStatement();
					String sql = "SELECT * FROM list WHERE Id ='"+userID+"' AND Pw ='"+password+"'";
					rs = stmt.executeQuery(sql);
					if(rs.next()) {
						welcomePage = new WelcomePage();
						welcomePage.frame.setBounds(510, 30, 400, 200);
						welcomePage.welcomeLabel.setText("안녕하세요! " + txt(userID) + "님");
						switchPanels(connect);
						connect.setVisible(true);
						offFrame(welcomePage.frame);
					}else {
						welcomePage = new WelcomePage();
						welcomePage.welcomeLabel.setText("로그인 실패입니다!");
						offFrame(welcomePage.frame);
					}
					con.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				break;
			case "signUp" :
				switchPanels(signUp.SignUp);
				signUp.SignUp.setVisible(true);
				break;
			case "complete" :
				//비밀번호 양식 
				String checkPw = "";
				int c = 0;
				for(char a : signUp.signUpPasswordField.getPassword()) {
					checkPw += signUp.signUpPasswordField.getPassword()[c];
					c++;
				}
				if(!signUp.signUpIDField.getText().equals("") && !checkPw.equals("") && !signUp.signUpNameField.getText().equals("") && !signUp.signUpIDNumField.getText().equals("") && !signUp.signUpPhoneNumField.getText().equals("")) {
					signUpData = new SignUpDAO();
					signUpData.signUp.setId(signUp.signUpIDField.getText());
					signUpData.signUp.setPw(checkPw);
					signUpData.signUp.setName(signUp.signUpNameField.getText());
					signUpData.signUp.setIdNum(signUp.signUpIDNumField.getText());
					signUpData.signUp.setPhoneNum(signUp.signUpPhoneNumField.getText());
					signUpData.signUp.setWord(signUp.signUpWordTxt.getText());
					// 성별 데이터 저장
					if(signUp.GenderM.isSelected()) {
						signUpData.signUp.setGender(signUp.GenderM.getToolTipText());
					}else if(signUp.GenderW.isSelected()) {
						signUpData.signUp.setGender(signUp.GenderW.getToolTipText());
					}else {
						warningMs = new WarningMs();
						warningMs.warning.setBounds(90, 15, 330, 130);
						warningMs.warning.setText("성별을 선택해주세요!");
						offFrame(warningMs.frame);
					} 
					System.out.println(signUpData.SetSignUp());
					if(!(signUpData.SignUpDAO() == -1)) {
						switchPanels(login.LogIn);
						login.LogIn.setVisible(true);
						deleteAll();
					}else {
						signUpData.SignUpDAO();
					}
					break;
				}else {
					warningMs = new WarningMs();
					warningMs.warning.setBounds(60, 15, 330, 130);
					warningMs.warning.setText("빈 공간이 없도록 해주세요!");
					offFrame(warningMs.frame);
					}
		}
}
	
	public void vnOffFrame(JFrame f) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				f.setVisible(false);
			}
		};
		timer.schedule(task, 4000);
	}
	
	public void offFrame(JFrame f) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				f.setVisible(false);
			}
		};
		timer.schedule(task, 2000);
	}
	
	public String txt(String s) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(s);
		return list.get(0);
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
	
	public void deleteAll() {
		signUp.signUpIDField.setText("");
		signUp.signUpPasswordField.setText("");
		signUp.signUpNameField.setText("");
		signUp.signUpIDNumField.setText("");
		signUp.signUpPhoneNumField.setText("");
		signUp.signUpWordTxt.setText("");
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public JPanel getShowUp() {
		return ShowUp;
	}

	public void setShowUp(JPanel Showup) {
		this.ShowUp = ShowUp;
	}

	//배경이미지 넣기
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
}
