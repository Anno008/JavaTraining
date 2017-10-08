package springDataJpa.service;

import java.util.List;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springDataJpa.repository.SubjectRepository;

@Component
public class SubjectService {
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	ExamService examService;

	public List<Subject> get() {
		return subjectRepository.findAll();
	}

	public Subject get(Long id) {
		return subjectRepository.findOne(id);
	}

	public Subject save(Subject subject) {
		return subjectRepository.save(subject);
	}

	public void remove(Long id) {
		if (examService.findBySubjectId(id).isEmpty()) {
			subjectRepository.delete(id);
		}
	}
}
