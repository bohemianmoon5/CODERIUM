package com.ui;

import java.util.ArrayList;

import com.db.Datainfo;
import com.db.SQLite3;

public class window {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		SQLite3 db = new SQLite3();
		
		if(db.dbConnect() == true) {
//			db.setQuery("INSERT INTO 'member' ('id', 'pw', 'name', 'gender', 'birth', 'mobile', 'dream') VALUES ('jisoo26', 4321, '������', 'male', '19960303', '01095462135',"
//					+ "'���α׷���')");
//			db.setQuery("INSERT INTO 'index' ('id', 'name', 'book_code') VALUES (NULL, '�ظ����Ϳ� ȥ������', 'KOR0001')");
			
			
			ArrayList<Datainfo> data = db.getSearchQuery("SELECT * FROM 'member'");
			System.out.println(data.size());
			System.out.println(data.get(0).getId() + "/" + data.get(0).getMobile());
//			
		}
		
		
	}

}
/*
����db ���� 
���̵�, ���۽ð�, ���ð�, �����½ð�, �¼���ȣ
����db ����
���̵�, �¼���ȣ, ���۽ð�, ���ð�, �����½ð�, ������ ��ǰ����, �������, �����ݾ�
������ �ɱ��???
pi => ��ǰ����, pm=> �������, ap =>�����ݾ�
*/