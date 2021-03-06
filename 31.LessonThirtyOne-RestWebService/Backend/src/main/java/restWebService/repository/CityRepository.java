package restWebService.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import restWebService.model.City;

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
		return cities.stream().filter(c -> c.getId() == id).findFirst().get();
	}

	public List<City> getByCountry(int id) {
		return cities.stream().filter(c -> c.getCountry().getId() == id).collect(Collectors.toList());
	}

	public City save(City city) {
		City existingCity = get(city.getId());
		if (existingCity == null) {
			city.setId(Collections.max(cities, Comparator.comparing(c -> c.getId())).getId() + 1);
			cities.add(city);
		} else
			existingCity.setName(city.getName());

		return city;
	}

	public void delete(int id) {
		cities.remove(get(id));
	}

	public List<City> findByName(String name) {
		return cities.stream().filter(c -> c.getName().toLowerCase().contains(name.toLowerCase()))
				.collect(Collectors.toList());
	}
}
