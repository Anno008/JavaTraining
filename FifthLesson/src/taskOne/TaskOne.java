package taskOne;

public class TaskOne {

	public static void main(String[] args) {
		// Translate pseudo code to java
		// for i from 1 to N
		// 		key = a[i]
		// 		j = i - 1
		// 		while j >= 0 and a[j] > key
		// 			a[j+1] = a[j]
		// 			j = j – 1
		// 			end(while)
		// 		a[j+1] = key
		// end(for)
		
		int[] array = { 1, 3, 4, 55, 66, 45, 78, 64 };

		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			int j = i - 1;

			while (j >= 0 && key < array[j]) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}

		for (int i : array) {
			System.out.println(i);
		}
	}

}
