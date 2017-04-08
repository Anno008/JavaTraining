package taskSix;

import java.util.Arrays;

public class TaskSix {
	public static void main(String[] args) {
		// Transfrom a matrix

		int[][] array = { { 1, 2, 3 }, { 3, 4, 5 } };
		PrintArray(array, "Input array");

		int[][] result = TransformArray(array);
		PrintArray(result, "Transformed array");
	}

	public static int[][] TransformArray(int[][] array) {
		int[][] result = new int[array[0].length][array.length];

		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[i].length; j++)
				result[j][i] = array[i][j];

		return result;
	}

	public static void PrintArray(int[][] array, String message) {
		System.out.println(message);
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}
}
