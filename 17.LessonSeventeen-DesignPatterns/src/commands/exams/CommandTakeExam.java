package commands.exams;

import java.util.ArrayList;

import commands.Command;
import models.Exam;
import models.Student;
import models.Subject;
import utils.Utility;

public class CommandTakeExam implements Command {
	private ArrayList<Student> students;
	private ArrayList<Subject> subjects;
	private Student student;
	private Subject subject;
	private Exam exam;

	public CommandTakeExam(ArrayList<Student> students, ArrayList<Subject> subjects) {
		this.students = students;
		this.subjects = subjects;
	}

	@Override
	public void execute() {
		student = Utility.findStudentOnIndex(students);
		subject = Utility.findSubjectOnIndex(subjects);

		if (student != null && subject != null) {
			int grade = Utility.readInteger("Enter the grade that the studnet: " + student.getName() + " has earned on the subject: " + subject.getName());
			exam = new Exam(subject, grade);
			student.addExam(exam);
		} else
			System.out.println("Non existing student or/and subject");
	}

	@Override
	public void undo() {
		student.removeExam(exam);
	}
}
