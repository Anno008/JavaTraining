package introductionToOopPartTwo;

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

	static void PrintOptions() {
		String output = 
				"1. Display informations about all students\n" +
				"2. Find a student based on index, and display it's information\n" +
				"3. Create a student\n" +
				"4. Update a student\n" +
				"5. Delete a student\n\n" +
				"6. List all subjects\n" +
				"7. Find a subject based on id, and display it's information\n" + 
				"8. Create a subject\n" +
				"9. Update a subject\n" +
				"10. Delete a subject\n" +
				"11. Take an exam\n\n" +
				"12. Exit";
		
		System.out.println(output);
	}

	public static int parseInt(String input) {
		int number = 0;
		try {
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("Error while parsing a string to int, are you sure you entered a valid integer?");
		}
		return number;
	}

	public static int askForInteger(String message) {
		System.out.println(message);
		String input = UtilityMethods.ReadInput();
		int index = UtilityMethods.parseInt(input);
		return index;
	}
}
