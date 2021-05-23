package main.pay;

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

	public storeData(String seat, String payT,String sTime, String uTime,String eTime, 
			String product, String price, String type) {
		this.seat = seat;
		this.payT=payT;
		this.sTime = sTime;
		this.uTime = uTime;
		this.eTime = eTime;
		this.product = product;
		this.price = price;
		this.type = type;
	}
	
	public void store() {
		db newD = new db();		
		newD.insert("¿ÀÁö¼ö",seat,payT ,sTime, uTime, eTime, product, price, type);
	}

}
