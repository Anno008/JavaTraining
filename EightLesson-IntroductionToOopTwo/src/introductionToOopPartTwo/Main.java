package introductionToOopPartTwo;

public class Main {

	public static void main(String[] args) {

		boolean repeat = true;
		do {
			UtilityMethods.PrintOptions();
			String choice = UtilityMethods.ReadInput();
			repeat = coninueBasedOnInput(choice, repeat);
		} while (repeat);
	}

	private static boolean coninueBasedOnInput(String input, boolean repeat) {
		switch (input) {
		case "1":
			Management.displayInformationAboutStudents();
			break;
		case "2":
			Management.findStudent();
			break;
		case "3":
			Management.addStudent();
			break;
		case "4":
			Management.updateStudent();
			break;
		case "5":
			Management.deleteStudent();
			break;
		case "6":
			Management.displayInformationAboutSubjects();
			break;
		case "7":
			Management.displayInformationAboutSubjects();
			break;
		case "8":
			Management.findSubject();
			break;
		case "9":
			Management.updateSubject();
			break;
		case "10":
			Management.deleteSubject();
			break;
		case "11":
			Management.takeAnExam();
			break;
		case "12":
			return false;
		default:
			break;
		}
		return true;
	}
}
