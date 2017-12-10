package pcShop.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pcShop.dto.ComponentTypeDTO;
import pcShop.service.ComponentTypeService;

@RestController
public class ComponentTypeController {
	@Autowired
	private ComponentTypeService componentTypeService;
	
	@GetMapping(value = "api/componentTypes")
	public ResponseEntity<List<ComponentTypeDTO>> get() {
		return new ResponseEntity<List<ComponentTypeDTO>>(componentTypeService.findAll().stream().map(ComponentTypeDTO::new).collect(Collectors.toList()), HttpStatus.OK);
	}
}
