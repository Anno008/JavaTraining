package springDataJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springDataJpa.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
