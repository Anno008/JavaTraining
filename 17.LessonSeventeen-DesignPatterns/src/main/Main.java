package main;

import management.Management;

public class Main {

	public static void main(String[] args) {
		Management mng = Management.getInstance();
		mng.start();
	}
}
