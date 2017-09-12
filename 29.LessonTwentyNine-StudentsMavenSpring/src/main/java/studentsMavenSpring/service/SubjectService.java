package studentsMavenSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import studentsMavenSpring.model.Subject;
import studentsMavenSpring.repository.SubjectRepository;

@Component
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	public List<Subject> findAll() {
		return subjectRepository.findAll();
	}

	public Subject find(int id) {
		return subjectRepository.find(id);
	}

	public void save(Subject subject) {
		subjectRepository.save(subject);
	}

	public void delete(int id) {
		subjectRepository.delete(id);
	}
}
