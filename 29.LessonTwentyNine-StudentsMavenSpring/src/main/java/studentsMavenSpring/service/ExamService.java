package studentsMavenSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import studentsMavenSpring.model.Exam;
import studentsMavenSpring.repository.ExamRepository;

@Component
public class ExamService {
	@Autowired
	private ExamRepository examRepository;

	public List<Exam> findAll(){
		return examRepository.findAll();
	}
	
	public void save(Exam exam) {
		examRepository.save(exam);
	}
}
