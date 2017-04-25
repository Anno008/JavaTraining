package wrappers;

import java.util.List;

import models.Student;
import util.Utility;

public class StudentWrapper {
	public static void displayStudents(List<Student> students) {
		students.forEach(s -> s.printInfo());
	}

	public static Student findStudent(List<Student> students) {
		int index = Utility.readInteger("Enter the index of the student");
		Student st = students.stream().filter(s -> s.getId() == index).findFirst().orElse(null);
		if (st == null)
			System.out.println("A student with the index of: " + index + " doesn't exist.");

		return st;
	}

	public static Student createStudent(List<Student> students) {
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
		System.out.println("Student successfully added. Index: " + newStudent.getId() + ", student: "
				+ newStudent.getFullName());
		return newStudent;
	}

	public static void updateStudent(Student student) {
		String name = Utility.readString("Enter the students name.");
		String surname = Utility.readString("Enter the students last name.");
		student.setFirstName(name);
		student.setLastName(surname);
		System.out.println("Student successfully updated. Index: " + student.getId() + ", student: " + student.getFullName());
	}

	public static void deleteStudent(List<Student> students, Student student) {
		students.remove(student);
		System.out.println("Student deleted.");
	}
}
