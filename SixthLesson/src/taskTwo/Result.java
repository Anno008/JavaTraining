package taskTwo;

public class Result {
	public int SmallestNumber;
	public int HighestNumber;
	public int Sum;
	public double Average;

	public Result(int min, int max, int sum, int average) {
		SmallestNumber = min;
		HighestNumber = max;
		Average = average;
		Sum = sum;
	}
}
