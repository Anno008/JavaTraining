package countriesMavenSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import countriesMavenSpring.model.Country;
import countriesMavenSpring.repository.CountryRepository;

@Component
public class CountryService {

	@Autowired
	CountryRepository countryRepository;

	public List<Country> findAll() {
		return countryRepository.findAll();
	}

	public Country find(int id) {
		return countryRepository.find(id);
	}

	public void save(Country country) {
		countryRepository.save(country);
	}

	public void delete(int id) {
		countryRepository.delete(id);
	}

}
