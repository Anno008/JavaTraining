package school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import school.model.Subject;
import school.repository.SubjectRepository;

@Component
public class SubjectService {
	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private ExamService examService;

	public List<Subject> findAll() {
		return subjectRepository.findAll();
	}

	public Page<Subject> findAll(Pageable page) {
		return subjectRepository.findAll(page);
	}

	public Subject findOne(Long id) {
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
