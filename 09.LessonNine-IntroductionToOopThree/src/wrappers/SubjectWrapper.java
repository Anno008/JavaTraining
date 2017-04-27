package wrappers;

import java.util.List;
import models.*;
import util.ObjectDecorator;
import util.Utility;

public class SubjectWrapper {
	public static String displaySubjects(List<Subject> subjects) {
		String output = "";
		for (Subject subject : subjects) 
			output += subject.getInfo() + "\n";
		
		return output;
	}

	public static ObjectDecorator<Subject> findSubject(List<Subject> subjects) {
		String output = "";
		int index = Utility.readInteger("Enter the id of the subject");
		Subject st = subjects.stream().filter(s -> s.getId() == index).findFirst().orElse(null);
		if (st == null)
			output += "A subject with the id of: " + index + " doesn't exist.\n";

		return new ObjectDecorator<Subject>(st, output);
	}

	public static ObjectDecorator<Subject> createSubject(List<Subject> subjects, List<Teacher> teachers) {
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
		ObjectDecorator<Teacher> t = TeacherWrapper.findTeacher(teachers);
		Subject newSubject = new Subject(index, name, espb, t.getObj());
		return new ObjectDecorator<Subject>(newSubject,
				"Subject successfully added. Index: " + newSubject.getId() + ", subject: " + newSubject.getName()
						+ " with " + newSubject.getEspb() + " espb points. Held by teacher: "
						+ newSubject.getTeacher().getFullName());
	}

	public static String updateSubject(Subject subject) {
		String name = Utility.readString("Enter the name of the subject.");
		int espb = Utility.readInteger("Enter the espb points that the subject carries.");
		subject.setName(name);
		subject.setEspb(espb);
		return "Subject successfully updated. Index: " + subject.getId() + ", subject: " + subject.getName();
	}

	public static String deleteSubject(List<Subject> subjects, Subject subject) {
		subjects.remove(subject);
		return "Subject deleted.";
	}
}
