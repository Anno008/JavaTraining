package studentsSecurityTest.tests.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import studentsSecurityTest.model.Student;
import studentsSecurityTest.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class StudentRepositoryIntegrationTests {
	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void testFindByCardNumber() {
		List<Student> students = studentRepository.findByCard("e11");
		
		assertEquals(students.size(), 2);
		assertEquals(students.get(0).getName(), "Jack");
		assertEquals(students.get(0).getSurname(), "Sparrow");
	}
}
