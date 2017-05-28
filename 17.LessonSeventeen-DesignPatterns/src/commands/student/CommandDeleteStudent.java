package commands.student;

import java.util.ArrayList;

import commands.Command;
import models.Student;
import utils.Utility;

public class CommandDeleteStudent implements Command {
	private ArrayList<Student> students;
	private Student st;

	public CommandDeleteStudent(ArrayList<Student> students) {
		this.students = students;
	}

	@Override
	public void execute() {
		st = Utility.findStudentOnIndex(students);
		if (st != null)
			students.remove(st);
	}

	@Override
	public void undo() {
		students.add(st);
	}
}
