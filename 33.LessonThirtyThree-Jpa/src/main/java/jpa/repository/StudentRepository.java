package jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import jpa.model.Student;

@Component
@Transactional
public class StudentRepository {
	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Student> get() {
		return em.createQuery("SELECT s FROM student").getResultList();
	}

	public Student get(Long id) {
		return em.find(Student.class, id);
	}

	public Student save(Student student) {
		if (student.getId() != null) {
			return em.merge(student);
		} else {
			em.persist(student);
			return student;
		}

	}

	public void delete(Long id) {
		em.remove(get(id));
	}
	
	public Student findByCardNumber(String cardNumber) {
		Query q = em.createQuery("SELECT s FROM Student s WHERE card = :card");
		q.setParameter("cardNumber", cardNumber); 
		return (Student) q.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> findAllWithExams() {
		return em.createQuery("SELECT s FROM Student s left join fetch s.exams").getResultList();
	}
}
