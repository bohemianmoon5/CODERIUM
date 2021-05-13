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
	ArrayList<String> arr = new ArrayList<String>();

	int y=73;

	public product() {
		readFile rf = new readFile("product");
		rf.readFileFunc(arr);
	}

	public product(JPanel panel, JLabel name, JLabel price, 
			JCheckBox chk, String font) {
		this.panel = panel;
		this.name = name;
		this.price = price;
		this.chk = chk;
		this.font = font;
		
		readFile rf = new readFile("product");
		rf.readFileFunc(arr);
	}
	
	public String createName(int i) {
		name.setText(arr.get(i).split(" ")[0]);
		name.setFont(new Font(font, Font.PLAIN, 18));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(22, y+(30*i), 56, 30);
		panel.add(name);
		return arr.get(i).split(" ")[0];
	}

	public String createPrice(int i) {
		price.setText(arr.get(i).split(" ")[1]);
		price.setFont(new Font(font, Font.PLAIN, 18));
		price.setHorizontalAlignment(SwingConstants.CENTER);
		price.setBounds(90, y+(30*i), 120, 30);
		panel.add(price);
		return arr.get(i).split(" ")[1];
	}

	public JCheckBox chkBox(int i) {
		chk.setBounds(220, y+(30*i), 21, 23);
		panel.add(chk);
		return chk;
	}


}
