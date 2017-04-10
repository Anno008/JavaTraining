package taskFourArrayMedian;

import taskOneArraySort.TaskOneArraySort;

public class TaskFourArrayMedian {
	public static void main(String[] args) {
		int[] inputArray = { 1, 2, 6, 45, 89, 6, 34, 63, 2, 76, 645 };
		double median = GetArrayMedian(inputArray);

		System.out.println(median);
	}

	public static double GetArrayMedian(int[] array) {
		int[] sortedArray = TaskOneArraySort.bubbleSort(array);

		return array.length % 2 == 0 ? (double) array[array.length / 2] + (double) array[array.length / 2 - 1]
				: (double) array[array.length / 2];
	}
}
