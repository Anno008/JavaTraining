package studentsSecurityTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import studentsSecurityTest.model.user.SecurityUser;

@Component
public interface UserRepository extends JpaRepository<SecurityUser, Long>{

}
