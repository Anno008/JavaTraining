package main;

import util.Utility;
import wrappers.MainWrapper;


public class Main {
	public static void main(String[] args) {
		boolean repeat = true;
		do {
			displayTheMenu();
			int option = Utility.readInteger("");
			repeat = makeDecision(option, repeat);
		} while (repeat);
	}

	private static boolean makeDecision(int option, boolean repeat) {
		switch (option) {
		case 1:
			MainWrapper.displayStudents();
			break;
		case 2:
			MainWrapper.findStudent();
			break;
		case 3:
			MainWrapper.createStudent();
			break;
		case 4:
			MainWrapper.updateStudent();
			break;
		case 5:
			MainWrapper.deleteStudent();
			break;
		case 6:
			MainWrapper.displaySubjects();
			break;
		case 7:
			MainWrapper.findSubject();
			break;
		case 8:
			MainWrapper.createSubject();
			break;
		case 9:
			MainWrapper.updateSubject();
			break;
		case 10:
			MainWrapper.deleteSubject();
			break;
		case 11:
			MainWrapper.displayTeachers();
			break;
		case 12:
			MainWrapper.findTeacher();
			break;
		case 13:
			MainWrapper.createTeacher();
			break;
		case 14:
			MainWrapper.UpdateTeacher();
			break;
		case 15:
			MainWrapper.deleteTeacher();
			break;
		case 16:
			MainWrapper.takeExam();
			break;
		case 17:
			MainWrapper.invalidateExam();
			break;
		case 18:
			return false;
		}

		return true;
	}
	
	private static void displayTheMenu() {
		System.out.println(Utility.createString('=', 140));
		System.out.println("1. Display students");
		System.out.println("2. Find a student");
		System.out.println("3. Create a student");
		System.out.println("4. Update a student");
		System.out.println("5. Delete a student\n");
		System.out.println("6. Display subjects");
		System.out.println("7. Find a subject");
		System.out.println("8. Create a subject");
		System.out.println("9. Update a subject");
		System.out.println("10. Delete a subject\n");
		System.out.println("11. Display teachers");
		System.out.println("12. Find a teacher");
		System.out.println("13. Create a teacher");
		System.out.println("14. Update a teacher");
		System.out.println("15. Delete a teacher\n");
		System.out.println("16. Take an exam");
		System.out.println("17. Invalidate an exam\n");
		System.out.println("18. Exit");
	}
}
