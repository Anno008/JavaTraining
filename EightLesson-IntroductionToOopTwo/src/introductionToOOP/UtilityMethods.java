package introductionToOOP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UtilityMethods {
	
	static String ReadInput() {
		String retVal = "";
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			retVal = reader.readLine();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

		return retVal;
	}
	
	static void PrintOptions(){
		String output = 
				"1. Display informations about all students\n" +
				"2. Find a student based on index, and display it's information\n" +
				"3. Create a student\n" +
				"4. Update a student\n" +
				"5. Delete a student\n" +
				"6. Exit";
		
		System.out.println(output);
	}
	
	public static int parseInt(String input){
		int number = 0;
		try {
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("Error while parsing a string to int, are you sure you entered a valid integer?");
		}
		return number;
	}
}
