package main.pay;

import java.text.SimpleDateFormat;
import java.util.Date;

public class modiData {
	public modiData() {

	}

	// ���۽ð�~���ð��� ���� �������� �ð� ���� ����
	// ++Date�� ���� ���� �����ؾ� ��
	// ++Ŭ������ �����ϱ�
	
	//���� �ð� ��ȯ
	public String start() {
		Date date = new Date();
		String format = "YYYY/MM/dd/HH:mm";
		SimpleDateFormat sd = new SimpleDateFormat(format);
		String now = sd.format(date.getTime());

		return now;
	}

	// �� �ð� ��ȯ
	public String end(String product) {
		String formatTime = "";
		Date date = new Date();

		if (product.contains("�ð�")) {
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

	// ��� �ð� ��ȯ
	public String use(String product) {
		String use = "";
		if (product.contains("�ð�")) {
			use = product.substring(0, product.length() - 2);
		} else {
			String tmp = product.substring(0, product.length() - 2);
			use = Integer.parseInt(tmp) * 7 * 24 + "";
		}
		return use;
	}

	// ��ǰ�� ��ȯ
	public String modiPro(String product) {
		String pro = "";
		if (product.contains("�ð�")) {
			pro = product.substring(0, product.length() - 2) + "hours";
		} else {
			String tmp = product.substring(0, product.length() - 2);
			pro = Integer.parseInt(tmp) * 7 + "days";
		}
		return pro;
	}

	// ���� ��ȯ
	public String modiPri(String price) {
		String pri = "";
		if (price.contains("��")) {
			pri = price.substring(0, price.length() - 1) + "won";
		}
		return pri;
	}
}
