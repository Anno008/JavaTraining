package taskMergeSort;

import java.util.Arrays;

public class TaskMergeSort {

	public static void main(String[] args) {
		int[] array = { 9, 10, 3, 4, 5, 6, 7, 8 };

		System.out.println("Note sadly this only works if the count of the array is an even number.");
		System.out.println("Input array: " + Arrays.toString(array));
		int[] resultArray = MergeSortArray(array);

		System.out.println("Sorted input array: " + Arrays.toString(resultArray));
	}

	static int[] MergeSortArray(int[] inputArray) {
		if (inputArray.length <= 1)
			return inputArray;

		int[] leftArray = new int[inputArray.length / 2];
		int[] rightArray = new int[inputArray.length / 2];

		for (int i = 0; i < inputArray.length; i++) {
			if (i < inputArray.length / 2)
				leftArray[i] = inputArray[i];
			else
				rightArray[i - inputArray.length / 2] = inputArray[i];
		}

		return MergeArrays(MergeSortArray(leftArray), MergeSortArray(rightArray));
	}

	static int[] MergeArrays(int[] left, int[] right) {
		int leftIndex = 0, rightIndex = 0;
		int[] resultArray = new int[left.length + right.length];

		for (int i = 0; i < resultArray.length; i++) {
			resultArray[i] = leftIndex >= left.length ? 
					right[rightIndex++] : rightIndex >= right.length ? 
					left[leftIndex++] : left[leftIndex] <= right[rightIndex] ? 
					left[leftIndex++] : right[rightIndex++];
		}
		return resultArray;
	}
}
