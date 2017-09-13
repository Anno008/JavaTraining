package studentsMavenSpring.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import studentsMavenSpring.model.Exam;
import studentsMavenSpring.model.Student;
import studentsMavenSpring.model.Subject;
import studentsMavenSpring.service.ExamService;
import studentsMavenSpring.service.StudentService;
import studentsMavenSpring.service.SubjectService;
import studentsMavenSpring.utility.Utility;

@Component
public class ExamView {

	@Autowired
	private StudentService studentService;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private ExamService examService;

	public void start() {
		displayMenu();
		int option = Utility.readInteger("Enter the desired option:");
		switch (option) {
		case 1:
			takeAnExam();
			break;
		case 2:
			deleteAnExam();
			break;
		}
	}

	private void deleteAnExam() {
		System.out.println("Not implemented");
	}

	private void takeAnExam() {
		int studentId = Utility.readInteger("Enter the id of the student.");
		Student st = studentService.find(studentId);
		if (st == null) {
			System.out.println("Student with an id of: " + studentId + " doesn't exist");
			return;
		}
		int subjectId = Utility.readInteger("Enter the id of the subject.");
		Subject sb = subjectService.find(subjectId);
		if (sb == null) {
			System.out.println("Subject with an id of: " + studentId + " doesn't exist");
			return;
		}
		int grade = Utility.readInteger("Enter the grade that the student received.");
		examService.save(new Exam(studentId, subjectId, grade));

	}

	private void displayMenu() {
		System.out.println("1. Take an exam");
		System.out.println("2. Delete an exam");
	}

}
