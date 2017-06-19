package basicThreadingExample;

public class Task extends Thread {
	private int number;

	public Task(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		System.out.println("Printing from withing the task, number: " + number);
	}
}
