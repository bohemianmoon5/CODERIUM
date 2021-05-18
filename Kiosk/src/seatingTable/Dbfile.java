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
			// 파일 객체 생성
			File file = new File("C:\\Users\\kosta\\Desktop\\CODERIUM\\CODERIUM\\Kiosk\\text\\" + f);
			//입력 스트림 생성
			FileReader filereader = new FileReader(file);
			// 입력 버퍼 생성
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufReader.readLine()) != null) {
				arr.add(line);
			}
			// .readLine()은 끝에 개행문자를 읽지 않는다.
			bufReader.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
