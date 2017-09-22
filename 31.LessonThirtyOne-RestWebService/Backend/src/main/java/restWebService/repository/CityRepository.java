package restWebService.repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import restWebService.model.City;

@Component("cityRepository")
public class CityRepository {
	private List<City> cities;

	@Autowired
	public CityRepository(CountryRepository countryRepository) {
		cities = Arrays.asList(
				new City(1, "Novi Sad", countryRepository.get(1)),
				new City(2, "Subotica", countryRepository.get(1)),
				new City(3, "Belgrade", countryRepository.get(1)),
				new City(4, "Amstermdam", countryRepository.get(2)),
				new City(5, "The Hague", countryRepository.get(2)),
				new City(6, "Rotterdam", countryRepository.get(2)),
				new City(7, "Vienna", countryRepository.get(3)),
				new City(8, "Graz", countryRepository.get(3)),
				new City(9, "Linz", countryRepository.get(3)));
	}

	public List<City> getAll() {
		return cities;
	}

	public City get(int id) {
		return cities.stream().filter(c -> c.getId() == id).findFirst().get();
	}

	public City save(City City) {
		City existingCity = get(City.getId());
		if (existingCity == null) {
			City.setId(Collections.max(cities, Comparator.comparing(c -> c.getId())).getId() + 1);
			cities.add(City);
		} else
			existingCity.setName(City.getName());

		return City;
	}

	public void delete(int id) {
		cities.remove(cities.stream().filter(c -> c.getId() == id).findFirst().get());
	}

	public List<City> findByName(String name) {
		return cities.stream().filter(c -> c.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
	}
}
