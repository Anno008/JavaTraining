package taskOneArraySort;

import java.util.Arrays;

public class TaskOneArraySort {
	public static void main(String[] args) {
		int[] inputArray = { 1, 2, 3, 4, 5, 78, 9, 45, 3 };
		System.out.println("Input array: " + Arrays.toString(inputArray));

		int[] result = bubbleSort(inputArray);
		System.out.println("Sorted array: " + result.toString());
	}

	public static int[] bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array.length - i - 1; j++)
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}

		return array;
	}

	static int[] insertionSort(int array[]) {
		for (int i = 1; i < array.length; i++) {
			int j = i - 1;
			int temp = array[i];

			while (j >= 0 && temp < array[j]) {
				array[j + 1] = array[j];
				j--;
				;
			}
			array[j + 1] = temp;
		}
		return array;
	}
}