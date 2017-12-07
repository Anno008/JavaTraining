package pcShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pcShop.model.Component;
import pcShop.repository.ComponentRepository;

@org.springframework.stereotype.Component
public class ComponentService {
	@Autowired
	private ComponentRepository componentRepository;
	
	public List<Component> findAll() {
		return componentRepository.findAll();
	}
	
	public Page<Component> findAll(Pageable page) {
		return componentRepository.findAll(page);
	}

	public Component findOne(Long id) {
		return componentRepository.findOne(id);
	}

	public Component save(Component comp) {
		return componentRepository.save(comp);
	}

	public void remove(Long id) {
		componentRepository.delete(id);
	}

}
