package seatingTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Dbfile {
	Connection conn;
	String jdbc = "jdbc:mysql://localhost:3306/coderium";
	String root = "root";
//	String pwd = "1234";
	String pwd = "1234";
	
	public Dbfile() {
		
	}
	
	public void connectDB() {
		try {
			conn = DriverManager.getConnection(jdbc, root, pwd);
			System.out.println("db ���� ����");
			
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
	}
	
	public void dml(String query) {
		try {
			conn = DriverManager.getConnection(jdbc,root,pwd);
			System.out.println("db ���� ����");

			Statement stat = conn.createStatement();
			stat.executeUpdate(query);

			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
	}
	//�¼� db�θ��� select
	public ArrayList<String> select(String a, String query1) {
		String query = query1;	
		ResultSet rs;
		ArrayList<String> seat = new ArrayList<String>();
		try {
			conn = DriverManager.getConnection(jdbc,root,pwd);
			System.out.println("db ���� ����");

			Statement stat = conn.createStatement();
			rs = stat.executeQuery(query);
			while (rs.next()) {
				seat.add(rs.getString(a));
			}

			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return seat;
	}
	//start �ð� �θ��� select
	public ArrayList<String> t_select(String a, String query1) {
		String query = query1;	
		ResultSet rs;
		ArrayList<String> start = new ArrayList<String>();
		try {
			conn = DriverManager.getConnection(jdbc,root,pwd);
			System.out.println("db ���� ����");

			Statement stat = conn.createStatement();
			rs = stat.executeQuery(query);
			while (rs.next()) {
				start.add(rs.getString(a));
			}

			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return start;
	}
	//���� �ð�!
	public ArrayList<String> r_select(String a, String tableName) {
		String query = "select * from "+ tableName +";";	
		ResultSet rs;
		ArrayList<String> r_start = new ArrayList<String>();
		try {
			conn = DriverManager.getConnection(jdbc,root,pwd);
			System.out.println("db ���� ����");

			Statement stat = conn.createStatement();
			rs = stat.executeQuery(query);
			while (rs.next()) {
				r_start.add(rs.getString(a));
			}

			stat.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return r_start;
	}
}
