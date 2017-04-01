package taskTwo;

public class TaskTwo {
	public static void main(String[] args) {
		double[] decimalArray = { 12.42, 13.55, 5.23, 1.23, 65.43, 343.56, 73.23 };
		
		double highestNumber = 0;
		double lowestNumber = decimalArray[0];
		
		for (int i = 0; i < decimalArray.length; i++) {
			if(lowestNumber > decimalArray[i])
				lowestNumber = decimalArray[i];
			
			if(decimalArray[i] > highestNumber)
				highestNumber = decimalArray[i];
		}
		
		System.out.println("The highest number in the array is: " + highestNumber);
		System.out.println("The lowest number in the array is: " + lowestNumber);
	}
}
