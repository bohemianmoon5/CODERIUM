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

	private String font = "twayair";
	JRadioButton check[] = new JRadioButton[3];
	String check_name[] = {"1.","2.","3."};
//	JRadioButton rdbtnNewRadioButton = new JRadioButton();
//	JRadioButton rdbtnNewRadioButton_1 = new JRadioButton();
//	JRadioButton rdbtnNewRadioButton_2 = new JRadioButton();

	
	public selectRe(JPanel panel) {
		setLayout(null);
		
		ButtonGroup group = new ButtonGroup();
        for(int i=0; i<3; i++){
        	check[i] = new JRadioButton(check_name[i]);
        	if(check_name[i] == null)
        		continue;
             group.add(check[i]);
             check[i].addActionListener(this);
             check[i].setBounds(57, 55, 166, 41);
             check[i].setFocusPainted(false);
             check[i].setBorderPainted(false);
             check[i].setContentAreaFilled(false);
             check[i].setFont(new Font("twayair", Font.BOLD, 30));
             if(check[i] == check[0]) { 
            	 check[i].setBounds(57, 55, 166, 41);
             }else if(check[i] == check[1]) { 
            	 check[i].setBounds(57, 225, 166, 41);
             }else if(check[i] == check[2]) {
            	 check[i].setBounds(57, 410, 166, 41);
             }
        	

           add(check[i]);
             
        }
        
        check[0].setSelected(false);
        check[1].setSelected(true);
        
        
        setSize(252, 496);
        
        //DB ���� Ŭ���� �ҷ���
//        dbconnect();
        
      

        
//        JRadioButton selectRe = new JRadioButton();
//        for (int i = 1; i < 4; i++) {
//            rdbtnNewRadioButton.setBounds(57, 55, 166, 41);
//            rdbtnNewRadioButton.setFocusPainted(false);
//            rdbtnNewRadioButton.setBorderPainted(false);
//            rdbtnNewRadioButton.setContentAreaFilled(false);
//            rdbtnNewRadioButton.setFont(new Font("Ƽ����_�װ�", Font.BOLD, 30));
//
//            add(rdbtnNewRadioButton);
//			
//		}
//        
//        
//        // 1������ �κп� �����ҷ����� �ʿ�
//        JRadioButton rdbtnNewRadioButton = new JRadioButton("1�� ����");
//        rdbtnNewRadioButton.setBounds(57, 55, 166, 41);
//        rdbtnNewRadioButton.setFocusPainted(false);
//        rdbtnNewRadioButton.setBorderPainted(false);
//        rdbtnNewRadioButton.setContentAreaFilled(false);
//        rdbtnNewRadioButton.setFont(new Font("Ƽ����_�װ�", Font.BOLD, 30));
//
//        add(rdbtnNewRadioButton);
//        
//        // 2������ �κп� �����ҷ����� �ʿ�
//        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("2�� ����");
//        rdbtnNewRadioButton_1.setBounds(57, 224, 166, 41);
//        rdbtnNewRadioButton_1.setFocusPainted(false);
//        rdbtnNewRadioButton_1.setBorderPainted(false);
//        rdbtnNewRadioButton_1.setContentAreaFilled(false);
//        rdbtnNewRadioButton_1.setFont(new Font("Ƽ����_�װ�", Font.BOLD, 30));
//
//        add(rdbtnNewRadioButton_1);
//        
//        // 3������ �κп� �����ҷ����� �ʿ�
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
//               JOptionPane.showMessageDialog(null,"���� ���� : "+rdbtnNewRadioButton.getText());
//           }
//           else if(s.equals(rdbtnNewRadioButton_1.getText())){
//               JOptionPane.showMessageDialog(null,"���� ���� : "+rdbtnNewRadioButton_1.getText());
//           }
//           else if(s.equals(rdbtnNewRadioButton_2.getText())){
//               JOptionPane.showMessageDialog(null,"���� ���� : "+rdbtnNewRadioButton_2.getText());
//           }	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	

