package wrappers;

import java.util.List;

import models.Teacher;
import util.*;

public class TeacherWrapper {
	public static String displayTeachers(List<Teacher> teachers) {
		String output = "";
		for (Teacher teacher : teachers) {
			output += teacher.getInfo() + "\n";
		}
		
		return output;
	}

	public static ObjectDecorator<Teacher> findTeacher(List<Teacher> teachers) {
		int index = Utility.readInteger("Enter the index of the teacher.");
		Teacher t = teachers.stream().filter(s -> s.getId() == index).findFirst().orElse(null);
		
		String output = "";
		if (t == null)
			output += "Teacher with the id of: " + index + " doesn't exist.";

		return new ObjectDecorator<Teacher>(t, output);
	}

	public static ObjectDecorator<Teacher> createTeacher(List<Teacher> teachers) {
		int index = 1;
		for (int i = 1; i < teachers.size() + 2; i++) {
			final int temp = i;
			boolean exists = teachers.stream().anyMatch(s -> s.getId() == temp);
			if (!exists) {
				index = i;
				break;
			}
		}

		String output = "";
		String name = Utility.readString("Enter the teachers name.");
		String surname = Utility.readString("Enter the teachers last name.");
		Teacher newTeacher = new Teacher(index, name, surname);
		output += "Teacher successfully added. Index: " + newTeacher.getId() + ", teacher: " + newTeacher.getFullName();
		return new ObjectDecorator<Teacher>(newTeacher, output);
	}

	public static String updateTeacher(Teacher teacher) {
		String name = Utility.readString("Enter the name of the teacher.");
		String surname = Utility.readString("Enter the teachers last name.");
		teacher.setFirstName(name);
		teacher.setLastName(surname);
		return "Teacher successfully updated. Id: " + teacher.getId() + ", teacher: " + teacher.getFullName();
	}

	public static String deleteTeacher(List<Teacher> teachers, Teacher teacher) {
		teachers.remove(teacher);
		return "Teacher deleted.";
	}
}
