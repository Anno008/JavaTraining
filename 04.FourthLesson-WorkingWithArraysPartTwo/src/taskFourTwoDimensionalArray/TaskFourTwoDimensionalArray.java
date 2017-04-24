package taskFourTwoDimensionalArray;

public class TaskFourTwoDimensionalArray {
	public static void main(String[] args){
		int[][] array = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		
		int productOfMultiplicationAboveTheMainDiagonalLine = 1;
		int productOfMultiplicationBelowTheMainDiagonalLine = 1;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if(j > i)
					productOfMultiplicationAboveTheMainDiagonalLine *= array[i][j];
				
				if(j < i)
					productOfMultiplicationBelowTheMainDiagonalLine *= array[i][j];
			}
				
		}
		
		System.out.println("The multiplication product of all the elements above the diagonal line is: " + productOfMultiplicationAboveTheMainDiagonalLine);
		System.out.println("The multiplication product of all the elements below the diagonal line is: " + productOfMultiplicationBelowTheMainDiagonalLine);
	}
}
