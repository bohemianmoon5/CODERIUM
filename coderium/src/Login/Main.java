package Login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame implements ActionListener{
	
	JFrame frame;
	JButton Main_clickMe;
	LogIn login;
	NonMember nonMember;
	SignUp signUp;
	Connect connectP;
	ImagePanel ShowUp = new ImagePanel(new ImageIcon("./Image/12(수정).png").getImage());
	ImagePanel connect = new ImagePanel(new ImageIcon("./Image/12.png").getImage());
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main main = new Main();
					main.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Main() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 1080);
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
			case "loginNon" :
				WelcomePage welcomePage = new WelcomePage();
				welcomePage.welcomeLabel.setText("안녕하세요!");
				switchPanels(connect);
				connect.setVisible(true);
				break;	
			case "cancel" :
				switchPanels(login.LogIn);
				login.LogIn.setVisible(true);
				break;
			case "return" :
				switchPanels(login.LogIn);
				login.LogIn.setVisible(true);
				break;
			case "login" :
				// 로그인 정보 불러오기
//				IdPassword idPassword = new IdPassword();
				String userID = login.userIDField.getText();
				String password = String.valueOf(login.userPasswordField.getPassword());
//				if(idPassword.loginInfo.containsKey(userID)) {
//					if(idPassword.loginInfo.get(userID).equals(password)) {
//						welcomePage = new WelcomePage();
//						welcomePage.welcomeLabel.setText("안녕하세요! " + userID + "님");
//						switchPanels(connect);
//						connect.setVisible(true);
//					}
//					else {
//					}
//				}
				Test test = new Test();
				test.login(userID, password);
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
				break;
		}
		
	}

	public void switchPanels(JPanel panel) {
		ShowUp.removeAll();
		ShowUp.add(panel);
		ShowUp.repaint();
		ShowUp.revalidate();
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
