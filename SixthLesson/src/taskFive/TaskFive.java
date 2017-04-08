package taskFive;

public class TaskFive {
	public static void main(String[] args) {
		int recResult = FactorialRecursive(4);
		System.out.println(recResult);
		
		int result = Factorial(4);
		System.out.println(result);
		
	}

	public static int FactorialRecursive(int number) {
		return number == 1 ? 1 : number * FactorialRecursive(number - 1);
	}
	
	public static int Factorial(int number){
		int temp = 1;
		for (int i = 1; i <= number; i++) 
			temp *= i;
		
		return temp;
	}
}
