package Login;

import java.util.HashMap;

public class IdPassword {
	
	HashMap<String, String> loginInfo = new HashMap<String, String>();

	IdPassword() {
		
		loginInfo.put("나문오", "1234");
		loginInfo.put("정원호", "2345");
		loginInfo.put("최민규", "3456");
		loginInfo.put("오지수", "4567");
		
	}
	
	protected HashMap getLoginInfo() {
		return loginInfo;
	}
	
}
