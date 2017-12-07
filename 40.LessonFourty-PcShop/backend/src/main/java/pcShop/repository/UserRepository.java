package pcShop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import pcShop.model.security.SecurityUser;

@Component
public interface UserRepository extends JpaRepository<SecurityUser, Long> {
	Optional<SecurityUser> findByUsername(String username);
}
