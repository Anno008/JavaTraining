package threadingExampleTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import threadingExampleTwo2.Task;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		int[] array = { 2, 5, 4, 11, 45, 23, 85, 43, 26 };
		int oneThird = array.length / 3;

		int sum = 0;
		List<Task> taskList = new ArrayList<Task>();

		for (int i = 1; i <= 3; i++) {
			Task t = new Task("Thread: " + i, Arrays.copyOfRange(array, (oneThird * i) - oneThird, oneThird * i));
			t.start();
			taskList.add(t);
		}

		for (Task task : taskList) {
			task.join();
			sum += task.getSum();
		}

		System.out.println("The sum is: " + sum);
		System.out.println("Main thread finished");
	}
}
