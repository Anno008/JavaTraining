package pcShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import pcShop.model.ShoppingCart;

@Component
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
	ShoppingCart findByUserUsername(String username);
}
