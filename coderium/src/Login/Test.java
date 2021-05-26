package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Test() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/registerInfo?autoReconnect=true&useSSL=false";
			String dbID = "root";
			String dbPassword = "root";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int login(String userID, String userPassword) {
		String SQL = "SELECT Pw FROM registerInfo.list WHERE Id = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).contentEquals(userPassword)) {
					return 1;
				}
				else
					return 0;
			}
			return -1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2;
	}
}
