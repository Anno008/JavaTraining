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

import jdbc.model.City;
import jdbc.service.CityService;

@RestController
@RequestMapping(value ="api/cities")
public class CityController {
	@Autowired
	CityService cityService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<City>> get() {
		return new ResponseEntity<>(cityService.get(), HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<City> get(@PathVariable int id) {
		return new ResponseEntity<>(cityService.get(id), HttpStatus.OK); 
	}
	
	@RequestMapping(method = RequestMethod.GET, params = "name")
	public ResponseEntity<List<City>> getCitiesByName(@RequestParam String name) {
		return new ResponseEntity<>(cityService.getByName(name), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<City> post(@RequestBody City city){
		return new ResponseEntity<>(cityService.save(city), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<City> put(@RequestBody City city){
		return new ResponseEntity<>(cityService.save(city), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable int id) {
		City city = cityService.get(id);
		if (city != null) {
			cityService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
