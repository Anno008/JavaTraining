package project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import project.model.security.SecurityUser;

@Component
public interface UserRepository extends JpaRepository<SecurityUser, Long> {
	Optional<SecurityUser> findByUsername(String username);
}
