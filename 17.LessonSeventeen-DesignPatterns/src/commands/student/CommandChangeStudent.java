package commands.student;

import java.util.ArrayList;

import commands.Command;
import models.Student;
import utils.Utility;

public class CommandChangeStudent implements Command {
	private ArrayList<Student> students;
	private Student oldStudent;
	private Student newStudent;
	
	public CommandChangeStudent(ArrayList<Student> students) {
		this.students = students;
	}

	@Override
	public void execute() {
		newStudent = Utility.findStudentOnIndex(students);
		if(newStudent != null){
			String name = Utility.readString("Enter the name of the student.");
			String surname = Utility.readString("Enter the surname of the student.");
			int index = Utility.readInteger("Enter the index of the student.");
			
			oldStudent = newStudent.cloneStudent(newStudent);
			newStudent.setName(name);
			newStudent.setSurname(surname);
			newStudent.setIndex(index);
		}else
			System.out.println("Student doesn't exist.");
	}

	@Override
	public void undo() {
		for (Student student : students) 
			if(student.getIndex() == newStudent.getIndex())
				student = oldStudent;
	}
}
