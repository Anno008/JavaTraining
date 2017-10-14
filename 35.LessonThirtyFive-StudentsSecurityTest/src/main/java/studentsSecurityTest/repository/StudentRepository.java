package studentsSecurityTest.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import studentsSecurityTest.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	Student findByCardNumber(String cardNumber);

	List<Student> findAllWithExams();
}
