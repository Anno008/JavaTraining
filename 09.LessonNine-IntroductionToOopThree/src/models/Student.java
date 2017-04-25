package models;

import java.util.ArrayList;
import java.util.List;

import base.Person;
import util.Utility;

public class Student extends Person {
	private int index;
	private List<Exam> exams = new ArrayList<Exam>();
	private double average = 0;

	public Student(String firstName, String lastName, int index) {
		super(firstName, lastName);
		this.index = index;
	}

	public void printInfo() {
		String output = "";
		output += Utility.createString('=',140);
		output += "\nStudent: " + getFullName() + " index: " + index ;

		if (exams.size() != 0) {
			output += "\nPassed:\n";
			for (Exam exam : exams)
				output += "\tSubject: " + exam.getSubject().getName() + " which carries: " + exam.getSubject().getEspb()
						+ " espb points, earned a grade: " + exam.getGrade() + " graded by teacher: "
						+ exam.getSubject().getTeacher().getFullName() + "\n";

			average = getAverage();
			output += Utility.createString('-', 140) + "\n";
			output += "\tAverage grade: " + average;
		}
		else
			output += "\n" + Utility.createString('-', 140) + "\n" + "\n\tDoesn't have any passed exams.";
		
		System.out.println(output);
	}

	public double getAverage() {
		double temp = 0;
		for (Exam exam : exams)
			temp += exam.getGrade();

		return temp / exams.size();
	}

	public void takeExam(Exam exam) {
		for (Exam e : exams)
			if (e.getSubject().getName().equals(exam.getSubject().getName())) {
				System.out.println(
						"Student: " + getFullName() + " has already taken the exam: " + exam.getSubject().getName());
				return;
			}

		exams.add(exam);
	}
}
