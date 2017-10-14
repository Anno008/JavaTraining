package studentsSecurityTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import studentsSecurityTest.model.Subject;

@Component
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
