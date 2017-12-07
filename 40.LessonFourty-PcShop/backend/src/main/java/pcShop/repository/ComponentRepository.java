package pcShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ComponentRepository extends JpaRepository<pcShop.model.Component, Long> {

}
