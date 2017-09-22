package restWebService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import restWebService.model.Country;
import restWebService.service.CountryService;

@RestController
public class CountryController {
	@Autowired
	CountryService countryService;

	@RequestMapping(value = "api/countries", method = RequestMethod.GET)
	public ResponseEntity<List<Country>> getAllCountries() {
		return new ResponseEntity<>(countryService.getAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "api/countries/{id}", method = RequestMethod.GET)
	public ResponseEntity<Country> getCountry(@PathVariable int id) {
		return new ResponseEntity<>(countryService.get(id), HttpStatus.OK);
	}

	@RequestMapping(value = "api/countries", method = RequestMethod.POST)
	public ResponseEntity<Country> create(@RequestBody Country country) {
		return new ResponseEntity<>(countryService.save(country), HttpStatus.CREATED);
	}

	@RequestMapping(value = "api/countries/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Country> update(@PathVariable int id, @RequestBody Country country) {
		return new ResponseEntity<>(countryService.save(country), HttpStatus.OK);
	}

	@RequestMapping(value = "api/countries/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable int id) {
		if (countryService.get(id) != null) {
			countryService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "api/countries", method = RequestMethod.GET, params = "name")
	public ResponseEntity<List<Country>> getCountriesByName(@RequestParam String name) {
		List<Country> countries = countryService.findByName(name);

		return new ResponseEntity<>(countries, HttpStatus.OK);
	}

	@RequestMapping(value = "api/countries", method = RequestMethod.GET, params = "population")
	public ResponseEntity<List<Country>> getCountriesByPopulation(@RequestParam int population,
			@RequestParam boolean higherThan) {
		return new ResponseEntity<>(higherThan ? countryService.getAllWithPopulationHigher(population)
				: countryService.getAllWithPopulationLower(population), HttpStatus.OK);
	}
}