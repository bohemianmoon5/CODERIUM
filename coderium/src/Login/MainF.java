package Login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainF extends JFrame implements ActionListener{
	
	JFrame frame;
	JButton Main_clickMe;
	LogIn login;
	NonMember nonMember;
	SignUp signUp;
	Connect connectP;
	WelcomePage welcomePage;
	ImagePanel ShowUp = new ImagePanel(new ImageIcon("./Image/12(수정).png").getImage());
	ImagePanel connect = new ImagePanel(new ImageIcon("./Image/12.png").getImage());
	
	ArrayList<String> list = new ArrayList<String>();
	public static Component[] con;
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
		
		frame = new JFrame();
		frame.setBounds(350, 350, 720, 1080);
		frame.getContentPane().add(ShowUp);
		
		
		// 메인 버튼
		Main_clickMe = new JButton("<HTML><body><center>All dreamers are here!<br>[Click Me]</center></body></HTML>");
		Main_clickMe.setIcon(new ImageIcon("./Image/메인_버튼.png"));
		Main_clickMe.setBounds(198, 462, 340, 91);
		Main_clickMe.setForeground(new Color(0, 0, 204));
		Main_clickMe.setBackground(new Color(192, 192, 192));
		Main_clickMe.setFont(new Font("twayair", Font.PLAIN, 20));
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
		
		// 연결 패널 
		connectP = new Connect();
		connectP.Connect.add(connect);
		connect.add(connectP.Today);
		connect.add(connectP.Reservation);
		connect.add(connectP.SeatChange);
		connect.add(connectP.In);
		connect.add(connectP.Out);
		ShowUp.add(connectP.Connect);

		//++js modify
		con = connectP.Connect.getComponents();
		//++
		
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
					nonMember.cellPhoneNumField.setText(phone_format(nonMember.cellPhoneNumField.getText()));
					VerifiedNum verifiedNum = new VerifiedNum();
					list.add(verifiedNum.randomNum());
					verifiedNum.randomNum.setText(list.get(0));
					vnOffFrame(verifiedNum.frame);
				}
				break;
			case "loginNon" :
				if(list.get(0).equals(nonMember.verifiedNumField.getText())) {
					welcomePage = new WelcomePage();
					welcomePage.welcomeLabel.setText("    " + "안녕하세요!");
					switchPanels(connect);
					connect.setVisible(true);
					offFrame(welcomePage.frame);
				}
				break;	
			case "cancel" :
				signUp.signUpIDField.setText("");
				signUp.signUpPasswordField.setText("");
				signUp.signUpNameField.setText("");
				signUp.signUpIDNumField.setText("");
				signUp.signUpPhoneNumField.setText("");
				signUp.signUpWordTxt.setText("");
				switchPanels(login.LogIn);
				login.LogIn.setVisible(true);
				break;
			case "return" :
				switchPanels(login.LogIn);
				login.LogIn.setVisible(true);
				break;
			case "login" :
				String userID = login.userIDField.getText();
				String password = String.valueOf(login.userPasswordField.getPassword());
				Connection con;
				Statement stmt;
				ResultSet rs;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registerInfo?autoReconnect=true&useSSL=false", "root", "root");
					stmt = con.createStatement();
					String sql = "SELECT * FROM list WHERE Id ='"+userID+"' AND Pw ='"+password+"'";
					rs = stmt.executeQuery(sql);
					if(rs.next()) {
						welcomePage = new WelcomePage();
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
				SignUpDAO signUpData = new SignUpDAO();
				signUpData.signUp.setId(signUp.signUpIDField.getText());
				// Pw 데이터 저장 
				String stringPassword = "";
				int i = 0;
				for(char a : signUp.signUpPasswordField.getPassword()) {
					stringPassword += signUp.signUpPasswordField.getPassword()[i];
					i++;
				}
				signUpData.signUp.setPw(stringPassword);
				signUpData.signUp.setName(signUp.signUpNameField.getText());
				signUpData.signUp.setIdNum(signUp.signUpIDNumField.getText());
				signUpData.signUp.setPhoneNum(signUp.signUpPhoneNumField.getText());
				signUpData.signUp.setWord(signUp.signUpWordTxt.getText());
				// 성별 데이터 저장
				if(signUp.GenderM.isSelected()) {
					signUpData.signUp.setGender(signUp.GenderM.getToolTipText());
				} else {
					signUpData.signUp.setGender(signUp.GenderW.getToolTipText());
				}
				System.out.println(signUpData.SetSignUp());
				signUpData.SignUpDAO();
				switchPanels(login.LogIn);
				login.LogIn.setVisible(true);
				break;
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
