package models;

public class City {
	private int zipCode;
	private String name;
	private int population;
	private Country country;

	public City(int zipCode, String name, int population, Country country) {
		this.zipCode = zipCode;
		this.name = name;
		this.population = population;
		this.country = country;
	}
}
