package commands.student;

import java.util.ArrayList;

import commands.Command;
import models.Student;
import utils.Utility;

public class CommandAverageGrade implements Command {
	private ArrayList<Student> students;

	public CommandAverageGrade(ArrayList<Student> students) {
		this.students = students;
	}

	@Override
	public void execute() {
		double average = Utility.readDouble("Enter the average grade on which you want to filter students.");
		for (Student student : students) {
			if (student.getExams().stream().mapToInt(e -> e.getGrade()).sum() > average)
				System.out.println(students);
		}
	}

	@Override
	public void undo() {
		// Nothing to undo
	}

}
