package restWebService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import restWebService.model.Country;
import restWebService.repository.CountryRepository;

@Component
public class CountryService {
	@Autowired
	private CountryRepository countryRepository;

	public List<Country> getAll() {
		return countryRepository.getAll();
	}

	public Country get(int id) {
		return countryRepository.get(id);
	}

	public List<Country> getAllWithPopulationHigher(int population) {
		return countryRepository.getAllWithPopulationHigher(population);
	}

	public List<Country> getAllWithPopulationLower(int population) {
		return countryRepository.getAllWithPopulationLower(population);
	}

	public Country save(Country country) {
		return countryRepository.save(country);
	}

	public void delete(int id) {
		countryRepository.delete(id);
	}

	public List<Country> findByName(String name) {
		return countryRepository.findByName(name);
	}
}
