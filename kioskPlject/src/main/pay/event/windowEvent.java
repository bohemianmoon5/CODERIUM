package main.pay.event;

import java.awt.Component;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class windowEvent {
	JFrame f;
	public static Component[] com;
	public windowEvent(JFrame f) {
		this.f=f;
	}
	
	public static void setComponent(Component[] c) {
		com=c;
	}
	
	public void event() {
//		System.out.println("c������ "+c.length);
		f.addWindowListener(new WindowListener() {
			@Override
			// ������ ó�� �����Ǿ��� ��
			public void windowOpened(WindowEvent e) {
			}

			@Override
			// ������ �ý��� �޴��� �ݱ� �õ��� ��
			public void windowClosing(WindowEvent e) {
			}

			@Override
			// �����찡 ���� ��
			// ���� â�� ������ main �гο� �ִ� �ڽ� component Ȱ��ȭ
			public void windowClosed(WindowEvent e) {
				System.out.println("������");
				for (int i = 0; i < com.length; i++) {
					com[i].setEnabled(true);
				}
			}

			@Override
			// �����찡 �ּ�ȭ �Ǿ��� ��
			public void windowIconified(WindowEvent e) {
			}

			@Override
			// �����찡 �ּ�ȭ���� �ִ�ȭ �Ǿ��� ��
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			// �����찡 Ȱ��ȭ �Ǿ��� ��
			public void windowActivated(WindowEvent e) {
			}

			@Override
			// �����찡 ��Ȱ��ȭ �Ǿ��� ��
			public void windowDeactivated(WindowEvent e) {
			}
		});
	}
}
