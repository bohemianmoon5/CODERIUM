package test;

public class Main {

	public static void main(String[] args) {
		
		IdPassword idPassword = new IdPassword();
		
		swing_LoginPage loginPage = new swing_LoginPage(idPassword.getLoginInfo());

	}

}
