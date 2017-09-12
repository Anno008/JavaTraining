package studentsMavenSpring.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import studentsMavenSpring.utility.Utility;

@Component
public class MainView {

	@Autowired
	private StudentView studentView;

	@Autowired
	private SubjectView subjectView;

	@Autowired
	private ExamView examView;

	public void start() {
		int option = 0;

		do {
			displayMenu();
			option = Utility.readInteger("Please choose your desierd option.");
			switch (option) {
			case 1:
				studentView.start();
				break;
			case 2:
				subjectView.start();
				break;
			case 3:
				examView.start();
				break;
			}
		} while (option != 4);
	}

	private void displayMenu() {
		System.out.println("1. Students");
		System.out.println("2. Subjects");
		System.out.println("3. Exams");
		System.out.println("4. Exit");
	}
}
