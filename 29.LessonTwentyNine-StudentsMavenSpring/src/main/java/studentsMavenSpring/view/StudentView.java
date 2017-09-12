package studentsMavenSpring.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import studentsMavenSpring.model.Student;
import studentsMavenSpring.service.StudentService;
import studentsMavenSpring.utility.Utility;

@Component
public class StudentView {

	@Autowired
	private StudentService studentService;

	public void start() {
		displayMenu();
		int option = Utility.readInteger("Please select an option: ");
		switch (option) {
		case 1:
			displayStudents();
			break;
		case 2:
			findStudent();
			break;
		case 3:
			createStudent();
			break;
		case 4:
			updateStudent();
			break;
		case 5:
			deleteStudent();
			break;
		}
	}

	private void deleteStudent() {
		int id = Utility.readInteger("Enter the id of the student you want to delete: ");
		
		studentService.delete(id);
	}

	private void updateStudent() {
		int id = Utility.readInteger("Enter the id of the student you want to update: ");
		String name = Utility.readString("Enter the students name:");
		String surname = Utility.readString("Enter the students surname:");

		studentService.save(new Student(id, name, surname));
	}

	private void createStudent() {
		int id = Utility.readInteger("Enter the students id:");
		String name = Utility.readString("Enter the students name:");
		String surname = Utility.readString("Enter the students surname:");

		studentService.save(new Student(id, name, surname));
	}

	private void findStudent() {
		int id = Utility.readInteger("Enter the id of the student you want to find: ");
		Student student = studentService.find(id);
		System.out.println(student == null ? "Student with an id of: " + id + " doesn't exist" : student);
	}

	private void displayStudents() {
		for (Student student : studentService.findAll())
			System.out.println(student);
	}

	private void displayMenu() {
		System.out.println("1. Display students");
		System.out.println("2. Find student");
		System.out.println("3. Create student");
		System.out.println("4. Update student");
		System.out.println("5. Delete student\n");
	}
}
