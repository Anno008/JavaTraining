package taskSeven;

public class TaskSeven {
	public static void main(String[] args) {
		for (int i = 1; i < 15; i++)
			System.out.print(Fibonacci(i) + " ");

		System.out.println();
		int fibResult = FibonacciRecursive(7);
		System.out.println("Fibonacci of 7 is: " + fibResult);
	}

	public static int FibonacciRecursive(int number) {
		return number < 2 ? number : FibonacciRecursive(number - 2) + FibonacciRecursive(number - 1);
	}

	public static int Fibonacci(int n) {
		int first = 0;
		int second = 1;

		for (int i = 0; i < n; i++) {
			int temp = first;
			first = second;
			second = temp + second;
		}
		return first;
	}

	public long Fib(int n) {
		if (n < 2)
			return n;

		long[] f = new long[n + 1];
		f[0] = 0;
		f[1] = 1;

		for (int i = 2; i <= n; i++)
			f[i] = f[i - 1] + f[i - 2];

		return f[n];
	}
}
