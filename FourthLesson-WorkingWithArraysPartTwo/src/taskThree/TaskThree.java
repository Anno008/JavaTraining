package taskThree;

public class TaskThree {
	public static void main(String[] args) {
		int[] array = { 2, 4, 6, 4, 2 , 1 };
		
		boolean isSymmetric = false;
		
		for (int i = 0; i < array.length; i++) {
			if( array[i] == array[array.length - 1]){
				isSymmetric = true;
			}
			else{
				isSymmetric = false;
				break;
			}
		}
		
		System.out.println(isSymmetric ? "This is a symmetric array" : "This is an asymmetric array");
	}
}
