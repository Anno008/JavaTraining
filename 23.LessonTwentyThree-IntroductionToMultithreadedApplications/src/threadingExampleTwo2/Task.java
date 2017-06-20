package threadingExampleTwo2;

import java.util.Random;

public class Task extends Thread{
	private int[] array;
	private int sum;
	private String pseudoThreadName;
	
	public Task(String pseudoThreadName, int[] array){
		this.pseudoThreadName = pseudoThreadName;
		this.array = array;
	}
	public int getSum(){
		return sum;
	}
	
	private int calculateSum() throws InterruptedException {
		// Wannabe hard work simulation
		Thread.sleep(new Random().nextInt(4000));
		
		for (int i : array) {
			sum += i;
		}
		return sum;
	}
	
	@Override
	public void run(){
		System.out.println(pseudoThreadName + " started");
		try {
			calculateSum();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(pseudoThreadName + " finished");
	}
}
