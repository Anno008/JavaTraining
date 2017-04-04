package taskBucketSort;

import java.util.Arrays;

public class TaskBucketSort {
	public static void main(String[] args) {
		// The problem I see here is that if the input array contains an element whose 
		// value is higher than the range of the sorted array it will be out of bounds
		int[] inputArray = { 5, 6, 4, 2, 3, 7, 1, 0 };
		int[] sortedArray = new int[inputArray.length];
		
		for (int i = 0; i < inputArray.length; i++) 
			sortedArray[inputArray[i]] = inputArray[i];
		
		System.out.println("Input array is: " + Arrays.toString(inputArray));
		System.out.println("Sorted input array is: " + Arrays.toString(sortedArray));
	}
}
