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
		Subject whichcraft = new Subject("Which craft", 20, merlin);
		
		Teacher snape = new Teacher("Snape","Severus",2);
		Subject defenseAgainstTheDarkArts = new Subject("Defense against the dark arts", 30, snape);
		
		Teacher sergei = new Teacher("Sergei","Adian",3);
		Subject math = new Subject("Mathematics",25,sergei);

		Student jack = new Student("Jack", "Sparrow", 1);
		jack.takeExam(new Exam(jack,math,5));
		Student jason = new Student("Jason", "Momoa", 2);
		
		Student emma = new Student("Emma", "Watson", 3);
		emma.takeExam(new Exam(emma,defenseAgainstTheDarkArts,7));
		emma.takeExam(new Exam(emma,whichcraft,10));
		
		students.add(jack);
		students.add(jason);
		students.add(emma);
		students.add(new Student("Harry","Joe",4));
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
		Student student = StudentWrapper.createStudent(students);
		students.add(student);
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
		// TODO Auto-generated method stub
		
	}

	public static void findSubject() {
		// TODO Auto-generated method stub
		
	}

	public static void createSubject() {
		// TODO Auto-generated method stub
		
	}

	public static void updateSubject() {
		// TODO Auto-generated method stub
		
	}

	public static void deleteSubject() {
		// TODO Auto-generated method stub
		
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
