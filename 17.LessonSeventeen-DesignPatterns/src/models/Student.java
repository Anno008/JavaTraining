package models;

import java.util.ArrayList;

public class Student {
	private int index;
	private String name;
	private String surname;
	private ArrayList<Exam> exams = new ArrayList<Exam>();

	public Student(int index, String name, String surname) {
		this.index = index;
		this.name = name;
		this.surname = surname;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public ArrayList<Exam> getExams() {
		return exams;
	}

	public void setExams(ArrayList<Exam> exams) {
		this.exams = exams;
	}
	
	public void addExam(Exam exam){
		exams.add(exam);
	}
	
	@Override
	public String toString(){
		String output = "Index: " + index + ", name: " + name + ", surname: " + surname + (exams.size() > 0 ? ", average grade: " + exams.stream().mapToInt(e -> e.getGrade()).sum() : "");
		for (Exam exam : exams) 
			output += "\tExam: " + exam.getSubject().getName() + ", passed with a grade of: " + exam.getGrade();
		
		return output;	
	}
}
