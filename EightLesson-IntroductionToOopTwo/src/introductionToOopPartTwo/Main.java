package introductionToOopPartTwo;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private static List<Student> students;
	private static List<Subject> subjects;

	public static void main(String[] args) {
		students = getStartupStudents();
		subjects = getStartupSubjects();
		
		boolean repeat = true;
		do {
			UtilityMethods.PrintOptions();
			String choice = UtilityMethods.ReadInput();
			repeat = coninueBasedOnInput(choice, repeat);
		} while (repeat);
	}

	private static List<Student> getStartupStudents() {
		List<Student> returnList = new ArrayList<Student>();
		returnList.add(new Student("Jhony", "Weed", 1));
		returnList.add(new Student("Optimus", "Prime", 2));
		returnList.add(new Student("Lara", "Croft", 3));
		returnList.add(new Student("Mory", "Sorry", 4));
		return returnList;
	}
	private static List<Subject> getStartupSubjects() {
		List<Subject> returnList = new ArrayList<Subject>();
		returnList.add(new Subject(SubjectsEnum.Art));
		returnList.add(new Subject(SubjectsEnum.Management));
		returnList.add(new Subject(SubjectsEnum.Math));
		returnList.add(new Subject(SubjectsEnum.History));
		return returnList;
	}

	private static boolean coninueBasedOnInput(String input, boolean repeat) {
		switch (input) {
		case "1":
			displayInformationAboutStudents();
			break;
		case "2":
			int index = askForIndex();
			if(index == 0) break;
			Student st = findAStudentBasedOnIndex(index);
			if (st==null)
				System.out.println("There doesn't exist a student with an index of: " + index);
			else
				st.printInformation();
			break;
		case "3":
			Student newStudent = createStudent();
			students.add(newStudent);
			System.out.println("Student: " + newStudent.getName() + " " + newStudent.getSurname() + " created");
			
			break;
		case "4":
			Student s = findAStudentBasedOnIndex(askForIndex());
			updateStudent(s);
			System.out.println("Student updated.");
			s.printInformation();
			break;
		case "5":
			Student sDel = findAStudentBasedOnIndex(askForIndex());
			students.remove(sDel);
			System.out.println("Student deleted. ");
			break;
		case "6":
			displayInformationAboutSubjects();
			break;
		case "7":
			int id = askForSubjectId();
			Subject sub = findSubjectBasedOnId(id);
			if (sub==null)
				System.out.println("There doesn't exist a subject with an id of: " + id);
			else
				sub.printInformation();
			break;
		case "8":
			Subject newSubject = createSubject();
			subjects.add(newSubject);
			System.out.println("Subject: " + newSubject.getName() + " created");
			
			break;
		case "9":
			Subject updateSub = findSubjectBasedOnId(askForIndex());
			updateSubject(updateSub);
			System.out.println("Subject updated.");
			updateSub.printInformation();
			break;
		case "10":
			Subject subDel = findSubjectBasedOnId(askForIndex());
			subjects.remove(subDel);
			System.out.println("Subject deleted. ");
			break;
		case "11":
			int stindex = askForIndex();
			if(stindex == 0) break;
			Student stu = findAStudentBasedOnIndex(stindex);
			if (stu==null){
				System.out.println("There doesn't exist a student with an index of: " + stindex);
				break;			
			}
			
			int subId = askForSubjectId();
			Subject subj = findSubjectBasedOnId(subId);
			if (subj==null){
				System.out.println("There doesn't exist a subject with an id of: " + subId);
				break;
			}
			
			System.out.println("Enter the grade that student: " + stu.getName() + " has achieved on the exam: " + subj.getName());
			int grade = UtilityMethods.parseInt(UtilityMethods.ReadInput());
			stu.TakeAnExam(subj, grade);
			System.out.println("Finished");
			break;
		case "12":
			return false;
		default:
			break;
		}

		return true;
	}
	
	private static void updateSubject(Subject updateSub) {
		System.out.println("Enter the subject name.");
		String name = UtilityMethods.ReadInput();
		
		System.out.println("Enter the ESPB points that it carries.");
		int espb = UtilityMethods.parseInt(UtilityMethods.ReadInput());
		
		updateSub.setName(name);
		updateSub.setEspb(espb);
	}

	private static Subject createSubject() {
		System.out.println("Enter the subject name.");
		String name = UtilityMethods.ReadInput();
		
		System.out.println("Enter the ESPB points that it carries.");
		int espb = UtilityMethods.parseInt(UtilityMethods.ReadInput());
		
		return new Subject(name, espb);
	}

	private static Subject findSubjectBasedOnId(int id) {
		Subject st = null;
		for (Subject subject : subjects) {
			if(subject.getId() == id)
				st = subject;
		}
		return st;
	}

	private static void displayInformationAboutSubjects() {
		for (Subject sub : subjects) {
			sub.printInformation();
		}
		System.out.println();
	}

	private static void updateStudent(Student s) {
		System.out.println("Enter the students name.");
		String name = UtilityMethods.ReadInput();
		
		System.out.println("Enter the students surname.");
		String surname = UtilityMethods.ReadInput();
		
		System.out.println("Enter the students index.");
		int index = UtilityMethods.parseInt(UtilityMethods.ReadInput());
		
		s.setName(name);
		s.setSurname(surname);
		s.setIndex(index);
	}

	private static Student createStudent() {
		System.out.println("Enter the students name.");
		String name = UtilityMethods.ReadInput();
		
		System.out.println("Enter the students surname.");
		String surname = UtilityMethods.ReadInput();
		
		System.out.println("Enter the students index.");
		int index = UtilityMethods.parseInt(UtilityMethods.ReadInput());
		
		return new Student(name, surname, index);
	}


	private static int askForIndex() {
			System.out.println("Enter the index of the student.");
			String input = UtilityMethods.ReadInput();
			int index = UtilityMethods.parseInt(input);
			return index;
	}
	
	private static int askForSubjectId() {
		System.out.println("Enter the Id of the Subject.");
		String input = UtilityMethods.ReadInput();
		int id = UtilityMethods.parseInt(input);
		return id;
}

	private static Student findAStudentBasedOnIndex(int index) {
		Student st = null;
		for (Student student : students) {
			if(student.getIndex() == index)
				st = student;
		}
		return st;
	}

	private static void displayInformationAboutStudents(){
		for (Student student : students) {
			student.printInformation();
		}
		System.out.println();
	}
}
