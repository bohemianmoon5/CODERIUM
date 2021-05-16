package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
	
	public static void main(String[] args)throws Exception{
		
		Connection connection  = null;
		Statement statement = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
		}
		catch(ClassNotFoundException e) {
			System.out.println("org.sqlite.JDBC�� ã�� ���߽��ϴ�.");
		}
		/* Program.class�� ���� ���丮�� �ִ� test.db�� ���ϴ�. */
		connection = DriverManager.getConnection("jdbc:sqlite:test");
		// ���� �������� ��, connection���κ��� statemet �ν��Ͻ��� ����ϴ�. ���⼭ sql������ ���ϴ�. */
		statement = connection.createStatement();
		System.out.println("����");
		ResultSet resultSet = statement.executeQuery("select * from table1;");
		statement.executeUpdate("insert into table1(Id,Pw) values('hoho', 1234)");
	}
}
