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
			// ++�̸��� �ӽ�- �α��ε� ȸ�� ������ �����ؾ���
			fw.write("�̸�: ������" + "/�ð�: " + time + "/�¼�: " + seat + "/��ǰ: " + product + "/����: " + price + "/���� ���� : "
					+ type +"\n");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
