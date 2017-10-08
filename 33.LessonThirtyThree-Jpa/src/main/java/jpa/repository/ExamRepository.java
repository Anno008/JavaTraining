package jpa.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jpa.model.Exam;
import jpa.model.Subject;

@Component
@Transactional
public class ExamRepository {
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	SubjectRepository subjectRepository;

	@SuppressWarnings("unchecked")
	public List<Exam> get() {
		return em.createQuery("SELECT e FROM Exam e").getResultList();
	}

	public Exam get(Long id) {
		return em.find(Exam.class, id);
	}

	public Exam save(Exam exam) {
		em.persist(exam);
		return exam;		
	}
	
	public void delete(Long id) {
		em.remove(get(id));
	}
	
	public List<Exam> findByStudentId(Long studentId) {
		return new ArrayList<Exam>(studentRepository.get(studentId).getExams());
	}
	
	public List<Exam> findBySubjectId(Long courseId) {
		return new ArrayList<Exam>(subjectRepository.get(courseId).getExams());
	}
	
	public double findStudentAvgGrade(Long studentId) {
		Query q = em.createQuery("SELECT avg(e.grade) from Exam e where e.student.id = :id");
		q.setParameter("id", studentId);
		return (double) q.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Subject> findSubjectsByExamCount() {
		return em.createQuery("SELECT e.subject from Exam e group by e.subject order by count(e.subject)").getResultList();
	}
}
