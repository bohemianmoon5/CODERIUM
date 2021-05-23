package main.pay;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class product {
	JPanel panel;
	JLabel name;
	JLabel price;
	JCheckBox chk;
	String font = "";
	ArrayList<String> nameArr = new ArrayList<String>();
	ArrayList<String> priceArr = new ArrayList<String>();
	int y=10;
	db d = new db();
	
	public product() {
		
	}
	public product(JPanel panel) {
		this.panel=panel;
	}
	public product(String tableName) {
		nameArr=chk("productName",tableName);
		priceArr=chk("price",tableName);
	}

	public product(JPanel panel, String font,String tableName) {
		this.panel = panel;
		this.font = font;
		nameArr=chk("productName",tableName);
		priceArr=chk("price",tableName);
	}
	
	public ArrayList<String> chk(String str,String tableName) {
		return d.select(str,tableName);
	}
	
	public void createTitle(String str) {
		JLabel title = new JLabel(str);
		title.setFont(new Font(font, Font.BOLD, 18));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(246, 22, 150, 30);
		panel.add(title);
	}
	
	public String createName(int i) {
		JLabel name = new JLabel("");
		name.setText(nameArr.get(i));
		name.setFont(new Font(font, Font.PLAIN, 18));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(20, y+(30*i), 56, 30);
		panel.add(name);
		return nameArr.get(i);
	}
	
	
	public String createPrice(int i) {
		JLabel price = new JLabel("");
		price.setText(priceArr.get(i));
		price.setFont(new Font(font, Font.PLAIN, 18));
		price.setHorizontalAlignment(SwingConstants.CENTER);
		price.setBounds(80, y+(30*i), 120, 30);
		panel.add(price);
		return priceArr.get(i);
	}

	public JCheckBox chkBox(int i) {
		JCheckBox chk = new JCheckBox("");
		chk.setBounds(200, y+(30*i), 21, 23);
		panel.add(chk);
		return chk;
	}


}
