package com.reservation;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Font;

public class selectMenu extends JPanel{

//	String[] fruits={"apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry"};
    String[] name={"1시간 1000원", "2시간 2000원", "3시간 3000원", "4시간 4000원"};
    selectMenu(JPanel panel){
        setLayout(null);
//        this.setTitle("콤보박스 만들기 예제");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
//        JComboBox strCombo= new JComboBox(fruits);
//        this.add(strCombo);
        
        JComboBox nameCombo = new JComboBox(name);
        nameCombo.setFont(new Font("티웨이_항공", Font.BOLD, 20));
        nameCombo.setBounds(119, 5, 153, 45);
        this.add(nameCombo);
        
//        nameCombo.setPreferredSize(new Dimension(20,20));
//        nameCombo.setSize();
        
//        this.setLocationRelativeTo(null);
//        this.setSize(300,300);
//        this.setVisible(true);
    }



}
