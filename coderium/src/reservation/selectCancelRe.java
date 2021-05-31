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

public class selectCancelRe extends JPanel implements ActionListener{
	JPanel panel = new JPanel();

	private String font = "twayair";
	JRadioButton cancel[] = new JRadioButton[3];
	String cancel_name[] = {"1.","2.","3."};
//	JRadioButton rdbtnNewRadioButton = new JRadioButton();
//	JRadioButton rdbtnNewRadioButton_1 = new JRadioButton();
//	JRadioButton rdbtnNewRadioButton_2 = new JRadioButton();

	

	public selectCancelRe(JPanel panel) {
		setLayout(null);
		
		ButtonGroup group = new ButtonGroup();
        for(int i=0; i<3; i++){
        	 cancel[i] = new JRadioButton(cancel_name[i]);
        	 if(cancel_name[i] == null)
        		continue;
             group.add(cancel[i]);
             cancel[i].addActionListener(this);
             cancel[i].setBounds(57, 55, 166, 41);
             cancel[i].setFocusPainted(false);
             cancel[i].setBorderPainted(false);
             cancel[i].setContentAreaFilled(false);
             cancel[i].setFont(new Font("twayair", Font.BOLD, 30));
             if(i == 0) { 
            	 cancel[i].setBounds(57, 55, 166, 41);
             }else if(i == 1) { 
            	 cancel[i].setBounds(57, 225, 166, 41);
             }else if(i == 2) {
            	 cancel[i].setBounds(57, 410, 166, 41);
             }
             cancel[i].addActionListener(this);
             
           add(cancel[i]);
        }
//        if(cancel[0] != null) { 
//       	 cancel[0].setBounds(57, 55, 166, 41);
//        }if(cancel[1] != null) { 
//       	 cancel[1].setBounds(57, 225, 166, 41);
//        }if(cancel[2] != null) {
//       	 cancel[2].setBounds(57, 410, 166, 41);
//        }
        
        cancel[0].setSelected(false);
        cancel[1].setSelected(true);
        
        
        setSize(252, 496);
//		ButtonGroup group = new ButtonGroup();
//        for(int i=0; i<3; i++){
//        	reList[i] = new JRadioButton(radio_name[i]);
//             group.add(reList[i]);
//             panel.add(reList[i]);
//             reList[i].addActionListener(this);
//        }
        
//        setSize(252, 496);
        
        // 1번예약 부분에 정보불러오기 필요
//        JRadioButton rdbtnNewRadioButton = new JRadioButton("1�� ����");
//        rdbtnNewRadioButton.setBounds(57, 55, 166, 41);
//        rdbtnNewRadioButton.setFocusPainted(false);
//        rdbtnNewRadioButton.setBorderPainted(false);
//        rdbtnNewRadioButton.setContentAreaFilled(false);
//        rdbtnNewRadioButton.setFont(new Font("Ƽ����_�װ�", Font.BOLD, 30));
//
//        add(rdbtnNewRadioButton);
//        
//        // 2번예약 부분에 정보불러오기 필요
//        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("2�� ����");
//        rdbtnNewRadioButton_1.setBounds(57, 224, 166, 41);
//        rdbtnNewRadioButton_1.setFocusPainted(false);
//        rdbtnNewRadioButton_1.setBorderPainted(false);
//        rdbtnNewRadioButton_1.setContentAreaFilled(false);
//        rdbtnNewRadioButton_1.setFont(new Font("Ƽ����_�װ�", Font.BOLD, 30));
//
//        add(rdbtnNewRadioButton_1);
//        
//        // 3번예약 부분에 정보불러오기 필요
//        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("3�� ����");
//        rdbtnNewRadioButton_2.setBounds(57, 407, 166, 41);
//        rdbtnNewRadioButton_2.setFocusPainted(false);
//        rdbtnNewRadioButton_2.setBorderPainted(false);
//        rdbtnNewRadioButton_2.setContentAreaFilled(false);
//        rdbtnNewRadioButton_2.setFont(new Font("Ƽ����_�װ�", Font.BOLD, 30));
//
//        add(rdbtnNewRadioButton_2);
//        
//
//        
//        rdbtnNewRadioButton.setSelected(false);
//        rdbtnNewRadioButton_1.setSelected(false);
//        rdbtnNewRadioButton_2.setSelected(false);
//
//        panel.setLayout(null);
//        panel.setBackground(new Color(255,0,0));
//        panel.setOpaque(false);
//        
	
		
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		   String s = e.getActionCommand();
           
           if(s.equals(cancel[0].getText())){
               JOptionPane.showMessageDialog(null,"선택 예약 : "+cancel[0].getText());
           }
           else if(s.equals(cancel[1].getText())){
               JOptionPane.showMessageDialog(null,"선택 예약 : "+cancel[1].getText());
           }
           else if(s.equals(cancel[2].getText())){
               JOptionPane.showMessageDialog(null,"선택 예약 : "+cancel[2].getText());
           }	

	}
	
}
	

