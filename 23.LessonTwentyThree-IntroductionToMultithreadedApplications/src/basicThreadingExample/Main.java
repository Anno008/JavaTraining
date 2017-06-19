package basicThreadingExample;

public class Main {
	public static void main(String[] args){
		System.out.println("Main thread started");
		
		for (int i = 0; i < 10; i++) {
			Task t = new Task(i);
			t.start();
		}
		
		System.out.println("Main thread finished.");
	}
}
