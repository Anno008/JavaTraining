package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import models.Country;

public class CountryIO {
	private static final String path = "src/IO/countries.txt";

	private static Country string2Country(String row) throws IOException {
		String[] s = row.split(",");
		return new Country(Integer.parseInt(s[0]), s[1]);
	}

	private static String country2String(Country c) {
		return c.getId() + "," + c.getName();
	}

	public static ArrayList<Country> readCountries() throws IOException {
		BufferedReader inputStream = null;
		ArrayList<Country> countries = null;

		// Check if the file exists if not return an empty array
		File file = new File(path);
		if (!file.exists())
			return new ArrayList<Country>();

		try {
			inputStream = new BufferedReader(new FileReader(path));
			countries = new ArrayList<Country>();
			String line;
			while ((line = inputStream.readLine()) != null)
				countries.add(string2Country(line));

			return countries;
		} finally {
			if (inputStream != null)
				inputStream.close();
		}
	}

	public static void saveCountries(List<Country> countries) throws IOException {
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileWriter(path));
			for (Country country : countries)
				outputStream.println(country2String(country));
		} finally {
			if (outputStream != null)
				outputStream.close();
		}
	}
}
