package school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import school.model.Exam;
import school.repository.ExamRepository;


@Component
public class ExamService {
	@Autowired
	private ExamRepository examRepository;

	public List<Exam> findAll() {
		return examRepository.findAll();
	}

	public Page<Exam> findAll(Pageable page) {
		return examRepository.findAll(page);
	}

	public Exam findOne(Long id) {
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

	public Page<Exam> findByStudentId(Long studentId, Pageable page) {
		return examRepository.findByStudentId(studentId, page);
	}

	public List<Exam> findBySubjectId(Long subjectId) {
		return examRepository.findBySubjectId(subjectId);
	}

	public Page<Exam> findBySubjectId(Long subjectId, Pageable page) {
		return examRepository.findBySubjectId(subjectId, page);
	}
}
