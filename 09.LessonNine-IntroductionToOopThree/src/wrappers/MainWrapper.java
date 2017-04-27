package wrappers;

import java.util.ArrayList;
import java.util.List;

import models.*;
import util.ObjectDecorator;

public class MainWrapper {
	static {
		initializeStarupData();
	}
	public static List<Student> students;
	public static List<Subject> subjects;
	public static List<Teacher> teachers;

	private static void initializeStarupData() {
		students = new ArrayList<Student>();
		subjects = new ArrayList<Subject>();
		teachers = new ArrayList<Teacher>();

		Teacher merlin = new Teacher(1, "Merlin", "Ambrosius");
		teachers.add(merlin);
		Subject whichcraft = new Subject(1, "Which craft", 20, merlin);
		subjects.add(whichcraft);

		Teacher snape = new Teacher(2, "Snape", "Severus");
		teachers.add(snape);
		Subject defenseAgainstTheDarkArts = new Subject(2, "Defense against the dark arts", 30, snape);
		subjects.add(defenseAgainstTheDarkArts);

		Teacher sergei = new Teacher(3, "Sergei", "Adian");
		teachers.add(sergei);

		Subject math = new Subject(3, "Mathematics", 25, sergei);
		subjects.add(math);

		Student jack = new Student(1, "Jack", "Sparrow");
		jack.takeExam(new Exam(1, jack, math, 5));
		Student jason = new Student(2, "Jason", "Momoa");

		Student emma = new Student(3, "Emma", "Watson");
		emma.takeExam(new Exam(2, emma, defenseAgainstTheDarkArts, 7));
		emma.takeExam(new Exam(3, emma, whichcraft, 10));

		students.add(jack);
		students.add(jason);
		students.add(emma);
	}

	public static void displayStudents() {
		System.out.println(StudentWrapper.displayStudents(students));
	}

	public static void findStudent() {
		ObjectDecorator<Student> result = StudentWrapper.findStudent(students);
		if (result.getObj() != null)
			System.out.println(result.getObj().getInfo());
		else
			System.out.println(result.getOutput());
	}

	public static void createStudent() {
		ObjectDecorator<Student> result = StudentWrapper.createStudent(students);
		students.add(result.getObj());
		System.out.println(result.getOutput());
	}

	public static void updateStudent() {
		ObjectDecorator<Student> result = StudentWrapper.findStudent(students);
		if (result.getObj() != null)
			System.out.println(StudentWrapper.updateStudent(result.getObj()));
		else
			System.out.println(result.getOutput());
	}

	public static void deleteStudent() {
		ObjectDecorator<Student> result = StudentWrapper.findStudent(students);
		if (result.getObj() != null)
			System.out.println(StudentWrapper.deleteStudent(students, result.getObj()));
	}

	public static void displaySubjects() {
		System.out.println(SubjectWrapper.displaySubjects(subjects));
	}

	public static void findSubject() {
		ObjectDecorator<Subject> result = SubjectWrapper.findSubject(subjects);
		if (result.getObj() != null)
			System.out.println(result.getObj().getInfo());
		else
			System.out.println(result.getOutput());
	}

	public static void createSubject() {
		ObjectDecorator<Subject> result = SubjectWrapper.createSubject(subjects, teachers);
		subjects.add(result.getObj());
		System.out.println(result.getOutput());
	}

	public static void updateSubject() {
		ObjectDecorator<Subject> result = SubjectWrapper.findSubject(subjects);
		if (result.getObj() != null)
			System.out.println(SubjectWrapper.updateSubject(result.getObj()));
		else
			System.out.println(result.getOutput());
	}

	public static void deleteSubject() {
		ObjectDecorator<Subject> result = SubjectWrapper.findSubject(subjects);
		if (result.getObj() != null)
			System.out.println(SubjectWrapper.deleteSubject(subjects, result.getObj()));
		else
			System.out.println(result.getOutput());
	}

	public static void displayTeachers() {
		System.out.println(TeacherWrapper.displayTeachers(teachers));
	}

	public static void findTeacher() {
		ObjectDecorator<Teacher> result = TeacherWrapper.findTeacher(teachers);
		if (result.getObj() != null)
			System.out.println(result.getObj().getInfo());
		else
			System.out.println(result.getOutput());
	}

	public static void createTeacher() {
		ObjectDecorator<Teacher> result = TeacherWrapper.createTeacher(teachers);
		teachers.add(result.getObj());
		System.out.println(result.getOutput());
	}

	public static void UpdateTeacher() {
		ObjectDecorator<Teacher> result = TeacherWrapper.findTeacher(teachers);
		if (result.getObj() != null)
			System.out.println(TeacherWrapper.updateTeacher(result.getObj()));
		else
			System.out.println(result.getOutput());
	}

	public static void deleteTeacher() {
		ObjectDecorator<Teacher> result = TeacherWrapper.findTeacher(teachers);
		if (result.getObj() != null)
			System.out.println(TeacherWrapper.deleteTeacher(teachers, result.getObj()));
		else
			System.out.println(result.getOutput());
	}

	public static void takeExam() {
		System.out.println(ExamWrapper.takeExam(students, subjects));
	}

	public static void invalidateExam() {
		System.out.println(ExamWrapper.invalidateExam(students, subjects));
	}
}
