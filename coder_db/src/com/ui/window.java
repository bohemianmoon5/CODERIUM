package com.ui;

import java.util.ArrayList;

import com.db.Datainfo;
import com.db.SQLite3;

public class window {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		SQLite3 db = new SQLite3();
		
		if(db.dbConnect() == true) {
//			db.setQuery("INSERT INTO 'member' ('id', 'pw', 'name', 'gender', 'birth', 'mobile', 'dream') VALUES ('jisoo26', 4321, '오지수', 'male', '19960303', '01095462135',"
//					+ "'프로그래머')");
//			db.setQuery("INSERT INTO 'index' ('id', 'name', 'book_code') VALUES (NULL, '해리포터와 혼혈왕자', 'KOR0001')");
			
			
			ArrayList<Datainfo> data = db.getSearchQuery("SELECT * FROM 'member'");
			System.out.println(data.size());
			System.out.println(data.get(0).getId() + "/" + data.get(0).getMobile());
//			
		}
		
		
	}

}
/*
예약db 폼은 
아이디, 시작시간, 사용시간, 끝나는시간, 좌석번호
결제db 폼은
아이디, 좌석번호, 시작시간, 사용시간, 끝나는시간, 선택한 상품정보, 결제방법, 결제금액
정도면 될까요???
pi => 상품정보, pm=> 결제방법, ap =>결제금액
*/