package restWebService.model;

public class Country {
	private int id;
	private String name;
	private int population;
	
	// To allow our controller to deserialize incoming JSON objects
	public Country() {}
	
	public Country(int id, String name, int population) {
		this.id = id;
		this.name = name;
		this.population = population;
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

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Country id=" + id + ", name=" + name + ", population=" + population;
	}
}
