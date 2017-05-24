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

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Zip code: " + zipCode + ", name: " + name + ", population: " + population + ", Country: " + country.getName();
	}
}
