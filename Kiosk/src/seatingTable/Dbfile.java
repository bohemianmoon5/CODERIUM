package seatingTable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dbfile {
	ArrayList<String> arr = new ArrayList<String>();
	public Dbfile() {

	}
	
	public Dbfile(String f) {
		
		try {
			// ���� ��ü ����
			File file = new File("C:\\Users\\kosta\\Desktop\\CODERIUM\\CODERIUM\\Kiosk\\text\\" + f);
			//�Է� ��Ʈ�� ����
			FileReader filereader = new FileReader(file);
			// �Է� ���� ����
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufReader.readLine()) != null) {
				arr.add(line);
			}
			// .readLine()�� ���� ���๮�ڸ� ���� �ʴ´�.
			bufReader.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
