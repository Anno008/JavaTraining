package school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import school.model.Student;
import school.repository.StudentRepository;

@Component
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	 @Autowired
	 private ExamService examService;

	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	public Page<Student> findAll(Pageable page) {
		return studentRepository.findAll(page);
	}

	public Student findOne(Long id) {
		return studentRepository.findOne(id);
	}

	public Student save(Student student) {
		return studentRepository.save(student);
	}

	public void remove(Long id) {
		if (examService.findByStudentId(id).isEmpty()) {
			studentRepository.delete(id);
		}
	}

	public List<Student> findByCard(String card) {
		return studentRepository.findByCard(card);
	}
}
