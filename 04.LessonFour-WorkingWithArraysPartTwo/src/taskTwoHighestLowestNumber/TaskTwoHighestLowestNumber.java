package taskTwoHighestLowestNumber;

public class TaskTwoHighestLowestNumber {
	public static void main(String[] args) {
		double[] array = { 12.42, 13.55, 5.23, 1.23, 65.43, 343.56, 73.23 };
		
		double highestNumber = 0;
		double lowestNumber = array[0];
		
		for (int i = 0; i < array.length; i++) {
			if(lowestNumber > array[i])
				lowestNumber = array[i];
			
			if(array[i] > highestNumber)
				highestNumber = array[i];
		}
		
		System.out.println("The highest number in the array is: " + highestNumber);
		System.out.println("The lowest number in the array is: " + lowestNumber);
	}
}
