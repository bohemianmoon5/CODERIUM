package com.reservation;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Font;

public class selectMenu extends JPanel{

//	String[] fruits={"apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry"};
    String[] name={"1�ð� 1000��", "2�ð� 2000��", "3�ð� 3000��", "4�ð� 4000��"};
    selectMenu(JPanel panel){
        setLayout(null);
//        this.setTitle("�޺��ڽ� ����� ����");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
//        JComboBox strCombo= new JComboBox(fruits);
//        this.add(strCombo);
        
        JComboBox nameCombo = new JComboBox(name);
        nameCombo.setFont(new Font("Ƽ����_�װ�", Font.BOLD, 20));
        nameCombo.setBounds(119, 5, 153, 45);
        this.add(nameCombo);
        
//        nameCombo.setPreferredSize(new Dimension(20,20));
//        nameCombo.setSize();
        
//        this.setLocationRelativeTo(null);
//        this.setSize(300,300);
//        this.setVisible(true);
    }



}
