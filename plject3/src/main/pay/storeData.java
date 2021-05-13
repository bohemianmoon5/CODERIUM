package main.pay;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class storeData {
	String seat;
	String product;
	String price;
	String time;
	String type;

	public storeData(String seat, String time, String product, String price, String type) {
		this.seat = seat;
		this.time = time;
		this.product = product;
		this.price = price;
		this.type = type;
	}

	public void store() {
		String path = "./src/data";
		File file = new File(path);
		try {
			FileWriter fw = new FileWriter(file + "/done.txt", true);
			// ++이름은 임시- 로그인된 회원 정보로 변경해야함
			fw.write("이름: 오지수" + "/시간: " + time + "/좌석: " + seat + "/상품: " + product + "/가격: " + price + "/결제 수단 : "
					+ type +"\n");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
