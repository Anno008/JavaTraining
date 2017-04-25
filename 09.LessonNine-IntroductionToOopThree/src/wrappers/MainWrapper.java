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
		
		Teacher merlin = new Teacher("Merlin", "Ambrosius", 1);
		Subject whichcraft = new Subject(1,"Which craft", 20, merlin);
		subjects.add(whichcraft);
		
		Teacher snape = new Teacher("Snape","Severus",2);
		Subject defenseAgainstTheDarkArts = new Subject(2,"Defense against the dark arts", 30, snape);
		subjects.add(defenseAgainstTheDarkArts);
		
		Teacher sergei = new Teacher("Sergei","Adian",3);
		Subject math = new Subject(3,"Mathematics",25,sergei);
		subjects.add(math);

		Student jack = new Student("Jack", "Sparrow", 1);
		jack.takeExam(new Exam(jack,math,5));
		Student jason = new Student("Jason", "Momoa", 2);
		
		Student emma = new Student("Emma", "Watson", 3);
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
		// TODO Auto-generated method stub
		
	}

	public static void findTeacher() {
		// TODO Auto-generated method stub
		
	}

	public static void createTeacher() {
		// TODO Auto-generated method stub
		
	}

	public static void UpdateTeacher() {
		// TODO Auto-generated method stub
		
	}

	public static void deleteTeacher() {
		// TODO Auto-generated method stub
		
	}

	public static void takeExam() {
		// TODO Auto-generated method stub
		
	}

	public static void invalidateExam() {
		// TODO Auto-generated method stub
		
	}
}
