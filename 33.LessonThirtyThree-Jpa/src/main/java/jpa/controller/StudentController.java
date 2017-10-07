package jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jpa.model.Student;
import jpa.service.StudentService;

@RestController
@RequestMapping(value = "api/students")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Student>> get() {
		return new ResponseEntity<>(studentService.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> get(@PathVariable Long id) {
		return new ResponseEntity<>(studentService.get(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Student> post(@RequestBody Student student) {
		return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
		student.setId(id);

		return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Student student = studentService.get(id);
		if (student != null) {
			studentService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.GET, params = "cardNumber")
	public ResponseEntity<Student> getStudentsByCardNumber(@RequestParam String cardNumber) {
		return new ResponseEntity<>(studentService.findByCardNumber(cardNumber), HttpStatus.OK);
	}
}
