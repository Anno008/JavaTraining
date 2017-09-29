package jdbc.controller;

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

import jdbc.model.Country;
import jdbc.service.CountryService;

@RestController
@RequestMapping(value ="api/countries")
public class CountryController {
	@Autowired
	CountryService countryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Country>> get() {
		return new ResponseEntity<>(countryService.get(), HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Country> get(@PathVariable int id) {
		return new ResponseEntity<>(countryService.get(id), HttpStatus.OK); 
	}
	
	@RequestMapping(method = RequestMethod.GET, params = "name")
	public ResponseEntity<List<Country>> getCountriesByName(@RequestParam String name) {
		return new ResponseEntity<>(countryService.getByName(name), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Country> post(@RequestBody Country country){
		return new ResponseEntity<>(countryService.save(country), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Country> put(@RequestBody Country country){
		return new ResponseEntity<>(countryService.save(country), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable int id) {
		Country country = countryService.get(id);
		if (country != null) {
			countryService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
