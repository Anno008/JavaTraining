package taskEight;

public class TaskEight {
	public static void main(String[] args) {
		int number = 1000;
		double aprox = ApproximationsOfPi(number);

		System.out.println(aprox);
	}

	private static double ApproximationsOfPi(int number) {
		double result = 0;
		int multiplier = 1;
		for (int i = 0; i < number; i++) {
			result = i % 2 == 0 ? result + (double)4/multiplier : result - (double) 4 /multiplier;
			multiplier += 2;
		}
		return result;
	}

}
