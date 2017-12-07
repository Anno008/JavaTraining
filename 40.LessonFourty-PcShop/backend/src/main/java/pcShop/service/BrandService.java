package pcShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pcShop.model.Brand;
import pcShop.repository.BrandRepository;

@Component
public class BrandService {
	@Autowired
	private BrandRepository brandRepository;

	public List<Brand> findAll() {
		return brandRepository.findAll();
	}
}
