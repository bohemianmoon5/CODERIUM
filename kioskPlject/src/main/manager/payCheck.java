package main.manager;

import java.util.ArrayList;

import main.pay.readFile;

public class payCheck {
	ArrayList<String> readData = new ArrayList<String>();
	ArrayList<String[]> modifyData = new ArrayList<String[]>();

	public payCheck() {

	}

	public void reFunc() {
		readFile a = new readFile("done");
		readData = a.readFileFunc(readData);
	}

	public void modiFunc() {
		reFunc();
		for (int i = 0; i < readData.size(); i++) {
			modifyData.add(readData.get(i).split("/"));
		}
	}

	public void modiFucnc2() {
		for (int i = 0; i < modifyData.size(); i++) {
			for (int j = 0; j < modifyData.get(i).length; j++) {
				System.out.println(modifyData.get(i)[j].split(": ")[1]);
			}
		}
	}
}
