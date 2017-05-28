package commands.student;

import java.util.ArrayList;

import commands.Command;
import models.Student;
import utils.Utility;

public class CommandFindStudent implements Command {
	private ArrayList<Student> students;

	public CommandFindStudent(ArrayList<Student> students) {
		this.students = students;
	}

	@Override
	public void execute() {
		Student st = Utility.findStudentOnIndex(students);
		if (st != null)
			System.out.println(st);
		else
			System.out.println("Student doesn't exist.");
	}

	@Override
	public void undo() {
		// Nothing to undo
	}
}
