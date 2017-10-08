package springDataJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springDataJpa.model.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {

}
