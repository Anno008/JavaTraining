package jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import jpa.model.Subject;

@Component
@Transactional
public class SubjectRepository {

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Subject> get() {
		return em.createQuery("SELECT s FROM Subject s").getResultList();
	}

	public Subject get(Long id) {
		return em.find(Subject.class, id);
	}

	public Subject save(Subject subject) {
		if (subject.getId() != null) {
			return em.merge(subject);
		} else {
			em.persist(subject);
			return subject;
		}
	}

	public void delete(Long id) {
		em.remove(get(id));
	}
}
