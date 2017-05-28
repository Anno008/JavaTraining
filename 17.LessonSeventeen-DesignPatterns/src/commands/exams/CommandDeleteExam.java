package commands.exams;

import java.util.ArrayList;

import commands.Command;
import models.Exam;
import models.Student;
import models.Subject;
import utils.Utility;

public class CommandDeleteExam implements Command {
	private ArrayList<Student> students;
	private ArrayList<Subject> subjects;
	private Student student;
	private Subject subject;
	private Exam exam;

	public CommandDeleteExam(ArrayList<Student> students, ArrayList<Subject> subjects) {
		this.students = students;
		this.subjects = subjects;
	}

	@Override
	public void execute() {
		student = Utility.findStudentOnIndex(students);
		subject = Utility.findSubjectOnIndex(subjects);

		if (student != null && subject != null) {
			exam = student.getExams().stream().filter(e -> e.getSubject().getName().equals(subject.getName()))
					.findFirst().orElse(null);
			if (exam != null)
				student.removeExam(exam);
			else
				System.out.println("Student: " + student.getName() + " doesn't have an exam from the subject: " + subject.getName());
		} else
			System.out.println("Non existing student or/and subject");
	}

	@Override
	public void undo() {
		student.addExam(exam);
	}
}