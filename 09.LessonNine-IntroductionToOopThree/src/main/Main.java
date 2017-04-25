package main;

import util.Utility;
import wrappers.MainWrapper;


public class Main {
	public static void main(String[] args) {
		boolean repeat = true;
		do {
			Utility.displayTheMenu();
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
}
