package studentsSecurityTest.tests.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import studentsSecurityTest.model.Exam;
import studentsSecurityTest.repository.ExamRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExamRepositoryIntegrationTests {

	@Autowired
	private ExamRepository examRepository;

	@Test
	public void testFindBySubjectId() {
		List<Exam> exams = examRepository.findBySubjectId(1L);

		assertEquals(exams.size(), 2);
		assertEquals(exams.get(0).getGrade(), 9);
	}
	
	@Test
	public void testFindByStudentId() {
		List<Exam> exams = examRepository.findByStudentId(1L);

		assertEquals(exams.size(), 1);
		assertEquals(exams.get(0).getGrade(), 7);
	}
}
