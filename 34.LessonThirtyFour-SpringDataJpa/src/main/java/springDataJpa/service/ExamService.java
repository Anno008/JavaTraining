package springDataJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springDataJpa.model.Exam;
import springDataJpa.model.Subject;
import springDataJpa.repository.ExamRepository;

@Component
public class ExamService {
	@Autowired
	private ExamRepository examRepository;
	
	public List<Exam> get() {
		return examRepository.findAll();
	}

	public Exam get(Long id) {
		return examRepository.findOne(id);
	}

	public Exam save(Exam exam) {
		return examRepository.save(exam);
	}

	public void remove(Long id) {
		examRepository.delete(id);
	}

	public List<Exam> findByStudentId(Long studentId) {
		return examRepository.findByStudentId(studentId);
	}

	public List<Exam> findBySubjectId(Long subjectId) {
		return examRepository.findBySubjectId(subjectId);
	}

	public double findStudentAvgGrade(Long studentId) {
		return examRepository.findStudentAvgGrade(studentId);
	}

	public List<Subject> findSubjectsByExamCount() {
		return examRepository.findSubjectsByExamCount();
	}
}
