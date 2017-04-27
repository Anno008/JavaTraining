package wrappers;

import java.util.List;
import models.*;
import util.Utility;

public class SubjectWrapper {
	public static void displaySubjects(List<Subject> subjects) {
		subjects.forEach(s -> s.getInfo());
	}

	public static Subject findSubject(List<Subject> subjects) {
		int index = Utility.readInteger("Enter the id of the subject");
		Subject st = subjects.stream().filter(s -> s.getId() == index).findFirst().orElse(null);
		if (st == null)
			System.out.println("A subject with the id of: " + index + " doesn't exist.");

		return st;
	}

	public static Subject createSubject(List<Subject> subjects, List<Teacher> teachers) {
		int index = 1;
		for (int i = 1; i < subjects.size() + 2; i++) {
			final int temp = i;
			boolean exists = subjects.stream().anyMatch(s -> s.getId() == temp);
			if (!exists) {
				index = i;
				break;
			}
		}

		String name = Utility.readString("Enter the name of the subject.");
		int espb = Utility.readInteger("Enter the espb points that the subject carries.");
		Teacher t = TeacherWrapper.findTeacher(teachers);
		Subject newSubject = new Subject(index, name, espb, t);
		System.out.println("Subject successfully added. Index: " + newSubject.getId() + ", subject: " + newSubject.getName() + " with " + newSubject.getEspb() + " espb points. Held by teacher: " + newSubject.getTeacher().getFullName());
		return newSubject;
	}

	public static void updateSubject(Subject subject) {
		String name = Utility.readString("Enter the name of the subject.");
		int espb = Utility.readInteger("Enter the espb points that the subject carries.");
		subject.setName(name);
		subject.setEspb(espb);
		System.out.println("Subject successfully updated. Index: " + subject.getId() + ", subject: " + subject.getName());
	}

	public static void deleteSubject(List<Subject> subjects, Subject subject) {
		subjects.remove(subject);
		System.out.println("Subject deleted.");
	}
}
