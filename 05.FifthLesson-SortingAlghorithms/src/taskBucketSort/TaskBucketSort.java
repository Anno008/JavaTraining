package taskBucketSort;

import java.util.Arrays;

public class TaskBucketSort {
	public static void main(String[] args) {
		int[] inputArray = { 5, 6, 4, 2, 7, 1, 0, 0, 0, 2, 9 };

		System.out.println("Input array: " + Arrays.toString(inputArray));

		int[] tempArray = new int[inputArray.length];

		for (int i = 0; i < inputArray.length; i++)
			tempArray[inputArray[i]]++;

		int position = 0;
		for (int i = 0; i < tempArray.length; i++)
			for (int j = 0; j < tempArray[i]; j++)
				inputArray[position++] = i;

		System.out.println("Sorted input array is: " + Arrays.toString(inputArray));
	}
}