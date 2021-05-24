package com.reservation;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import main.pay.data.reservData;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class selectMenu extends JPanel implements ActionListener {
	JComboBox nameCombo;
	// ++js modify
	String stdDate = "";
	String price = "";
	String prodName = "";
	// ++
//	String[] fruits={"apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry"};
	String[] name = { "1시간 1000원", "2시간 2000원", "3시간 3000원", "4시간 4000원" };

	selectMenu(JPanel panel, /* js modify */String stdDate) {
		setLayout(null);
		this.stdDate = stdDate;
//        this.setTitle("�޺��ڽ� ����� ����");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        JComboBox strCombo= new JComboBox(fruits);
//        this.add(strCombo);

		nameCombo = new JComboBox(name);
		nameCombo.setFont(new Font("티웨이_항공", Font.BOLD, 20));
		nameCombo.setBounds(119, 5, 153, 45);
		// ++js modify
		nameCombo.setSelectedItem(name[0]);
		nameCombo.addActionListener(this);
		// ++
		this.add(nameCombo);

		// ++js modify
		String prod = nameCombo.getSelectedItem().toString();
		reservData rd = new reservData(stdDate, prod);
		rd.modiProd();
		prodName = rd.getProd();
		price = rd.getPrice();
		// ++
//        nameCombo.setPreferredSize(new Dimension(20,20));
//        nameCombo.setSize();

//        this.setLocationRelativeTo(null);
//        this.setSize(300,300);
//        this.setVisible(true);
	}

	// ++js modify
	@Override
	public void actionPerformed(ActionEvent e) {
		String prod = nameCombo.getSelectedItem().toString();
		reservData rd = new reservData(stdDate, prod);
		rd.modiProd();
		prodName = rd.getProd();
		price = rd.getPrice();
	}
	// ++

}
