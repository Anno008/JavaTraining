package wrappers;

import java.util.ArrayList;
import java.util.List;

import models.*;

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
		System.out.println(jack.takeExam(new Exam(1, jack, math, 5)));
		Student jason = new Student(2, "Jason", "Momoa");

		Student emma = new Student(3, "Emma", "Watson");
		System.out.println(emma.takeExam(new Exam(2, emma, defenseAgainstTheDarkArts, 7)));
		System.out.println(emma.takeExam(new Exam(3, emma, whichcraft, 10)));

		students.add(jack);
		students.add(jason);
		students.add(emma);
	}

	public static void displayStudents() {
		StudentWrapper.displayStudents(students);
	}

	public static void findStudent() {
		Student st = StudentWrapper.findStudent(students);
		if (st != null)
			System.out.println(st.getInfo());
	}

	public static void createStudent() {
		students.add(StudentWrapper.createStudent(students));
	}

	public static void updateStudent() {
		Student st = StudentWrapper.findStudent(students);
		if (st != null)
			StudentWrapper.updateStudent(st);
	}

	public static void deleteStudent() {
		Student st = StudentWrapper.findStudent(students);
		if (st != null)
			StudentWrapper.deleteStudent(students, st);
	}

	public static void displaySubjects() {
		SubjectWrapper.displaySubjects(subjects);
	}

	public static void findSubject() {
		Subject subj = SubjectWrapper.findSubject(subjects);
		if (subj != null)
			subj.getInfo();
	}

	public static void createSubject() {
		subjects.add(SubjectWrapper.createSubject(subjects, teachers));
	}

	public static void updateSubject() {
		Subject subj = SubjectWrapper.findSubject(subjects);
		if (subj != null)
			SubjectWrapper.updateSubject(subj);
	}

	public static void deleteSubject() {
		Subject subj = SubjectWrapper.findSubject(subjects);
		if (subj != null)
			SubjectWrapper.deleteSubject(subjects, subj);
	}

	public static void displayTeachers() {
		TeacherWrapper.displayTeachers(teachers);
	}

	public static void findTeacher() {
		Teacher t = TeacherWrapper.findTeacher(teachers);
		if (t != TeacherWrapper.findTeacher(teachers))
			System.out.println(t.getInfo());
	}

	public static void createTeacher() {
		teachers.add(TeacherWrapper.createTeacher(teachers));
	}

	public static void UpdateTeacher() {
		Teacher t = TeacherWrapper.findTeacher(teachers);
		if (t != null)
			TeacherWrapper.updateTeacher(t);
	}

	public static void deleteTeacher() {
		Teacher t = TeacherWrapper.findTeacher(teachers);
		if (t != null)
			TeacherWrapper.deleteTeacher(teachers, t);
	}

	public static void takeExam() {
		ExamWrapper.takeExam(students, subjects);
	}

	public static void invalidateExam() {
		ExamWrapper.invalidateExam(students, subjects);
	}
}
