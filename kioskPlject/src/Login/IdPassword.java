package Login;

import java.util.HashMap;

public class IdPassword {
	
	HashMap<String, String> loginInfo = new HashMap<String, String>();

	IdPassword() {
		
		loginInfo.put("?λ¬Έμ€", "1234");
		loginInfo.put("? ??Έ", "2345");
		loginInfo.put("μ΅λ?Όκ·", "3456");
		loginInfo.put("?€μ§??", "4567");
		
	}
	
	protected HashMap getLoginInfo() {
		return loginInfo;
	}
	
}
