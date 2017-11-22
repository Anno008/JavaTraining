package school.dto;

import java.util.ArrayList;
import java.util.List;

import school.model.Student;

public class StudentDTO {
	private Long id;
	private String name;
	private String surname;
	private String card;
	private List<ExamDTO> exams = new ArrayList<ExamDTO>();

	public StudentDTO() {

	}

	public StudentDTO(Long id, String name, String surname, String card, List<ExamDTO> exams) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.card = card;
		this.exams = exams;
	}

	public StudentDTO(Student student) {
		this.id = student.getId();
		this.name = student.getName();
		this.surname = student.getSurname();
		this.card = student.getCard();
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public List<ExamDTO> getExams() {
		return exams;
	}

	public void setExams(List<ExamDTO> exams) {
		this.exams = exams;
	}

}
