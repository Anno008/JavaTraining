package school.dto;

import java.util.ArrayList;
import java.util.List;

import school.model.Subject;

public class SubjectDTO {
	private Long id;
	private String name;
	private int espb;

	private List<ExamDTO> exams = new ArrayList<ExamDTO>();

	public SubjectDTO() {

	}

	public SubjectDTO(Long id, String name, int espb, List<ExamDTO> exams) {
		super();
		this.id = id;
		this.name = name;
		this.espb = espb;
		this.exams = exams;
	}

	public SubjectDTO(Subject subject) {
		this.id = subject.getId();
		this.name = subject.getName();
		this.espb = subject.getEspb();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public List<ExamDTO> getExams() {
		return exams;
	}

	public void setExams(List<ExamDTO> exams) {
		this.exams = exams;
	}
}
