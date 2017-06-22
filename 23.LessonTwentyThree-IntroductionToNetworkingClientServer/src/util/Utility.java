package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utility {
	public static String readString(String message) {
		String retVal = "";
		try {
			boolean isOk = true;
			do {
				if (message.length() != 0)
					System.out.println(message);

				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				retVal = reader.readLine();
				if (retVal.length() == 0) {
					isOk = false;
					System.out.println("You must enter at least one character.");
				} else
					isOk = true;
			} while (!isOk);

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

		return retVal;
	}

	public static int readInteger(String message) {
		String input = readString(message);
		int number = parseInt(input);
		return number;
	}

	public static double readDouble(String message) {
		String input = readString(message);
		double number = parseDouble(input);
		return number;
	}

	private static double parseDouble(String input) {
		double number = 0;
		try {
			number = Double.parseDouble(input);
		} catch (Exception e) {
			System.out.println("Error while parsing a string to a double, are you sure you entered a valid number?");
		}
		return number;
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
