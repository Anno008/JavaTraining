package jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jdbc.model.City;
import jdbc.repository.CityRepository;

@Component
public class CityService {
	@Autowired
	private CityRepository cityRepository;

	public List<City> get() {
		return cityRepository.get();
	}

	public City get(int id) {
		return cityRepository.get(id);
	}

	public City save(City country) {
		return cityRepository.save(country);
	}

	public void delete(int id) {
		cityRepository.delete(id);
	}

	public List<City> getByName(String name) {
		return cityRepository.getByName(name);
	}
}
