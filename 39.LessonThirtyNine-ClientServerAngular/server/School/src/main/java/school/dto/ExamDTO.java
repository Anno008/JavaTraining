package school.dto;

import school.model.Exam;

public class ExamDTO {
	private Long id;
	private StudentDTO student;
	private SubjectDTO subject;
	private int grade;
	
	public ExamDTO () {
		
	}

	public ExamDTO(Long id, StudentDTO student, SubjectDTO subject, int grade) {
		super();
		this.id = id;
		this.student = student;
		this.subject = subject;
		this.grade = grade;
	}
	
	public ExamDTO(Exam exam) {
		this.id = exam.getId();
		this.student = new StudentDTO(exam.getStudent());
		this.subject = new SubjectDTO(exam.getSubject());
		this.grade = exam.getGrade();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public SubjectDTO getSubject() {
		return subject;
	}

	public void setSubject(SubjectDTO subject) {
		this.subject = subject;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
}
