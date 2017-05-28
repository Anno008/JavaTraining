package commands.student;

import java.util.ArrayList;

import commands.Command;
import models.Student;

public class CommandDisplayStudents implements Command {
	private ArrayList<Student> students;

	public CommandDisplayStudents (ArrayList<Student> students){
		this.students = students;
	}

	@Override
	public void execute() {
		for (Student student : students) 
			System.out.println(student);

	}

	@Override
	public void undo() {
		// TODO Can't undo this		
	}
}
