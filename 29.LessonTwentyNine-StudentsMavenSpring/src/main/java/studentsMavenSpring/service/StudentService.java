package studentsMavenSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import studentsMavenSpring.model.Student;
import studentsMavenSpring.repository.StudentRepository;

@Component
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	public Student find(int id) {
		return studentRepository.find(id);
	}

	public void save(Student student) {
		studentRepository.save(student);
	}

	public void delete(int id) {
		studentRepository.delete(id);
	}
}
