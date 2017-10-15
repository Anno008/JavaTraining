package studentsSecurityTest.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import studentsSecurityTest.model.Student;

@Component
public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByCard(String cardNumber);
}
