package banking;

import java.util.Random;

public class Bank {
	private int totalAmount;
	private boolean available = true;

	public void pay(String client, int amount) throws InterruptedException {
		synchronized (this) {
			while (!available) {
				System.out.println("\nClient: " + client + " is waiting for his turn");
				wait();
			}
			available = false;
			totalAmount += amount;
		}

		System.out.println("\nClient: " + client + " is approaching the counter.");
		Thread.sleep(new Random().nextInt(5000));

		synchronized (this) {
			System.out.println("\nClient: " + client + " paid the following amount: " + amount + "\n");
			notify();
			available = true;
		}
	}

	public int getBankFunds() {
		return totalAmount;
	}
}
