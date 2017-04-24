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

	public static void initializeStudents() {
		
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
	}

	public static void displayStudentsInformation() {
		//initializeStudents();
		students.forEach(s -> s.printInfo());
	}
}
