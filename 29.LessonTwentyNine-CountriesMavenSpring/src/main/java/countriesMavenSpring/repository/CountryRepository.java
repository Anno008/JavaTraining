package countriesMavenSpring.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import countriesMavenSpring.model.Country;

@Component("countryRepository")
public class CountryRepository {
	private List<Country> countries = new ArrayList<Country>();

	public CountryRepository() {
		countries.add(new Country(1, "Serbia", 7098000));
		countries.add(new Country(2, "France", 66810000));
		countries.add(new Country(3, "Italy", 608000000));
	}

	public List<Country> findAll() {
		return countries;
	}

	public Country find(int id) {
		for (Country country : countries)
			if (country.getId() == id)
				return country;

		return null;
	}

	public void save(Country country) {
		Country existingCountry = find(country.getId());
		if (existingCountry == null)
			countries.add(country);
		else {
			existingCountry.setName(country.getName());
			existingCountry.setPopulation(country.getPopulation());
		}
	}

	public void delete(int id) {
		Iterator<Country> countriesIterator = countries.iterator();
		while (countriesIterator.hasNext()) {
			if (countriesIterator.next().getId() == id) {
				countriesIterator.remove();
				return;
			}
		}
	}
}
