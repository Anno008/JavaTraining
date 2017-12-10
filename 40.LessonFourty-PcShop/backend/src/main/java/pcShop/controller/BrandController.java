package pcShop.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pcShop.dto.BrandDTO;
import pcShop.service.BrandService;

@RestController
public class BrandController {
	@Autowired
	private BrandService brandService;

//	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "api/brands")
	public ResponseEntity<List<BrandDTO>> get() {
		return new ResponseEntity<List<BrandDTO>>(brandService.findAll().stream().map(BrandDTO::new).collect(Collectors.toList()), HttpStatus.OK);
	}
}
