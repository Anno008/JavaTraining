package springDataJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import springDataJpa.model.Exam;

@Component
public interface ExamRepository extends JpaRepository<Exam, Long> {

}
