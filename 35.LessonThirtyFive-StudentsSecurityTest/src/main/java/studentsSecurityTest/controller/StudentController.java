package studentsSecurityTest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import studentsSecurityTest.dto.ExamDTO;
import studentsSecurityTest.dto.StudentDTO;
import studentsSecurityTest.model.Exam;
import studentsSecurityTest.model.Student;
import studentsSecurityTest.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

//	@RequestMapping(value = "/api/students", method = RequestMethod.GET)
//	public ResponseEntity<List<StudentDTO>> getStudentsPage(Pageable page) {
//		return new ResponseEntity<>(studentService.findAll(page).getContent().stream().map(s -> new StudentDTO(s))
//				.collect(Collectors.toList()), HttpStatus.OK);
//	}

	@RequestMapping(value = "/api/students", method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getStudentsPage() {
		return new ResponseEntity<>(
				studentService.findAll().stream().map(s -> new StudentDTO(s)).collect(Collectors.toList()),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/api/students", method = RequestMethod.GET, params = "withExams")
	public ResponseEntity<List<StudentDTO>> getStudentsPageWithExams(Pageable page, @RequestParam boolean withExams) {
		List<StudentDTO> retVal = new ArrayList<>();
		for (Student s : studentService.findAll(page)) {
			StudentDTO stDTO = new StudentDTO(s);
			if (withExams) {
				for (Exam e : s.getExams()) {
					stDTO.getExams().add(new ExamDTO(e));
				}
			}
			retVal.add(stDTO);
		}

		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
}
