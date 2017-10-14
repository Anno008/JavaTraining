package studentsSecurityTest.tests.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import studentsSecurityTest.model.Student;
import studentsSecurityTest.repository.StudentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryUnitTests {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void testFindByCard() {
		entityManager.persist(new Student("Jack", "Sparrow", "1"));
		entityManager.persist(new Student("Wendy", "Black", "2"));

		List<Student> students = studentRepository.findByCard("1");

		assertEquals(students.size(), 1);
		assertEquals(students.get(0).getName(), "Jack");
		assertEquals(students.get(0).getSurname(), "Sparrow");
	}
}
