package Login;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Function;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUpDAO {
	
	String data = null;
	SignUpDTO signUp = new SignUpDTO();
	
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String SetSignUp() {
		data = signUp.getId() + ", " + signUp.getPw() + ", " + signUp.getName() + ", " + signUp.getGender() + ", " 
				+ signUp.getIdNum() + ", " + signUp.getPhoneNum() + ", " + signUp.getWord();
		
		return data;
	}
	
	public int SignUpDAO() {
		String sql = "INSERT INTO list VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registerInfo?autoReconnect=true&useSSL=false", "root", "root");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, signUp.getId());
			pstmt.setString(2, signUp.getPw());
			pstmt.setString(3, signUp.getName());
			pstmt.setString(4, signUp.getGender());
			pstmt.setString(5, signUp.getIdNum());
			pstmt.setString(6, signUp.getPhoneNum());
			pstmt.setString(7, signUp.getWord());
			return pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류
	}
	
	public boolean IdCheck(String id) {
        boolean result = true;
 
        try {
            pstmt = con.prepareStatement("SELECT * FROM list WHERE id=?");
            pstmt.setString(1, id.trim());
            rs = pstmt.executeQuery(); //실행
            if (rs.next())
                result = false; //레코드가 존재하면 false
 
        } catch (SQLException e) {
            System.out.println(e + "=>  IdCheck fail");
        } finally {
            dbClose();
        }
 
        return result;
 
    }
	
	public void dbClose() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (pstmt != null) pstmt.close();
        } catch (Exception e) {
            System.out.println(e + "=> dbClose fail");
        }
    }
}
	
