package springDataJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import springDataJpa.model.Student;

@Component
public interface StudentRepository extends JpaRepository<Student, Long> {

}
