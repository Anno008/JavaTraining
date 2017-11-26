package school.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import school.dto.ExamDTO;
import school.model.Exam;
import school.service.ExamService;

@RestController
public class ExamController {
	@Autowired
	private ExamService examService;

	@GetMapping(value = "api/exams")
	public ResponseEntity<List<ExamDTO>> getExams() {
		return new ResponseEntity<List<ExamDTO>>(
				examService.findAll().stream().map(ExamDTO::new).collect(Collectors.toList()), HttpStatus.OK);
	}

	@GetMapping(value = "api/exams/{id}")
	public ResponseEntity<ExamDTO> getExam(@PathVariable Long id) {
		Exam exam = examService.findOne(id);
		return exam == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<ExamDTO>(new ExamDTO(exam), HttpStatus.OK);
	}

	@DeleteMapping(value = "api/exams/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
		Exam exam = examService.findOne(id);
		if (exam == null) 
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		
		examService.remove(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
