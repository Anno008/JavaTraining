package studentsMavenSpring.model;

public class Exam {
	private int student_id;
	private int subject_id;
	private int grade;

	public Exam(int student_id, int subject_id, int grade) {
		this.student_id = student_id;
		this.subject_id = subject_id;
		this.grade = grade;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}
