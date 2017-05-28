package commands.student;

import java.util.ArrayList;

import commands.Command;
import models.Student;
import utils.Utility;

public class CommandCreateStudent implements Command {
	private ArrayList<Student> students;
	private Student newStudent;

	public CommandCreateStudent(ArrayList<Student> students) {
		this.students = students;
	}

	@Override
	public void execute() {
		String name = Utility.readString("Enter the name of the student.");
		String surname = Utility.readString("Enter the surname of the student.");
		int index = Utility.readInteger("Enter the index of the student.");

		newStudent = new Student(index, name, surname);
		students.add(newStudent);
		System.out.println("Student created: " + newStudent);
	}

	@Override
	public void undo() {
		students.remove(newStudent);
		System.out.println("Undo executed, student removed: " + newStudent);
	}
}
