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

import restWebService.model.City;
import restWebService.model.Country;
import restWebService.service.CityService;

@RestController
@RequestMapping(value = "api/cities")
public class CityController {
	@Autowired
	CityService cityService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<City>> get() {
		Country c = cityService.get(1).getCountry();
		return new ResponseEntity<>(cityService.getAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<City> get(@PathVariable int id) {
		return new ResponseEntity<>(cityService.get(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, params = "name")
	public ResponseEntity<List<City>> getByName(@RequestParam String name) {
		List<City> countries = cityService.findByName(name);

		return new ResponseEntity<>(countries, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<City> post(@RequestBody City city) {
		return new ResponseEntity<City>(cityService.save(city), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> put(@PathVariable int id, @RequestBody City city) {
		return new ResponseEntity<>(cityService.save(city), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable int id) {
		if (cityService.get(id) != null) {
			cityService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}