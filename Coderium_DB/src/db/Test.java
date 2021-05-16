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
			System.out.println("org.sqlite.JDBC를 찾지 못했습니다.");
		}
		/* Program.class와 같은 디렉토리에 있는 test.db를 엽니다. */
		connection = DriverManager.getConnection("jdbc:sqlite:test");
		// 연결 성공했을 때, connection으로부터 statemet 인스턴스를 얻습니다. 여기서 sql구문을 엽니다. */
		statement = connection.createStatement();
		System.out.println("연결");
		ResultSet resultSet = statement.executeQuery("select * from table1;");
		statement.executeUpdate("insert into table1(Id,Pw) values('hoho', 1234)");
	}
}
