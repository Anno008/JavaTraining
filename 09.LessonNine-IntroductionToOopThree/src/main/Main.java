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
			MainWrapper.filterStudentsBasedOnAverageGrade();
			break;
		case 7:
			MainWrapper.displaySubjects();
			break;
		case 8:
			MainWrapper.findSubject();
			break;
		case 9:
			MainWrapper.createSubject();
			break;
		case 10:
			MainWrapper.updateSubject();
			break;
		case 11:
			MainWrapper.deleteSubject();
			break;
		case 12:
			MainWrapper.displayTeachers();
			break;
		case 13:
			MainWrapper.findTeacher();
			break;
		case 14:
			MainWrapper.createTeacher();
			break;
		case 15:
			MainWrapper.UpdateTeacher();
			break;
		case 16:
			MainWrapper.deleteTeacher();
			break;
		case 17:
			MainWrapper.takeExam();
			break;
		case 18:
			MainWrapper.invalidateExam();
			break;
		case 19:
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
		System.out.println("5. Delete a student");
		System.out.println("6. Get all student with average grade higher than specified\n");
		System.out.println("7. Display subjects");
		System.out.println("8. Find a subject");
		System.out.println("9. Create a subject");
		System.out.println("10. Update a subject");
		System.out.println("11. Delete a subject\n");
		System.out.println("12. Display teachers");
		System.out.println("13. Find a teacher");
		System.out.println("14. Create a teacher");
		System.out.println("15. Update a teacher");
		System.out.println("16. Delete a teacher\n");
		System.out.println("17. Take an exam");
		System.out.println("18. Invalidate an exam\n");
		System.out.println("19. Exit");
	}
}
