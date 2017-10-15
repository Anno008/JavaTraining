package studentsSecurityTest.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Exam {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Student student;

	@ManyToOne(fetch = FetchType.EAGER)
	private Subject subject;

	private int grade;

	public Exam() {

	}

	public Exam(Student student, Subject subject, int grade) {
		this.student = student;
		this.subject = subject;
		this.grade = grade;
	}

	public Exam(Long id, Student student, Subject subject, int grade) {
		this.id = id;
		this.student = student;
		this.subject = subject;
		this.grade = grade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setCourse(Subject subject) {
		this.subject = subject;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}
