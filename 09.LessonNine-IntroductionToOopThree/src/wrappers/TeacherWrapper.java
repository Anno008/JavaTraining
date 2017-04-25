package wrappers;

import java.util.List;

import models.Teacher;
import util.Utility;

public class TeacherWrapper {
	public static void displayTeachers(List<Teacher> teachers) {
		teachers.forEach(s -> s.printInfo());
	}

	public static Teacher findTeacher(List<Teacher> teachers) {
		int index = Utility.readInteger("Enter the index of the teacher.");
		Teacher t = teachers.stream().filter(s -> s.getId() == index).findFirst().orElse(null);
		if (t == null)
			System.out.println("A subject with the id of: " + index + " doesn't exist.");

		return t;
	}

	public static Teacher createTeacher(List<Teacher> teachers) {
		int index = 1;
		for (int i = 1; i < teachers.size() + 2; i++) {
			final int temp = i;
			boolean exists = teachers.stream().anyMatch(s -> s.getId() == temp);
			if (!exists) {
				index = i;
				break;
			}
		}

		String name = Utility.readString("Enter the teachers name.");
		String surname = Utility.readString("Enter the teachers last name.");
		Teacher newTeacher = new Teacher(index, name, surname);
		System.out.println("Teacher successfully added. Index: " + newTeacher.getId() + ", teacher: " + newTeacher.getFullName());
		return newTeacher;
	}

	public static void updateTeacher(Teacher teacher) {
		String name = Utility.readString("Enter the name of the teacher.");
		String surname = Utility.readString("Enter the teachers last name.");
		teacher.setFirstName(name);
		teacher.setLastName(surname);
		System.out.println("Teacher successfully updated. Id: " + teacher.getId() + ", teacher: " + teacher.getFullName());
	}

	public static void deleteTeacher(List<Teacher> teachers, Teacher teacher) {
		teachers.remove(teacher);
		System.out.println("Teacher deleted.");
	}
}
