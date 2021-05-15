package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLite3 {
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	//초기 드라이버 한번 로드
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		}catch(Exception e) {e.printStackTrace();
		
		}
	}
	
	public SQLite3() {
		
	}
	
	//데이터베이스 연결 메소드
	public boolean dbConnect() {
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:resource/db.sqlite");//jdbc:sqlite:폴!
			stmt = conn.createStatement();
		}catch(Exception e) {
			System.err.println(e.getClass()+":"+e.getMessage());
			return false;
		}
		return true;
	}
	
	//update, insert, delete 퀴리 수행
	public void setQuery(String query) {
		try {
			stmt.executeUpdate(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//select 특정 레코드 받아오기
	public ArrayList<Datainfo> getSearchQuery(String query) {
		ArrayList<Datainfo> data = new ArrayList<Datainfo>();
		
		try {
			
			rs = stmt.executeQuery(query);
			
			Datainfo info = new Datainfo();
			// 회원db
			info.setId(rs.getString("Id"));
			info.setPw(rs.getInt("pw"));
			info.setName(rs.getString("name"));
			info.setGender(rs.getString("gender"));
			info.setBirth(rs.getString("birth"));
			info.setMobile(rs.getString("mobile"));
			info.setDream(rs.getString("dream"));
			
			//예약 db
//			info.setR_start(rs.getString("r_start"));
//			info.setR_use(rs.getString("r_use"));
//			info.setR_end(rs.getString("r_end"));
//			info.setSeat(rs.getString("seat"));
//			
//			//결제 db
//			info.setStart(rs.getString("start"));
//			info.setUse(rs.getString("use"));
//			info.setUse(rs.getString("end"));
//			info.setPi(rs.getString("pi"));
//			info.setPm(rs.getString("pm"));
//			info.setAp(rs.getInt("ap"));
			
			
			data.add(info);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return data;
	}

}

