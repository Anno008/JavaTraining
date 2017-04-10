package taskQuickSort;

import java.util.Arrays;

public class TaskQuickSort {
	public static void main(String[] args) {
		int[] array = { 2, 5, 57, 54, 1, 1, 1 };
		System.out.println("Input array: " + Arrays.toString(array));

		array = quickSortEncapsulation(array);
		System.out.println("Sorted array: " + Arrays.toString(array));

	}

	static int[] quickSortEncapsulation(int[] array) {
		return quicksort(array, 0, array.length - 1);
	}

	static int[] quicksort(int[] array, int min, int max) {
		if (min > max)
			return array;

		int index = min - 1;
		for (int i = min; i < max; i++)
			if (array[i] <= array[max]) {
				int temp = array[++index];
				array[index] = array[i];
				array[i] = temp;
			}

		int temp = array[index + 1];
		array[index + 1] = array[max];
		array[max] = temp;

		array = quicksort(array, min, index);
		array = quicksort(array, index + 2, max);
		return array;
	}
}
