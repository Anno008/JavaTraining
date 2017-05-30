package models;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private List<Exam> exams = new ArrayList<Exam>();

	public Student(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId(){
		return id;
	}
	
	public String getName(){
		return firstName;
	}
	
	public String getSurname(){
		return lastName;
	}
	@Override
	public String toString() {
		String output = "";
		output += "\nStudent: " + firstName + " " + lastName + " index: " + id;

		if (exams.size() != 0) {
			output += "\nPassed:\n";
			for (Exam exam : exams)
				output += "\tId: " + exam.getId() + ", Subject: " + exam.getSubject().getName() + " which carries: "
						+ exam.getSubject().getEspb() + " espb points, earned a grade: " + exam.getGrade() + "\n";

			double average = getAverage();
			output += "\tAverage grade: " + average;
		} else
			output += "\n" + "\n" + "\n\tDoesn't have any passed exams.";

		return output;
	}

	public void takeExam(Exam exam) {
		exams.add(exam);
	}

	public void invalidateExam(Exam examToInvalidate) {
		exams.remove(examToInvalidate);
	}

	public double getAverage() {
		double temp = 0;
		for (Exam exam : exams)
			temp += exam.getGrade();

		return temp / exams.size();
	}

	public List<Exam> getExams() {
		return exams;
	}
}
