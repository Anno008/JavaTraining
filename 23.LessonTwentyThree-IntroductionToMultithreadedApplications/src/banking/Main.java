package banking;

import java.util.Vector;

public class Main {
	public static void main(String[] args) throws InterruptedException{
		Bank bank = new Bank();
		Vector<Client> clients = new Vector<Client>();
		clients.add(new Client("Jhon",bank,246));
		clients.add(new Client("Wendy",bank,377));
		clients.add(new Client("Tom",bank,35));
		clients.add(new Client("Bob",bank,124));
		clients.add(new Client("Perry",bank,783));
		clients.add(new Client("Mith",bank,553));

		for (Client client : clients) {
			client.start();
		}
		
	}
}
