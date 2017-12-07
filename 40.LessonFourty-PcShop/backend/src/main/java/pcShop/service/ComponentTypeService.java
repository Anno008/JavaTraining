package pcShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pcShop.model.ComponentType;
import pcShop.repository.ComponentTypeRepository;

@Component
public class ComponentTypeService {
	@Autowired
	private ComponentTypeRepository componentTypeRepository;
	
	public List<ComponentType> findAll() {
		return componentTypeRepository.findAll();
	}
}
