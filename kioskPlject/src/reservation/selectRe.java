package reservation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

public class selectRe extends JPanel implements ActionListener{
	JPanel panel = new JPanel();

	private String font = "티웨이_항공";
	JRadioButton radio[] = new JRadioButton[3];
	String radio_name[] = {"1.","2.","3."};
//	JRadioButton rdbtnNewRadioButton = new JRadioButton();
//	JRadioButton rdbtnNewRadioButton_1 = new JRadioButton();
//	JRadioButton rdbtnNewRadioButton_2 = new JRadioButton();

	
	public selectRe(JPanel panel) {
		setLayout(null);
		
		ButtonGroup group = new ButtonGroup();
        for(int i=0; i<3; i++){
        	radio[i] = new JRadioButton(radio_name[i]);
             group.add(radio[i]);
             radio[i].addActionListener(this);
             radio[i].setBounds(57, 55, 166, 41);
             radio[i].setFocusPainted(false);
             radio[i].setBorderPainted(false);
             radio[i].setContentAreaFilled(false);
             radio[i].setFont(new Font("티웨이_항공", Font.BOLD, 30));
             if(radio[i] == radio[0]) { 
            	radio[i].setBounds(57, 55, 166, 41);
             }else if(radio[i] == radio[1]) { 
            	radio[i].setBounds(57, 225, 166, 41);
             }else if(radio[i] == radio[2]) {
            	radio[i].setBounds(57, 410, 166, 41);
             }
        	

           add(radio[i]);
             
        }
        
        radio[0].setSelected(false);
        radio[1].setSelected(true);
        
        
        setSize(252, 496);
        
        //DB 연결 클래스 불러옴
//        dbconnect();
        
      

        
//        JRadioButton selectRe = new JRadioButton();
//        for (int i = 1; i < 4; i++) {
//            rdbtnNewRadioButton.setBounds(57, 55, 166, 41);
//            rdbtnNewRadioButton.setFocusPainted(false);
//            rdbtnNewRadioButton.setBorderPainted(false);
//            rdbtnNewRadioButton.setContentAreaFilled(false);
//            rdbtnNewRadioButton.setFont(new Font("티웨이_항공", Font.BOLD, 30));
//
//            add(rdbtnNewRadioButton);
//			
//		}
//        
//        
//        // 1번예약 부분에 정보불러오기 필요
//        JRadioButton rdbtnNewRadioButton = new JRadioButton("1번 예약");
//        rdbtnNewRadioButton.setBounds(57, 55, 166, 41);
//        rdbtnNewRadioButton.setFocusPainted(false);
//        rdbtnNewRadioButton.setBorderPainted(false);
//        rdbtnNewRadioButton.setContentAreaFilled(false);
//        rdbtnNewRadioButton.setFont(new Font("티웨이_항공", Font.BOLD, 30));
//
//        add(rdbtnNewRadioButton);
//        
//        // 2번예약 부분에 정보불러오기 필요
//        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("2번 예약");
//        rdbtnNewRadioButton_1.setBounds(57, 224, 166, 41);
//        rdbtnNewRadioButton_1.setFocusPainted(false);
//        rdbtnNewRadioButton_1.setBorderPainted(false);
//        rdbtnNewRadioButton_1.setContentAreaFilled(false);
//        rdbtnNewRadioButton_1.setFont(new Font("티웨이_항공", Font.BOLD, 30));
//
//        add(rdbtnNewRadioButton_1);
//        
//        // 3번예약 부분에 정보불러오기 필요
//        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("3번 예약");
//        rdbtnNewRadioButton_2.setBounds(57, 407, 166, 41);
//        rdbtnNewRadioButton_2.setFocusPainted(false);
//        rdbtnNewRadioButton_2.setBorderPainted(false);
//        rdbtnNewRadioButton_2.setContentAreaFilled(false);
//        rdbtnNewRadioButton_2.setFont(new Font("티웨이_항공", Font.BOLD, 30));
//
//        add(rdbtnNewRadioButton_2);
//        
//
//        
//        rdbtnNewRadioButton.setSelected(false);
//        rdbtnNewRadioButton_1.setSelected(false);
//        rdbtnNewRadioButton_2.setSelected(false);
//
        panel.setLayout(null);
        panel.setBackground(new Color(255,0,0));
        panel.setOpaque(false);
//        
//	
//		
//	}	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		   String s = e.getActionCommand();
//           
//           if(s.equals(rdbtnNewRadioButton.getText())){
//               JOptionPane.showMessageDialog(null,"선택 예약 : "+rdbtnNewRadioButton.getText());
//           }
//           else if(s.equals(rdbtnNewRadioButton_1.getText())){
//               JOptionPane.showMessageDialog(null,"선택 예약 : "+rdbtnNewRadioButton_1.getText());
//           }
//           else if(s.equals(rdbtnNewRadioButton_2.getText())){
//               JOptionPane.showMessageDialog(null,"선택 예약 : "+rdbtnNewRadioButton_2.getText());
//           }	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	

