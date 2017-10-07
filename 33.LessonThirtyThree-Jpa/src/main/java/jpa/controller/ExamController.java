package jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jpa.model.Exam;
import jpa.service.ExamService;

@RestController
@RequestMapping(value = "api/exams")
public class ExamController {
	@Autowired
	private ExamService examService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Exam>> getAllExams() {
		return new ResponseEntity<>(examService.get(), HttpStatus.OK); 
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Exam> getExam(@PathVariable Long id) {
		return new ResponseEntity<>(examService.get(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Exam> create(@RequestBody Exam exam) {
		return new ResponseEntity<>(examService.save(exam), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Exam exam = examService.get(id);
		if (exam != null) {
			examService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "api/students/{studentId}/exams", method = RequestMethod.GET)
	public ResponseEntity<List<Exam>> findStudentExams(@PathVariable Long studentId) {
		return new ResponseEntity<>(examService.findByStudentId(studentId), HttpStatus.OK); 
	}
	
	@RequestMapping(value = "api/students/{studentId}/exams/avg", method = RequestMethod.GET)
	public ResponseEntity<Double> findStudentAvgGrade(@PathVariable Long studentId) {
		return new ResponseEntity<>(examService.findStudentAvgGrade(studentId), HttpStatus.OK); 
	}
}
