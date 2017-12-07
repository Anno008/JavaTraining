package pcShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pcShop.model.Component;
import pcShop.service.ComponentService;

@RestController
public class ComponentController {

	@Autowired
	private ComponentService componentService;

	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "api/components")
	public Page<Component> get(Pageable pageable) {
		return componentService.findAll(pageable);
	}

	@PreAuthorize("hasAnyAuthority('Admin')")
	@PostMapping(value = "api/components")
	public ResponseEntity<Component> create(@RequestBody Component component) {
		return new ResponseEntity<Component>(componentService.save(component), HttpStatus.CREATED);
	}

	@PreAuthorize("hasAnyAuthority('Admin')")
	@DeleteMapping(value = "api/components/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
		Component c = componentService.findOne(id);

		if (c == null)
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);

		componentService.remove(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@PreAuthorize("hasAnyAuthority('Admin')")
	@PutMapping(value = "api/comonents/{id}")
	public ResponseEntity<Component> update(@PathVariable Long id, @RequestBody Component component) {
		Component c = componentService.findOne(id);

		if (c == null)
			return new ResponseEntity(HttpStatus.NOT_FOUND);

		c.setName(component.getName());
		c.setPrice(component.getPrice());
		c.setBrand(component.getBrand());
		c.setComponentType(component.getComponentType());
		return new ResponseEntity<Component>(componentService.save(c), HttpStatus.OK);

	}

}
