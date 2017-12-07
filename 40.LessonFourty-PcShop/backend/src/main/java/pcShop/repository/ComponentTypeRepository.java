package pcShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import pcShop.model.ComponentType;

@Component
public interface ComponentTypeRepository extends JpaRepository<ComponentType, Long> {

}
