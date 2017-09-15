package countries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import countries.model.Country;
import countries.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;

	@RequestMapping(value = "api/countries", method = RequestMethod.GET)
	public List<Country> getAllCountries() {
		return countryService.getAll();
	}

	@RequestMapping(value = "api/countries/{id}", method = RequestMethod.GET)
	public Country get(@PathVariable int id) {
		return countryService.get(id);
	}
	
	@RequestMapping(value="api/countries/search", method = RequestMethod.GET) 
	public List<Country> getByName(@RequestParam String name){
		return countryService.findByName(name);
	}
	
	@RequestMapping(value="api/countries", method = RequestMethod.POST)
	public void createCountry(@RequestBody Country country) {
		countryService.save(country);
	}
	
	@RequestMapping(value="api/countries/{id}", method = RequestMethod.DELETE)
	public void deleteCountry(@PathVariable int id) {
		countryService.delete(id);
	}
}
