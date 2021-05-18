package main.pay;

import java.text.SimpleDateFormat;
import java.util.Date;

public class modiData {
	public modiData() {

	}

	// 시작시간~끝시간에 대한 보여지는 시간 형식 지정
	// ++Date에 관한 윤년 적용해야 함
	// ++클래스로 변경하기
	
	//현재 시간 반환
	public String start() {
		Date date = new Date();
		String format = "YYYY/MM/dd/HH:mm";
		SimpleDateFormat sd = new SimpleDateFormat(format);
		String now = sd.format(date.getTime());

		return now;
	}

	// 끝 시간 반환
	public String end(String product) {
		String formatTime = "";
		Date date = new Date();

		if (product.contains("시간")) {
			int productTime = Integer.parseInt(product.substring(0, product.length() - 2));
			int temp = date.getHours() + productTime;
			String endHour = temp >= 24 ? "0" + Integer.toString(temp - 24) : temp + "";
			String format = "YYYY/MM/dd/" + endHour + ":mm";
			SimpleDateFormat sd = new SimpleDateFormat(format);
			String end = sd.format(date.getTime());

			formatTime = end;
		} else {
			int productDay = Integer.parseInt(product.substring(0, product.length() - 2));
			int temp = date.getDate() + productDay * 7;
			String endDay = Integer.toString(temp);
			String format = "YYYY/MM/" + endDay + "/HH:mm";
			SimpleDateFormat sd = new SimpleDateFormat(format);
			String end = sd.format(date.getTime());

			formatTime = end;
		}
		return formatTime;
	}

	// 사용 시간 반환
	public String use(String product) {
		String use = "";
		if (product.contains("시간")) {
			use = product.substring(0, product.length() - 2);
		} else {
			String tmp = product.substring(0, product.length() - 2);
			use = Integer.parseInt(tmp) * 7 * 24 + "";
		}
		return use;
	}

	// 상품명 반환
	public String modiPro(String product) {
		String pro = "";
		if (product.contains("시간")) {
			pro = product.substring(0, product.length() - 2) + "hours";
		} else {
			String tmp = product.substring(0, product.length() - 2);
			pro = Integer.parseInt(tmp) * 7 + "days";
		}
		return pro;
	}

	// 가격 반환
	public String modiPri(String price) {
		String pri = "";
		if (price.contains("원")) {
			pri = price.substring(0, price.length() - 1) + "won";
		}
		return pri;
	}
}
