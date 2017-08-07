package taskOneMoneyCheckout;

public class TaskOneMoneyCheckout {
	public static void main(String[] args) {

		int amountToCheckout = 14350;
		int[][] availableMoneyAmount = { { 2000, 13 }, { 1000, 5 }, { 500, 2 }, { 100, 4 }, { 50, 55 } };
		String output = "";

		for (int i = 0; i < availableMoneyAmount.length; i++) {
			int count = 0;
				while (availableMoneyAmount[i][1] > 0) { 
					if (amountToCheckout <= 0 || amountToCheckout < availableMoneyAmount[i][0])
						break;
					amountToCheckout -= availableMoneyAmount[i][0];
					availableMoneyAmount[i][1] -= 1;
					count++;
				}
			output += "Checked out " + count + " bills with the value of: " + availableMoneyAmount[i][0] + "\n";
		}
		
		System.out.println(output);
	}
}
