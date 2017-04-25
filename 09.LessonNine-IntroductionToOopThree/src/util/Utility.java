package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utility {
	public static void displayTheMenu() {
		System.out.println(createString('=', 140));
		System.out.println("1. Display students");
		System.out.println("2. Find a student");
		System.out.println("3. Create a student");
		System.out.println("4. Update a student");
		System.out.println("5. Delete a student\n");
		System.out.println("6. Display subjects");
		System.out.println("7. Find a subject");
		System.out.println("8. Create a subject");
		System.out.println("9. Update a subject");
		System.out.println("10. Delete a subject\n");
		System.out.println("11. Display teachers");
		System.out.println("12. Find a teacher");
		System.out.println("13. Create a teacher");
		System.out.println("14. Update a teacher");
		System.out.println("15. Delete a teacher\n");
		System.out.println("16. Take an exam");
		System.out.println("17. Invalidate an exam\n");
		System.out.println("18. Exit");
	}

	public static String readString(String message) {
		String retVal = "";
		try {
			boolean isOk = true;
			do {
				if(message.length() != 0)
					System.out.println(message);
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				retVal = reader.readLine();
				if(retVal.length() == 0){
					isOk = false;
					System.out.println("You must enter at least one character.");
				}
				else
					isOk = true;
			} while (!isOk);
		
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

		return retVal;
	}

	public static int readInteger(String message) {
		String input = readString(message);
		int index = parseInt(input);
		return index;
	}

	private static int parseInt(String input) {
		int number = 0;
		try {
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("Error while parsing a string to int, are you sure you entered a valid integer?");
		}
		return number;
	}

	public static String createString(char character, int times) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < times; i++)
		sb.append(character);

		return new String(sb);
	}
}
