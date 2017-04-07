package taskTwo;

public class TaskTwo {
	public static void main(String[] args) {
		int[] inputArray = { 2, 5, 73, 45, 23, 97, 6, 465 };

		Result result = GetHighestLowestNumberInTheArray(inputArray);

		System.out.println("The highest number in the array is: " + result.HighestNumber
				+ "\nThe lowest number in the array is: " + result.SmallestNumber 
				+ "\nThe sum of all the elements in the array is: " + result.Sum
				+ "\nThe average value of the array is: " + result.Average);
	}

	static Result GetHighestLowestNumberInTheArray(int[] array) {
		int min = array[0];
		int max = array[1];
		int sum = 0;

		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			if (min > array[i])
				min = array[i];
			if (max < array[i])
				max = array[i];
		}

		return new Result(min, max, sum, sum / array.length);
	}
}
