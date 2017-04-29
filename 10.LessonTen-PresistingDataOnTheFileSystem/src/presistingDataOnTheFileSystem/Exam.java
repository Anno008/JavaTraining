package presistingDataOnTheFileSystem;

public class Exam {
	private String studentIdentifier;
	private Subject subject;
	private int grade;

	public Exam(String studentIdentifier, Subject subject, int grade) {
		this.studentIdentifier = studentIdentifier;
		this.subject = subject;
		this.grade = grade;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject predmet) {
		this.subject = predmet;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getStudentIdentifier() {
		return studentIdentifier;
	}

	public void setStudentIdentifier(String studentIdentifier) {
		this.studentIdentifier = studentIdentifier;
	}
}
