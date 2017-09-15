package countries.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import countries.model.City;

@Component("cityRepository")
public class CityRepository {
	private List<City> cities = new ArrayList<City>();

	@Autowired
	public CityRepository(CountryRepository countryRepository) {
		cities.add(new City(1, "Novi Sad", countryRepository.get(1)));
		cities.add(new City(2, "Subotica", countryRepository.get(1)));
		cities.add(new City(3, "Belgrade", countryRepository.get(1)));

		cities.add(new City(4, "Amstermdam", countryRepository.get(2)));
		cities.add(new City(5, "The Hague", countryRepository.get(2)));
		cities.add(new City(6, "Rotterdam", countryRepository.get(2)));

		cities.add(new City(7, "Vienna", countryRepository.get(3)));
		cities.add(new City(8, "Graz", countryRepository.get(3)));
		cities.add(new City(9, "Linz", countryRepository.get(3)));
	}

	public List<City> getAll() {
		return cities;
	}

	public City get(int id) {
		for (City city : cities)
			if (city.getId() == id)
				return city;

		return null;
	}

	public void save(City City) {
		City existingCity = get(City.getId());
		if (existingCity == null)
			cities.add(City);
		else
			existingCity.setName(City.getName());

	}

	public void delete(int id) {
		for (int i = 0; i < cities.size(); i++)
			if (cities.get(i).getId() == id) {
				cities.remove(i);
				return;
			}
	}

	public List<City> findByName(String name) {
		List<City> retVal = new ArrayList<City>();
		for (City City : cities) {
			if (City.getName().toLowerCase().contains(name.toLowerCase()))
				retVal.add(City);
		}

		return retVal;
	}
}
