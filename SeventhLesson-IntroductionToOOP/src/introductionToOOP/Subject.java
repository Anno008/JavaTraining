package introductionToOOP;

public class Subject {
	public SubjectsEnum Name;
	public int ESPB;

	public Subject(SubjectsEnum name) {
		Name = name;
		ESPB = setEspbForSubject(name);
	}

	private int setEspbForSubject(SubjectsEnum name) {
		switch (name) {
		case Math:
			return 10;
		case Art:
			return 9;
		case Economics:
			return 12;
		case Finance:
			return 7;
		case History:
			return 15;
		case Management:
			return 5;
		case Physics:
			return 18;
		case Programming:
			return 8;
		default:
			return 0;
		}
	}
}
