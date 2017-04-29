package presistingDataOnTheFileSystem;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Student {
	private String name;
	private String surname;
	private String index;
	private List<Exam> exams;

	
	public Student(String index, String name, String surname) throws IOException {
		this.name = name;
		this.surname = surname;
		this.index = index;
		exams = ExamIO.readExams(index).stream().distinct().collect(Collectors.toList());
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

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}
	
	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
	
	public void takeExam(Exam ispit) throws IOException {
		for (Exam exam : exams) 
			if(exam.getSubject().getIdentifier().equals(ispit.getSubject().getIdentifier())){
				System.out.println("Student already passed subject: " + ispit.getSubject().getName());
				return;
			}
		
		exams.add(ispit);
	}

	public double getAverage(){
		double sum = 0;
		for (int i = 0; i < exams.size(); i++) {
			sum += exams.get(i).getGrade();
		}
		return sum/exams.size();
	}
	
	void invalidateExam(Subject subject) throws IOException {
		Exam exam = exams.stream().filter(e -> e.getSubject().getIdentifier() == subject.getIdentifier()).findFirst().orElse(null);
		if(exam != null){
			exams.remove(exam);
		}
	}

	String getInfo() {
		String output = index + " " + name + " " + surname + 
				" average: " + getAverage() + ". Passed: ";
		for (int i = 0; i < exams.size(); i++) {
			output += " \n\t\t"+exams.get(i).getSubject().getName() + ":" + exams.get(i).getGrade();
		}
		return output;
	}	
}

