package test;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.HashMap;

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
	
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("User ID");
	JLabel userPasswordLabel = new JLabel("Password");
	
	private final JPanel LogIn = new JPanel();
	private JTextField textField;
	

	public swing_LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		
		ImagePanel panel = new ImagePanel(new ImageIcon("/Users/masonna/Desktop/코더리움(스터디카페)/12.png").getImage());
		
		frame.setBounds(100, 100, 720, 1080);
		frame.getContentPane().add(panel);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LogIn.setToolTipText("");
		LogIn.setBackground(new Color(220, 220, 220));
		LogIn.setBounds(139, 222, 470, 266);
		LogIn.setLayout(null);
		
		panel.add(LogIn);
		
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
		loginButton.setBounds(112, 224, 103, 20);
		
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
						
						
					}
					else {
						
					}
				}
				
			}
		});
		
		LogIn.add(loginButton);
		
		
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
