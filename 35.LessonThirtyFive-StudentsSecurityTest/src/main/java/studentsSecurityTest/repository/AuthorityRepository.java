package studentsSecurityTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import studentsSecurityTest.model.user.SecurityAuthority;

@Component
public interface AuthorityRepository extends JpaRepository<SecurityAuthority, Long> {
	SecurityAuthority findByName(String name);
}
