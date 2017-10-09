package springDataJpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import springDataJpa.model.Student;

@Component
public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByCardNumber(String cardNumber);

	List<Student> findAllWithExams();

}
