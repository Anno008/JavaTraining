package models;

public class Exam {
	private int id;
	private Student student;
	private Subject subject;
	private int grade;
	
	public Exam(int id, Student student,Subject subject, int grade){
		this.id = id;
		this.student = student;
		this.subject = subject;
		this.grade = grade;
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

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getIndex() {
		return id;
	}

	public void setIndex(int id) {
		this.id = id;
	}
}
