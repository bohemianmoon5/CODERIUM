package main.pay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class modiData {
	public modiData() {
	}
	// ���۽ð�~���ð��� ���� �������� �ð� ���� ����
	
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
		String a = start();
		String form = "yyyy/MM/dd/HH:mm";
		SimpleDateFormat s = new SimpleDateFormat(form);
		Date now= new Date();
		if (product.contains("�ð�")) {
			try {
				now = s.parse(a);		
				int productTime = Integer.parseInt(product.substring(0, product.length() - 2));
				Calendar c = Calendar.getInstance();
				c.setTime(now);
				c.add(Calendar.HOUR, productTime);
				String format = "YYYY/MM/dd/HH:mm";
				SimpleDateFormat sd = new SimpleDateFormat(format);
				String end = sd.format(c.getTime());
				formatTime = end;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			try {
				now = s.parse(a);		
				int productDay = Integer.parseInt(product.substring(0, product.length() - 2));
				Calendar c = Calendar.getInstance();
				c.setTime(now);
				c.add(Calendar.DATE, productDay*7);
				String format = "YYYY/MM/dd/HH:mm";
				SimpleDateFormat sd = new SimpleDateFormat(format);
				String end = sd.format(c.getTime());
				formatTime = end;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
