package studentsSecurityTest.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import studentsSecurityTest.model.Exam;

@Component
public interface ExamRepository extends JpaRepository<Exam, Long> {
	@Query("SELECT e FROM Exam e WHERE e.subject.id = :id")
	public List<Exam> findBySubjectId(@Param("id") Long subjectId);

	@Query("SELECT e FROM Exam e WHERE e.subject.id = :id")
	public Page<Exam> findBySubjectId(@Param("id") Long subjectId, Pageable page);

	@Query("SELECT e FROM Exam e WHERE e.student.id = :id")
	public List<Exam> findByStudentId(@Param("id") Long studentId);

	@Query("SELECT e FROM Exam e WHERE e.student.id = :id")
	public Page<Exam> findByStudentId(@Param("id") Long studentId, Pageable page);

	@Query("SELECT AVG(e.grade) from Exam e where e.student.id = :id")
	public double findStudentAvgGrade(@Param("id") Long studentId);
}
