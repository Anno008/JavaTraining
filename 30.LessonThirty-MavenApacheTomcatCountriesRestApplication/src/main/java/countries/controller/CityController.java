package countries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import countries.model.City;
import countries.service.CityService;

@RestController
public class CityController {

	@Autowired
	private CityService cityService;

	@RequestMapping(value = "api/cities", method = RequestMethod.GET)
	public List<City> getAllCities() {
		return cityService.getAll();
	}

	@RequestMapping(value = "api/cities/{id}", method = RequestMethod.GET)
	public City get(@PathVariable int id) {
		return cityService.get(id);
	}

	@RequestMapping(value = "api/cities/search", method = RequestMethod.GET)
	public List<City> getByName(@RequestParam String name) {
		return cityService.findByName(name);
	}

	@RequestMapping(value = "api/cities", method = RequestMethod.POST)
	public void createCity(@RequestBody City City) {
		cityService.save(City);
	}

	@RequestMapping(value = "api/cities/{id}", method = RequestMethod.DELETE)
	public void deleteCity(@PathVariable int id) {
		cityService.delete(id);
	}
}
