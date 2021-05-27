package main.manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JPanel;

public class payCheckWindow {

	private JFrame frame;
	private JTable table;
	private JScrollPane scroll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payCheckWindow window = new payCheckWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public payCheckWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 43, 680, 870);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		String[] colTitle= {"이름","결제시간","좌석","상품","가격","결제수단"};

		payCheck pc = new payCheck();
		pc.modiFunc();
		pc.modiFucnc2();
		String[][] row= new String[pc.modifyData.size()][6];
		for(int i=0; i<pc.modifyData.size(); i++) {
			for(int j=0; j<pc.modifyData.get(i).length; j++) {
				row[i][j]=pc.modifyData.get(i)[j].split(": ")[1];
			}
		}
		
		String temp="";
		
		for(int i=0; i<row.length; i++) {
			for(int j=0; j<row[i].length; j++) {
				if(row[i][j].contains("년")) {
					temp=row[i][j].split(" ~ ")[0];
				}
			}
		}
		
		StringBuffer temp2=new StringBuffer();
		temp2.append(temp.replaceAll("[^0-9]",""));
		for(int i=0; i<temp2.length(); i++) {
			if(i==4 || i==7 || i==10 ) {
				temp2 = temp2.insert(i, "/");				
			}else if(i==13) {
				temp2 = temp2.insert(i, ":");
			}
		}
//		temp2 = temp2.insert(4,"/");
		System.out.println(temp2);
		
		for(int i=0; i<row.length; i++) {
			for(int j=0; j<row[i].length; j++) {
				if(row[i][j].contains("년")) {
					row[i][j]=temp2.toString();
				}
			}
		}
		
		DefaultTableModel model = new DefaultTableModel(row,colTitle);
//		model.setHorizontalAlignment(SwingConstants.CENTER);

		table = new JTable(model);
		table.setAlignmentX(SwingConstants.CENTER);
		table.setBounds(30, 57, 615, 854);
		table.setLayout(null);
		panel.add(table);
		scroll=new JScrollPane(table);
		scroll.setLocation(0, 10);
		scroll.setSize(680,850);
		panel.add(scroll);
		
		
	}
}
