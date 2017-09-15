package countries.service;

import java.util.List;

import org.springframework.stereotype.Component;

import countries.model.Country;
import countries.repository.CountryRepository;

@Component
public class CountryService {
	private CountryRepository countryRepository;

	public List<Country> getAll() {
		return countryRepository.getAll();
	}

	public Country get(int id) {
		return countryRepository.get(id);
	}

	public void save(Country country) {
		countryRepository.save(country);
	}

	public void delete(int id) {
		countryRepository.delete(id);
	}

	public List<Country> findByName(String name) {
		return countryRepository.findByName(name);
	}
}
