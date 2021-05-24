package main.pay.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class db {
	Connection conn;
	// MySql private information
	String jdbc = "jdbc:mysql://localhost:3306/data";
	String root = "root";
	String pwd = "dlrlwk86532@";

	public db() {

	}

	public void connectDB(String query) {

		try {
			conn = DriverManager.getConnection(jdbc, root, pwd);
			System.out.println("db 연결 성공");

			conn.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void insert(String id, String seat, String payT,String sTime, String uTime, String eTime, String product, String price,
			String payType) {
		String query = "insert into paydata value(\"" + id + "\",\"" + seat + "\",\""+payT +"\",\""+ sTime + "\",\"" + uTime
				+ "\",\"" + eTime + "\",\"" + product + "\",\"" + price + "\",\"" + payType + "\");";
		try {
			conn = DriverManager.getConnection(jdbc, root, pwd);
			System.out.println("db 연결 성공");

			Statement stat = conn.createStatement();
			stat.executeUpdate(query);

			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public ArrayList<String> select(String a, String tableName) {
		String query = "select " + a + " from " + tableName + ";";
		ResultSet rs;
		ArrayList<String> arr = new ArrayList<String>();
		try {
			conn = DriverManager.getConnection(jdbc, root, pwd);
			System.out.println("db 연결 성공");

			Statement stat = conn.createStatement();
			rs = stat.executeQuery(query);

			while (rs.next()) {
				arr.add(rs.getString(a));
			}

			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arr;
	}

	// column명 arr 반환
	public ArrayList<String> colLookUp(String tableName) {
		String query = "select * from " + tableName + ";";
		ResultSet rs;
		ResultSetMetaData rsmd;
		ArrayList<String> arr = new ArrayList<String>();
		try {
			conn = DriverManager.getConnection(jdbc, root, pwd);
			System.out.println("db 연결 성공");

			Statement stat = conn.createStatement();
			rs = stat.executeQuery(query);
			rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				arr.add(rsmd.getColumnName(i));
			}

			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arr;
	}
	
	public void dml(String query) {
		try {
			conn = DriverManager.getConnection(jdbc,root,pwd);
			System.out.println("db 연결 성공");
			Statement stat = conn.createStatement();
			stat.executeUpdate(query);

			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
	}
}
