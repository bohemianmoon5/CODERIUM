package com.reservation;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class selectMenu extends JPanel implements ActionListener{

//	String[] fruits={"apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry"};
//    String[] name={"1�ð� 1000��", "2�ð� 2000��", "3�ð� 3000��", "4�ð� 4000��"};
//	ArrayList<String> menuList = new ArrayList<String>();
	JComboBox<String> menuList = new JComboBox<String>();
	DefaultComboBoxModel<String> nameCombo = new DefaultComboBoxModel<String>();
    
	
	private String font = "Ƽ����_�װ�";
	
	public selectMenu(JPanel panel){
        setLayout(null);
//        this.setTitle("�޺��ڽ� ����� ����");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        JComboBox menu = new JComboBox();
//        menu.setModel(new DefaultComboBoxModel(menuList));
   
        menuList = new JComboBox();
        menuList.setModel(new DefaultComboBoxModel(new String[] {"1�ð� 1000��", "2�ð� 2000��", "3�ð� 3000��", "4�ð� 4000��"}));
        menuList.setFont(new Font("Ƽ����_�װ�", Font.BOLD, 20));
        menuList.setBounds(119, 5, 153, 45);
        add(menuList);
        
        menuList.setPreferredSize(new Dimension(20,20));
        
     
        
//        this.setLocationRelativeTo(null);
//        this.setSize(300,300);
//        this.setVisible(true);
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



}
