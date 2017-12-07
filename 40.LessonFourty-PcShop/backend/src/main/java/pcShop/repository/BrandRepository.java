package pcShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import pcShop.model.Brand;

@Component
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
