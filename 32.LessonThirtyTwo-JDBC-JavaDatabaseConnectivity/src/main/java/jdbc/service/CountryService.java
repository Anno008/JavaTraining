package jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jdbc.model.Country;
import jdbc.repository.CountryRepository;

@Component
public class CountryService {
	@Autowired
	private CountryRepository countryRepository;
	
	public List<Country> get() {
		return countryRepository.get();
	}
	
	public Country get(int id) {
		return countryRepository.get(id);
	}
	
	public Country save(Country country) {
		return countryRepository.save(country);
	}
	
	public void delete(int id) {
		countryRepository.delete(id);
	}
	
	public List<Country> getByName(String name) {
		return countryRepository.getByName(name);
	}
}
