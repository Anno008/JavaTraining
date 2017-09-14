package countries.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import countries.model.Country;

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
		for (Country country : countries)
			if (country.getId() == id)
				return country;

		return null;
	}

	public void save(Country country) {
		Country existingCountry = get(country.getId());
		if (existingCountry == null)
			countries.add(country);
		else {
			existingCountry.setName(country.getName());
			existingCountry.setPopulation(country.getPopulation());
		}
	}

	public void delete(int id) {
		for (int i = 0; i < countries.size(); i++)
			if (countries.get(i).getId() == id) {
				countries.remove(i);
				return;
			}
	}

	public List<Country> findByName(String name) {
		List<Country> retVal = new ArrayList<Country>();
		for (Country country : countries) {
			if (country.getName().toLowerCase().contains(name.toLowerCase()))
				retVal.add(country);
		}

		return retVal;
	}
}
