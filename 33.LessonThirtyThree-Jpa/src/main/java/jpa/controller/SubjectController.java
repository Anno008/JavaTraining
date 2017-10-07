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

import jpa.model.Subject;
import jpa.service.ExamService;
import jpa.service.SubjectService;

@RestController
@RequestMapping(value = "api/subjects")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired 
	private ExamService examService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Subject>> get(){
		return new ResponseEntity<>(subjectService.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Subject> getCourse(@PathVariable Long id) {
		return new ResponseEntity<>(subjectService.get(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Subject> create(@RequestBody Subject subject) {
		return new ResponseEntity<>(subjectService.save(subject), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Subject> update(@PathVariable Long id,
			@RequestBody Subject subject) {
		subject.setId(id);
		return new ResponseEntity<>(subjectService.save(subject), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Subject subject  = subjectService.get(id);
		if (subject != null) {
			subjectService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping( method = RequestMethod.GET, params = "sortByExamCount")
	public ResponseEntity<List<Subject>> getCoursesByExamCount(
			@RequestParam boolean sortByExamCount) {
		return new ResponseEntity<>(examService.findSubjectsByExamCount(), HttpStatus.OK);
	}
}
