package taskSelectionSort;

import java.util.Arrays;

public class TaskSelectionSort {
	public static void main(String[] args) {
		// This algorithm is fairly simple to implement but has considerable drawbacks
		// for every item in the array we will iterate by array length times

		int[] array = { 6, 12, 42, 33, 4, 1, 3, 2, 0, 0, 1 };
		System.out.println("Input array: " + Arrays.toString(array));

		for (int i = 0; i < array.length; i++) {
			int index = i;
			for (int j = i; j < array.length; j++) 
				if (array[j] < array[index])
					index = j;
			
			int min = array[index];
			array[index] = array[i];
			array[i] = min;
		}

		System.out.println("Sorted input array: " + Arrays.toString(array));
	}
}
