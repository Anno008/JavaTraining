package taskOneSumOfAllElements;

public class TaskOneSumOfAllElements {
	public static void main(String[] args) {
		int[] array = { 1, 3, 5, 66, 34, 22, 66, 77, 88, 99, 123 };

		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		
		System.out.println("The sum of all the elements in the array is: " + sum);
		System.out.println("The average value of the array is: " + sum / array.length);
	}
}
