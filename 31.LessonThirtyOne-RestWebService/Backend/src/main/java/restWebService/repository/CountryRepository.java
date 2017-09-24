package restWebService.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import restWebService.model.Country;

@Component("countryRepository")
public class CountryRepository {
	private List<Country> countries = new ArrayList<Country>();

	public CountryRepository() {
		countries.add(new Country(1, "Serbia", 7000000));
		countries.add(new Country(2, "Netherlands", 17000000));
		countries.add(new Country(3, "Austria", 8700000));
	}

	public List<Country> getAll() {
		return countries;
	}

	public Country get(int id) {
		return countries.stream().filter(c -> c.getId() == id).findFirst().get();
	}

	public Country save(Country country) {
		Country existingCountry = get(country.getId());
		if (existingCountry == null) {
			country.setId(Collections.max(countries, Comparator.comparing(c -> c.getId())).getId() + 1);
			countries.add(country);
		} else
			existingCountry.setName(country.getName());

		return country;
	}

	public void delete(int id) {
		countries.remove(countries.stream().filter(c -> c.getId() == id).findFirst().get());
	}

	public List<Country> findByName(String name) {
		return countries.stream().filter(c -> c.getName().toLowerCase().contains(name.toLowerCase()))
				.collect(Collectors.toList());
	}

	public List<Country> getAllWithPopulationHigher(int population) {
		return countries.stream().filter(c -> c.getPopulation() >= population).collect(Collectors.toList());
	}

	public List<Country> getAllWithPopulationLower(int population) {
		return countries.stream().filter(c -> c.getPopulation() <= population).collect(Collectors.toList());
	}
}
