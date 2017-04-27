package models;

import java.util.ArrayList;
import java.util.List;

import base.Person;
import util.Utility;

public class Student extends Person {
	private List<Exam> exams = new ArrayList<Exam>();

	public Student(int id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}

	public String getInfo() {
		String output = "";
		output += Utility.createString('=',140);
		output += "\nStudent: " + getFullName() + " index: " + getId() ;

		if (exams.size() != 0) {
			output += "\nPassed:\n";
			for (Exam exam : exams)
				output += "\tId: " + exam.getIndex() + ", Subject: " + exam.getSubject().getName() + " which carries: " + exam.getSubject().getEspb()
						+ " espb points, earned a grade: " + exam.getGrade() + " graded by teacher: "
						+ exam.getSubject().getTeacher().getFullName() + "\n";

			double average = getAverage();
			output += Utility.createString('-', 140) + "\n";
			output += "\tAverage grade: " + average;
		}
		else
			output += "\n" + Utility.createString('-', 140) + "\n" + "\n\tDoesn't have any passed exams.";
		
		return output;
	}

	public double getAverage() {
		double temp = 0;
		for (Exam exam : exams)
			temp += exam.getGrade();

		return temp / exams.size();
	}

	public String takeExam(Exam exam) {
		String output = "";
		for (Exam e : exams)
			if (e.getSubject().getName().equals(exam.getSubject().getName())) {
				output += "Student: " + getFullName() + " has already taken the exam: " + exam.getSubject().getName() + "\n";
				return output;
			}

		exams.add(exam);
		return output;
	}
	
	public String invalidateExam(Exam examToInvalidate) {
			exams.remove(examToInvalidate);
			return "invalidated exam of subject: " + examToInvalidate.getSubject().getName() + " from student: " + getFullName();
	}
	
	public int getId(){
		return super.getId();
	}
	
	public List<Exam> getExams(){
		return exams;
	}
}
