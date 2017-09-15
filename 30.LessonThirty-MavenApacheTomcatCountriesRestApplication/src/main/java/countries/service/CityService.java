package countries.service;

import java.util.List;

import org.springframework.stereotype.Component;

import countries.model.City;
import countries.repository.CityRepository;

@Component
public class CityService {
	private CityRepository cityRepository;

	public List<City> getAll() {
		return cityRepository.getAll();
	}

	public City get(int id) {
		return cityRepository.get(id);
	}

	public void save(City city) {
		cityRepository.save(city);
	}

	public void delete(int id) {
		cityRepository.delete(id);
	}

	public List<City> findByName(String name) {
		return cityRepository.findByName(name);
	}
}
