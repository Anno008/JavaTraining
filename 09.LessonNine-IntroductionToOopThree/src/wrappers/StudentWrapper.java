package wrappers;

import java.util.List;

import models.Student;
import util.*;

public class StudentWrapper {
	public static String displayStudents(List<Student> students) {
		String output = "";
		for (Student student : students)
			output += student.getInfo() + "\n";

		return output;
	}

	public static ObjectDecorator<Student> findStudent(List<Student> students) {
		int index = Utility.readInteger("Enter the index of the student");
		Student st = students.stream().filter(s -> s.getId() == index).findFirst().orElse(null);

		String output = "";
		if (st == null)
			output += "A student with the index of: " + index + " doesn't exist.";

		return new ObjectDecorator<Student>(st, output);
	}

	public static ObjectDecorator<Student> createStudent(List<Student> students) {
		int index = 1;
		for (int i = 1; i < students.size() + 2; i++) {
			final int temp = i;
			boolean exists = students.stream().anyMatch(s -> s.getId() == temp);
			if (!exists) {
				index = i;
				break;
			}
		}

		String name = Utility.readString("Enter the students name.");
		String surname = Utility.readString("Enter the students last name.");
		Student newStudent = new Student(index, name, surname);
		String output = "Student successfully added. Index: " + newStudent.getId() + ", student: " + newStudent.getFullName();
		return new ObjectDecorator<Student>(newStudent, output);
	}

	public static String updateStudent(Student student) {
		String name = Utility.readString("Enter the students name.");
		String surname = Utility.readString("Enter the students last name.");
		student.setFirstName(name);
		student.setLastName(surname);
		return "Student successfully updated. Index: " + student.getId() + ", student: " + student.getFullName();
	}

	public static String deleteStudent(List<Student> students, Student student) {
		students.remove(student);
		return "Student deleted.";
	}
}
