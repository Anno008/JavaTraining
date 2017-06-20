package threadingExampleTwo;

public class Task extends Thread{
	private int[] array;
	private int sum;
	private String pseudoThreadName;
	
	public Task(String pseudoThreadName, int[] array){
		this.pseudoThreadName = pseudoThreadName;
		this.array = array;
	}
	
	public int getSum() throws InterruptedException{
		return sum;
	}
	
	@Override
	public void run(){
		System.out.println(pseudoThreadName + " started");
		for (int i : array) {
			sum += i;
		}
		try {
			// Wannabe hard work simulation
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
