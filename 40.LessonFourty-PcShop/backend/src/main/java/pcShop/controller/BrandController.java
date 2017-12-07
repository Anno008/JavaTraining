package pcShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pcShop.model.Brand;
import pcShop.service.BrandService;

@RestController
public class BrandController {
	@Autowired
	BrandService brandService;

	@PreAuthorize("isAuthorized()")
	@GetMapping(value = "api/brands")
	public ResponseEntity<List<Brand>> get() {
		return new ResponseEntity<List<Brand>>(brandService.findAll(), HttpStatus.OK);
	}
}
