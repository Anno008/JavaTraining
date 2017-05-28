package management;

import java.util.ArrayList;
import java.util.Stack;

import commands.Command;
import commands.exams.*;
import commands.student.*;
import commands.subjects.*;
import models.Student;
import models.Subject;
import utils.Utility;

// this will be singleton
public class Management {

	// private constructor so no one can make an instance of this class
	private Management() {
	}

	private static Management instance = new Management();

	public static Management getInstance() {
		return instance;
	}

	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	private Stack<Command> commands = new Stack<Command>();

	public void start() {
		int option = 0;
		do {
			showMenu();
			int op = Utility.readInteger("Enter the otption.");

			switch (op) {
			case 1:
				displayStudents();
				break;
			case 2:
				findStudent();
				break;
			case 3:
				createStudent();
				break;
			case 4:
				changeStudent();
				break;
			case 5:
				deleteStudent();
				break;
			case 6:
				displaySubjects();
				break;
			case 7:
				findSubject();
				break;
			case 8:
				createSubject();
				break;
			case 9:
				changeSubject();
				break;
			case 10:
				deleteSubject();
				break;
			case 11:
				addExam();
				break;
			case 12:
				deleteExam();
				break;
			case 13:
				findStudentAverageGrade();
				break;
			case 14:
				undo();
				break;
			case 15:
				System.out.println("Exiting...");
			}
		} while (option != 15);
	}

	private void undo() {
		Command cmdToUndo = commands.pop();
		cmdToUndo.undo();
	}

	private void findStudentAverageGrade() {
		Command averageGradeCmd = new CommandAverageGrade(students);
		averageGradeCmd.execute();
	}

	private void addExam() {
		Command addExamCmd = new CommandTakeExam(students, subjects);
		commands.push(addExamCmd);
		addExamCmd.execute();
	}

	private void deleteExam() {
		Command deleteExamCmd = new CommandDeleteExam(students,subjects);
		commands.push(deleteExamCmd);
		deleteExamCmd.execute();
	}

	private void changeSubject() {
		Command changeCmd = new CommandChangeSubject(subjects);
		commands.push(changeCmd);
		changeCmd.execute();

	}

	private void deleteSubject() {
		Command deleteCmd = new CommandDeleteSubject(subjects);
		commands.push(deleteCmd);
		deleteCmd.execute();
	}

	private void createSubject() {
		Command createCmd = new CommandCreateSubject(subjects);
		commands.push(createCmd);
		createCmd.execute();
	}

	private void findSubject() {
		Command findCmd = new CommandFindSubject(subjects);
		findCmd.execute();
	}

	private void displaySubjects() {
		Command displayCmd = new CommandDisplayStubjects(subjects);
		displayCmd.execute();
	}

	private void deleteStudent() {
		Command deleteCmd = new CommandDeleteStudent(students);
		deleteCmd.execute();
		commands.push(deleteCmd);

	}

	private void changeStudent() {
		Command changeCmd = new CommandChangeStudent(students);
		commands.push(changeCmd);
		changeCmd.execute();
	}

	private void createStudent() {
		Command createCmd = new CommandCreateStudent(students);
		commands.push(createCmd);
		createCmd.execute();
	}

	private void findStudent() {
		Command findCmd = new CommandFindStudent(students);
		findCmd.execute();
	}

	private void displayStudents() {
		Command displayCmd = new CommandDisplayStudents(students);
		displayCmd.execute();
	}

	private void showMenu() {
		System.out.println("===================================");
		System.out.println("1. Display students");
		System.out.println("2. Find a student");
		System.out.println("3. Create a student");
		System.out.println("4. Change a student");
		System.out.println("5. Delete a student\n");
		System.out.println("6. Display subjects");
		System.out.println("7. Find a subject");
		System.out.println("8. Create a subject");
		System.out.println("9. Chnage a subject");
		System.out.println("10. Delete a subject\n");
		System.out.println("11. Take an exam");
		System.out.println("12. Delete an exam");
		System.out.println("13. Find a student based on average grade");
		System.out.println("14. Undo");
		System.out.println("15. Exit");
	}

}
