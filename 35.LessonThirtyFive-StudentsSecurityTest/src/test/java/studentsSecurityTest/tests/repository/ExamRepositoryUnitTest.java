package studentsSecurityTest.tests.repository;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import studentsSecurityTest.model.Exam;
import studentsSecurityTest.model.Student;
import studentsSecurityTest.model.Subject;
import studentsSecurityTest.repository.ExamRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ExamRepositoryUnitTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ExamRepository examRepository;

	@Test
	public void testFindBySubjectId() {
		Student st = new Student("Test", "Test", "1");
		Subject sub = new Subject("Test Subject", 20);

		entityManager.persist(sub);
		entityManager.persist(st);
		entityManager.persist(new Exam(st, sub, 9));

		List<Exam> exams = examRepository.findBySubjectId(2L);

		assertEquals(1, exams.size());
		assertEquals(9, exams.get(0).getGrade());
		assertEquals(st, exams.get(0).getStudent());
		assertEquals(sub, exams.get(0).getSubject());
	}

	@Test
	public void testFindByStudentId() {
		Student st = new Student("Test", "Test", "1");
		Subject sub = new Subject("Test Subject", 20);

		entityManager.persist(st);
		entityManager.persist(sub);
		entityManager.persist(new Exam(st, sub, 9));

		List<Exam> exams = examRepository.findByStudentId(1L);

		assertEquals(1, exams.size());
		assertEquals(9, exams.get(0).getGrade());
		assertEquals(st, exams.get(0).getStudent());
		assertEquals(sub, exams.get(0).getSubject());
	}
}
