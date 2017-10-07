package jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jpa.model.Subject;
import jpa.repository.SubjectRepository;

@Component
public class SubjectService {
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	ExamService examService;

	public List<Subject> get() {
		return subjectRepository.get();
	}

	public Subject get(Long id) {
		return subjectRepository.get(id);
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
