package taskMergeSort;

import java.util.Arrays;

public class TaskMergeSort {

	public static void main(String[] args) {
		int[] array = { 9, 10, 3, 4, 4, 5, 1, 25, 33, 0, 0, 111 };

		System.out.println("Input array: " + Arrays.toString(array));
		int[] resultArray = MergeSortArray(array);

		System.out.println("Sorted input array: " + Arrays.toString(resultArray));
	}

	static int[] MergeSortArray(int[] inputArray) {
		if (inputArray.length <= 1)
			return inputArray;

		boolean isEven = inputArray.length % 2 == 0;
		int halfLength = inputArray.length / 2;
		int[] leftArray = new int[halfLength];
		int[] rightArray = new int[inputArray.length - halfLength];
		int numberOfIterations = isEven ? halfLength : halfLength + 1;
		
		for (int i = 0; i < numberOfIterations; i++) {
			if (i < halfLength)
				leftArray[i] = inputArray[i];

			rightArray[i] = inputArray[halfLength + i];
		}

		return MergeArrays(MergeSortArray(leftArray), MergeSortArray(rightArray));
	}

	static int[] MergeArrays(int[] left, int[] right) {
		int leftIndex = 0, rightIndex = 0;
		int[] resultArray = new int[left.length + right.length];

		for (int i = 0; i < resultArray.length; i++) {
			if (leftIndex >= left.length)
				resultArray[i] = right[rightIndex++];
			else if (rightIndex >= right.length || left[leftIndex] <= right[rightIndex])
				resultArray[i] = left[leftIndex++];
			else
				resultArray[i] = right[rightIndex++];
		}
		return resultArray;
	}
}
