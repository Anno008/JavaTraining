package wrappers;

import java.util.ArrayList;
import java.util.List;

import models.*;

public class MainWrapper {
	static{
		students = new ArrayList<Student>();
		subjects = new ArrayList<Subject>();
		teachers = new ArrayList<Teacher>();
		initializeStudents();
	}
	public static List<Student> students;
	public static List<Subject> subjects;
	public static List<Teacher> teachers;

	private static void initializeStudents() {
		
		Teacher merlin = new Teacher(1, "Merlin", "Ambrosius");
		Subject whichcraft = new Subject(1,"Which craft", 20, merlin);
		subjects.add(whichcraft);
		
		Teacher snape = new Teacher(2, "Snape","Severus");
		Subject defenseAgainstTheDarkArts = new Subject(2,"Defense against the dark arts", 30, snape);
		subjects.add(defenseAgainstTheDarkArts);
		
		Teacher sergei = new Teacher(3, "Sergei","Adian");
		Subject math = new Subject(3,"Mathematics",25,sergei);
		subjects.add(math);

		Student jack = new Student(1, "Jack", "Sparrow");
		jack.takeExam(new Exam(jack,math,5));
		Student jason = new Student(2, "Jason", "Momoa");
		
		Student emma = new Student(3, "Emma", "Watson");
		emma.takeExam(new Exam(emma,defenseAgainstTheDarkArts,7));
		emma.takeExam(new Exam(emma,whichcraft,10));
		
		students.add(jack);
		students.add(jason);
		students.add(emma);
	}

	
	
	public static void displayStudents() {
		StudentWrapper.displayStudents(students);
	}

	public static void findStudent() {
		Student st = StudentWrapper.findStudent(students);
		if(st != null)
			st.printInfo();
	}

	public static void createStudent() {
		students.add(StudentWrapper.createStudent(students));
	}

	public static void updateStudent() {
		Student st = StudentWrapper.findStudent(students);
		if(st != null)
			StudentWrapper.updateStudent(st);
	}

	public static void deleteStudent() {
		Student st = StudentWrapper.findStudent(students);
		if(st != null)
			StudentWrapper.deleteStudent(students, st);
	}

	public static void displaySubjects() {
		SubjectWrapper.displaySubjects(subjects);
	}

	public static void findSubject() {
		Subject subj = SubjectWrapper.findSubject(subjects);
		if(subj != null)
			subj.printInfo();
	}

	public static void createSubject() {
		subjects.add(SubjectWrapper.createSubject(subjects));
	}

	public static void updateSubject() {
		Subject subj = SubjectWrapper.findSubject(subjects);
		if(subj != null)
			SubjectWrapper.updateSubject(subj);
	}

	public static void deleteSubject() {
		Subject subj = SubjectWrapper.findSubject(subjects);
		if(subj != null)
			SubjectWrapper.deleteSubject(subjects, subj);
	}

	public static void displayTeachers() {
		TeacherWrapper.displayTeachers(teachers);
	}

	public static void findTeacher() {
		Teacher t = TeacherWrapper.findTeacher(teachers);
		if(t != null)
			t.printInfo();
	}

	public static void createTeacher() {
		teachers.add(TeacherWrapper.createTeacher(teachers));
		
	}

	public static void UpdateTeacher() {
		Teacher t = TeacherWrapper.findTeacher(teachers);
		if(t != null)
			TeacherWrapper.updateTeacher(t);
	}

	public static void deleteTeacher() {
		Teacher t = TeacherWrapper.findTeacher(teachers);
		if(t != null)
			TeacherWrapper.deleteTeacher(teachers, t);
	}

	public static void takeExam() {
		// TODO Auto-generated method stub
		
	}

	public static void invalidateExam() {
		// TODO Auto-generated method stub
		
	}
}
