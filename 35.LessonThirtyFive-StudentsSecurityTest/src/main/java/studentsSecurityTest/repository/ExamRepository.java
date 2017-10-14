package studentsSecurityTest.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import studentsSecurityTest.model.Exam;
import studentsSecurityTest.model.Subject;

public interface ExamRepository extends JpaRepository<Exam, Long> {
	public List<Exam> findBySubjectId(Long id);

	public List<Exam> findByStudentId(Long studentId);

	public double findStudentAvgGrade(Long studentId);

	public List<Subject> findSubjectsByExamCount();
}
