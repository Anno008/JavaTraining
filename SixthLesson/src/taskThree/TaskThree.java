package taskThree;

public class TaskThree {
	public static void main(String[] args) {
		int[] array = { 2, 5, 4, 3, 7, 645, 56, 123 };
		int number = 5;

		int index = GetNumberIndex(array, number);
		System.out.println("The number: " + number
				+ (number > -1 ? " is in the array at the index of: " + index : " isn't contained in the array"));
	}

	public static int GetNumberIndex(int[] array, int number) {
		int index = -1;

		for (int i = 0; i < array.length; i++)
			if (array[i] == number)
				index = i;

		return index;
	}
}
