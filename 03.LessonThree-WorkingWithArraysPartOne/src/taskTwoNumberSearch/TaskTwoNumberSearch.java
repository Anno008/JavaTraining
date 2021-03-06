package taskTwoNumberSearch;

public class TaskTwoNumberSearch {
	public static void main(String[] args) {
		int[] array = { 1, 23, 5, 6, 34, 54, 65, 888, 65, 45, 4, 7, 15, 54 };

		int numberToFind = 54;
		int count = 0;
		String index = "";

		for (int i = 0; i < array.length; i++) {
			if (array[i] != numberToFind)
				continue;
			index += i + " ";
			count++;
		}
		
		System.out.println(count > 0 ? "Number " + numberToFind + " exists in the array and appears " + count + " times, at indexes: " + index :
									   "Number " + numberToFind + " doesn't exist in the array");

	}
}
