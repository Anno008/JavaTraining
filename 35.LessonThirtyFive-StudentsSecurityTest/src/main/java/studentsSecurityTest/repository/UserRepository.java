package studentsSecurityTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import studentsSecurityTest.model.user.SecurityUser;

public interface UserRepository extends JpaRepository<SecurityUser, Long>{

}
