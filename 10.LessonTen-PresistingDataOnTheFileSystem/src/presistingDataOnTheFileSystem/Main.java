package presistingDataOnTheFileSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {	

	private static List<Student> students;
	public static List<Subject> subjects;
	
	static void Initialize() throws IOException{
		subjects = SubjectIO.readSubjects();
		students = StudentIO.readStudents();
	}
	
	public static void main(String[] args) throws IOException {
		Initialize();
		
		int choice = 0;

		do {
			displayTheMenu();
			System.out.println("\nPick an option: ");	
			String choiceString = readInput();
			choice = Integer.parseInt(choiceString);

			switch (choice) {
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
			case 6:
				displaySubjects();
				break;
			case 7: 
				findSubject();
				break;
			case 8:
				createSubject();
				break;
			case 9:
				updateSubject();
				break;
			case 10:
				deleteSubject();
				break;
			case 11: 
				takeExam();
				break;
			case 12:
				deleteExam();
				break;
			case 13:
				findStudentsBasedOnAverage();
				break;
			case 14:
				System.out.println("Goodbye.");
			default:
			}
			StudentIO.saveStudents(students);
			SubjectIO.saveSubjects(subjects);
		} while (choice != 13);
	}
	
	private static void displayTheMenu() {
		System.out.println("===================================");
		System.out.println("1. Display students");
		System.out.println("2. Find student");
		System.out.println("3. Create student");
		System.out.println("4. Update student");
		System.out.println("5. delete student\n");
		System.out.println("6. Display subjects");
		System.out.println("7. Find subject");
		System.out.println("8. Create subject");
		System.out.println("9. Update subject");
		System.out.println("10. Delete subject\n");
		System.out.println("11. Take an exam");
		System.out.println("12. Delete an exam");
		System.out.println("13. Display students who have an average higher than\n");
		System.out.println("14. Exit");
	}
	
	private static String readInput() {
		String input = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			 input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}
	
	private static void displayStudents() {
		System.out.println("Students: ");
		students.forEach(s -> System.out.println(s.getInfo()));
	}
	
	private static void findStudent() {
		Student st = findBasedOnIndex();
		if (st != null) 
			System.out.println(st.getInfo());
		else 
			System.out.println("Student doesn't exist");
	}
	
	private static Student findBasedOnIndex() {
		System.out.print("Enter the index: ");
		String index = readInput(); 
		
		return students.stream().filter(s -> s.getIndex().equals(index)).findFirst().orElse(null);
	}
	
	private static void createStudent() throws IOException {
		System.out.print("Enter the students name: ");
		String name = readInput();
		System.out.print("Enter the students surname: ");
		String surname = readInput();
		System.out.print("Enter the students index: ");
		String index = readInput();
		
		students.add(new Student(index, name, surname));
	}
	
	private static void updateStudent() {
		Student st = findBasedOnIndex();
		if (st != null) {
			System.out.print("Enter the students name: ");
			String name = readInput();
			System.out.print("Enter the students surname: ");
			String surname = readInput();
			System.out.print("Enter the students index: ");
			String index = readInput();
			
			st.setName(name);
			st.setSurname(surname);
			st.setIndex(index);			
		} else {
			System.out.println("Student doesn't exist.");
		}
	}
	
	private static void deleteStudent() {
		Student st = findBasedOnIndex();
		if (st!=null)
			students.remove(st);
	}
	
	private static void displaySubjects() {
		subjects.forEach(s -> System.out.println(s.getInfo()));
	}
	
	private static void findSubject() {
		Subject sub = findSubjectBasedOnIdentifier();
		if (sub != null) 
			System.out.print(sub.getInfo());
		else 
			System.out.println("Subject doesn't exist.");
	}
	
	private static Subject findSubjectBasedOnIdentifier() {
		System.out.print("Enter the id of the subject: ");
		String identifier = readInput(); 
		
		return subjects.stream().filter(s -> s.getIdentifier().equals(identifier)).findFirst().orElse(null);
	}
	
	private static void createSubject() {
		System.out.print("Enter the name of the subject: ");
		String name = readInput();
		System.out.print("Enter the amount of espb points the subject carries: ");
		String espb = readInput();
		
		subjects.add(new Subject(String.valueOf(subjects.size()+1), 
				name, Integer.valueOf(espb)));
	}
	
	private static void updateSubject() {
		Subject sub = findSubjectBasedOnIdentifier();
		if (sub != null) {
			System.out.print("Enter the name of the subject: ");
			String name = readInput();
			System.out.print("Enter the amount of espb points the subject carries: ");
			String espb = readInput();
			
			sub.setName(name);
			sub.setEspb(Integer.valueOf(espb));			
		} else {
			System.out.println("The subject doesn't exist.");
		}
	}
	
	private static void deleteSubject() {
		Subject sub = findSubjectBasedOnIdentifier();
		if (sub != null) {
			subjects.remove(sub);
		}
	}
	
	private static void takeExam() throws IOException {
		Student st = findBasedOnIndex();
		Subject sub = findSubjectBasedOnIdentifier();
		
		if (st != null && sub != null) {
			System.out.println("Enter the grade the student earned.");
			int grade = Integer.parseInt(readInput());
			st.takeExam(new Exam(st.getIndex(), sub, grade));
			ExamIO.saveExams(st.getExams());
		} else {
			System.out.println("Failed");
		}
	}
	
	private static void deleteExam() throws IOException {
		Student st = findBasedOnIndex();
		Subject sub = findSubjectBasedOnIdentifier();
		
		if (st != null && sub != null) {
			st.invalidateExam(sub);
			ExamIO.saveExams(st.getExams());
		}
	}

	private static void findStudentsBasedOnAverage() {
		double average = Double.parseDouble(readInput()); 
		for (Student student : students) {
			if(student.getAverage() > average)
				System.out.println(student.getInfo());
		}
	}
}
