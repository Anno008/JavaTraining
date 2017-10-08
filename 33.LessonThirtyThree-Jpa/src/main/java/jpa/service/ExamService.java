package jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jpa.model.Exam;
import jpa.model.Subject;
import jpa.repository.ExamRepository;

@Component
public class ExamService {
	@Autowired
	ExamRepository examRepository;

	public List<Exam> get() {
		return examRepository.get();
	}

	public Exam get(Long id) {
		return examRepository.get(id);
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
