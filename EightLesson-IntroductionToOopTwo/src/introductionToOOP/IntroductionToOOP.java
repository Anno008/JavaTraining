package introductionToOOP;

import java.util.ArrayList;
import java.util.List;

public class IntroductionToOOP {

	private static List<Student> students;

	public static void main(String[] args) {
		students = GetStartupStudents();
		boolean repeat = true;
		do {
			UtilityMethods.PrintOptions();
			String choice = UtilityMethods.ReadInput();
			repeat = coninueBasedOnInput(choice, repeat);
		} while (repeat);
	}

	private static List<Student> GetStartupStudents() {
		List<Student> returnList = new ArrayList<Student>();
		returnList.add(new Student("Jhony", "Weed", 1));
		returnList.add(new Student("Optimus", "Prime", 2));
		returnList.add(new Student("Lara", "Croft", 3));
		returnList.add(new Student("Mory", "Sorry", 4));
		return returnList;
	}

	private static boolean coninueBasedOnInput(String input, boolean repeat) {
		switch (input) {
		case "1":
			displayInformationAboutStudents();
			break;
		case "2":
			
			int index = askForIndex();
			if(index == 0) return true;
			Student st = findAStudentBasedOnIndex(index);
			if (st==null)
				System.out.println("There doesn't exist a student with an index of: " + index);
			else
				st.printInformation();
			break;
		case "3":
			Student newStudent = createStudent();
			
			break;
		case "4":

			break;
		case "5":

			break;
		case "6":
			return false;
		default:
			break;
		}

		return true;
	}
	
	private static Student createStudent() {
		System.out.println();
		System.out.println("Enter the students name.");
		String name = UtilityMethods.ReadInput();
		
		return null;
	}

	private static int askForIndex() {
			System.out.println("Enter the index of the student you want information on.");
			String input = UtilityMethods.ReadInput();
			int index = UtilityMethods.parseInt(input);
			return index;
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
