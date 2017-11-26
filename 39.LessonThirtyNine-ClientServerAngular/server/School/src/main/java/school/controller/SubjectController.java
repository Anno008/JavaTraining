package school.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import school.dto.SubjectDTO;
import school.model.Subject;
import school.service.SubjectService;

@RestController
public class SubjectController {
	@Autowired
	private SubjectService subjectService;

	@GetMapping(value = "api/subjects")
	public ResponseEntity<List<SubjectDTO>> getSubjects() {
		return new ResponseEntity<List<SubjectDTO>>(
				subjectService.findAll().stream().map(SubjectDTO::new).collect(Collectors.toList()), HttpStatus.OK);
	}

	@GetMapping(value = "api/subjects/{id}")
	public ResponseEntity<SubjectDTO> getSubject(@PathVariable Long id) {
		Subject subject = subjectService.findOne(id);

		return subject == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<>(new SubjectDTO(subject), HttpStatus.OK);
	}

	@PostMapping(value = "api/subjects")
	public ResponseEntity<SubjectDTO> create(@RequestBody SubjectDTO subjectDTO) {
		Subject subject = new Subject();
		subject.setName(subjectDTO.getName());
		subject.setEspb(subjectDTO.getEspb());

		return new ResponseEntity<SubjectDTO>(new SubjectDTO(subjectService.save(subject)), HttpStatus.CREATED);
	}

	@PutMapping(value = "api/subjects/{id}")
	public ResponseEntity<SubjectDTO> update(@PathVariable Long id, @RequestBody SubjectDTO subjectDto) {
		Subject subject = subjectService.findOne(id);

		if (subject == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		subject.setId(id);
		subject.setName(subjectDto.getName());
		subject.setEspb(subjectDto.getEspb());

		return new ResponseEntity<SubjectDTO>(new SubjectDTO(subjectService.save(subject)), HttpStatus.OK);
	}

	@DeleteMapping(value = "api/subjects/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
		Subject subject = subjectService.findOne(id);
		if (subject == null)
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);

		subjectService.remove(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
