package models;

public class Exam {
	private Subject subject;
	private int grade;

	public Exam(Subject subject, int grade) {
		this.subject = subject;
		this.grade = grade;
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
}
