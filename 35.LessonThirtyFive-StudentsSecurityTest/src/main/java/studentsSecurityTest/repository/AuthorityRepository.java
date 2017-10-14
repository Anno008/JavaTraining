package studentsSecurityTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import studentsSecurityTest.model.user.SecurityAuthority;

public interface AuthorityRepository extends JpaRepository<SecurityAuthority, Long> {
	SecurityAuthority findByName(String name);
}
