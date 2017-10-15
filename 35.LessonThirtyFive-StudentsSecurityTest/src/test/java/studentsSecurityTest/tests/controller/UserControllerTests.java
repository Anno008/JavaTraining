package studentsSecurityTest.tests.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import studentsSecurityTest.dto.LoginDTO;
import studentsSecurityTest.dto.StudentDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTests {
	@Autowired
	private TestRestTemplate restTemplate;

	private String accessToken;

	@Before
	public void login() {
		ResponseEntity<String> responseEntity = restTemplate.postForEntity("/api/login", new LoginDTO("admin", "12345"),
				String.class);
		accessToken = responseEntity.getBody();
	}

	@Test
	public void testGetStudents() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-Auth-Token", accessToken);
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(headers);

		ResponseEntity<StudentDTO[]> responseEntity = restTemplate.exchange("/api/students", HttpMethod.GET, httpEntity,
				StudentDTO[].class);

		StudentDTO[] students = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(3, students.length);
		assertEquals("e11", students[0].getCard());
		assertEquals("Jack", students[0].getName());
		assertEquals("Sparrow", students[0].getSurname());
	}
}
