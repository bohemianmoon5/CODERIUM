package main.manager;

import java.util.ArrayList;

import main.pay.data.db;

public class payCheck {
	ArrayList<String> data = new ArrayList<String>(); 
	db d = new db();
	
	public payCheck() {
		data = chk("id","paydata");
	}
	public payCheck(String str) {
		data = chk(str,"paydata");
		for(int i=0; i<data.size(); i++) {
			System.out.println(data.get(i));
		}
	}

	public ArrayList<String> chk(String tableName) {
		return d.colLookUp(tableName);
	}
	public ArrayList<String> chk(String str,String tableName) {
		return d.select(str,tableName);
	}
	
}
