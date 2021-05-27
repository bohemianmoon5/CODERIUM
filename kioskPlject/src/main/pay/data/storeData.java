package main.pay.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class storeData {
	String seat;
	String payT;
	String sTime;
	String uTime;
	String eTime;
	String product;
	String price;
	String type;
	String menuType;

	public storeData(String seat, String payT,String sTime, String uTime,String eTime, 
			String product, String price, String type,String menuType) {
		this.seat = seat;
		this.payT=payT;
		this.sTime = sTime;
		this.uTime = uTime;
		this.eTime = eTime;
		this.product = product;
		this.price = price;
		this.type = type;
		this.menuType = menuType;
	}
	
	public void store() {
		db newD = new db();		
		newD.insert("jisu",seat,payT ,sTime, uTime, eTime, product, price, type,menuType);
	}

}
