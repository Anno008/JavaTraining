package models;

import java.util.ArrayList;
import java.util.List;

public class Country {
	private int id;
	private String name;
	private List<City> cities = new ArrayList<City>();
	private int population = 0;

	public Country(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void addCity(City city) {
		cities.add(city);
		population += city.getPopulation();
	}
	
	public List<City> getCities(){
		return cities;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation(){
		return population;
	}
	@Override
	public String toString() {
		return "Id: " + id + ", Name: " + name + ", Population: " + population + ", Cities: " + cities.size();
	}
}
