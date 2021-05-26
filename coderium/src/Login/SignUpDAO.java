package Login;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignUpDAO {
	
	String data = null;
	SignUpDTO signUp = new SignUpDTO();
	
	String SetSignUp() {
		data = signUp.getId() + ", " + signUp.getPw() + ", " + signUp.getName() + ", " + signUp.getGender() + ", " 
				+ signUp.getIdNum() + ", " + signUp.getPhoneNum() + ", " + signUp.getWord();
		
		return data;
	}
	
}
	
