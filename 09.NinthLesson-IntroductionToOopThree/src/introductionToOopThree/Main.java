package introductionToOopThree;

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
			Management.displayStudents();
			break;
		case 2:
			Management.findStudent();
			break;
		case 3:
			Management.createStudent();
			break;
		case 4:
			Management.updateStudent();
			break;
		case 5:
			Management.deleteStudent();
			break;
		case 6:
			Management.displaySubjects();
			break;
		case 7:
			Management.findSubject();
			break;
		case 8:
			Management.createSubject();
			break;
		case 9:
			Management.updateSubject();
			break;
		case 10:
			Management.deleteSubject();
			break;
		case 11:
			Management.displayTeachers();
			break;
		case 12:
			Management.findTeacher();
			break;
		case 13:
			Management.createTeacher();
			break;
		case 14:
			Management.UpdateTeacher();
			break;
		case 15:
			Management.deleteTeacher();
			break;
		case 16:
			Management.takeExam();
			break;
		case 17:
			Management.invalidateExam();
			break;
		case 18:
			return false;
		}

		return true;
	}
}
