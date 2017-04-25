package wrappers;

import java.util.List;

import models.Student;

public class StudentWrapper {
	public static void displayStudents(List<Student> students){
		students.forEach(s -> s.printInfo());
	}
	
	public static void findStudent(){
		
	}
	
	public static Student createStudent(){
		return null;
		
	}
	
	public static void updateStudent(Student student){
		
	}
	
	public static void deleteStudent(Student student){
		
	}
}
