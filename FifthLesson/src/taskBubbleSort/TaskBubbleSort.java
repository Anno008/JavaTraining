package taskBubbleSort;

import java.util.Arrays;

public class TaskBubbleSort {
	public static void main(String[] args) {
		int[] array = { 9, 5, 7, 3, 1, 2, 2, 6, 1 };

		System.out.println("Input array: " + Arrays.toString(array));

		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}

		System.out.println("Sorted array: " + Arrays.toString(array));
	}
}
