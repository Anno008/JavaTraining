package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import main.Main;
import models.*;

public class CityIO {
	private static final String path = "src/IO/cities.txt";

	private static City string2City(String row) throws IOException {
		String[] s = row.split(",");
		Country country = Main.countries.stream().filter(c -> c.getId() == Integer.parseInt(s[3])).findFirst().get();
		City city = new City(Integer.parseInt(s[0]), s[1], Integer.parseInt(s[2]), country);
		country.addCity(city);
		return city;
	}

	private static String city2String(City c) {
		return c.getZipCode() + "," + c.getName() + "," + c.getPopulation() + "," + c.getCountry().getId();
	}

	public static ArrayList<City> readCities() throws IOException {
		BufferedReader inputStream = null;
		ArrayList<City> cities = null;

		// Check if the file exists if not return an empty array
		File file = new File(path);
		if (!file.exists())
			return new ArrayList<City>();

		try {
			inputStream = new BufferedReader(new FileReader(path));
			cities = new ArrayList<City>();
			String line;
			while ((line = inputStream.readLine()) != null)
				cities.add(string2City(line));

			return cities;
		} finally {
			if (inputStream != null)
				inputStream.close();
		}
	}

	public static void saveCities(List<City> cities) throws IOException {
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileWriter(path));
			for (City city : cities)
				outputStream.println(city2String(city));
		} finally {
			if (outputStream != null)
				outputStream.close();
		}
	}
}
