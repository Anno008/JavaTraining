package restWebService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import restWebService.model.City;
import restWebService.repository.CityRepository;

@Component
public class CityService {
	@Autowired
	private CityRepository cityRepository;

	public List<City> getAll() {
		return cityRepository.getAll();
	}

	public City get(int id) {
		return cityRepository.get(id);
	}
	
	public List<City> getByCountry(int id){
		return cityRepository.getByCountry(id);
	}

	public City save(City city) {
		return cityRepository.save(city);
	}

	public void delete(int id) {
		cityRepository.delete(id);
	}

	public List<City> findByName(String name) {
		return cityRepository.findByName(name);
	}
}