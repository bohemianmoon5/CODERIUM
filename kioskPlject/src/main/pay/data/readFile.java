package main.pay.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

// ���� �о���� Ŭ����
public class readFile {
	String title="";
	public readFile() {
		
	}
	public readFile( String title) {
		this.title=title;
	}
	
	// ���� �о�� arrayList�� ������ �� arrayList ��ȯ�ϴ� �Լ�
	public ArrayList<String> readFileFunc(ArrayList<String> arr) {
		String path = "./src/data";
		File file = new File(path+"\\"+title+".txt");
		String str = "";
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			while ((str = br.readLine()) != null) {
				arr.add(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
}
