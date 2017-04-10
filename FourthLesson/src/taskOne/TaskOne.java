package taskOne;

public class TaskOne {
	public static void main(String[] args) {
		int[] array = { 1, 3, 5, 66, 34, 22, 66, 77, 88, 99, 123 };

		int sumOfAllElements = 0;
		for (int i = 0; i < array.length; i++) {
			sumOfAllElements += array[i];
		}
		
		System.out.println("The sum of all the elements in the array is: " + sumOfAllElements);
		System.out.println("The average value of the array is: " + sumOfAllElements / array.length);
	}
}
