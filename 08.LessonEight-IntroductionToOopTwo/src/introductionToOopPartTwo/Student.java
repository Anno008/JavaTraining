package introductionToOopPartTwo;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
	private String surname;
	private int index;
	private List<Exam> Exams = new ArrayList<Exam>();
	
	public Student(String name, String surname, int index){
		this.name = name;
		this.surname = surname;
		this.index = index;
	}
	
	public void printInformation() {		
		String output = "";
		output += "Name: " + name + ", Surname: " + surname + ", Index: " + index;

		if (Exams.size() > 0) {
			output += "Passed exams:\n";
			for (Exam exam : Exams)
				output += "\tSubject: " + exam.getSubject().getName() + " passed with a grade of " + exam.getGrade() + " which carries " + exam.getSubject().getEspb() + " ESPB\n";
		}

		System.out.println(output);
	}

	public void TakeAnExam(Subject subject, int grade) {
		Exam exam = new Exam(this, subject, grade);
		Exams.add(exam);
	}

	public void updateStudent(Student s) {
		name = s.name;
		surname = s.surname;
		index = s.index;
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

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
