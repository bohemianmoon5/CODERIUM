package main.pay.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class storeData {
	String id;
	String seat;
	String payT;
	String sTime;
	String eTime;
	String product;
	String price;
	String type;
	String menuType;

	public storeData(String id,String seat, String payT,String sTime,String eTime, 
			String product, String price, String type,String menuType) {
		this.id=id;
		this.seat = seat;
		this.payT=payT;
		this.sTime = sTime;
		this.eTime = eTime;
		this.product = product;
		this.price = price;
		this.type = type;
		this.menuType = menuType;
	}
	
	public void store() {
		db newD = new db();		
		newD.insert(id,seat,payT ,sTime, eTime, product, price, type,menuType);
	}

}
