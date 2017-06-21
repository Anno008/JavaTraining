package banking;

public class Client extends Thread{
	private String name;
	private Bank bank;
	private int amount;
	
	public Client(String name, Bank bank, int amount){
		this.name = name;
		this.bank = bank;
		this.amount = amount;
	}
	
	public String getClientName(){
		return name;
	}
	
	public int getAmount(){
		return amount;
	}
	
	@Override
	public void run(){
		try {
			System.out.println("Client: " + name + " wants to pay the following amount: " + amount);
			bank.pay(name,amount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
