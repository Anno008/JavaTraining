package main;

import java.util.ArrayList;
import IO.*;
import models.City;
import models.Country;
import util.Utils;

public class Main {
	private static ArrayList<City> cities;
	public static ArrayList<Country> countries;

	static {
		initialize();
	}

	private static void initialize() {
		try {
			countries = CountryIO.readCountries();
			cities = CityIO.readCities();
		} catch (Exception e) {
			System.out.println("An error occured while loading the files");
			e.printStackTrace(System.out);
		}
	}

	private static void save() {
		try {
			CountryIO.saveCountries(countries);
			CityIO.saveCities(cities);
		} catch (Exception e) {
			System.out.println("An error occured when saving the data.");
		}
	}

	public static void main(String[] args) {
		boolean repeat = true;
		do {
			int option = Utils.readInteger(getOptions());
			repeat = makeDecision(option, repeat);
			save();
		} while (repeat);
	}

	private static String getOptions() {
		Utils.createString('-', 50);
		String output = "";
		output += "1. Display countries\n";
		output += "2. Create country\n\n";
		output += "3. Display all cities in a country\n";
		output += "4. Create city\n";
		output += "5. City with the highest population\n";
		output += "6. Country with the highest population\n\n";
		output += "7. Exit\n\n";
		return output;
	}

	private static boolean makeDecision(int option, boolean repeat) {
		switch (option) {
		case 1:
			displayCountries();
			break;
		case 2:
			createCountry();
			break;
		case 3:
			displayCitiesInCountry();
			break;
		case 4:
			createCity();
			break;
		case 5:
			displayCityWithTheHighestPopulation();
			break;
		case 6:
			displayCountryWithTheHighestPopulation();
			break;
		case 7:
			return false;
		}
		return true;
	}

	private static void displayCountryWithTheHighestPopulation() {
		if (countries.size() == 0) {
			System.out.println("There are no countries saved");
			return;
		}

		Country countryWithTheHighestPopulation = new Country(0, "");

		for (Country country : countries)
			if (country.getPopulation() > countryWithTheHighestPopulation.getPopulation())
				countryWithTheHighestPopulation = country;

		System.out.println(countryWithTheHighestPopulation);
	}

	private static void displayCityWithTheHighestPopulation() {
		if (countries.size() == 0) {
			System.out.println("There are no countries saved");
			return;
		}

		City cityWithTheHighestPopulation = new City(0, "", 0, null);

		for (Country country : countries)
			for (City city : country.getCities())
				if (city.getPopulation() > cityWithTheHighestPopulation.getPopulation())
					cityWithTheHighestPopulation = city;

		System.out.println(cityWithTheHighestPopulation);
	}

	private static void createCity() {
		int zipCode = Utils.readInteger("Enter the zip code of the city.");
		String name = Utils.readString("Enter the name of the city");
		int population = Utils.readInteger("Enter the population of the city.");

		Country c = findCountry();
		if (c == null)
			return;
		City newCity = new City(zipCode, name, population, c);
		c.addCity(newCity);
		cities.add(newCity);
		System.out.println("City: " + newCity.getName() + " added to country: " + c.getName());
	}

	private static void displayCitiesInCountry() {
		Country c = findCountry();
		if (c == null)
			return;

		System.out.println("Country: " + c + "\nCities:");
		for (City city : c.getCities())
			System.out.println(city);

	}

	private static Country findCountry() {
		int countryId = Utils.readInteger("Enter the id of the country.");
		Country country = countries.stream().filter(c -> c.getId() == countryId).findFirst().orElse(null);
		if (country == null)
			System.out.println("Country with an id of: " + countryId + " doesn't exist");

		return country;
	}

	private static void createCountry() {
		String name = Utils.readString("Enter the name of the country you want to create.");
		Country newCountry = new Country(countries.size() + 1, name);

		countries.add(newCountry);
		System.out.println("Country " + name + " added");
	}

	private static void displayCountries() {
		for (Country country : countries)
			System.out.println(country);
	}
}
